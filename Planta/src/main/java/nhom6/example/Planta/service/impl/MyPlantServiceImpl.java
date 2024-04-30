package nhom6.example.Planta.service.impl;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nhom6.example.Planta.entity.MyPlant;
import nhom6.example.Planta.entity.MySchedule;
import nhom6.example.Planta.payload.CareSchedule;
import nhom6.example.Planta.payload.request.MyPlantRequest;
import nhom6.example.Planta.payload.response.CareScheduleResponse;
import nhom6.example.Planta.payload.response.MyPlantScheduleResponse;
import nhom6.example.Planta.payload.response.MyPlantResponse;
import nhom6.example.Planta.payload.response.PlantResponseOfMyPlant;
import nhom6.example.Planta.repository.MyPlantRepository;
import nhom6.example.Planta.service.MyPlantService;

@Service
public class MyPlantServiceImpl implements MyPlantService {

	@Autowired
	private MyPlantRepository myPlantRepository;
	
	
	@Override
	public List<MyPlantResponse> getAllMyPlantByUser(int id){
		List<MyPlant> myPlants = myPlantRepository.getAllMyPlantByUser(id);

		List<MyPlantResponse> myPlantResponses = new ArrayList<>();
		for(MyPlant myPlant : myPlants) {
			PlantResponseOfMyPlant plantResponseOfMyPlant = new PlantResponseOfMyPlant();
			plantResponseOfMyPlant.setId(myPlant.getPlant().getId());
			plantResponseOfMyPlant.setName(myPlant.getPlant().getName());
			plantResponseOfMyPlant.setTypePlant(myPlant.getPlant().getTypePlant());
			plantResponseOfMyPlant.setMainImage(myPlant.getPlant().getMainImage());
			plantResponseOfMyPlant.setSecondaryImage(myPlant.getPlant().getSecondaryImage());
			plantResponseOfMyPlant.setSecondaryImage(myPlant.getPlant().getTypeSoil());
			plantResponseOfMyPlant.setSecondaryImage(myPlant.getPlant().getMatureSize());
			plantResponseOfMyPlant.setSecondaryImage(myPlant.getPlant().getMatureTime());
			plantResponseOfMyPlant.setSecondaryImage(myPlant.getPlant().getDescription());
			
			MyPlantResponse myPlantResponse = new MyPlantResponse();
			myPlantResponse.setId(myPlant.getId());
			myPlantResponse.setName(myPlant.getName());
			myPlantResponse.setGrownDate(myPlant.getGrownDate());
			myPlantResponse.setKindOfLight(myPlant.getKindOfLight());
			myPlantResponse.setImage(myPlant.getImage());
			myPlantResponse.setPlantResponseOfMyPlant(plantResponseOfMyPlant);
			
			myPlantResponses.add(myPlantResponse);
		}
		return myPlantResponses;
	}
	
	@Override
	public List<MyPlantResponse> getAllMyPlantByUserAndKey(int id, String key) {
		List<MyPlant> myPlants = myPlantRepository.getAllMyPlantByUserAndKey(id, key);

		List<MyPlantResponse> myPlantResponses = new ArrayList<>();
		for(MyPlant myPlant : myPlants) {
			PlantResponseOfMyPlant plantResponseOfMyPlant = new PlantResponseOfMyPlant();
			plantResponseOfMyPlant.setId(myPlant.getPlant().getId());
			plantResponseOfMyPlant.setName(myPlant.getPlant().getName());
			plantResponseOfMyPlant.setTypePlant(myPlant.getPlant().getTypePlant());
			plantResponseOfMyPlant.setMainImage(myPlant.getPlant().getMainImage());
			plantResponseOfMyPlant.setSecondaryImage(myPlant.getPlant().getSecondaryImage());
			plantResponseOfMyPlant.setSecondaryImage(myPlant.getPlant().getTypeSoil());
			plantResponseOfMyPlant.setSecondaryImage(myPlant.getPlant().getMatureSize());
			plantResponseOfMyPlant.setSecondaryImage(myPlant.getPlant().getMatureTime());
			plantResponseOfMyPlant.setSecondaryImage(myPlant.getPlant().getDescription());
			
			MyPlantResponse myPlantResponse = new MyPlantResponse();
			myPlantResponse.setId(myPlant.getId());
			myPlantResponse.setName(myPlant.getName());
			myPlantResponse.setGrownDate(myPlant.getGrownDate());
			myPlantResponse.setKindOfLight(myPlant.getKindOfLight());
			myPlantResponse.setImage(myPlant.getImage());
			myPlantResponse.setPlantResponseOfMyPlant(plantResponseOfMyPlant);
			
			myPlantResponses.add(myPlantResponse);
		}
		return myPlantResponses;
	}
	
