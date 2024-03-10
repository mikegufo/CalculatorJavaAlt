class Calculator {
    public String calculate(String operand1, String operator, String operand2) throws Exception {
        String result = "";

        switch (operator) {
            case "+":
                if (operand1.length() <= 12 && operand2.length() <= 12) {
                    result = operand1 + operand2;
                } else {
                    throw new Exception("Операнды должны иметь длину не более 10 символов");
                }
                break;
            case "-":
                if (operand1.length() <= 12 && operand2.length() <= 12) {
                    result = operand1.replace(operand2, "");
                } else {
                    throw new Exception("Операнды не более 10 символов");
                }
                break;
            case "*":
                if (operand1.length() <= 12 && operand2.length() <= 12) {
                    int repetition = Integer.parseInt(operand2);
                    if (repetition >= 1 && repetition <= 10) {
                        result = repeatString(operand1, repetition);
                    } else {
                        throw new Exception("Нужен множитель от 1 до 10");
                    }
                } else {
                    throw new Exception("Операнды не более 10 символов");
                }
                break;
            case "/":
                if (operand1.length() <= 12 && operand2.length() <= 12) {
                    int divisor = Integer.parseInt(operand2);
                    if (divisor >= 1 && divisor <= 10) {
                        if (divisor > 0) {
                            int resultLength = operand1.length() / divisor;
                            result = operand1.substring(0, resultLength);
                        } else {
                            throw new Exception("Неподдерживаемая операция");
                        }
                    } else {
                        throw new Exception("Делитель не в диапазоне от 1 до 10");
                    }
                } else {
                    throw new Exception("Операнды не более 10 символов");
                }
                break;
            default:
                throw new Exception("Неподдерживаемая операция");
        }

        if (result.length() > 40) {
            result = result.substring(0, 40) + "...";
        }

        return result;
    }

    public static String repeatString(String str, int times) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < times; i++) {
            sb.append(str);
        }
        return sb.toString();
    }
}
