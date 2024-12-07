package com.itp.payload;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.itp.entity.Category;
import com.itp.entity.Comment;
import com.itp.entity.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class PostDto {

	private String title;

	private String content;

	private String imageName = "default.png";

	private Date addDate;

	private Category category;

	private User user;
	
	private List<Comment> comment=new ArrayList<>();

}
