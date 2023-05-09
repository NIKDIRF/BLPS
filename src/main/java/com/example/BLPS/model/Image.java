package com.example.BLPS.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@Table(name = "image")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tag_seq")
    private Integer id;

    @Column(name = "image_link")
    private String imageLink;

    @ManyToOne(optional = false)
    @JoinColumn(name = "article_id")
    private Article article;

    @Transient
    private String fileName;

    @Transient
    private byte[] imageContent;

    @Transient
    private String imageExtension;
}
