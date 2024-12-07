package com.itp.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.itp.config.AppConstants;
import com.itp.payload.ApiResponse;
import com.itp.payload.PostDto;
import com.itp.payload.PostResponse;
import com.itp.service.FileService;
import com.itp.service.PostService;



@RestController
@RequestMapping("/api/post")
public class PostController {

	@Autowired
	private PostService postServiceImpl;
	
	@Autowired
	private FileService fileServiceImpl;
	
	@Value("${project.image}")
	private String path;
	
	@PostMapping("/user/{userId}/category/{categoryId}/posts")
	public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto,
			@PathVariable Integer userId,
			@PathVariable Integer categoryId)
	{
		
		PostDto createdPost=this.postServiceImpl.createPost(postDto, userId, categoryId);
		
		return new ResponseEntity<>(createdPost,HttpStatus.CREATED);
	}
	
	@PutMapping("/{postId}")
	public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto,@PathVariable Integer postId)
	{
		PostDto updatePost = this.postServiceImpl.updatePost(postDto, postId);
				
		return new ResponseEntity<>(updatePost,HttpStatus.OK);
	}
	
	@GetMapping("/getPostById/{postId}")
	public ResponseEntity<PostDto> getPostById(@PathVariable Integer postId)
	{
		PostDto postDto = this.postServiceImpl.getPostById(postId);
		
		return new ResponseEntity<PostDto>(postDto,HttpStatus.OK);
	}
	
	@DeleteMapping("/deletePost/{postId}")
	public ResponseEntity<ApiResponse> deletePost(@PathVariable Integer postId)
	{
		this.postServiceImpl.deletePost(postId);
		return new ResponseEntity<>(new ApiResponse("post is deleted successfully !!", true),HttpStatus.OK);
	}
	
	@GetMapping("/posts")
	public ResponseEntity<PostResponse> getAllPosts(
			@RequestParam(value = "pageNumber",defaultValue = AppConstants.PAGE_NUMBER,required = false)Integer pageNumber,
			@RequestParam(value = "pageSize",defaultValue = AppConstants.PAGE_SIZE,required = false)Integer pageSize,
			@RequestParam(value = "sortBy",defaultValue = AppConstants.SORT_BY,required = false)String sortBy,
			@RequestParam(value = "sortDir",defaultValue = AppConstants.SORT_DIRECTION,required = false)String sortDirection
			)
	{
		PostResponse allPosts = this.postServiceImpl.getAllPosts(pageNumber,pageSize,sortBy,sortDirection);
		
		return new ResponseEntity<PostResponse>(allPosts,HttpStatus.OK);
	}
	
	@GetMapping("/getByCategory/{categoryId}")
	public ResponseEntity<List<PostDto>> getPostByCategory(@PathVariable Integer categoryId)
	{
		List<PostDto> posts = this.postServiceImpl.getPostByCategory(categoryId);
		
		return new ResponseEntity<List<PostDto>>(posts,HttpStatus.OK);
	}
	
	@GetMapping("/getByUser/{userId}")
	public ResponseEntity<List<PostDto>> getPostByUser(@PathVariable Integer userId)
	{
		List<PostDto> posts = this.postServiceImpl.getPostByUser(userId);
		
		return new ResponseEntity<List<PostDto>>(posts,HttpStatus.OK);
	}
	
	//search
	@GetMapping("/posts/{keyword}")
	public ResponseEntity<List<PostDto>> searchPostByTitle(
			@PathVariable("keyword")String keyword )
	{
		List<PostDto> result = this.postServiceImpl.searchPosts(keyword);
		
		return new ResponseEntity<List<PostDto>>(result,HttpStatus.OK);
	}
	
	//post image upload
	
	@PostMapping("/posts/image/upload/{postId}")
	public ResponseEntity<PostDto> uploadImage(
			@RequestParam("image")MultipartFile image,
			@PathVariable Integer postId) throws IOException
	{
		String fileName = this.fileServiceImpl.uploadImage(path, image);
		
		PostDto postDto = this.postServiceImpl.getPostById(postId);
		
		postDto.setImageName(fileName);
		PostDto updatePost = this.postServiceImpl.updatePost(postDto, postId);
		
		return new ResponseEntity<PostDto>(updatePost,HttpStatus.OK);
	}
}
