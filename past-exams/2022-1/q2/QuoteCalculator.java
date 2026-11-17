public class QuoteCalculator {

	public static Quote bestQuote(Parcel parcel, ExpressCompany a, ExpressCompany b) throws IllegalParcelItemException {
        double qa = a.handle(parcel), qb = b.handle(parcel);
        return qa <= qb ? new Quote(a, qa) : new Quote(b, qb);
    }
}
