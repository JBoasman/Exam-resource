package parcel;

public class Parcel implements Comparable<Parcel> {
	private final int id;
	private final int weight;
	private final int allowedDays;
	private final Sender sender;
	private final Recipient recipient;

	public Parcel(int id,int weight, int allowedDays, Sender sender, Recipient recipient) {
		this.id = id;
		this.weight = weight;
		this.allowedDays = allowedDays;
		this.sender = sender;
		this.recipient = recipient;
	}

	public Parcel(Parcel parcel) {
		this.id = parcel.id;
		this.weight = parcel.weight;
		this.allowedDays = parcel.allowedDays;
		this.sender = new Sender(parcel.sender);
		this.recipient = new Recipient(parcel.recipient);
	}

	public int getId(){
		return id;
	}

	public int getWeight() {
		return weight;
	}

	public int getAllowedDays() {
		return allowedDays;
	}

	public Sender getSender() {
		return sender;
	}

	public Recipient getRecipient() {
		return recipient;
	}

	@Override
	public int compareTo(Parcel other) {
		// TODO
		// START YOUR CODE
		//this distance minus other distance, zero if same distance
		//distance is warehouse to recipient
		CartesianCoordinate wh = new CartesianCoordinate(20,10);
		double od = wh.getDistance(other.getRecipient().getLocation());
		double pd = wh.getDistance(this.getRecipient().getLocation());

		return Double.compare(pd, od);
		// END YOUR CODE
	}

	@Override
	public String toString() {
		return "Parcel{" +
				"id=" + id +
				", sender=" + sender +
				", recipient=" + recipient +
				'}';
	}

}
