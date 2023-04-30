package aula.web.adivinhe.ws;

import aulas.web.adivinhe.entity.Jogador;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/jogador")
public class JogadorResource {

    @GET
    @Path("/info/{codigo}")
    @Produces(MediaType.APPLICATION_JSON)
    public Jogador infoJogador(Integer codigo) {
        Jogador jogador = Jogador.findById(codigo);
        return jogador;
    }
    
    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Jogador> listJogadores() {
        List<Jogador> jogadores = Jogador.listAll();
        return jogadores;
    }
}