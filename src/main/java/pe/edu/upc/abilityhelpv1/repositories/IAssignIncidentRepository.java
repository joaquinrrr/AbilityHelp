package pe.edu.upc.abilityhelpv1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.abilityhelpv1.entities.AssignIncident;

@Repository
public interface IAssignIncidentRepository extends JpaRepository<AssignIncident, Integer> {
}
