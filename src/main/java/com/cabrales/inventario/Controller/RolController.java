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

import com.cabrales.inventario.DAO.EstatusDao;
import com.cabrales.inventario.Service.RolService;
import com.cabrales.inventario.dto.Estatus;
import com.cabrales.inventario.dto.Rol;

@RestController
@RequestMapping ("/api/roles/")
public class RolController {
	
	@Autowired
	private RolService rolService;
	@Autowired
	private EstatusDao estatusDao;
	
	@PostMapping
	private ResponseEntity<Rol> guardar(@RequestBody Rol rol) {
	    try {
	      
	        Optional<Estatus> estatusOptional = estatusDao.findById(rol.getEstatus().getIdEstatus());

	        if (estatusOptional.isEmpty()) {
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null); // Si no existe el estatus, retorna un error
	        }

	
	        rol.setEstatus(estatusOptional.get());

	  
	        Rol temporal = rolService.create(rol);

	          return ResponseEntity.created(new URI("/api/roles/" + temporal.getIdRol())).body(temporal);

	    } catch (Exception e) {
	     
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	    }
	}
	
	//@PostMapping
	//private ResponseEntity<Rol> guardar (@RequestBody Rol rol){
		//Rol temporal= rolService.create(rol);
		
		//try {
			
			//return ResponseEntity.created(new URI("/api/rol"+temporal.getIdRol())).body(temporal);
			
		//}catch(Exception e) {
			
			//return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		//}
	//}
	
	
	@GetMapping
	private ResponseEntity<List<Rol>> listarRoles(){
		return ResponseEntity.ok(rolService.getAllRoles());
		
	}
	
	//@DeleteMapping
	//private ResponseEntity<Void> eliminarRol (@RequestBody Rol rol){
		//rolService.delete(rol);
		//return ResponseEntity.ok().build();
	//}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminarRol(@PathVariable("id") Integer id) {
	    rolService.delete(id);  // Asumiendo que 'delete' acepta un ID
	    return ResponseEntity.noContent().build();  // Responde con 204 No Content
	}

	
	@GetMapping (value = "{id}")
	private ResponseEntity<Optional<Rol>> listarPorId (@PathVariable("id") Integer id){
return ResponseEntity.ok(rolService.findById(id));
}
}
