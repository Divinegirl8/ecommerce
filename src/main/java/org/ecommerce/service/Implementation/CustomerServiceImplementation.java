package org.ecommerce.service.Implementation;

import lombok.Data;
import org.ecommerce.data.model.Customers;
import org.ecommerce.data.repository.CustomerRepository;
import org.ecommerce.dtos.request.ShoppingRequest;
import org.ecommerce.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImplementation implements CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Customers shop(ShoppingRequest shoppingRequest) {
        Customers customers = new Customers();
        customers.setShoppingCart(shoppingRequest.getShoppingCart());
        customers.setBillingInformation(shoppingRequest.getBillingInformation());
        customerRepository.save(customers);
        return customers;
    }
}
