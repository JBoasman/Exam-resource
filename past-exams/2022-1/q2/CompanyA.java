import java.util.List;

public class CompanyA extends ExpressCompany {

	public CompanyA(Point location, int deliveryRadius, List<ItemType> illegalItems) {
		super(location, deliveryRadius, illegalItems);
	}

	@Override
	public double calculateQuote(Parcel parcel) {
        int w = parcel.getWeight();
        double quote = Math.min(w, 20) * 1.3 + Math.max(0, Math.min(w - 20, 20)) * 1.7
            + Math.max(0, Math.min(w - 40, 20)) * 2.4 + Math.max(0, w - 60) * 3.2;
        int distance = calculateDistance(parcel);
        if (distance > deliveryRadius) quote += distance;
        return quote;
    }
}
