package br.mil.eb.dashboard_sgl_sg7;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Dashboard SGL-SG7 API", version = "1.0", contact = @Contact(email = "hassankrc@ctcea.org.br", name = "Hassan Kuntze")), servers = {
		@Server(url = "http://localhost:9989/dashboard-sgl-sg7/api/", description = "API"),
		@Server(url = "http://10.134.0.163:9991/dashboard-sgl-sg7/api/", description = "Homologação"),
		@Server(url = "http://10.134.0.163:9989/dashboard-sgl-sg7/api/", description = "Produção") }, security = @SecurityRequirement(name = "oauth2"))
@SecurityScheme(name = "oauth2", type = SecuritySchemeType.HTTP, scheme = "bearer", bearerFormat = "JWT", in = SecuritySchemeIn.HEADER, description = "Insira o token JWT gerado")
public class DashboardSglSg7Application {

	public static void main(String[] args) {
		SpringApplication.run(DashboardSglSg7Application.class, args);
	}
}