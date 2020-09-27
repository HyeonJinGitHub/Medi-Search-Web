package hyeonjin.listener;

import java.util.ArrayList;


import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import hyeonjin.domain.MedicineVO;
import hyeonjin.persistence.MedicineDAO;
/**
 * Application Lifecycle Listener implementation class InitialMedicine
 *
 */
@WebListener
public class InitialMedicine implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public InitialMedicine() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    	ServletContext context = sce.getServletContext();
    	ArrayList<MedicineVO> datas = new ArrayList<MedicineVO>();
    	MedicineDAO medicineDAO = new MedicineDAO();
    	
    	datas = medicineDAO.getMedicineList();
    	context.setAttribute("medicines", datas);
    	context.setAttribute("total", datas.size());
    }
	
}
