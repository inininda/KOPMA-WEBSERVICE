/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import com.google.gson.Gson;
import helper.TransaksiHelper;
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
import pojos.Transaksi;

/**
 * REST Web Service
 *
 * @author basisd10
 */
@Path("Transaksi")
public class TransaksiResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of PembelianResource
     */
    public TransaksiResource() {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    @GET
    @Path("getTransaksi")
    @Produces(MediaType.APPLICATION_JSON)

    public Response getAllTransaksi() {
        TransaksiHelper test = new TransaksiHelper();
        List<Transaksi> list = test.getAllTransaksi();
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
    @Path("addTransaksi")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addNewTransaksi(String data) {
        Gson gson = new Gson();
        Transaksi beli = gson.fromJson(data, Transaksi.class);
        TransaksiHelper helper = new TransaksiHelper();
        helper.addNewTransaksi(
                beli.getIdBarang(),
                beli.getKodeUnik(),
                beli.getJumlahPembayaran(),
                beli.getStatusPembayaran(),
                beli.getTanggalTransaksi());
        return Response
                .status(200)
                .entity(beli)
                .build();
    }
}
