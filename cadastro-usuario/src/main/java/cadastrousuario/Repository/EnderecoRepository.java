package cadastrousuario.Repository;

import cadastrousuario.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface EnderecoRepository extends JpaRepository <Endereco, Integer> {

    @Query("update Endereco e set e.rua = ?2, e.bairro = ?3, e.cidade = ?4 where e.idEndereco = ?1")
    @Modifying
    @Transactional
    void atualizarEndereco(Long idEndereco,String rua, String bairro, String cidade);
}
