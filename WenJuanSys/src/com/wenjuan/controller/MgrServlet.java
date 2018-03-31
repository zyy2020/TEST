package com.wenjuan.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wenjuan.bean.Mgr;
import com.wenjuan.service.MgrService;
import com.wenjuan.service.impl.MgrServiceImpl;

@WebServlet("/mgrServlet")
public class MgrServlet extends HttpServlet {
	private MgrService mgrService = new MgrServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();
		//绝对路径
		String path = request.getContextPath();
		Mgr login = null;
		try {
			login = mgrService.login(userName, password);
		} catch (SQLException e) {

			e.printStackTrace();
		}
		if (login != null) {
			session.setAttribute("mgr", login);
			response.sendRedirect(path + "/mgr/mgr.jsp");
		} else {
			String script = "<script>alert('账号密码错误');location.href='"+path+"/mgrLogin.jsp'</script>";
			response.getWriter().println(script);
		}

	}

}
