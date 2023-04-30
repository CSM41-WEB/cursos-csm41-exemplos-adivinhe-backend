package aulas.web.adivinhe.entity;

import java.io.Serializable;
import javax.persistence.Embeddable;

/**
 * Representa o endereço e um jogador.
 * @author Wilson Horstmeyer Bogado
 */
@Embeddable
public class Endereco implements Serializable {
    
    public String logradouro;
    public Integer numero;
    public String bairro;
    public Integer cep;
    public String cidade;
    public String uf;

    @Override
    public String toString() {
        return logradouro + ", " +
               numero + " " +
               bairro + " " +
               cep + " " +
               cidade + " " +
               uf;
    }
    
}
