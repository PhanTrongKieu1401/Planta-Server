package nhom6.example.Planta.payload.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import nhom6.example.Planta.payload.CareSchedule;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CareScheduleResponse {
	private String name;
	List<CareSchedule> careSchedules;
}
