package com.busanit501.ljj980413.spring_todo.mapper;


import com.busanit501.ljj980413.spring_todo.domain.TodoVO;

import java.util.List;

public interface TodoMapper {
    //테스트
    String getTime();

    //입력된 정보 받기: dto로 받아서 vo로 변환 후 db에 전달
    void insert(TodoVO todoVO);

    // 전체 목록 조회
    List<TodoVO> selectAll();

    // 하나 조회
    TodoVO selectOne(Long tno);

    // 삭제
    void delete(Long tno);

    //수정
    void update(TodoVO todoVO);
}
