
	/**
	 * @author Michael Sabbagh
	 *
	 */
	public class King extends Pieces{
		
		boolean firstMove;
		
		public King(int color, int row, int column){
			super(color, row, column);
			this.firstMove = false;
		}
		
		public String toString(){
			if(color == 0){
				return "wK ";
			}else{return "bK ";}
		}
		public boolean validMove(int row, int column, int targetRow, int targetColumn){
			//if white player's turn
			if(Chess.whiteMove){	
				//if piece to be moven is the white king
				if(Chess.gameBoard[row][column].color == 0 && Chess.gameBoard[row][column].toString().equals("wK ")) {
					//if destination is on game board
					if(targetRow <= 7 && targetRow >=0 && targetColumn >= 0 && targetColumn <= 7){
						King tempKing = (King) Chess.gameBoard[row][column];
						//if king has not been moved
						if(tempKing.firstMove == false){
							//if attempting to castle
							if((targetColumn > column && targetColumn == column+2) &&  (row == targetRow)){
								Rook tempRook = (Rook) Chess.gameBoard[row][column+3];
								//if 
							if(Chess.gameBoard[row][column+1].color != 0 && Chess.gameBoard[row][column+1].color != 1
									&& Chess.gameBoard[row][column+2].color != 0 && Chess.gameBoard[row][column+2].color != 1
									&& Chess.gameBoard[row][column+3].color == 0 && 
									Chess.gameBoard[row][column+3].toString().equals("wR ")){
								if(tempRook.firstMove == false){
									return true;
								}
							}
						}else{
							if( (row == targetRow)){
							Rook tempRook = (Rook) Chess.gameBoard[row][column-4];

							if(Chess.gameBoard[row][column-1].color != 0 && Chess.gameBoard[row][column-1].color != 1
									&& Chess.gameBoard[row][column-2].color != 0 && Chess.gameBoard[row][column-2].color != 1
									&& Chess.gameBoard[row][column-3].color != 0 && Chess.gameBoard[row][column-3].color != 1
									&& Chess.gameBoard[row][column-4].color == 0 && Chess.gameBoard[row][column-4].toString().equals("wR ")
									&& targetColumn == column - 2){
								if(tempRook.firstMove == false){
									return true;
								}
							}
							}
						}
						}
						if((Math.abs(targetRow - row) + Math.abs(targetColumn - column)) <= 2){
							if(Math.abs(targetRow - row) < 2 && Math.abs(targetColumn - column) < 2){
								if(Chess.gameBoard[targetRow][targetColumn].color != Chess.gameBoard[row][column].color){
									return true;
								}else{return false;}//else{System.out.println("Asking to move onto friendly piece");return false;}
							}else{return false;}//else{System.out.println("Invalid move");return false;}
						}else{return false;}//else{System.out.println("Invalid move");return false;}
				
				
					}else{return false;}//else{System.out.println("Asking to move to invalid board location");return false;}
			
			
			
			}else{return false;}//else{System.out.println("Asking to move incorrect piece type.");return false;}
			}else{
				if(Chess.gameBoard[row][column].color == 1 && Chess.gameBoard[row][column].toString().equals("bK ")) {
					
					if(targetRow <= 7 && targetRow >=0 && targetColumn >= 0 && targetColumn <= 7){
						King tempKing = (King) Chess.gameBoard[row][column];

						if(tempKing.firstMove == false){
							if((targetColumn > column && targetColumn == column+2) && (row == targetRow)){
								if(Chess.gameBoard[row][column-4].toString().equals("bR ")){
								Rook tempRook = (Rook) Chess.gameBoard[row][column+3];
							if(Chess.gameBoard[row][column+1].color != 0 && Chess.gameBoard[row][column+1].color != 1
									&& Chess.gameBoard[row][column+2].color != 0 && Chess.gameBoard[row][column+2].color != 1
									&& Chess.gameBoard[row][column+3].color == 1 && 
									Chess.gameBoard[row][column+3].toString().equals("bR ")){
								if(tempRook.firstMove == false){
									return true;
								}
							}
							}
						}else{
							 if (row == targetRow){
							if(Chess.gameBoard[row][column-4].toString().equals("bR ")){
							Rook tempRook = (Rook) Chess.gameBoard[row][column-4];

							if(Chess.gameBoard[row][column-1].color != 0 && Chess.gameBoard[row][column-1].color != 1
									&& Chess.gameBoard[row][column-2].color != 0 && Chess.gameBoard[row][column-2].color != 1
									&& Chess.gameBoard[row][column-3].color != 0 && Chess.gameBoard[row][column-3].color != 1
									&& Chess.gameBoard[row][column-4].color == 1 && Chess.gameBoard[row][column-4].toString().equals("bR ")
									&& targetColumn == column - 2){
								if(tempRook.firstMove == false){
									return true;
								}
							}
						}
						}
						}
						}
					
						if((Math.abs(targetRow - row) + Math.abs(targetColumn - column)) <= 2){
							if(Math.abs(targetRow - row) < 2 && Math.abs(targetColumn - column) < 2){
								if(Chess.gameBoard[targetRow][targetColumn].color != Chess.gameBoard[row][column].color){
									return true;
								}else{return false;}//else{System.out.println("Asking to move onto friendly piece");return false;}
							}else{return false;}//else{System.out.println("Invalid move");return false;}
						}else{return false;}//else{System.out.println("Invalid move");return false;}
					
					
					}else{return false;}//else{System.out.println("Asking to move to invalid board location");return false;}
				
				
				
				}else{return false;}//else{System.out.println("Asking to move incorrect piece type.");return false;}
				
			}
			
		}
		public boolean checkMove(int row, int column, int targetRow, int targetColumn){
			//if white player's turn
			if(Chess.whiteMove || !Chess.whiteMove){	
				//if piece to be moven is the white king
				if(Chess.gameBoard[row][column].color == 0 && Chess.gameBoard[row][column].toString().equals("wK ")) {
					//if destination is on game board
					if(targetRow <= 7 && targetRow >=0 && targetColumn >= 0 && targetColumn <= 7){
						King tempKing = (King) Chess.gameBoard[row][column];
						//if king has not been moved
						if(tempKing.firstMove == false){
							//if attempting to castle
							if((targetColumn > column && targetColumn == column+2) &&  (row == targetRow)){
								Rook tempRook = (Rook) Chess.gameBoard[row][column+3];
								//if 
							if(Chess.gameBoard[row][column+1].color != 0 && Chess.gameBoard[row][column+1].color != 1
									&& Chess.gameBoard[row][column+2].color != 0 && Chess.gameBoard[row][column+2].color != 1
									&& Chess.gameBoard[row][column+3].color == 0 && 
									Chess.gameBoard[row][column+3].toString().equals("wR ")){
								if(tempRook.firstMove == false){
									return true;
								}
							}
						}else{
							if( (row == targetRow)){
							Rook tempRook = (Rook) Chess.gameBoard[row][column-4];

							if(Chess.gameBoard[row][column-1].color != 0 && Chess.gameBoard[row][column-1].color != 1
									&& Chess.gameBoard[row][column-2].color != 0 && Chess.gameBoard[row][column-2].color != 1
									&& Chess.gameBoard[row][column-3].color != 0 && Chess.gameBoard[row][column-3].color != 1
									&& Chess.gameBoard[row][column-4].color == 0 && Chess.gameBoard[row][column-4].toString().equals("wR ")
									&& targetColumn == column - 2){
								if(tempRook.firstMove == false){
									return true;
								}
							}
							}
						}
						}
						if((Math.abs(targetRow - row) + Math.abs(targetColumn - column)) <= 2){
							if(Math.abs(targetRow - row) < 2 && Math.abs(targetColumn - column) < 2){
								if(Chess.gameBoard[targetRow][targetColumn].color != Chess.gameBoard[row][column].color){
									return true;
								}else{return false;}//else{System.out.println("Asking to move onto friendly piece");return false;}
							}else{return false;}//else{System.out.println("Invalid move");return false;}
						}else{return false;}//else{System.out.println("Invalid move");return false;}
				
				
					}else{return false;}//else{System.out.println("Asking to move to invalid board location");return false;}
			
			
			
			}else{//else{System.out.println("Asking to move incorrect piece type.");return false;}
			
				if(Chess.gameBoard[row][column].color == 1 && Chess.gameBoard[row][column].toString().equals("bK ")) {
					
					if(targetRow <= 7 && targetRow >=0 && targetColumn >= 0 && targetColumn <= 7){
						King tempKing = (King) Chess.gameBoard[row][column];

						if(tempKing.firstMove == false){
							if((targetColumn > column && targetColumn == column+2) && (row == targetRow)){
								if(Chess.gameBoard[row][column-4].toString().equals("bR ")){
								Rook tempRook = (Rook) Chess.gameBoard[row][column+3];
							if(Chess.gameBoard[row][column+1].color != 0 && Chess.gameBoard[row][column+1].color != 1
									&& Chess.gameBoard[row][column+2].color != 0 && Chess.gameBoard[row][column+2].color != 1
									&& Chess.gameBoard[row][column+3].color == 1 && 
									Chess.gameBoard[row][column+3].toString().equals("bR ")){
								if(tempRook.firstMove == false){
									return true;
								}
							}
							}
						}else{
							 if (row == targetRow){
							if(Chess.gameBoard[row][column-4].toString().equals("bR ")){
							Rook tempRook = (Rook) Chess.gameBoard[row][column-4];

							if(Chess.gameBoard[row][column-1].color != 0 && Chess.gameBoard[row][column-1].color != 1
									&& Chess.gameBoard[row][column-2].color != 0 && Chess.gameBoard[row][column-2].color != 1
									&& Chess.gameBoard[row][column-3].color != 0 && Chess.gameBoard[row][column-3].color != 1
									&& Chess.gameBoard[row][column-4].color == 1 && Chess.gameBoard[row][column-4].toString().equals("bR ")
									&& targetColumn == column - 2){
								if(tempRook.firstMove == false){
									return true;
								}
							}
						}
						}
						}
						}
					
						if((Math.abs(targetRow - row) + Math.abs(targetColumn - column)) <= 2){
							if(Math.abs(targetRow - row) < 2 && Math.abs(targetColumn - column) < 2){
								if(Chess.gameBoard[targetRow][targetColumn].color != Chess.gameBoard[row][column].color){
									return true;
								}else{return false;}//else{System.out.println("Asking to move onto friendly piece");return false;}
							}else{return false;}//else{System.out.println("Invalid move");return false;}
						}else{return false;}//else{System.out.println("Invalid move");return false;}
					
					
					}else{return false;}//else{System.out.println("Asking to move to invalid board location");return false;}
				
				
				
				}else{return false;}//else{System.out.println("Asking to move incorrect piece type.");return false;}
				
			
			}
		}
			return false;
		}
		public void movePiece(int row, int column, int targetrow, int targetcolumn){
			Pieces tempPiece = new Pieces(-1000, row, column);
			King tempPiece2 =(King) Chess.gameBoard[row][column];
			tempPiece2.firstMove = true;
			Chess.gameBoard[targetrow][targetcolumn] = Chess.gameBoard[row][column];
			Chess.gameBoard[row][column] =  tempPiece;
		}
		
		
	}
	
