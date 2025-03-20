package com.example.PEDIDOSAPP.repositorios;

import com.example.PEDIDOSAPP.modelos.Tienda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITiendaRepositorio extends JpaRepository<Tienda,Integer> {
    //ACA DENTRO DE EL REPO VAN LAS CONSULTAS PERSONALIZADAS
}
