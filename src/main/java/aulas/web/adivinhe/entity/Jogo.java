package aulas.web.adivinhe.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Representa um jogo no banco de dados.
 * @author Wilson Horstmeyer Bogado
 */
@Entity
@Table(name = "jogo")
public class Jogo extends PanacheEntityBase {

    @EmbeddedId
    @Valid
    public JogoPK jogoPK;
    
    @NotNull
    @Min(value = 0, message = "Pontuação ${validatedValue} é inválida. A pontuação mínima permitida é {value}.")
    public Integer pontuacao;
    
    @ManyToOne
    @JoinColumn(name = "jogador", referencedColumnName = "codigo", insertable = false, updatable = false)
    @JsonbTransient
    public Jogador jogador;

    @Override
    public String toString() {
        return "Jogo{" + "jogoPK=" + jogoPK + ", pontuacao=" + pontuacao + ", jogador=" + jogador + '}';
    }
}
