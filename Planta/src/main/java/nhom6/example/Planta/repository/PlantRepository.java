package nhom6.example.Planta.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import nhom6.example.Planta.entity.Plant;
import nhom6.example.Planta.payload.response.PlantResponse;


@Repository
public interface PlantRepository extends JpaRepository<Plant, Integer> {
	
	@Query("SELECT new nhom6.example.Planta.payload.response.PlantResponse(p.id, p.name, p.typePlant, p.mainImage) FROM Plant p")
    List<PlantResponse> findAllProjected();
	
	@Query("SELECT new nhom6.example.Planta.payload.response.PlantResponse(p.id, p.name, p.typePlant, p.mainImage) FROM Plant p WHERE p.name LIKE CONCAT('%', :key, '%') ORDER BY p.name ASC")
    List<PlantResponse> findPlantByName(@Param("key") String key);
	
	@Query("SELECT new nhom6.example.Planta.payload.response.PlantResponse(p.id, p.name, p.typePlant, p.mainImage) FROM Plant p")
    Page<PlantResponse> findAllProjected(Pageable pageable);
	
}
