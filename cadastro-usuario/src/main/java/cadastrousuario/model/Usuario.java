package cadastrousuario.model;

import java.util.Date;


public class Usuario {
    private String nome;
    private String email;
    private String senha;
    private Date idade;
    private Endereco endereco;

    public Usuario(String nome, String email, String senha, Date idade, Endereco endereco) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.idade = idade;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Date getIdade() {
        return idade;
    }

    public void setIdade(Date idade) {
        this.idade = idade;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", idade=" + idade +
                ", endereco=" + endereco +
                '}';
    }
}
