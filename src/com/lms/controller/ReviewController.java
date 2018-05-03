package com.lms.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lms.command.Command;
import com.lms.command.review.*;


@WebServlet("/review")
public class ReviewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
      protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  		doPost(request, response);
      }

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=UTF-8");
			
			String type = request.getParameter("type");
			String path = ".";
			System.out.println("doPost type: "+type);
			
			Command cmd = null;
			if (type.equalsIgnoreCase("reviewinsert")) {
				cmd = new ReviewInsertCommand();
			} else if (type.equalsIgnoreCase("reviewupdateform")) {
				cmd =  new ReviewUpdateFormCommand();
			} else if (type.equalsIgnoreCase("reviewupdateaction")) {
				cmd =  new ReviewUpdateActionCommand();
			} else if (type.equalsIgnoreCase("reviewdelete")) {
				cmd =  new ReviewDeleteCommand();	
			}	
			
			if (cmd != null) {
				path = cmd.exec(request, response);
			}
			
			request.getRequestDispatcher(path).forward(request, response);
	  }
}