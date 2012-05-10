package fr.miblack.chess.GUI;

import fr.miblack.chess.Echiquier;
import fr.miblack.chess.Partie;
import fr.miblack.chess.joueurs.JoueurAbstract;
import fr.miblack.chess.piece.Piece;

public class Interface
{
	protected  Partie maPartie;
	protected JoueurAbstract player1;
	protected JoueurAbstract player2;
	public Partie getMaPartie() 
	{
		return maPartie;
	}
	public Piece getPiecePosition(int x,int y)
	{
		return this.getMaPartie().getMyChessboard().getPiecePosition(x, y);
	}

	public Echiquier getMyChessboard()
	{
		return this.getMaPartie().getMyChessboard();
	}
}
