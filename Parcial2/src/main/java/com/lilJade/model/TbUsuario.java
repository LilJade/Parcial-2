package com.lilJade.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tb_usuario database table.
 * 
 */
@Entity
@Table(name="tb_usuario")
@NamedQuery(name="TbUsuario.findAll", query="SELECT t FROM TbUsuario t")
public class TbUsuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String contra;

	private String usser;

	public TbUsuario() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContra() {
		return this.contra;
	}

	public void setContra(String contra) {
		this.contra = contra;
	}

	public String getUsser() {
		return this.usser;
	}

	public void setUsser(String usser) {
		this.usser = usser;
	}

}