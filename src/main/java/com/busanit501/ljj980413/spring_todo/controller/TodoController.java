package com.busanit501.ljj980413.spring_todo.controller;


import com.busanit501.ljj980413.spring_todo.dto.PageRequestDTO;
import com.busanit501.ljj980413.spring_todo.dto.PageResponseDTO;
import com.busanit501.ljj980413.spring_todo.dto.TodoDTO;
import com.busanit501.ljj980413.spring_todo.service.TodoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
// http://localhost:9090/todo/
@RequestMapping("/todo")
@Log4j2
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

//    @RequestMapping("/list")
//    public void list(Model model) {
//        log.info("todo list...");
//        List<TodoDTO> dtoList = todoService.getAll();
//        model.addAttribute("dtoList",dtoList);
//    }

    @RequestMapping("/list")
    //  스프링에서는 기본적으로 매개변수의 클래스 타입을 화면으로 전달함: PageRequestDTO pageRequestDTO
    public void list(@Valid PageRequestDTO pageRequestDTO, BindingResult bindingResult,
                     Model model) {
        log.info("pageRequestDTO : " + pageRequestDTO);
        log.info("todo list...페이징 처리가 된 리스트 조회");
        // 유효성 체크에 걸린다면
        if(bindingResult.hasErrors()) {
            // 잠시 대기. 추후 작업 할 예정.
            pageRequestDTO = PageRequestDTO.builder().build();
            log.info("유효성 검사. hasErrors..");
        }

        PageResponseDTO<TodoDTO> responseDTO = todoService.getList(pageRequestDTO);
        // 서버 -> 화면에 데이터 목록들을 전달. 박스 이름 : responseDTO, 내용물: DB에서 받아온 목록들
        model.addAttribute("responseDTO",responseDTO);
    }




    @GetMapping({"/read", "/modify"})
    public void read(Long tno, PageRequestDTO pageRequestDTO, Model model) {
        log.info("todo read...");
        TodoDTO todoDTO = todoService.getOne(tno);
        // 서버 -> 화면에 데이터 목록들을 전달. 박스 이름 : dto, 내용물: DB에서 받아온 목록들
        model.addAttribute("dto", todoDTO);

    }

    @PostMapping("/delete")
    public String delete(Long tno, RedirectAttributes redirectAttributes) {
        log.info("삭제할 tno 번호 확인 : " + tno);
        todoService.remove(tno);
        return "redirect:/todo/list";
    }

//    @RequestMapping(value = "/register", method = RequestMethod.GET)
    @GetMapping("/register")
    public void getRegister() {
        log.info("todo register..get");
    }

    @PostMapping("/register")
    // 유효성 체크시, 주의사항, !) @Valid TodoDTO todoDTO, BindingResult bindingResult, 순서 주의!!!
    public String postRegister(@Valid TodoDTO todoDTO, BindingResult bindingResult,
                               RedirectAttributes redirectAttributes) {
        log.info("todo register..post");

        // 유효성 체크
        if(bindingResult.hasErrors()) {
            log.info("유효성 오류가 있습니다. ");
            // 서버에서 화면으로 임시 데이터를 전달. 박스이름: errors, 박스 내용물: 오류가 난 이유.
            redirectAttributes.addFlashAttribute("errors",bindingResult.getAllErrors());
            return "redirect:/todo/register";
        }

        log.info("todoDTO : " + todoDTO);
        // 서비스의 도움을 받아서, 화면으로 부터 전달 받은 데이터를 전달하기.
        todoService.register(todoDTO);

        log.info(" 유효성 통과한 데이터 todoDTO : " + todoDTO);
        return "redirect:/todo/list";
    }

    @PostMapping("/modify")
    // 유효성 체크시, 주의사항, !) @Valid TodoDTO todoDTO, BindingResult bindingResult, 순서 주의!!!
    public String postModify(@Valid TodoDTO todoDTO, BindingResult bindingResult,
                               RedirectAttributes redirectAttributes) {
        log.info("todo register..post");

        // 유효성 체크
        if(bindingResult.hasErrors()) {
            log.info("유효성 오류가 있습니다. ");
            // 서버에서 화면으로 임시 데이터를 전달. 박스이름: errors, 박스 내용물: 오류가 난 이유.
            redirectAttributes.addFlashAttribute("errors",bindingResult.getAllErrors());
            redirectAttributes.addAttribute("tno", todoDTO.getTno());
            return "redirect:/todo/modify";
        }

        log.info("todoDTO: " + todoDTO);
        // 서비스의 도움을 받아서, 화면으로 부터 전달 받은 데이터를 전달하기.
        todoService.modify(todoDTO);

        log.info(" 유효성 통과한 데이터 todoDTO: " + todoDTO);
        return "redirect:/todo/list";
    }


}
