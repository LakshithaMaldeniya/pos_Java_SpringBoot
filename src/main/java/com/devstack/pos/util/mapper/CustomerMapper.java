package com.devstack.pos.util.mapper;
import com.devstack.pos.dto.core.CustomerDto;
import com.devstack.pos.entity.Customer;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface CustomerMapper {

    Customer toCustomer(CustomerDto dto);

}
