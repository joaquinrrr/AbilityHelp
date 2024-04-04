package pe.edu.upc.abilityhelpv1.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.abilityhelpv1.entities.Auth;


public interface IAuthRepository extends JpaRepository <Auth, Integer> {
}
