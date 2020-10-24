package atm;

public class EncashmentCassette {
	private int denomination;
	private int notesCount;
	
	public EncashmentCassette(String denomination, String notesCount) {
		this.denomination = Integer.parseInt(denomination);
		this.notesCount = Integer.parseInt(notesCount);
	}
}
