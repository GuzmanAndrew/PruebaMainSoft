package com.test.jax.controllers;

import com.test.jax.daos.BancoDao;
import com.test.jax.entities.Banco;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("/bancos")
@Produces("application/json")
public class BancoCtrl {
	
	BancoDao bancoService = new BancoDao();

	@GET
	@Path("/lista")
	public Response listBancos() {
	    return Response.ok().entity(this.bancoService.listBancos()).build();
	}

    @GET
    @Path("/banco/{id}")
    public Response bancoById(@PathParam("id") int id) {
        return Response.ok().entity(this.bancoService.bancoId(id)).build();
    }

    @DELETE
    @Path("/lista/{id}")
    public Response delete(@PathParam("id") Integer id) {
        bancoService.eliminarBanco(id);
        return Response.ok().entity("Banco deleted successfully !!").build();
    }

    @POST
    @Path("/lista/agregar")
    public Response create(Banco banco) {
        return Response.ok().entity(bancoService.guardarBanco(banco)).build();
    }

    @PUT
    @Path("/actualizar/{id}")
    public Response update(@PathParam("id") Integer id, Banco banco ){
        bancoService.actualizarBanco(banco, id);
        return Response.noContent().build();
    }
}

