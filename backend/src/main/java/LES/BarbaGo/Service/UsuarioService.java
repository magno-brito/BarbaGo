package LES.BarbaGo.Service;

import LES.BarbaGo.Model.Usuario;
import LES.BarbaGo.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private EmailVerificationService emailVerificationService;

    @Transactional
    public Usuario salvar(Usuario usuario) {
        if (emailVerificationService.emailExists(usuario.getEmail())) {
            throw new RuntimeException("Email já está em uso.");
        }
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> listaUsuarios(){
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> buscarPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    public void removerPorId(Long id) {
        usuarioRepository.deleteById(id);
    }
}
