package pers.mw.exercise;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringEscapeUtils;

/**
 * BIG 5 save as UTF-8 
 * 
 * 在〈HTML 實體〉中規範了實體名稱（Entity）與實體編號（Entity
 * number），用以表達網頁上無法直接表現的字元，實體名稱的格式是 &entity_name;，以 < 與 > 為例，因為 < 與 >
 * 在HTML原始碼中，用來作為標籤之用，若要在網頁上呈現 < 與 >，在 HTML 原始碼中必須撰寫為 &lt; 與 &gt;，實體編號的格式為
 * &#entity_number;，若要用實體編碼來表示 < 與 >，必須寫為 &#60; 與 &#62;。
 */
@WebServlet("/ex3_3")
public class Exercise3_3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("Big5");

		String inputText = request.getParameter("inputText");
		
		// 解析Big5無法正常顯示的字元
		inputText = StringEscapeUtils.unescapeHtml(inputText);
		System.out.println(inputText);

		saveTxt("D:/tmpworkspace/Big5ToUTF-8.txt", inputText);
	}

	private void saveTxt(String file, String name) throws IOException {
        try(BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(file), "UTF-8"))) {
            writer.write(name);
        }
    }
}
