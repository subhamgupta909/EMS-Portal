package com.ems.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ems.dao.ContactPersonDAO;
import com.ems.entity.ContactPerson;
import com.ems.service.ContactPersonService;
@Service
@Transactional
public class ContactPersonServiceImpl implements ContactPersonService {

	@Autowired
	ContactPersonDAO contactPersonDao;
	@Override
	public void addContactPerson(ContactPerson contactPerson) {
		contactPersonDao.addContactPerson(contactPerson);
		
	}

	@Override
	public List<ContactPerson> getAllContactPersons() {
		List<ContactPerson>  contactList=contactPersonDao.getAllContactPersons();
		return contactList;
	}

	@Override
	public void deleteContactPerson(Integer contactPersonId) {
        contactPersonDao.deleteContactPerson(contactPersonId);
		
	}

	@Override
	public void updateContactPerson(ContactPerson contactPerson) {
		contactPersonDao.updateContactPerson(contactPerson);
		
	}

	@Override
	public void assignContactPersonToClient(String clientId, Integer contactPersonId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ContactPerson findContactPersonById(Integer id) {
		ContactPerson cp=contactPersonDao.findContactPersonById(id);
		return cp;
	}

	@Override
	public List<ContactPerson> findContactPersonsByClientId(String clientId) {
		List<ContactPerson>  cpList=contactPersonDao.findContactPersonsByClientId(clientId);
		return cpList;
	}

}
