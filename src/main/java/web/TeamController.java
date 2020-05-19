package web;

import lombok.RequiredArgsConstructor;
import model.Player;
import model.Team;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.TeamService;

import java.util.List;

@Controller
@RequestMapping("/teams")
@RequiredArgsConstructor
public class TeamController {

	private final TeamService teamService;

	@GetMapping
	public List<Team> getAll() {
		return teamService.getAll();
	}

	@GetMapping("/{id}")
	public Team getById(@PathVariable("id") Long id) {
		return teamService.getById(id);
	}

	@GetMapping("/{id}/captain")
	public Player getCaptainByTeamId(@PathVariable("id") Long teamId) {
		return teamService.getCaptainByTeamId(teamId);
	}

	@PostMapping
	public Team create(@RequestParam Team team) {
		if (team.getId() != null)
			throw new IllegalStateException();

		return teamService.save(team);
	}

	@PostMapping("/{id}/player")
	public void addPlayer(@PathVariable("id") Long teamId, Player player) {
		if (player.getId() != null)
			throw new IllegalStateException();

		teamService.addPlayerToTeam(teamId, player);
	}

	@PutMapping("/{id}")
	public Team update(@PathVariable("id") Long id, @RequestParam Team team) {
		team.setId(id);
		return teamService.save(team);
	}

	@PutMapping("/{id}/captain")
	public void assignCaptain(@PathVariable("id") Long teamId, @RequestParam Player captain) {
		if (captain.getId() == null)
			throw new IllegalStateException();

		teamService.assignCaptain(teamId, captain);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) {
		teamService.delete(id);
	}
}
