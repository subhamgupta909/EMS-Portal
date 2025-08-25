//package com.ems.daoImpl;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.orm.hibernate5.HibernateTemplate;
//import org.springframework.stereotype.Repository;
//
//import com.ems.dao.ClientDAO;
//import com.ems.entity.Client;
//@Repository
//public class ClientDAOImpl implements ClientDAO {
//
//	@Autowired
//	HibernateTemplate hTemplate;
//	@Override
//	public void addClient(Client client) {
//		hTemplate.save(client);
//	}
//
//	@Override
//	public List<Client> getAllClients() {
//	List<Client>  clientList=hTemplate.loadAll(Client.class);	
//		return 	clientList;	
//			}
//
//	@Override
//	public Client getAllProjectsByClientId(String clientId) {
//        return null;
//	}
//
//	@Override
//	public void updateClient(Client client) {
//	    Client existing = hTemplate.get(Client.class, client.getClientId());
//	    
//	    if(existing != null) {
//	        existing.setClientName(client.getClientName());
//	        //existing.setEmail(client.getEmail());
//	        //existing.setRelationshipDate(client.getRelationshipDate());
//	        
//	        hTemplate.merge(existing);
//	    } else {
//	        throw new RuntimeException("Client not found with ID: " + client.getClientId());
//	    }
//	}
//
//	@Override
//	public void deleteClientById(String clientId) {
//		Client client=hTemplate.get(Client.class, clientId);
//		if(client!=null)
//		hTemplate.delete(client);
//		
//	}
//
//	@Override
//	public Client getClientByProjectId(String projectId) {
//		
//		return null;
//	}
//
//	@Override
//	public boolean verifyClientEmail(String email) {
//		return false;	}
//
//	@Override
//	public List<Client> getClientListWithContactPerson(String clientId) {
//		return new ArrayList<Client>();	}
//
//	@Override
//	public Client getClientByClientId(String clientId) {
//		Client client=hTemplate.get(Client.class, clientId);
//		return client;
//	}
//
//}
