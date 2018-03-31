package com.wenjuan.controller;

import java.awt.image.RescaleOp;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.mysql.fabric.Response;
import com.wenjuan.bean.User;
import com.wenjuan.service.UserService;
import com.wenjuan.service.impl.UserServiceImpl;
import com.wenjuan.utils.DesUtils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@MultipartConfig
@WebServlet("/userServlet")
public class UserServlet extends HttpServlet {
	private UserService userService = new UserServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String piccode = session.getAttribute("verCode").toString();
		String op = request.getParameter("op");
		
		switch (op) {
		case "login":
			try {
				login(request, response, session);
			} catch (Exception e1) {

				e1.printStackTrace();
			}
			break;
		case "regist":
			try {
				regist(request, response);
			} catch (Exception e) {

				e.printStackTrace();
			}
			break;
		case "yanzheng":
			yanzheng(request, out, piccode);
			break;
		case "inquire":
			inquire(request, out);
			break;
		case "insert":
		    try {
				modify(request,out);
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case "search":
			try {
				search(request, out);
			} catch (Exception e) {
			
				e.printStackTrace();
			}
			break;
		case "delete":
			try {
				delete(request, out);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		default:
			break;
		}

	}

	private void delete(HttpServletRequest request, PrintWriter out) throws SQLException {
		String userIdStr = request.getParameter("userId");
		int id = Integer.parseInt(userIdStr);
		
		int del = userService.deleteUser(id);
		JSONObject data=new JSONObject();
		data.put("right", "yes");
		out.println(data);
	}

	private void search(HttpServletRequest request, PrintWriter out) throws Exception {
		String idStr = request.getParameter("id");
		int id = Integer.parseInt(idStr);
		User user = userService.selectById(id);
		user.setBirth(new java.util.Date(user.getBirth().getTime()));
		//还原密码
		DesUtils des = new DesUtils("");
		String pwd = des.decrypt(user.getPwd());
		user.setPwd(pwd);
		JSONObject userJson = JSONObject.fromObject(user);
		out.println(userJson);
	}

	private void modify(HttpServletRequest request,PrintWriter out) throws Exception, ParseException, SQLException {
		String idStr = request.getParameter("idStr");
		int id = Integer.parseInt(idStr);
		String name = request.getParameter("name");
		String pwdStr = request.getParameter("password");
		String gender = request.getParameter("gender");
		String birthStr = request.getParameter("birth");
		DesUtils des = new DesUtils("");
		String pwd = des.encrypt(pwdStr);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yy-MM-dd");
		Date birth = null;
		birth = dateFormat.parse(birthStr);
		int modifyUser = userService.modifyUser(new User(id,name,pwd,gender,birth,"/upload/user/20171031145455.png"));
		JSONObject data=new JSONObject();
		if(modifyUser>0) {
			data.put("right", "yes");
		}else {
			data.put("right", "no");
		}
		out.println(data);
		out.flush();
		out.close();
	}

	private void inquire(HttpServletRequest request, PrintWriter out) {
		String pageNumStr = request.getParameter("pageNum");
		int pageNum = Integer.parseInt(pageNumStr);
		List<User>users=null;
		try {
			users=userService.findPageNumUser(pageNum);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//得到所有用户数量
		long count=1;
		try {
			count=userService.selectCount();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//把时间转换为date.util形式
		for(User user:users) {
			user.setBirth(new java.util.Date(user.getBirth().getTime()));
		}
		JSONArray jsonA = JSONArray.fromObject(users);
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

	private void yanzheng(HttpServletRequest request, PrintWriter out, String piccode) {
		int i;
		String code = request.getParameter("code");
		char[] low = piccode.toLowerCase().toCharArray();
		char[] up = piccode.toUpperCase().toCharArray();
		char[] charArray = code.toCharArray();
		for (i = 0; i < charArray.length; i++) {
			if ((charArray[i] != low[i] && charArray[i] != up[i]))
				break;
		}

		if (i >= charArray.length) {
			out.write("ok");
		} else
			out.write("False");
	}

	private void login(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
		String name = request.getParameter("userName");
		String pwdStr = request.getParameter("password");
		DesUtils des = new DesUtils("");
		String pwd = des.encrypt(pwdStr);
		String path = request.getContextPath();
		User user = null;
		try {
			user = userService.login(name, pwd);
		} catch (SQLException e) {

			e.printStackTrace();
		}
		if (user != null) {
			session.setAttribute("user", user);
			response.sendRedirect(path+"/user/user.jsp");
		} else {
			String script = "<script>alert('用户名或密码错误，请重新登陆');location.href='user/index.jsp'</script>";
			response.getWriter().println(script);
		}
	}

	private void regist(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String name = request.getParameter("userName");
		String pwdStr = request.getParameter("password1");


		DesUtils des = new DesUtils("");
		String pwd = des.encrypt(pwdStr);

		String birthStr = request.getParameter("birth");
		String radio = request.getParameter("inlineRadioOptions");

		SimpleDateFormat dateFormat = new SimpleDateFormat("yy-MM-dd");
		Date birth = null;
		try {
			birth = dateFormat.parse(birthStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Part part = request.getPart("img");
		String header = part.getHeader("content-disposition");
		String fileName = header.substring(header.lastIndexOf("=\"") + 2, header.length() - 1);// abc.img

		String realPath = request.getServletContext().getRealPath("");
		String parts = realPath + "/upload/user";

		File file = new File(parts);
		if (!file.exists()) {
			file.mkdirs();
		}
		part.write(parts + fileName);

		User user = new User(name, pwd, radio, birth, "/upload/user/" + fileName);
		try {
			userService.regist(user);
		} catch (SQLException e) {

			e.printStackTrace();
		}
		response.sendRedirect("registSuccess.jsp");
	}
}
