package pe.edu.upc.abilityhelpv1;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "ABILITYHELP",version = "1.0",description = "BuscarUsuario"))
public class Abilityhelpv1Application {

	public static void main(String[] args) {
		SpringApplication.run(Abilityhelpv1Application.class, args);
	}

}
