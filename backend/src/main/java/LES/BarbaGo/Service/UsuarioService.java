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

    @Transactional
    public Usuario salvar(Usuario usuario) {
        Optional<Usuario> usuarioExistente = usuarioRepository.findByEmail(usuario.getEmail());
        if (usuarioExistente.isPresent()) {
            throw new IllegalStateException("Já existe um usuário cadastrado com esse e-mail.");
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
