package nhom6.example.Planta.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nhom6.example.Planta.entity.Plant;
import nhom6.example.Planta.payload.ApiResponse;
import nhom6.example.Planta.payload.response.PlantResponse;
import nhom6.example.Planta.service.PlantService;

@CrossOrigin
@RestController
@RequestMapping("/api/plant/")
public class PlantController {
	
	@Autowired
	private PlantService plantService;

	@GetMapping("all")
	public ApiResponse<List<PlantResponse>> getAllPlant(){
		
		List<PlantResponse>plants = plantService.getListPlants();
		ApiResponse<List<PlantResponse>> apiResponse = ApiResponse.<List<PlantResponse>>builder()
				.success(true)
				.code(200)
				.message("success")
				.result(plants)
				.build();
		return apiResponse;
	}
	
	@GetMapping("search")
	public ApiResponse<List<PlantResponse>> getPlantByName(@RequestParam("key") String key){
		List<PlantResponse> plants = plantService.getPlantsByName(key);
		ApiResponse<List<PlantResponse>> apiResponse;
		if(plants != null) {
			apiResponse = ApiResponse.<List<PlantResponse>>builder()
					.success(true)
					.code(200)
					.message("Lấy được danh sách cây trồng!")
					.result(plants)
					.build();
		} else {
			apiResponse = ApiResponse.<List<PlantResponse>>builder()
					.success(false)
					.code(404)
					.message("Không có cây trồng nào phù hợp!")
					.result(null)
					.build();
		}
		return apiResponse;
	}
	
	
	@GetMapping("{id}")
	public ApiResponse<Plant> getPlantDetail(@PathVariable int id){
		
	    Plant plant = plantService.getPlantDetail(id);
	    ApiResponse<Plant> apiResponse = ApiResponse.<Plant>builder()
	    		.success(true)
				.code(200)
				.message("success")
				.result(plant)
	    		.build();
	    return apiResponse;
	}
	
	
	@GetMapping("page")
    public ApiResponse<List<PlantResponse>> getAllPlants(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "40") int limit) {
        
		List<PlantResponse> plantResponses = plantService.getAllPlants(page, limit);
        
        return ApiResponse.<List<PlantResponse>>builder()
                .success(true)
                .code(200)
                .message("success")
                .result(plantResponses)
                .build();
    }

}
