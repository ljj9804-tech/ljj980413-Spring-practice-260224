package com.busanit501.ljj980413.mapper;

import com.busanit501.ljj980413.spring_todo.domain.TodoVO;
import com.busanit501.ljj980413.spring_todo.mapper.TodoMapper;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
public class TodoMapperTests {

    @Autowired(required = false)
    private TodoMapper todoMapper;

    // 2. 실제 테스트를 수행할 메서드 추가
    @Test
    public void testGetTime() {
        log.info("DB 현재 시간: " + todoMapper.getTime());

    }

    @Test
    public void testInsert() {
        // 준비물, 화면에서 넘겨받은 TodoVO 있다고 가정, 또는 더미 데이터 준비.
        TodoVO todoVO = TodoVO.builder()
                .title("insert 테스트")
                .dueDate(LocalDate.now())
                .writer("이진주")
                .build();
        todoMapper.insert(todoVO);
    }
}