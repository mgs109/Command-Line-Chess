import java.text.*;
import java.util.*;
import java.io.*;


/**
 * @author Michael Sabbagh
 *
 */
public class Chess {
	public static Pieces [] [] gameBoard = new  Pieces [9][9];

	//initializes the chess board
	public  static void makeBoard(){
		//initializes the letters at the bottom of the board.
		for(int i = 0; i < 9; i++){
			Pieces piece1 = new Pieces(100 + i, 8, i);
			gameBoard[8][i] = piece1;
			
		}
		//initializes the numbers to the right of the board.
		for(int i = 0; i < 9; i++){
			Pieces piece1 = new Pieces(200 + i,i,8);
			gameBoard[i][8] = piece1;
			
		}
		//initializes "  " and "##"
		for(int i = 2; i < 6; i++){
			if(i%2 == 0){
				for(int j = 0; j < 7; j++){
				
					Pieces piece1 = new Pieces(-200,i,j);
					gameBoard[i][j] = piece1;
					if(j == 7)break;
					Pieces piece2 = new Pieces(-100,i,j);
					gameBoard[i][j+1] = piece2;
					j++;
					}
			
				}else{
					
					for(int j = 0; j < 7; j++){
						
						Pieces piece1 = new Pieces(-100,i,j);
						gameBoard[i][j] = piece1;
						if(j == 7)break;
						Pieces piece2 = new Pieces(-200,i,j);
						gameBoard[i][j+1] = piece2;
						j++;
						}
					
				}
		
		}
		//initializes pawns
			for(int j = 0; j < 8; j++){
				Pieces piece1 = new Pawn(1, 1, j);
				gameBoard[1][j] = piece1;
				Pieces piece2 = new Pawn(0, 6, j);
				gameBoard[6][j] = piece2;
			
		}
			//player pieces
			Pieces piece1 = new Rook(1, 0, 7);
			gameBoard[0][7] = piece1;
			Pieces piece2 = new Rook(1, 0, 0);
			gameBoard[0][0] = piece2;
			Pieces piece3 = new Knight(1, 0, 1);
			gameBoard[0][1] = piece3;
			Pieces piece4 = new Knight(1, 0, 6);
			gameBoard[0][6] = piece4;
			Pieces piece5 = new Bishop(1, 0, 2);
			gameBoard[0][2] = piece5;
			Pieces piece6 = new Bishop(1, 0, 5);
			gameBoard[0][5] = piece6;
			Pieces piece7 = new King(1, 0, 4);
			gameBoard[0][4] = piece7;
			Pieces piece8 = new Queen(1, 0, 3);
			gameBoard[0][3] = piece8;
			Pieces piece9 = new Rook(0, 7, 7);
			gameBoard[7][7] = piece9;
			Pieces piece10 = new Rook(0, 7, 0);
			gameBoard[7][0] = piece10;
			Pieces piece11 = new Knight(0, 7, 1);
			gameBoard[7][1] = piece11;
			Pieces piece12 = new Knight(0, 7, 6);
			gameBoard[7][6] = piece12;
			Pieces piece13 = new Bishop(0, 7, 2);
			gameBoard[7][2] = piece13;
			Pieces piece14 = new Bishop(0, 7, 5);
			gameBoard[7][5] = piece14;
			Pieces piece15 = new King(0, 7, 4);
			gameBoard[7][4] = piece15;
			Pieces piece16 = new Queen(0, 7, 3);
			gameBoard[7][3] = piece16;

	}
	//fills the ## and "   " pieces after each move
	public static void fillBoard(){
		for( int i = 0; i< 	8; i++) {
			for(int j = 0; j < 8; j++){
				if(i%2 == j%2 && gameBoard[i][j].color != 1 && gameBoard[i][j].color != 0){
					Pieces tempPiece = new Pieces(-200, i, j);
					gameBoard[i][j] = tempPiece;
					
				}else if(i%2 != j%2 && gameBoard[i][j].color != 1 && gameBoard[i][j].color != 0){
					Pieces tempPiece = new Pieces(-100, i, j);
					gameBoard[i][j] = tempPiece;
				}
			       	
			      }
	      }
		
	}
	//prints the board after each turn
	public  static void printBoard(){

		for( int i = 0; i< 	9; i++) {
			for(int j = 0; j < 9; j++){
				if(j == 8 && i ==8){
					return;
			    	  }
			       	System.out.print(gameBoard[i][j].toString());
			      }
			    System.out.println();
	      }
	    
	 
}
	
