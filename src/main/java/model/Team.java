package model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "team")
@Data
@EqualsAndHashCode(of = "id")
public class Team {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	@Column(nullable = false)
	private String name;

	@OneToOne
	@JoinColumn(name ="captain_id")
	private Player captain;

	@OneToMany(mappedBy = "team", cascade = CascadeType.PERSIST)
	@Setter(AccessLevel.PRIVATE)
	private List<Player> players = new ArrayList<>();

	public void addPlayer(Player player) {
		player.setTeam(this);
		players.add(player);
	}

}
