package com.itp.payload;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class CommentDto {

	private Integer commentId;
	
	private String content;
}
