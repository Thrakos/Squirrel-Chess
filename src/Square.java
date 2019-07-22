import javax.swing.JButton;
import javax.swing.JOptionPane;

public class Square extends JButton {
	private boolean inMoveSet;
	private Board b;
	private Position pos;

	public Square(Board b, Position pos) {
		this.inMoveSet = false;
		this.b = b;
		this.pos = pos;
	}

	public void click() {
		if (b.getSelectedPiece() == null && b.getPieceAtPos(pos) != null) {
			b.getPieceAtPos(pos).select();
		} else if (inMoveSet && b.getSelectedPiece() != null) {
			b.getSelectedPiece().move(pos);
			
			if (b.testCheck(true)) {
				JOptionPane.showMessageDialog(null, "White King is in check!");
			} else if (b.testCheck(false)) {
				JOptionPane.showMessageDialog(null, "Black King is in check!");
			}
			
		} else {
			b.setSelectedPiece(null);
			b.unhighlightMoves();
		}
	}

	public void setInMoveSet(boolean inMoveSet) {
		this.inMoveSet = inMoveSet;
	}
}
