package nhom6.example.Planta.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "note")
public class Note {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "image")
	private String image;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "numberofflower")
	private int numberOfFlower;
	
	@Column(name = "numberoffruit")
	private int numberOfFruit;
	
	@Column(name = "height")
	private int height;
	
	@JoinColumn(name = "idmyplant")
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	private MyPlant myPlant;
}
