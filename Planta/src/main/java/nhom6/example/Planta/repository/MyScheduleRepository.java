package nhom6.example.Planta.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import nhom6.example.Planta.entity.MySchedule;

@Repository
public interface MyScheduleRepository extends JpaRepository<MySchedule, Integer> {
	
	@Query("SELECT ms FROM MySchedule ms JOIN ms.myPlant mp JOIN mp.user u WHERE u.id = :userId")
	Optional<List<MySchedule>> findByUserId(@Param("userId") int userId);
	
	@Query("SELECT ms FROM MySchedule ms JOIN ms.myPlant mp WHERE mp.id = :myplantId")
	Optional<List<MySchedule>> findByMyPlantId(@Param("myplantId") int myplantId);
	
}
