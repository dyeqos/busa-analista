package api.rest;

import api.dao.entity.Product;
import api.impl.ProductImpl;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/api/product")
@Transactional
public class ProductRest {

    @Inject
    ProductImpl productImpl;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/save")
    public Response saveProduct(Product data){
        Product product = productImpl.save(data);
        return Response.ok(product).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/list")
    public Response listProducts(){
        List<Product> clientList = productImpl.listProducts();
        return Response.ok(clientList).build();
    }
}
