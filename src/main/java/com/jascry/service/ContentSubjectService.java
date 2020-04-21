package com.jascry.service;

import com.jascry.mapping.PostMapper;
import com.jascry.mapping.dto.ContentSubjectDto;
import com.jascry.mapping.SubjectMapper;
import com.jascry.repository.ContentSubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContentSubjectService {
    @Autowired
    private ContentSubjectRepository contentSubjectRepository;

    @Autowired
    private PostMapper postMapper;

    @Autowired
    private SubjectMapper subjectMapper;

    public List<ContentSubjectDto> getContentSubjectDtoList() {
        return subjectMapper.getContentSubjectDtoList(contentSubjectRepository.findAll());
    }

    public ContentSubjectDto getContentSubjectWithPosts(String subjectName) {
        return subjectMapper.getContentSubjectDto(contentSubjectRepository.getOne(subjectName));
    }
}
