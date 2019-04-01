package pers.mw.exercise;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;
import java.util.stream.Collectors;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 產生隨機數字圖片
 */
@WebServlet("/ex3_2")
public class Exercise3_2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try (OutputStream os = response.getOutputStream()){
			String num = new Random().ints(0, 10).limit(4).mapToObj(String::valueOf).collect(Collectors.joining());
			BufferedImage result = randomNumberImg(num);
			ImageIO.write(result, "JPG", os);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	private BufferedImage randomNumberImg(String num) throws IOException {
		BufferedImage bufferedImage = new BufferedImage(60, 20, BufferedImage.TYPE_INT_RGB);
		Graphics g = bufferedImage.getGraphics();
		g.setColor(Color.WHITE);
		g.setFont(new Font("標楷體", Font.BOLD, 16));
		g.drawString(num, 10, 15);
		return bufferedImage;
	}
}
