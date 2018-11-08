/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import com.google.gson.Gson;
import helper.PembelianHelper;
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
import pojos.Pembelian;

/**
 * REST Web Service
 *
 * @author basisd10
 */
@Path("Pembelian")
public class PembelianResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of PembelianResource
     */
    public PembelianResource() {
    }

    /**
     * Retrieves representation of an instance of services.PembelianResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJson() {
        PembelianHelper test = new PembelianHelper();
        List<Pembelian> list = test.getAllPembelian();
        Gson gson = new Gson();
        String json = gson.toJson(list);
        return Response
                .status(200)
                .entity(json)
                .build();
    }

    /**
     * PUT method for updating or creating an instance of PembelianResource
     * @param content representation for the resource
     */
    @POST
    @Path("addPembelian")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response putJson(String data) {
        Gson gson = new Gson();
        Pembelian beli = gson.fromJson(data,Pembelian.class);
        PembelianHelper helper = new PembelianHelper();
        helper.addNewPembelian(
                beli.getIdBarang(),
                beli.getKodeUnik(),
                beli.getJumlahPembayaran(),
                beli.getStatusPembayaran());   
        return Response
                .status(200)
                .entity(beli)
                .build();
    }
}
