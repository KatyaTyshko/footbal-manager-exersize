package service;

import lombok.RequiredArgsConstructor;
import model.Player;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.PlayerRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;


@RequiredArgsConstructor
@Transactional
@Service
public class PlayerService {

	private final PlayerRepository playerRepository;

	@Transactional(readOnly = true)
	public Player getById(Long id) {
		return playerRepository
			.findById(id)
			.orElseThrow(() -> new EntityNotFoundException("Player not found by id " + id));
	}

	public Player save(Player pla) {
		return playerRepository.save(pla);
	}

	public void delete(Long id) {
		playerRepository.deleteById(id);
	}

	@Transactional(readOnly = true)
	public List<Player> getAll() {
		return playerRepository.findAll();
	}

	public List<Player> getAllByTeam(Long teamId) {
		return playerRepository.getAllByTeamId(teamId);
	}
}
