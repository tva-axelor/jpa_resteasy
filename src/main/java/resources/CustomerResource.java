package resources;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import controller.CustomerController;
import dao.Car;
import dao.Customer;

@Path("/hello")
public class CustomerResource{
	private static EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("Taxil");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	CustomerController customerController=new CustomerController();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Customer> customer() {
		Query query=entityManager.createQuery("select s from Customer s");
		List<Customer>customers=query.getResultList();
		return customers;
	}
	
	@GET
	@Path("/customer/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public String getCustomerById(@PathParam("id") int id) {
		Customer customer=entityManager.find(Customer.class, id);
		return customer.getName();
	}
	@GET
	@Path("/addCust")
//	@Produces(MediaType.TEXT_PLAIN)
	public String addCustomer(@QueryParam("name") String name,@QueryParam("mobile") String mobile,@QueryParam("carname") String carname,@QueryParam("carmodel") String carmodel) {
		
		customerController.addCustomer(name, mobile, carname, carmodel);
		return "added";
		
	}
	
	@PUT
	@Path("/updateName")
	public String updatename(@QueryParam("id") int id,@QueryParam("name") String name) {
		customerController.updateCustomerName(id, name);
		return "Name updated";
	}
	
	@DELETE
	@Path("/deleteCustomer")
	public String deleteCustomer(@QueryParam("id") int id) {
		customerController.deleteCustomer(id);
		return "Deleted";
	}
}
