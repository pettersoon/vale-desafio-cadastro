package cadastrousuario.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEndereço;
    private String rua;
    private String bairro;
    private String cidade;

    public Endereco(String rua, String bairro, String cidade) {
        this.rua = rua;
        this.bairro = bairro;
        this.cidade = cidade;
    }

    public Endereco() {

    }
}
