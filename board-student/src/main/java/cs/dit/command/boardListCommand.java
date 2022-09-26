package cs.dit.command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs.dit.board.BoardDao;
import cs.dit.board.BoardDto;

public class boardListCommand implements boardService{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		BoardDao dao = new BoardDao();
		ArrayList<BoardDto> dtos = dao.list();
		
		//5. 이 페이지의 저장소인 pageContext에 DB에서 검색해온 dtos 값을 저장하시오.
		request.setAttribute("dtos", dtos);
	}
}
