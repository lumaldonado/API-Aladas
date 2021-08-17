package ar.com.ada.api.aladas.repos;

import ar.com.ada.api.aladas.entities.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    public Usuario findByUsername(String userName);

    public Usuario findByEmail(String email);

}
