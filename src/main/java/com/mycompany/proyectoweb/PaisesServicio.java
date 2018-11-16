/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectoweb;

import com.mycompany.dao.PaisesDao;
import com.mycompany.models.Paises;
import java.lang.annotation.Annotation;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Helder Castrillon
 */
@Path("paises")
public class PaisesServicio {

    @GET
    @Path("/get/")
    @Produces(MediaType.APPLICATION_JSON)
    public  Response getPaises(){
        List<Paises> lista= PaisesDao.getPaises();
        return Response.ok(lista)
                 //.entity(podcastById, detailed ? new Annotation[]{PodcastDetailedView.Factory.get()} : new Annotation[0])
		.header("Access-Control-Allow-Origin", "*")
		.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
		.allow("OPTIONS").build();
      
  }
   
    @GET
    @Path("/find/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public  Response findPaises(@PathParam("name") String name ){
        List<Paises> lista= PaisesDao.findPaises(name);
        return Response.ok(lista)
                  //.entity(podcastById, detailed ? new Annotation[]{PodcastDetailedView.Factory.get()} : new Annotation[0])
		.header("Access-Control-Allow-Origin", "*")
		.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
		.allow("OPTIONS").build();
      
  }
    
    @POST
    @Path("/save/")
    @Consumes(MediaType.APPLICATION_JSON)// specifies the request body content
    public  Response setPaises(Paises pais){
        //Guarda los valores usando el método serPaises y retorna e resultado true si fue correcto
        PaisesDao.setPaises(pais);
        String resultAPI = "Datos almacenados ";
        return Response.status(201).entity(resultAPI).build();
      
       
      
  } 
  
}
