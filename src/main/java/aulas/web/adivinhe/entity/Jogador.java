package aulas.web.adivinhe.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import java.util.Date;
import java.util.List;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

/**
 * Representa um jogador no banco de dados.
 * @author Wilson Horstmeyer Bogado
 */
@Entity
@Table(name = "jogador")
public class Jogador extends PanacheEntityBase {
    
    @Id
    @NotNull
    public Integer codigo;
    
    @NotNull
    public String apelido;

    @NotNull
    public String nome;
    
    @NotNull
    @Email
    public String email;
    
    @NotNull
    @JsonbTransient
    public String senha;
    
    @NotNull
    @Past
    @Temporal(TemporalType.DATE)
    @Column(name = "data_nasc")
    public Date dataNasc;
    
    @Embedded
    public Endereco endereco;

    @OneToMany
    @JoinColumn(name = "jogador", referencedColumnName = "codigo")
    @JsonbTransient
    public List<Jogo> jogos;
    
}
