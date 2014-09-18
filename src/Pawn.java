
/**
 * @author Michael Sabbagh
 *
 */
public class Pawn extends Pieces{
	
	boolean firstMove;
	
	public Pawn(int color, int row, int column){
		super(color, row, column);
		this.firstMove = false;
	}
	
	public String toString(){
		if(color == 0){
			return "wp ";
		}else{
			return "bp ";}
	}
	
	public boolean validMove(int row, int column, int targetRow, int targetColumn){
		//if white players turn
		if(Chess.whiteMove){
			//if it is the correct piece
			if(Chess.gameBoard[row][column].color == 0 && Chess.gameBoard[row][column].toString().equals("wp ")) {
			//if it is the pawn's first time moving
			if(getFirstMove((Pawn) Chess.gameBoard[row][column]) == false){
				if(targetColumn == column){
					if(row - targetRow == 1 && Chess.gameBoard[row-1][column].color != 0){
						return true;
					}
					if(row - targetRow == 2 && Chess.gameBoard[row-1][column].color != 0 && Chess.gameBoard[row-2][column].color != 0){
						return true;
				}
			}
			
		}
			//if it is not the pawn's first time moving and it is not attacking
			if(targetRow <= 7 && targetRow >=0 && targetColumn >= 0 && targetColumn <= 7){
				if(column == targetColumn){
					if(Chess.gameBoard[row][column].color == 0){
						if(targetRow - row < 0 && Chess.gameBoard[targetRow][targetColumn].color != 0 
								&& Chess.gameBoard[targetRow][targetColumn].color != 1 && targetRow - row == -1){
							return true;
						}
					}
				}
				//if the pawn is attacking
		  if(Chess.gameBoard[row][column].color == 0){
			  if(Math.abs(targetRow - row) ==1 && Math.abs(targetColumn - column) ==1){
				  if(Chess.gameBoard[targetRow][targetColumn].color == 1){
					  return true;
				  }
			  }
		  }
		  //en passant
		  if(row == 3 && targetRow == 2){
			  if(Math.abs(column - targetColumn) == 1){
				  if(Chess.gameBoard[row][targetColumn].toString().equals("bp ")){
					  return true;
				  }
			  }
		  }
		
			
			
			}else{return false;}//System.out.println("Asking to move to invalid board location");return false;}
			
		
		
		
		}else{return false;}//System.out.println("Asking to move incorrect piece type.");return false;}
			return false;
		}else{
			if(Chess.gameBoard[row][column].color == 1 && Chess.gameBoard[row][column].toString().equals("bp ")) {
			
				if(getFirstMove((Pawn) Chess.gameBoard[row][column]) == false){
					if(Chess.gameBoard[row][column].color == 1 && targetColumn == column){
						if(targetRow - row == 1 && Chess.gameBoard[row+1][column].color != 1){
							return true;
					}
						if(targetRow - row == 2 && Chess.gameBoard[row+1][column].color != 1 && Chess.gameBoard[row+2][column].color != 1){
							return true;
					}
				}
			}
			
		
				
				if(targetRow <= 7 && targetRow >=0 && targetColumn >= 0 && targetColumn <= 7){
					if(column == targetColumn){
						if(Chess.gameBoard[row][column].color == 1){
							if(targetRow - row >0 && Chess.gameBoard[targetRow][targetColumn].color != 1 
									&& Chess.gameBoard[targetRow][targetColumn].color != 0 && targetRow - row == 1){
								return true;
							}
						}
					}
			  if(Chess.gameBoard[row][column].color == 1){
				  if(Math.abs(targetRow - row) == 1 && Math.abs(targetColumn - column) ==1){
					  if(Chess.gameBoard[targetRow][targetColumn].color == 0){
						  return true;
					  }
				  }
			  }
			  
			  //en passant
			  if(row == 4 && targetRow == 5){
				  if(Math.abs(column - targetColumn) == 1){
					  if(Chess.gameBoard[row][targetColumn].toString().equals("wp ")){
						  return true;
					  }
				  }
			  }
				
				
				}else{return false;}//System.out.println("Asking to move to invalid board location");return false;}
				
			
			
			
			}else{return false;}//System.out.println("Asking to move incorrect piece type.");return false;}
			return false;		

		}
	}
	
	public boolean getFirstMove(Pawn pawn1){
		return pawn1.firstMove;
	}
	public void movePiece(int row, int column, int targetrow, int targetcolumn){
		Pieces tempPiece = new Pieces(-1000, row, column);
		Pawn tempPiece2 =(Pawn) Chess.gameBoard[row][column];
		tempPiece2.firstMove = true;
		Chess.gameBoard[targetrow][targetcolumn] = Chess.gameBoard[row][column];
		Chess.gameBoard[row][column] =  tempPiece;
	}
	public void queenPromo(int row, int column, int targetrow, int targetcolumn){
		Pieces tempPiece = new Pieces(-1000, row, column);
		Pawn tempPiece2 =(Pawn) Chess.gameBoard[row][column];
		Pieces tempPiece3 = new Queen(tempPiece2.color, targetrow, targetcolumn);
		Chess.gameBoard[targetrow][targetcolumn] = tempPiece3;
		Chess.gameBoard[row][column] =  tempPiece;
	}
	public void rookPromo(int row, int column, int targetrow, int targetcolumn){
		Pieces tempPiece = new Pieces(-1000, row, column);
		Pawn tempPiece2 =(Pawn) Chess.gameBoard[row][column];
		Pieces tempPiece3 = new Rook(tempPiece2.color, targetrow, targetcolumn);
		Chess.gameBoard[targetrow][targetcolumn] = tempPiece3;
		Chess.gameBoard[row][column] =  tempPiece;
	}
	public void bishopPromo(int row, int column, int targetrow, int targetcolumn){
		Pieces tempPiece = new Pieces(-1000, row, column);
		Pawn tempPiece2 =(Pawn) Chess.gameBoard[row][column];
		Pieces tempPiece3 = new Bishop(tempPiece2.color, targetrow, targetcolumn);
		Chess.gameBoard[targetrow][targetcolumn] = tempPiece3;
		Chess.gameBoard[row][column] =  tempPiece;
	}
	public void knightPromo(int row, int column, int targetrow, int targetcolumn){
		Pieces tempPiece = new Pieces(-1000, row, column);
		Pawn tempPiece2 =(Pawn) Chess.gameBoard[row][column];
		Pieces tempPiece3 = new Knight(tempPiece2.color, targetrow, targetcolumn);
		Chess.gameBoard[targetrow][targetcolumn] = tempPiece3;
		Chess.gameBoard[row][column] =  tempPiece;
	}
	public void moveEnpassant(int row, int column, int targetrow, int targetcolumn){
		Pieces tempPiece = new Pieces(-1000, row, column);
		Pawn tempPiece2 =(Pawn) Chess.gameBoard[row][column];
		Chess.gameBoard[targetrow][targetcolumn] = Chess.gameBoard[row][column];
		Chess.gameBoard[row][column] =  tempPiece;
		Chess.gameBoard[row][targetcolumn] = tempPiece;
	}

}
