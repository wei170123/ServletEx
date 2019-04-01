package pers.mw.exercise;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * 上傳
 * 
 */
//@MultipartConfig(location = "D:/tmpworkspace")
//@WebServlet("/uploads")
public class RqUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		 request.getParts()
				 .stream()
				 .filter(part -> part.getName().startsWith("file"))
				 .forEach(this::write);
	}

	private void write(Part part) {
		String subFileName = part.getSubmittedFileName().substring(part.getSubmittedFileName().lastIndexOf("."));
		try {
			part.write(new Date().getTime() + subFileName);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
