package com.vsu.cs.maslova_e_i.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Patient {
    private int id;
    private String fullName;
    private int age;
    private String gender;
    private String departmentName;
}
