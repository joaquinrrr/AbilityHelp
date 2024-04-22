package pe.edu.upc.abilityhelpv1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.abilityhelpv1.entities.AssignIncident;

import java.util.List;

@Repository
public interface IAssignIncidentRepository extends JpaRepository<AssignIncident, Integer> {
    @Query(value = "select usrep.username as Reportador, usban.username as Baneado,  \n" +
            "inc.type_incident as Incidente, ai.detail_incident as Detalle from assign_incident as ai \n" +
            "inner join user_table as usrep ON usrep.id_user = ai.id_user_reporter \n" +
            "inner join user_table as usban ON usban.id_user = ai.id_user_ban \n" +
            "inner join incidents as inc ON inc.id = ai.type_incident \n" +
            "where usrep.username =:name", nativeQuery = true)
    public List<String[]> AssignIncidentByUser(@Param("name") String name);

    @Query(value = "select inc.type_incident, count(*) from assign_incident as ai \n" +
            "inner join incidents as inc ON inc.id = ai.type_incident \n" +
            "group by inc.type_incident ", nativeQuery = true)
    public List<String[]> AssignIncidentsCount();

    @Query(value = "select us.username as Reporter, count(*) as Quantity_Incidents from assign_incident as ai \n" +
            "inner join user_table as us ON us.id_user = ai.id_user_reporter \n" +
            "group by us.username ", nativeQuery = true) // native query: PUEDE UTILIZAR UNA QUERY DE SQL
    public List<String[]>quantityUserIncidents();


}
