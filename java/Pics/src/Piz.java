import java.awt.*;

public class Piz {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		invertColor("caterpillar.jpg");
	}
	public static void greyPicture(String pictureName){
		Picture picture = new Picture(pictureName);
		for(int i = 0; i < picture.width(); i++){
			for(int j = 0; j < picture.height(); j++){
				Color cur = picture.get(i, j);	
				int greyscale = cur.getRed() + cur.getBlue() + cur.getGreen();
				greyscale /= 3;
				Color nin = new Color(greyscale, greyscale, greyscale);
				picture.set(i, j, nin);
				
			}
		}
		picture.show();		
	}
	public static void mirrorX(String pictureName){
		Picture picture = new Picture(pictureName);
		//picture.show();
		for(int i = 0; i < picture.width()/2; i++){
			for(int j = 0; j < picture.height(); j++){
				int mirrorSpot = picture.width() - i-1;
				picture.set(mirrorSpot, j, picture.get(i, j));
				
			}
		}
		picture.show();			
	}
	public static void mirrorY(String pictureName){
		Picture picture = new Picture(pictureName);
		for(int i = 0; i < picture.width(); i++){
			for(int j = 0; j < picture.height()/2; j++){
				int mirrorSpot = picture.height() - j-1;
				picture.set(i, mirrorSpot, picture.get(i, j));
				
			}
		}
		picture.show();			
	}
	public static void invertColor(String pictureName){
		Picture pic = new Picture(pictureName);
		for(int i=0; i < pic.width(); i++){
			for(int j = 0; j < pic.height(); j++){
				Color currentColor = pic.get(i, j);
				int newRed = 255- currentColor.getRed(); //Don't copy this part
				int newGreen = 255-currentColor.getGreen();
				int newBlue = 255-currentColor.getBlue();
				
				Color newColor = new Color(newRed, newGreen, newBlue);
				pic.set(i, j, newColor);
			}
		}
		pic.show();
	}
	public static void superSample(String pictureName){
	
		Picture pic = new Picture(pictureName);
		Color[][] pixelArray = new Color[pic.width()][pic.height()];
	
		for(int i=0; i < pic.width(); i++){
			for(int j = 0; j < pic.height(); j++){
				
				//Get color
				pixelArray[i][j] = pic.get(i, j);
					
				//Manipulate color in some way
				
				
				//Set Colo
			}
		}
		pic.show();
	}
	public static void swapBlueAndRed(String pictureName){
		Picture picture = new Picture(pictureName);
		for(int i = 0; i < picture.width(); i++){
			for(int j = 0; j < picture.height(); j++){
				Color cur = picture.get(i, j);
				Color newColor = new Color(cur.getBlue(), cur.getGreen(), cur.getRed());
				picture.set(i, j, newColor);
				
			}
		}
		picture.show();			
	}
}
