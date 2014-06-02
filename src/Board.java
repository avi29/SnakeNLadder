import java.util.Random;


public class Board {
	String grid[][];
	String gridInList[];
	int snakeHeads[];
	int snakeTails[];
	int ladderHeads[];
	int ladderTails[];
	
	public Board() {
		this.gridInList = new String[100];
		for(int j=0;j<100;j++){
			gridInList[j] = String.valueOf(j+1);
		}
		snakeHeads = new int[3];
		snakeTails = new int[3];
		ladderHeads = new int[3];
		ladderTails = new int[3];
		
				//snake head nodes
		snakeHeads[0] = (generateRandomNo(100));
		snakeHeads[1] = (generateRandomNo(100));
		snakeHeads[2] = (generateRandomNo(100));
				
				//snake tail nodes
		snakeTails[0] = (generateRandomNo(snakeHeads[0]));
		snakeTails[1] = (generateRandomNo(snakeHeads[1]));
		snakeTails[2] = (generateRandomNo(snakeHeads[2]));
				
				//ladder head nodes
		ladderHeads[0] = (generateRandomNo(100));
		ladderHeads[1] = (generateRandomNo(100));
		ladderHeads[2] = (generateRandomNo(100));
				
				//ladder tail nodes
		ladderTails[0] = (generateRandomNo(ladderHeads[0]));
		ladderTails[1] = (generateRandomNo(ladderHeads[1]));
		ladderTails[2] = (generateRandomNo(ladderHeads[2]));
				
		gridInList[snakeHeads[0]] = "sh1";
		gridInList[snakeHeads[1]] = "sh2";
		gridInList[snakeHeads[2]] = "sh3";
		gridInList[snakeTails[0]] = "st1";
		gridInList[snakeTails[1]] = "st2";
		gridInList[snakeTails[2]] = "st3";
		gridInList[ladderHeads[0]] = "lh1";
		gridInList[ladderHeads[1]] = "lh2";
		gridInList[ladderHeads[2]] = "lh3";
		gridInList[ladderTails[0]] = "lt1";
		gridInList[ladderTails[1]] = "lt2";
		gridInList[ladderTails[2]] = "lt3";
		this.grid = new String[10][10];		
		
	}
	
	public void showBoard(Players players){
		int k = 0;
		for(int i=9;i>-1;i--){
			if(i%2==1){
			for(int j=0;j<10;j++){
				grid[i][j]=gridInList[k];
				for(int x=0;x<players.playersCount;x++){
					if(players.playersPostion[x]==k){
						grid[i][j] = "P"+String.valueOf(x+1)+grid[i][j];
					}
				}
				k++;
			}
			}else{
				for(int j=9;j>-1;j--){
					grid[i][j]=gridInList[k];
					for(int x=0;x<players.playersCount;x++){
						if(players.playersPostion[x]==k){
							grid[i][j] = "P"+String.valueOf(x+1)+grid[i][j];
						}
					}
					k++;
				}
			}
		}
		for(int i=0;i<10;i++){
			for(int j=0;j<10;j++){
				if(grid[i][j].length()>5){
					grid[i][j] = grid[i][j].substring(0, 5);
				}
				System.out.print(grid[i][j]);
				System.out.print(" ");
				if(grid[i][j].length()<5){
					int x = 0;
					while((grid[i][j].length()+x)!=5){
						System.out.print(" ");
						x++;
					}
				} 
			}
			System.out.println();
		}
	}
	
	public static int generateRandomNo(int maxNumber){
		Random rand = new Random();
		return rand.nextInt(maxNumber);
	}

	public void processMove(int[] playersPostion, int player, int move) {
		int initialPosition = (playersPostion[player]);
		int newPosition = initialPosition + move;
		if(initialPosition==-1&&(move!=1&&move!=6)){
			newPosition = initialPosition;
		}
		if(newPosition>99)newPosition = initialPosition;
		for(int i=0;i<3;i++){
			if(newPosition==snakeHeads[i]){
				newPosition=snakeTails[i];
				break;
			}else if(newPosition==ladderTails[i]){
				newPosition=ladderHeads[i];
			}
		}
		playersPostion[player] = (newPosition);
		
	}
}
