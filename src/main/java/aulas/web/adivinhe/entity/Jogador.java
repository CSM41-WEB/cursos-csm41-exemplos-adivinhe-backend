package aulas.web.adivinhe.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import static io.quarkus.hibernate.orm.panache.PanacheEntityBase.find;
import java.util.Date;
import java.util.List;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Representa um jogador no banco de dados.
 * @author Wilson Horstmeyer Bogado
 */
@Entity
@Table(name = "jogador")
public class Jogador extends PanacheEntityBase {
    
    @Id
    public Integer codigo;
    
    public String apelido;
    public String nome;
    public String email;
    
    @JsonbTransient
    public String senha;
    
    @Column(name = "data_nasc")
    public Date dataNasc;
    
    @Embedded
    public Endereco endereco;

    @OneToMany
    @JoinColumn(name = "jogador", referencedColumnName = "codigo")
    @JsonbTransient
    public List<Jogo> jogos;
    
}
