package ar.com.ada.api.aladas.services;
import java.math.BigDecimal;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import ar.com.ada.api.aladas.entities.Aeropuerto;
import ar.com.ada.api.aladas.entities.Vuelo;
import ar.com.ada.api.aladas.entities.Vuelo.EstadoVueloEnum;
import ar.com.ada.api.aladas.repos.VueloRepository;

@Service
public class VueloService {

    @Autowired
    private VueloRepository repo;
    @Autowired
    private AeropuertoService aeropservice;

    public void crear(Vuelo vuelo){
        
        if(this.validar(vuelo) == ValidacionVueloDataEnum.OK){
        vuelo.setEstadoVueloId(EstadoVueloEnum.GENERADO);
        repo.save(vuelo);
        }
    }

    public Vuelo crear(Date fecha, Integer capacidad, String aeropuertoOrigenIATA, String aeropuertoDestinoIATA, BigDecimal precio, String codigoMoneda){

         Vuelo vuelo = new Vuelo();
         vuelo.setFecha(fecha);
         vuelo.setCapacidad(capacidad);

         Aeropuerto aeropuertoOrigen = aeropservice.buescarPorCodigoIATA(aeropuertoOrigenIATA);
         Aeropuerto aeropuertoDestino = aeropservice.buescarPorCodigoIATA(aeropuertoDestinoIATA);

         vuelo.setAeropuertoOrigen(aeropuertoOrigen.getAeropuertoId());
         vuelo.setAeropuertoDestino(aeropuertoDestino.getAeropuertoId());

         vuelo.setPrecio(precio);
         vuelo.setCodigoMoneda(codigoMoneda);

         return repo.save(vuelo);
    }

    public ValidacionVueloDataEnum validar(Vuelo vuelo){
        if(!validarPrecio(vuelo))
        return ValidacionVueloDataEnum.ERROR_PRECIO;

        if(!validarAeropuertoOrigenDiffDestino(vuelo))
        return ValidacionVueloDataEnum.ERROR_AEROPUERTOS_IGUALES;

        return ValidacionVueloDataEnum.OK;

    }

    public boolean validarPrecio(Vuelo vuelo){
        
        if (vuelo.getPrecio() == null){
            return false;
        }
        if (vuelo.getPrecio().doubleValue() > 0)
        return true;

        return false;

    }
    

    public boolean validarAeropuertoOrigenDiffDestino(Vuelo vuelo){

        /*if(vuelo.getAeropuertoDestino() != vuelo.getAeropuertoOrigen())
        return true;
        else 
        return false;*/

        return vuelo.getAeropuertoDestino() != vuelo.getAeropuertoOrigen();

    }

    public enum ValidacionVueloDataEnum {
        OK, ERROR_PRECIO, ERROR_AEROPUERTO_ORIGEN, ERROR_AEROPUERTO_DESTINO,
        ERROR_FECHA, ERROR_MONEDA, ERROR_CAPACIDAD_MINIMA, ERROR_CAPACIDAD_MAXIMA,
        ERROR_AEROPUERTOS_IGUALES,

    }

    public Vuelo buscarPorId(Integer id) {

        Optional<Vuelo> opVuelo =  repo.findById(id);
        Vuelo vuelo = null;

        if(opVuelo.isPresent())
            vuelo = opVuelo.get();

        return vuelo;
    }

    public boolean existePorId(int id) {

        Vuelo vuelo = repo.findByVueloId(id);
        return vuelo != null;
    }
    public void actualizar(Vuelo vuelo) {
        repo.save(vuelo);
    }

    public List<Vuelo> traerVuelosAbiertos() {
        return repo.findByEstadoVueloId(EstadoVueloEnum.ABIERTO.getValue());
    }

    public List<Vuelo> buscarOrigen(Integer id) {

        return repo.findByAeropuertoOrigen(id);
    }

    public List<Vuelo> buscarDestino(Integer id) {

        return repo.findByAeropuertoDestino(id);
    }


    
}
