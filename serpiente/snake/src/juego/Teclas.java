package juego;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Teclas extends KeyAdapter {

    private Game game;  // Recibimos la referencia al objeto 'game'

    public Teclas(Game game) {
        this.game = game;  // Inicializamos el objeto que maneja la lógica del juego
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            System.exit(0);  // Salir del juego si se presiona 'Escape'
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            if (!game.direccion.equals("LEFT")) {
                game.direccion = "RIGHT";  // Cambiar dirección a la derecha
            }
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            if (!game.direccion.equals("RIGHT")) {
                game.direccion = "LEFT";  // Cambiar dirección a la izquierda
            }
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            if (!game.direccion.equals("DOWN")) {
                game.direccion = "UP";  // Cambiar dirección hacia arriba
            }
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            if (!game.direccion.equals("UP")) {
                game.direccion = "DOWN";  // Cambiar dirección hacia abajo
            }
        } else if (e.getKeyCode() == KeyEvent.VK_N) {
            game.gameOver = false;
            game.startGame();  // Reiniciar el juego cuando se presiona 'N'
        }
    }
}


