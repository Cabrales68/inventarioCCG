package com.cabrales.inventario.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cabrales.inventario.DAO.EstatusDao;
import com.cabrales.inventario.dto.Estatus;


@Service
public class EstatusService {
	
	@Autowired
	private EstatusDao estatusDao;
	
	public Estatus create(Estatus estatus) {
		return estatusDao.save(estatus);
	}

	public List<Estatus> getAllEstatus() {

		return estatusDao.findAll();
	}

	public void delete (Estatus estatus) {
		 estatusDao.delete(estatus);
	}

	public Optional<Estatus> findById (Integer  id) {
		return estatusDao.findById(id);
	}
	

}
