package LES.BarbaGo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import LES.BarbaGo.Repository.BarbeiroRepository;
import LES.BarbaGo.Repository.UsuarioRepository;

@Service
public class EmailVerificationService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private BarbeiroRepository barbeiroRepository;

    public boolean emailExists(String email) {
        boolean existsInUsuarios = usuarioRepository.findByEmail(email).isPresent();
        boolean existsInBarbeiros = barbeiroRepository.findByEmail(email).isPresent();
        return existsInUsuarios || existsInBarbeiros;
    }
}
