package com.general;

public class Database {
	
	private String url;
	private String driver;
	private String user;
	private String password;
	
	public Database() {
		
		//datos min de conexion
		this.url="jdbc:oracle:thin:@localhost:1521:xe";//direccion desde java para conectar a la BD
		//xe:es la instancia  de la BD
		this.driver="oracle.jdbc.OracleDriver";//sirve para que busque ciertas clases que por default no vienen en jdbk
		//decirle donde esta la ruta de la clase
		this.user="Rafa2";
		this.password="System";
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	

}
