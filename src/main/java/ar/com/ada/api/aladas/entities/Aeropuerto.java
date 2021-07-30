package ar.com.ada.api.aladas.entities;

import javax.persistence.*;

@Entity
@Table(name = "aeropuerto")
public class Aeropuerto {
    
    @Id
    @Column(name = "aeropueto_id")
    private Integer aeropuertoid;

    @Column(name = "nombre_aeropuerto")
    private String nombreAeropueto;

    @Column(name = "codigo_iata")
    private String codigoIata;

    public Integer getAeropuertoid() {
        return aeropuertoid;
    }

    public void setAeropuertoid(Integer aeropuertoid) {
        this.aeropuertoid = aeropuertoid;
    }

    public String getNombreAeropueto() {
        return nombreAeropueto;
    }

    public void setNombreAeropueto(String nombreAeropueto) {
        this.nombreAeropueto = nombreAeropueto;
    }

    public String getCodigoIata() {
        return codigoIata;
    }

    public void setCodigoIata(String codigoIata) {
        this.codigoIata = codigoIata;
    }

    

}
