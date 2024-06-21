package api.rest;

import api.dao.entity.Client;
import api.data.ClientSearchData;
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

@Path("/client")
@Transactional
public class ClientRest {

    @Inject
    ClientImpl clientImpl;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/save")
    public Response saveClient(Client data){
        Client client = clientImpl.save(data);
        return Response.ok(client).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/update")
    public Response updateClient(Client data){
        Client client = clientImpl.update(data);
        return Response.ok(client).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/delete")
    public Response deleteClient(Client data){
       boolean resp =  clientImpl.delete(data);
       if(resp){
        return Response.ok(true).build();
       }
       return Response.status(400).entity("Tiene Cuentas Asociadas").build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/search")
    public Response searchClient(ClientSearchData data){
        Client client =  clientImpl.search(data);
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
