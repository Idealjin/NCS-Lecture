package com.ohgiraffers.section02.otherservlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/otherservlet")
public class OtherServletRedirectTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("get 요청 정상 수락");
		System.out.println(response);
		response.sendRedirect("redirect");
		
	}

}
