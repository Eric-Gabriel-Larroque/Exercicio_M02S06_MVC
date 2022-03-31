package dive.tech.exercicios_mvc.controller;

import dive.tech.exercicios_mvc.model.entity.Genero;
import dive.tech.exercicios_mvc.model.service.GeneroService;

import javax.enterprise.context.ApplicationScoped;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@ApplicationScoped
@Path("/genero")
public class GeneroController {

    private GeneroService generoService = new GeneroService();

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response createGenero(@Valid Genero genero,
                                 @HeaderParam("Authorization") String authorization) {

        if(!"Bearer codigo123".equalsIgnoreCase(authorization)) {
            return Response
                    .status(Response.Status.NOT_FOUND)
                    .build();
        }

        try {
            Genero generoCriado = generoService.createGenero(genero);
            return Response
                    .ok(generoCriado)
                    .build();
        }catch (Exception e) {
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .entity(e.getMessage())
                    .build();
        }
    }
}
