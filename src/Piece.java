import java.util.ArrayList;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Piece {
	private int ligne, colonne, type;
	private boolean estBlanc;
	private Image img;

	public int getType() {
		return type;
	}

	public int getLigne() {
		return ligne;
	}

	public int getColonne() {
		return colonne;
	}

	public boolean isEstBlanc() {
		return estBlanc;
	}

	public void setType(int type) {
		this.type = type;
	}

	public void setEstBlanc(boolean estBlanc) {
		this.estBlanc = estBlanc;
	}

	public void setImg() throws SlickException {
		switch (type) {
		case 0:
			if (estBlanc)
				img = new Image("images/pionB.png");
			else
				img = new Image("images/pionN.png");
			break;
		case 1:
			if (estBlanc)
				img = new Image("images/tourB.png");
			else
				img = new Image("images/tourN.png");
			break;
		case 2:
			if (estBlanc)
				img = new Image("images/cavalierB.png");
			else
				img = new Image("images/cavalierN.png");
			break;
		case 3:
			if (estBlanc)
				img = new Image("images/fouB.png");
			else
				img = new Image("images/fouN.png");
			break;
		case 4:
			if (estBlanc)
				img = new Image("images/reineB.png");
			else
				img = new Image("images/reineN.png");
			break;
		case 5:
			if (estBlanc)
				img = new Image("images/roiB.png");
			else
				img = new Image("images/roiN.png");
			break;
		default:
			if (estBlanc)
				img = new Image("images/roiB.png");
			else
				img = new Image("images/roiN.png");
			break;
		}
	}

	public Image getImg() {
		return img;
	}

	public Piece() throws SlickException {
		this.ligne = 1;
		this.colonne = 1;
		this.type = 0;
		this.estBlanc = true;
		img = new Image("images/pionB.png");
	}

	public Piece(int colonne, int ligne, int type, boolean estBlanc) throws SlickException {
		super();
		this.ligne = ligne;
		this.colonne = colonne;
		this.type = type;
		this.estBlanc = estBlanc;

		switch (type) {
		case 0:
			if (estBlanc)
				img = new Image("images/pionB.png");
			else
				img = new Image("images/pionN.png");
			break;
		case 1:
			if (estBlanc)
				img = new Image("images/tourB.png");
			else
				img = new Image("images/tourN.png");
			break;
		case 2:
			if (estBlanc)
				img = new Image("images/cavalierB.png");
			else
				img = new Image("images/cavalierN.png");
			break;
		case 3:
			if (estBlanc)
				img = new Image("images/fouB.png");
			else
				img = new Image("images/fouN.png");
			break;
		case 4:
			if (estBlanc)
				img = new Image("images/reineB.png");
			else
				img = new Image("images/reineN.png");
			break;
		case 5:
			if (estBlanc)
				img = new Image("images/roiB.png");
			else
				img = new Image("images/roiN.png");
			break;
		default:
			if (estBlanc)
				img = new Image("images/roiB.png");
			else
				img = new Image("images/roiN.png");
			break;
		}
	}

	public void dessiner(Graphics g) {
		g.drawImage(img, colonne * 60, ligne * 60);
	}

	public boolean dansLesLimites(int x, int y) {
		if (x < 8 && y < 8 && x >= 0 && y >= 0)
			return true;
		else
			return false;
	}

	public ArrayList<int[]> deplacementsCavalier(Plateau p) {
		ArrayList<int[]> arr = new ArrayList<int[]>();
		int[] tab;
		int decaleColonne, decaleLigne;

		tab = new int[3];
		decaleColonne = colonne + 2;
		decaleLigne = ligne + 1;
		if (this.dansLesLimites(decaleColonne, decaleLigne)) {
			if (p.getPieces(decaleColonne, decaleLigne) == null) {
				tab[0] = decaleColonne;
				tab[1] = decaleLigne;
				arr.add(tab);
			} else if (this.estBlanc != p.getPieces(decaleColonne, decaleLigne).estBlanc) {
				tab[0] = decaleColonne;
				tab[1] = decaleLigne;
				tab[2] = 1;
				arr.add(tab);
			}
		}

		tab = new int[3];
		decaleColonne = colonne + 2;
		decaleLigne = ligne - 1;
		if (this.dansLesLimites(decaleColonne, decaleLigne)) {
			if (p.getPieces(decaleColonne, decaleLigne) == null) {
				tab[0] = decaleColonne;
				tab[1] = decaleLigne;
				arr.add(tab);
			} else if (this.estBlanc != p.getPieces(decaleColonne, decaleLigne).estBlanc) {
				tab[0] = decaleColonne;
				tab[1] = decaleLigne;
				tab[2] = 1;
				arr.add(tab);
			}
		}

		tab = new int[3];
		decaleColonne = colonne - 2;
		decaleLigne = ligne + 1;
		if (this.dansLesLimites(decaleColonne, decaleLigne)) {
			if (p.getPieces(decaleColonne, decaleLigne) == null) {
				tab[0] = decaleColonne;
				tab[1] = decaleLigne;
				arr.add(tab);
			} else if (this.estBlanc != p.getPieces(decaleColonne, decaleLigne).estBlanc) {
				tab[0] = decaleColonne;
				tab[1] = decaleLigne;
				tab[2] = 1;
				arr.add(tab);
			}
		}

		tab = new int[3];
		decaleColonne = colonne - 2;
		decaleLigne = ligne - 1;
		if (this.dansLesLimites(decaleColonne, decaleLigne)) {
			if (p.getPieces(decaleColonne, decaleLigne) == null) {
				tab[0] = decaleColonne;
				tab[1] = decaleLigne;
				arr.add(tab);
			} else if (this.estBlanc != p.getPieces(decaleColonne, decaleLigne).estBlanc) {
				tab[0] = decaleColonne;
				tab[1] = decaleLigne;
				tab[2] = 1;
				arr.add(tab);
			}
		}

		tab = new int[3];
		decaleColonne = colonne + 1;
		decaleLigne = ligne + 2;
		if (this.dansLesLimites(decaleColonne, decaleLigne)) {
			if (p.getPieces(decaleColonne, decaleLigne) == null) {
				tab[0] = decaleColonne;
				tab[1] = decaleLigne;
				arr.add(tab);
			} else if (this.estBlanc != p.getPieces(decaleColonne, decaleLigne).estBlanc) {
				tab[0] = decaleColonne;
				tab[1] = decaleLigne;
				tab[2] = 1;
				arr.add(tab);
			}
		}

		tab = new int[3];
		decaleColonne = colonne + 1;
		decaleLigne = ligne - 2;
		if (this.dansLesLimites(decaleColonne, decaleLigne)) {
			if (p.getPieces(decaleColonne, decaleLigne) == null) {
				tab[0] = decaleColonne;
				tab[1] = decaleLigne;
				arr.add(tab);
			} else if (this.estBlanc != p.getPieces(decaleColonne, decaleLigne).estBlanc) {
				tab[0] = decaleColonne;
				tab[1] = decaleLigne;
				tab[2] = 1;
				arr.add(tab);
			}
		}

		tab = new int[3];
		decaleColonne = colonne - 1;
		decaleLigne = ligne + 2;
		if (this.dansLesLimites(decaleColonne, decaleLigne)) {
			if (p.getPieces(decaleColonne, decaleLigne) == null) {
				tab[0] = decaleColonne;
				tab[1] = decaleLigne;
				arr.add(tab);
			} else if (this.estBlanc != p.getPieces(decaleColonne, decaleLigne).estBlanc) {
				tab[0] = decaleColonne;
				tab[1] = decaleLigne;
				tab[2] = 1;
				arr.add(tab);
			}
		}

		tab = new int[3];
		decaleColonne = colonne - 1;
		decaleLigne = ligne - 2;
		if (this.dansLesLimites(decaleColonne, decaleLigne)) {
			if (p.getPieces(decaleColonne, decaleLigne) == null) {
				tab[0] = decaleColonne;
				tab[1] = decaleLigne;
				arr.add(tab);
			} else if (this.estBlanc != p.getPieces(decaleColonne, decaleLigne).estBlanc) {
				tab[0] = decaleColonne;
				tab[1] = decaleLigne;
				tab[2] = 1;
				arr.add(tab);
			}
		}
		return arr;
	}

	public ArrayList<int[]> deplacementsFou(Plateau p) {
		ArrayList<int[]> arr = new ArrayList<int[]>();
		int[] tab;
		int decaleColonne = colonne, decaleLigne = ligne;

		while (decaleColonne < 7 && decaleLigne < 7) {
			decaleColonne++;
			decaleLigne++;
			if (p.getPieces(decaleColonne, decaleLigne) != null) {
				tab = new int[3];
				tab[0] = decaleColonne;
				tab[1] = decaleLigne;
				if (p.getPieces(decaleColonne, decaleLigne).estBlanc != estBlanc) {
					tab[2] = 1;
					arr.add(tab);
				}
				break;
			} else {
				tab = new int[3];
				tab[0] = decaleColonne;
				tab[1] = decaleLigne;
				arr.add(tab);
			}
		}

		decaleColonne = colonne;
		decaleLigne = ligne;
		while (decaleColonne < 7 && decaleLigne > 0) {
			decaleColonne++;
			decaleLigne--;
			if (p.getPieces(decaleColonne, decaleLigne) != null) {
				tab = new int[3];
				tab[0] = decaleColonne;
				tab[1] = decaleLigne;
				if (p.getPieces(decaleColonne, decaleLigne).estBlanc != estBlanc) {
					tab[2] = 1;
					arr.add(tab);
				}
				break;
			} else {
				tab = new int[3];
				tab[0] = decaleColonne;
				tab[1] = decaleLigne;
				arr.add(tab);
			}
		}

		decaleColonne = colonne;
		decaleLigne = ligne;
		while (decaleColonne > 0 && decaleLigne > 0) {
			decaleColonne--;
			decaleLigne--;
			if (p.getPieces(decaleColonne, decaleLigne) != null) {
				tab = new int[3];
				tab[0] = decaleColonne;
				tab[1] = decaleLigne;
				if (p.getPieces(decaleColonne, decaleLigne).estBlanc != estBlanc) {
					tab[2] = 1;
					arr.add(tab);
				}
				break;
			} else {
				tab = new int[3];
				tab[0] = decaleColonne;
				tab[1] = decaleLigne;
				arr.add(tab);
			}
		}

		decaleColonne = colonne;
		decaleLigne = ligne;
		while (decaleColonne > 0 && decaleLigne < 7) {
			decaleColonne--;
			decaleLigne++;
			if (p.getPieces(decaleColonne, decaleLigne) != null) {
				tab = new int[3];
				tab[0] = decaleColonne;
				tab[1] = decaleLigne;
				if (p.getPieces(decaleColonne, decaleLigne).estBlanc != estBlanc) {
					tab[2] = 1;
					arr.add(tab);
				}
				break;
			} else {
				tab = new int[3];
				tab[0] = decaleColonne;
				tab[1] = decaleLigne;
				arr.add(tab);
			}
		}

		return arr;
	}

	public ArrayList<int[]> deplacementsTour(Plateau p) {
		ArrayList<int[]> arr = new ArrayList<int[]>();
		int[] tab;
		int decaleColonne = colonne, decaleLigne = ligne;

		for (int k = colonne + 1; k < 8; k++) {
			if (p.getPieces(k, decaleLigne) != null) {
				tab = new int[3];
				tab[0] = k;
				tab[1] = decaleLigne;
				if (p.getPieces(k, decaleLigne).estBlanc != estBlanc) {
					tab[2] = 1;
					arr.add(tab);
				}
				break;
			} else {
				tab = new int[3];
				tab[0] = k;
				tab[1] = decaleLigne;
				arr.add(tab);
			}
		}

		for (int k = colonne - 1; k >= 0; k--) {
			if (p.getPieces(k, decaleLigne) != null) {
				tab = new int[3];
				tab[0] = k;
				tab[1] = decaleLigne;
				if (p.getPieces(k, decaleLigne).estBlanc != estBlanc) {
					tab[2] = 1;
					arr.add(tab);
				}
				break;
			} else {
				tab = new int[3];
				tab[0] = k;
				tab[1] = decaleLigne;
				arr.add(tab);
			}
		}

		for (int k = ligne + 1; k < 8; k++) {
			if (p.getPieces(decaleColonne, k) != null) {
				tab = new int[3];
				tab[0] = decaleColonne;
				tab[1] = k;
				if (p.getPieces(decaleColonne, k).estBlanc != estBlanc) {
					tab[2] = 1;
					arr.add(tab);
				}
				break;
			} else {
				tab = new int[3];
				tab[0] = decaleColonne;
				tab[1] = k;
				arr.add(tab);
			}
		}

		for (int k = ligne - 1; k >= 0; k--) {
			if (p.getPieces(decaleColonne, k) != null) {
				tab = new int[3];
				tab[0] = decaleColonne;
				tab[1] = k;
				if (p.getPieces(decaleColonne, k).estBlanc != estBlanc) {
					tab[2] = 1;
					arr.add(tab);
				}
				break;
			} else {
				tab = new int[3];
				tab[0] = decaleColonne;
				tab[1] = k;
				arr.add(tab);
			}
		}

		return arr;
	}

	public ArrayList<int[]> deplacementsReine(Plateau p) {
		ArrayList<int[]> arr = new ArrayList<int[]>();
		
		arr.addAll(this.deplacementsFou(p));
		arr.addAll(this.deplacementsTour(p));

		return arr;
	}

	public ArrayList<int[]> deplacementsRoi(Plateau p) {
		ArrayList<int[]> arr = new ArrayList<int[]>();
		int[] tab;
		int decaleColonne = colonne, decaleLigne = ligne;

		int k = colonne + 1;
		if (p.getPieces(k, decaleLigne) != null) {
			if (p.getPieces(k, decaleLigne).estBlanc != estBlanc) {
				tab = new int[3];
				tab[0] = k;
				tab[1] = decaleLigne;
				tab[2] = 1;
				arr.add(tab);
			}
		} else {
			tab = new int[3];
			tab[0] = k;
			tab[1] = decaleLigne;
			arr.add(tab);
		}

		k = colonne - 1;
		if (p.getPieces(k, decaleLigne) != null) {
			if (p.getPieces(k, decaleLigne).estBlanc != estBlanc) {
				tab = new int[3];
				tab[0] = k;
				tab[1] = decaleLigne;
				tab[2] = 1;
				arr.add(tab);
			}
		} else {
			tab = new int[3];
			tab[0] = k;
			tab[1] = decaleLigne;
			arr.add(tab);
		}

		k = ligne + 1;
		if (p.getPieces(decaleColonne, k) != null) {
			if (p.getPieces(decaleColonne, k).estBlanc != estBlanc) {
				tab = new int[3];
				tab[0] = decaleColonne;
				tab[1] = k;
				tab[2] = 1;
				arr.add(tab);
			}
		} else {
			tab = new int[3];
			tab[0] = decaleColonne;
			tab[1] = k;
			arr.add(tab);
		}

		k = ligne - 1;
		if (p.getPieces(decaleColonne, k) != null) {
			if (p.getPieces(decaleColonne, k).estBlanc != estBlanc) {
				tab = new int[3];
				tab[0] = decaleColonne;
				tab[1] = k;
				tab[2] = 1;
				arr.add(tab);
			}
		} else {
			tab = new int[3];
			tab[0] = decaleColonne;
			tab[1] = k;
			arr.add(tab);
		}

		k = colonne + 1;
		int m = ligne + 1;
		if (p.getPieces(k, m) != null) {
			if (p.getPieces(k, m).estBlanc != estBlanc) {
				tab = new int[3];
				tab[0] = k;
				tab[1] = m;
				tab[2] = 1;
				arr.add(tab);
			}
		} else {
			tab = new int[3];
			tab[0] = k;
			tab[1] = m;
			arr.add(tab);
		}

		k = colonne - 1;
		m = ligne + 1;
		if (p.getPieces(k, m) != null) {
			if (p.getPieces(k, m).estBlanc != estBlanc) {
				tab = new int[3];
				tab[0] = k;
				tab[1] = m;
				tab[2] = 1;
				arr.add(tab);
			}
		} else {
			tab = new int[3];
			tab[0] = k;
			tab[1] = m;
			arr.add(tab);
		}

		k = colonne + 1;
		m = ligne - 1;
		if (p.getPieces(k, m) != null) {
			if (p.getPieces(k, m).estBlanc != estBlanc) {
				tab = new int[3];
				tab[0] = k;
				tab[2] = 1;
				arr.add(tab);
			}
		} else {
			tab = new int[3];
			tab[0] = k;
			tab[1] = m;
			arr.add(tab);
		}

		k = colonne - 1;
		m = ligne + 1;
		if (p.getPieces(k, m) != null) {
			if (p.getPieces(k, m).estBlanc != estBlanc) {
				tab = new int[3];
				tab[0] = k;
				tab[1] = m;
				tab[2] = 1;
				arr.add(tab);
			}
		} else {
			tab = new int[3];
			tab[0] = k;
			tab[1] = m;
			arr.add(tab);
		}

		k = colonne - 1;
		m = ligne - 1;
		if (p.getPieces(k, m) != null) {
			if (p.getPieces(k, m).estBlanc != estBlanc) {
				tab = new int[3];
				tab[0] = k;
				tab[1] = m;
				tab[2] = 1;
				arr.add(tab);
			}
		} else {
			tab = new int[3];
			tab[0] = k;
			tab[1] = m;
			arr.add(tab);
		}

		return arr;
	}

	public ArrayList<int[]> deplacementsPion(Plateau p) {
		ArrayList<int[]> arr = new ArrayList<int[]>();
		int[] tab;

		if (this.estBlanc && this.dansLesLimites(colonne, ligne - 1) && p.getPieces(colonne, ligne - 1) == null) {
			tab = new int[3];
			tab[0] = colonne;
			tab[1] = ligne - 1;
			arr.add(tab);

		} else if (!this.estBlanc && this.dansLesLimites(colonne, ligne + 1)
				&& p.getPieces(colonne, ligne + 1) == null) {
			tab = new int[3];
			tab[0] = colonne;
			tab[1] = ligne + 1;
			arr.add(tab);
		}

		if (this.estBlanc && this.dansLesLimites(colonne, ligne - 2) && p.getPieces(colonne, ligne - 2) == null
				&& ligne == 6) {
			tab = new int[3];
			tab[0] = colonne;
			tab[1] = ligne - 2;
			arr.add(tab);

		} else if (!this.estBlanc && this.dansLesLimites(colonne, ligne + 2) && p.getPieces(colonne, ligne + 2) == null
				&& ligne == 1) {
			tab = new int[3];
			tab[0] = colonne;
			tab[1] = ligne + 2;
			arr.add(tab);
		}

		if (this.estBlanc && this.dansLesLimites(colonne + 1, ligne - 1)
				&& p.getPieces(colonne + 1, ligne - 1) != null) {
			if (this.estBlanc != p.getPieces(colonne + 1, ligne - 1).estBlanc) {
				tab = new int[3];
				tab[0] = colonne + 1;
				tab[1] = ligne - 1;
				tab[2] = 1;
				arr.add(tab);
			}
		} else if (!this.estBlanc && this.dansLesLimites(colonne + 1, ligne + 1)
				&& p.getPieces(colonne + 1, ligne + 1) != null) {
			if (this.estBlanc != p.getPieces(colonne + 1, ligne + 1).estBlanc) {
				tab = new int[3];
				tab[0] = colonne + 1;
				tab[1] = ligne + 1;
				tab[2] = 1;
				arr.add(tab);
			}
		}

		if (this.estBlanc && this.dansLesLimites(colonne - 1, ligne - 1)
				&& p.getPieces(colonne - 1, ligne - 1) != null) {
			if (this.estBlanc != p.getPieces(colonne - 1, ligne - 1).estBlanc) {
				tab = new int[3];
				tab[0] = colonne - 1;
				tab[1] = ligne - 1;
				tab[2] = 1;
				arr.add(tab);
			}
		} else if (!this.estBlanc && this.dansLesLimites(colonne - 1, ligne + 1)
				&& p.getPieces(colonne - 1, ligne + 1) != null) {
			if (this.estBlanc != p.getPieces(colonne - 1, ligne + 1).estBlanc) {
				tab = new int[3];
				tab[0] = colonne - 1;
				tab[1] = ligne + 1;
				tab[2] = 1;
				arr.add(tab);
			}
		}

		return arr;
	}

	public void setLigne(int ligne) {
		this.ligne = ligne;
	}

	public void setColonne(int colonne) {
		this.colonne = colonne;
	}

}
