package com.busanit501.ljj980413.spring_todo.service;

import com.busanit501.ljj980413.spring_todo.dto.TodoDTO;

import java.util.List;

public interface TodoService {
    //추가
    // 화면에서, 입력된 정보를 받기 -> DTO담기 -> VO 변환 -> DB 에 전달.
    void register(TodoDTO todoDTO);

    // 전체 목록
    List<TodoDTO> getAll();

    // 하나 조회
    TodoDTO getOne(Long tno);

    // 삭제
    void remove(Long tno);

    //수정
    void modify(TodoDTO todoDTO);

}
