import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "perfil")
@Getter
@Setter

public class Perfil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

  private String tipoDocumento;
  private String numeroDocumento;
  private String nombre;
  private String apellido;
  private String direccion;
  private String telefono;

  @OneToOne
    @JoinColumn(name = "usuario_id", unique = true
        private Usuario usuario;
    )

    @OneToMany(mappedBy = "perfil")
private List<Prestamo> prestamos;

}
