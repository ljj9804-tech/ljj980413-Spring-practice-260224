package com.busanit501.ljj980413.spring_todo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Data
@Builder // 객체 생성을 체인 기법을 이용해서, 편하게 작업하기 위해서 사용함.
@NoArgsConstructor // 기본 생성자를 생성함.
@AllArgsConstructor // 모든 멤버를 매개변수로 가지는 생성자를 생성함.
public class TodoDTO {
    private Long tno;

    @NotBlank
    private String title;

    @FutureOrPresent
    private LocalDate dueDate;

    @NotBlank
    private String writer;

    private  boolean finished;


}
