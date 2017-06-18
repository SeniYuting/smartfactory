package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MongoDao;
import model.GoalData;

/**
 * Servlet implementation class AddGoalDataServlet
 */
@WebServlet("/AddGoalDataServlet")
public class AddGoalDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddGoalDataServlet() {
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
		GoalData data = new GoalData();
		data.setName(req.getParameter("name"));
		data.setRule(req.getParameter("rule"));
		data.setTupleNum(Integer.parseInt(req.getParameter("tupleNum")));
		data.setFrequency(Integer.parseInt(req.getParameter("frequency")));
		data.setType(req.getParameter("type"));
		data.setDataSourceList(req.getParameter("dataSourceList"));
		MongoDao.getInstance().addGoalDocument(data);
	}
}