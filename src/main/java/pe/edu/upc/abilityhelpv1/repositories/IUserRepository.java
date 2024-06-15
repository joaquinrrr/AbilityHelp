package pe.edu.upc.abilityhelpv1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upc.abilityhelpv1.entities.User;

import java.util.List;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {

    public User findByUsername(String nameUser);

    /*@Query("select count(u.username) from User u where u.username =:username")
    public int buscarUsername(@Param("username") String nombre);
    @Transactional
    @Modifying
    @Query(value = "insert into rol (rol, user_id) VALUES (:rol, :user_id)", nativeQuery = true)
    public void insRol(@Param("rol") String authority, @Param("user_id") Long user_id);*/

}
