package cadastrousuario.service;

import cadastrousuario.Repository.EnderecoRepository;
import cadastrousuario.Repository.UsuarioRepository;
import cadastrousuario.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@Service
public class UsuarioService {

    @Autowired
    EnderecoRepository repository;

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder encoder;

    public void saveUser (Usuario usuario) throws ParseException {
        usuario.setIdade(calcularIdade(usuario.getIdade()));
        usuarioRepository.save(usuario);
    }

    public void updateUser (Usuario usuario) {
        usuarioRepository.atualizarUsuario(
                usuario.getIdUsuario(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getSenha());
    }

    public String calcularIdade (String dataNascUsuario) throws ParseException {
        String pattern = "dd/MM/yyyy";
        DateFormat formatter = new SimpleDateFormat(pattern);
        Date dataNascFormatada = formatter.parse(dataNascUsuario);

        Calendar dataNasc = new GregorianCalendar();
        dataNasc.setTime(dataNascFormatada);

        Calendar today = Calendar.getInstance();
        int idade = today.get(Calendar.YEAR) - dataNasc.get(Calendar.YEAR);

        dataNasc.add(Calendar.YEAR, idade);

        if (today.before(dataNasc)){
            idade--;
        }

        return String.valueOf(idade);
    }
}
