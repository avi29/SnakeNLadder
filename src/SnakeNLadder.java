import java.util.Scanner;



public class SnakeNLadder {
	 private int playersCount;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Number of players: ");
	      int playersCount = in.nextInt();
	      
	      SnakeNLadder game = new SnakeNLadder(playersCount);
	      game.start();
	      		
	}
	
	public SnakeNLadder(int playersCount) {
		this.playersCount = playersCount;
	}
	

	private void start() { 
		Board board = new Board();
		Scanner in = new Scanner(System.in);

	      Player[] players = new Player [playersCount];
	      for(int i=0;i<playersCount;i++){
	    	  players[i]=new Player();
	      }

	      board.showBoard(players);
	      
		
		
		while(!gameCompleted()){
		for(int i=0;i<playersCount;i++){
			if(players[i].getStatus().equalsIgnoreCase("Playing")){
				System.out.println("Player "+String.valueOf(i+1)+" move :");
				int move = in.nextInt();
				board.processMove(players[i],move);
				if(players[i].userGameCompleted()){
					System.out.println("Player "+String.valueOf(i+1)+" game completed!!");
				}else{
				while(move==1||move==6){
					System.out.println("Player "+String.valueOf(i+1)+" move :");
					move = in.nextInt();
					board.processMove(players[i],move);
					if(players[i].userGameCompleted()){
						System.out.println("Player "+String.valueOf(i+1)+" game completed!!");
						break;
					}
				}
				}
				if(gameCompleted()){
					System.out.println("Game completed!!!");
					break;
				}
			}
			board.showBoard(players);
		}
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
