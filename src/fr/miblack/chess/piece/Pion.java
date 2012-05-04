package fr.miblack.chess.piece;
import java.util.*;

import fr.miblack.chess.Position;
import fr.miblack.chess.Echiquier;
import fr.miblack.chess.color.Couleur;
public class Pion extends Piece
{

	public Pion(Couleur color,Position pos,int valeur)
	{
		super(color,pos,valeur);
	}

	public LinkedList<Position> positionAccessibleCouleur(int couleur)
	{
		LinkedList<Position> myList=new LinkedList<Position>() ;
		int mult=1;
		if(couleur==0)
		{
			mult=-1;
		}
		for(Position onePos : Position.listPosit()  )
		{
			if(onePos.getX()== getX() &&(onePos.getY()== (getY()+(1*mult))))
			{
				myList.add(onePos);
			}
		}
		if(this.asPlayed==0)
		{
			myList.add(Position.getPosition( getX(), getY()+(2*mult)));
		}
		return myList;

	}
	public  LinkedList<Position> positionAccessible()
	{
		LinkedList<Position> myList=positionAccessibleCouleur(color.getColor());
		return myList;
	}

	public LinkedList<Position> positionAccessibleChessboard(Echiquier chess)
	{
		LinkedList<Position> myList=positionAccessible() ;
		for(Position onePos :positionAccessible())
		{
			if((chess.getPiecePosition(onePos)!=null)) 
			{
				myList.remove(onePos);
			}
			
		}
		myList.addAll(whatCanIEat(chess));
		return myList;
	}

	public LinkedList<Position> whatCanIEat(Echiquier chess)
	{
		LinkedList<Position> myList=new LinkedList<Position>() ;
		Couleur maCouleur=this.getColor();
		int mult=1;
		if(maCouleur.getColor()==0)
		{
			mult=-1;
		}
	    if((this.getX()+1)<=7)
		 {
			 if(chess.getPiecePosition(this.getX()+1,this.getY()+(1*mult))!=null)
			 {
				if(!verifColor(chess,this.getX()+1,this.getY()+(1*mult)) )
				{
					if(!(chess.getPiecePosition(this.getX()+1,this.getY()+(1*mult) ) instanceof Roi))
					 myList.add(Position.getPosition(this.getX()+1,this.getY()+(1*mult)));
				}
			 }
		 }
		 if((this.getX()-1)>=0)
		 {
			 if(chess.getPiecePosition(this.getX()-1,this.getY()+(1*mult))!=null)
			 {
				if(!verifColor(chess,this.getX()-1,this.getY()+(1*mult)))
				{
					if(!(chess.getPiecePosition(this.getX()-1,this.getY()+(1*mult) ) instanceof Roi))
					 myList.add(Position.getPosition(this.getX()-1,this.getY()+(1*mult)));
				}
			 }
		 }
		return myList;
	}

	@Override
	public String toString()
	{
		if(this.color.getColor()==1)
			return "P";
		//return "♟";
		else
			return "p";
		//return "♙";
	}
	
	public String getNom()
	{
		return "";
	}

	
}