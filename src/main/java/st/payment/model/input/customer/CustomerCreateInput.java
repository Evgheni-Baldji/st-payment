package st.payment.model.input.customer;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class CustomerCreateInput {
    private String name;
    private String email;
    private String description;
    private String address;
    private String phone;
    private List<String> paymentMethod;
}
