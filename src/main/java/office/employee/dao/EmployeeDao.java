package office.employee.dao;



import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import office.employee.dto.Employee;

@Component
public class EmployeeDao {
	
	@Autowired
	private EntityManager em;
	
	public void saveEmployee(Employee employee) {
		em.getTransaction().begin();
		em.persist(employee);
		em.getTransaction().commit();
		
	}
	
	public List<Employee> getAllEmployee(){
		Query query = em.createQuery("select e from Employee e");
		List<Employee> employees= query.getResultList();
		return employees;
	}
	
}
