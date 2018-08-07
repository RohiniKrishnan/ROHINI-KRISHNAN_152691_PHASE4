package com.cg.spring.paymentwallet.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.cg.spring.paymentwallet.dto.Customer;
@Repository("paymentWalletRepo")
public interface IPaymentWalletRepo extends CrudRepository<Customer, String>{

 
}
