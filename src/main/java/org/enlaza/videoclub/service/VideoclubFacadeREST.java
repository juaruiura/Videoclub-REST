/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.enlaza.videoclub.service;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.enlaza.videoclub.Videoclub;

/**
 *
 * @author Juan Manuel
 */
@Stateless
@Path("videoclub")
public class VideoclubFacadeREST extends AbstractFacade<Videoclub> {

    @PersistenceContext(unitName = "org.enlaza_Videoclub_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    public VideoclubFacadeREST() {
        super(Videoclub.class);
    }

    @POST
    @Path("post")
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(Videoclub entity) {
        super.create(entity);
    }

    @PUT
    @Path("put/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void edit(@PathParam("id") String id, Videoclub entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("delete/{id}")
    public void remove(@PathParam("id") String id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("find/{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Videoclub find(@PathParam("id") String id) {
        return super.find(id);
    }

    @GET
    @Override
    @Path("findAll")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Videoclub> findAll() {
        return super.findAll();
    }

    @GET
    @Path("findRange/{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Videoclub> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
