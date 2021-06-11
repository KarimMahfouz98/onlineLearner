package de.unidue.inf.is;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.unidue.inf.is.domain.Abgabe;
import de.unidue.inf.is.domain.Aufgabe;
import de.unidue.inf.is.domain.Kurs;
import de.unidue.inf.is.stores.EinreichenStore;
import de.unidue.inf.is.stores.StoreException;
import de.unidue.inf.is.utils.DBUtil;




public final class NewAssignmentServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    		EinreichenStore e = new EinreichenStore();
    		Aufgabe vt = new Aufgabe();
    		e.ViewTask(vt);
    		e.close();
    		request.setAttribute("vt", vt);
    		request.getRequestDispatcher("/new_assignment.ftl").forward(request, response);
    	}
    
    		
    		/*boolean databaseExists = DBUtil.checkDatabaseExistsExternal();
		
		if (databaseExists) {
		    request.setAttribute("db2exists", "vorhanden! Supi!");
		}
		else {
		    request.setAttribute("db2exists", "nicht vorhanden :-(");
		}
		
		request.getRequestDispatcher("new_course.ftl").forward(request, response);
		}
*/
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
    IOException {   	
    				System.out.println("Inside doPost!!!!");
    				String name = request.getParameter("description");
					System.out.println(request.getParameter(name));

					System.out.println(request.getParameter("description"));
					Abgabe taskToSubmit = new Abgabe();
					taskToSubmit.setDescription(name);
					System.out.println(taskToSubmit.getDescription());
			
					try {
						System.out.println("1");
						EinreichenStore einreichenStore = new EinreichenStore();
						System.out.println("2");
						einreichenStore.submitTask(taskToSubmit);
						einreichenStore.close();
					} catch (Exception e){
			            throw new StoreException(e);
			        }
	    }
	
	}
    