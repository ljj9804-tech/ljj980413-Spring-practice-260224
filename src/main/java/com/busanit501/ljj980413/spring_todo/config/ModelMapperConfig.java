package com.busanit501.ljj980413.spring_todo.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 설정을 담당하는 클래스라고, 스프링(시스템에게) 알려주기.
@Configuration
public class ModelMapperConfig {
    // 일반 클래스 객체를  스프링(시스템에게) 알려주기.
    @Bean
    public ModelMapper getMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
        // dto <-> vo 클래스의 멤버의 일치 여부를 체크함.
        .setFieldMatchingEnabled(true)
        // 접근은 private 까지 가능하게
        .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE)
        // 매칭시, 검사시, 엄격하게 검사함.
        .setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper;
    }
}
