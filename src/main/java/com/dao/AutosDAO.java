package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.dto.ProductosPorCliente;
import com.dto.ProductosPorDepartamento;
import com.dto.ProductosPorDepartamento_DTO;
import com.dto.ProductosPorVentaCliente_DTO;
import com.entity.Autos;
import com.general.Database;
import com.general.Metodos;

//DONDE SE RESULEVEN LAS CONSULTAS
//DATA ACCES OBJECT(DAO)
//AQUI AGREGAMOS LAS CONSULTAS
public class AutosDAO implements Metodos {

	Connection con = null;// llave a la conexion o abre la conexion
	PreparedStatement ps = null;// hacerle llegar las instrucciones,entrada de instrucciones
	ResultSet rs = null;// salida de los resultados,captura/salida de resultados

	String resultado;//
	Autos auto = null;//
	Database db = new Database();

	@Override
	public String guardar(Object ob) {
		// este objeto es generico
		auto = (Autos) ob;// casteo es una conversion directa

		String query = "INSERT INTO AUTOS VALUES(?,?,?,?,?)";
		// maracdores de posicion,son las columnas de la tabla de la BD

		//
		try {
			// abrir la conexion
			Class.forName(db.getDriver());// va el driver
			con = DriverManager.getConnection(db.getUrl(), db.getUser(), db.getPassword());
			ps = con.prepareStatement(query);// recibe un argumento un query,la instruccion
			// para que se interprete commo una sentencia y NO como un string

			// recurrimos a los getter y setter para traer los datos del objeto que
			// casteamos
			// toma los campos de la base de datos o las variables que creamos en la clase
			// Autos
			ps.setInt(1, 0);// aqui toma el id de la tabla Autos de la BD
			ps.setString(2, auto.getModelo());
			ps.setInt(3, auto.getAño());
			ps.setDouble(4, auto.getPrecio());
			ps.setInt(5, auto.getMarcaId());

			// ejecutar la consulta,
			int x = ps.executeUpdate();// devolver un conteo de cuantas filas afecto
			// devulve un valor entero en caso de que salga bien(valor de 1)

			if (x > 0) {
				System.out.println("Guardado OK");
				resultado = "1";
			} else {
				System.out.println("Error al guardar");
				resultado = "0";
			}

		} catch (Exception ex) {
			resultado = ex.getMessage();

		}

		return resultado;
	}

	@Override
	public String editar(Object ob) {
		// Class.forName(db.getDriver());
		auto = (Autos) ob;
		String update = "UPDATE AUTOS SET MODELO = ?, AÑO = ?, PRECIO = ?,MARCA_ID = ? WHERE AUTO_ID = ?";

		try {
			Class.forName(db.getDriver());
			con = DriverManager.getConnection(db.getUrl(), db.getUser(), db.getPassword());
			ps = con.prepareStatement(update);

			ps.setString(1, auto.getModelo());
			ps.setInt(2, auto.getAño());
			ps.setDouble(3, auto.getPrecio());
			ps.setInt(4, auto.getMarcaId());
			ps.setInt(5, auto.getAutoId());

			int x = ps.executeUpdate();

			if (x > 0) {
				System.out.println("Actualizar OK");
				resultado = "1";
			} else {
				System.out.println("Error al actualizar");
				resultado = "0";
			}

		} catch (Exception ex) {
			resultado = ex.getMessage();

		}
		return resultado;
	}

	@Override
	public String eliminar(int id) {

		String delete = "DELETE FROM AUTOS WHERE AUTO_ID=" + id;

		try {
			Class.forName(db.getDriver());
			con = DriverManager.getConnection(db.getUrl(), db.getUser(), db.getPassword());
			ps = con.prepareStatement(delete);

			int x = ps.executeUpdate();
			if (x > 0) {
				System.out.println("Eliminacion OK");
				resultado = "1";
			} else {
				System.out.println("Error al eliminar");
				resultado = "0";
			}

		} catch (Exception ex) {

			resultado = ex.getMessage();
		}

		return resultado;

	}

	@Override
	public Object buscar(int id) {

		String select = "SELECT * FROM AUTOS WHERE AUTO_ID=" + id;

		try {

			Class.forName(db.getDriver());
			con = DriverManager.getConnection(db.getUrl(), db.getUser(), db.getPassword());
			ps = con.prepareStatement(select);

			// la operacion de buscar no requiere de una transaccion
			rs = ps.executeQuery();// solo es de lectura por eso ponemos Query

			while (rs.next()) {// next preguntamos si hay una fila despues

				// creamos el objeto,con los datos de la BD
				auto = new Autos(rs.getInt("AUTO_ID"), rs.getString("MODELO"), rs.getInt("AÑO"), rs.getDouble("PRECIO"),
						rs.getInt("MARCA_ID"));
			}

		} catch (Exception ex) {
			System.out.println("Error al buscar.....");
			ex.printStackTrace();

		}

		return auto;
	}

