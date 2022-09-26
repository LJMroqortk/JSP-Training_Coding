package cs.dit.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cs.dit.board.BoardDao;
import cs.dit.board.BoardDto;

public class boardViewCommand implements boardService{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();

		int bcode = Integer.parseInt(request.getParameter("bcode"));
		
		BoardDao dao = new BoardDao();
		
		BoardDto dto = dao.selectOne(bcode);
		
		request.setAttribute("dto", dto);
	}
}
