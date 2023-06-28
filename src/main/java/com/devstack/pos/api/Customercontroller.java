package com.devstack.pos.api;

import com.devstack.pos.dto.Request.CustomerRequestDto;
import com.devstack.pos.dto.Response.CustomerResponseDto;
import com.devstack.pos.service.CustomerService;
import com.devstack.pos.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/pos/customers")
public class Customercontroller {

    private final CustomerService customerService;

    @Autowired
    public Customercontroller(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<StandardResponse> createCustomer(
            @RequestBody CustomerRequestDto customerRequestDto) {
        return new ResponseEntity<>(
                new StandardResponse(201, "Customer Saved", customerService.createCustomer(customerRequestDto)), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StandardResponse> findCustomer(@PathVariable long id) {
        return new ResponseEntity<>(
                new StandardResponse(200, "Customer Found", customerService.findCustomer(id)), HttpStatus.OK);
    }

    @DeleteMapping(params = "id")
    public ResponseEntity<StandardResponse> deleteCustomer(@RequestParam long id){
        customerService.deleteCustomer(id);
        return new ResponseEntity<>(
                new StandardResponse(204, "Customer Deleted", null), HttpStatus.NO_CONTENT);
    }

    @PutMapping(params = "id")
    public ResponseEntity<StandardResponse> updateCustomer(
            @RequestParam long id,
            @RequestBody CustomerRequestDto dto
    ) throws ClassNotFoundException {
        System.out.println(id);
        System.out.println(dto.toString());
        return new ResponseEntity<>(
                new StandardResponse(201, "Customer Deleted", customerService.updateCustomer(id,dto)), HttpStatus.CREATED);
    }

    @GetMapping(value = "/list" , params = {"page","size","searchText"})
    public ResponseEntity<StandardResponse> findAllCustomers(
            @RequestParam long page,
            @RequestParam long size,
            @RequestParam String searchText
    ){
        System.out.println(page);
        System.out.println(size);
        System.out.println(searchText);
        return new ResponseEntity<>(
                new StandardResponse(200, "Customer List", customerService.findAllCustomers(page,size,searchText)), HttpStatus.OK);
    }





}
