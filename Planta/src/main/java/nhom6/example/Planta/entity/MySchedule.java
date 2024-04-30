package nhom6.example.Planta.entity;

import java.sql.Date;
import java.sql.Time;

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

@Entity
@Table(name = "myschedule")
public class MySchedule {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "startdate")
	private Date startDate;
	
	@Column(name = "enddate")
	private Date endDate;
	
	@Column(name = "time")
	private Time time;
	
	@Column(name = "frequency")
	private int frequency;
	
	@JoinColumn(name = "idmyplant")
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	private MyPlant myPlant;

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Date getStartDate() {
		return startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public Time getTime() {
		return time;
	}

	public int getFrequency() {
		return frequency;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}

	public void setMyPlant(MyPlant myPlant) {
		this.myPlant = myPlant;
	}
	
}
