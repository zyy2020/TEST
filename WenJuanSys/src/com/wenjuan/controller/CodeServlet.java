package com.wenjuan.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wenjuan.utils.VerifyCodeUtils;

@WebServlet("/codeServlet")
public class CodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		response.setContentType("image/jpeg");

		String verifyCode = VerifyCodeUtils.generateVerifyCode(4);

		HttpSession session = request.getSession(true);

		session.removeAttribute("verCode");
		session.setAttribute("verCode", verifyCode.toLowerCase());

		int w = 100, h = 30;
		VerifyCodeUtils.outputImage(w, h, response.getOutputStream(), verifyCode);

	}

}
