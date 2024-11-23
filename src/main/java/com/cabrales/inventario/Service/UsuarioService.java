package com.cabrales.inventario.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Optional;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cabrales.inventario.DAO.EstatusDao;
import com.cabrales.inventario.DAO.RolDAO;
import com.cabrales.inventario.DAO.UsuarioDao;
import com.cabrales.inventario.dto.Estatus;
import com.cabrales.inventario.dto.Rol;
import com.cabrales.inventario.dto.Usuarios;

import ch.qos.logback.classic.Logger;

@Service
public class UsuarioService {
	
	private static final Logger logger = (Logger) LoggerFactory.getLogger(UsuarioService.class);


	@Autowired
	private UsuarioDao usuarioDao;
	@Autowired
	private RolDAO rolDao;
	@Autowired
	private EstatusDao estatusDao;
	
	public Usuarios crearUsuario(Usuarios usuario) {
        if (usuario.getRol() == null || usuario.getRol().getIdRol() == null) {
            throw new IllegalArgumentException("El rol es obligatorio.");
        }
        {
            logger.info("Recibiendo solicitud para crear usuario: {}", usuario);
        }

        if (usuario.getEstatus() == null || usuario.getEstatus().getIdEstatus() == null) {
            throw new IllegalArgumentException("El estatus es obligatorio.");
        }

        // Validar que el rol exista
        Rol rol = rolDao.findById(usuario.getRol().getIdRol())
                .orElseThrow(() -> new IllegalArgumentException("El rol especificado no existe."));

        // Validar que el estatus exista
        Estatus estatus = estatusDao.findById(usuario.getEstatus().getIdEstatus())
                .orElseThrow(() -> new IllegalArgumentException("El estatus especificado no existe."));

        usuario.setRol(rol);
        usuario.setEstatus(estatus);

        // Hash de contraseña si es necesario
        if (usuario.getPassword() != null) {
            usuario.setPassword(hashMD5(usuario.getPassword()));
        }

        return usuarioDao.save(usuario);
    }

    private String hashMD5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digest = md.digest(input.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : digest) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error al generar hash MD5", e);
        }
    }
    
	public List<Usuarios> getAllRoles() {

		return usuarioDao.findAll();
	}

	public void delete (Integer id) {
		 usuarioDao.deleteById(id);
	}

	public Optional<Usuarios> findById (Integer  id) {
		return usuarioDao.findById(id);
	}
	
}
	
	

