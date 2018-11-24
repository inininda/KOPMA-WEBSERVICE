/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

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

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    @GET
    @Path("getPembelian")
    @Produces(MediaType.APPLICATION_JSON)

    public Response getAllPembelian() {
        PembelianHelper test = new PembelianHelper();
        List<Pembelian> list = test.getAllPembelian();
        Gson gson = new Gson();
        String json = gson.toJson(list);
        return Response.status(200)
                .entity(gson.toJson(list))
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods",
                        "GET,POST,HEAD,OPTIONS,PUT")
                .header("Access-Control-Allow-Headers",
                        "Content-Type,X-Requested-With,accept,Origin,Access-Control-Request-Method,Access-Control-Request-Headers")
                .header("Access-Exposed-Headers",
                        "Access-Control-Allow-Origin,Access-Control-Allow-Credentials")
                .header("Access-Support-Credentials",
                        "true")
                .header("Access-Control-Max-Age", "2")
                .header("Access-Preflight-Maxage", "2")
                .build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }

    @POST
    @Path("addPembelian")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addNewPembelian(String data) {
        Gson gson = new Gson();
        Pembelian beli = gson.fromJson(data, Pembelian.class);
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
