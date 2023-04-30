package aula.web.adivinhe.ws;

import aulas.web.adivinhe.entity.Jogador;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/jogador")
public class JogadorResource {

    @GET
    @Path("/info/{codigo}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response infoJogador(@PathParam("codigo") Integer codigo) {
        var jogador = Jogador.findById(codigo);
        return Response.ok(jogador).build();
    }
    
    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listJogadores() {
        var jogadores = Jogador.listAll();
        return Response.ok(jogadores).build();
    }
}