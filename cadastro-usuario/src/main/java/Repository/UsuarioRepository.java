package Repository;

import cadastrousuario.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    // Find by email efuta uma consulta no banco de dados buscando no campo email
    public Optional<Usuario> findByEmail(String email);
}
