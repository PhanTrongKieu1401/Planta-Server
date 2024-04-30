package nhom6.example.Planta.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import nhom6.example.Planta.entity.Plant;
import nhom6.example.Planta.payload.response.PlantResponse;
import nhom6.example.Planta.repository.PlantRepository;
import nhom6.example.Planta.service.PlantService;

@Service
public class PlantServiceImpl implements PlantService {

	@Autowired
	private PlantRepository plantRepository;
	
	@Override
	public Plant getPlantDetail(int id) {
		return plantRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Không tìm thấy cây"));
	}
	
	@Override
	public List<PlantResponse> getListPlants() {
        List<PlantResponse> allPlants = plantRepository.findAllProjected();
        
        if (allPlants.isEmpty()) {
            return allPlants;
        }
        
        long seed = System.nanoTime(); // Sử dụng seed từ thời gian hiện tại để tạo số ngẫu nhiên
        Collections.shuffle(allPlants, new Random(seed));
        
        return allPlants;
    }
	
	@Override
	public List<PlantResponse> getPlantsByName(String key) {
		List<PlantResponse> plantResponses = plantRepository.findPlantByName(key);
		return plantResponses;
	}
	
	public List<PlantResponse> getAllPlants(int page, int limit) {
        PageRequest pageRequest = PageRequest.of(page, limit);
        Page<PlantResponse> plantsPage = plantRepository.findAllProjected(pageRequest);
        List<PlantResponse> plantResponses = plantsPage.getContent();
        return plantResponses;
    }
}
