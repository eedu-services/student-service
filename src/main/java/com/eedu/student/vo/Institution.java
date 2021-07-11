package com.eedu.student.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Institution {
    private Long id;
    private String name;
    private String email;
    private String code;
    private String address;
}
