import java.util.ArrayList;

/**
 * Main
 */
public class Main {

    static int counter = 0;

    public static void main(String[] args) {
        Board board = new Board(true);
        UserInterface ui = new UserInterface();
        ArrayList<Integer> x = new ArrayList<>();
        ArrayList<Integer> y = new ArrayList<>();

        while(!board.hasWon("X")){
            if(board.hasWon("O")){
                break;
            }
            String s = ui.askForInput();
            
            while(s.length() < 1){
                s = ui.askForInput();
            }
            
            x.add(Integer.parseInt(s.substring(0, 1)));
            y.add(Integer.parseInt(s.substring(1, 2)));

            board.addSymbol(x.get(counter), y.get(counter));
            board.updateBoard();
            board.aiPlay();
            board.updateBoard();

            counter++;
        }

        if(board.hasWon("X")){
            System.out.println("Congratulations, you have won");
        } else if(board.hasWon("O")){
            System.out.println("AI has won, better luck next time");
        }
        
        
        
    }
}