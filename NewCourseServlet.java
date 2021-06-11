package de.unidue.inf.is;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.unidue.inf.is.domain.Kurs;
import de.unidue.inf.is.stores.KursStore;
import de.unidue.inf.is.stores.StoreException;
import de.unidue.inf.is.utils.DBUtil;




public final class NewCourseServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static List<Kurs> kursList = new ArrayList<>();
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    		request.getRequestDispatcher("/new_course.ftl").forward(request, response);

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
					String name = request.getParameter("name");
					String einschreibeschluessel = request.getParameter("key");
					String beschreibungstext = request.getParameter("description");
					int freiePlaetze = Integer.parseInt(request.getParameter("freeplaces"));
					int c = 1;
					System.out.println(request.getParameter("name"));
					Kurs KursToAdd = new Kurs();
					KursToAdd.setName(name);
					System.out.println(KursToAdd.getName());
					KursToAdd.setKey(einschreibeschluessel);
					KursToAdd.setDescription(beschreibungstext);
					KursToAdd.setFreeplaces(freiePlaetze);
					KursToAdd.setCreator(c);
			
					try {
						System.out.println("1");
						KursStore kursStore = new KursStore();
						System.out.println("2");
						kursStore.addKurs(KursToAdd);
					} catch (Exception e){
			            throw new StoreException(e);
			        }
	    }
	
	}
    
				//doGet(request, response);