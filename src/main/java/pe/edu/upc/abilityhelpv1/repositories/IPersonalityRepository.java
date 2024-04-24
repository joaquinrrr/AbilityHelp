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
    @Query(value = "select p.name_personality, count(*) from user_table as us \n" +
            "inner join personality as p ON p.id_personality = us.personality_id \n" +
            "where p.name_personality =:name \n" +
            "group by p.name_personality \n", nativeQuery = true)
    public List<String[]> quantityUserPerPersonality(@Param("name") String name);

    //cambiar query


}
