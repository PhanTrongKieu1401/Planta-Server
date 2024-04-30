package nhom6.example.Planta.repository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;
import nhom6.example.Planta.entity.MyPlant;

@Repository
public interface MyPlantRepository extends JpaRepository<MyPlant, Integer>{
	
	@Query(value = "SELECT * FROM myplant mp WHERE mp.iduser = :idUser ORDER BY mp.growndate DESC, mp.name ASC", nativeQuery = true)
	List<MyPlant> getAllMyPlantByUser(@Param("idUser") int idUser);
	
	@Query(value = "SELECT * FROM myplant mp WHERE mp.iduser = :idUser AND mp.name LIKE CONCAT('%',:key,'%') ORDER BY mp.growndate DESC, mp.name ASC", nativeQuery = true)
	List<MyPlant> getAllMyPlantByUserAndKey(@Param("idUser") int idUser, @Param("key") String key);
	
	@Query(value = "SELECT * FROM myplant mp WHERE mp.iduser = :idUser AND mp.id = :id", nativeQuery = true)
	MyPlant getMyPlantByUser(@Param("idUser") int idUser, @Param("id") int id);
	
	@Query(value = "SELECT * FROM myplant mp WHERE mp.iduser = :idUser ORDER BY mp.id DESC LIMIT 1", nativeQuery = true)
	MyPlant getLastMyPlantByUser(@Param("idUser") int idUser);
	
	@Query("SELECT mp FROM MyPlant mp JOIN mp.user u WHERE u.id = :userId")
	Optional<List<MyPlant>> getAllMyPlantByUserId(@Param("userId") int userId);

	@Query(value = "SELECT * FROM myplant mp WHERE mp.iduser = :idUser AND mp.name = :name", nativeQuery = true)
	MyPlant getMyPlantByUserAndName(@Param("idUser") int idUser, @Param("name") String name);
	
	@Query(value = "SELECT * FROM myplant mp WHERE mp.iduser = :idUser AND mp.name = :name AND mp.id != :idMyPlant", nativeQuery = true)
	MyPlant getMyPlantByUserAndNameNotId(@Param("idUser") int idUser, @Param("name") String name, @Param("idMyPlant") int idMyPlant);
	
	@Modifying
	@Transactional
	@Query(value = "INSERT INTO myplant(growndate,image,kindoflight,name,idplant,iduser) VALUE (:growndate, :image, :kindoflight, :name, :idplant, :iduser)", nativeQuery = true)
	int addMyPlant(@Param("growndate") Date growndate, @Param("image") String image, @Param("kindoflight") String kindoflight, 
			@Param("name") String name, @Param("idplant") int idplant, @Param("iduser") int iduser);
	
	@Modifying
	@Transactional
	@Query(value = "UPDATE myplant mp SET mp.growndate = :growndate, mp.image = :image, mp.kindoflight = :kindoflight, mp.name = :name "
			+ "WHERE mp.id = :id", nativeQuery = true)
	int updateMyPlant(@Param("growndate") Date growndate, @Param("image") String image, @Param("kindoflight") String kindoflight, 
			@Param("name") String name, @Param("id") int id);
	
	@Modifying
	@Transactional
	@Query(value = "DELETE FROM myplant mp WHERE mp.id = :id", nativeQuery = true)
	int deleteMyPlant(@Param("id") int id);
}
