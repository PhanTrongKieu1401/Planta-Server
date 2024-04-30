package nhom6.example.Planta.service;

import java.util.Map;
import nhom6.example.Planta.entity.User;
import nhom6.example.Planta.payload.response.UserResponse;

public interface UserService{
	
	public User updateUserByFields(int id, Map<String, Object> fields);
	
	public UserResponse getUserByToken(String token);
	public UserResponse getUserById(int idUser);
	public User getUserByEmail(String email, int idUser);
	public User getUserByUsername(String username);
	public UserResponse login(User user);
	public int register(User user);
	public int updateUser(UserResponse userResponse);
	public int updateUserToken(User user);
	public int updateUserPassword(User user);
}
