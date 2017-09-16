package cn.ssh.bos.crm.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.ssh.bos.crm.dao.customer.ICustomerDao;
import cn.ssh.bos.crm.domain.Customers;
@Service("customerService")
@Transactional
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	private ICustomerDao customerDao;
	
	@Override
	public List<Customers> findNoAssociation() {
		// TODO Auto-generated method stub
		return customerDao.findNoAssociationCustomers();
	}

	@Override
	public List<Customers> findUserAssociation(String decidedzoneId) {
		// TODO Auto-generated method stub
		return customerDao.findInUseAssociationCustomers(decidedzoneId);
	}

	@Override
	public void assignedCustomerToDecidedZone(String customerids, String decidedZone_id) {
		customerDao.updateCustomerByDidToNUll(decidedZone_id);
		System.out.println(customerids);
		if ("none".equalsIgnoreCase(customerids)) {
			return;
		}
		if (StringUtils.isNoneBlank(customerids)) {
			String[] cid = customerids.split(",");
			for (String id : cid) {
				customerDao.updateCustomerByDidToDid(Integer.parseInt(id),decidedZone_id);
			}
		}
	}

	@Override
	public Customers getCustomerByTel(String telephone) {
		// TODO Auto-generated method stub
		
		return customerDao.getCustomerByTel(telephone);
	}

	@Override
	public void updateCustomerFromNotice(String customerId, String address) {
		// TODO Auto-generated method stub
		customerDao.updateCustomerFromNotice(customerId,address);
	}

	@Override
	public Customers save(Customers customers) {
		// TODO Auto-generated method stub
		return customerDao.saveCustomer(customers);
	}

	@Override
	public Customers findcustomerbyaddress(String address) {
		// TODO Auto-generated method stub
		return customerDao.findcustomerbyaddress(address);
	}

}
