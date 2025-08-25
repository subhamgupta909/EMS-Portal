package com.ems.service;

import java.util.List;

import com.ems.entity.ContactPerson;

public interface ContactPersonService {
	public void addContactPerson(ContactPerson contactPerson);
	public List<ContactPerson> getAllContactPersons();
	public void deleteContactPerson(Integer contactPersonId);
	public void updateContactPerson(ContactPerson contactPerson);
	public ContactPerson findContactPersonById(Integer id);
	public List<ContactPerson>  findContactPersonsByClientId(String clientId);
	public void assignContactPersonToClient(String clientId,Integer contactPersonId);

}
