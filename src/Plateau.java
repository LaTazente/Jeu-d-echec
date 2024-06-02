import java.util.ArrayList;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class Plateau {
	private Piece[][] pieces = new Piece[8][8];
	private int[] caseSelectionnee = new int[2];
	private ArrayList<int[]> destinationsValides;

	public Piece getPieces(int x, int y) {
		return pieces[x][y];
	}

	public Plateau() throws SlickException {
		super();
		for (int k = 0; k < 8; k++) {
			pieces[k][1] = new Piece(k, 1, 0, false);
			pieces[k][6] = new Piece(k, 6, 0, true);
		}

		pieces[0][0] = new Piece(0, 0, 1, false);
		pieces[7][0] = new Piece(7, 0, 1, false);
		pieces[0][7] = new Piece(0, 7, 1, true);
		pieces[7][7] = new Piece(7, 7, 1, true);

		pieces[1][0] = new Piece(1, 0, 2, false);
		pieces[6][0] = new Piece(6, 0, 2, false);
		pieces[1][7] = new Piece(1, 7, 2, true);
		pieces[6][7] = new Piece(6, 7, 2, true);

		pieces[2][0] = new Piece(2, 0, 3, false);
		pieces[5][0] = new Piece(5, 0, 3, false);
		pieces[2][7] = new Piece(2, 7, 3, true);
		pieces[5][7] = new Piece(5, 7, 3, true);

		pieces[4][0] = new Piece(4, 0, 4, false);
		pieces[4][7] = new Piece(4, 7, 4, true);

		pieces[3][0] = new Piece(3, 0, 5, false);
		pieces[3][7] = new Piece(3, 7, 5, true);

		destinationsValides = null;
		caseSelectionnee[0] = -1;
		caseSelectionnee[1] = -1;
	}

	public void vainqueur() {
		boolean vainqueurB = true, vainqueurN = true;
		for (int k = 0; k < 8; k++)
			for (int m = 0; m < 8; m++) {
				if (pieces[k][m] != null) {
					if (pieces[k][m].isEstBlanc() && pieces[k][m].getType() == 5)
						vainqueurN = false;
					if (!pieces[k][m].isEstBlanc() && pieces[k][m].getType() == 5)
						vainqueurB = false;
				}
			}
		if (vainqueurB == true)
			System.out.println("Vainqueur blanc!");
		if (vainqueurN == true)
			System.out.println("Vainqueur Noir!");
	}

	public void dessinerPlateau(Graphics g) {
		for (int k = 0; k < 8; k++)
			for (int m = 0; m < 8; m++) {
				if ((m + k) % 2 == 0)
					g.setColor(Color.white);
				else
					g.setColor(Color.gray);
				g.fillRect(k * 60, m * 60, 60, 60);
			}
	}

	public void dessinerPieces(Graphics g) {
		for (int k = 0; k < 8; k++)
			for (int m = 0; m < 8; m++)
				if (pieces[k][m] != null)
					pieces[k][m].dessiner(g);
	}

	public int[] quelleCase(int x, int y) {
		int[] selectionnee = new int[2];

		if (x <= 60)
			selectionnee[0] = 0;
		else if (x <= 60 * 2)
			selectionnee[0] = 1;
		else if (x <= 60 * 3)
			selectionnee[0] = 2;
		else if (x <= 60 * 4)
			selectionnee[0] = 3;
		else if (x <= 60 * 5)
			selectionnee[0] = 4;
		else if (x <= 60 * 6)
			selectionnee[0] = 5;
		else if (x <= 60 * 7)
			selectionnee[0] = 6;
		else if (x <= 60 * 8)
			selectionnee[0] = 7;
		else
			selectionnee[0] = 8;

		if (y <= 60)
			selectionnee[1] = 0;
		else if (y <= 60 * 2)
			selectionnee[1] = 1;
		else if (y <= 60 * 3)
			selectionnee[1] = 2;
		else if (y <= 60 * 4)
			selectionnee[1] = 3;
		else if (y <= 60 * 5)
			selectionnee[1] = 4;
		else if (y <= 60 * 6)
			selectionnee[1] = 5;
		else if (y <= 60 * 7)
			selectionnee[1] = 6;
		else if (y <= 60 * 8)
			selectionnee[1] = 7;
		else
			selectionnee[1] = 8;

		return selectionnee;
	}

	public void clicCase(int x, int y) throws SlickException {
		int[] tab = this.quelleCase(x, y);

		System.out.print(caseSelectionnee[0] + " " + caseSelectionnee[1] + " ");
		System.out.println(x + " " + y + " ");
		System.out.println(tab[0] + " " + tab[1] + " ");
		System.out.println(pieces[tab[0]][tab[1]] + " ");
		System.out.println();
		if (destinationsValides != null) {
			for (int[] k : destinationsValides) {
				if (k[0] == tab[0] && k[1] == tab[1]) {
					pieces[tab[0]][tab[1]] = new Piece(tab[0], tab[1],
							pieces[caseSelectionnee[0]][caseSelectionnee[1]].getType(),
							pieces[caseSelectionnee[0]][caseSelectionnee[1]].isEstBlanc());
					pieces[caseSelectionnee[0]][caseSelectionnee[1]] = null;
				}
			}
			destinationsValides = null;
			caseSelectionnee[0] = -1;
			caseSelectionnee[1] = -1;

		} else {
			if (caseSelectionnee[0] == -1 && caseSelectionnee[1] == -1 && pieces[tab[0]][tab[1]] != null)
				caseSelectionnee = tab;
			else if (caseSelectionnee[0] != tab[0] && pieces[tab[0]][tab[1]] != null
					|| caseSelectionnee[1] != tab[1] && pieces[tab[0]][tab[1]] != null)

				caseSelectionnee = tab;
			else {
				caseSelectionnee[0] = -1;
				caseSelectionnee[1] = -1;
			}

			if (caseSelectionnee[0] != -1 && caseSelectionnee[1] != -1 && caseSelectionnee[0] == tab[0]
					&& caseSelectionnee[1] == tab[1])
				switch (pieces[caseSelectionnee[0]][caseSelectionnee[1]].getType()) {
				case 0:
					destinationsValides = pieces[caseSelectionnee[0]][caseSelectionnee[1]].deplacementsPion(this);
					break;
				case 1:
					destinationsValides = pieces[caseSelectionnee[0]][caseSelectionnee[1]].deplacementsTour(this);
					break;
				case 2:
					destinationsValides = pieces[caseSelectionnee[0]][caseSelectionnee[1]].deplacementsCavalier(this);
					break;
				case 3:
					destinationsValides = pieces[caseSelectionnee[0]][caseSelectionnee[1]].deplacementsFou(this);
					break;
				case 4:
					destinationsValides = pieces[caseSelectionnee[0]][caseSelectionnee[1]].deplacementsReine(this);
					break;
				case 5:
					destinationsValides = pieces[caseSelectionnee[0]][caseSelectionnee[1]].deplacementsRoi(this);
					;
					break;
				}
			else
				destinationsValides = null;

		}
		System.out.print(caseSelectionnee[0] + " " + caseSelectionnee[1] + " ");
		System.out.println(x + " " + y + " ");
		System.out.println(tab[0] + " " + tab[1] + " ");
		System.out.println(pieces[tab[0]][tab[1]] + " ");
		System.out.println();
	}

	public void dessinerCaseSelectionnee(Graphics g) {
		if (caseSelectionnee[0] != -1 && caseSelectionnee[1] != -1) {
			g.setColor(new Color(255, 0, 0, 128));
			g.fillRect(caseSelectionnee[0] * 60, caseSelectionnee[1] * 60, 60, 60);
		}
	}

	public void dessinerDestinationsValides(Graphics g) {
		if (destinationsValides != null)
			for (int[] k : destinationsValides) {
				if (k[2] == 0)
					g.setColor(new Color(0, 255, 0, 128));
				else
					g.setColor(new Color(0, 0, 255, 128));
				g.fillRect(k[0] * 60, k[1] * 60, 60, 60);
			}

	}

}
