package juego;

import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.Toolkit;

public class Snake extends JFrame {

    private Game game;  // Instancia del objeto que maneja la lógica del juego

    public Snake() {
        setTitle("Snake");

        game = new Game();  // Creamos el objeto que maneja la lógica del juego
        game.startGame();  // Iniciamos el juego

        this.setSize(game.width, game.height);  // Establecemos el tamaño de la ventana
        this.setLocationRelativeTo(null);  // Centramos la ventana en la pantalla
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Cierra el programa al salir
        this.setUndecorated(true);  // Eliminamos los bordes de la ventana

        this.add(game.imagenSnake);  // Añadimos el JPanel que maneja el dibujo
        this.addKeyListener(game.teclas);  // Añadimos el Listener de teclas para controlar el juego
        this.setVisible(true);  // Hacemos visible la ventana

        JuegoLoop juegoLoop = new JuegoLoop(game);  // Creamos el hilo del juego
        Thread gameThread = new Thread(juegoLoop);  // Hilo que corre el juego
        gameThread.start();  // Iniciamos el hilo
    }

    public static void main(String[] args) {
        new Snake();  // Iniciamos el juego
    }
}

