package com.bytesbanana.msscbrewery.services;

import com.bytesbanana.msscbrewery.web.model.CustomerDto;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public interface CustomerService {

    CustomerDto getCustomerById(UUID id);

    CustomerDto addNewCustomer(CustomerDto customerDto);

    CustomerDto updateCustomer(UUID uuid, CustomerDto customerDto);

    void deleteCustomer(UUID id);

}
