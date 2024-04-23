package pe.edu.upc.abilityhelpv1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.abilityhelpv1.entities.Degree;

import java.util.List;

@Repository
public interface IDegreeRepository extends JpaRepository<Degree, Integer> {
    @Query(value = "select name_degree, count(*) as Quantity_User from degree \n" +
            "group by name_degree", nativeQuery = true)
    public List<String[]> quantityUserByCarrer();
}