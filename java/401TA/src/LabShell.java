
import java.util.*;
/*
   Sample run:

      bash-3.2$ java LabShell
      Type coefs from lowest to highest power, hit enter ^D:
      To stop enter 0, hit enter and ^D: 105 -76 -34 4 1
      The rational roots of 1x^4 + 4x^3 - 34x^2 - 76x + 105 are:
       1
      -3
       5
      -7

      Type coefs from lowest to highest power, hit enter ^D:
      To stop enter 0, hit enter and ^D: 0
      bash-3.2$
*/


public class LabShell{
   public static void main(String[] args){
      Scanner keyboard = null;
      Polynomial p = null;

      while(true){
         System.out.print("Type coefs from lowest to highest power, hit enter ^D:\nTo stop enter 0, hit enter and ^D: ");
         p = readPoly(keyboard);      
         
         if(p.eq(new Polynomial(0,0))) break;

         computeRationalRoots(p);
         System.out.println();
      }
   }


    public static Polynomial readPoly(Scanner scan){
        Scanner keyboard = new Scanner(System.in);
        String polyline = keyboard.nextLine();
        String[] newPolyline = polyline.split(" ");
        int ar[] = new int[newPolyline.length];
    
        for(int i = 0; i < newPolyline.length; i++){
            ar[i] = Integer.parseInt(newPolyline[i]);
        }
    
        Polynomial p = new Polynomial(ar[0],0);
    
        for(int k=1; k < ar.length; k++){
            p = p.plus(new Polynomial(ar[k],k));
        }
   
   return p;
   }


   public static ArrayList<Integer> divisors(int x){
	   
	   ArrayList<Integer> div = new ArrayList();
	   
	   for(int i = 1; i <= x; i++){
                if(x%i == 0){
                    div.add(i);
                    div.add(-1*i);
                }
	   }
	   
	   return div;
   }


   public static void computeRationalRoots(Polynomial p){
	   int[] coef = p.coef();
	   ArrayList<Integer> a_n = divisors(p.coef()[coef.length-1]);
	   ArrayList<Integer> a_0 = divisors(p.coef()[0]);
	   ArrayList<Rational> roots = new ArrayList();
	   System.out.println(p);
	   System.out.println(a_n);
	   System.out.println(a_0);
	   for(int i = 0; i < a_n.size(); i++){
		   for(int j = 0; j < a_0.size(); j++){
               Rational r = new Rational(a_0.get(j), a_n.get(i));
                       
			   if(p.evaluate((int)r.toDouble())== 0){
				   System.out.println(r.toDouble()+ "fe");
			   }
		   }
	   }  
   }
}