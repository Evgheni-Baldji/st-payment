package st.payment.model.dto;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CustomerDto {
    private String email;
    private String name;
    private String description;
}
