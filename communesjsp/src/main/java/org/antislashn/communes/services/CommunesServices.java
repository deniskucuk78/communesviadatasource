package org.antislashn.communes.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.antislashn.communes.dao.CommuneDAO;
import org.antislashn.communes.entities.Commune;

public class CommunesServices {
	
	private CommuneDAO dao;
	
	public CommunesServices(EntityManagerFactory emf)
	{
		dao = new CommuneDAO(emf);
	}
	
	
	public List<Commune> getCommunesByCodePostal(String codePostal)
	{
		return dao.getCommunesByCodePostal(codePostal);
	}
	
	

}
