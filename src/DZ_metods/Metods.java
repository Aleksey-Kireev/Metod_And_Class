package DZ_metods;

import java.time.LocalDate;
import java.util.Scanner;

public class Metods {
//

    //    Метод для проверки високосный год или нет.

    public static String checkYear(int year) {
        String mess;
        if (year <= 1584) {
            mess = " - за пределом принятого летоисчисления високосных годов.";
        } else if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
            mess = " високосный год.";
        } else {
            mess = " невисокосный год";
        }
        return mess;
    }

    // Метод поверки телефонов
    public static void checkUpd(int os, int year) {
        int currentYear = LocalDate.now().getYear();
        String mess;
        if (year == currentYear) {
            mess = (os == 1) ?
                    "Установите версию приложения для Android по ссылке ...." :
                    "Установите версию приложения для iOS по ссылке ....";
        } else {
            mess = (os == 1) ?
                    "Установите облегченную версию приложения для Android по ссылке ...." :
                    "Установите облегченную версию приложения для iOS по ссылке ....";
        }
        System.out.println(mess);
    }

    // Метод поверки доставки
    public static int checkDeliv(int deliveryDistance) {
        int tMin = 1;    //  Переменная минимального дня доставки
        if (deliveryDistance >= 0 && deliveryDistance <= 20) {
            tMin = 1;
        } else if (deliveryDistance > 20 && deliveryDistance <= 60) {
            tMin += 1;
        } else if (deliveryDistance > 60 && deliveryDistance <= 100) {
            tMin += 2;
        } else if (deliveryDistance > 100 | deliveryDistance < 0) {
            tMin = 0;
        }

        return tMin;
    }

    public static void main(String[] args) {

//     ---------  Заадача № 1 ------

        System.out.println(" \n ---- Задача № 1 ----");
        Scanner inNum = new Scanner(System.in);         //  Инициализируем сканер
        System.out.println();
        System.out.print("Введите год для проверки : ");
        int year = inNum.nextInt();         //  Ввод числа для проверки
        System.out.printf("%s год -%s \n", year, checkYear(year));

//     ---------  Заадача № 2 ------

        System.out.println(" \n ---- Задача № 2 ----");
        System.out.println();
        System.out.print("Если у Вас iOS - введите '0' \n" +
                "Если у Вас Android - введите '1' ");
        int os = inNum.nextInt();
        if (os == 0 | os == 1) {
            System.out.print("\n Введите год выпуска телефона : ");
            year = inNum.nextInt();
            checkUpd(os, year);
        } else {
            System.out.println("\n Введены неверные данные. Повторите все сначала.");
            main(args);
        }

//     ---------  Заадача № 3 ------

        System.out.println(" \n ---- Задача № 3 ----");
        System.out.print(" \n Введите расстояние до Вас : ");
        int deliveryDistance = inNum.nextInt();
        int day = checkDeliv(deliveryDistance);
        String mess = switch (day) {
            case 1 -> "Для доставки карты потребуется %d день";
            case 2, 3 -> "Для доставки карты потребуется %d дня";
            default -> "Доставка карты не осуществляется ";
        };
        System.out.printf(mess + " ", day);

    }
}
