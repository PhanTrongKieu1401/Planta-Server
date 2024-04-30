package nhom6.example.Planta.payload.response;

import java.sql.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import nhom6.example.Planta.payload.CareCalendar;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CareCalendarResponse implements Comparable<CareCalendarResponse> {
	
	private Date dateCare;
	private List<CareCalendar> careCalendars;
	@Override
	public int compareTo(CareCalendarResponse o) {
		// TODO Auto-generated method stub
		return this.dateCare.compareTo(o.dateCare);
	}
}
