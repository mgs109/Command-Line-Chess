/**
 * @author Michael Sabbagh
 *
 */
public class Queen extends Pieces{
		public Queen(int color, int row, int column){
			super(color, row, column);
		}
		public String toString(){
			if(color == 0){
				return "wQ ";
			}else{return "bQ ";}
		}
		
		public boolean validMove(int row, int column, int targetRow, int targetColumn){
			if(Chess.whiteMove){	
				if(Chess.gameBoard[row][column].color == 0 && Chess.gameBoard[row][column].toString().equals("wQ ")) {
					if(targetRow <= 7 && targetRow >=0 && targetColumn >= 0 && targetColumn <= 7){
						if((row == targetRow || column == targetColumn) && !(row == targetRow && column == targetColumn)){
							if(row != targetRow){
								
								if(row < targetRow){
									int i = row+1;
									while(i < targetRow){
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
									while(i > targetRow){
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
								if(column < targetColumn){
								int i = column+1;
								while(i < targetColumn){
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
									while(i > targetColumn){
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
						
						if((Math.abs(row - targetRow) == Math.abs(column - targetColumn))){

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
					}
						
						
					}else{return false;}//else{System.out.println("Asking to move to invalid board location");return false;}
					
				}else{return false;}//else{System.out.println("Asking to move incorrect piece type");return false;}
			}else{
				if(Chess.gameBoard[row][column].color == 1 && Chess.gameBoard[row][column].toString().equals("bQ ")) {
					if(targetRow <= 7 && targetRow >=0 && targetColumn >= 0 && targetColumn <= 7){
						if((row == targetRow || column == targetColumn) && !(row == targetRow && column == targetColumn)){
							if(row != targetRow){
								
								if(row < targetRow){
									int i = row+1;
									while(i < targetRow){
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
									while(i > targetRow){
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
								if(column < targetColumn){
								int i = column+1;
								while(i < targetColumn){
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
									while(i > targetColumn){
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
						
						if((Math.abs(row - targetRow) == Math.abs(column - targetColumn))){

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