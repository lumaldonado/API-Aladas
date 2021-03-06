package ar.com.ada.api.aladas.entities;

import java.util.*;

import javax.persistence.*;

import org.hibernate.annotations.NaturalId;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usuario_id")
    private Integer usuarioId;

    @NaturalId
    private String username;

    private String password;

    @Column(name = "mail")
    private String email;

    @Column(name = "fecha_loggin")
    private Date fechalogin;

    @Column(name = "tipo_usuario_id")
    private Integer tipoUsuario;

    @OneToOne
    @JoinColumn(name = "staff_id", referencedColumnName = "staff_id")
    // primero se pone en nombre de la columna en esta tabla,
    // y despues el nombre de la columna de la tabla de donde viene la FK
    private Staff staff;

    @OneToOne
    @JoinColumn(name = "pasajero_id", referencedColumnName = "pasajero_id")
    private Pasajero pasajero;

    public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getFechalogin() {
        return fechalogin;
    }

    public void setFechalogin(Date fechalogin) {
        this.fechalogin = fechalogin;
    }

    public TipoUsuarioEnum getTipoUsuario() {
        return TipoUsuarioEnum.parse(this.tipoUsuario);
    }

    public void setTipoUsuario(TipoUsuarioEnum tipoUsuario) {
        this.tipoUsuario = tipoUsuario.getValue();
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public Pasajero getPasajero() {
        return pasajero;
    }

    public void setPasajero(Pasajero pasajero) {
        this.pasajero = pasajero;
    }

    public Integer obtenerEntityId() {
        
        switch (this.getTipoUsuario()) {
            case PASAJERO:
                return this.getPasajero().getPasajeroId();
            case STAFF:
                return this.getStaff().getStaffId();
            default:
                break;

        }
        return null;
    }

    public enum TipoUsuarioEnum {
        STAFF(1), PASAJERO(2);

        private final Integer value;

        private TipoUsuarioEnum(Integer value) {
            this.value = value;
        }

        public Integer getValue() {
            return value;
        }

        public static TipoUsuarioEnum parse(Integer id) {
            TipoUsuarioEnum status = null; // Default
            for (TipoUsuarioEnum item : TipoUsuarioEnum.values()) {
                if (item.getValue().equals(id)) {
                    status = item;
                    break;
                }
            }
            return status;
        }
    }

}
