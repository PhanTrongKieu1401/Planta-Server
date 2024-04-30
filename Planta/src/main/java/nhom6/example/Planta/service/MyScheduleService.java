package nhom6.example.Planta.service;

import java.util.List;

import nhom6.example.Planta.entity.MySchedule;
import nhom6.example.Planta.payload.request.MyScheduleRequest;
import nhom6.example.Planta.payload.response.CareCalendarResponse;


public interface MyScheduleService {
	
	public List<CareCalendarResponse> getMyCareCalendar(int myPlantId);
	
	public MySchedule createMySchedule(MyScheduleRequest request);
	
	public MySchedule updateMySchedule(int myScheduleId, MyScheduleRequest request);
	
	public MySchedule getMySchedule(int myScheduleId);
	
	public List<MySchedule> getListMyScheduleByIdUser(int id);
	
	public List<MySchedule> getListMyScheduleByIdMyPlant(int id);
	
	public void deleteMySchedule(int myScheduleId);
	

}
