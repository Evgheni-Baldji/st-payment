package st.payment.service.impl;

import com.google.gson.Gson;
import com.stripe.Stripe;
import com.stripe.model.Customer;
import com.stripe.model.CustomerCollection;
import com.stripe.param.CustomerCreateParams;
import com.stripe.param.CustomerListParams;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import st.payment.config.mapping.CustomerMapping;
import st.payment.model.dto.CustomerDto;
import st.payment.model.input.customer.CustomerCreateInput;
import st.payment.service.CustomerService;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerServiceImpl implements CustomerService {
    private static Gson gson = new Gson();
    private final CustomerMapping customerMapping;


    String publicKey = "pk_test_51OYpS6FZL6vs9Mw33Nc4ON4VqgQiZuEALNED04MU10zetObFoNTaDF4cNjGmqbjaRYxJRVx9tIDcwJzv88JNKeQx00nhGfzl95";
    String secretKey = "sk_test_51OYpS6FZL6vs9Mw3wZVWPhLS6eVLTJxLGhUYVukwgj3juqxdAo9Kfb04YHTzn5wRVU8j9gqj2GulLU4WHLPaPk5800KCla0xfD";



    @Override
    public void createCustomer(CustomerCreateInput input) {
        setApiKey();
        Customer customer = null;
        CustomerCreateParams params =
                CustomerCreateParams.builder()
                        .setName(input.getName())
                        .setEmail(input.getEmail())
                        .setDescription(input.getDescription())
                        .build();
        try {
            customer = Customer.create(params);
        } catch (Exception e) {
            log.error("Got exception in creating customer: " + e.getMessage());
        }
        log.debug("Customer was created: " + customer);
    }

    @Override
    public List<CustomerDto> getAllCustomer() {
        setApiKey();
        CustomerListParams params = CustomerListParams.builder().setLimit(3L).build();
        CustomerCollection customers;
        List<CustomerDto> listCustomer = null;
        try {
            customers = Customer.list(params);
            if (customers.getData() == null)
                listCustomer = new ArrayList<>();
            else
                listCustomer = customers.getData().stream().map(customerMapping::map).toList();
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return listCustomer;
    }

    private void setApiKey() {
        Stripe.apiKey = secretKey;
    }
}
