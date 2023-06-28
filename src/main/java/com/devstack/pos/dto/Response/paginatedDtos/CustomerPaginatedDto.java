package com.devstack.pos.dto.Response.paginatedDtos;

import com.devstack.pos.dto.Response.CustomerResponseDto;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CustomerPaginatedDto {

    long size;

    List<CustomerResponseDto> list;

}
