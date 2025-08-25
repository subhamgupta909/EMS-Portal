package com.ems.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.ems.dao.ContactPersonDAO;
import com.ems.entity.ContactPerson;
@Repository
public class ContactPersonDAOImpl implements ContactPersonDAO {

	@Autowired
	HibernateTemplate hTemplate;
	@Override
	public void addContactPerson(ContactPerson contactPerson) {
		hTemplate.save(contactPerson);
	}

	@Override
	public void deleteContactPerson(Integer contactPersonId) {
		ContactPerson  cp=hTemplate.get(ContactPerson.class, contactPersonId);
		hTemplate.delete(cp);
	}

	@Override
	public void updateContactPerson(ContactPerson contactPerson) {
        ContactPerson  cp=hTemplate.load(ContactPerson.class,contactPerson.getId());
       if(cp!=null) {
        cp.setName(contactPerson.getName());
        cp.setEmail(contactPerson.getEmail());
        cp.setPhone(contactPerson.getPhone());
        cp.setDesignation(contactPerson.getDesignation());
        cp.setClient(contactPerson.getClient());

        hTemplate.update(cp); 
       }
	}

	@Override
	public List<ContactPerson> getAllContactPersons() {
		List<ContactPerson>  contactList=hTemplate.loadAll(ContactPerson.class);
		return contactList;
	}

	@Override
	public void assignContactPersonToClient(String clientId, Integer contactPersonId) {
	   
	}

	@Override
	public ContactPerson findContactPersonById(Integer id) {
		ContactPerson cp=hTemplate.get(ContactPerson.class, id);
		return cp;
	}

	@Override
	public List<ContactPerson> findContactPersonsByClientId(String clientId) {
	    String hql = "FROM ContactPerson cp WHERE cp.client.userId = :clientId";
	    List<ContactPerson> cpList = (List<ContactPerson>) hTemplate.findByNamedParam(
	            hql,
	            "clientId",
	            clientId
	    );
	    return cpList;
	}
}