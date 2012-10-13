import java.util.Random;


public class BellRecursive {
	public static int[] buckets = new int[61];
	public static double[] probability = new double[61];
	public static int total;
	public static void main(String [] args){
		Random rnd= new Random(System.currentTimeMillis());
		total = 200000;
		for(int i= 0; i < total; i++){
			buckets[rollDice(10,rnd)] += 1;
		}
		System.out.printf("%19s %11s\n", "experiment", "theory");
		System.out.printf("%3s %15s %11s\n", "sum", "p(sum)", "p(sum)");
		calculateProbability();
		for(int i = 10; i < 60; i++){
			System.out.printf(" %2d          %f    %f\n",i, probability[i],probability(10,i));	
		}
		
	}
	public static double probability(int M, int k){
		if((k >= 1 && k <= 6) && M == 1){
			return 1.0/6.0;
		}
		else if((k < 1 || k > 6)&& M == 1){
			return 0;
		}
		else if(M % 2 == 0){
			double sum = 0;
			for(int i = 1; i < k; i++){

				sum += probability(M/2, i)*probability(M/2, k-i);
			}
			return sum;
		}
		else{
			double sum = 0;
			for(int i = 1; i < k; i++){
				sum+= probability(M/2, i)*probability(M/2+1, k-i);
			}
			return sum;
		}
	}
	public static int rollDice(int times, Random rnd){
		int total = 0;
		for(int i = 0; i < times; i++){
			int rand =(rnd.nextInt(6)+1); 
			total += rand;
		}		
		return total;
	}
	public static void calculateProbability(){
		double totPercent = 0;
		for(int i = 0; i < buckets.length; i++){
			probability[i] = (double)(buckets[i])/total;
			totPercent += probability[i];
		}
	}
}
