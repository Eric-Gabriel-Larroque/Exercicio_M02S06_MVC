package dive.tech.exercicios_mvc.controller;

import dive.tech.exercicios_mvc.model.entity.Genero;
import dive.tech.exercicios_mvc.model.entity.Jogo;
import dive.tech.exercicios_mvc.model.service.JogoService;

import javax.enterprise.context.ApplicationScoped;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@ApplicationScoped
@Path("/jogo")
public class JogoController {

    JogoService jogoService = new JogoService();

    @GET
    @Produces("text/plain")
    public Response getJogos(@HeaderParam("Authorization") String authorization) {

        if(!"Bearer codigo123".equalsIgnoreCase(authorization)) {
            return Response
                    .status(Response.Status.NOT_FOUND)
                    .build();
        }
        return Response
                .ok(jogoService.getJogo())
                .build();
    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response createJogo(@Valid Jogo jogo) {
        try {
            Jogo jogoCriado = jogoService.createJogo(jogo);
            return Response
                    .ok(jogoCriado)
                    .build();
        }catch (Exception e) {
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .entity(e.getMessage())
                    .build();
        }
    }

    @PUT
    @Path("{id}")
    @Consumes("application/json")
    @Produces("application/json")
    public Response updateJogo( @PathParam("id") Long id,
                                String nome) {
        Jogo jogoAtualizado = jogoService.updateJogo(nome,id);

        try {
            return Response
                    .ok(jogoAtualizado)
                    .build();
        }catch (Exception e) {
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .entity(e.getMessage())
                    .build();
        }
    }

    @DELETE
    @Path("{id}")
    @Produces("application/json")
    public Response deleteJogo(@PathParam("id") Long id) {
        Jogo jogoDeletado = jogoService.deleteJogo(id);

        try {
            return Response
                    .ok(jogoDeletado)
                    .build();
        }catch (Exception e) {
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .build();
        }
    }
}
