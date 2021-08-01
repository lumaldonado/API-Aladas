package ar.com.ada.api.aladas.entities;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "staff")
public class Staff extends Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "staff_id")
    private Integer staffId;

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }
    
    @OneToOne(mappedBy = "staff", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Usuario usuario;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
        usuario.setStaff(this);
    }

    
}
