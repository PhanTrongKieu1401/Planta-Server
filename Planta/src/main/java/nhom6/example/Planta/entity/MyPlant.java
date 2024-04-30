package nhom6.example.Planta.entity;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
@Table(name = "myplant")
public class MyPlant {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "growndate")
	private Date grownDate;
	
	@Column(name = "kindoflight")
	private String kindOfLight;
	
	@Column(name = "image")
	private String image;
	
	@JoinColumn(name = "iduser")
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	private User user;
	
	@JoinColumn(name = "idplant")
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	private Plant plant;
	
	@OneToMany(mappedBy = "myPlant", cascade = CascadeType.ALL)
	private List<Note> notes;
	
	@OneToMany(mappedBy = "myPlant", cascade = CascadeType.ALL)
	private List<MySchedule> mySchedules;
}
