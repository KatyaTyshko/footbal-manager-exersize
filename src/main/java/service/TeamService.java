package service;

import lombok.RequiredArgsConstructor;
import model.Player;
import model.Team;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.TeamRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class TeamService {

	private final TeamRepository teamRepository;

	@Transactional(readOnly = true)
	public Team getById(Long id) {
		return teamRepository
			.findById(id)
			.orElseThrow(() -> new EntityNotFoundException("Team not found by id " + id));
	}

	public Team save(Team team) {
		return teamRepository.save(team);
	}

	public void delete(Long id) {
		teamRepository.deleteById(id);
	}

	@Transactional(readOnly = true)
	public List<Team> getAll() {
		return teamRepository.findAll();
	}

	@Transactional(readOnly = true)
	public Player getCaptainByTeamId(Long teamId) {
		return getById(teamId).getCaptain();
	}

	public void addPlayerToTeam(Long teamId, Player player) {
		var team = getById(teamId);
		team.addPlayer(player);
	}

	public void assignCaptain(Long teamId, Player captain) {
		var team = getById(teamId);
		team.setCaptain(captain);
	}
}
