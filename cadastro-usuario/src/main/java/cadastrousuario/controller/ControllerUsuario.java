package cadastrousuario.controller;

import cadastrousuario.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/freelancer")
public class ControllerUsuario {

  @GetMapping
    public ResponseEntity getUsers(){

  }
}
