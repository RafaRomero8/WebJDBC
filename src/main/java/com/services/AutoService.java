package com.services;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.dao.AutosDAO;
import com.dto.ProductosPorCliente;
import com.dto.ProductosPorDepartamento;
import com.dto.ProductosPorVentaCliente_DTO;
import com.entity.Autos;
import com.general.Status;

//hacer la notacion path ,
//dependencias :son bibliotecas de codigo que no estan en el proyecto,digamos que son externas al proyecto
//buscar que dependencias se requiere

@Path("autos/")//define una direccion
public class AutoService {
	
	
	//capas son como los paquetes
	//las capas mas cercanas a la bd es el paqute emptity,la clase Auto
	
	//encapsular la logica al acceso a la bd,el paquete DAO
	
	
	
//	EN ESTA CALSE HAREMOS ENDPOINTS(SON COMO OPERACIONES),PARA ELEGIR QUE OPERACION QUEREMOS EJECUTAR
	//ES COMO UN MENU,
	
	Autos auto = null;
	AutosDAO dao = null;
	ProductosPorVentaCliente_DTO dto = null;
	
	// autos/guardar
	@Path("guardar")
	@POST    //accion de escritura
	@Consumes({MediaType.APPLICATION_JSON})//va a estar en formato JSON
	@Produces({MediaType.APPLICATION_JSON})
	
	public Status guardar(Autos auto) {
		
		//este metodo hace pasar un objeto de tipo auto
		//y responde un objeto de tipo status
		//es como una entrada y salida
		
		Status status = new Status();
		status.setObject(auto);
		dao = new AutosDAO();	//encapsula la logica de las operaciones de AutosDAO
		
		String respuesta = dao.guardar(auto);//recordemos que devuelve un string
		//la cual cachamos la respuesta en la variable respuesta
		
		//verificamos para ver en que capa hay un tip de error
		if(respuesta.equals("1")) {
			
			status.setMensaje("Service OK");
			status.setRespuesta(respuesta);
			
		}else {
						
			status.setMensaje("Service Error");
			status.setRespuesta(respuesta);
		}
		
		return status;
	}
	
	
	//------------------------------------------------------
	@Path("editar")
	@POST   
	@Consumes({MediaType.APPLICATION_JSON})//en que formato espera que el cliente 
	@Produces({MediaType.APPLICATION_JSON})//en que frmato debe de responder el servidor
	
	public Status editar(Autos auto) {

		// hacemos lo mismo para editar ,cambiamos el dao.guardar a dao.editar

		Status status = new Status();
		status.setObject(auto);
		dao = new AutosDAO();

		String respuesta = dao.editar(auto);

		if (respuesta.equals("1")) {

			status.setMensaje("Service OK");
			status.setRespuesta(respuesta);

		} else {

			status.setMensaje("Service Error");
			status.setRespuesta(respuesta);
		}

		return status;
	}
	
	//----------------------------------------------------------------------
	
	@Path("eliminar/{id}")//le mandamso un parametro(id) es el id del auto
	@GET    //para mandarle datos al servidor
	@Produces({MediaType.APPLICATION_JSON})//igual en formato JSON
	
	public Status eliminar(@PathParam("id") int id) {//debemos pasarle el patParam

		Status status = new Status();
		dao = new AutosDAO();
		String respuesta = dao.eliminar(id);

		if (respuesta.equals("1")) {

			status.setMensaje("Eliminacion OK");
			status.setRespuesta(respuesta);

		} else {

			status.setMensaje("Eliminacion  Error");
			status.setRespuesta(respuesta);
		}

		return status;

	}

	//--------------------------------------------------------------
	
	
	@Path("buscar-por-id/{id}")
	@GET 
	@Produces({MediaType.APPLICATION_JSON})
	public Autos buscar(@PathParam("id") int id) {
		dao = new AutosDAO();
		auto = (Autos) dao.buscar(id);
	
		return auto;
	}
	
	//------------------------------------------------------------------
	// http://localhost:8090/webjdbc_rrx/webjdbc_rrx/autos/mostrar   GET esto es el endpoint o la peticion del url
	@Path("mostrar")
	@GET 
	@Produces({MediaType.APPLICATION_JSON})
	
	public List<Autos> mostrar(){
		
		 dao = new AutosDAO();
		 List<Autos> autos = new ArrayList<Autos>();
		 autos = dao.mostrar();
		 
		 return autos;		 
	}
	
	//----------------------------------------------------
	
	@Path("productos/{cliente}")
	@GET 
	@Produces({MediaType.APPLICATION_JSON})

	public ProductosPorCliente getProductos(@PathParam("cliente") String cliente){
		
		 dao = new AutosDAO();
		 ProductosPorCliente productos = dao.getProductos(cliente);
		// productos  = dao.getProductos(cliente);
		 
		 return productos;		 
	}
	
	@Path("buscar/{departamento}")
	@GET 
	@Produces({MediaType.APPLICATION_JSON})

	public ProductosPorDepartamento getDepa(@PathParam("departamento") String departamento){
		
		 dao = new AutosDAO();
		 ProductosPorDepartamento departamentos = dao.getDepa(departamento);
		// productos  = dao.getProductos(cliente);
		 
		 return departamentos;		 
	}
	
	
}
