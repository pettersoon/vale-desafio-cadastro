package cadastrousuario.Repository;

import cadastrousuario.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    // Find by email efuta uma consulta no banco de dados buscando no campo email
    Usuario findByIdUsuario(Integer idUsuario);

    @Query("update Usuario u set u.nome = ?2, u.email = ?3, u.senha = ?4 where u.idUsuario = ?1")
    @Modifying
    @Transactional
    void atualizarUsuario(Integer idUsuario,
                          String nome,
                          String email,
                          String senha);
}
