import java.util.Scanner;


public class StringSplit {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner keyboard = new Scanner(System.in);
		String polyLine = keyboard.nextLine();
		String[] a = polyLine.split(" ");
		Polynomial ret = new Polynomial(Integer.parseInt(a[0]), 0);
    	for(int i = 1; i < a.length; i++){
    		int coef = Integer.parseInt(a[i]);
    		ret = ret.plus(new Polynomial(coef, i));
    	}
    	System.out.println(ret);
    	int i = 1;
    	int j = 2;
    	Rational k = new Rational(i,j);
    	System.out.println(k.toDouble());
	}

}
