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

import com.wenjuan.bean.ADTK;
import com.wenjuan.bean.ShiJuan;
import com.wenjuan.bean.TKDTK;
import com.wenjuan.bean.User;
import com.wenjuan.bean.XZDTK;
import com.wenjuan.bean.XuanZe;
import com.wenjuan.dao.TianKongDTKDao;
import com.wenjuan.dao.TianKongDao;
import com.wenjuan.dao.impl.TKDTKDaoImpl;
import com.wenjuan.dao.impl.TianKongDaoImpl;
import com.wenjuan.service.ADTKService;
import com.wenjuan.service.SJTKService;
import com.wenjuan.service.SJXZService;
import com.wenjuan.service.ShiJuanService;
import com.wenjuan.service.TKDTKService;
import com.wenjuan.service.TianKongService;
import com.wenjuan.service.UserService;
import com.wenjuan.service.XZDTKService;
import com.wenjuan.service.XuanZeService;
import com.wenjuan.service.impl.ADTKServiceImpl;
import com.wenjuan.service.impl.SJTKServiceImpl;
import com.wenjuan.service.impl.SJXZServiceImpl;
import com.wenjuan.service.impl.ShiJuanServiceImpl;
import com.wenjuan.service.impl.TKDTKDaoServiceImpl;
import com.wenjuan.service.impl.TianKongServiceImpl;
import com.wenjuan.service.impl.UserServiceImpl;
import com.wenjuan.service.impl.XZDTKDaoServiceImpl;
import com.wenjuan.service.impl.XuanZeServiceImpl;
import com.wenjuan.utils.JdbcUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@WebServlet("/dTKServlet")
public class DTKServlet extends HttpServlet {
	private XZDTKService xZDTKServiuce = new XZDTKDaoServiceImpl();
	private TKDTKService tKDTKServiuce = new TKDTKDaoServiceImpl();
	private ADTKService aDTKServiuce = new ADTKServiceImpl();
	private ShiJuanService shiJuanService = new ShiJuanServiceImpl();
	private XuanZeService xuanZeService = new XuanZeServiceImpl();
	private TianKongService tianKongService = new TianKongServiceImpl();
	private UserService userService = new UserServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String op = request.getParameter("op");
		PrintWriter out = response.getWriter();
		switch (op) {
		case "insert":
			try {
				insert(request, out);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		case "search":

			try {
				analyse(request, out);
			} catch (ParseException | SQLException e) {
				e.printStackTrace();
			}
			break;
		default:
			break;
		}
	}

	private void analyse(HttpServletRequest request, PrintWriter out) throws ParseException, SQLException {
		int ecxellent = 0;
		int fitness = 0;
		int qualify = 0;
		int nQualify = 0;
		int account = 0;
		int mEcx = 0;// 男生优秀
		int fEcx = 0;// 女生优秀
		int mFit = 0;// 男生良好
		int fFit = 0;// 女生良好
		int mQua = 0;// 男生合格
		int fQua = 0;// 女生合格
		int mNqua = 0;// 男生不合格
		int fNqua = 0;// 女生不合格
		String riqiStr = request.getParameter("riqi");
		String title = request.getParameter("title");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		JSONObject json = new JSONObject();
		Date riqi = null;
		riqi = df.parse(riqiStr);
		// 找道问卷的id
		ShiJuan shiJuan = null;
		shiJuan = shiJuanService.selectShiJuan(riqi, title);
		// 找到该问卷的所有使用者
		List<Object> selectUserId = new ArrayList<>();
		try {
			// 通过问卷查找user
			selectUserId = xZDTKServiuce.selectUserId(shiJuan.getId());
		} catch (SQLException e) {

			e.printStackTrace();
		}
		for (Object o : selectUserId) {
			List<XZDTK> xzdtks = null;
			List<TKDTK> tkdtks = null;
			account = 0;
			// 查找该用户的信息
			User user = null;

			user = userService.selectById((Integer) o);

			xzdtks = xZDTKServiuce.selectXZDTK(shiJuan, (Integer) o);

			// 计算选择分数
			account += xuanZeService.getXZScore(xzdtks);

			// 计算填空分数

			tkdtks = tKDTKServiuce.selectTKDTK(shiJuan, (Integer) o);

			account = account + tianKongService.getTKScore(tkdtks);

			if (user.getGender().equals("male")) {
				if (account > 60) {
					ecxellent += 1;
					mEcx++;
				} else if (account > 50) {
					fitness += 1;
					mFit++;
				} else if (account > 30) {
					qualify += 1;
					mQua++;
				} else {
					nQualify += 1;
					mNqua++;
				}
			} else {
				if (account > 60) {
					ecxellent += 1;
					fEcx++;
				} else if (account > 50) {
					fitness += 1;
					fFit++;
				} else if (account > 30) {
					qualify += 1;
					fQua++;
				} else {
					nQualify += 1;
					fNqua++;
				}
			}

		}
		// 传四个级别的人数过去，和问答题的内容
		json.put("exe", ecxellent);
		json.put("fit", fitness);
		json.put("qua", qualify);
		json.put("nQu", nQualify);
		json.put("mEcx", mEcx);
		json.put("mFit", mFit);
		json.put("mQua", mQua);
		json.put("mNqua", mNqua);
		json.put("fEcx", fEcx);
		json.put("fFit", fFit);
		json.put("fQua", fQua);
		json.put("fNqua", fNqua);
		out.println(json);
		out.flush();
		out.close();
	}

	private void insert(HttpServletRequest request, PrintWriter out) throws SQLException {
		String[] xuanZeAnswers = request.getParameterValues("xuanZeAnsers");
		String[] tianKongAnswers = request.getParameterValues("tiankongAnswers");
		String[] askAnswers = request.getParameterValues("askAnswers");
		String idStr = request.getParameter("shiJuanId");
		int id = Integer.parseInt(idStr);
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		int userId = user.getId();
		Connection conn = JdbcUtil.getConnection();
		conn.setAutoCommit(false);
		List<XZDTK> xzdtks = new ArrayList<>();
		// 选择答题卡
		int i;
		for (i = 0; i < xuanZeAnswers.length; i += 2) {
			xzdtks.add(new XZDTK(id, Integer.parseInt(xuanZeAnswers[i]), userId, xuanZeAnswers[i + 1]));
		}
		// 填空答题卡
		List<TKDTK> tkdtks = new ArrayList<>();
		for (i = 0; i < tianKongAnswers.length; i += 2) {
			tkdtks.add(new TKDTK(id, Integer.parseInt(tianKongAnswers[i]), userId, tianKongAnswers[i + 1]));
		}
		// 问答题
		List<ADTK> adtks = new ArrayList<>();
		for (i = 0; i < askAnswers.length; i += 2) {
			adtks.add(new ADTK(id, Integer.parseInt(askAnswers[i]), userId, askAnswers[i + 1]));
		}
		// 运用事务，插入问卷答题卡
		try {
			xZDTKServiuce.insertXZDTK(xzdtks);
			tKDTKServiuce.insertTKDTK(tkdtks);
			aDTKServiuce.insertADTK(adtks);
		} catch (SQLException e) {
			// 如错误，回滚
			conn.rollback();
			System.out.println(e.getMessage());
		}

		conn.setAutoCommit(true);
		JdbcUtil.releaseDB(conn);
		JSONObject json = new JSONObject();
		json.put("data", "yes");
		out.println(json);
		out.flush();
		out.close();
	}

}
