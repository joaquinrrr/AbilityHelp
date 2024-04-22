package pe.edu.upc.abilityhelpv1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.abilityhelpv1.entities.Incidents;

@Repository
public interface IIncidentsRepository extends JpaRepository<Incidents, Integer> {
}
