package com.general;

import java.util.List;

public interface Metodos {

	
	//operaciones que vamos a resolver
	String guardar(Object ob);
	String editar(Object ob);
	String eliminar(int id);
	Object buscar(int id);
	List mostrar();
	
}
