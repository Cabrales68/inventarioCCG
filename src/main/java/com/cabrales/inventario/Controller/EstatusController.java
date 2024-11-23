package com.cabrales.inventario.Controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cabrales.inventario.Service.EstatusService;
import com.cabrales.inventario.dto.Estatus;



@RestController
@RequestMapping ("/api/estatus/")
public class EstatusController {
	
	@Autowired
	private EstatusService estatusService;

	
	@PostMapping
	private ResponseEntity<Estatus> guardar (@RequestBody Estatus estatus){
		Estatus temporal= estatusService.create(estatus);
		
		try {
			
			return ResponseEntity.created(new URI("/api/estatus"+temporal.getIdEstatus())).body(temporal);
			
		}catch(Exception e) {
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@GetMapping
	private ResponseEntity<List<Estatus>> listarEstatus(){
		return ResponseEntity.ok(estatusService.getAllEstatus());
		
	}
	
	@DeleteMapping
	private ResponseEntity<Void> eliminarEstatus (@RequestBody Estatus estatus){
		estatusService.delete(estatus);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping (value = "{id}")
	private ResponseEntity<Optional<Estatus>> listarPorId (@PathVariable("id") Integer id){
return ResponseEntity.ok(estatusService.findById(id));
}
	
}
