package service;

import com.google.gson.Gson;
import helper.PengirimanHelper;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import pojos.Pengiriman;

/**
 *
 * @author xanadila
 */
@Path("Pengiriman")
public class PengirimanResource {
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of PembelianResource
     */
    public PengirimanResource() {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    @GET
    @Path("getPengiriman")
    @Produces(MediaType.APPLICATION_JSON)
        public Response getAllPengiriman() {
        PengirimanHelper test = new PengirimanHelper();
        List<Pengiriman> list = test.getAllPengiriman();
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
    @Path("addPengiriman")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addNewPengiriman(String data) {
        Gson gson = new Gson();
        Pengiriman beli = gson.fromJson(data, Pengiriman.class);
        PengirimanHelper helper = new PengirimanHelper();
        helper.addNewPengiriman(
                beli.getIdKirim(),
                beli.getIdBarang(),
                beli.getNamaBarang(),
                beli.getJumlahKirim(),
                beli.getStatusTerima(),
                beli.getTanggalKirim());
        return Response
                .status(200)
                .entity(beli)
                .build();
    }
}
