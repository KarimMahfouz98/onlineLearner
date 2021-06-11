package de.unidue.inf.is;
 
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import de.unidue.inf.is.domain.Kurs;
import de.unidue.inf.is.domain.Benutzer;
import de.unidue.inf.is.stores.KursStore;
 
 
 
/**
 * Einfaches Beispiel, das die Vewendung der Template-Engine zeigt.
 */
public final class ViewCourseServlet extends HttpServlet {
 
    private static final long serialVersionUID = 1L;
 
 
   
    KursStore kursStore = new KursStore();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
    	ArrayList <Kurs> list = new ArrayList <Kurs>();
    	ArrayList <Kurs> list2 = new ArrayList <Kurs>();
    	list = kursStore.viewMeineKurse();
    	list2 = kursStore.viewVerfuegbareKurse();
    	request.setAttribute("list", list );
    	request.setAttribute("list2", list2 );
        request.getRequestDispatcher("/view_main.ftl").forward(request, response);
    }
   
}
