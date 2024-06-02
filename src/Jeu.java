import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class Jeu extends BasicGame {
	private Plateau p1;
	
	
	public Jeu(String title) {
		super(title);
		double x , y ;
	}

	@Override
	public void render(GameContainer arg0, Graphics arg1) throws SlickException {
		// TODO Auto-generated method stub
		arg1.clear();
		arg1.destroy();
		p1.dessinerPlateau(arg1);
		p1.dessinerCaseSelectionnee(arg1);
		p1.dessinerDestinationsValides(arg1);
		p1.dessinerPieces(arg1);
	}

	@Override
	public void init(GameContainer arg0) throws SlickException {
		p1 = new Plateau();

	}

	@Override
	public void update(GameContainer arg0, int arg1) throws SlickException {
		Input inp = arg0.getInput();
		
		if(inp.isMousePressed(inp.MOUSE_LEFT_BUTTON)) p1.clicCase(inp.getMouseX(), inp.getMouseY());
		p1.vainqueur();
	}

}
