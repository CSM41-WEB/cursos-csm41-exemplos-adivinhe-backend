package aulas.web.adivinhe.entity;

import java.io.Serializable;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;

/**
 * A chave primária composta de um jogo.
 * @author Wilson Horstmeyer Bogado
 */
@Embeddable
public class JogoPK implements Serializable {
    public Integer jogador;
    
    @GeneratedValue
    public Integer seq;

    @Override
    public String toString() {
        return "JogoPK{" + "jogador=" + jogador + ", seq=" + seq + '}';
    }
}
