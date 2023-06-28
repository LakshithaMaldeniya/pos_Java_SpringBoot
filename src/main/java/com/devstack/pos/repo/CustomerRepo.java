package com.devstack.pos.repo;

import com.devstack.pos.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer,Long> {
public  Customer findByPublicId(long id);
}
