package com.sputnik.web;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sputnik.service.UserService;

@WebServlet(urlPatterns="/mainform", loadOnStartup = 1)
public class MainForm extends HttpServlet{
	
	@EJB
	private UserService userServiceImpl; 

	private final static Logger logger = LoggerFactory.getLogger(MainForm.class.getName());

	@Override
	protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("user", userServiceImpl.getUserEntity());
        
		request.getRequestDispatcher("form.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
		userServiceImpl.getUserEntity().setFirstName(request.getParameter("firstName"));
		userServiceImpl.getUserEntity().setSecondName(request.getParameter("secondName"));
		userServiceImpl.getUserEntity().setShurName(request.getParameter("shurName"));
		userServiceImpl.getUserEntity().setDateOfBirth(request.getParameter("dateOfBirth"));
        
		//По идеи нужно редиректить на  /mainform get, но что то глючновато это работает
		//jsp рендерится напрямую отсюда
		request.setAttribute("user", userServiceImpl.getUserEntity());
        request.getRequestDispatcher("form.jsp").forward(request, response);
   	}
}
