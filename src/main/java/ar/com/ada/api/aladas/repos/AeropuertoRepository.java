package ar.com.ada.api.aladas.repos;
import ar.com.ada.api.aladas.entities.Aeropuerto;

import org.springframework.beans.factory.annotation.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

public interface AeropuertoRepository extends JpaRepository<Aeropuerto,Integer>{
    //el integer va porque es el tipo de la PK de Aeropuerto,
    //si no fuera de tipo Integer iria otra cosa

}
