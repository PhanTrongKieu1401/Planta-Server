package nhom6.example.Planta.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.ToString;

@ToString
@Entity
@Table(name = "plant")
public class Plant {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "typeplant")
	private String typePlant;
	
	@Column(name = "mainimage")
	private String mainImage;
	
	@Column(name = "secondaryimage")
	private String secondaryImage;
	
	@Column(name = "typesoil")
	private String typeSoil;
	
	@Column(name = "keysearch")
	private String keySearch;

	@Column(name = "maturesize")
	private String matureSize;
	
	@Column(name = "maturetime")
	private String matureTime;
	
	@Column(name = "description")
	private String description;
	
	@OneToMany(mappedBy = "plant", cascade = CascadeType.ALL)
	private List<Schedule> schedules;
	
	@OneToMany(mappedBy = "plant", cascade = CascadeType.ALL)
	private List<Weather> weathers;
	
	@OneToMany(mappedBy = "plant", cascade = CascadeType.ALL)
	private List<HarvestSeason> harvestSeasons;

	public Plant() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Plant(int id, String name, String typePlant, String mainImage, String secondaryImage, String typeSoil,
			String keySearch, String matureSize, String matureTime, String description) {
		super();
		this.id = id;
		this.name = name;
		this.typePlant = typePlant;
		this.mainImage = mainImage;
		this.secondaryImage = secondaryImage;
		this.typeSoil = typeSoil;
		this.keySearch = keySearch;
		this.matureSize = matureSize;
		this.matureTime = matureTime;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getTypePlant() {
		return typePlant;
	}

	public String getMainImage() {
		return mainImage;
	}

	public String getSecondaryImage() {
		return secondaryImage;
	}

	public String getTypeSoil() {
		return typeSoil;
	}

	public String getKeySearch() {
		return keySearch;
	}

	public String getMatureSize() {
		return matureSize;
	}

	public String getMatureTime() {
		return matureTime;
	}

	public String getDescription() {
		return description;
	}

	public List<Schedule> getSchedules() {
		return schedules;
	}

	public List<Weather> getWeathers() {
		return weathers;
	}

	public List<HarvestSeason> getHarvestSeasons() {
		return harvestSeasons;
	}

	
	
}
