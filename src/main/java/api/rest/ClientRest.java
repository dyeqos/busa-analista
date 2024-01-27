package api.rest;

import api.dao.entity.Client;
import api.impl.ClientImpl;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/api/client")
@Transactional
public class ClientRest {

    @Inject
    ClientImpl clientImpl;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/save")
    public Response saveClient(Client data){
        System.out.println(data);
        Client client = clientImpl.save(data);
        return Response.ok(client).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/list")
    public Response listClient(){
        List<Client> clientList = clientImpl.listClient();
        return Response.ok(clientList).build();
    }
}
