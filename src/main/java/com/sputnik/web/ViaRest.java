package com.sputnik.web;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sputnik.service.UserService;

@WebServlet(urlPatterns="/viarest")
public class ViaRest extends HttpServlet{
	
	@EJB
	private UserService userServiceImpl; 

	private final static Logger logger = LoggerFactory.getLogger(MainForm.class.getName());

	@Override
	protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("viarestform.jsp").forward(request, response);
	}
}
