package com.jojoldu.book.springboot.web.dto;

import com.jojoldu.book.springboot.domain.gon2s.Gon2s;

import lombok.Getter;

@Getter
public class Gon2sResponseDto {
    private String word;
    private String meaning;

    public Gon2sResponseDto(Gon2s entity) {
        this.word = entity.getWord();
        this.meaning = entity.getMeaning();
    }
}
