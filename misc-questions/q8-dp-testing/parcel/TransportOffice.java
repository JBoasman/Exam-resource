
public class TransportOffice {

	private static TransportOffice instance;

	private TransportOffice() {
	}

	public static TransportOffice getInstance() {

		// TODO
		// START YOUR CODE
		if (instance == null) {
			instance = new TransportOffice();
		}
		// YOU ARE ALLOWED TO CHANGE THIS RETURNED VALUE
		return instance;

		// END YOUR CODE
	}

	public Transport transportBy(Parcel parcel) {
        Transport transport;
        if (parcel.getAllowedDays() >= 7) transport = Transport.SHIP;
        else if (parcel.getAllowedDays() >= 3) transport = Transport.TRAIN;
        else if (parcel.getAllowedDays() >= 1 && parcel.getWeight() <= 20) transport = Transport.AIRPLANE;
        else { parcel.setStatus(Status.RETURNED); return null; }
        parcel.setStatus(Status.TRANSFERRING);
        return transport;
    }
}