	@Override
	public List mostrar() {

		String select = "SELECT * FROM AUTOS";
		List<Autos> autos = new ArrayList<Autos>();

		try {

			Class.forName(db.getDriver());
			con = DriverManager.getConnection(db.getUrl(), db.getUser(), db.getPassword());
			ps = con.prepareStatement(select);

			// la operacion de buscar no requiere de una transaccion
			rs = ps.executeQuery();// solo es de lectura por eso ponemos Query

			while (rs.next()) {// next preguntamos si hay una fila despues

				auto = new Autos(rs.getInt("AUTO_ID"), rs.getString("MODELO"), rs.getInt("AÑO"), rs.getDouble("PRECIO"),
						rs.getInt("MARCA_ID"));
				// en cada iteracion va construyendo un objeto y lo guarda a la lista
				autos.add(auto);
			}

		} catch (Exception ex) {
			System.out.println("Error al buscar.....");
			ex.printStackTrace();

		}

		return autos;
	}

	public ProductosPorCliente getProductos(String cliente) {

		String nombreCliente = "";
		ProductosPorCliente dto = null;// va almacenar una fila a la vez
		ProductosPorVentaCliente_DTO detalle = null;
		int totalArticulosVendidos = 0;

		List<ProductosPorVentaCliente_DTO> compras = new ArrayList<ProductosPorVentaCliente_DTO>();

		String query = "SELECT P.NOMBRE,P.FECHA_CAD,V.FECHA_VENTA,DV.CANTIDAD,C.NOMBRE AS CLIENTE "
				+ "FROM PRODUCTOS P INNER JOIN DET_VENTA DV " + "ON P.PRODUCTO_ID=DV.PRODUCTO_ID "
				+ "INNER JOIN VENTAS V " + "ON V.VENTA_ID=DV.VENTA_ID " + "INNER JOIN CUSTOMERS C "
				+ "ON V.CUSTOMER_ID=C.CUSTOMER_ID WHERE C.NOMBRE = '" + cliente + "'";

		try {

			Class.forName(db.getDriver());
			con = DriverManager.getConnection(db.getUrl(), db.getUser(), db.getPassword());
			ps = con.prepareStatement(query);

			rs = ps.executeQuery();

			while (rs.next()) {

				detalle = new ProductosPorVentaCliente_DTO(rs.getString("NOMBRE"),
						                                   rs.getDate("FECHA_CAD"),
					                                       rs.getDate("FECHA_VENTA"),
                                                           rs.getInt("CANTIDAD"));
				compras.add(detalle);
				nombreCliente = rs.getString("CLIENTE");
				totalArticulosVendidos = totalArticulosVendidos + rs.getInt("CANTIDAD");

			}

			dto = new ProductosPorCliente(nombreCliente, compras, totalArticulosVendidos);

		} catch (Exception ex) {
			System.out.println("Error al buscar.....");
			ex.printStackTrace();

		}

		return dto;
	}
	
	
	
	public ProductosPorDepartamento getDepa(String departamento) {
		
		String nombreDepartamento = "";
		ProductosPorDepartamento dto = null;// va almacenar una fila a la vez
		ProductosPorDepartamento_DTO productos = null;
		//double descuento = 0.15;

		List<ProductosPorDepartamento_DTO> departamentos = new ArrayList<ProductosPorDepartamento_DTO>();
		String query = "SELECT D.NOMBRE AS NOMBRE_DEP,P.NOMBRE AS NOMBRE_PRO,P.REFRIGERADO,S.STOCK,P.PRECIO_VENTA * 0.15 AS DESCUENTO " + 
				"FROM DEPARTAMENTO D INNER JOIN PRODUCTOS P " + 
				"ON D.DEPTO_ID = P.DEPTO_ID " + 
				"INNER JOIN INVENTARIO S " + 
				"ON P.PRODUCTO_ID = S.PRODUCTO_ID " + 
				"WHERE D.NOMBRE = '" + departamento + "'";
		
		try {
			
			Class.forName(db.getDriver());
			con = DriverManager.getConnection(db.getUrl(), db.getUser(), db.getPassword());
			ps = con.prepareStatement(query);

			rs = ps.executeQuery();
			
			while (rs.next()) {
				
				productos = new ProductosPorDepartamento_DTO(rs.getString("NOMBRE_PRO"),rs.getString("REFRIGERADO").charAt(0),rs.getInt("STOCK"),rs.getDouble("DESCUENTO"));
				departamentos.add(productos);
				nombreDepartamento= rs.getString("NOMBRE_DEP");
			}
			
			dto = new ProductosPorDepartamento(nombreDepartamento,departamentos); 
		}catch(Exception ex) {
			System.out.println("Error al buscar.....");
			ex.printStackTrace();
			
		}
				
		return dto;
	}
	
	
	
	

}
