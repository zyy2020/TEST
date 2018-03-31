package com.wenjuan.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wenjuan.bean.XuanZe;
import com.wenjuan.service.XuanZeService;
import com.wenjuan.service.impl.XuanZeServiceImpl;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@WebServlet("/xuanZeServlet")
public class XuanZeServlet extends HttpServlet {
	private XuanZeService xuanZeService = new XuanZeServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String op = request.getParameter("op");
		PrintWriter out = response.getWriter();
		switch (op) {
		case "inquire":
			inquire(request, out);
			break;
		case "delete":
			delete(request, out);
			break;
		case "modify":
			modify(request, out);
			break;
		case "insert":
			insert(request, out);
			break;
		case "search":
			search(request, out);
			break;
		default:
			System.out.println("error");
			break;
		}
	}

	private void modify(HttpServletRequest request, PrintWriter out) {
		String idStr = request.getParameter("idText");
		int id = Integer.parseInt(idStr);
		String title = request.getParameter("title");
		String key1 = request.getParameter("key1");
		String weight1Str = request.getParameter("weight1");
		int weight1 = Integer.parseInt(weight1Str);
		String key2 = request.getParameter("key2");
		String weight2Str = request.getParameter("weight2");
		int weight2 = Integer.parseInt(weight2Str);
		String key3 = request.getParameter("key3");
		String weight3Str = request.getParameter("weight3");
		int weight3 = Integer.parseInt(weight3Str);
		String key4 = request.getParameter("key4");
		String weight4Str = request.getParameter("weight4");
		int weight4 = Integer.parseInt(weight4Str);
		XuanZe xuanze = new XuanZe(id, title, key1, weight1, key2, weight2, key3, weight3, key4, weight4);
		boolean ri = false;
		String script;
		try {
			ri = xuanZeService.updateXuanZe(xuanze);
		} catch (SQLException e) {

			e.printStackTrace();
		}
		if (ri) {
			script = "<script>alert('更新成功！');location.href='mgr/exam.jsp'</script>";

		} else {
			script = "<script>alert('error');location.href='mgr/exam.jsp'</script>";
		}
		out.println(script);
	}

	private void search(HttpServletRequest request, PrintWriter out) {
		String idStr = request.getParameter("id");
		int id = Integer.parseInt(idStr);
		XuanZe xuanZe = new XuanZe();
		try {
			xuanZe = xuanZeService.findXuanZeById(id);
		} catch (SQLException e) {

			e.printStackTrace();
		}
		JSONObject res = JSONObject.fromObject(xuanZe);

		out.println(res);
		out.flush();
		out.close();
	}

	private void inquire(HttpServletRequest request, PrintWriter out) {
		String page = request.getParameter("pageNum");
		int pageNum = Integer.parseInt(page);
		List<XuanZe> xuanZeLists = null;
		try {
			xuanZeLists = xuanZeService.findXuanZeByPageNum(pageNum);
		} catch (SQLException e1) {

			e1.printStackTrace();
		}
		long count = 1;// 得到所有页
		try {
			count = xuanZeService.selectAllCount();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		JSONArray jsonA = JSONArray.fromObject(xuanZeLists);
		JSONArray dataNum = new JSONArray();
		JSONObject jsonB = new JSONObject();
		jsonB.put("currenPage", pageNum);
		jsonB.put("allCount", count);
		dataNum.add(jsonB);
		dataNum.add(jsonA);
		out.println(dataNum);
		out.flush();// 清空缓冲区
		out.close();
	}

	private void delete(HttpServletRequest request, PrintWriter out) {
		String idStr = request.getParameter("xuanZeId");
		int id = Integer.parseInt(idStr);
		boolean del = false;
		try {
			del = xuanZeService.deleteXuanZe(id);
		} catch (SQLException e) {

			e.printStackTrace();
		}
		if (!del) {
			out.write("error");
		} else
			out.write("ok");
	}

	private void insert(HttpServletRequest request, PrintWriter out) {
		String title = request.getParameter("title");
		String key1 = request.getParameter("key1");
		String weight1Str = request.getParameter("weight1");
		int weight1 = Integer.parseInt(weight1Str);
		String key2 = request.getParameter("key2");
		String weight2Str = request.getParameter("weight2");
		int weight2 = Integer.parseInt(weight2Str);
		String key3 = request.getParameter("key3");
		String weight3Str = request.getParameter("weight3");
		int weight3 = Integer.parseInt(weight3Str);
		String key4 = request.getParameter("key4");
		String weight4Str = request.getParameter("weight4");
		int weight4 = Integer.parseInt(weight4Str);
		XuanZe xuanze = new XuanZe(title, key1, weight1, key2, weight2, key3, weight3, key4, weight4);
		boolean ri = false;
		try {
			ri = xuanZeService.insertXuanZe(xuanze);
		} catch (SQLException e) {

			e.printStackTrace();
		}
		String script;
		if (ri) {
			script = "<script>alert('插入成功！');location.href='mgr/exam.jsp'</script>";

		} else {
			script = "<script>alert('error');location.href='mgr/exam.jsp'</script>";
		}
		out.println(script);
	}

}