	@Override
	public MyPlantResponse getMyPlantByUser(int idUser, int idMyPlant) {
		MyPlant myPlant = myPlantRepository.getMyPlantByUser(idUser, idMyPlant);

		PlantResponseOfMyPlant plantResponseOfMyPlant = new PlantResponseOfMyPlant();
		plantResponseOfMyPlant.setId(myPlant.getPlant().getId());
		plantResponseOfMyPlant.setName(myPlant.getPlant().getName());
		plantResponseOfMyPlant.setTypePlant(myPlant.getPlant().getTypePlant());
		plantResponseOfMyPlant.setMainImage(myPlant.getPlant().getMainImage());
		plantResponseOfMyPlant.setSecondaryImage(myPlant.getPlant().getSecondaryImage());
		plantResponseOfMyPlant.setTypeSoil(myPlant.getPlant().getTypeSoil());
		plantResponseOfMyPlant.setMatureSize(myPlant.getPlant().getMatureSize());
		plantResponseOfMyPlant.setMatureTime(myPlant.getPlant().getMatureTime());
		plantResponseOfMyPlant.setDescription(myPlant.getPlant().getDescription());
		
		MyPlantResponse myPlantResponse = new MyPlantResponse();
		myPlantResponse.setId(myPlant.getId());
		myPlantResponse.setName(myPlant.getName());
		myPlantResponse.setGrownDate(myPlant.getGrownDate());
		myPlantResponse.setKindOfLight(myPlant.getKindOfLight());
		myPlantResponse.setImage(myPlant.getImage());
		myPlantResponse.setPlantResponseOfMyPlant(plantResponseOfMyPlant);
		
		return myPlantResponse;
	}
	
	@Override
	public MyPlant getMyPlantByUserAndName(int idUser, String name) {
		MyPlant myPlant = myPlantRepository.getMyPlantByUserAndName(idUser, name);
		return myPlant;
	}
	
	@Override
	public MyPlant getMyPlantByUserAndNameNotId(int idUser, String name, int idMyPlant) {
		MyPlant myPlant = myPlantRepository.getMyPlantByUserAndNameNotId(idUser, name, idMyPlant);
		return myPlant;
	}

	@Override
	public MyPlantRequest getLastMyPlantByUser(int idUser) {
		MyPlant myPlant = myPlantRepository.getLastMyPlantByUser(idUser);
		
		MyPlantRequest myPlantRequest = new MyPlantRequest();
		myPlantRequest.setId(myPlant.getId());
		myPlantRequest.setName(myPlant.getName());
		myPlantRequest.setGrownDate(myPlant.getGrownDate());
		myPlantRequest.setKindOfLight(myPlant.getKindOfLight());
		myPlantRequest.setImage(myPlant.getImage());
		myPlantRequest.setIdPlant(myPlant.getPlant().getId());
		
		return myPlantRequest;
	}
	
	@Override
	public boolean addMyPlant(int idUser, MyPlantRequest myPlantRequest) {
		int check = myPlantRepository.addMyPlant(myPlantRequest.getGrownDate(), myPlantRequest.getImage(), myPlantRequest.getKindOfLight(), 
				myPlantRequest.getName(), myPlantRequest.getIdPlant(), idUser);
		if(check > 0) 
			return true;
		else
			return false;
	}

	@Override
	public boolean updateMyPlant(int idUser, MyPlantRequest myPlantRequest) {
		int check = myPlantRepository.updateMyPlant(myPlantRequest.getGrownDate(), myPlantRequest.getImage(), myPlantRequest.getKindOfLight(), myPlantRequest.getName(), idUser);
		if(check > 0) 
			return true;
		else
			return false;
	}

	@Override
	public boolean deleteMyPlant(int idMyPlant) {
		int check = myPlantRepository.deleteMyPlant(idMyPlant);
		if(check > 0) 
			return true;
		else
			return false;
	}
	
