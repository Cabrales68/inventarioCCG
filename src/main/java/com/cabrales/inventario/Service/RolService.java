package com.cabrales.inventario.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cabrales.inventario.DAO.EstatusDao;
import com.cabrales.inventario.DAO.RolDAO;
import com.cabrales.inventario.dto.Estatus;
import com.cabrales.inventario.dto.Rol;

@Service
public class RolService {

	@Autowired
	private RolDAO rolDao;
	@Autowired
	private EstatusDao estatusDao;
	
	public Rol create(Rol rol) {
	   
	    if (rol.getEstatus() == null || rol.getEstatus().getIdEstatus() == null) {
	        throw new IllegalArgumentException("El estatus proporcionado es inválido.");
	    }

	  
	    Optional<Estatus> estatusOptional = estatusDao.findById(rol.getEstatus().getIdEstatus());
	    if (!estatusOptional.isPresent()) {
	        throw new IllegalArgumentException("El estatus con ID " + rol.getEstatus().getIdEstatus() + " no existe.");
	    }

	    
	    rol.setEstatus(estatusOptional.get());

	
	    return rolDao.save(rol);
	}


	//public Rol create(Rol rol) {
		//return rolDao.save(rol);
	//}
	public List<Rol> getAllRoles() {

		return rolDao.findAll();
	}

	public void delete (Integer id) {
		 rolDao.deleteById(id);
	}

	public Optional<Rol> findById (Integer  id) {
		return rolDao.findById(id);
	}
	

}
