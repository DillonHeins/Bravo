package reporting;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import ejb.*;
import entity.*;

public class LifeCycleStateTest {
	private PersonServiceBean person;
	private PublicationServiceBean publication;
	
	
	@Before
	public void setUp() {
		/*emf = Persistence.createEntityManagerFactory("reporting");
		em = emf.createEntityManager();*/
	}
	
	@Test
	public void testPersonGet() {
		Person p = person.getPersonByID(1);
		Assert.assertNotNull(p);
	}
	
	@Test
	public void testPublicationsGet() {
		Person p = person.getPersonByID(1);
		List<Publication> pubs = publication.getPublcationsByPerson(p);
		Assert.assertNotNull(pubs);
	}
}

/*public class EmployeeFacadeServiceBean implements EmployeeFacadeService  {  
	protected EmployeeFacade employeeFacade ;                                 
	//Uses setter injection       
	public void setEmployeeFacade(EmployeeFacade employeeFacade) {     
		this.employeeFacade = employeeFacade;  
		}      
	
	public Employee addEmployee(String empName, Double sal){      
		return (Employee) this.employeeFacade.addEmployee(empName, sal);     
		}
	
	public Employee findEmployeeByEmpNo(Long empNo) {   
		return (Employee) this.employeeFacade.findEmployeeByEmpNo(empNo);   
		}
	}*/

/*@EJB(name="ejb/EmployeeFacade",beanInterface=oracle.ejb30.EmployeeFacade.class) 
public class InsertServlet extends HttpServlet  {   
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException   {   
		             EmployeeFacadeServiceBean es = (EmployeeFacadeServiceBean) appContext.getBean("employeeFacadeService");             
		             Employee emp = es.addEmployee(name,sal);             
		             System.out.println("Successfully persisted an employee");   
		              }   
		               }
}*/

/*@Stateless 
public class EmployeeFacadeBean  implements EmployeeFacade { 
	@PersistenceContext    
	private EntityManager em;        
	public Employee addEmployee(String empName, double sal) {     
		Employee emp = new Employee();          
		emp.setName(empName);        
		emp.setSal(sal);        
		em.persist(emp);         
		return emp;      
		}    
	
	public Employee findEmployeeByEmpNo(Long empNo){       
		return em.find(Employee.class,empNo); 
		}  
	}*/
