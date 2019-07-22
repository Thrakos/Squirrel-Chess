import java.util.ArrayList;

public class Bishop extends Piece {

	public Bishop(Position pos, Board b, boolean isWhite) {
		super(pos, b, isWhite);
	}

	@Override
	public ArrayList<Position> getMoveSet() {
		ArrayList<Position> ret = new ArrayList<Position>();

		boolean A = true;
		boolean B = true;
		boolean C = true;
		boolean D = true;

		for (int i = 1; (((pos.getRow() + i) < 8) && ((pos.getCol() + i) < 8) && A); i++)
			if (b.getPieceAtPos(new Position(pos.getRow() + i, pos.getCol() + i)) == null) {
				ret.add(new Position(pos.getRow() + i, pos.getCol() + i));
			} else {
				A = false;
				if (b.getPieceAtPos(new Position(pos.getRow() + i, pos.getCol() + i)).isWhite != super.isWhite) {
					ret.add(new Position(pos.getRow() + i, pos.getCol() + i));
				}
			}
		for (int i = 1; (((pos.getRow() + i) < 8) && ((pos.getCol() - i) >= 0) && B); i++)
			if (b.getPieceAtPos(new Position(pos.getRow() + i, pos.getCol() - i)) == null) {
				ret.add(new Position(pos.getRow() + i, pos.getCol() - i));
			} else {
				B = false;
				if (b.getPieceAtPos(new Position(pos.getRow() + i, pos.getCol() - i)).isWhite != super.isWhite) {
					ret.add(new Position(pos.getRow() + i, pos.getCol() - i));
				}
			}
		for (int i = 1; (((pos.getRow() - i) >= 0) && ((pos.getCol() + i) < 8) && C); i++)
			if (b.getPieceAtPos(new Position(pos.getRow() - i, pos.getCol() + i)) == null) {
				ret.add(new Position(pos.getRow() - i, pos.getCol() + i));
			} else {
				C = false;
				if (b.getPieceAtPos(new Position(pos.getRow() - i, pos.getCol() + i)).isWhite != super.isWhite) {
					ret.add(new Position(pos.getRow() - i, pos.getCol() + i));
				}
			}
		for (int i = 1; (((pos.getRow() - i) >= 0) && ((pos.getCol() - i) >= 0) && D); i++)
			if (b.getPieceAtPos(new Position(pos.getRow() - i, pos.getCol() - i)) == null) {
				ret.add(new Position(pos.getRow() - i, pos.getCol() - i));
			} else {
				D = false;
				if (b.getPieceAtPos(new Position(pos.getRow() - i, pos.getCol() - i)).isWhite != super.isWhite) {
					ret.add(new Position(pos.getRow() - i, pos.getCol() - i));
				}
			}

		return removeInvalidMoves(ret);
	}

	@Override
	public void draw() {
	}

	public String toString() {
		return "Bishop" + super.toString();
	}
}
