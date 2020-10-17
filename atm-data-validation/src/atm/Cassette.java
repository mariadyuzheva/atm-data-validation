package atm;

public class Cassette {
	private int denomination;
	private int notesCount;
	
	public Cassette(String denomination, String notesCount) {
		this.denomination = Integer.parseInt(denomination);
		this.notesCount = Integer.parseInt(notesCount);
	}
}
