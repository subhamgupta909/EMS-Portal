package com.ems.dao;

import java.util.List;

import com.ems.entity.ContactPerson;

public interface ContactPersonDAO {
 
	public void addContactPerson(ContactPerson contactPerson);
	public List<ContactPerson> getAllContactPersons();
	public void deleteContactPerson(Integer contactPersonId);
	public void updateContactPerson(ContactPerson contactPerson);
	public List<ContactPerson>  findContactPersonsByClientId(String clientId);

	public ContactPerson findContactPersonById(Integer id);
	public void assignContactPersonToClient(String clientId,Integer contactPersonId);
}
