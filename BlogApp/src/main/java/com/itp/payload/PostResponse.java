package com.itp.payload;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PostResponse {

	private List<PostDto> content;
	
	private Integer pageNumberInteger;
	
	private Integer pagesize;
	
	private Long totalElements;
	
	private Integer totalPages;
	
	private boolean lastPage;
}
