import java.util.Scanner;


public class TikTacToe{
    public static void main(String[] args) {
        System.out.println("Welcome to tik tac toe! The rules of this game are simple, \t\t 1 | 2 | 3 ");
        System.out.println("\t\t\t\t\t\t\t\t\t - + - + - ");
        
        System.out.println("The rules are simple, get 3 in a row first before your opponent \t 4 | 5 | 6 ");
        System.out.println(" \t\t\t\t\t\t\t\t\t - + - + - ");
        System.out.println("Today your opponent will be the computer, lets get started :)\t\t 7 | 8 | 9 \n\n");

        Scanner scan = new Scanner(System.in);
        


        System.out.println("Get three in a row, coloum or diaganal to win! lets get started");
        




        char [][] board = new char[][]{ {' ' , '|' , ' ', '|' , ' '}, 
                                        {'-' , '+' , '-', '+' , '-' }, 
                                        {' ' , '|' , ' ', '|' , ' '} , 
                                        {'-' , '+' , '-', '+' , '-' } , 
                                        {' ' , '|' , ' ', '|' , ' '}};

        
        


        
        boolean gameloop = true;
        randomCPU opponent = new randomCPU();
        opponent.initializeCPUMoves();
        char playerChar = 'X', cpuCharacter = 'O';
        int move, count = 0; 
        boolean playerturn = true, won = false;
        while (gameloop){
            

            
            if (playerturn){

                boolean playerMoveAllowed;
                for (int i = 0; i < board.length; i++){
                    
                    for (int x = 0; x < board[i].length; x++){
                        System.out.print(board[i][x]);
                    }

                    System.out.print("\n");
                }
                
                System.out.println("Which square would you like to place your move? ");
                move = scan.nextInt();
                if (move < 1 || move > 9){
                    
                    System.out.println("Invalid Input, try again. ");
                
                } else {

                    playerMoveAllowed = checkMove(move, playerChar, cpuCharacter, board);

                    won = winner(playerChar, board);
                    if (won){
                        for (int i = 0; i < board.length; i++){
                    
                            for (int x = 0; x < board[i].length; x++){
                                System.out.print(board[i][x]);
                            }
    
                            System.out.print("\n");
                        }
                        System.out.println("Congrats you won! :)");
                        gameloop = false;
                    }else if (playerMoveAllowed == false){
                        System.out.println("Invalid move");
                    } else {
                        count++;
                        if (count == 9){
                            System.out.println("It was a draw");
                            for (int i = 0; i < board.length; i++){
                    
                                for (int x = 0; x < board[i].length; x++){
                                    System.out.print(board[i][x]);
                                }
        
                                System.out.print("\n");
                            }
                            gameloop = false;
                        }
                        opponent.removePosition(move);
                        playerturn = false;
                        
                    }  

                }

                System.out.println("-----------------------");

            } else {


                while (true){
                    int cpuMove = opponent.randomCPUMove();       
                    System.out.println(cpuMove);            
                    boolean CPUMoveAllowed = checkMove(cpuMove, cpuCharacter,playerChar, board);
                    if (CPUMoveAllowed){
                        opponent.removePosition(cpuMove);
                        break;
                        
                    }
                }

                won = winner(cpuCharacter, board);
                if (won){
                    
                    for (int i = 0; i < board.length; i++){
                    
                        for (int x = 0; x < board[i].length; x++){
                            System.out.print(board[i][x]);
                        }

                        System.out.print("\n");
                    }

                    System.out.println("The Computer won!!");
                    gameloop = false;
                } else {
                    count++;
                    if (count == 9){
                        System.out.println("It was a draw");
                        for (int i = 0; i < board.length; i++){
                    
                            for (int x = 0; x < board[i].length; x++){
                                System.out.print(board[i][x]);
                            }
    
                            System.out.print("\n");
                        }
                        gameloop = false;
                    }    
                    System.out.println("The computer made its move");
                
                }

                System.out.println("-----------------------");
                playerturn = true;
            }             
                

                

        } 

    
    


    scan.close();
    }

    public static boolean checkMove(int playerMove, char playerCharacter,char otherPlayerCharacter, char board[][]){
        boolean moveAllowed = true;
        switch (playerMove){
            case 1:
                if (board[0][0] == playerCharacter || board[0][0] == otherPlayerCharacter){
                  moveAllowed = false;  
                } else {
                    board[0][0] = playerCharacter;

                }
                break;

            case 2:
                if (board[0][2] == playerCharacter || board[0][2] == otherPlayerCharacter){
                    moveAllowed = false;  
                } else {
                    board[0][2] = playerCharacter;
                }
                break;   

            case 3:
                if (board[0][4] == playerCharacter || board[0][4] == otherPlayerCharacter ){
                    moveAllowed = false;  
                } else {
                    board[0][4] = playerCharacter;
                }
                break;

            case 4:
                if (board[2][0] == playerCharacter || board[2][0] == otherPlayerCharacter){
                    moveAllowed = false;  
                } else {
                    board[2][0] = playerCharacter;
                }
                break;    

            case 5:
                if (board[2][2] == playerCharacter || board[2][2] == otherPlayerCharacter){
                    moveAllowed = false;  
                } else {
                    board[2][2] = playerCharacter;
                }
                break;

            case 6:
                if (board[2][4] == playerCharacter || board[2][4] == otherPlayerCharacter){
                    moveAllowed = false;  
                } else {
                    board[2][4] = playerCharacter;
                }
                break;

            case 7:
                if (board[4][0] == playerCharacter || board[4][0] == otherPlayerCharacter){
                    moveAllowed = false;  
                } else {
                    board[4][0] = playerCharacter;
                }
                break;

            case 8:
                if (board[4][2] == playerCharacter || board[4][2] == otherPlayerCharacter){
                    moveAllowed = false;  
                } else {
                    board[4][2] = playerCharacter;
                }
                break;

            case 9:
                if (board[4][4] == playerCharacter || board[4][4] == otherPlayerCharacter){
                    moveAllowed = false;  
                } else {
                    board[4][4] = playerCharacter;
                }
                break;

        }
        return moveAllowed;
    }

    public static boolean winner(char character, char[][]board){
        boolean winner = false;
        int count = 0;

        //checks for rows
        for (int i = 0; i < 5; i+= 2){
            for (int x = 0; x < 5; x+= 2){
                if (board[i][x] == character){
                    count++;
                }        


                if (count == 3){
                    winner = true;
                    break;
                }
            }
            if (winner){
                break;
            }
            count = 0;
        }

        count = 0;
        for (int i = 0; i < 5; i+= 2){
            for (int x = 0; x < 5; x+= 2){
                if (board[x][i] == character){
                    count++;
                }        


                if (count == 3){
                    winner = true;
                    break;
                }
            }
            if (winner){
                break;
            }
            count = 0;
        }

        if (board[0][0] == character && board[2][2] == character && board[4][4] == character){
            winner = true;
        } else if (board[4][0] == character && board[2][2] == character && board[0][4] == character){
            winner = true;
        }

        return winner;
    }

}
