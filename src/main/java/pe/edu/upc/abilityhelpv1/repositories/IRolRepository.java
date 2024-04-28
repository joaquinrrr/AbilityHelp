package pe.edu.upc.abilityhelpv1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.abilityhelpv1.entities.Rol;

import java.util.List;

@Repository
public interface IRolRepository extends JpaRepository<Rol,Integer> {

    @Query(value = "select r.rol , count(*) from rol as r \n" +
            "inner join user_table as us ON us.id_user = r.user_id \n" +
            "group by r.rol ", nativeQuery = true)
    public List<String[]> quantityUserPerRol();
}