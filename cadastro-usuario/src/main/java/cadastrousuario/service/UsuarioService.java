package cadastrousuario.service;

import cadastrousuario.Repository.EnderecoRepository;
import cadastrousuario.Repository.UsuarioRepository;
import cadastrousuario.model.Endereco;
import cadastrousuario.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;

public class UsuarioService {
    @Autowired
    UsuarioRepository repository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private PasswordEncoder encoder;

    public String salvarUsuario(Usuario usuario){
      return "Chamada feita";
    }
    
    public void updateUsuario(Usuario usuario) {
        repository.save(usuario);
        repository.atualizarUsuario(
                usuario.getIdUsuario(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getSenha());

    }
    
}

    
