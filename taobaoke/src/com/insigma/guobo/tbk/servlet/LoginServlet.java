package com.insigma.guobo.tbk.servlet;

import java.io.IOException;
import java.net.URLEncoder;

import javax.persistence.Entity;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.insigma.guobo.tbk.services.LoginService;
import com.insigma.guobo.tbk.services.LoginServiceImpl;

@Entity
public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		//获取信息
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String role = request.getParameter("role");
		String keepLogin = request.getParameter("terms");//如果勾选了 则为 1 
		
		//如果是退出操作  
		String logout = request.getParameter("logout");
		if("1".equals(logout)){
			//修改标记自动提交的cookie
			Cookie cookie = new Cookie("keepLogin","");
			cookie.setMaxAge(0);
			cookie.setPath("/taobaoke");
			response.addCookie(cookie);
			
			//移除session
			request.getSession(false).removeAttribute("userName");
			request.getRequestDispatcher("/jsp/user/indexp.jsp").forward(request, response);
			return;
		}
		
		//验证
		LoginService loginService = new LoginServiceImpl();
		boolean isAccept = loginService.isValidUser(userName, password);
		
		if(isAccept){
			
			//判断是否保持登录
			if("1".equals(keepLogin)){
				//记录到cookie
				Cookie userNameCookie = new Cookie("userName", URLEncoder.encode(userName, "utf-8"));//有中文需要url编码
				userNameCookie.setMaxAge(7*24*3600);//保存一周
				userNameCookie.setPath("/taobaoke");
				Cookie passwordCookie = new Cookie("password", password);
				passwordCookie.setMaxAge(7*24*3600);//保存一周
				passwordCookie.setPath("/taobaoke");
				Cookie keepLoginCookie = new Cookie("keepLogin","1");
				keepLoginCookie.setMaxAge(7*24*3600);//保存一周
				keepLoginCookie.setPath("/taobaoke");				
				response.addCookie(passwordCookie);
				response.addCookie(userNameCookie);
				response.addCookie(keepLoginCookie);
			}
		

			
			//如果成功  跳转到首页  保存会话
			request.getSession().setAttribute("userName", userName);
			request.setAttribute("userName", userName);
			if("0".equals(role)){
				//管理员
				request.getRequestDispatcher("/jsp/admin/index.jsp").forward(request, response);
				return;
			}else{
				request.getRequestDispatcher("/jsp/user/index.jsp").forward(request, response);
				return;
			}
		}
		
		String message = "用户名或者密码错误！！！";
		request.setAttribute("msg", message);
		request.getRequestDispatcher("/jsp/user/login.jsp").forward(request, response);
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
