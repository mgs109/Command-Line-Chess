

	/**
	 * @author Michael Sabbagh
	 *
	 */
	public class Knight extends Pieces{
		public Knight(int color, int row, int column){
			super(color,  row,  column);
		}
		
		public String toString(){
			if(color == 0){
				return "wN ";
			}else{return "bN ";}
		}
		public boolean validMove(int row, int column, int targetRow, int targetColumn){
			if(Chess.whiteMove){
				if(Chess.gameBoard[row][column].color == 0 && Chess.gameBoard[row][column].toString().equals("wN ")){
					if(targetRow <= 7 && targetRow >=0 && targetColumn >= 0 && targetColumn <= 7){
						if(Math.abs(row - targetRow) == 2 && Math.abs(column - targetColumn) == 1
								&& Chess.gameBoard[targetRow][targetColumn].color != 0){
							return true;
						}
						if(Math.abs(row - targetRow) == 1 && Math.abs(column - targetColumn) == 2
								&& Chess.gameBoard[targetRow][targetColumn].color != 0){
							return true;
						}
						return false;

					}else{return false;}//else{System.out.println("Asking to move to invalid board location");return false;}
				}else{return false;}//else{System.out.println("Asking to move incorrect piece type.");return false;}
			}else{
				if(Chess.gameBoard[row][column].color == 1 && Chess.gameBoard[row][column].toString().equals("bN ")){
					if(targetRow <= 7 && targetRow >=0 && targetColumn >= 0 && targetColumn <= 7){
						if(Math.abs(row - targetRow) == 2 && Math.abs(column - targetColumn) == 1
								&& Chess.gameBoard[targetRow][targetColumn].color != 1){
							return true;
						}
						if(Math.abs(row - targetRow) == 1 && Math.abs(column - targetColumn) == 2
								&& Chess.gameBoard[targetRow][targetColumn].color != 1){
							return true;
						}
						return false;

					}else{return false;}//else{System.out.println("Asking to move to invalid board location");return false;}
				}else{return false;}//else{System.out.println("Asking to move incorrect piece type.");return false;}
				
				
			}

	}	
		public void movePiece(int row, int column, int targetrow, int targetcolumn){
			Pieces tempPiece = new Pieces(-1000, row, column);
			Chess.gameBoard[targetrow][targetcolumn] = Chess.gameBoard[row][column];
			Chess.gameBoard[row][column] =  tempPiece;
		}
	}
