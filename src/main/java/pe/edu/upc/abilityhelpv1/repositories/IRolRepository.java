package pe.edu.upc.abilityhelpv1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.abilityhelpv1.entities.Rol;

public interface IRolRepository extends JpaRepository<Rol, Integer> {
}
