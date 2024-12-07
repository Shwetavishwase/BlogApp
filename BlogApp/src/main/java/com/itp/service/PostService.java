package com.itp.service;


import java.util.List;

import com.itp.payload.PostDto;
import com.itp.payload.PostResponse;



public interface PostService {
	
	//create
	
	PostDto createPost(PostDto postDto,Integer userId,Integer categoryId);

	//update
	PostDto updatePost(PostDto postDto,Integer postId);
	
	//delete
	void deletePost(Integer postId);
	
	//get all post
	PostResponse getAllPosts(Integer pageNumber,Integer pageSize,String sortBy,String sortDirection);
	
	//get post by Id
	PostDto getPostById(Integer postId);
	
	//get all post by category
	List<PostDto> getPostByCategory(Integer categoryId);
	
	//get all post by user
	List<PostDto> getPostByUser(Integer userId);
	
	//search posts
	List<PostDto> searchPosts(String keyword);
	
	
	
}
