package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.Autos;
import com.entity.Marcas;
import com.general.Database;
import com.general.Metodos;

public class MarcasDAO implements Metodos {
	
	Connection con= null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	
	String resultado;//
	Marcas marca = null;//
	Database db = new Database();
	
	
	@Override
	public String guardar(Object ob) {
		
		marca = (Marcas) ob;
		
		String query = "INSERT INTO MARCA VALUES(?,?,?)";
		
		try {
			
			Class.forName(db.getDriver());
			con = DriverManager.getConnection(db.getUrl(),db.getUser() ,db.getPassword());
			ps = con.prepareStatement(query);
			
			ps.setInt(1,0);
			ps.setString(2,marca.getNombre());
			ps.setString(3,marca.getPais());
			
			int x = ps.executeUpdate();
			
			if(x>0) {
				System.out.println("Guardado OK");
				resultado = "1";
			}else {
				System.out.println("Error al guardar");
				resultado = "0";
			}
			
			
		}catch(Exception ex) {
			resultado = ex.getMessage();
			
		}
		
		return resultado;
	}
	
	@Override
	public String editar(Object ob) {
		
		marca = (Marcas) ob;
		String  update = "UPDATE MARCA SET NOMBRE = ?, PAIS = ? WHERE MARCA_ID = ?";
		
		
		try {
			
			Class.forName(db.getDriver());
			con = DriverManager.getConnection(db.getUrl(),db.getUser() ,db.getPassword());
			ps = con.prepareStatement(update);
			
			ps.setString(1,marca.getNombre());
			ps.setString(2, marca.getPais());
			ps.setInt(3,marca.getMarcaId());
			
			int x = ps.executeUpdate();
						
			if(x>0) {
				System.out.println("Actualizar OK");
				resultado = "1";
			}else {
				System.out.println("Error al actualizar");
				resultado = "0";
			}
			
			
		}catch(Exception ex){
			
			resultado = ex.getMessage();	
		}
		
		return resultado;
		
	}

	@Override
	public String eliminar(int id) {
		String delete = "DELETE FROM MARCA WHERE MARCA_ID="+id;
		
		try {
			Class.forName(db.getDriver());
			con = DriverManager.getConnection(db.getUrl(),db.getUser() ,db.getPassword());
			ps = con.prepareStatement(delete);
			
			int x = ps.executeUpdate();
			if(x>0) {
				System.out.println("Eliminacion OK");
				resultado = "1";
			}else {
				System.out.println("Error al eliminar");
				resultado = "0";
			}
			
			
		}catch(Exception ex){
			
			resultado = ex.getMessage();
		}
		
		return resultado;
		
	}
	
	@Override
	public Object buscar(int id) {
		
	
		String select = "SELECT * FROM MARCA WHERE MARCA_ID="+ id;
		
		
		try {
			
			Class.forName(db.getDriver());
			con = DriverManager.getConnection(db.getUrl(),db.getUser() ,db.getPassword());
			ps = con.prepareStatement(select);
			
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				marca = new Marcas(rs.getInt("MARCA_ID"),rs.getString("NOMBRE"),rs.getString("PAIS"));
			}
			
		}catch(Exception ex) {
			System.out.println("Error al buscar.....");
			ex.printStackTrace();
			
		}
		
		return marca;
	}
	
	@Override
	public List mostrar() {
	
	  String select = "SELECT * FROM MARCA";
	List<Marcas> marcas = new ArrayList<Marcas>();
		
		try {
			
			Class.forName(db.getDriver());
			con = DriverManager.getConnection(db.getUrl(),db.getUser() ,db.getPassword());
			ps = con.prepareStatement(select);
			
		
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				marca = new Marcas(rs.getInt("MARCA_ID"),rs.getString("NOMBRE"),rs.getString("PAIS"));
				
				marcas.add(marca);
			}
			
		}catch(Exception ex) {
			System.out.println("Error al buscar.....");
			ex.printStackTrace();
			
		}
		
		return marcas;
	}
	
	
}
