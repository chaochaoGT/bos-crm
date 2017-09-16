package cn.ssh.bos.crm.dao.customer;

import java.io.Serializable;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import cn.ssh.bos.crm.domain.Customers;
@Repository("customerDao")
@SuppressWarnings("all")
public class CustomerDaoImpl extends HibernateDaoSupport implements ICustomerDao{
	@Autowired
	public void setSessionfactory(SessionFactory sessionFactory){
		super.setSessionFactory(sessionFactory);
	}

	@Override
	public List findNoAssociationCustomers() {
		// TODO Auto-generated method stub
		List<Customers> list = getHibernateTemplate().find("from Customers where decidedzoneId is  null");
		return list==null?null:list;
	}

	@Override
	public List findInUseAssociationCustomers(String id) {
		// TODO Auto-generated method stub
		List<Customers> list = getHibernateTemplate().find("from Customers where decidedzoneId=?",id);
		return list==null?null:list;
	}

	@Override
	public void updateCustomerByDidToNUll(String did) {
		// TODO Auto-generated method stub
		getSession().createQuery("update Customers set decidedzoneId=null where decidedzoneId=?")
		.setParameter(0, did).executeUpdate();
	}

	
	@Override
	public void updateCustomerByDidToDid(Integer id, String decidedZone_id) {
		// TODO Auto-generated method stub
			// 修改 update xxx set decidezoneid = ? where id = ? hql Query session
			getSession().createQuery("update Customers set decidedzoneId = ? where id = ?")
			.setParameter(0, decidedZone_id).setParameter(1, id).executeUpdate();
	}

	@Override
	public Customers findById(Integer id) {
		// TODO Auto-generated method stub
		return (Customers) getHibernateTemplate().find("from Customers where id=?",id);
	}

	@Override
	public Customers getCustomerByTel(String telephone) {
		// TODO Auto-generated method stub
		 List<Customers> list = getHibernateTemplate().find("from Customers where telephone=?",telephone);
		 return list.isEmpty() ? null : list.get(0);
	}

	@Override
	public void updateCustomerFromNotice(String customerId, String address) {
		// TODO Auto-generated method stub
		getSession().createQuery("update Customers set address = ? ,decidedzoneId=null where id = ?")
		.setParameter(0, address).setParameter(1, Integer.parseInt(customerId)).executeUpdate();
	}

	//保存
	public Customers saveCustomer(Customers customers) {
		// TODO Auto-generated method stub
		Serializable id = getHibernateTemplate().save(customers);
		customers.setId((Integer) id);
		return customers;
	}

	@Override
	public Customers findcustomerbyaddress(String address) {
		// TODO Auto-generated method stub
		 List<Customers> list = getHibernateTemplate().find("from Customers where address=?",address);
		 return list.isEmpty() ? null : list.get(0);
	}

}
