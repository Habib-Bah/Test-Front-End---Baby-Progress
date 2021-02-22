import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Fenetre extends JFrame {

	private static final long serialVersionUID = 3848503049147007269L;


	/*************************************************
	 *	 Declaration des JButtons
	 **************************************************/

	private final JButton gauche;
	private final JButton droite;
	private final JButton haut;
	private final JButton bas;
	private final JButton start;
	private  JButton [] buttons;


	/*************************************************
	 *	 Declaration des variables qui correspondent aux positions
	 *	 du pion et de la sortie.
	 *	 Ses positions sont genérées de manière aléatoire
	 **************************************************/
	private int position = 1;
	private int sortie = 1;

	public Fenetre(String title) {
		super(title);

		/*************************************************
			*	 Ajout des propriété de la jframe
		**************************************************/

		this.setTitle("Labyrinthe");
		this.setSize(200, 100);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);

		/*************************************************
		 	*    Ajout des propriété du gridLayout
		 **************************************************/

		this.setLayout(new GridLayout(5, 5));

		/*************************************************
		 	*	Initialisation du tableau de buttons
		 *************************************************/
		this.buttons = new JButton[57];

		/*************************************************
		 	*  Initialisation des bouttons de direction
		 *************************************************/

		this.haut = new JButton("↑");
		this.bas = new JButton("↓");
		this.gauche = new JButton("←");
		this.droite = new JButton("→");
		this.start = new JButton("start");

		/*************************************************
			*	Ajout des bouttons sur la grille
		 *************************************************/

		for(int i=1 ; i<=55 ; i++){
			JButton btn = new JButton("");
			btn.setPreferredSize(new Dimension(1, 1));
			buttons[i] = btn;
			this.getContentPane().add(buttons[i]);
		}

		this.getContentPane().add(start);
		/*************************************************
			* Construction du labyrinthe
		 *************************************************/

		buttons[2].setText("x");
		buttons[4].setText("x");
		buttons[8].setText("x");
		buttons[10].setText("x");
		buttons[12].setText("x");
		buttons[14].setText("x");
		buttons[16].setText("x");
		buttons[20].setText("x");
		buttons[22].setText("x");
		buttons[23].setText("x");
		buttons[29].setText("x");
		buttons[32].setText("x");
		buttons[34].setText("x");
		buttons[38].setText("x");
		buttons[40].setText("x");
		buttons[43].setText("x");
		buttons[48].setText("x");

		/*************************************************
		 	*	Ajout des buttons de directions
		 **************************************************/

		this.getContentPane().add(this.gauche);
		this.getContentPane().add(this.droite);
		this.getContentPane().add(this.haut);
		this.getContentPane().add(this.bas);


		/*************************************************
			*	Ecouteurs d'evenements sur les buttons de direction
		 **************************************************/

		gauche.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				buttons[position].setText("");
				position --;

				if(!(buttons[position].getText().equalsIgnoreCase("x"))) {
					if(buttons[position].getText().equalsIgnoreCase("sortie")) {
						buttons[position].setText("");
					}
					else {
						buttons[position].setText("p");
					}
				}
				else {
					position ++;
					buttons[position].setText("p");
				}

			}
		});

		droite.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				buttons[position].setText("");
				position ++;
				if(!(buttons[position].getText().equalsIgnoreCase("x"))) {
					if(buttons[position].getText().equalsIgnoreCase("sortie")) {
						buttons[position].setText("");
					}
					else {
						buttons[position].setText("p");
					}
				}
				else {
					position --;
					buttons[position].setText("p");
				}
			}
		});


		haut.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				buttons[position].setText("");
				position = position - 12;

				if(position <= 0 ) {
					position = position + 12;
					if(buttons[position].getText().equalsIgnoreCase("sortie")) {
						buttons[position].setText("");
					}
					else {
						buttons[position].setText("p");
					}
				}
				else {
					if(!(buttons[position].getText().equalsIgnoreCase("x"))) {
						if(buttons[position].getText().equalsIgnoreCase("sortie")) {
							buttons[position].setText("");
						}
						else {
							buttons[position].setText("p");
						}
					}
					else {
						position = position + 12;
						buttons[position].setText("p");
					}
				}
			}
		});


		bas.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				buttons[position].setText("");
				position = position + 12;

				if(position > 55 ) {
					position = position - 12;
					if(buttons[position].getText().equalsIgnoreCase("sortie")) {
						buttons[position].setText("");
					}
					else {
						buttons[position].setText("p");
					}
				}
				else {
					if(!(buttons[position].getText().equalsIgnoreCase("x"))) {
						if(buttons[position].getText().equalsIgnoreCase("sortie")) {
							buttons[position].setText("");
						}
						else {
							buttons[position].setText("p");
						}
					}
					else {
						position = position - 12;
						buttons[position].setText("p");
					}
				}
			}
		});



		/*************************************************
		 *	Ecouteurs d'evenements sur le buttons start
		 **************************************************/

		start.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				if(buttons[position].getText().equalsIgnoreCase("p")) {
					buttons[position].setText("");
				}
				if(buttons[sortie].getText().equalsIgnoreCase("sortie")) {
					buttons[sortie].setText("");
				}
				Random random = new Random();
				position = random.nextInt(50) + 1;
				sortie = random.nextInt(50) + 1;
				while (buttons[position].getText().equalsIgnoreCase("x") || buttons[position].getText().equalsIgnoreCase("sortie") ) {
					position = random.nextInt(50) + 1;
					sortie = random.nextInt(50) + 1;
				}

				buttons[position].setText("p");
				buttons[sortie].setText("sortie");
			}
		});



		this.setVisible(true);
	}

}
