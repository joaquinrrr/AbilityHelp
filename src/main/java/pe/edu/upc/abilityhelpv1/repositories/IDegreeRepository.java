package pe.edu.upc.abilityhelpv1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.abilityhelpv1.entities.Degree;

import java.util.List;

@Repository
public interface IDegreeRepository extends JpaRepository<Degree, Integer> {
    @Query(value = "select count(*) as Quantity_User, p.name_personality as Personality, d.name_degree as Degree from degree as d \n" +
            "inner join user_table as us ON us.id_user = d.user_id \n" +
            "inner join personality as p ON p.id_personality = us.personality_id \n" +
            "group by p.name_personality, d.name_degree ", nativeQuery = true)
    public List<String[]> quantityPersonalityDegreeUser();
}
