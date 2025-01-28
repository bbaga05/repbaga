import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);  // Вводим сканнер

        System.out.println("Введите выражение (например, 1 + 2):");
        String expr = sc.nextLine(); // Вводим выражение (expression)

        try {
            String[] parts = expr.split(" "); // Разделяем строку на части (parts)

            if (parts.length != 3) {   // массив parts должен иметь 3 элемента
                throw new Exception("Введите выражение в формате: число операция число.");
            }

            int num1 = Integer.parseInt(parts[0]); // Первое целое число
            String opr = parts[1];                 // Оператор
            int num2 = Integer.parseInt(parts[2]); // Второе целое число

            if (num1 < 1 || num1 > 10 || num2 < 1 || num2 > 10) {
                throw new Exception("Числа должны быть от 1 до 10.");
            }

            int res = 0;
            switch (opr) {
                case "+" -> res = num1 + num2;
                case "-" -> res = num1 - num2;
                case "*" -> res = num1 * num2;
                case "/" -> {
                    if (num2 == 0) {
                        throw new Exception("Деление на ноль невозможно.");
                    }
                    res = num1 / num2;
                }
                default -> throw new Exception("Используйте +, -, *, /.");
            }

            System.out.println("Результат: " + res);
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        sc.close();
    }
}
