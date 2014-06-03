import java.util.Scanner;



public class SnakeNLadder {
	static int playersCount;
	public static void main(String[] args) {
		Board board = new Board();
		Scanner in = new Scanner(System.in);
		System.out.println("Number of players: ");
	      playersCount = in.nextInt();
	      
	      Player[] players = new Player [playersCount];
	      for(int i=0;i<playersCount;i++){
	    	  players[i]=new Player();
	      }

	      board.showBoard(players);
	      
		SnakeNLadder snakeNLadder = new SnakeNLadder();
		
		while(!snakeNLadder.gameCompleted()){
		for(int i=0;i<playersCount;i++){
			if(players[i].getStatus().equalsIgnoreCase("Playing")){
				snakeNLadder.callProcess(board, players[i],i);
				if(snakeNLadder.gameCompleted()){
					System.out.println("Game completed!!!");
					break;
				}
			}
			board.showBoard(players);
		}
		}
		
	}
	
	
	public void callProcess(Board board, Player player, int playerNumber){
		Scanner in = new Scanner(System.in);
		System.out.println("Player "+String.valueOf(playerNumber+1)+" move :");
		int move = in.nextInt();
		board.processMove(player,move);
		if(player.userGameCompleted()){
			System.out.println("Player "+String.valueOf(playerNumber+1)+" game completed!!");
		}else if(move==1||move==6){
			callProcess(board, player, playerNumber);
		}
	}
	
	public boolean gameCompleted() {
		boolean status = false;
		if(Player.winnersCount==playersCount-1){
			status = true;
		}
		return status;
	}
	
}
