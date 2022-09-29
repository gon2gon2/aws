package com.jojoldu.book.springboot.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jojoldu.book.springboot.service.gon2s.Gon2sService;
import com.jojoldu.book.springboot.web.dto.Gon2sResponseDto;
import com.jojoldu.book.springboot.web.dto.Gon2sSaveRequestDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class GonController {

    private final Gon2sService gon2sService;

    @GetMapping("/gon2")
    public Long save(@RequestBody Gon2sSaveRequestDto requestDto) {
        return gon2sService.save(requestDto);
    }
}
