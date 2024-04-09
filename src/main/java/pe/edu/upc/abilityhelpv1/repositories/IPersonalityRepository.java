package pe.edu.upc.abilityhelpv1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.abilityhelpv1.entities.Personalities;
@Repository
public interface IPersonalityRepository extends JpaRepository<Personalities, Integer> {
}
