# Q4 - Calculator critique and improved design

The Java files in this folder are the original code being criticised, not completed reference implementations.

## Part 1 - Defects and improvements

- Exponentiate.calculate multiplies by the loop index i, starting at zero, so exponents of at least two incorrectly return zero. It also returns the base for exponent zero. Initialise a result to one and multiply by the base the requested number of times; exponentiation by squaring reduces multiplication count from O(b) to O(log b).
- Define the arithmetic contract: integer division truncates, negative powers generally need a fractional result, and division by zero throws ArithmeticException. Either reject unsupported inputs explicitly or change the result domain consistently, for example to BigDecimal with a rounding policy.
- int addition, subtraction, multiplication, and exponentiation can overflow silently. Use Math.addExact, subtractExact, and multiplyExact if overflow should be rejected, or use BigInteger when arbitrary integer precision is required.
- Client accepts five nullable operation objects and silently chooses the first non-null one. This permits invalid configurations and couples the client to every operation class. Require one non-null Operation instead; reject absent or ambiguous input rather than returning zero as an error sentinel.
- Test exponent zero, one, and several positive values; zero and negative bases; divide by zero; truncation policy; overflow boundaries; and invalid operation selection. The original files have no supplied JUnit tests.

A checked integer power implementation for non-negative exponents is:

```java
static int power(int base, int exponent) {
    if (exponent < 0) throw new IllegalArgumentException("Negative integer exponent");
    int result = 1;
    while (exponent > 0) {
        if ((exponent & 1) != 0) result = Math.multiplyExact(result, base);
        exponent >>>= 1;
        if (exponent > 0) base = Math.multiplyExact(base, base);
    }
    return result; // defines 0^0 as 1; document or reject that case if required
}
```

## Part 2 - Extensibility

- Introduce an Operation interface with calculate() and let Add, Subtract, Multiply, Divide, and Exponentiate implement it. Client receives an Operation and delegates, applying Strategy and dependency inversion. A factory or registry resolves external operation names outside Client.
- A new Modulo or Minimum implementation can then be added without editing Client. For expression input, keep tokenisation, parsing, and evaluation separate; an expression tree can compose nested operations.
- Keep operand immutability, centralise the arithmetic contract, and separate UI formatting from calculation. Select patterns to address concrete variation rather than introducing inheritance solely to remove two field declarations.

## Part 3 - Licensing and IP

- Audit provenance before incorporating third-party algorithms or libraries. A publicly visible repository is not automatically licensed for reuse; obtain permission or select an appropriately licensed implementation.
- Preserve required notices and attribution. MIT-style and copyleft licenses impose different obligations, so check the chosen license against the intended distribution. Copyleft does not prohibit commercial charging.
- State the project's own license and ensure contributors have authority to license their contributions. Do not copy proprietary calculator code simply because the behaviour is familiar.

References: [No license](https://choosealicense.com/no-license/) and [GNU on selling free software](https://www.gnu.org/philosophy/selling.html).
