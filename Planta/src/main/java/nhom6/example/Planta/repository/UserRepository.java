package nhom6.example.Planta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;
import nhom6.example.Planta.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	
	User getUserByToken(String token);
	
	User findByUsernameAndPassword(String username, String password);
	
	@Query(value = "SELECT * FROM user u WHERE (u.username = :username OR u.email = :email) AND u.password = :password", nativeQuery = true)
	User getUserByUsernameOrEmail(@Param("username") String username, @Param("email") String email, @Param("password") String password);
	
	@Query(value = "SELECT * FROM user u WHERE u.id = :id", nativeQuery = true)
	User getUserById(@Param("id") int id);
	
	@Query(value = "SELECT * FROM user u WHERE u.email = :email AND u.id != :id", nativeQuery = true)
	User getUserByEmail(@Param("email") String email, @Param("id") int id);
	
	User findByUsername(String username);
	
	@Modifying
	@Transactional
	@Query(value = "INSERT INTO user(address,email,name,password,phone,username) VALUE (:address, :email, :name, :password, :phone, :username)", nativeQuery = true)
	int register(@Param("address") String address, @Param("email") String email, @Param("name") String name, @Param("password") String password,
			@Param("phone") String phone, @Param("username") String username);
	
	@Modifying
    @Transactional
	@Query(value = "UPDATE user u SET u.address = :address, u.email = :email, u.name = :name, u.phone = :phone WHERE u.id = :id", nativeQuery = true)
	int update(@Param("address") String address, @Param("email") String email, @Param("name") String name, 
			@Param("phone") String phone, @Param("id") int id);
	
	@Modifying
	@Transactional
	@Query(value = "UPDATE user u SET u.token = :token WHERE u.id = :id", nativeQuery = true)
	int updateToken(@Param("token") String token, @Param("id") int id);
	
	@Modifying
	@Transactional
	@Query(value = "UPDATE user u SET u.password = :password WHERE u.id = :id", nativeQuery = true)
	int updatePassword(@Param("password") String password, @Param("id") int id);
}
