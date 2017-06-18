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
import model.GoalData;

/**
 * Servlet implementation class GoalDataServlet
 */
@WebServlet("/GoalDataServlet")
public class GoalDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GoalDataServlet() {
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
		ArrayList<GoalData> dataList = MongoDao.getInstance().getAllGoal();

		if (!dataList.isEmpty()) {
			req.setAttribute("dataList", dataList);
		}
		ServletContext context = getServletContext();
		context.getRequestDispatcher("/admin/goalData.jsp").forward(req, resp);
	}

}
