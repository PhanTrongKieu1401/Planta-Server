package nhom6.example.Planta.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nhom6.example.Planta.entity.MySchedule;
import nhom6.example.Planta.payload.ApiResponse;
import nhom6.example.Planta.payload.request.MyScheduleRequest;
import nhom6.example.Planta.payload.response.CareCalendarResponse;
import nhom6.example.Planta.service.MyScheduleService;

@CrossOrigin
@RestController
@RequestMapping("/api/schedule")
public class MyScheduleController {
	
	@Autowired
	private MyScheduleService myScheduleService;
	
	
	@PostMapping
    public ApiResponse<MySchedule> createUser(@RequestBody MyScheduleRequest request){
        ApiResponse<MySchedule> apiResponse = new ApiResponse<>();
    	apiResponse.setResult(myScheduleService.createMySchedule(request));
    	apiResponse.setSuccess(true);
    	apiResponse.setMessage("success");
    	apiResponse.setCode(200);
    	return apiResponse;
    }
	@GetMapping("/care/{id}")
	public ApiResponse<List<CareCalendarResponse>> getMyCareCalendarByMyPlantId(@PathVariable int id){
		return ApiResponse.<List<CareCalendarResponse>>builder()
				.code(200)
				.success(true)
				.message("success")
				.result(myScheduleService.getMyCareCalendar(id))
				.build();
	}
	
	@GetMapping("/user/{id}")
	public ApiResponse<List<MySchedule>>getListMyScheduleByIdUser(@PathVariable int id){
		List<MySchedule> mySchedules = myScheduleService.getListMyScheduleByIdUser(id);
		
		return ApiResponse.<List<MySchedule>>builder()
				.code(200)
				.success(true)
				.message("success")
				.result(mySchedules)
				.build();
	}
	
	@GetMapping("/plant/{id}")
	public ApiResponse<List<MySchedule>>getListMyScheduleByIdMyPlant(@PathVariable int id){
		List<MySchedule> mySchedules = myScheduleService.getListMyScheduleByIdMyPlant(id);
		return ApiResponse.<List<MySchedule>>builder()
				.code(200)
				.success(true)
				.message("success")
				.result(mySchedules)
				.build();
	}
	
	@GetMapping("/{myScheduleId}")
    public ApiResponse<MySchedule> getMySchedule(@PathVariable int myScheduleId){
        
		return ApiResponse.<MySchedule>builder()
				.code(200)
				.success(true)
				.message("success")
				.result(myScheduleService.getMySchedule(myScheduleId))
				.build();
    }
	
	@PutMapping("/{myScheduleId}")
    public ApiResponse<MySchedule> updateMySchedule(@PathVariable int myScheduleId, @RequestBody MyScheduleRequest request){
        
		return ApiResponse.<MySchedule>builder()
				.code(200)
				.success(true)
				.message("success")
				.result(myScheduleService.updateMySchedule(myScheduleId, request))
				.build();
    }
	
	@DeleteMapping("/{myScheduleId}")
	public ApiResponse<?> deleteMySchedule(@PathVariable int myScheduleId) {
		myScheduleService.deleteMySchedule(myScheduleId);
		
		return ApiResponse.builder()
				.code(200)
				.success(true)
				.message("delete success")
				.build();
	}

}
