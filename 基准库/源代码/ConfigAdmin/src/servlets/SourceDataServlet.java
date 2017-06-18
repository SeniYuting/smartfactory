package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MongoDao;
import model.SourceData;

/**
 * Servlet implementation class SourceDataServlet
 */
@WebServlet("/SourceDataServlet")
public class SourceDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SourceDataServlet() {
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
		ArrayList<SourceData> dataList = MongoDao.getInstance().getAllSource();

		if (!dataList.isEmpty()) {
			req.setAttribute("dataList", dataList);
		}
		ServletContext context = getServletContext();
		context.getRequestDispatcher("/admin/sourceData.jsp").forward(req, resp);
	}

}
