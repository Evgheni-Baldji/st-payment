package st.payment.model.input.customer;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class CustomerCreateAddressInput {
    private String city;
    private String country;
    private String line1;
    private String line2;
    private String postal_code;
    private String state;
}
