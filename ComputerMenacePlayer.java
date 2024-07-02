import java.util.LinkedList;
import java.util.Random;

public class ComputerMenacePlayer extends Player {

  private LinkedList<LinkedList<MenaceTicTacToeGame>> allGames;
  private LinkedList<TicTacToeGame> currentGameMoves;
  private LinkedList currentGameCells;

	public ComputerMenacePlayer(){
		super();

		allGames = new LinkedList<LinkedList<MenaceTicTacToeGame>>();
    currentGameMoves = new LinkedList<TicTacToeGame>();
    currentGameCells = new LinkedList();


		allGames.add(new LinkedList<MenaceTicTacToeGame>());
		allGames.get(0).add(new MenaceTicTacToeGame());


		for(int i=1; i<= 9; i++) {
			LinkedList<MenaceTicTacToeGame> newList;
			newList = new LinkedList<MenaceTicTacToeGame>();
			allGames.add(newList);
			for(MenaceTicTacToeGame game: allGames.get(i-1)){
				if(game.getGameState() == GameState.PLAYING) {
					for(int j = 0; j < 9; j++) {
						if(game.valueAt(j) == CellValue.EMPTY) {
							MenaceTicTacToeGame newGame = new MenaceTicTacToeGame(game,j);

							boolean isNew = true;
							for(MenaceTicTacToeGame existingGame: allGames.get(i)){
								if(newGame.equals(existingGame)){
									isNew = false;
									break;
								}
							}
							if(isNew) {
								newList.add(newGame);
							}
						}
					}
				}

			}
		}

	}
  public  void play(TicTacToeGame game) {

    if(game.getGameState() != GameState.PLAYING){
      throw new IllegalArgumentException();
    }
    for(MenaceTicTacToeGame y : allGames.get(game.getLevel())){
      if(y.equals(game)){
        currentGameMoves.add(y);
        break;
      }
    }

    for(MenaceTicTacToeGame x : allGames.get(game.getLevel())){
      if(x.equals(game)){
        boolean played = false;
        int y = new Random().nextInt(x.possibleNextMove.size());
        while(!played){
          int z = (int)x.possibleNextMove.get(y);
            try{
              game.play(z);
              played = true;
              currentGameCells.add(z);
            }
            catch(IllegalArgumentException e){
              System.out.println(game.toString());
              System.out.println(x.possibleNextMove.toString());
              throw new IllegalStateException();
            }
        }
      }
    }
  }

  public void gameFinished(GameState result){
    super.gameFinished(result);

    if(result==GameState.DRAW){
      currentGameMoves.clear();
      currentGameCells.clear();
    }
    else{
      for(int x = 0; x < currentGameMoves.size(); x++){
        for(MenaceTicTacToeGame y : allGames.get(currentGameMoves.get(x).getLevel())){

          if(currentGameMoves.get(x).equals(y)){

            if(result==GameState.XWIN){
              if(myMove == CellValue.X) {
        				y.possibleNextMove.add(currentGameCells.get(x));
                y.possibleNextMove.add(currentGameCells.get(x));
                y.possibleNextMove.add(currentGameCells.get(x));
        			}
              else {
                if(y.possibleNextMove.size()>1){
                  y.possibleNextMove.remove(currentGameCells.get(x));
                  if( x==currentGameMoves.size()-1){
                    while(y.possibleNextMove.size()>1 && y.possibleNextMove.contains(currentGameCells.get(x))){
                      y.possibleNextMove.remove(currentGameCells.get(x));
                    }
                  }
                }
        			}
            }
            if(result==GameState.OWIN){
              if(myMove == CellValue.O) {
        				y.possibleNextMove.add(currentGameCells.get(x));
                y.possibleNextMove.add(currentGameCells.get(x));
                y.possibleNextMove.add(currentGameCells.get(x));
        			}
              else {
                if(y.possibleNextMove.size()>1){
                  y.possibleNextMove.remove(currentGameCells.get(x));
                  if( x==currentGameMoves.size()-1){
                    while(y.possibleNextMove.size()>1 && y.possibleNextMove.contains(currentGameCells.get(x))){
                      y.possibleNextMove.remove(currentGameCells.get(x));
                    }
                  }
                }
        			}
            }


            break;

          }
        }
      }

      currentGameMoves.clear();
      currentGameCells.clear();
    }
  }
}
