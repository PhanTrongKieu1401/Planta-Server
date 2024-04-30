package nhom6.example.Planta.payload.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import nhom6.example.Planta.entity.MySchedule;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MyPlantScheduleResponse {

	private int id;
	
	private String name;
	
	private String image;
	
	List<MySchedule> mySchedules;
}
