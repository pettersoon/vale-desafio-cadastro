package cadastrousuario.controller;

import cadastrousuario.Repository.EnderecoRepository;
import cadastrousuario.Repository.UsuarioRepository;
import cadastrousuario.model.Endereco;
import cadastrousuario.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class ControllerUsuario {

    /*Banco de dados*/
    @Autowired
    private final UsuarioRepository repository;

    @Autowired
    private EnderecoRepository enderecoRepository;


    @Autowired
    private final PasswordEncoder encoder;

    public ControllerUsuario(PasswordEncoder encoder, UsuarioRepository repository) {
        this.encoder = encoder;
        this.repository = repository;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Usuario>> listarTodos() {
        return ResponseEntity.ok(repository.findAll());
    }

    @PostMapping("/salvar")
    public ResponseEntity<Usuario> salvar(@RequestBody Usuario usuario) {
//    usuario.setSenha(encoder.encode(usuario.getSenha()));
        Endereco endereco = enderecoRepository.save(usuario.getFkEnderecoUsuario());
        enderecoRepository.save(endereco);
        usuario.setFkEnderecoUsuario(endereco);
        repository.save(usuario);
        return ResponseEntity.status(201).build();
    }
//
//  @GetMapping("/validarSenha")
//  public ResponseEntity<Boolean> validarSenha(@RequestParam String email,
//                                              @RequestParam String senha){
//
//    // Consulta o usuário, caso não encontre o usuário retorna um não autorizado
//    Optional<Usuario> optUsuario = repository.findByEmail(email);
//    if(optUsuario.isEmpty()){
//      return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(false);
//    }
//
//    // pego o usuario do optinal e verifico se a senha bate com a senha informada
//
//    Usuario usuario = optUsuario.get();
//    // matches serve para comparar com a senha "aberta" com a senha encriptada
//    // o encoder faz isso sozinho
//    boolean valid = encoder.matches(senha, usuario.getSenha());
//// Se a senha bater http status ok, caso contrario não autorizado
//    HttpStatus status = (valid) ? HttpStatus.OK : HttpStatus.UNAUTHORIZED;
//
//    if(!valid){
//      return ResponseEntity.status(status).body(valid);
//    }
//    return null;
//  }
//
//
///*Usando lista */
//  private List<Usuario> usuariosList = new ArrayList<>();
//
//  @GetMapping
//  public List<Usuario> listarUsuarios(){
//    return usuariosList;
//  }
//
//  @PostMapping()
//  public Usuario cadastrarUsuario(@RequestBody Usuario usuario){
//    usuariosList.add(usuario);
//    return usuario;
//  }
//
//  public void buscarUsuario(String email) {
//    Boolean achou = false;
//    for (Usuario u : usuariosList) {
//      if (u.getEmail().equals(email)) {
//        System.out.println(u);
//        achou = true;
//      }
//    }
//    if (!achou) {
//      System.out.println("Não encontrado!");
//    }
//  }
//
//  @GetMapping("/atualizar/{indice}/{nome}/{email}/{idade}/{senha}/")
//  public Usuario atualizarUsuarioId(
//          @PathVariable("indice") int indice,
//          @PathVariable("nome") String nome,
//          @PathVariable("email") String email,
//          @PathVariable("idade") Date idade,
//          @PathVariable("senha") String senha
//
//  ) {
//    usuariosList.get(indice).setNome(nome);
//    usuariosList.get(indice).setEmail(email);
//    usuariosList.get(indice).setIdade(idade);
//    usuariosList.get(indice).setSenha(senha);
//
//    System.out.println("Usuário atualizado com sucesso!");
//    return usuariosList.get(indice);
//  }
}
