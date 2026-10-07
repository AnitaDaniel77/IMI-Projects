// Interface Segregation Principle: don't force a class to implement methods it has no real use for
public class SolidISP {
    public static void main(String[] args) {
        PayPal payPal = new PayPal();
        System.out.println("VAT: " + payPal.vatCalculation());
        // payPal.makePayment() would throw, this payment method doesn't actually support it
    }
}

abstract class PaymentMethod {
    int vatCalculation() {
        return 15; // default VAT
    }
}

interface MakePayments {
    boolean makePayment();
}

class PayPal extends PaymentMethod implements MakePayments {
    @Override
    int vatCalculation() {
        return 20; // PayPal has its own VAT rule
    }

    public boolean makePayment() {
        throw new UnsupportedOperationException("Unimplemented method 'makePayment'");
    }
}