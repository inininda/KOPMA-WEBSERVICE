/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import com.google.gson.Gson;
import helper.PegawaiHelper;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import pojos.Pegawai;

/**
 * REST Web Service
 *
 * @author basisd10
 */
@Path("Pegawai")
public class PegawaiResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of Pegawai
     */
    public PegawaiResource() {
    }

    /**
     * Retrieves representation of an instance of services.Pegawai
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJson() {
        PegawaiHelper test = new PegawaiHelper();
        List<Pegawai> list = test.getAllPegawai();
        Gson gson = new Gson();
        String json = gson.toJson(list);
        return Response
                .status(200)
                .entity(json)
                .build();
    }

    /**
     * PUT method for updating or creating an instance of Pegawai
     *
     * @param content representation for the resource
     */
    @POST
    @Path("addPegawai")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response AddNewPegawai(String data) {
        Gson gson = new Gson();
        Pegawai pegawai = gson.fromJson(data,Pegawai.class);
        PegawaiHelper helper = new PegawaiHelper();
        helper.addNewPegawai(
                pegawai.getIdPegawai(),
                pegawai.getNama(),
                pegawai.getNoTelp(),
                pegawai.getAlamat(),
                pegawai.getUsername(),
                pegawai.getPassword());   
        return Response
                .status(200)
                .entity(pegawai)
                .build();
    }
}
