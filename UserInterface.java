import java.util.Scanner;


public class UserInterface {
    Scanner termialReader;
    Boolean accepted = false;
    Board board;

    public UserInterface(){
        initilize();
        board = new Board(false);
    }

    public void initilize(){
        termialReader = new Scanner(System.in);
    }

    public String askForInput(){
        System.out.println("Where would you like to place your symbol <x y>: ");
        accepted = false;
        while(!accepted){
            try {
                String returnValue = termialReader.nextLine();

                if(returnValue.length() < 3 || returnValue.length() > 3 || !returnValue.contains(" ")){
                    throw new NumberFormatException();
                }

                if(Integer.parseInt(returnValue.substring(0, 1)) > 3 || Integer.parseInt(returnValue.substring(2, 3)) > 3){
                    if(Integer.parseInt(returnValue.substring(0, 1)) < 0 || Integer.parseInt(returnValue.substring(2, 3)) < 0){
                        throw new NumberFormatException();
                    }

                    throw new NumberFormatException();
                }
                
                int x = Integer.parseInt(returnValue.substring(0, 1));
                int y = Integer.parseInt(returnValue.substring(2, 3));

                if(board.isOccupied(x, y)){
                    throw new NumberFormatException();
                }

                accepted = true;

                int returnArray[][] = new int[1][2];
                returnArray[0][0] = Integer.parseInt(returnValue.substring(0, 1));
                returnArray[0][1] = Integer.parseInt(returnValue.substring(2, 3));

                return returnValue.substring(0, 1) + returnValue.substring(2, 3);
            } catch (Exception e) {
                System.out.println("Please enter a valid number, with x, a space, and then y, and make sure you don't enter a box that already has a symbol in it");
            }
        }
        return null;
    }

    public int[][] convertToValue(String initialVal){
        int[][] returnVal = new int[1][0];
        returnVal[0][0] = Integer.parseInt(initialVal, 0, 2, 10);
        System.out.println(returnVal[0][0]);
        returnVal[1][0] = Integer.parseInt(initialVal, 3, 3, 10);
        System.out.println(returnVal[3][3]);
        return returnVal;

    }
}
