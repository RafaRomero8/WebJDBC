package com.dto;

import java.sql.Date;

public class ProductosPorVentaCliente_DTO {
	
	//mapeaR a una tabla virtual
	
	private String nombreProducto;
	private Date fechaCad;
	private Date fechaVenta;
	private int cantidad;

	
	public ProductosPorVentaCliente_DTO(){
		
	}
	
	public ProductosPorVentaCliente_DTO(String nombreProducto, Date fechaCad, Date fechaVenta, int cantidad) {
		//super();
		this.nombreProducto = nombreProducto;
		this.fechaCad = fechaCad;
		this.fechaVenta = fechaVenta;
		this.cantidad = cantidad;
		
	}
	
	
	

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public Date getFechaCad() {
		return fechaCad;
	}

	public void setFechaCad(Date fechaCad) {
		this.fechaCad = fechaCad;
	}

	public Date getFechaVenta() {
		return fechaVenta;
	}

	public void setFechaVenta(Date fechaVenta) {
		this.fechaVenta = fechaVenta;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public String toString() {
		return "ProductosPorVentaCliente_DTO [nombreProducto=" + nombreProducto + ", fechaCad=" + fechaCad
				+ ", fechaVenta=" + fechaVenta + ", cantidad=" + cantidad + "]";
	}
	
	

}
