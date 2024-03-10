import java.util.Scanner;

class InputHandler {
    private Calculator calculator;
    private Scanner scanner;

    public InputHandler(Calculator calculator) {
        this.calculator = calculator;
        scanner = new Scanner(System.in);
    }

    public void handleInput() {
        System.out.print("Введите операцию (без пробелов) например, '5 + 10' или 'Java * 5' или 'Example!!! / 3': ");
        String input = scanner.nextLine();

        try {
            String[] parts = input.split("\\s+");

            if (parts.length == 3) {
                String operand1 = parts[0];
                String operator = parts[1];
                String operand2 = parts[2];

                validateInput(operand1, operator, operand2);

                String result = calculator.calculate(operand1, operator, operand2);

                result = result.replaceAll("\"", "");
                result = "\"" + result.trim() + "\"";
                System.out.println("Результат: " + result);
            } else {
                System.out.println("Неверный формат ввода");
            }
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    private void validateInput(String operand1, String operator, String operand2) throws Exception {
        if (operand1.contains(".") || operand1.contains(",") || operand2.contains(".") || operand2.contains(",")) {
            throw new Exception("Калькулятор умеет работать только с целыми числами");
        }


        if (!(operand1.startsWith("\"") && operand1.endsWith("\""))) {
            throw new IllegalArgumentException("Первый аргумент выражения должна быть строка");
        }
    }

}