package cadastrousuario.controller;

import cadastrousuario.Repository.EnderecoRepository;
import cadastrousuario.Repository.UsuarioRepository;
import cadastrousuario.model.Endereco;
import cadastrousuario.model.Usuario;
import cadastrousuario.service.EnderecoService;
import cadastrousuario.service.UsuarioService;
import org.apache.naming.factory.SendMailFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/usuario")
public class ControllerUsuario {

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private EnderecoService enderecoService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private PasswordEncoder encoder;


    @GetMapping
    public ResponseEntity<List<Usuario>> listarTodos() {
        if (repository.findAll() != null) {
            return ResponseEntity.status(200).body(repository.findAll());
        } else {
            return ResponseEntity.status(404).build();
        }
    }

    @GetMapping("/{idUsuario}")
    public ResponseEntity exibirUsuario(@PathVariable Integer idUsuario) {
        List<Usuario> usuarios = repository.findAll();
        for (Usuario usuario : usuarios
        ) {
            if (usuario.getIdUsuario() == idUsuario) {
                return ResponseEntity.status(200).body(repository.findByIdUsuario(idUsuario));
            }
        }
        return ResponseEntity.status(404).build();
    }

    @PostMapping
    public ResponseEntity<Usuario> cadastroUsuario(@RequestBody Usuario usuario) throws ParseException {
        try {
            enderecoService.saveAndress(usuario.getFkEnderecoUsuario());
            usuarioService.saveUser(usuario);

        } catch (Exception e) {
            return ResponseEntity.status(406).build();
        }
        return ResponseEntity.status(201).build();
    }

    @PutMapping("/alterar")
    public ResponseEntity<Usuario> alterar(@RequestBody Usuario usuario) {
        if (!repository.existsById(usuario.getIdUsuario())) {
            return ResponseEntity.status(404).build();
        }
        enderecoService.updateAndress(usuario);
        usuarioService.updateUser(usuario);
        return ResponseEntity.status(202).build();
    }
}
