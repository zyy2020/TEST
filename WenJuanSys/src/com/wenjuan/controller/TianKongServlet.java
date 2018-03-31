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

import com.wenjuan.bean.TianKong;

import com.wenjuan.service.TianKongService;
import com.wenjuan.service.impl.TianKongServiceImpl;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@WebServlet("/tianKongServlet")
public class TianKongServlet extends HttpServlet {
	// 导包快捷键 ctrl +shift+o
	private TianKongService tianKongService = new TianKongServiceImpl();

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
			require(request, out);
			break;

		case "search":
			search(request, out);
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
		default:
			break;
		}
	}

	private void modify(HttpServletRequest request, PrintWriter out) {
		String idStr = request.getParameter("idText");
		int id = Integer.parseInt(idStr);
		String question = request.getParameter("question");
		String answer = request.getParameter("answer");
		String scoreStr = request.getParameter("score");
		int score = Integer.parseInt(scoreStr);

		TianKong tianKong = new TianKong(id, question, answer, score);
		boolean ri = false;
		try {
			ri = tianKongService.updateTianKong(tianKong);
		} catch (SQLException e) {

			e.printStackTrace();
		}
		String script;
		if (ri) {
			script = "<script>alert('修改成功！');location.href='mgr/tianKongExam.jsp'</script>";

		} else {
			script = "<script>alert('error');location.href='mgr/tianKongExam.jsp'</script>";
		}
		out.println(script);
	}

	private void insert(HttpServletRequest request, PrintWriter out) {
		String question = request.getParameter("question");
		String answer = request.getParameter("answer");
		String scoreStr = request.getParameter("score");
		int score = Integer.parseInt(scoreStr);

		TianKong tianKong = new TianKong(question, answer, score);
		boolean ri = false;
		try {
			ri = tianKongService.insertTianKong(tianKong);
		} catch (SQLException e) {

			e.printStackTrace();
		}
		String script;
		if (ri) {
			script = "<script>alert('插入成功！');location.href='mgr/tianKongExam.jsp'</script>";

		} else {
			script = "<script>alert('error');location.href='mgr/tianKongExam.jsp'</script>";
		}
		out.println(script);
	}

	private void search(HttpServletRequest request, PrintWriter out) {
		String idStr = request.getParameter("id");
		int id = Integer.parseInt(idStr);
		TianKong tianKong = new TianKong();

		try {
			tianKong = tianKongService.selectTianKongById(id);
		} catch (SQLException e) {

			e.printStackTrace();
		}
		JSONObject res = JSONObject.fromObject(tianKong);

		out.println(res);
		out.flush();
		out.close();
	}

	private void delete(HttpServletRequest request, PrintWriter out) {
		String idStr = request.getParameter("tiankongId");
		int id = Integer.parseInt(idStr);
		boolean del = false;
		try {
			del = tianKongService.deleteTianKong(id);
		} catch (SQLException e) {

			e.printStackTrace();
		}
		if (!del) {
			out.write("error");
		} else
			out.write("ok");
	}

	private void require(HttpServletRequest request, PrintWriter out) {
		String pageNumStr = request.getParameter("pageNum");
		int pageNum = Integer.parseInt(pageNumStr);
		List<TianKong> tkLists = new ArrayList<>();
		// 找到所有的页数
		long page = 1;
		try {
			page = tianKongService.findAllCount();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		// 找到该页的内容

		try {
			tkLists = tianKongService.findTianKongByPage(pageNum);
		} catch (SQLException e) {

			e.printStackTrace();
		}
		// 转换成json
		JSONArray jsonArr = JSONArray.fromObject(tkLists);
		JSONObject json = new JSONObject();
		json.put("currPage", pageNum);
		json.put("allCount", page);
		JSONArray data = new JSONArray();
		data.add(json);
		data.add(jsonArr);
		out.println(data);
		out.flush();
		out.close();
	}

}
