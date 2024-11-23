package com.cabrales.inventario.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cabrales.inventario.dto.Usuarios;

public interface UsuarioDao extends JpaRepository<Usuarios, Integer> {

}
