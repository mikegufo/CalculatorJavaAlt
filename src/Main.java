
public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        InputHandler inputHandler = new InputHandler(calculator);
        inputHandler.handleInput();
    }
}