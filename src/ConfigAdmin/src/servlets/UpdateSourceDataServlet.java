package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MongoDao;
import model.SourceData;

/**
 * Servlet implementation class UpdateSourceDataServlet
 */
@WebServlet("/UpdateSourceDataServlet")
public class UpdateSourceDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateSourceDataServlet() {
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
		SourceData data = new SourceData();
		data.set_id(req.getParameter("id"));
		data.setName(req.getParameter("name"));
		data.setSql(req.getParameter("sql"));
		data.setSource(req.getParameter("source"));
		data.setFrequency(req.getParameter("frequency"));
		data.setType(req.getParameter("type"));
		data.setTupleNum(req.getParameter("tupleNum"));
		MongoDao.getInstance().updateSourceDocument(data);
	}
}