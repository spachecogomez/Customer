/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javeriana.aes.pica.controllers;

import co.edu.javeriana.aes.pica.model.Customer;
import co.edu.javeriana.aes.pica.model.CustomerWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author sebastianpacheco
 */
@Controller
public class CustomerController {
    
    private Logger log = LoggerFactory.getLogger(CustomerController.class);
    
    @RequestMapping(value = "/customer/{id}" , method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody ResponseEntity<CustomerWrapper> getCustomer(@PathVariable Integer id){
        log.info(String.format("The received id was %d",id));
        CustomerWrapper wrapper = new CustomerWrapper();
        Customer cust = new Customer();
        cust.setCustomerId(1);
        cust.setCustomerFirstName("Jon");
        cust.setCustomerLastName("Doe");
        cust.setCustomerAdress("FakeStreet 123");
        cust.setCustomerEmail("jon.dow@test.com");
        cust.setCustomerPhone("222-33-444");
        cust.setCustomerCreditCardType("Visa");
        cust.setCustomerCreditCardNumber("33-44-22-11-22");
        cust.setCustomerStatus("1");
        wrapper.setCustomer(cust);
        return new ResponseEntity<>(wrapper,HttpStatus.OK);
    }
    
    @RequestMapping(value = "/customer" , method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody ResponseEntity<CustomerWrapper> createCustomer(@RequestBody Customer c){
        CustomerWrapper wrapper = new CustomerWrapper();
        c.setCustomerFirstName(c.getCustomerFirstName()+"Created");
        wrapper.setCustomer(c);
        return new ResponseEntity<>(wrapper,HttpStatus.OK);
    }
    
}
