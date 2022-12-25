// Реализовать простой калькулятор

import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String[] labels = { "1-е число:  ", "2-е число:  " };
        double[] num = new double[2];

        for (int i = 0; i < 2; i++) {
            System.out.printf("Введите %s", labels[i]);
            if (console.hasNextDouble()) {
                num[i] = console.nextDouble();
            } else {
                System.out.println("Извините, но это не число. Перезапустите программу и попробуйте снова!");
                System.exit(0);
            }
        }

        System.out.print("Какую операцию выполнить? (+ - * /)  ");
        String operation = console.next();
        console.close();

        String res = calc(operation, num[0], num[1]);
        res = (res.endsWith(".0")) ? res.substring(0, res.length() - 2) : res;
        System.out.println("Результат = " + res);
    }

    private static String calc(String operation, double num1, double num2) {
        switch (operation) {
            case "+":
                return Double.toString(num1 + num2);
            case "-":
                return Double.toString(num1 - num2);
            case "*":
                return Double.toString(num1 * num2);
            case "/":
                return (num2 != 0) ? Double.toString(num1 / num2) : "Ошибка! Деление на 0!";
            default:
                return "Некорректная операция";
        }
    }
}