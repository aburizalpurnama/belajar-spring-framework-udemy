package com.rizal.spring.aop.entity;

import lombok.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    private String name;
    private String level;
}