	public static boolean  whiteMove = true, draw = false;
	
	public static void main(String args[]){
	
		
		makeBoard();
		printBoard();

		
		Scanner in = new Scanner(System.in);
		
		String in2 = "";
		
		while(!in2.equals("stop")){ 
			
			String inputs = "";
			int checkRow = -1, checkColumn = -1;
			boolean move = false, blackCheck = false, whiteCheck = false, queenPromo = false, knightPromo = false, bishopPromo = false, rookPromo = false, moved = false;
			if(whiteMove){
				System.out.print("\n\nWhite's Move: " );
			}else{ 
				System.out.print("\n\nBlack's Move: " );

			}
			in2 = in.nextLine();
			
			if(in2.equals("resign")){
				if(whiteMove){
					System.out.println("\n\nWhite resigns,\nBlack wins!");
				}else{
					System.out.println("\n\nBlack resigns,\nWhite wins!");

				}
				return;
			}
			if(in2.contains("draw?")){
				draw = true;
				in2 = in2.replace("draw?", "");
			}
			if(draw){
				if(in2.equals("draw")){
					System.out.println("\n\nTie game!");
					return;
				}
			}
			int strlen = in2.length();
			
			if(in2.charAt(strlen-1) == 'N'){
				knightPromo = true;
				
				
			}
			if(in2.charAt(strlen-1)== 'R'){
				rookPromo = true;
				
			}
			if(in2.charAt(strlen-1)== 'Q'){
				queenPromo = true;
				
			}
			if(in2.charAt(strlen-1)== 'B'){
				bishopPromo = true;
			
			}
			if(bishopPromo || rookPromo  || queenPromo || knightPromo){
				in2 = in2.substring(0, strlen-1);

			}
	
				
			inputs = parseInput(in2);
			if(inputs.length() != 4 || inputs.equals("")){
				System.out.println("Illegal move, try again.");
				continue;
			}
			int row1, column1, row2, column2, kingrow1 = -1, kingrow2 = -1, kingcolumn1 = -1, kingcolumn2 = -1;
			
			row1 = Integer.parseInt(inputs.substring(0, 1));
			column1 = Integer.parseInt(inputs.substring(1, 2));
			row2 = Integer.parseInt(inputs.substring(2, 3));
			column2 = Integer.parseInt(inputs.substring(3, 4));
			
			
			move = gameBoard[row1][column1].validMove(row1, column1, row2, column2);

			if(move){
				if(queenPromo){
					if(gameBoard[row1][column1].toString().equals("wp ")||gameBoard[row1][column1].toString().equals("bp ")){
						Pawn tempPawn = (Pawn)gameBoard[row1][column1];
						tempPawn.queenPromo(row1, column1, row2, column2);
						moved = true;
					}
					
				}
				if(rookPromo){
					if(gameBoard[row1][column1].toString().equals("wp ")||gameBoard[row1][column1].toString().equals("bp ")){
						Pawn tempPawn = (Pawn)gameBoard[row1][column1];
						tempPawn.rookPromo(row1, column1, row2, column2);
						moved =true;
					}
				}
				if(knightPromo){
					if(gameBoard[row1][column1].toString().equals("wp ")|| gameBoard[row1][column1].toString().equals("bp ")){
						Pawn tempPawn = (Pawn)gameBoard[row1][column1];
						tempPawn.knightPromo(row1, column1, row2, column2);
						moved =true;

					}
				}
				if(bishopPromo){
					if(gameBoard[row1][column1].toString().equals("wp ")||gameBoard[row1][column1].toString().equals("bp ")){
						Pawn tempPawn = (Pawn)gameBoard[row1][column1];
						tempPawn.bishopPromo(row1, column1, row2, column2);
						moved =true;

					}
				}
				//checks if enpassant
				  if(row1 == 4 && row2 == 5){
					  if(Math.abs(column1 - column2) == 1){
						  if(Chess.gameBoard[row1][column2].toString().equals("wp ")){
							  if(gameBoard[row1][column1].toString().equals("bp ")){
							  Pawn tempPawn = (Pawn)gameBoard[row1][column1];
							  tempPawn.moveEnpassant(row1, column1, row2, column2);
							  }
						  }
					  }
				  }
				  if(row1 == 3 && row2 == 2){
					  if(Math.abs(column1 - column2) == 1){
						  if(Chess.gameBoard[row1][column2].toString().equals("bp ")){
							  if(gameBoard[row1][column1].toString().equals("wp ")){
							  Pawn tempPawn = (Pawn)gameBoard[row1][column1];
							  tempPawn.moveEnpassant(row1, column1, row2, column2);
							  }
						  }
					  }
				  }
				
				
				 //checks if player is trying to castle white king
				if(row1 == 7 && row2 == 7 ){
					if(column1 == 4 && column2 == 6 && gameBoard[row1][column1].toString().equals("wK ")){
						King tempKing = (King) Chess.gameBoard[row1][column1];
						if(tempKing.firstMove == false){
							gameBoard[row1][column1 +3].movePiece(row1, column1+3, row1, column2-1);
						}
					}
					if(column1 == 4 && column2 == 2){
						King tempKing = (King) Chess.gameBoard[row1][column1];
						if(tempKing.firstMove == false){
							gameBoard[row1][column1 - 4].movePiece(row1, column1-4, row1, column2+1);
						}
					}
				}
				
				//checks if player is trying to castle black king
				if(row1 == 0 && row2 == 0 ){
					if(column1 == 4 && column2 == 6 && gameBoard[row1][column1].toString().equals("bK ")){
						King tempKing = (King) Chess.gameBoard[row1][column1];
						if(tempKing.firstMove == false){
							gameBoard[row1][column1 +3].movePiece(row1, column1+3, row1, column2-1);
						}
					}
					if(column1 == 4 && column2 == 2){
						King tempKing = (King) Chess.gameBoard[row1][column1];
						if(tempKing.firstMove == false){
							gameBoard[row1][column1 - 4].movePiece(row1, column1-4, row1, column2+1);
						}
					}
				}
				if(!moved && (gameBoard[row1][column1].toString().equals("wp "))){
					if(row2 == 0){
						Pawn tempPawn = (Pawn)gameBoard[row1][column1];
						tempPawn.queenPromo(row1, column1, row2, column2);
						moved = true;
						
					}
				}
				if(!moved && (gameBoard[row1][column1].toString().equals("bp "))){
					if(row2 == 7){
						Pawn tempPawn = (Pawn)gameBoard[row1][column1];
						tempPawn.queenPromo(row1, column1, row2, column2);
						moved = true;
						
					}
				}
				
				//moves the piece
				if(!moved){
				gameBoard[row1][column1].movePiece(row1, column1, row2, column2);
				}
				
				//gets coordinates of both kings
				for( int i = 0; i< 	8; i++) {
					for(int j = 0; j < 8; j++){
						if(gameBoard[i][j].toString().equals("wK ")){
							kingrow1 = i;
							kingcolumn1 = j;
						}
						if(gameBoard[i][j].toString().equals("bK ")){
							kingrow2 = i;
							kingcolumn2 = j;
						}
							
					}
				}
				//checks if either king is in check
				for( int i = 0; i< 	8; i++) {
					for(int j = 0; j < 8; j++){
						if(!blackCheck){
							blackCheck = gameBoard[i][j].validMove(i, j, kingrow2, kingcolumn2);
							
						
						}
						if(!whiteCheck){
							whiteCheck = gameBoard[i][j].validMove(i, j, kingrow1, kingcolumn1);
						
						}
					}
				}
				//if white check and the king can't move, black wins
				if(whiteCheck){
					if(!canKingMove(kingrow1, kingcolumn1)){
						fillBoard();
						System.out.println();
						printBoard();
						System.out.println("\n\nCheckmate\nBlack wins!");
						return;
					}
				}
				
				//if black king is in check and can't move. white wins
				if(blackCheck){
					if(!canKingMove(kingrow2, kingcolumn2)){
						fillBoard();
						System.out.println();
						printBoard();
						System.out.println("\n\nCheckmate\nWhite wins!");
						return;
					}
				}
		
				fillBoard();
				if(whiteMove){
					whiteMove = false;
				}else{
					whiteMove = true;
					}
		}else{
			System.out.println("Illegal move, try again.");
			continue;
			}
			
			System.out.println();
			printBoard();
			if(blackCheck || whiteCheck){
				System.out.print("\n\nCheck");
				
			}
		} 
	
		
}
	//returns row1 column1 row2 column2 in a string
	public static String parseInput(String input){
		String inputs = "";
		input = input.trim();
		
		StringTokenizer st = new StringTokenizer(input, " ");
		
		if(st.countTokens() != 2){
		//	System.out.println("Invalid input, try again.");
			return inputs;
		}
		
		String firstinput = st.nextToken();
		String secondinput = st.nextToken();
		if(firstinput.length() != 2 || secondinput.length() != 2){
			return inputs;
		}
		
		String firstColumn, firstRow, secondColumn, secondRow;
		int row1, row2;
		
		if(firstinput.length() != 2 && secondinput.length() != 2){
			//System.out.println("Invalid input, try again.");
			return inputs;
		}
		firstColumn = parseColumn(firstinput.substring(0, 1));
		secondColumn = parseColumn(secondinput.substring(0, 1));
		
		if(firstColumn.isEmpty() || secondColumn.isEmpty()){
			return inputs;
		}
		
		firstRow = firstinput.substring(1,2);
		
		try{
		row1 = Integer.parseInt(firstRow);
		}catch(Exception e){return "";}
		
		row1 = 8-row1;
		firstRow = "" + row1;
		
		secondRow = secondinput.substring(1,2);
		try{
		row2 = Integer.parseInt(secondRow);
		
		}catch(Exception e){return "";}
		
		row2 = 8-row2;
		secondRow = "" + row2;
		
		inputs += firstRow;
		inputs += firstColumn;
		inputs += secondRow;
		inputs += secondColumn;

		return inputs;
	}
	//turns the column input ie. a, b, etc. into the corresponding array value
	public static String parseColumn(String input){
		String inputs = input, returnString = "";
		
		if(inputs.equals("a")){
			returnString = "0";
		}
		if(inputs.equals("b")){
			returnString = "1";

		}
		if(inputs.equals("c")){
			returnString = "2";

		}
		if(inputs.equals("d")){
			returnString = "3";

		}
		if(inputs.equals("e")){
			returnString = "4";

		}
		if(inputs.equals("f")){
			returnString = "5";

		}
		if(inputs.equals("g")){
			returnString = "6";

		}
		if(inputs.equals("h")){
			returnString = "7";

		}
		return returnString;
	}
	//returns true if a piece can check the king
	public static boolean canCheckKing(int row, int column){
		boolean check = false;
		for( int i = 0; i< 	8; i++) {
			for(int j = 0; j < 8; j++){
				if(!check){
				check = gameBoard[i][j].validMove(i, j, row, column);
				
				}
			}
		}
		return check;
	}
	
