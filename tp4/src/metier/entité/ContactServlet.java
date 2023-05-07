package metier.entité;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.sql.SQLException;
import java.util.concurrent.Executor;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

/**
 * Servlet implementation class ContactServlet
 */
@WebServlet("/ContactServlet")
public class ContactServlet extends HttpServer {
	 private contactdao contactDAO;
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ContactServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	        try {
	            List<contact> contacts = contactDAO.getAllContacts();
	            request.setAttribute("contacts", contacts);
	            request.getRequestDispatcher("/WEB-INF/views/contactList.jsp").forward(request, response);
	        } catch (SQLException e) {
	            throw new ServletException("Error retrieving contacts", e);
	        }}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	@Override
	public void bind(InetSocketAddress addr, int backlog) throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setExecutor(Executor executor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Executor getExecutor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void stop(int delay) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public HttpContext createContext(String path, HttpHandler handler) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HttpContext createContext(String path) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeContext(String path) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeContext(HttpContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public InetSocketAddress getAddress() {
		// TODO Auto-generated method stub
		return null;
	}

}
