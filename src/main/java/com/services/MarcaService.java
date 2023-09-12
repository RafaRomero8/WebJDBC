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


import com.dao.MarcasDAO;
import com.entity.Marcas;
import com.general.Status;



@Path("marcas/")
public class MarcaService {

	Marcas marca = null;
	MarcasDAO dao = null;

	@Path("guardar")
	@POST
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Status guardar(Marcas marca) {

		Status status = new Status();
		status.setObject(marca);
		dao = new MarcasDAO();

		String respuesta = dao.guardar(marca);

		if (respuesta.equals("1")) {

			status.setMensaje("Service OK");
			status.setRespuesta(respuesta);

		} else {

			status.setMensaje("Service Error");
			status.setRespuesta(respuesta);
		}

		return status;
	}

	@Path("editar")
	@POST
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Status editar(Marcas marca) {

		Status status = new Status();
		status.setObject(marca);
		dao = new MarcasDAO();

		String respuesta = dao.editar(marca);

		if (respuesta.equals("1")) {

			status.setMensaje("Service OK");
			status.setRespuesta(respuesta);

		} else {

			status.setMensaje("Service Error");
			status.setRespuesta(respuesta);
		}

		return status;
	}

	@Path("eliminar/{id}")
	@GET
	@Produces({ MediaType.APPLICATION_JSON })

	public Status eliminar(@PathParam("id") int id) {

		Status status = new Status();
		dao = new MarcasDAO();
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
	
	@Path("buscar-por-id/{id}")
	@GET 
	@Produces({MediaType.APPLICATION_JSON})
	public Marcas buscar(@PathParam("id") int id) {
		dao = new MarcasDAO();
		marca = (Marcas) dao.buscar(id);
	
		return marca;
	}
	
	@Path("mostrar")
	@GET 
	@Produces({MediaType.APPLICATION_JSON})
	
	public List<Marcas> mostrar(){
		
		 dao = new MarcasDAO();
		 List<Marcas> marcas = new ArrayList<Marcas>();
		 marcas = dao.mostrar();
		 
		 return marcas;		 
	}
	
	
	

}