	@Override
	public List<CareScheduleResponse> getAllMyPlantToDayByUser(int userId) {
		List<MyPlant> myPlants = myPlantRepository.getAllMyPlantByUserId(userId)
	    		.orElseThrow(() -> new RuntimeException("Không tìm thấy người dùng"));
		
	    Map<String, List<CareSchedule>> groupedSchedules = new HashMap<>();

	    LocalDate todayLocal = LocalDate.now();
	    
	    // Nhóm các CareSchedule theo tên bài tập
	    for (MyPlant myPlant : myPlants) {
	        List<MySchedule> mySchedules = myPlant.getMySchedules();
	        for (MySchedule mySchedule : mySchedules) {
	        	
	        	LocalDate startDateLocal = mySchedule.getStartDate().toLocalDate();
	        	LocalDate endDateLocal = mySchedule.getEndDate().toLocalDate();
	        	
	        	if ((todayLocal.isAfter(startDateLocal) || todayLocal.isEqual(startDateLocal)) && 
	        			(todayLocal.isBefore(endDateLocal) || todayLocal.isEqual(endDateLocal))) {
	        		
	                 long daysBetween = java.time.temporal.ChronoUnit.DAYS.between(startDateLocal, todayLocal);
	                 if (daysBetween % mySchedule.getFrequency() == 0) {
			            String scheduleName = mySchedule.getName();
			            CareSchedule careSchedule = CareSchedule.builder()
			            		.myPlantId(myPlant.getId())
			            		.myPlantName(myPlant.getName())
			            		.image(myPlant.getImage())
			            		.startDate(mySchedule.getStartDate())
			            		.endDate(mySchedule.getEndDate())
			            		.time(mySchedule.getTime())
			            		.frequency(mySchedule.getFrequency())
			            		.build();
		
			            groupedSchedules.computeIfAbsent(scheduleName, k -> new ArrayList<>()).add(careSchedule);
	                 }
	        	 }
	        }
	    }

	    // Tạo danh sách MyCareScheduleResponse từ map đã nhóm
	    List<CareScheduleResponse> scheduleResponses = new ArrayList<>();
	    for (Map.Entry<String, List<CareSchedule>> entry : groupedSchedules.entrySet()) {
	        CareScheduleResponse myCareScheduleResponse = new CareScheduleResponse();
	        myCareScheduleResponse.setName(entry.getKey());
	        myCareScheduleResponse.setCareSchedules(entry.getValue());
	        scheduleResponses.add(myCareScheduleResponse);
	    }

	    return scheduleResponses;
	}
	
	@Override
	public List<MyPlantScheduleResponse> getMyPlantScheduleByUser(int userId) {
		List<MyPlant> myPlants = myPlantRepository.getAllMyPlantByUserId(userId)
	    		.orElseThrow(() -> new RuntimeException("Không tìm thấy người dùng"));
		
		LocalDate localDate = LocalDate.now();
	    Date currentDate = Date.valueOf(localDate);
		
		List<MyPlantScheduleResponse> myPlantResponses = new ArrayList<>();
		for(MyPlant myPlant : myPlants) {
			
			MyPlantScheduleResponse myPlantResponse = MyPlantScheduleResponse.builder()
					.id(myPlant.getId())
					.name(myPlant.getName())
					.image(myPlant.getImage())
					.mySchedules(filterSchedules(myPlant.getMySchedules(), currentDate))
					.build();
			myPlantResponses.add(myPlantResponse);
		}
		return myPlantResponses;
	}
	
	public List<MySchedule> filterSchedules(List<MySchedule> schedules, Date currentDate) {
        return schedules.stream()
                .filter(schedule -> !schedule.getEndDate().before(currentDate))
                .collect(Collectors.toList());
    }
	
	@Override
	public List<MyPlantScheduleResponse> getAllMyPlantCalendarByUser(int userId) {
		List<MyPlant> myPlants = myPlantRepository.getAllMyPlantByUserId(userId)
	    		.orElseThrow(() -> new RuntimeException("Không tìm thấy người dùng"));
		
		List<MyPlantScheduleResponse> myPlantResponses = new ArrayList<>();
		for(MyPlant myPlant : myPlants) {
			MyPlantScheduleResponse myPlantResponse = MyPlantScheduleResponse.builder()
					.id(myPlant.getId())
					.name(myPlant.getName())
					.image(myPlant.getImage())
					.mySchedules(myPlant.getMySchedules())
					.build();
			myPlantResponses.add(myPlantResponse);
		}
		return myPlantResponses;
	}
}