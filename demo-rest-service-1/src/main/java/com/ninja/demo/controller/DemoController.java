package com.ninja.demo.controller;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ninja.demo.jpa.DemoRepository;
import com.ninja.demo.entity.DemoEntity;
@RestController
@RequestMapping("/")
public class DemoController {
 
 // DemoEntity is the Customer Object
 
 @Autowired
 DemoRepository demoRepository;
 
 // Get All Customers
 @GetMapping("/customers")
 List<DemoEntity> all(){
 return demoRepository.findAll(); 
 }
 
 // Get Single Customer
 @GetMapping("/customers/{id}")
 Optional <DemoEntity> findCustomer(@PathVariable Long id){
 return demoRepository.findById(id);
 }
 
 // Create New Customer
 @PostMapping("/customers")
 List<DemoEntity> createCustomer (@RequestBody List<DemoEntity> newCustomer) {
 return demoRepository.saveAll(newCustomer);
 }
 
 // Update Customer Information
	/*
	 * @PutMapping("/customers/edit/{id}")
	 * 
	 * 
	 * DemoEntity updateCustomer (@RequestBody DemoEntity
	 * updatedCustomer, @PathVariable Long id) { return
	 * demoRepository.save(updatedCustomer); }
	 */
	 
	 
	
	
	  @PutMapping("/customers/edit/{id}") 
	  void updatecustomerCity(@PathVariable int id, @RequestBody DemoEntity customer ) {
	  
	  DemoEntity customer_ = demoRepository.findById((long) id).get();
	  if(!(customer.getCustomerCity()==null))
	  {
		  customer_.setCustomerCity(customer.getCustomerCity());
		  System.out.println("The updated city is " + customer.getCustomerCity());
	  }
	  if(!(customer.getCustomerState()==null))
	  {
		  customer_.setCustomerState(customer.getCustomerState());
		  System.out.println("The updated city is " + customer.getCustomerState());
	  }
	  
	  	  
	  System.out.println("Updated"); 
	  demoRepository.save(customer_); 
	  }
	 
	
	 
 // Delete Single Customer
 @DeleteMapping ("/customers/{id}")
 void deleteCustomer(@PathVariable Long id){
 demoRepository.deleteById(id);
 }


}