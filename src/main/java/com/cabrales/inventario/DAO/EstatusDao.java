package com.cabrales.inventario.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cabrales.inventario.dto.Estatus;

public interface EstatusDao extends JpaRepository<Estatus,Integer> {

}

