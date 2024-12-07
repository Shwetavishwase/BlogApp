package com.itp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itp.entity.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {

}
