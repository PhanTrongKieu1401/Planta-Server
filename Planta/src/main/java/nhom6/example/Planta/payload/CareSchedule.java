package nhom6.example.Planta.payload;

import java.sql.Date;
import java.sql.Time;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CareSchedule {
	private int myPlantId;
	private String myPlantName;
	private String image;
	private Date startDate;
	private Date endDate;
	private Time time;
	private int frequency;
}
