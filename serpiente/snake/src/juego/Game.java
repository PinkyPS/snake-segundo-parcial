package juego;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

public class Game {

    public int width = 640;  // Ancho de la ventana
    public int height = 480;  // Alto de la ventana
    public int widthPoint = 10;  // Tamaño de un segmento de la serpiente
    public int heightPoint = 10;  // Tamaño de un segmento de la serpiente
    public String direccion = "RIGHT";  // Dirección inicial de la serpiente
    public long frequency = 50;  // Frecuencia de actualización en milisegundos

    public boolean gameOver = false;  // Estado del juego (si ha terminado)

    public Point snake;  // La posición de la cabeza de la serpiente
    public Point comida;  // La posición de la comida
    public ArrayList<Point> listaPosiciones = new ArrayList<>();  // Lista de posiciones de la serpiente

    public Teclas teclas;  // El objeto que maneja las teclas
    public ImagenSnake imagenSnake;  // El JPanel que maneja la renderización

    // Constructor sin necesidad del parámetro Snake
    public Game() {
        this.imagenSnake = new ImagenSnake(this);  // Creamos el panel de imagen
        this.teclas = new Teclas(this);  // Creamos el listener de teclas
        this.snake = new Point(320, 240);  // Inicializamos la posición de la serpiente
        this.comida = new Point(200, 100);  // Inicializamos la posición de la comida
    }

    public void startGame() {
        listaPosiciones.clear();  // Limpiamos las posiciones de la serpiente
        listaPosiciones.add(snake);  // Añadimos la posición inicial
        gameOver = false;  // Indicamos que el juego no ha terminado
        generateFood();  // Generamos la comida en una nueva posición
    }

    public void generateFood() {
        Random rnd = new Random();

        comida.x = (rnd.nextInt(width)) + 5;
        comida.x -= comida.x % 5;  // Alineamos la comida con el grid

        if (comida.x < 5) comida.x += 10;
        if (comida.x > width) comida.x -= 10;

        comida.y = (rnd.nextInt(height)) + 5;
        comida.y -= comida.y % 5;  // Alineamos la comida con el grid

        if (comida.y < 0) comida.y += 10;
        if (comida.y > height) comida.y -= 10;
    }

    public void update() {
        // Actualizamos la posición de la serpiente
        listaPosiciones.add(0, new Point(snake.x, snake.y));  // Añadimos la cabeza de la serpiente
        listaPosiciones.remove(listaPosiciones.size() - 1);  // Eliminamos el último segmento (cuerpo)

        // Comprobamos si la serpiente se ha chocado consigo misma
        for (int i = 1; i < listaPosiciones.size(); i++) {
            Point point = listaPosiciones.get(i);
            if (snake.x == point.x && snake.y == point.y) {
                gameOver = true;  // Si se choca, termina el juego
                break;
            }
        }

        // Comprobamos si la serpiente ha comido la comida
        if ((snake.x > (comida.x - 10) && snake.x < (comida.x + 10)) && (snake.y > (comida.y - 10) && snake.y < (comida.y + 10))) {
            listaPosiciones.add(0, new Point(snake.x, snake.y));  // Añadimos un nuevo segmento
            generateFood();  // Generamos una nueva comida en una posición aleatoria
        }

        imagenSnake.repaint();  // Actualizamos la pantalla
    }

    public void moveSnake() {
        // Mover la serpiente según la dirección
        if (direccion.equals("RIGHT")) {
            snake.x += widthPoint;
            if (snake.x > width) snake.x = 0;  // Si la serpiente se sale por la derecha, aparece por la izquierda
        } else if (direccion.equals("LEFT")) {
            snake.x -= widthPoint;
            if (snake.x < 0) snake.x = width - widthPoint;  // Si la serpiente se sale por la izquierda, aparece por la derecha
        } else if (direccion.equals("UP")) {
            snake.y -= heightPoint;
            if (snake.y < 0) snake.y = height;  // Si la serpiente se sale por arriba, aparece por abajo
        } else if (direccion.equals("DOWN")) {
            snake.y += heightPoint;
            if (snake.y > height) snake.y = 0;  // Si la serpiente se sale por abajo, aparece por arriba
        }
    }
}






