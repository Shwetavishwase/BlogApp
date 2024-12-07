package com.itp.payload;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CategoryDto {

	private Integer categoryId;
	
	@NotBlank
	@Size(min = 4,message = "category should be atleast 2 characters")
	private String categoryTitle;
	
	@NotBlank
	@Size(min = 10,message = "description should be atleast 2 characters")
	private String categoryDescription;
}
