package pers.mw.exercise;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 圖片上顯示request parameter
 */
@WebServlet("/ex3_1")
public class Exercise3_1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String name = request.getParameter("name");
		
		//Response
		response.setContentType("image/jpeg");
		try (
				InputStream is = getServletContext().getResourceAsStream("/test.jpg");
				OutputStream os = response.getOutputStream()){
			BufferedImage result = mergeImage(is, name);
			ImageIO.write(result, "JPG", os);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private BufferedImage mergeImage(InputStream is, String parameter) throws IOException {
		BufferedImage bufferedImage =  ImageIO.read(is);
		Graphics g = bufferedImage.getGraphics();
		g.setColor(Color.BLACK);
		g.setFont(new Font("標楷體", Font.BOLD, 16));
		g.drawString(parameter, 10, 15);
		return bufferedImage;
	}
}
