package com.jojoldu.book.springboot.service.gon2s;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.jojoldu.book.springboot.domain.gon2s.Gon2s;
import com.jojoldu.book.springboot.domain.gon2s.Gon2sRepository;
import com.jojoldu.book.springboot.web.dto.Gon2sResponseDto;
import com.jojoldu.book.springboot.web.dto.Gon2sSaveRequestDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class Gon2sService {
    private final Gon2sRepository gon2sRepository;

    @Transactional
    public Long save(Gon2sSaveRequestDto requestDto) {return gon2sRepository.save(requestDto.toEntity()).getId();}

    public Gon2sResponseDto findById(Long id) {
        Gon2s entity = gon2sRepository.findById(id)
                                      .orElseThrow(() -> new IllegalArgumentException("해당 id 없음"));
        return new Gon2sResponseDto(entity);
    }
}
