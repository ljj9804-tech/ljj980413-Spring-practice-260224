package com.busanit501.ljj980413.spring_todo.service;

import com.busanit501.ljj980413.spring_todo.domain.TodoVO;
import com.busanit501.ljj980413.spring_todo.dto.TodoDTO;
import com.busanit501.ljj980413.spring_todo.mapper.TodoMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService {

    private final TodoMapper todoMapper;
    private final ModelMapper modelMapper;

    @Override
    public void register(TodoDTO todoDTO) {
        log.info("서비스 작업: insert 기능 작업중. ");
        TodoVO todoVO = modelMapper.map(todoDTO, TodoVO.class);
        log.info("서비스 작업: insert 기능 변환된 todoVO : " + todoVO);
        todoMapper.insert(todoVO);
    }

    @Override
    public List<TodoDTO> getAll() {
        List<TodoDTO> dtoList = todoMapper.selectAll().stream()
                .map(vo -> modelMapper.map(vo, TodoDTO.class))
                .collect(Collectors.toList());
        return dtoList;
    }

    @Override
    public TodoDTO getOne(Long tno) {
        TodoVO todoVO = todoMapper.selectOne(tno);
        TodoDTO todoDTO = modelMapper.map(todoVO, TodoDTO.class);
        return todoDTO;
    }

    @Override
    public void remove(Long tno) {
        todoMapper.delete(tno);
    }

    @Override
    public void modify(TodoDTO todoDTO) {
        // 화면에서 전달받은 데이터는 어디에 담죠? TodoDTO
        // 서비스에서 -> 데이터 수정할 때는 어디에 담죠 ? TodoVO
        // 여기서, 변환하기.
        TodoVO todoVO = modelMapper.map(todoDTO, TodoVO.class);
        todoMapper.update(todoVO);
    }
}
