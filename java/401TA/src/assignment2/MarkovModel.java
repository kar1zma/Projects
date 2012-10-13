
import java.util.HashMap;
import java.util.Random;

public class MarkovModel {
	private int k;
	private HashMap<String, int[]> markovTable;
    public MarkovModel(String text, int k){
    	markovTable = new HashMap<String, int[]>();
    	this.k = k;
    	char[] temp = new char[k];
    	for(int i = 0; i < text.length(); i++){
    		for(int j = 0; j < k; j++){
    			temp[j] = text.charAt((i+j)%text.length());
    		}
    		String key = new String(temp);
    		int[] frequency;
    		if(!markovTable.containsKey(key))
    			frequency = new int[256];
    		else
    			frequency = markovTable.get(key);
    		char nextCharacter = text.charAt((i+k)%text.length());
				System.out.println(nextCharacter);
    		frequency[nextCharacter] += 1;
			markovTable.put(key, frequency);    		
    	}
    }
    int order() {
    	return k;
    }
    int freq(String kgram) throws KGramSizeException{
    	if(kgram.length() < k){
    		throw new KGramSizeException();
    	}
    	int ret = -1;
    	if(markovTable.containsKey(kgram)){
    		ret = 0;
    		int[] frequency = markovTable.get(kgram);
    		for(int i = 0; i < frequency.length; i++){
    			ret += frequency[i];
    		}
    		
    	}
    	return ret;
    }
    int freq(String kgram, char c) throws KGramSizeException{
    	if(kgram.length() != k){
    		throw new KGramSizeException();
    	}
    	int ret = -1;
    	if(markovTable.containsKey(kgram)){
    		ret = markovTable.get(kgram)[c];
    	}
    	return ret;
    	// number of times that character c follows kgram
    }
    char rand(String kgram) throws KGramSizeException{

    	if(kgram.length() != k){
    		throw new KGramSizeException();
    	}
    	Random rand = new Random();
    	int ranNum=rand.nextInt(this.freq(kgram))+1;
    	int[] frequency = markovTable.get(kgram);
    	int iter = 0;

    	while(ranNum > 0){
    		ranNum -= frequency[iter];
    		if(ranNum <= 0){
    			break;
    		}
    		iter+=1;
    	}
    	return (char)iter;
    }
}
