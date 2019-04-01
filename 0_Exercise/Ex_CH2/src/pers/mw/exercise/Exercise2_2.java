package pers.mw.exercise;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 表單登入
 */
@WebServlet("/ex2_2")
public class Exercise2_2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Exercise2_2() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		String result;
		if(username.equals("admin") && password.equals("123456")) {
			result = "登入成功";
		} else {
			result = "<font color=\"red\">登入失敗!</font>";
		}
		
		// 回首頁，參考web.xml設定
		String infexUrl = request.getContextPath();
		
		// 避免中文亂碼
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String docType = "<!DOCTYPE html> \n";
        out.println(docType +
            "<html>\n" +
            "	<head><title>登入結果</title></head>\n" +
            "	<body>\n" +
            "		<h1 align=\"center\">" + result + "</h1>\n" +
            "		<h3 align=\"center\"><a href=\"" + infexUrl +"\">回首頁</a></center>" +
            "	</body>" + 
            "</html>");
	}

}
