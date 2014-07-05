public class SnakeNLadderGame {
    private final int playersCount;
    private Board board;
    private Player[] players;
    private Player currentPlayer = null;

    public SnakeNLadderGame(int playersCount) {
        this.playersCount = playersCount;
    }

    public void play() {

        init();
        board.showBoard(players);

        while (!gameCompleted()) {
            this.currentPlayer = this.getNextPLayer();
            //todo : some duplicate code with the else block , can we extract into may be, takeTurn() method ?
            int numberThrown = Dice.roll();
            board.processMove(currentPlayer, numberThrown);
            if (currentPlayer.userGameCompleted()) {
                System.out.println(currentPlayer.getName() +" : game completed!!");
                break;
            }
            else {
                while (numberThrown == 1 || numberThrown == 6) {
                    numberThrown = Dice.roll();
                    board.processMove(currentPlayer, numberThrown);
                    if (currentPlayer.userGameCompleted()) {
                        System.out.println(currentPlayer.getName() +" : game completed!!");
                        break;
                    }
                }
            }
            if (gameCompleted()) {
                System.out.println("Game completed!!!");
                break;
            }
        }
        board.showBoard(players);
    }

    private Player getNextPLayer() {
        int currentPlayerIndex = 0;
        while (players[currentPlayerIndex] != currentPlayer)
            currentPlayerIndex++;
        int nextPlayerIndex = (currentPlayerIndex + 1) % playersCount;
        while (!players[nextPlayerIndex].isStillPlaying() && nextPlayerIndex != currentPlayerIndex) {
            nextPlayerIndex = (nextPlayerIndex + 1) % playersCount;
        }
        return players[nextPlayerIndex];
    }

    public void init() {
        players = new Player[playersCount];
        this.board = new Board();
        for (int i = 0; i < playersCount; i++) {
            final String playerName = "Player " +String.valueOf(i);
            players[i] = new Player(){{
                setName("Player "+ String.valueOf(playerName));
            }};
        }
        currentPlayer = players[0];
    }


    public boolean gameCompleted() {
        for(Player player: players){
            if(player.getStatus() != PlayerStatus.Completed)
                return false;
        }
        return true;
    }
}
