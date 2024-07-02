import java.util.LinkedList;
public class MenaceTicTacToeGame extends TicTacToeGame {

	private LinkedList<MenaceTicTacToeGame> moves;
	public LinkedList possibleNextMove;

	public MenaceTicTacToeGame(){
		super(3,3,3);
		moves =
		possibleNextMove = new LinkedList();
		for(int i=0; i<9; i++){
			possibleNextMove.add(1);
			possibleNextMove.add(2);
			possibleNextMove.add(3);
			possibleNextMove.add(4);
			possibleNextMove.add(5);
			possibleNextMove.add(6);
			possibleNextMove.add(7);
			possibleNextMove.add(8);
			possibleNextMove.add(0);
		}
	}

	public boolean equals(TicTacToeGame o) {
		for(int i = 0; i < 9 ; i++ ) {
			if(this.valueAt(i)!= o.valueAt(i)) {
				return false;
		}
		}
		return true;
	}


	public MenaceTicTacToeGame(MenaceTicTacToeGame base, int next){
		super(base,next);
		this.possibleNextMove = new LinkedList();
		if(base.getLevel()==0){
			for(int i=0; i<9; i++){
				for(int j=0; j<9; j++){
					if(this.valueAt(j)==CellValue.EMPTY){
						possibleNextMove.add(j);
					}
				}
			}
		}
		else if(base.getLevel()==1||base.getLevel()==2){
			for(int i=0; i<4; i++){
				for(int j=0; j<9; j++){
					if(this.valueAt(j)==CellValue.EMPTY){
						possibleNextMove.add(j);
					}
				}
			}
		}
		else if(base.getLevel()==3||base.getLevel()==4){
			for(int i=0; i<4; i++){
				for(int j=0; j<9; j++){
					if(this.valueAt(j)==CellValue.EMPTY){
						possibleNextMove.add(j);
					}
				}
			}
		}
		else if(base.getLevel()==5||base.getLevel()==6||base.getLevel()==7){
			for(int i=0; i<4; i++){
				for(int j=0; j<9; j++){
					if(this.valueAt(j)==CellValue.EMPTY){
						possibleNextMove.add(j);
					}
				}
			}
		}
		else if(base.getLevel()==8){
			possibleNextMove.add(null);
		}
		else{
			System.out.println(base.getLevel()==0); //////////////////////
			System.out.println(base.getLevel());///////////////////////////
			throw new IllegalStateException();
		}
	}









}
