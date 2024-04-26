package pe.edu.upc.abilityhelpv1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.abilityhelpv1.entities.Personalities;

import java.util.List;

@Repository
public interface IPersonalityRepository extends JpaRepository<Personalities, Integer> {

    //PERSONALITY ACTUALIZAR

    //cambiar query


}
