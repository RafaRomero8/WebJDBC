package com.dto;

import java.util.List;

public class ProductosPorCliente {
	
	
	//para que se muestre solo una vez el nombre del cliente
	
	String cliente;
	List<ProductosPorVentaCliente_DTO> detalles;
	int totalArticulosVendidos;
	
	public ProductosPorCliente() {}
	
	public ProductosPorCliente(String cliente, List<ProductosPorVentaCliente_DTO> detalles,int totalArticulosVendidos) {
		//super();
		this.cliente = cliente;
		this.detalles = detalles;
		this.totalArticulosVendidos = totalArticulosVendidos;
	}
	
	public String getCliente() {
		return cliente;
	}
	
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	
	public List<ProductosPorVentaCliente_DTO> getDetalles() {
		return detalles;
	}
	
	public void setDetalles(List<ProductosPorVentaCliente_DTO> detalles) {
		this.detalles = detalles;
	}

	public int getTotalArticulosVendidos() {
		return totalArticulosVendidos;
	}

	public void setTotalArticulosVendidos(int totalArticulosVendidos) {
		this.totalArticulosVendidos = totalArticulosVendidos;
	}

	@Override
	public String toString() {
		return "ProductosPorCliente [cliente=" + cliente + ", detalles=" + detalles + ", totalArticulosVendidos="
				+ totalArticulosVendidos + "]";
	}
	
	
	
	
	
	
	
}
