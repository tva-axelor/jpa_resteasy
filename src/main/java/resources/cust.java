package resources;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import org.jboss.resteasy.annotations.Form;

import controller.CustomerController;

@Path("/cust")
public class cust {
	@FormParam("name")
	private String name;
	@FormParam("mobile")
	private String mobile;
	@FormParam("car")
	private String carname;
	@FormParam("model")
	private String carmodel;
	
//	@POST
//	@Path("/addCust")
//	public String addCustomer(@FormParam ("name") String name,@FormParam ("mobile") String mobile,@FormParam ("car") String carname,@FormParam ("model") String carmodel) {
//		CustomerController customerController=new CustomerController();
//		customerController.addCustomer(name, mobile, carname, carmodel);
//		return "added";
//		
//	}
	@POST
	@Path("/addCust")
	public String addCustomer(@Form cust cust) {
		CustomerController customerController=new CustomerController();
		customerController.addCustomer(cust.name, cust.mobile, cust.carname, cust.carmodel);
		return "added";
	}
}
