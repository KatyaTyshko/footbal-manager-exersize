package repository;

import model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlayerRepository extends JpaRepository<Player, Long> {

	List<Player> getAllByTeamId(Long team_id);
}
