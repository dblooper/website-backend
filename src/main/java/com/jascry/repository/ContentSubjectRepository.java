package com.jascry.repository;

import com.jascry.db_model.ContentSubject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContentSubjectRepository extends JpaRepository<ContentSubject, String> {

}
