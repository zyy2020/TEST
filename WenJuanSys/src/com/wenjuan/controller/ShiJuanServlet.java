package com.wenjuan.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wenjuan.bean.Ask;
import com.wenjuan.bean.SJAsk;
import com.wenjuan.bean.SJTK;
import com.wenjuan.bean.SJXZ;
import com.wenjuan.bean.ShiJuan;
import com.wenjuan.bean.TKDTK;
import com.wenjuan.bean.TianKong;
import com.wenjuan.bean.User;
import com.wenjuan.bean.XZDTK;
import com.wenjuan.bean.XuanZe;
import com.wenjuan.service.ADTKService;
import com.wenjuan.service.SJAService;
import com.wenjuan.service.SJTKService;
import com.wenjuan.service.SJXZService;
import com.wenjuan.service.ShiJuanService;
import com.wenjuan.service.TKDTKService;
import com.wenjuan.service.XZDTKService;
import com.wenjuan.service.impl.ADTKServiceImpl;
import com.wenjuan.service.impl.SJAServiceImpl;
import com.wenjuan.service.impl.SJTKServiceImpl;
import com.wenjuan.service.impl.SJXZServiceImpl;
import com.wenjuan.service.impl.ShiJuanServiceImpl;
import com.wenjuan.service.impl.TKDTKDaoServiceImpl;
import com.wenjuan.service.impl.XZDTKDaoServiceImpl;
import com.wenjuan.utils.JdbcUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@WebServlet("/shiJuanServlet")
public class ShiJuanServlet extends HttpServlet {

	private ShiJuanService shiJuanService = new ShiJuanServiceImpl();
	private SJXZService sJXZService = new SJXZServiceImpl();
	private SJTKService sJTKService = new SJTKServiceImpl();
	private SJAService sJAService = new SJAServiceImpl();
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		//
		String op = request.getParameter("op");
		switch (op) {
		case "initial":
			// 生成试卷用事务

			try {

				initialize(request, out);
			} catch (ParseException | SQLException e) {

			}

			break;
		case "modify":
			System.out.println("yes");
			break;
		case "show":
			try {
				show(request, out);
			} catch (SQLException e1) {

				e1.printStackTrace();
			}
			break;
		case "all":
			try {
				all(request, out);
			} catch (SQLException e) {

				e.printStackTrace();
			}
			break;
		case "delete":
			try {
				delelte(request, out);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		case "search":
			
			break;
		case "insert":
			break;
		default:
			break;
		}

	}

	private void delelte(HttpServletRequest request, PrintWriter out) throws SQLException {
		String idStr = request.getParameter("shiJuanId");
		int id = Integer.parseInt(idStr);
		boolean right = shiJuanService.deleteById(id);
		if (right) {
			out.write("ok");
		}else {
			out.write("error");
		}
	}

	private void show(HttpServletRequest request, PrintWriter out) throws SQLException {
		String idStr = request.getParameter("sjId");
		int id = Integer.parseInt(idStr);
		ShiJuan shiJuan = new ShiJuan();
		shiJuan.setId(id);
		ShiJuan sj = shiJuanService.selectById(id);
		List<XuanZe> selectSJXZs = sJXZService.selectSJXZs(shiJuan);
		List<TianKong> selectSJTKs = sJTKService.selectSJTKs(shiJuan);
		List<Ask> selectSJAsks = sJAService.selectAsksByShiJuan(shiJuan);
		JSONArray jsonSJXZs = JSONArray.fromObject(selectSJXZs);
		JSONArray jsonSJTKs = JSONArray.fromObject(selectSJTKs);
		JSONArray jsonAsks = JSONArray.fromObject(selectSJAsks);
		JSONObject data = new JSONObject();
		data.put("SJXZs", jsonSJXZs);
		data.put("SJTKs", jsonSJTKs);
		data.put("Asks", jsonAsks);
		data.put("title", sj.getTitle());
		data.put("shiJuanId",sj.getId());
		out.println(data);
		out.flush();
		out.close();
	}

	private void all(HttpServletRequest request, PrintWriter out) throws SQLException {
		String page = request.getParameter("pageNum");
		int pageNum = Integer.parseInt(page);
		List<ShiJuan> allShiJuan = null;
		allShiJuan = shiJuanService.selectPageNum(pageNum);
		long count = 0;
		count = shiJuanService.selectAllPage();
		JSONArray jsonA = JSONArray.fromObject(allShiJuan);
		JSONArray dataNum = new JSONArray();
		JSONObject jsonB = new JSONObject();
		jsonB.put("currenPage", pageNum);
		jsonB.put("allCount", count);
		dataNum.add(jsonB);
		dataNum.add(jsonA);
		out.println(dataNum);
		out.flush();
		out.close();
	}

	private void initialize(HttpServletRequest request, PrintWriter out) throws ParseException, SQLException {
		Connection conn = JdbcUtil.getConnection();
		conn.setAutoCommit(false);
		JSONObject json = new JSONObject();
		try {
			String xuanzesId[] = request.getParameterValues("xuanzesId");
			String tiankongsId[] = request.getParameterValues("tiankongsId");
			String[] asksId = request.getParameterValues("asksId");

			String title = request.getParameter("shijuan");

			Date dNow = new Date();
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			String format = df.format(dNow);
			Date dNow2 = new Date();
			dNow2 = df.parse(format);

			ShiJuan shiJuan1 = new ShiJuan(title, dNow2, 0);
			shiJuanService.insertShiJuan(shiJuan1);
			ShiJuan shiJuan = new ShiJuan();
			shiJuan = shiJuanService.selectShiJuan(dNow2, title);

			if (xuanzesId != null) {
				List<SJXZ> sjxzs = new ArrayList<>();
				for (int i = 0; i < xuanzesId.length; i++) {
					XuanZe xuanZe = new XuanZe();
					xuanZe.setId(Integer.parseInt(xuanzesId[i]));
					sjxzs.add(new SJXZ(shiJuan, xuanZe));
				}
				sJXZService.insertSJXZ(sjxzs);
			}

			if (tiankongsId != null) {
				List<SJTK> sjtks = new ArrayList<>();
				for (int i = 0; i < tiankongsId.length; i++) {
					TianKong tianKong = new TianKong();
					tianKong.setId(Integer.parseInt(tiankongsId[i]));
					sjtks.add(new SJTK(shiJuan, tianKong));
				}
				sJTKService.insertSJTK(sjtks);

			}

			if (asksId != null) {

				List<SJAsk> sjasks = new ArrayList<>();
				for (int i = 0; i < asksId.length; i++) {
					Ask ask = new Ask();
					ask.setId(Integer.parseInt(asksId[i]));
					sjasks.add(new SJAsk(shiJuan, ask));
				}
				sJAService.insertAsk(sjasks);
			}
		} catch (Exception e) {
			conn.rollback();
			System.out.println(e.getMessage());
			json.put("right", "no");
			out.println(json);
			out.flush();
			out.close();
		}
		json.put("right", "yes");
		out.println(json);
		out.flush();
		out.close();
		conn.commit();
		conn.setAutoCommit(true);
		JdbcUtil.releaseDB(conn);
	}

}
