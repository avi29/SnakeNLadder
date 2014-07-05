import java.util.Scanner;



public class SnakeNLadder {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Number of players: ");
	      int playersCount = in.nextInt();
	      
	      SnakeNLadderGame game = new SnakeNLadderGame(playersCount);
	      game.play();
	}
	

	
}
