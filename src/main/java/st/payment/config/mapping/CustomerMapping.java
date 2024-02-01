package st.payment.config.mapping;

import com.stripe.model.Customer;
import org.mapstruct.Mapper;
import st.payment.model.dto.CustomerDto;

@Mapper(componentModel = "spring")
public interface CustomerMapping {

    CustomerDto map(Customer input);
}
