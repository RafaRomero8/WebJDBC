package com.entity;


//POJO(Plain Old Java Object)
//es una clase simple en java
//hacer un mapeo 


public class Autos {
	private int autoId;
	private String modelo;
	private int año;
	private double precio;
	private int marcaId;
	
	
	public Autos() {
		
	}
	
	public Autos(int autoId, String modelo, int año, double precio, int marcaId) {
		//super();
		this.autoId = autoId;
		this.modelo = modelo;
		this.año = año;
		this.precio = precio;
		this.marcaId = marcaId;
	}

	public int getAutoId() {
		return autoId;
	}

	public void setAutoId(int autoId) {
		this.autoId = autoId;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getAño() {
		return año;
	}

	public void setAño(int año) {
		this.año = año;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getMarcaId() {
		return marcaId;
	}

	public void setMarcaId(int marcaId) {
		this.marcaId = marcaId;
	}

	@Override
	public String toString() {
		return "Autos [autoId=" + autoId + ", modelo=" + modelo + ", año=" + año + ", precio=" + precio + ", marcaId="
				+ marcaId + "]";
	}
	
	
}
