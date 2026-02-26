package com.busanit501.ljj980413.spring_todo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageRequestDTO {

    // 1)페이지 번호
    @Builder.Default //초기화 고정
    @Min(value = 1)
    @Positive //양수로 고정
    private int page = 1;

    // 2) 페이지(page) 당 보여줄 갯수
    @Builder.Default //초기화 고정
    @Min(value = 10)
    @Max(value = 100)
    @Positive //양수로 고정
    private int size = 10;

    // 3) 몇개를 건너띄기 할건지.
    public int getSkip() {
        return (page -1) * 10;
    }
}
