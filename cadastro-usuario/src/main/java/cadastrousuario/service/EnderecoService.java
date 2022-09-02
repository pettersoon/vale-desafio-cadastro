package cadastrousuario.service;

import cadastrousuario.Repository.EnderecoRepository;
import cadastrousuario.Repository.UsuarioRepository;
import cadastrousuario.model.Endereco;
import cadastrousuario.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService {

    @Autowired
    EnderecoRepository repository;
    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    private PasswordEncoder encoder;

    public void saveAndress (Endereco endereco) {
        repository.save(endereco);
    }

    public void updateAndress (Usuario usuario) {
        repository.atualizarEndereco(
                usuario.getFkEnderecoUsuario().getIdEndereco(),
                usuario.getFkEnderecoUsuario().getRua(),
                usuario.getFkEnderecoUsuario().getBairro(),
                usuario.getFkEnderecoUsuario().getCidade());
    }
}
