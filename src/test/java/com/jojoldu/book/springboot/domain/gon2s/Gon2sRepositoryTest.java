package com.jojoldu.book.springboot.domain.gon2s;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Gon2sRepositoryTest {

    @Autowired
    private Gon2sRepository gon2sRepository;

    @After
    public void cleanup() {
        gon2sRepository.deleteAll();
        System.out.println("테스트 완!");
    }

    @Test
    public void 게시글저장_불러오기() {
        // given
        String word = "테스트 단어";
        String meaning = "테스트 테스트 뜻";

        gon2sRepository.save(Gon2s.builder()
                                  .word(word)
                                  .meaning(meaning)
                                  .build()
        );

        // when
        List<Gon2s> gon2sList = gon2sRepository.findAll();

        // then
        Gon2s gon2s = gon2sList.get(0);
        assertThat(gon2s.getWord()).isEqualTo(word);
        assertThat(gon2s.getMeaning()).isEqualTo(meaning);
    }
}
