import java.util.Random;


public class Utility {
	public int generateRandomNo(int maxNumber){
		Random rand = new Random();
		return rand.nextInt(maxNumber);
	}
}
