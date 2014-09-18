
	/**
	 * @author Michael Sabbagh
	 *
	 */
	public class Bishop extends Pieces{
		public Bishop(int color, int row, int column){
			super(color, row, column);
		}
		
		public String toString(){
			if(color == 0){
				return "wB ";
			}else{return "bB ";}
		}
		
		public boolean validMove(int row, int column, int targetRow, int targetColumn){
			if(Chess.whiteMove){	
				if(Chess.gameBoard[row][column].color == 0 && Chess.gameBoard[row][column].toString().equals("wB ")) {
					if(targetRow <= 7 && targetRow >=0 && targetColumn >= 0 && targetColumn <= 7){
						if(row == targetRow || column == targetColumn){
							return false;
						}
						if((Math.abs(row - targetRow) != Math.abs(column - targetColumn))){
							return false;
						}
						if(row > targetRow && column > targetColumn){
							int i = row-1,  j = column-1;
							while(i > targetRow && j > targetColumn){
								if(Chess.gameBoard[i][j].color == 1 || Chess.gameBoard[i][j].color == 0){
									return false;
								}
								i--;
								j--;
							}
							if(Chess.gameBoard[i][j].color != 0){
								return true;
							}
						}
						if(row > targetRow && column < targetColumn){
							int i = row-1,  j = column+1;
							while(i > targetRow && j < targetColumn){
								if(Chess.gameBoard[i][j].color == 1 || Chess.gameBoard[i][j].color == 0){
									return false;
								}
								i--;
								j++;
							}
							if(Chess.gameBoard[i][j].color != 0){
								return true;
							}
						}
						if(row < targetRow && column > targetColumn){
							int i = row+1,  j = column-1;
							while(i < targetRow && j > targetColumn){
								if(Chess.gameBoard[i][j].color == 1 || Chess.gameBoard[i][j].color == 0){
									return false;
								}
								i++;
								j--;
							}
							if(Chess.gameBoard[i][j].color != 0){
								return true;
							}
						}
						if(row < targetRow && column < targetColumn){
							int i = row+1,  j = column+1;
							while(i < targetRow && j < targetColumn){
								if(Chess.gameBoard[i][j].color == 1 || Chess.gameBoard[i][j].color == 0){
									return false;
								}
								i++;
								j++;
							}
							if(Chess.gameBoard[i][j].color != 0){
								return true;
							}
						}
						
						
					}else{return false;}//else{System.out.println("Asking to move to invalid board location");return false;}
					
				}else{return false;}//else{System.out.println("Asking to move incorrect piece type");return false;}
			}else{
				
				if(Chess.gameBoard[row][column].color == 1 && Chess.gameBoard[row][column].toString().equals("bB ")) {
					if(targetRow <= 7 && targetRow >=0 && targetColumn >= 0 && targetColumn <= 7){
						if(row == targetRow || column == targetColumn){
							return false;
						}
						if((Math.abs(row - targetRow) != Math.abs(column - targetColumn))){
							return false;
						}
						if(row > targetRow && column > targetColumn){
							int i = row-1,  j = column-1;
							while(i > targetRow && j > targetColumn){
								if(Chess.gameBoard[i][j].color == 1 || Chess.gameBoard[i][j].color == 0){
									return false;
								}
								i--;
								j--;
							}
							if(Chess.gameBoard[i][j].color != 1){
								return true;
							}
						}
						if(row > targetRow && column < targetColumn){
							int i = row-1,  j = column+1;
							while(i > targetRow && j < targetColumn){
								if(Chess.gameBoard[i][j].color == 1 || Chess.gameBoard[i][j].color == 0){
									return false;
								}
								i--;
								j++;
							}
							if(Chess.gameBoard[i][j].color != 1){
								return true;
							}
						}
						if(row < targetRow && column > targetColumn){
							int i = row+1,  j = column-1;
							while(i < targetRow && j > targetColumn){
								if(Chess.gameBoard[i][j].color == 1 || Chess.gameBoard[i][j].color == 0){
									return false;
								}
								i++;
								j--;
							}
							if(Chess.gameBoard[i][j].color != 1){
								return true;
							}
						}
						if(row < targetRow && column < targetColumn){
							int i = row+1,  j = column+1;
							while(i < targetRow && j < targetColumn){
								if(Chess.gameBoard[i][j].color == 1 || Chess.gameBoard[i][j].color == 0){
									return false;
								}
								i++;
								j++;
							}
							if(Chess.gameBoard[i][j].color != 1){
								return true;
							}
						}
						
						
					}else{return false;}//else{System.out.println("Asking to move to invalid board location");return false;}
					
				}else{return false;}//else{System.out.println("Asking to move incorrect piece type");return false;}
				
				
			}
			return false;
		}
		
		public void movePiece(int row, int column, int targetrow, int targetcolumn){
			Pieces tempPiece = new Pieces(-1000, row, column);
			Chess.gameBoard[targetrow][targetcolumn] = Chess.gameBoard[row][column];
			Chess.gameBoard[row][column] =  tempPiece;
		}
	}