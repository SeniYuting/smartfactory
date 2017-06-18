package servlets;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
     * processRequest
     * 
     * @param req, resp
     * @return
     */
	private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String[] temp = readPasswordFile();
		String email = temp[0];
		String password = temp[1];
		PrintWriter writer = resp.getWriter();
		if (req.getParameter("email").equals(email) && req.getParameter("password").equals(password)) {
			writer.print("success");
		} else {
			writer.print("error");
		}
		writer.flush();
		writer.close();
	}

	/**
	 * 从password.properties文件中读取email和密码
	 * 
	 * @param
	 * @return String[] temp = { email, password }
	 */
	private String[] readPasswordFile() {
		ClassLoader loader = LoginServlet.class.getClassLoader();
		InputStream is = (InputStream) loader.getResourceAsStream("password.properties");
		Properties properties = new Properties();
		try {
			properties.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
		String email = properties.getProperty("email");
		String password = properties.getProperty("password");
		String[] temp = { email, password };
		return temp;
	}

}
