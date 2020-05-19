package web;

import lombok.RequiredArgsConstructor;
import model.Player;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.PlayerService;

import java.util.List;

@Controller
@RequestMapping("/players")
@RequiredArgsConstructor
public class PlayerController {

	private final PlayerService playerService;

	@GetMapping
	public List<Player> getAll() {
		return playerService.getAll();
	}

	@GetMapping("/")
	public List<Player> getAllByTeam(@RequestParam("teamId") Long teamId) {
		return playerService.getAllByTeam(teamId);
	}

	@GetMapping("/{id}")
	public Player getById(@PathVariable("id") Long id) {
		return playerService.getById(id);
	}

	@PostMapping
	public Player create(@RequestParam Player player) {
		if (player.getId() != null)
			throw new IllegalStateException();

		return playerService.save(player);
	}

	@PutMapping("/{id}")
	public Player update(@PathVariable("id") Long id, @RequestParam Player player) {
		player.setId(id);
		return playerService.save(player);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) {
		playerService.delete(id);
	}
}
