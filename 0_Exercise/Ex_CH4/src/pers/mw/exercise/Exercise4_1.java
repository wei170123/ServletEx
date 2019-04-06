package pers.mw.exercise;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 數字驗證碼範例-檢查驗證碼
 * 透過Session
 */
@WebServlet("/ex4_1")
public class Exercise4_1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String sessionNum = (String) request.getSession().getAttribute("checkNum");
			
			String inputNum = request.getParameter("inputNum");
			
			response.setContentType("text/html;charset=UTF-8");
			
			if(sessionNum.equals(inputNum)) {
				response.getWriter().append("驗證成功");
			}
			else {
				response.getWriter().append("驗證失敗");
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
}
