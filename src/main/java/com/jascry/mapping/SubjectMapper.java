package com.jascry.mapping;

import com.jascry.db_model.ContentSubject;
import com.jascry.mapping.dto.ContentSubjectDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class SubjectMapper {

    @Autowired
    private PostMapper postMapper;

    public List<ContentSubjectDto> getContentSubjectDtoList(List<ContentSubject> contentSubjects) {
        return contentSubjects.stream()
                .map(s -> new ContentSubjectDto(s.getSubjectName(), s.getDescription()))
                .collect(Collectors.toList());
    }

    public ContentSubjectDto getContentSubjectDto(ContentSubject contentSubject) {
        return new ContentSubjectDto(contentSubject.getSubjectName(), contentSubject.getDescription(), postMapper.getPostForSubjectDtoList(contentSubject.getPosts()));
    }
}
