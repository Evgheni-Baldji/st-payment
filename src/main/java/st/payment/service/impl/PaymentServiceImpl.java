package st.payment.service.impl;

import com.google.gson.Gson;
import com.stripe.Stripe;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl {
    private static Gson gson = new Gson();
    String publicKey = "pk_test_51OYpS6FZL6vs9Mw33Nc4ON4VqgQiZuEALNED04MU10zetObFoNTaDF4cNjGmqbjaRYxJRVx9tIDcwJzv88JNKeQx00nhGfzl95";
    String secretKey = "sk_test_51OYpS6FZL6vs9Mw3wZVWPhLS6eVLTJxLGhUYVukwgj3juqxdAo9Kfb04YHTzn5wRVU8j9gqj2GulLU4WHLPaPk5800KCla0xfD";

    public void createPayment() {
        Stripe.apiKey = secretKey;
    }
}
