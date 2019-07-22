import java.util.ArrayList;

public class Queen extends Piece {

	public Queen(Position pos, Board b, boolean isWhite) {
		super(pos, b, isWhite);
	}

	@Override
	public ArrayList<Position> getMoveSet() {
		ArrayList<Position> ret = new ArrayList<Position>();
				
		boolean A = true;
		boolean B = true;
		boolean C = true;
		boolean D = true;
		boolean E = true;
		boolean F = true;
		boolean G = true;
		boolean H = true;
		
		for (int i = 1; (((pos.getRow() + i) < 8) && ((pos.getCol() + i) < 8) && A); i++)
			if (b.getPieceAtPos(new Position(pos.getRow() + i, pos.getCol() + i)) == null) {
				ret.add(new Position(pos.getRow() + i, pos.getCol() + i));
			} else {
				A = false;
				if (b.getPieceAtPos(new Position(pos.getRow() + i, pos.getCol() + i)).isWhite != super.isWhite) {
					ret.add(new Position(pos.getRow() + i, pos.getCol() + i));
				}
			}
		for (int i = 1; (((pos.getRow() + i) < 8) && ((pos.getCol() - i) >= 0)) && B; i++)	
			if (b.getPieceAtPos(new Position(pos.getRow() + i, pos.getCol() - i)) == null) {
				ret.add(new Position(pos.getRow() + i, pos.getCol() - i));
			} else {
				B = false;
				if (b.getPieceAtPos(new Position(pos.getRow() + i, pos.getCol() - i)).isWhite != super.isWhite) {
					ret.add(new Position(pos.getRow() + i, pos.getCol() - i));
				}
			}
		for (int i = 1; (((pos.getRow() - i) >= 0) && ((pos.getCol() + i) < 8)) && C; i++)
			if (b.getPieceAtPos(new Position(pos.getRow() - i, pos.getCol() + i)) == null) {
				ret.add(new Position(pos.getRow() - i, pos.getCol() + i));
			} else {
				C = false;
				if (b.getPieceAtPos(new Position(pos.getRow() - i, pos.getCol() + i)).isWhite != super.isWhite) {
					ret.add(new Position(pos.getRow() - i, pos.getCol() + i));
				}
			}		
		for (int i = 1; (((pos.getRow() - i) >= 0) && ((pos.getCol() - i) >= 0)) && D; i++)
			if (b.getPieceAtPos(new Position(pos.getRow() - i, pos.getCol() - i)) == null) {
				ret.add(new Position(pos.getRow() - i, pos.getCol() - i));
			} else {
				D = false;
				if (b.getPieceAtPos(new Position(pos.getRow() - i, pos.getCol() - i)).isWhite != super.isWhite) {
					ret.add(new Position(pos.getRow() - i, pos.getCol() - i));
				}
			}
		for (int i = 1; ((pos.getRow() + i < 8) && E); i++)
			if (b.getPieceAtPos(new Position(pos.getRow() + i, pos.getCol())) == null) {
				ret.add(new Position(pos.getRow() + i, pos.getCol()));
			} else {
				E = false;
				if (b.getPieceAtPos(new Position(pos.getRow() + i, pos.getCol())).isWhite != super.isWhite) {
					ret.add(new Position(pos.getRow() + i, pos.getCol()));
				}
			}
		for (int i = 1; ((pos.getRow() - i >= 0) && F); i++) 
			if (b.getPieceAtPos(new Position(pos.getRow() - i, pos.getCol())) == null) {
				ret.add(new Position(pos.getRow() - i, pos.getCol()));
			} else {
				F = false;
				if (b.getPieceAtPos(new Position(pos.getRow() - i, pos.getCol())).isWhite != super.isWhite) {
					ret.add(new Position(pos.getRow() - i, pos.getCol()));
				}
			}
		for (int i = 1; ((pos.getCol() + i < 8) && G); i++)
			if (b.getPieceAtPos(new Position(pos.getRow(), pos.getCol() + i)) == null) {
				ret.add(new Position(pos.getRow(), pos.getCol() + i));
			} else {
				G = false;
				if (b.getPieceAtPos(new Position(pos.getRow(), pos.getCol() + i)).isWhite != super.isWhite) {
					ret.add(new Position(pos.getRow(), pos.getCol() + i));
				}
			}
		for (int i = 1; ((pos.getCol() - i >= 0) && H); i++)
			if (b.getPieceAtPos(new Position(pos.getRow(), pos.getCol() - i)) == null) {
				ret.add(new Position(pos.getRow(), pos.getCol() - i));
			} else {
				H = false;
				if (b.getPieceAtPos(new Position(pos.getRow(), pos.getCol() - i)).isWhite != super.isWhite) {
					ret.add(new Position(pos.getRow(), pos.getCol() - i));
				}
			}
		
		return removeInvalidMoves(ret);
	}
	
	@Override
	public void draw() {
		// TODO Auto-generated method stub
		
	}
	
	public String toString() {
		return "Queen" + super.toString();
	}
}
