package com.example.BLPS.entity;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "article")
    public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "article_seq")
    private Integer id;

    @Column(name = "topic")
    private String topic;

    @Column(name = "description")
    private String description;

    @Column(name = "data")
    private Date creationDate;

    @OneToMany(mappedBy = "article", fetch = FetchType.LAZY)
    private List<Tag> tags;

    @OneToMany(mappedBy = "article", fetch = FetchType.LAZY)
    private List<Image> images;
}
