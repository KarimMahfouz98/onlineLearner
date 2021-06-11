package de.unidue.inf.is;
 
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import de.unidue.inf.is.domain.Kurs;
import de.unidue.inf.is.domain.Aufgabe;
import de.unidue.inf.is.stores.KursStore;
import de.unidue.inf.is.stores.StoreException;
 
 
 
/**
 * Einfaches Beispiel, das die Vewendung der Template-Engine zeigt.
 */
public final class ViewCourseInfoServlet extends HttpServlet {
 
    private static final long serialVersionUID = 1L;
 
 
   
    KursStore kursStore = new KursStore();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
    	 Kurs courseToview = new Kurs();
    	
    	 courseToview = kursStore.viewKurs(5);
    	 System.out.println(courseToview.getName());
    	 ArrayList<Aufgabe> assignmentsToview = new ArrayList<Aufgabe>(); 
    	 assignmentsToview = kursStore.viewAssignments(5);
    	 boolean e;
    	 e = kursStore.isEnrolled(3);
    	 request.setAttribute("enrolled", e );
    	request.setAttribute("course", courseToview );
    	request.setAttribute("assignments", assignmentsToview );
    	
 
        request.getRequestDispatcher("/view_course.ftl").forward(request, response);
    }   



protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
IOException {   	
				if (request.getParameter("action").equals("delete")) {
					KursStore k = new KursStore();
					
					try {
						System.out.println("1");
						k.deleteKurs(1);
						k.close();
					} catch (Exception e){
			            throw new StoreException(e);
			        }
				}	
    }

}