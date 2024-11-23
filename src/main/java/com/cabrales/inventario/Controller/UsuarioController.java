package com.cabrales.inventario.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cabrales.inventario.Service.UsuarioService;
import com.cabrales.inventario.dto.Usuarios;

@RestController
@RequestMapping("/api/usuarios/")
public class UsuarioController {

	    @Autowired
	    private UsuarioService usuarioService;

	    @PostMapping
	    public ResponseEntity<Usuarios> crearUsuario(@RequestBody Usuarios usuarios) {
	        try {
	            Usuarios nuevoUsuario = usuarioService.crearUsuario(usuarios);
	            return ResponseEntity.ok(nuevoUsuario);
	        } catch (IllegalArgumentException e) {
	            return ResponseEntity.badRequest().body(null);
	        } catch (Exception e) {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	        }
	    }
	    
	  
}
