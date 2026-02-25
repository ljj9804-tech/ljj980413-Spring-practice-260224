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
import java.util.List;

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

    @Test
    public void testSelectAll() {
        List<TodoVO> voList = todoMapper.selectAll();
        voList.forEach(vo -> log.info(vo));
    }

    @Test
    public void testSelectOne() {
        // 각자 데이터베이스에 있는 tno 번호 확인 후 , 테스트 진행하기.
        TodoVO todoVO = todoMapper.selectOne(1L);
        log.info(todoVO);
    }

    @Test
    public void testUpdate() {
        // 준비물, 화면에서 넘겨받은 TodoVO 있다고 가정, 또는 더미 데이터 준비.
        // 수정, 기존에 DB 내용으로 선택? (각자다름)
        TodoVO todoVO = TodoVO.builder()
                .tno(2L)
                .title("수정 테스트")
                .dueDate(LocalDate.now())
                .finished(true)
                .build();
        todoMapper.update(todoVO);
        log.info("수정 결과 : " + todoVO);
    }

    @Test
    public void testDeleteOne() {
        // 각자 데이터베이스에 있는 tno 번호 확인 후 , 테스트 진행하기.
        todoMapper.delete(3L);
    }
}