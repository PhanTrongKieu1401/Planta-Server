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
@Table(name = "weather")
public class Weather {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "humidity")
	private int humidity;
	
	@Column(name = "temperature")
	private int temperature;
	
	@Column(name = "advice")
	private String advice;
	
	@JoinColumn(name = "idplant")
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	private Plant plant;
}
