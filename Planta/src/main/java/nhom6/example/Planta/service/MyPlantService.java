package nhom6.example.Planta.service;

import java.util.List;

import nhom6.example.Planta.entity.MyPlant;
import nhom6.example.Planta.payload.request.MyPlantRequest;
import nhom6.example.Planta.payload.response.CareScheduleResponse;
import nhom6.example.Planta.payload.response.MyPlantResponse;
import nhom6.example.Planta.payload.response.MyPlantScheduleResponse;

public interface MyPlantService {

	public List<MyPlantResponse> getAllMyPlantByUser(int id);
	public List<MyPlantResponse> getAllMyPlantByUserAndKey(int id, String key);
	public MyPlantResponse getMyPlantByUser(int idUser, int idMyPlant);
	public MyPlant getMyPlantByUserAndName(int idUser, String name);
	public MyPlant getMyPlantByUserAndNameNotId(int idUser, String name, int idMyPlant);
	public MyPlantRequest getLastMyPlantByUser(int idUser);
	public boolean addMyPlant(int idUser, MyPlantRequest myPlantRequest);
	public boolean updateMyPlant(int idUser, MyPlantRequest myPlantRequest);
	public boolean deleteMyPlant(int idMyPlant);
	
	//
	public List<CareScheduleResponse> getAllMyPlantToDayByUser(int userId);
	
	public List<MyPlantScheduleResponse> getMyPlantScheduleByUser(int userId);
	
	public List<MyPlantScheduleResponse> getAllMyPlantCalendarByUser(int userId);
}