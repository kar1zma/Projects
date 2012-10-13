
public class ShiftRegister extends Register {

	/**
	 * 
	 * @param n - Size of the register.
	 * @throws IllegalArgument exception if you attempt to enter n that is not 8,16, or 32.
	 */
	public ShiftRegister(int n) {
		super(n);
	}
	/**
	 * 
	 * @param slr - Will do a deep copy of the register input.
	 */
	public ShiftRegister(ShiftRegister slr){
		super(slr);
	}
	/**
	 * 
	 * @return will return the boolean value of the bit shifted off the end of the array.
	 */
	public boolean shiftLeft(){
		boolean ret = this.getRegister(this.length()-1);
		
		for(int i = this.length()-1; i > 0; i--){
			setRegister(i, getRegister(i-1));
		}
		setRegister(0, false);
		return ret;
		
	}
	/**
	 * 
	 * @return the right most bit shifted off. 
	 * 
	 * Be careful implementing this function. If the left most bit is a 1, then you NEED to copy a 1 to the new shifted value as well.
	 */
	public boolean shiftRight(){
		boolean ret = getRegister(0);
		boolean sign = getRegister(length()-1);
		for(int i = 0; i < length()-1; i++){
			setRegister(i, getRegister(i+1));
		}
		setRegister(length()-1, sign);
		return ret;
	}

}
