package com.entity;

public class Marcas {
	
	private int marcaId;
	private String nombre;
	private String pais;
	
	public Marcas() {
		
	}
	
	public Marcas(int marcaId, String nombre, String pais) {
		//super();
		this.marcaId = marcaId;
		this.nombre = nombre;
		this.pais = pais;
	}


	public int getMarcaId() {
		return marcaId;
	}


	public void setMarcaId(int marcaId) {
		this.marcaId = marcaId;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getPais() {
		return pais;
	}


	public void setPais(String pais) {
		this.pais = pais;
	}


	@Override
	public String toString() {
		return "Marcas [marcaId=" + marcaId + ", nombre=" + nombre + ", pais=" + pais + "]";
	}
	
	

}
