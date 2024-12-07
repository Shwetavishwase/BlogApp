package com.itp.payload;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Size(min = 2, message = "Name should be atleast 2 characters")
	private String name;
	
	@Email(message = "Email id must be valid")
	private String email;
	
	@NotEmpty
	@Size(min = 3,max = 10,message = "Password must be min of 3 characters & max of 10 characters")
	private String password;
	
	@NotEmpty
	private String about;
	
}
