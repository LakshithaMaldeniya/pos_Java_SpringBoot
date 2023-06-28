package com.devstack.pos.dto.Request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CustomerRequestDto {
    private String name;
    private String address;
    private double salary;
}
