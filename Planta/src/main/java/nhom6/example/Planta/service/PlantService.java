package nhom6.example.Planta.service;

import java.util.List;

import nhom6.example.Planta.entity.Plant;
import nhom6.example.Planta.payload.response.PlantResponse;

public interface PlantService {

	public Plant getPlantDetail(int id);
	
	public List<PlantResponse> getListPlants();
	
	public List<PlantResponse> getPlantsByName(String key);
	
	public List<PlantResponse> getAllPlants(int page, int limit);
}
