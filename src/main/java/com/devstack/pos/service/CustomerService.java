package com.devstack.pos.service;

import com.devstack.pos.dto.Request.CustomerRequestDto;
import com.devstack.pos.dto.Response.CustomerResponseDto;
import com.devstack.pos.dto.Response.paginatedDtos.CustomerPaginatedDto;

public interface CustomerService {

    public  CustomerResponseDto createCustomer(CustomerRequestDto dto);
    public  CustomerResponseDto findCustomer(long id);
    public  void deleteCustomer(long id);
    public  CustomerResponseDto updateCustomer(long id,CustomerRequestDto dto);

    public CustomerPaginatedDto findAllCustomers(long page, long size, String searchText);


}
