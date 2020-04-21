package com.jascry.db_model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Comments")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "body", columnDefinition = "TEXT")
    private String body;

    @ManyToOne
    @JoinColumn(name = "authorLogin", nullable = false)
    private Author author;

    @Column
    private Integer likes;

    @Column
    private Integer dislikes;

    @OneToMany(mappedBy = "comment"
            ,fetch = FetchType.EAGER
            ,cascade = CascadeType.ALL)
    private List<CommentResponse> commentResponse;
}
