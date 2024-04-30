package nhom6.example.Planta.service.impl;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import nhom6.example.Planta.entity.User;
import nhom6.example.Planta.payload.response.UserResponse;
import nhom6.example.Planta.repository.UserRepository;
import nhom6.example.Planta.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserResponse getUserByToken(String token) {
		User user = userRepository.getUserByToken(token);
		UserResponse userResponse = new UserResponse(user.getId(), user.getName(),user.getPhone(),user.getAddress(),user.getEmail(),user.getToken());
		return userResponse;
	}
	
	@Override
	public UserResponse getUserById(int idUser) {
		User user = userRepository.getUserById(idUser);
		UserResponse userResponse = new UserResponse(user.getId(), user.getName(),user.getPhone(),user.getAddress(),user.getEmail(),user.getToken());
		return userResponse;
	}
	
	@Override
	public User getUserByEmail(String email, int idUser) {
		User user = userRepository.getUserByEmail(email, idUser);
		return user;
	}
	
	@Override
	public User getUserByUsername(String username) {
		User user = userRepository.findByUsername(username);
		return user;
	}
	
	public UserResponse login(User userRequest) {
		User user = userRepository.getUserByUsernameOrEmail(userRequest.getUsername(), userRequest.getUsername(), userRequest.getPassword());
		UserResponse userResponse = new UserResponse(user.getId(), user.getName(),user.getPhone(),user.getAddress(),user.getEmail(),user.getToken());
		return userResponse;
	}
	
	public int register(User userRequest) {
		if(userRepository.findByUsernameAndPassword(userRequest.getUsername(), userRequest.getPassword()) == null)
			return userRepository.register(userRequest.getAddress(),userRequest.getEmail(),userRequest.getName(),userRequest.getPassword(),userRequest.getPhone(),userRequest.getUsername());
		else {
			return 0;
		}
	}

	@Override
	public int updateUser(UserResponse userRequest) {
		return userRepository.update(userRequest.getAddress(), userRequest.getEmail(), userRequest.getName(), userRequest.getPhone(), userRequest.getId());
	}

	@Override
	public int updateUserToken(User userRequest) {
		return userRepository.updateToken(userRequest.getToken(), userRequest.getId());
	}

	@Override
	public int updateUserPassword(User userRequest) {
		return userRepository.updatePassword(userRequest.getPassword(), userRequest.getId());
	}
	
	@Override
	public User updateUserByFields(int id, Map<String, Object> fields) {
        Optional<User> existingProduct = userRepository.findById(id);

        if (existingProduct.isPresent()) {
            fields.forEach((key, value) -> {
                Field field = ReflectionUtils.findField(User.class, key);
                field.setAccessible(true);
                ReflectionUtils.setField(field, existingProduct.get(), value);
            });
            return userRepository.save(existingProduct.get());
        }
        return null;
    }
}
