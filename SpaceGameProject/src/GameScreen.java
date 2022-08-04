
import java.awt.HeadlessException;
import javax.swing.JFrame;

public class GameScreen extends JFrame {

    public GameScreen(String title) throws HeadlessException {
        super(title);
    }

    public static void main(String[] args) {
        GameScreen screen = new GameScreen("Kosmik Oyun");
        Game game = new Game();

        // Oyun class'ı ilə bağlı proseslər && KeyListener.
        game.requestFocus();
        game.addKeyListener(game);
        game.setFocusable(true);
        game.setFocusTraversalKeysEnabled(false);

        // Oyun Ekranının xüsusiyyətləri
        screen.setResizable(false);
        screen.setFocusable(false);
        screen.setSize(800, 600);
        screen.setDefaultCloseOperation(EXIT_ON_CLOSE);
        screen.setVisible(true);
        screen.add(game);

    }
}
