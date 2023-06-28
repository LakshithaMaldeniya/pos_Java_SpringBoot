package com.devstack.pos.service.impl;

import com.devstack.pos.dto.Request.CustomerRequestDto;
import com.devstack.pos.dto.Response.CustomerResponseDto;
import com.devstack.pos.dto.Response.paginatedDtos.CustomerPaginatedDto;
import com.devstack.pos.dto.core.CustomerDto;
import com.devstack.pos.entity.Customer;
import com.devstack.pos.exception.EntryNotFoundException;
import com.devstack.pos.repo.CustomerRepo;
import com.devstack.pos.service.CustomerService;
import com.devstack.pos.util.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepo customerRepo;

    private final CustomerMapper customerMapper;


    @Autowired
    public CustomerServiceImpl(CustomerRepo customerRepo, CustomerMapper customerMapper) {
        this.customerRepo = customerRepo;
        this.customerMapper = customerMapper;
    }

    @Override
    public CustomerResponseDto createCustomer(CustomerRequestDto dto) {
        CustomerDto customerDto = new CustomerDto(
                0,
                new Random().nextInt(100001),
                dto.getName(),
                dto.getAddress(),
                dto.getSalary(),
                true,
                null,
                null,
                null,
                null
        );

        System.out.println(customerDto);
        Customer customer = customerMapper.toCustomer(customerDto);
        customerRepo.save(customer);
        return new CustomerResponseDto(
                customerDto.getPublicId(),
                customerDto.getName(),
                customerDto.getAddress(),
                customerDto.getSalary(),
                customerDto.isActiveState()
        );
    }

    @Override
    public CustomerResponseDto findCustomer(long id){
        Customer selectedCustomer = customerRepo.findByPublicId(id);


        if (null != selectedCustomer) {
            return new CustomerResponseDto(
                    selectedCustomer.getPublicId(),
                    selectedCustomer.getName(),
                    selectedCustomer.getAddress(),
                    selectedCustomer.getSalary(),
                    selectedCustomer.isActiveState()
            );
        } else {
            throw new EntryNotFoundException("Customer Not found");
        }
    }

    @Override
    public void deleteCustomer(long id){
        System.out.println(id);
        Customer selectedCustomer = customerRepo.findByPublicId(id);
        if (null != selectedCustomer) {
            customerRepo.delete(selectedCustomer);
        } else {
            throw new EntryNotFoundException("Customer Not found");
        }
    }

    @Override
    public CustomerResponseDto updateCustomer(long id, CustomerRequestDto dto) {
        Customer customer = customerRepo.findByPublicId(id);
        if (null != customer) {
            customer.setName(dto.getName());
            customer.setAddress(dto.getAddress());
            customer.setSalary(dto.getSalary());
            customerRepo.save(customer);

            return new CustomerResponseDto(
                    customer.getPublicId(),
                    customer.getName(),
                    customer.getAddress(),
                    customer.getSalary(),
                    customer.isActiveState()
            );


        } else {
            throw new EntryNotFoundException("Customer Not found");
        }
    }

    @Override
    public CustomerPaginatedDto findAllCustomers(long page, long size, String searchText) {
        List<Customer> list = customerRepo.findAll();
        List<CustomerResponseDto> customerResponseDtoList = new ArrayList<>();
        long count =customerRepo.count();
        for (Customer c:list
             ) {
            CustomerResponseDto customerResponseDto = new CustomerResponseDto(
                    c.getPublicId(),
                    c.getName(),
                    c.getAddress(),
                    c.getSalary(),
                    c.isActiveState()
            );
            customerResponseDtoList.add(customerResponseDto);
        }
        return new CustomerPaginatedDto(count,customerResponseDtoList);
    }




}
