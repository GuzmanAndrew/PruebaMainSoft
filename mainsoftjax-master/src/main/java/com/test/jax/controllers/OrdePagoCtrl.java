package com.test.jax.controllers;

import com.test.jax.daos.OrdenPago;
import com.test.jax.entities.Sucursal;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("/pagos")
@Produces("application/json")
public class OrdePagoCtrl {

    OrdenPago pago = new OrdenPago();

    @GET
    @Path("/lista")
    public Response listBancos() {
        return Response.ok().entity(this.pago.listOrdenPago()).build();
    }

    @GET
    @Path("/filtro/dolar")
    public Response listFiltroDolar() {
        return Response.ok().entity(this.pago.listPagoDolar()).build();
    }

    @GET
    @Path("/filtro/soles")
    public Response listFiltroSoles() {
        return Response.ok().entity(this.pago.listPagoSoles()).build();
    }

    @GET
    @Path("/banco/{id}")
    public Response bancoById(@PathParam("id") int id) {
        return Response.ok().entity(this.pago.OrdenPagoId(id)).build();
    }

    @DELETE
    @Path("/lista/{id}")
    public Response delete(@PathParam("id") Integer id) {
        pago.eliminarOrdenPago(id);
        return Response.status(202).entity("Banco deleted successfully !!").build();
    }

    @POST
    @Path("/lista/agregar/{id}")
    public Response create(@PathParam("id") Long id, com.test.jax.entities.OrdenPago banco) {
        return Response.ok().entity(pago.guardarOrdenPago(banco, id)).build();
    }

    @PUT
    @Path("/lista/{id}")
    public Response update(@PathParam("id") Integer id, com.test.jax.entities.OrdenPago banco) {
        pago.actualizarBanco(banco, id);
        return Response.noContent().build();
    }
}
