package st.payment.model.paths;

public enum StripeEnumPath {

    CUSTOMER("Private");

    private final String value;

    StripeEnumPath(final String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
