/**
 * Question 3 - Software Construction and Refactoring
 *
 * - Replace the placeholder strings with your answers.
 * - Be concise and follow the word limits provided in the exam guidelines.
 * - Make sure to fill in your personal information.
 */
public class Q3Answers {
    public static final String UID = "u8201749";
    public static final String NAME = "";

    // For reference only
    static final String SAMPLE_MULTI_LINE_INPUT = """
            You can type your response in a paragraph-line manner for
            readability using triple-quoted Strings,
            like this one.
            """;


    // A) What is the name of the code smell you identified?
    public static final String CODE_SMELL_NAME = "Repeated conditional dispatch";

    // B) Precisely indicate where in the code the smell occurs.
    public static final String SMELL_LOCATION = "The method.equals conditional chain inside PaymentProcessor.processPayment selects credit card, PayPal, or bank transfer behavior.";

    // C) Explain the problem caused by this code smell in the context of the software.
    public static final String SMELL_IMPACT = """
            Each new payment method requires modifying the same conditional chain. PaymentProcessor mixes orchestration with gateway-specific behavior, making it harder to extend, test each method independently, and maintain without affecting other payment methods.
            """;

    // D) What is the name of the design pattern you propose to apply?
    public static final String DESIGN_PATTERN = "Strategy";

    // E) Describe how to apply this design pattern to refactor the code.
    // Be specific and precise about what changes should be made, to which part(s) of the code,
    // and where the changes should be placed.
    public static final String REFACTORING_PLAN = """
            Introduce a PaymentStrategy interface with pay(double amount). Move each gateway-specific branch into CreditCardPayment, PayPalPayment, or BankTransferPayment implementing that interface. Inject a PaymentStrategy into PaymentProcessor and replace the conditional chain with strategy.pay(amount), retaining shared orchestration there. Select the strategy at the caller or composition root, rejecting unknown methods before payment processing. Adding a payment method then requires a new strategy rather than editing PaymentProcessor.
            """;

}