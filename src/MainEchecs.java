import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

public class MainEchecs {
	public static void main(String[] args) throws SlickException {
		Jeu monJeu = new Jeu("Le Jeu!");
		AppGameContainer app = new AppGameContainer(monJeu);
		app.setTargetFrameRate(60);
		app.setShowFPS(false);
		app.setDisplayMode(480, 480, false);
		app.start();
	}

}
