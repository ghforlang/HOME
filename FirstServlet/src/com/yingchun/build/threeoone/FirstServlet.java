package com.yingchun.build.threeoone;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.log("调用doGet方法*****");
		super.doGet(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.log("调用post方法*****");
		super.doPost(req, resp);
	}

	
	@Override
	protected long getLastModified(HttpServletRequest req) {
		this.log("执行getLastModified方法******");
		return -1;
	}
	
	private void execute(HttpServletRequest request,HttpServletResponse response) throws
		ServletException,IOException{
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		String requestUrl = request.getRequestURI();
		String method = request.getMethod();
		String param = request.getParameter("Param");
		
		response.setContentType("text/html");
		PrintWriter outputWriter = response.getWriter();
		
		outputWriter.println("<!DOCTYPE HEML PUBLIC \" -//W3C//DTD HIML 4.01 Transitionl//EN\">");
		outputWriter.println("<HTML>");
		outputWriter.println("<HEAD><TTTLE>A SERVLET </TITLE></HEAD>");
		outputWriter.println("<BODY>");
		outputWriter.println("以" + method  + "方式访问该页面，获取的参数为" + param + "</br>");
		outputWriter.println("<form action='" + requestUrl + "'method = 'get'> <input type='text' name='Param' value='param string'>"
				+ "<input type='submit'  value='以get方式提交到页面'" + requestUrl + "'></form>");
		outputWriter.println("<form action='" + requestUrl + "'method = 'post'> <input type='text' name='Param' value='param string'>"
				+ "<input type='submit'  value='以post方式提交到页面'" + requestUrl + "'></form>");
		outputWriter.println("<script>document.write('本页面最后更新时间:'+ document.lastModified);</script>");
		outputWriter.println("</BODY>");
		outputWriter.println("</HTML>");
		outputWriter.flush();
		outputWriter.close();
		
	}
}
