package com.jojoldu.book.springboot.domain.gon2s;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.jojoldu.book.springboot.domain.BaseTimeEntity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class Gon2s extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
    private String word;

    @Column(length = 500, nullable = false)
    private String meaning;

    @Builder
    public Gon2s(String word, String meaning) {
        this.word = word;
        this.meaning = meaning;
    }

}
