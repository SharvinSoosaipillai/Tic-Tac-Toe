//importing modules to use for random and user input

import java.util.Random;
import java.util.ArrayList;

class randomCPU{
  private ArrayList<Integer> possibleMoves = new ArrayList<Integer>();
  public void initializeCPUMoves(){
    for (int i = 0; i <9; i++){
      possibleMoves.add(i + 1);
    }


  

    // int index = 0;
    // while (index < possibleMoves.size()){
    //   System.out.println(possibleMoves.get(index));
    //   index++;
    // }

  }

  public void removePosition(int move){
    possibleMoves.remove(possibleMoves.indexOf(move));


  }

  public int randomCPUMove(){
    Random randomNumber = new Random();

    int number = randomNumber.nextInt(possibleMoves.size());
    // System.out.println(possibleMoves.size());
    int CPUMove = possibleMoves.get(number);

    return CPUMove;

  }

}