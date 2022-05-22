package com.bytesbanana.msscbrewery.services;

import com.bytesbanana.msscbrewery.web.model.CustomerDto;

import java.util.UUID;

public interface CustomerService {
    CustomerDto getCustomerById(UUID id);
}
