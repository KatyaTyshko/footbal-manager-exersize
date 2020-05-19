package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import repository.PlayerRepository;
import repository.TeamRepository;
import service.PlayerService;
import service.TeamService;

import javax.persistence.EntityManagerFactory;

@Configuration
@ComponentScan(excludeFilters = @ComponentScan.Filter({Controller.class, EnableWebMvc.class}))
public class RootConfig {

	@Bean
	public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);
	}

	@Bean
	public PlayerService playerService(PlayerRepository playerRepository) {
		return new PlayerService(playerRepository);
	}

	@Bean
	public TeamService teamService(TeamRepository teamRepository) {
		return new TeamService(teamRepository);
	}
}
