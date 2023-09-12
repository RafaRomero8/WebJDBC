package com.general;


public class Status {
	
	private Object object;
	private String mensaje;
	private String respuesta;
	
	public Status() {
		
	}

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}

	@Override
	public String toString() {
		return "Status [object=" + object + ", mensaje=" + mensaje + ", respuesta=" + respuesta + "]";
	}
	
	
	

}
