package ec.edu.espe.bquito.seguridadBquito;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import ec.edu.espe.bquito.seguridadBquito.controller.AccesoController;
import ec.edu.espe.bquito.seguridadBquito.dao.UsuarioRepository;
import ec.edu.espe.bquito.seguridadBquito.domain.Usuario;
import ec.edu.espe.bquito.seguridadBquito.services.UsuarioService;

@ExtendWith(MockitoExtension.class)
public class AccesoControllerTest {

    private MockMvc mockMvcUsuario;
    ObjectMapper objectMapper = new ObjectMapper();
    ObjectWriter objectwrittWriter = objectMapper.writer();

    @Mock
    private UsuarioRepository usuarioRepository;

    @InjectMocks
    private AccesoController accesoController;

    Usuario REGISTRO_1 = new Usuario();

    @BeforeEach

    public void setUp() {
        MockitoAnnotations.initMocks(this);
        UsuarioService usuarioService = new UsuarioService(usuarioRepository);
        accesoController = new AccesoController(usuarioService);
        this.mockMvcUsuario = MockMvcBuilders.standaloneSetup(accesoController).build();
    }

    @Test
    public void obtenerAcceso_success() throws Exception {
        mockMvcUsuario.perform(MockMvcRequestBuilders
                .get("/api/v1/accesos/login")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isMethodNotAllowed());

    }

}
