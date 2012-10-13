import java.util.*;
public class BellCurve {
	public static int[] buckets = new int[51];

	public static void main(String [] args){
		Random rnd= new Random(System.currentTimeMillis());
		for(int i= 0; i < Integer.parseInt(args[0]); i++){
			if(i % 30 == 0){
				//System.out.println();
			}
			buckets[rollDice(10,rnd)-10] += 1;
		}
		displayHistogram();
	}
	public static int rollDice(int times, Random rnd){
		int total = 0;
		for(int i = 0; i < times; i++){
			int rand =(rnd.nextInt(6)+1); 
			total += rand;
		}		
		if(total == 60){
			System.out.println("%");
		}
		return total;
	}
	public static void displayHistogram(){
		for(int i = 0; i <= 50; i++){
			System.out.print((i+10)+ ": ");
			for(int j = 0; j < buckets[i]; j++){
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
