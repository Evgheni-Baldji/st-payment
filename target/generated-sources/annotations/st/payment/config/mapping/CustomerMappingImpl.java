package st.payment.config.mapping;

import com.stripe.model.Customer;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import st.payment.model.dto.CustomerDto;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-29T17:42:31+0200",
    comments = "version: 1.5.1.Final, compiler: javac, environment: Java 17.0.9 (Private Build)"
)
@Component
public class CustomerMappingImpl implements CustomerMapping {

    @Override
    public CustomerDto map(Customer input) {
        if ( input == null ) {
            return null;
        }

        CustomerDto customerDto = new CustomerDto();

        customerDto.setEmail( input.getEmail() );
        customerDto.setName( input.getName() );
        customerDto.setDescription( input.getDescription() );

        return customerDto;
    }
}
