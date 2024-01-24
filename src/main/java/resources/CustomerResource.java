package resources;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dao.Customer;

@Path("/customer")
public class CustomerResource{
	private static EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("Taxil");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String customer() {
//		Query query=entityManager.createQuery("select s from Customer s");
//		List<Customer>customers=query.getResultList();
//		Customer customer=customers.get(0);
//		Customer customer=entityManager.find(Customer.class, 1);
//		System.out.println(customer.getName());
//		return "Id: "+customer.getId()+"Name: "+customer.getName()+"Mobile no: "+customer.getMobile_No()+"Cars: "+customer.getCar();
		return "Hello";
	}
}
