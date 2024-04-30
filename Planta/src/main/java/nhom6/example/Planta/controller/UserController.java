package nhom6.example.Planta.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nhom6.example.Planta.entity.User;
import nhom6.example.Planta.payload.ApiResponse;
import nhom6.example.Planta.payload.response.UserResponse;
import nhom6.example.Planta.service.UserService;

@RestController
@RequestMapping("/api/user")
@CrossOrigin
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/{id}")
	public ApiResponse<UserResponse> getUser(@PathVariable("id") int id){
		UserResponse userResponse = userService.getUserById(id);
		System.out.println(userResponse);
		ApiResponse<UserResponse> apiResponse;
		if(userResponse != null) {
			apiResponse = ApiResponse.<UserResponse>builder()
					.success(true)
					.code(200)
					.message("Lấy thông tin thành công!")
					.result(userResponse)
					.build();
		}
		else {
			apiResponse = ApiResponse.<UserResponse>builder()
					.success(false)
					.code(200)
					.message("Lấy thông tin thất bại!")
					.result(null)
					.build();
		}
		return apiResponse;
	}
	
	@PostMapping("/login")
	public ApiResponse<UserResponse> login(@RequestBody User user){
		UserResponse userResponse = userService.login(user);
		ApiResponse<UserResponse> apiResponse;
		if(userResponse != null) {
			apiResponse = ApiResponse.<UserResponse>builder()
					.success(true)
					.code(200)
					.message("Đăng nhập thành công!")
					.result(userResponse)
					.build();
		}
		else {
			apiResponse = ApiResponse.<UserResponse>builder()
					.success(false)
					.code(200)
					.message("Sai tài khoản và mật khẩu!")
					.result(null)
					.build();
		}
		return apiResponse;
	}
	
	@PostMapping("/register")
	public ApiResponse<UserResponse> register(@RequestBody User userRequest){
		System.out.println("User request: "+userRequest);
		User user = userService.getUserByUsername(userRequest.getUsername());
		ApiResponse<UserResponse> apiResponse;
		if(user == null) {
			int check = userService.register(userRequest);
			if(check > 0) {
				User newUser = userService.getUserByUsername(userRequest.getUsername());
				UserResponse userResponse = new UserResponse(newUser.getId(), newUser.getName(),newUser.getPhone(),newUser.getAddress(),newUser.getEmail(),newUser.getToken());
				apiResponse = ApiResponse.<UserResponse>builder()
						.success(true)
						.code(200)
						.message("Đăng ký tài khoản thành công!")
						.result(userResponse)
						.build();
			} else {
				UserResponse userResponse = new UserResponse(userRequest.getId(), userRequest.getName(),userRequest.getPhone(),userRequest.getAddress(),userRequest.getEmail(),userRequest.getToken());
				apiResponse = ApiResponse.<UserResponse>builder()
						.success(false)
						.code(404)
						.message("Đăng ký tài khoản thất bại!")
						.result(userResponse)
						.build();
			}
		}
		else{
			apiResponse = ApiResponse.<UserResponse>builder()
					.success(false)
					.code(404)
					.message("Tài khoản đã tồn tại!")
					.result(null)
					.build();
		}
		
		return apiResponse;
	}
	
	@PutMapping("/update/information")
	public ApiResponse<UserResponse> updateInformation(@RequestBody UserResponse userRequest){
		
		ApiResponse<UserResponse> apiResponse;
		if(userService.getUserByEmail(userRequest.getEmail(), userRequest.getId()) == null) {
			int check = userService.updateUser(userRequest);
			if(check > 0) {
				UserResponse newUserResponse = new UserResponse(userRequest.getId(), userRequest.getName(),userRequest.getPhone(),userRequest.getAddress(),userRequest.getEmail(),userRequest.getToken());
				apiResponse = ApiResponse.<UserResponse>builder()
						.success(true)
						.code(200)
						.message("Cập nhật thông tin thành công!")
						.result(newUserResponse)
						.build();
			}
			else{
				apiResponse = ApiResponse.<UserResponse>builder()
						.success(false)
						.code(404)
						.message("Cập nhật thông tin thất bại!")
						.result(userRequest)
						.build();
			}
		}
		else{
			apiResponse = ApiResponse.<UserResponse>builder()
					.success(false)
					.code(404)
					.message("Email người dùng đã được sử dụng!")
					.result(userRequest)
					.build();
		}
		
		return apiResponse;
	}
	
	@PutMapping("/update/password")
	public ApiResponse<UserResponse> updatePassword(@RequestBody User user){
		int check = userService.updateUserPassword(user);
		ApiResponse<UserResponse> apiResponse;
		if(check > 0) {
			UserResponse userResponse = new UserResponse(user.getId(), user.getName(),user.getPhone(),user.getAddress(),user.getEmail(),user.getToken());
			apiResponse = ApiResponse.<UserResponse>builder()
					.success(true)
					.code(200)
					.message("Cập nhật mật khẩu thành công!")
					.result(userResponse)
					.build();
		}
		else{
			apiResponse = ApiResponse.<UserResponse>builder()
					.success(false)
					.code(404)
					.message("Cập nhật mật khẩu thất bại!")
					.result(null)
					.build();
		}
		
		return apiResponse;
	}
}
