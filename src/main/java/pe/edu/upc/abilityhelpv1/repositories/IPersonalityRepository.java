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
    @Query(value = "select name_personality, count(*) as Quantity_of_Users FROM personality \n" +
            "where name_personality =:name \n" +
            "group by name_personality \n", nativeQuery = true)
    public List<String[]> quantityUserPerPersonality(@Param("name") String name);

    //cambiar query


}
