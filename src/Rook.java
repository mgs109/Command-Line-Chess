
/**
 * @author Michael Sabbagh 
 *
 */
public class Rook extends Pieces{
	boolean firstMove;
	public Rook(int color, int row, int column){
		super(color,  row,  column);
		this.firstMove = false;
	}

	
	public String toString(){
		if(color == 0){
			return "wR ";
		}else{return "bR ";}
	}
	
	public boolean validMove(int row, int column, int targetrow, int targetcolumn){
		if(Chess.whiteMove){
			if(Chess.gameBoard[row][column].color == 0 && Chess.gameBoard[row][column].toString().equals("wR ")){
				if(targetrow <= 7 && targetrow >=0 && targetcolumn >= 0 && targetcolumn <= 7){
					if((row == targetrow || column == targetcolumn) && !(row == targetrow && column == targetcolumn)){
						if(row != targetrow){
							
							if(row < targetrow){
								int i = row+1;
								while(i < targetrow){
									if(Chess.gameBoard[i][column].color == 1 ||Chess.gameBoard[i][column].color == 0){
										return false;
									}
									i++;
								}
								if(Chess.gameBoard[i][column].color != 0){
									return true;
								}
							}else{
								int i = row -1;
								while(i > targetrow){
									if(Chess.gameBoard[i][column].color == 1 || Chess.gameBoard[i][column].color == 0){
										return false;
									}
									i--;
								}
								if(Chess.gameBoard[i][column].color != 0){
									return true;
								}
								
							}
						}else{
							if(column < targetcolumn){
							int i = column+1;
							while(i < targetcolumn){
								if(Chess.gameBoard[row][i].color == 1 ||Chess.gameBoard[row][i].color == 0){
									return false;
								}
								i++;
							}
							if(Chess.gameBoard[row][i].color != 0){
								return true;
							}
							}else{
								int i = column -1;
								while(i > targetcolumn){
									if(Chess.gameBoard[row][i].color == 1 ||Chess.gameBoard[row][i].color == 0){
										return false;
									}
									i--;
								}
								if(Chess.gameBoard[row][i].color != 0){
									return true;
								}
								
							}
						}
					}
				}else{return false;}//else{System.out.println("Asking to move to invalid board location");return false;}
			}else{return false;}//else{System.out.println("Asking to move incorrect piece type.");return false;}
		}else{
			if(Chess.gameBoard[row][column].color == 1 && Chess.gameBoard[row][column].toString().equals("bR ")){
				if(targetrow <= 7 && targetrow >=0 && targetcolumn >= 0 && targetcolumn <= 7){
					if((row == targetrow || column == targetcolumn) && !(row == targetrow && column == targetcolumn)){
						if(row != targetrow){
							if(row < targetrow){
								int i = row+1;
								while(i < targetrow){
									if(Chess.gameBoard[i][column].color == 1 ||Chess.gameBoard[i][column].color == 0){
										return false;
									}
									i++;
								}
								if(Chess.gameBoard[i][column].color != 1){
									return true;
								}
							}else{
								int i = row -1;
								while(i > targetrow){
									if(Chess.gameBoard[i][column].color == 1 || Chess.gameBoard[i][column].color == 0){
										return false;
									}
									i--;
								}
								if(Chess.gameBoard[i][column].color != 1){
									return true;
								}
								
							}
						}else{
							if(column < targetcolumn){
							int i = column+1;
							while(i < targetcolumn){
								if(Chess.gameBoard[row][i].color == 1 ||Chess.gameBoard[row][i].color == 0){
									return false;
								}
								i++;
							}
							if(Chess.gameBoard[row][i].color != 1){
								return true;
							}
							}else{
								int i = column -1;
								while(i > targetcolumn){
									if(Chess.gameBoard[row][i].color == 1 ||Chess.gameBoard[row][i].color == 0){
										return false;
									}
									i--;
								}
								if(Chess.gameBoard[row][i].color != 1){
									return true;
								}
								
							}
						}
					}
				}else{return false;}//else{System.out.println("Asking to move to invalid board location");return false;}
			}else{return false;}//else{System.out.println("Asking to move incorrect piece type.");return false;}
			
		}
		return false;
	}
	public void movePiece(int row, int column, int targetrow, int targetcolumn){
		Pieces tempPiece = new Pieces(-1000, row, column);
		Rook tempPiece2 =(Rook) Chess.gameBoard[row][column];
		tempPiece2.firstMove = true;
		Chess.gameBoard[targetrow][targetcolumn] = Chess.gameBoard[row][column];
		Chess.gameBoard[row][column] =  tempPiece;
	}
}