	public static boolean canKillCheck(int row, int column){
		
		if(whiteMove){
			for(int i = 0; i < 8; i++){
				for(int j = 0; j < 8; j++){
					if(gameBoard[i][j].validMove(i, j, row, column)){
						
					}
				}
			}
			
		}else{
			
		}
		return false;
	}
	//returns true if there is a move the king can make
	public static boolean canKingMove(int row, int column){
		if(gameBoard[row][column].toString().equals("wK ") || gameBoard[row][column].toString().equals("bK ")){
			King tempKing = (King) gameBoard[row][column];
			//checks if king is in one of the corners
			if(row == 7 && column == 7){
				if(!canCheckKing(6,7) && tempKing.checkMove(row, column, 6, 7)){
					return true;
				}
				if(!canCheckKing(7,6)&& tempKing.checkMove(row, column, 7, 6)){
					return true;
				}
				if(!canCheckKing(6,6)&& tempKing.checkMove(row, column, 6, 6)){
					return true;
				}
				return false;
			}
			if(row == 7 && column == 0){
				if(!canCheckKing(6,0)&& tempKing.checkMove(row, column, 6, 0)){
					return true;
				}
				if(!canCheckKing(6,1)&& tempKing.checkMove(row, column, 6, 1)){
					return true;
				}
				if(!canCheckKing(7,1)&& tempKing.checkMove(row, column, 7, 1)){
					return true;
				}
				return false;
				
			}
			if(row == 0 && column == 7){
				if(!canCheckKing(0,6)&& tempKing.checkMove(row, column, 0, 6)){
					return true;
				}
				if(!canCheckKing(1,6)&& tempKing.checkMove(row, column, 1, 6)){
					return true;
				}
				if(!canCheckKing(1,7)&& tempKing.checkMove(row, column, 1, 7)){
					return true;
				}
				return false;
				
			}
			if(row == 0 && column == 0){
				if(!canCheckKing(1,1)&& tempKing.checkMove(row, column, 1, 1)){
					return true;
				}
				if(!canCheckKing(0,1)&& tempKing.checkMove(row, column, 0, 1)){
					return true;
				}
				if(!canCheckKing(1,0)&& tempKing.checkMove(row, column, 1, 0)){
					return true;
				}
				return false;
				
			}
			//if the king is on an edge
			if(row == 0){
				if(!canCheckKing(row, column-1)&& tempKing.checkMove(row, column, row, column-1)){
					return true;
				}
				if(!canCheckKing(row, column+1)&& tempKing.checkMove(row, column,row, column+1)){
					return true;
				}
				if(!canCheckKing(row+1, column-1)&& tempKing.checkMove(row, column,row+1, column-1)){
					return true;
				}
				if(!canCheckKing(row+1, column) && tempKing.checkMove(row, column,row+1, column)){
					return true;
				}
				if(!canCheckKing(row+1, column+1)&& tempKing.checkMove(row, column,row+1, column+1)){
					return true;
				}
				return false;
			}
			if(row == 7){
				if(!canCheckKing(row, column-1)&& tempKing.checkMove(row, column,row, column-1)){
					return true;
				}
				if(!canCheckKing(row, column+1)&& tempKing.checkMove(row, column,row, column+1)){
					return true;
				}
				if(!canCheckKing(row-1, column-1)&& tempKing.checkMove(row, column,row-1, column-1)){
					return true;
				}
				if(!canCheckKing(row-1, column)&& tempKing.checkMove(row, column,row-1, column)){
					return true;
				}
				if(!canCheckKing(row-1, column+1)&& tempKing.checkMove(row, column,row-1, column+1)){
					return true;
				}
				return false;
			}
			if(column == 0){
				if(!canCheckKing(row+1, column+1)&& tempKing.checkMove(row, column,row+1, column+1)){
					return true;
				}
				if(!canCheckKing(row, column+1)&& tempKing.checkMove(row, column,row, column+1)){
					return true;
				}
				if(!canCheckKing(row+1, column)&& tempKing.checkMove(row, column,row+1, column)){
					return true;
				}
				if(!canCheckKing(row-1, column)&& tempKing.checkMove(row, column,row-1, column)){
					return true;
				}
				if(!canCheckKing(row-1, column+1)&& tempKing.checkMove(row, column,row-1, column+1)){
					return true;
				}
				return false;
			}
			if(column == 7){
				if(!canCheckKing(row-1, column-1)&& tempKing.checkMove(row, column,row-1, column-1)){
					return true;
				}
				if(!canCheckKing(row, column-1)&& tempKing.checkMove(row, column,row, column-1)){
					return true;
				}
				if(!canCheckKing(row+1, column)&& tempKing.checkMove(row, column,row+1, column)){
					return true;
				}
				if(!canCheckKing(row-1, column)&& tempKing.checkMove(row, column,row-1, column)){
					return true;
				}
				if(!canCheckKing(row+1, column-1)&& tempKing.checkMove(row, column,row+1, column-1)){
					return true;
				}
				return false;
			}
			
			
				if(!canCheckKing(row+1, column+1)&& tempKing.checkMove(row, column,row+1, column+1)){
					return true;
				}
				if(!canCheckKing(row+1, column)&& tempKing.checkMove(row, column,row+1, column)){
					return true;
				}
				if(!canCheckKing(row+1, column-1)&& tempKing.checkMove(row, column,row+1, column-1)){
					return true;
				}
				if(!canCheckKing(row-1, column)&& tempKing.checkMove(row, column,row-1, column)){
					return true;
				}
				if(!canCheckKing(row-1, column+1)&& tempKing.checkMove(row, column,row-1, column+1)){
					return true;
				}
				
				if(!canCheckKing(row-1, column-1)&& tempKing.checkMove(row, column,row-1, column-1)){
						return true;
					}
				if(!canCheckKing(row, column+1)&& tempKing.checkMove(row, column,row, column+1)){
						return true;
					}
			
				if(!canCheckKing(row, column-1)&& tempKing.checkMove(row, column,row, column-1)){
						return true;
					}
				if(!canCheckKing(row-1, column+1)&& tempKing.checkMove(row, column,row-1, column+1)){
						return true;
					}
				
			
			
			
		}
		return false;
	}


}
