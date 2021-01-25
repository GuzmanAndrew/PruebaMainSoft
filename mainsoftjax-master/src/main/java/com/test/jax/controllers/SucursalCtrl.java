package com.test.jax.controllers;

import com.test.jax.daos.SucursalDao;
import com.test.jax.entities.Banco;
import com.test.jax.entities.Sucursal;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("/sucursal")
@Produces("application/json")
public class SucursalCtrl {

    SucursalDao sucursal = new SucursalDao();

    @GET
    @Path("/lista")
    public Response listBancos() {
        return Response.ok().entity(this.sucursal.listSucursal()).build();
    }

    @GET
    @Path("/banco/{id}")
    public Response bancoById(@PathParam("id") int id) {
        return Response.ok().entity(this.sucursal.SucursalId(id)).build();
    }

    @GET
    @Path("/banco/sucursales/{id}")
    @Produces("application/xml")
    public Response bancoSucursalById(@PathParam("id") int id) {
        return Response.ok().entity(this.sucursal.listSucursalBanco(id)).build();
    }

    @DELETE
    @Path("/lista/{id}")
    public Response delete(@PathParam("id") Integer id) {
        sucursal.eliminarSucursal(id);
        return Response.ok().entity("Banco deleted successfully !!").build();
    }

    @POST
    @Path("/lista/agregar/{id}")
    public Response create(@PathParam("id") Integer id, Sucursal banco) {
        sucursal.guardarSucursal(banco, id);
        return Response.ok().entity("Banco create successfully !!").build();
    }

    @PUT
    @Path("/lista/{id}")
    public Response update(@PathParam("id") Integer id, Sucursal banco) {
        sucursal.actualizarBanco(banco, id);
        return Response.noContent().build();
    }
}
