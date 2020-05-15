package com.lilJade.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.lilJade.model.TbConsulta;

public class TbConsultaDao {

	TbConsulta tbc = new TbConsulta();
	
	public List<TbConsulta> listaConsulta(){
		List<TbConsulta> listaConsulta = new ArrayList<>();
		EntityManager em;
		EntityManagerFactory emf;
		emf = Persistence.createEntityManagerFactory("Parcial2");
		em = emf.createEntityManager();
		
		try {
			em.getTransaction().begin();
			listaConsulta = em.createQuery("from TbConsulta").getResultList();
			em.getTransaction().commit();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return listaConsulta;
	}
	
	public void actualizarConsulta(TbConsulta tbCon) {
		EntityManager em;
		EntityManagerFactory emf;
		emf = Persistence.createEntityManagerFactory("Parcial2");
		em = emf.createEntityManager();
		
		tbCon.getId();
		tbCon.getNombre();
		tbCon.getApellido();
		
		em.getTransaction().begin();
		em.merge(tbCon);
		em.flush();
		em.getTransaction().commit();
	}
	
	public void eliminarConsulta(TbConsulta tbCon){
		EntityManager em;
		EntityManagerFactory emf;
		emf = Persistence.createEntityManagerFactory("Parcial2");
		em = emf.createEntityManager();
		
		tbCon = em.getReference(TbConsulta.class, tbCon.getId());
		em.getTransaction().begin();
		em.remove(tbCon);
		em.flush();
		em.getTransaction().commit();
	}
}
