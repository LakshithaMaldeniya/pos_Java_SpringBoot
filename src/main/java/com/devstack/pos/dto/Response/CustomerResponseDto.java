package com.devstack.pos.dto.Response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CustomerResponseDto {

    private long publicId;
    private String name;
    private String address;
    private double salary;
    private boolean activeState;
}
