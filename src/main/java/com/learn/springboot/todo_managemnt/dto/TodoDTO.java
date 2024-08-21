package com.learn.springboot.todo_managemnt.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TodoDTO {

    private Long id;
    private String title;
    private String description;
    private Boolean completed;

}
