package grandinConstruction;

import java.io.IOException;
import java.util.LinkedList;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

/**
 * Servlet implementation class Servlet
 */
@WebServlet("/Servlet")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MainDbUtil database;
	
	@Resource(name="jdbc/pricesDB")
	private DataSource dataSource;
	
	private HttpSession session;
	
    public MainServlet() throws ServletException {
        super.init();
        
        try {
        	this.database = new MainDbUtil(dataSource);
        	
        	
        } catch (Exception e) {
        	throw new ServletException(e);
        }
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		session = request.getSession();
		String command = request.getParameter("command");
		
		if (command == null)
			command = "home";
		
		try {
			switch(command) {
			
			case "home":
				initHome(request, response);
				break;
				
			case "calculatePrice":
				calculatePrice(request, response);
				break;
				
			default:
				break;	// do nothing
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		session = request.getSession();
		String command = request.getParameter("command");
		
		try {
			switch(command) {
			
			case "login":
				login(request, response);
				break;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void calculatePrice(HttpServletRequest request, HttpServletResponse response) throws Exception {
		LinkedList<String> inputValues = new LinkedList<String>();
		LinkedList<Item> items = null;
		
		for (String table : database.getTables()) {
			inputValues.add(request.getParameter(table));
		}
		
		for (int i = 0; i < database.getNumTables(); ++i) {
			items.add(database.searchByName(database.getTables().get(i), inputValues.get(i)));
		}
		
		session.setAttribute("ITEMS", items);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/calculator.jsp");
		dispatcher.forward(request, response);
		
		
	}
	
	private void initHome(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void login(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

}
