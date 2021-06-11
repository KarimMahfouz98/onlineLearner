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
import de.unidue.inf.is.domain.Einschreiben;
import de.unidue.inf.is.stores.KursStore;
import de.unidue.inf.is.stores.StoreException;
import de.unidue.inf.is.utils.DBUtil;




public final class EnrollServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       	 Kurs courseToview = new Kurs();
       	 KursStore kursStore = new KursStore();
     	 courseToview = kursStore.viewKurs(1);
     	 System.out.println(courseToview.getName());
     	request.setAttribute("Name", courseToview );
     	kursStore.close();
		request.getRequestDispatcher("/enroll.ftl").forward(request, response);
    	}
    
    		
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
    IOException { 
    				System.out.println("Inside doPost!!!!!");
					String einschreibeschluessel = request.getParameter("key");
					System.out.println(request.getParameter("key"));
					
					try {
						System.out.println("1");
						KursStore kursStore = new KursStore();
						System.out.println("2");
						kursStore.enrollIn(1, einschreibeschluessel);
						System.out.println("3");
						kursStore.close();
					} catch (Exception e){
			            throw new StoreException(e);
			        }
	    }
	
	}
