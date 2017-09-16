package cn.ssh.bos.crm.dao.customer;

import java.util.List;

import cn.ssh.bos.crm.domain.Customers;

public interface ICustomerDao {

	public List<Customers> findNoAssociationCustomers();
	
	
	public List<Customers> findInUseAssociationCustomers(String id);

	public void updateCustomerByDidToNUll(String decidedZone_id);


	public Customers findById(Integer id);


	public void updateCustomerByDidToDid(Integer id, String decidedZone_id);


	public Customers getCustomerByTel(String telephone);


	public void updateCustomerFromNotice(String customerId, String address);


	public Customers saveCustomer(Customers customers);


	public Customers findcustomerbyaddress(String address);




	
	
	
}
