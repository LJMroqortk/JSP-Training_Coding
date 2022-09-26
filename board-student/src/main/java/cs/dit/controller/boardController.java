package cs.dit.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs.dit.command.boardDeleteCommand;
import cs.dit.command.boardInsertCommand;
import cs.dit.command.boardListCommand;
import cs.dit.command.boardUpdateCommand;
import cs.dit.command.boardViewCommand;

@WebServlet("*.bd")
public class boardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter out = resp.getWriter();
		
		String uri = req.getRequestURI();
		String com = uri.substring(uri.lastIndexOf("/")+1, uri.lastIndexOf(".bd"));
		String page = null;
		if(com != null && com.trim().equals("boardListPro")) {
			boardListCommand service = new boardListCommand();
			service.execute(req, resp);
			page="list.jsp";	
		}
		else if(com != null && com.trim().equals("boardUpdateViewPro")) {
			boardViewCommand service = new boardViewCommand();
			service.execute(req, resp);
			page="updateForm.jsp";	
		}
		else if(com != null && com.trim().equals("boardInsertPro")) {
			boardInsertCommand service = new boardInsertCommand();
			service.execute(req, resp);
			page="boardListPro.bd";	
		}
		else if(com != null && com.trim().equals("boardDeletePro")) {
			boardDeleteCommand service = new boardDeleteCommand();
			service.execute(req, resp);
			page="boardListPro.bd";	
		}
		else if(com != null && com.trim().equals("boardUpdatePro")) {
			boardUpdateCommand service = new boardUpdateCommand();
			service.execute(req, resp);
			page="boardListPro.bd";	
		} 
		RequestDispatcher rd = req.getRequestDispatcher(page);
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
