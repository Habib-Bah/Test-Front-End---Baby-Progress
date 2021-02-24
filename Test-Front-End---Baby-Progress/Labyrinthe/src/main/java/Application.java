import javax.swing.JFrame;


public class Application {

	public static void main(String[] args) {
		Fenetre fenetre = new Fenetre("Labirynthe");
		fenetre.setSize(600, 600);
		fenetre.setResizable(false);
		fenetre.setLocationRelativeTo(null);
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setVisible(true);
	}
}
