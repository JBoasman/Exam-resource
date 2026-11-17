import java.util.List;

public class CompanyB extends ExpressCompany {

	public CompanyB(Point location, int deliveryRadius, List<ItemType> illegalItems) {
		super(location, deliveryRadius, illegalItems);
	}

	@Override
	public double calculateQuote(Parcel parcel) {
        int w = parcel.getWeight();
        double quote = 46 + Math.max(0, Math.min(w - 30, 10)) * 1.5
            + Math.max(0, Math.min(w - 40, 10)) * 2.1 + Math.max(0, Math.min(w - 50, 10)) * 2.9 + Math.max(0, w - 60) * 3.6;
        int distance = calculateDistance(parcel);
        if (distance > deliveryRadius) quote += distance * 1.1;
        return quote;
    }
}
