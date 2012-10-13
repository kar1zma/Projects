public class PseudoInstruction extends Instruction{
	private Operation opt;
	private String label;
	private int rs, rt, labelTranslated;
	boolean isTranslated;

	public PseudoInstruction(String opCode, String rs, String rt, String label) throws InvalidInstructionException{
		opt = translateOpName(opCode);
		this.label = label;
		this.rs = Integer.parseInt(rs.substring(2)); 
		this.rt = Integer.parseInt(rt.substring(2)); 
		this.label = label;
		isTranslated = false;
	}

	public PseudoInstruction(String opCode, String label){
		opt = translateOpName(opCode);
		this.label = label;
		isTranslated = false;
	}
	public ArrayList<Instruction> resolveInstructions() throws InvalidInstructionException{
		ArrayList<Instruction> temp = new ArrayList<Instruction>();
		if(!isTranslated){
			throw new InvalidInstructionException("Label couldn't be translated");
		}
		
		return temp;
	}

}