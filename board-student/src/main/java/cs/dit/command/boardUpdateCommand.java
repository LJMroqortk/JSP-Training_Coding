package cs.dit.command;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs.dit.board.BoardDao;
import cs.dit.board.BoardDto;

public class boardUpdateCommand implements boardService {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		int bcode = Integer.parseInt(request.getParameter("bcode"));
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		String writer = request.getParameter("writer");
		Date regDate = Date.valueOf(request.getParameter("regDate"));
		
		BoardDto dto = new BoardDto(bcode, subject, content, writer, regDate); 
		BoardDao dao = new BoardDao();
		
		dao.update(dto);
		
	}
}
