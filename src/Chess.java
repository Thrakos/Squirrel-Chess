import javax.swing.JFrame;
import javax.swing.JPanel;

public class Chess {
	public Chess() {
		JFrame frame = new JFrame("Squirrel Chess");
		Board board = new Board();
		frame.setSize(1000, 1000);
		frame.setResizable(false);
		frame.add(board);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new Chess();
	}
}
