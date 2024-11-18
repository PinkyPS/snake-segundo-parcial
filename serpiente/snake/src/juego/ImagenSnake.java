package juego;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Font;

public class ImagenSnake extends JPanel {

    private Game game;  // Recibimos la referencia al objeto 'game'

    public ImagenSnake(Game game) {
        this.game = game;  // Inicializamos el objeto que maneja la lógica del juego
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (game.gameOver) {
            g.setColor(Color.BLACK);  // Fondo negro si el juego ha terminado
        } else {
            g.setColor(Color.WHITE);  // Fondo blanco durante el juego
        }

        g.fillRect(0, 0, game.width, game.height);  // Dibuja el fondo de la pantalla

        // Dibuja la serpiente
        g.setColor(Color.BLUE);
        for (Point p : game.listaPosiciones) {
            g.fillRect(p.x, p.y, game.widthPoint, game.heightPoint);
        }

        // Dibuja la comida
        g.setColor(Color.RED);
        g.fillRect(game.comida.x, game.comida.y, game.widthPoint, game.heightPoint);

        // Si el juego ha terminado, muestra el mensaje de "Game Over"
        if (game.gameOver) {
            g.setFont(new Font("TimesRoman", Font.BOLD, 40));
            g.drawString("GAME OVER", 300, 200);
            g.drawString("SCORE " + (game.listaPosiciones.size() - 1), 300, 240);

            g.setFont(new Font("TimesRoman", Font.BOLD, 20));
            g.drawString("N to Start New Game", 100, 320);
            g.drawString("ESC to Exit", 100, 340);
        }
    }
}

