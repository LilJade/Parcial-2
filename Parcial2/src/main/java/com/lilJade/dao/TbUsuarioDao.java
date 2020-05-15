package com.lilJade.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.lilJade.model.TbUsuario;

public class TbUsuarioDao {
	public List<TbUsuario> logInUser(TbUsuario tbu){
		List<TbUsuario> user = new ArrayList();
		EntityManager em;
		EntityManagerFactory emf;
		emf = Persistence.createEntityManagerFactory("Parcial2");
		em = emf.createEntityManager();
		
		try {
			em.getTransaction().begin();
			
			user = em.createQuery("from TbUsuario as u where u.usser='"+tbu.getUsser()+"' and u.contra='"+tbu.getContra()+"'").getResultList();
			em.getTransaction().commit();
			
			for(TbUsuario datoId:user) {
				tbu.setId(datoId.getId());
			}
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
		
		return user;
	}
}
