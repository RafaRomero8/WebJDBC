package com.dto;

public class ProductosPorDepartamento_DTO {
	
	
	private String nombrePro;
	private char refrigerado;
	private int stock;
	private double descuento;
	
	ProductosPorDepartamento_DTO(){}

	public ProductosPorDepartamento_DTO(String nombrePro, char refrigerado, int stock, double descuento) {
		super();
		this.nombrePro = nombrePro;
		this.refrigerado = refrigerado;
		this.stock = stock;
		this.descuento = descuento;
	}


	public String getNombrePro() {
		return nombrePro;
	}

	public void setNombrePro(String nombrePro) {
		this.nombrePro = nombrePro;
	}

	public char getRefrigerado() {
		return refrigerado;
	}

	public void setRefrigerado(char refrigerado) {
		this.refrigerado = refrigerado;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public double getDescuento() {
		return descuento;
	}

	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}

	@Override
	public String toString() {
		return "ProductosPorDepartamento_DTO [nombrePro=" + nombrePro + ", refrigerado=" + refrigerado + ", stock="
				+ stock + ", descuento=" + descuento + "]";
	}	
	
	
	

}
