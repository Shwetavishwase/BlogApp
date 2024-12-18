package com.itp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itp.entity.Category;
import com.itp.entity.Post;
import com.itp.entity.User;


@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {

//	
	List<Post> findByUser(User user);
//	
	List<Post> findByCategory(Category category);

	List<Post> findByTitleContaining(String title);
}
