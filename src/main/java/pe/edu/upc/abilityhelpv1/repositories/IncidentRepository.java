package pe.edu.upc.abilityhelpv1.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.abilityhelpv1.entities.Incidents;
import java.util.List;

@Repository
public interface IncidentRepository extends JpaRepository<Incidents, Integer> {
    public List<Incidents> findIncidentsBy(String type);
}
