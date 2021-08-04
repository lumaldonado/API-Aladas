package ar.com.ada.api.aladas.services;

import org.springframework.stereotype.Service;

import ar.com.ada.api.aladas.entities.Aeropuerto;
import ar.com.ada.api.aladas.repos.AeropuertoRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.*;

@Service
public class AeropuertoService{
       
        @Autowired
        private AeropuertoRepository repo;

        //en este caso se pasa como parametro aeropuertoId pq no es autoincremental
        public void crear(Integer aeropuertoId, String nombre, String codigoIATA){
            Aeropuerto aeropuerto = new Aeropuerto();
            aeropuerto.setAeropuertoId(aeropuertoId);
            aeropuerto.setNombre(nombre);
            aeropuerto.setCodigoIATA(codigoIATA);

            repo.save(aeropuerto);

        } 


        public List<Aeropuerto> obtenerTodos(){
            return repo.findAll();

        }

        public Aeropuerto buescarPorCodigoIATA(String codigoIATA){
            return repo.findByCodigoIATA(codigoIATA);

        }

        public boolean ValidarCodigoIATA(Aeropuerto aeropuerto){

            if (aeropuerto.getCodigoIATA().length() != 3)
            return false;

            String codigoIATA = aeropuerto.getCodigoIATA();

            for (int i=0; i<codigoIATA.length(); i++){
                char c = codigoIATA.charAt(i);

                if (!(c>= 'A' && c<='Z'))
                return false;
                
            }

            return true;

         
        }

}

