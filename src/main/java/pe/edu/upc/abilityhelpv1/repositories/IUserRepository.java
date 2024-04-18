package pe.edu.upc.abilityhelpv1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.abilityhelpv1.entities.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {

    public User findByUsername(String nameUser);

}
