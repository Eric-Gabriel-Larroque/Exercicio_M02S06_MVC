package dive.tech.exercicios_mvc.controller;

import dive.tech.exercicios_mvc.model.entity.Empresa;
import dive.tech.exercicios_mvc.model.service.EmpresaService;

import javax.enterprise.context.ApplicationScoped;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@ApplicationScoped
@Path("/empresa")
public class EmpresaController {

    EmpresaService empresaService = new EmpresaService();

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response createEmpresa(@Valid Empresa empresa,
                                  @HeaderParam("Authorization") String authorization) {

        if(!"Bearer codigo123".equalsIgnoreCase(authorization)) {
            return Response
                    .status(Response.Status.NOT_FOUND)
                    .build();
        }

        try {
            Empresa empresaCriada = empresaService.createEmpresa(empresa);
            return Response
                    .ok(empresaCriada)
                    .build();
        }catch (Exception e) {
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .entity(e.getMessage())
                    .build();
        }
    }

    @GET
    @Produces("text/plain")
    public Response getEmpresas(@HeaderParam("Authorization") String authorization) {

        if(!"Bearer codigo123".equalsIgnoreCase(authorization)) {
            return Response
                    .status(Response.Status.NOT_FOUND)
                    .build();
        }
        return Response
                .ok(empresaService.getEmpresas())
                .build();
    }

    @GET
    @Path("/html")
    @Produces(MediaType.TEXT_HTML)
    public String getEmpresaHtml() {
        String html = "<html><ul>";
        List<Empresa> empresas = empresaService.getEmpresas();

        for (Empresa empresa : empresas) {
            html += "<li>" + empresa.getId() + ", " + empresa.getNome() + "</li>";
        }
        html += "</ul></html>";
        return html;
    }

}