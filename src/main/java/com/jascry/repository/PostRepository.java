package com.jascry.repository;

import com.jascry.db_model.ContentSubject;
import com.jascry.db_model.Post;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    @Query
    List<Post> getLastPostsBySubject(@Param("SUBJECT") ContentSubject subjectName, Pageable limit);
}
