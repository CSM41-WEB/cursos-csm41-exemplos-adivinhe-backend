package aula.web.adivinhe.ws;

import aulas.web.adivinhe.entity.Jogo;
import aulas.web.adivinhe.entity.JogoPK;
import java.net.URI;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@Path("/jogo")
public class JogoResource {

    public static final SimpleDateFormat DATA_JOGO_FORMAT = new SimpleDateFormat(Jogo.DATA_JOGO_PATTERN);
    public static final String URI_JOGO = "/jogo/info?jogador=%d&dataHora=%s";
    
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
    
    @GET
    @Path("/info")
    @Produces(MediaType.APPLICATION_JSON)
    public Response infoJogo(@QueryParam("jogador") Integer jogador, @QueryParam("dataHora") String dataHora)
            throws ParseException {
        var dh = DATA_JOGO_FORMAT.parse(dataHora);
        var jogoPK = new JogoPK(jogador, dh);
        Jogo j = Jogo.findById(jogoPK);
        return Response.ok(j).build();
    }
    
    @POST
    @Path("/new")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response insertJogo(@Valid Jogo jogo) {
        jogo.persist();
        String dataHora = DATA_JOGO_FORMAT.format(jogo.jogoPK.dataHora);
        String uri = String.format(URI_JOGO, jogo.jogoPK.jogador, dataHora);
        return Response.created(URI.create(uri)).build();
    }
}