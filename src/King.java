import java.util.ArrayList;

public class King extends Piece {

	private Rook rook1;
	private Rook rook2;
	
	public King(Position pos, Board b, boolean isWhite, Rook rook1, Rook rook2) {
		super(pos, b, isWhite);
		this.rook1 = rook1;
		this.rook2 = rook2;
	}

	@Override
	public ArrayList<Position> getMoveSet() {
		ArrayList<Position> ret = new ArrayList<Position>();
		if (pos.getRow() + 1 < 8 && pos.getCol() + 1 < 8)
			ret.add(new Position(pos.getRow() + 1, pos.getCol() + 1));
		if (pos.getRow() - 1 >= 0 && pos.getCol() + 1 < 8)
			ret.add(new Position(pos.getRow() - 1, pos.getCol() + 1));
		if (pos.getRow() + 1 < 8 && pos.getCol() - 1 >= 0)
			ret.add(new Position(pos.getRow() + 1, pos.getCol() - 1));
		if (pos.getRow() - 1 >= 0 && pos.getCol() - 1 >= 0)
			ret.add(new Position(pos.getRow() - 1, pos.getCol() - 1));
		if (pos.getRow() + 1 < 8)
			ret.add(new Position(pos.getRow() + 1, pos.getCol()));
		if (pos.getRow() - 1 >= 0)
			ret.add(new Position(pos.getRow() - 1, pos.getCol()));
		if (pos.getCol() + 1 < 8)
			ret.add(new Position(pos.getRow(), pos.getCol() + 1));
		if (pos.getCol() - 1 >= 0)
			ret.add(new Position(pos.getRow(), pos.getCol() - 1));
		if (isWhite && b.whiteCanCastle()) {
			
		}
		return removeInvalidMoves(ret);
	}
	
	@Override
	public void move(Position pos) {
		super.move(pos);
		if (isWhite) {
			b.wKingPos = pos;
		} else {
			b.bKingPos = pos;
		}
	}
	
	@Override
	public void draw() {
		
	}
	
	public String toString() {
		return "King" + super.toString();
	}
}
