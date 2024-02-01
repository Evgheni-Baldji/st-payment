package st.payment.controller;

import com.stripe.model.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import st.payment.model.dto.CustomerDto;
import st.payment.model.input.customer.CustomerCreateInput;
import st.payment.service.CustomerService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService  customerService;
    @PostMapping("/create")
    public ResponseEntity<String> createCustomer(@RequestBody CustomerCreateInput input)
    {
        customerService.createCustomer(input);
        return ResponseEntity.ok("Nice man");
    }
    @GetMapping("/list")
    public ResponseEntity<List<CustomerDto>> getAllCustomer()
    {
        return ResponseEntity.ok(customerService.getAllCustomer());
    }
}
