import java.util.Scanner;



public class SnakeNLadder {
	public static void main(String[] args) {
		Board board = new Board();
		Scanner in = new Scanner(System.in);
		System.out.println("Number of players: ");
	      int playersCount = in.nextInt();
		Players players = new Players(playersCount);
		board.showBoard(players);
		
		while(!players.gameCompleted()){
		for(int i=0;i<playersCount;i++){
			if(players.playersStatus[i].equalsIgnoreCase("Playing")){
				callProcess(board, players, i);
				if(players.gameCompleted()){
					System.out.println("Game completed!!!");
					break;
				}
			}
			board.showBoard(players);
		}
		}
		
	}
	
	
	public static void callProcess(Board board, Players players, int player){
		Scanner in = new Scanner(System.in);
		System.out.println("Player "+String.valueOf(player+1)+" move :");
		int move = in.nextInt();
		board.processMove(players.playersPostion,player,move);
		if(players.userGameCompleted(player)){
			System.out.println("Player "+String.valueOf(player+1)+" game completed!!");
		}else if(move==1||move==6){
			callProcess(board, players, player);
		}
	}
	
	
}
