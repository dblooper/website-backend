package com.jascry.db_model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ContentSubjects")
public class ContentSubject {

    @Id
    @Column(name = "subjectName",
            nullable = false
            ,length = 100)
    private String subjectName;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "contentSubject"
            ,fetch = FetchType.EAGER
            ,cascade = CascadeType.ALL)
    private List<Post> posts;

    public ContentSubject() {
    }

    public ContentSubject(String subjectName, String description, List<Post> posts) {
        this.subjectName = subjectName;
        this.description = description;
        this.posts = posts;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public String getDescription() {
        return description;
    }

    public List<Post> getPosts() {
        return posts;
    }
}
