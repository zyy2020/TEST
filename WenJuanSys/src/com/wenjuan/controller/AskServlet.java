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

import com.wenjuan.bean.Ask;
import com.wenjuan.bean.TianKong;
import com.wenjuan.service.AskService;
import com.wenjuan.service.impl.AskServiceImpl;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@WebServlet("/askServlet")
public class AskServlet extends HttpServlet {
	private AskService askService = new AskServiceImpl();

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
			inqueire(request, out);
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
			break;
		}
	}

	private void modify(HttpServletRequest request, PrintWriter out) {
		String idStr = request.getParameter("idText");
		int id = Integer.parseInt(idStr);
		String question = request.getParameter("question");

		Ask ask = new Ask(id, question);
		boolean ri = false;
		try {
			ri = askService.updateAsk(ask);
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

		Ask ask = new Ask(question);
		boolean ri = false;
		try {
			ri = askService.insertAsk(ask);
		} catch (SQLException e) {

			e.printStackTrace();
		}
		String script;
		if (ri) {
			script = "<script>alert('����ɹ���');location.href='mgr/askExam.jsp'</script>";

		} else {
			script = "<script>alert('error');location.href='mgr/askExam.jsp'</script>";
		}
		out.println(script);
	}

	private void search(HttpServletRequest request, PrintWriter out) {
		String idStr = request.getParameter("id");
		int id = Integer.parseInt(idStr);
		Ask ask = new Ask();
		try {
			ask = askService.selectAskById(id);
		} catch (SQLException e) {

			e.printStackTrace();
		}
		JSONObject res = JSONObject.fromObject(ask);

		out.println(res);
		out.flush();
		out.close();
	}

	private void delete(HttpServletRequest request, PrintWriter out) {
		String idStr = request.getParameter("askId");
		int id = Integer.parseInt(idStr);
		boolean del = false;
		try {
			del = askService.deleteAsk(id);
		} catch (SQLException e) {

			e.printStackTrace();
		}
		if (!del) {
			out.write("error");
		} else
			out.write("ok");
	}

	private void inqueire(HttpServletRequest request, PrintWriter out) {
		String pageNumStr = request.getParameter("pageNum");
		int pageNum = Integer.parseInt(pageNumStr);
		List<Ask> asks = new ArrayList<>();
	
		long page = 1;
		try {
			page = askService.selectAllCount();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	

		try {
			asks = askService.selectAskByPageNum(pageNum);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// ת����json
		JSONArray jsonArr = JSONArray.fromObject(asks);
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
