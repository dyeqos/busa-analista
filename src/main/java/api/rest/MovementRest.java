package api.rest;

import api.dao.entity.Client;
import api.data.MovementData;
import api.impl.MovementImpl;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/movement")
@Transactional
public class MovementRest {

    @Inject
    MovementImpl movementImpl;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/save")
    public Response saveMovement(MovementData data){
        try {
        MovementData movement = movementImpl.save(data);
        return Response.ok(movement).build();

        }catch (Exception e){
          return   Response.status(400).entity("No tiene suficiente saldo").build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/list/client")
    public Response listMovement(Client data){
        List<MovementData> movements = movementImpl.listClient(data);
        return Response.ok(movements).build();
    }

}
