package juego;

public class JuegoLoop extends Thread {

    private Game game;
    private long last = 0;

    public JuegoLoop(Game game) {
        this.game = game;  // Recibimos la referencia al objeto 'game'
    }

    @Override
    public void run() {
        while (true) {
            if (System.currentTimeMillis() - last > game.frequency) {
                if (!game.gameOver) {
                    game.moveSnake();  // Mover la serpiente
                    game.update();  // Actualizar el estado del juego
                }
                last = System.currentTimeMillis();  // Actualizamos el tiempo
            }
        }
    }
}

