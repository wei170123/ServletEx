package pers.mw.exercise;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Param 設定順序
 * 1. getServletContext().getInitParameter("PARAM1") // ServletContext參數
 * 2. getInitParameter("PARAM1") //本身Servlet參數
 */
@WebServlet(urlPatterns = "/init", initParams = {
		@WebInitParam(name = "PARAM1", value = "VALUE1")
})
public class ServletParamInit extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	 public void init() {
	    	System.out.println("ServletParamInit");
	    	System.out.println(getServletContext().getInitParameter("PARAM1"));
	    	System.out.println(getInitParameter("PARAM1"));
	    	getServletContext().setAttribute("ServletParamInit", "ServletParamInit");
	    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getSession();
		request.getSession().invalidate();
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
