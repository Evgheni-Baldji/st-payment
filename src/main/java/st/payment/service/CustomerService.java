package st.payment.service;

import com.stripe.model.Customer;
import st.payment.model.dto.CustomerDto;
import st.payment.model.input.customer.CustomerCreateInput;

import java.util.List;

public interface CustomerService {
    void createCustomer(CustomerCreateInput input);

    List <CustomerDto>getAllCustomer();
}
