package pe.edu.upc.abilityhelpv1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.abilityhelpv1.entities.Meeting;
import pe.edu.upc.abilityhelpv1.servicesinterfaces.IMeetServices;

public interface IMeetRepository extends JpaRepository<Meeting, Integer> {
}
