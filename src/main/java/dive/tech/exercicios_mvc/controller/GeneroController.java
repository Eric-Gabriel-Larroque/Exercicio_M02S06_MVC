package dive.tech.exercicios_mvc.controller;

import dive.tech.exercicios_mvc.model.entity.Genero;
import dive.tech.exercicios_mvc.model.service.GeneroService;

import javax.enterprise.context.ApplicationScoped;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@ApplicationScoped
@Path("/genero")
public class GeneroController {

    private GeneroService generoService = new GeneroService();

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response createGenero(@Valid Genero genero) {
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
