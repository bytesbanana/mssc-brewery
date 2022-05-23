package com.bytesbanana.msscbrewery.services;

import com.bytesbanana.msscbrewery.web.model.CustomerDto;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final List<CustomerDto> tempList = List.of(new CustomerDto(UUID.fromString("a6824e6f-57d6-4e0f-9227-aa2e43a876d9"), "aaA"));
    private final List<CustomerDto> customerList = new ArrayList<>(tempList);

    @Override
    public CustomerDto getCustomerById(UUID id) {
        return customerList.stream()
                .filter((customerDto -> customerDto.getId().equals(id)))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Customer is not found"));
    }

    @Override
    public CustomerDto addNewCustomer(CustomerDto customerDto) {
        customerDto.setId(UUID.randomUUID());
        customerDto.setName(customerDto.getName());
        customerList.add(customerDto);

        return customerDto;
    }

    @Override
    public CustomerDto updateCustomer(UUID id, CustomerDto customerDto) {


        CustomerDto customerToUpdate = customerList.get(findIndexById(id));
        customerToUpdate.setName(customerDto.getName());
        return customerToUpdate;
    }

    @Override
    public void deleteCustomer(UUID id) {
        int index = findIndexById(id);
        customerList.remove(customerList.get(index));
    }

    private int findIndexById(UUID id) {
        int foundIndex = -1;
        for (int i = 0; i <  customerList.size(); i++) {
            CustomerDto customer = customerList.get(i);
            if (customer.getId().equals(id)) {
                foundIndex = i;
                break;
            }
        }
        return foundIndex;
    }


}
