package com.cabrales.inventario.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cabrales.inventario.dto.Rol;

public interface RolDAO extends JpaRepository<Rol,Integer> {

}
