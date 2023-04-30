package aulas.web.adivinhe.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import java.util.Date;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

/**
 * Representa um jogo no banco de dados.
 * @author Wilson Horstmeyer Bogado
 */
@Entity
@Table(name = "jogo")
public class Jogo extends PanacheEntityBase {

    @EmbeddedId
    public JogoPK jogoPK;
    
    @NotNull
    @PastOrPresent
    @Column(name = "data_hora")
    public Date dataHora;
    
    @NotNull
    @Min(0)
    public Integer pontuacao;
    
    @ManyToOne
    @JoinColumn(name = "jogador", referencedColumnName = "codigo", insertable = false, updatable = false)
    @JsonbTransient
    public Jogador jogador;

    @Override
    public String toString() {
        return "Jogo{" + "jogoPK=" + jogoPK + ", dataHora=" + dataHora + '}';
    }
    
}
