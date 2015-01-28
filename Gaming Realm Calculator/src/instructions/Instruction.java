package instructions;

public class Instruction {

	private String token;
	private int number;
	
	public Instruction(String token, int number) {
		this.token = token;
		this.number = number;
	}
	
	public String getToken() {
		return this.token;
	}
	
	public int getNumber() {
		return this.number;
	}
}
