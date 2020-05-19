package model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;

@Data
@Entity
@Table(name = "player")
@EqualsAndHashCode(of = "id")
@ToString(exclude = "team")
public class Player {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	@Column(name = "first_name", nullable = false)
	private String firstName;

	@Column(name = "last_name", nullable = false)
	private String lastName;

	@Column
	@Enumerated(EnumType.STRING)
	private Position position;

	@Column(nullable = false)
	private Date birthday;

	@ManyToOne
	@JoinColumn(name = "team_id")
	private Team team;

	public enum Position {
		GOALKEEPER,
		DEFENDER,
		MIDFIELDER,
		FORWARD
	}
}
