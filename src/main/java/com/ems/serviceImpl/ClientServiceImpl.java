//package com.ems.serviceImpl;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.ems.dao.ClientDAO;
//import com.ems.entity.Client;
//import com.ems.service.ClientService;
//@Service
//@Transactional
//public class ClientServiceImpl implements ClientService{
//
//	@Autowired
//	ClientDAO   clientDao;
//	@Override
//	public void addClient(Client client) {
//		clientDao.addClient(client);
//	}
//
//	@Override
//	public List<Client> getAllClients() {
//	List<Client> clientList=clientDao.getAllClients();
//		return clientList;
//	}
//
//	@Override
//	public Client getAllProjectsByClientId(String clientId) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Client getClientByProjectId(String projectId) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public void updateClient(Client client) {
//		clientDao.updateClient(client);
//	}
//
//	@Override
//	public void deleteClientById(String clientId) {
//		clientDao.deleteClientById(clientId);
//	}
//
//	@Override
//	public boolean verifyClientEmail(String email) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public List<Client> getClientListWithContactPerson(String clientId) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Client getClientByClientId(String clientId) {
//		Client client=clientDao.getClientByClientId(clientId);
//		return client;
//	}
//}
