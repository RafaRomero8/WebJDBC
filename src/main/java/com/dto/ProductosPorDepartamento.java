package com.dto;

import java.util.List;

public class ProductosPorDepartamento {
	
	String departamento;
	List<ProductosPorDepartamento_DTO> productos;
	//double descuento;
	
	ProductosPorDepartamento(){}

	public ProductosPorDepartamento(String departamento, List<ProductosPorDepartamento_DTO> productos) {
		//super();
		this.departamento = departamento;
		this.productos = productos;
		//this.descuento = descuento;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public List<ProductosPorDepartamento_DTO> getProductos() {
		return productos;
	}

	public void setProductos(List<ProductosPorDepartamento_DTO> productos) {
		this.productos = productos;
	}

	@Override
	public String toString() {
		return "ProductosPorDepartamento [departamento=" + departamento + ", productos=" + productos + "]";
	}

//	public double getDescuento() {
//		return descuento;
//	}
//
//	public void setDescuento(double descuento) {
//		this.descuento = descuento;
//	}

	
	
	
}
