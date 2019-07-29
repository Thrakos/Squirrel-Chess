import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Pawn extends Piece {

	private boolean hasMoved;

	public Pawn(Position pos, Board b, boolean isWhite) {
		super(pos, b, isWhite);
		hasMoved = false;
	}

	@Override
	public ArrayList<Position> getMoveSet() {
		ArrayList<Position> ret = new ArrayList<Position>();
		if (isWhite) {
			if (!hasMoved) {
				ret.add(new Position(pos.getRow() - 1, pos.getCol()));
				ret.add(new Position(pos.getRow() - 2, pos.getCol()));
			} else {
				ret.add(new Position(pos.getRow() - 1, pos.getCol()));
				if ((b.getPieceAtPos(new Position(pos.getRow() - 1, pos.getCol() + 1)) != null) && pos.getCol() != 7)
					ret.add(new Position(pos.getRow() - 1, pos.getCol() + 1));
				if ((b.getPieceAtPos(new Position(pos.getRow() - 1, pos.getCol() - 1)) != null) && pos.getCol() != 0)
					ret.add(new Position(pos.getRow() - 1, pos.getCol() - 1));
			}
		} else {
			if (!hasMoved) {
				ret.add(new Position(pos.getRow() + 1, pos.getCol()));
				ret.add(new Position(pos.getRow() + 2, pos.getCol()));
			} else {
				ret.add(new Position(pos.getRow() + 1, pos.getCol()));
				if ((b.getPieceAtPos(new Position(pos.getRow() + 1, pos.getCol() + 1)) != null) && pos.getCol() != 7)
					ret.add(new Position(pos.getRow() + 1, pos.getCol() + 1));
				if ((b.getPieceAtPos(new Position(pos.getRow() + 1, pos.getCol() - 1)) != null) && pos.getCol() != 0)
					ret.add(new Position(pos.getRow() + 1, pos.getCol() - 1));
			}
		}
		return removeInvalidMoves(ret);
	}

	@Override
	public void move(Position pos) {
		super.move(pos);
		hasMoved = true;
		if (isWhite) {
			if (pos.getRow() == 0)
				promoMenu();
		} else {
			if (pos.getRow() == 7)
				promoMenu();
		}
	}

	@Override
	public void draw() {

	}

	public String toString() {
		return super.toString() + "Pawn";
	}

	private void promoMenu() {
		b.removePiece(this);
		String[] options = { "Bishop", "Knight", "Queen", "Rook" };
		int option = JOptionPane.showOptionDialog(null, "Choose the piece to promote to", "Pawn Promotion", 0, 0, null,
				options, null);
		Piece p;
		switch (option) {
		case 0:
			p = new Bishop(pos, b, isWhite);
			break;
		case 1:
			p = new Knight(pos, b, isWhite);
			break;
		case 2:
			p = new Queen(pos, b, isWhite);
			break;
		default:
			p = new Rook(pos, b, isWhite);
			break;
		}
		b.addPiece(p);
		b.updateText();
	}
}
