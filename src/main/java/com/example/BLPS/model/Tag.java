package com.example.BLPS.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "tag")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tag_seq")
    private Integer id;

    @Column(name = "tag_name")
    private String tagName;

    @ManyToOne(optional = false)
    @JoinColumn(name = "article_id")
    private Article article;
}