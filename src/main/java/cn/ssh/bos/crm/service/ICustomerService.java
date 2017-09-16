package cn.ssh.bos.crm.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import cn.ssh.bos.crm.domain.Customers;

@Produces("*/*")
public interface ICustomerService {
	@GET
	@Path("/customer/findNoAssociation")
	@Produces({"application/xml","application/json"})
	public List<Customers> findNoAssociation();
	
	@GET
	@Path("/customer/findUserAssociation/{decidedzoneId}")
	@Consumes({"application/xml","application/json"})
	@Produces({"application/xml","application/json"})
	public List<Customers> findUserAssociation(@PathParam("decidedzoneId")String decidedzoneId);
	
	@GET
	@Path("/customer/getCustomerByTel/{telephone}")
	@Consumes({"application/xml","application/json"})
	@Produces({"application/xml","application/json"})
	public Customers getCustomerByTel(@PathParam("telephone")String telephone);
	
	@GET
	@Path("/customer/findcustomerbyaddress/{address}")
	@Consumes({"application/xml","application/json"})
	@Produces({"application/xml","application/json"})
	public Customers findcustomerbyaddress(@PathParam("address")String address);
	
	@PUT
	@Path("/customer/assigncustomerstodecidedzone/{decidezoneId}/{cids}")
	// /customer/1,2,3/dq001
	@Consumes({ "application/xml", "application/json" })
	public void assignedCustomerToDecidedZone(@PathParam("cids") String customerids, @PathParam("decidezoneId") String decidedZone_id);
	
	@PUT
	@Path("/customer/updateCustomerFromNotice/{customerId}/{address}")
	// /customer/1,2,3/dq001
	@Consumes({ "application/xml", "application/json" })
	public void updateCustomerFromNotice(@PathParam("customerId") String customerId, @PathParam("address") String address);
	
	@POST
	@Path("/customer/save/")
	@Consumes({ "application/xml", "application/json" })
	@Produces({"application/xml","application/json"})
	public Customers save(Customers customers);
}
