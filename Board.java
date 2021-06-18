import java.util.concurrent.ThreadLocalRandom;

public class Board {

    static String board[][];
    boolean hasCreated = false;

    public Board(boolean create){
        if(create){
            initilize();
            createGrid();
        }
    }

    public void initilize(){
        board = new String[3][3];
        hasCreated = true;
    }

    public void createGrid(){
        for(int i = 0; i < 3; i++){
            System.out.println("{_}{_}{_}");
        }
    }

    public void updateBoard(){
        System.out.print("\033[H\033[2J");
        for(int i = 0; i < 3; i++){
            for(int s = 0; s < 3; s++){
                if(board[s][i] == null){
                    System.out.print("{_}");
                    continue;
                }
                System.out.print(" " + board[s][i] + " ");
            }
            System.out.println("");
        }
    }

    public void addSymbol(int x, int y){
        board[x - 1][y - 1] = "X";
    }

    public void aiPlay(){
        int randomX = ThreadLocalRandom.current().nextInt(1, 3 + 1);
        int randomY = ThreadLocalRandom.current().nextInt(1, 3 + 1);

        while(isOccupied(randomX, randomY)){
            randomX = ThreadLocalRandom.current().nextInt(1, 3 + 1);
            randomY = ThreadLocalRandom.current().nextInt(1, 3 + 1);
        }
        
        board[randomX - 1][randomY - 1] = "O";

    }

    public boolean isOccupied(int x, int y){
        try{
            if(board[x-1][y-1] == "X" || board[x-1][y-1] == "O"){
                return true;
            } else {
                return false;
            }
        } catch(Exception e){
            return false;
        }
    }

    public boolean hasWon(String symbol){
        if(board[0][0] == symbol && board[0][1] == symbol && board[0][2] == symbol){
            return true;
        } else if(board[1][0] == symbol && board[1][1] == symbol && board[1][2] == symbol){
            return true;
        } else if(board[2][0] == symbol && board[2][1] == symbol && board[2][2] == symbol){
            return true;
        } else if(board[0][0] == symbol && board[1][0] == symbol && board[2][0] == symbol){
            return true;
        } else if(board[0][1] == symbol && board[1][1] == symbol && board[2][1] == symbol){
            return true;
        } else if(board[0][2] == symbol && board[1][2] == symbol && board[2][2] == symbol){
            return true;
        } else if(board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol){
            return true;
        } else if(board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol){
            return true;
        } else {
            return false;
        }
    }

}
