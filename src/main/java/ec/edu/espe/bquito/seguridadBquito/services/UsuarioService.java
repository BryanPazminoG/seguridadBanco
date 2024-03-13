package ec.edu.espe.bquito.seguridadBquito.services;

import ec.edu.espe.bquito.seguridadBquito.dao.UsuarioRepository;
import ec.edu.espe.bquito.seguridadBquito.domain.Usuario;
import ec.edu.espe.bquito.seguridadBquito.dto.AccesoResDto;
import ec.edu.espe.bquito.seguridadBquito.dto.LoginReqDto;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public AccesoResDto usuarioLogin(LoginReqDto loginUsuario){
        AccesoResDto accesoResDto=new AccesoResDto();
        Usuario usuario=this.usuarioRepository.findByEmailAndClave(loginUsuario.getUserEmail(),loginUsuario.getUserClave());
        if(usuario==null){
            accesoResDto.setEstado("ERROR_USUARIO_NO_EXISTE");
        }
        accesoResDto.setUsuarioNombre(usuario.getNombre());
        accesoResDto.setEstado("ACCESO_CORRECTO");
        return accesoResDto;
    }




}
