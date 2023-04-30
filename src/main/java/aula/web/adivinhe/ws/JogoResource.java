package aula.web.adivinhe.ws;

import aulas.web.adivinhe.entity.Jogo;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/jogo")
public class JogoResource {

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listJogos() {
        var jogos = Jogo.listAll();
        return Response.ok(jogos).build();
    }
    
    @GET
    @Path("/jogador/{jogador}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listJogos(Integer jogador) {
        var jogos = Jogo.list("jogoPK.jogador", jogador);
        return Response.ok(jogos).build();
    }
}