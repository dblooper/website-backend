package com.jascry.repository;

import com.jascry.db_model.CommentResponse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentResponseRepository extends JpaRepository<CommentResponse, Long> {
}
