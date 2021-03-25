package broker.three.exception;

public class RecordNotFoundException extends Exception {

	public RecordNotFoundException() {
		this("Record Not Found...");
	}
	public RecordNotFoundException(String message) {
		super(message);
	}
	
}
