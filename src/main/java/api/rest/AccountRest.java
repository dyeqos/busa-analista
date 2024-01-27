package api.rest;

import api.dao.entity.Account;
import api.data.AccountData;
import api.impl.AccountImpl;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/api/account")
@Transactional
public class AccountRest {

    @Inject
    AccountImpl accountImpl;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/save")
    public Response saveProduct(AccountData data){
        System.out.println(data);
        Account account = accountImpl.save(data);
        return Response.ok(account).build();
    }

}
