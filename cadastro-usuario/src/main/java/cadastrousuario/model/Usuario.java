package cadastrousuario.model;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.springframework.data.annotation.PersistenceCreator;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "usuario")
@Data
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUsuario;

    private String nome;

    @Column(unique = true)
    private String email;

    @Size(min = 6)
    private String senha;

    private String idade;

    @ManyToOne()
    private Endereco fkEnderecoUsuario;

    public Usuario() {
    }

    public Usuario(String nome, String email, String senha, String idade, Endereco endereco) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.idade = idade;
        this.fkEnderecoUsuario = endereco;
    }

}
