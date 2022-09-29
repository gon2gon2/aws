package com.jojoldu.book.springboot.web.dto;

import com.jojoldu.book.springboot.domain.gon2s.Gon2s;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Gon2sSaveRequestDto {
    private String word;
    private String meaning;

    @Builder
    public Gon2sSaveRequestDto(String word, String meaning) {
        this.word = word;
        this.meaning = meaning;
    }

    public Gon2s toEntity() {
        return Gon2s.builder()
                    .word(word)
                    .meaning(meaning)
                    .build();
    }
}
