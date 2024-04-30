package nhom6.example.Planta.service.impl;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nhom6.example.Planta.entity.MyPlant;
import nhom6.example.Planta.entity.MySchedule;
import nhom6.example.Planta.payload.CareCalendar;
import nhom6.example.Planta.payload.request.MyScheduleRequest;
import nhom6.example.Planta.payload.response.CareCalendarResponse;
import nhom6.example.Planta.repository.MyPlantRepository;
import nhom6.example.Planta.repository.MyScheduleRepository;
import nhom6.example.Planta.service.MyScheduleService;

@Service
public class MyScheduleServiceImpl implements MyScheduleService {
	
	@Autowired
	private MyScheduleRepository myScheduleRepository;
	
	@Autowired
	private MyPlantRepository myPlantRepository;
	
	
	@Override
	public MySchedule createMySchedule(MyScheduleRequest request) {
		
		MySchedule mySchedule = new MySchedule();
		mySchedule.setName(request.getName());
		mySchedule.setStartDate(request.getStartDate());
		mySchedule.setEndDate(request.getEndDate());
		mySchedule.setTime(request.getTime());
		mySchedule.setFrequency(request.getFrequency());
		mySchedule.setMyPlant(getMyPlant(request.getMyPlantId()));
		
		return myScheduleRepository.save(mySchedule);
	}
	
	@Override
	public MySchedule updateMySchedule(int myScheduleId, MyScheduleRequest request) {
		MySchedule mySchedule = getMySchedule(myScheduleId);
		
		mySchedule.setName(request.getName());
		mySchedule.setStartDate(request.getStartDate());
		mySchedule.setEndDate(request.getEndDate());
		mySchedule.setTime(request.getTime());
		mySchedule.setFrequency(request.getFrequency());
		
		return myScheduleRepository.save(mySchedule);
	}
	
	@Override
	public MySchedule getMySchedule(int myScheduleId) {
		return myScheduleRepository.findById(myScheduleId)
				.orElseThrow(() -> new RuntimeException("Không tìm thấy lịch trình của bạn"));
	}
	
	@Override
	public List<MySchedule> getListMyScheduleByIdUser(int id) {
		return myScheduleRepository.findByUserId(id)
				.orElseThrow(() -> new RuntimeException("Không tìm thấy người dùng"));
	}
	
	@Override
	public List<MySchedule> getListMyScheduleByIdMyPlant(int id) {
	
		return myScheduleRepository.findByMyPlantId(id)
				.orElseThrow(() -> new RuntimeException("Cây của bạn không được tìm thấy"));
	}
	
	@Override
	public void deleteMySchedule(int myScheduleId) {
		myScheduleRepository.deleteById(myScheduleId);
	}
	
	private MyPlant getMyPlant(int myPlantId) {
		return myPlantRepository.findById(myPlantId)
				.orElseThrow(() -> new RuntimeException("Cây của bạn không được tìm thấy"));
	}
	
	
	@Override
	public List<CareCalendarResponse> getMyCareCalendar(int myPlantId) {
	    List<MySchedule> mySchedules = myScheduleRepository.findByMyPlantId(myPlantId)
	            .orElseThrow(() -> new RuntimeException("Cây của bạn không được tìm thấy"));

	    // Sử dụng một Map để nhóm CareCalendar theo ngày chăm sóc
	    Map<Date, List<CareCalendar>> careCalendarMap = new HashMap<>();
	    
	    LocalDate localDate = LocalDate.now();
	    Date currentDate = Date.valueOf(localDate);

	    for (MySchedule mySchedule : mySchedules) {
	        Date startDate = mySchedule.getStartDate();
	        Date endDate = mySchedule.getEndDate();
	        int frequency = mySchedule.getFrequency();

	        // Tính toán các ngày chăm sóc từ ngày bắt đầu đến ngày kết thúc với tần suất
	        List<Date> scheduledDates = calculateScheduledDates(startDate, endDate, frequency);

	        // Tạo CareCalendar cho mỗi ngày chăm sóc và thêm vào Map
	        for (Date date : scheduledDates) {
	        	if(!date.before(currentDate)) {
		            List<CareCalendar> careCalendars = careCalendarMap.getOrDefault(date, new ArrayList<>());
	
		            CareCalendar careCalendar = new CareCalendar();
		            careCalendar.setMyScheduleId(mySchedule.getId());
		            careCalendar.setName(mySchedule.getName());
		            careCalendar.setStartDate(startDate);
		            careCalendar.setEndDate(endDate);
		            careCalendar.setTime(mySchedule.getTime());
		            careCalendar.setFrequency(frequency);
	
		            careCalendars.add(careCalendar);
		            careCalendarMap.put(date, careCalendars);
	        	}
	        }
	    }

	    boolean checkToDay = false;
	    // Tạo danh sách MyCareCalendarResponse từ Map
	    List<CareCalendarResponse> calendarResponses = new ArrayList<>();
	    for (Map.Entry<Date, List<CareCalendar>> entry : careCalendarMap.entrySet()) {
	        Date date = entry.getKey();
	        
	        if(date.compareTo(currentDate) == 0) checkToDay = true;
	        
	        List<CareCalendar> careCalendars = entry.getValue();

	        CareCalendarResponse calendarResponse = new CareCalendarResponse();
	        calendarResponse.setDateCare(date);
	        calendarResponse.setCareCalendars(careCalendars);

	        calendarResponses.add(calendarResponse);
	    }
	    if(!checkToDay) {
	    	calendarResponses.add(new CareCalendarResponse(currentDate, null));
	    }
	    Collections.sort(calendarResponses);

	    return calendarResponses;
	}

	// Phương thức để tính toán các ngày chăm sóc từ ngày bắt đầu đến ngày kết thúc với tần suất
	private List<Date> calculateScheduledDates(Date startDate, Date endDate, int frequency) {
	    List<Date> scheduledDates = new ArrayList<>();
	    LocalDate startLocalDate = startDate.toLocalDate();
	    LocalDate endLocalDate = endDate.toLocalDate();

	    while (!startLocalDate.isAfter(endLocalDate)) {
	        scheduledDates.add(Date.valueOf(startLocalDate));
	        startLocalDate = startLocalDate.plusDays(frequency);
	    }

	    return scheduledDates;
	}
}
