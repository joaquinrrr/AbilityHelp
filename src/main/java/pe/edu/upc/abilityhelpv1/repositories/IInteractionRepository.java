package pe.edu.upc.abilityhelpv1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.abilityhelpv1.entities.Interaction;

import java.util.List;

@Repository
public interface IInteractionRepository extends JpaRepository<Interaction, Integer> {
    @Query(value = "select usend.username as Sender, urec.username as Receiver, \n" +
            "ti.interaction as Interaction, i.date_interaction as Date from interaction as i \n" +
            "inner join type_interacion as ti ON ti.id = i.interaction_id \n" +
            "inner join user_table as usend ON usend.id_user = i.user_id_sender \n" +
            "inner join user_table as urec ON urec.id_user = i.user_id_receiver \n" +
            "group by usend.username, urec.username, ti.interaction, i.date_interaction ", nativeQuery = true)
    public List<String[]> interactionWithUsers();
}
