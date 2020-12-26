package ru.job4j.ru.job4j.io.ru.job4j.io;

import java.util.Random;
import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        int match = 11;
        int winnerFound = 0;
        int mode;
        boolean run = true;
        int ans;
        Scanner input = new Scanner(System.in);
        System.out.println("Игра \"11\"!");
        while (run = true) {
            System.out.println("Выберите режим. "
                    + System.lineSeparator() + "1 - Игра вдвоём" + System.lineSeparator()
                        + "2 - Игра с компюетром" + System.lineSeparator() + "0 - Выход");
            mode = Integer.valueOf(input.nextLine());
            switch (mode) {
                default:
                    System.out.println("Неизвестный режим.");
                    break;
                case 0:
                System.out.println("Выход...");
                    run = false;
                    break;
                case 1:
                    System.out.println("Игра вдвоём!");
                    match = 11;
                    winnerFound = 0;
                    while (match > 0 && winnerFound == 0) {
                        int minus;
                        System.out.println("Оставшихся спичек: " + match);
                        do {
                            System.out.println("Ходит первый игрок! Сколько берем спичек? (от 1 до 3)");
                            minus = Integer.valueOf(input.nextLine());
                            if ((minus <= 0 || minus >= 4) || match - minus < 0) {
                                System.out.println("Недопустимое количество спичек. "
                                        + System.lineSeparator() + "Ход переходит второму игроку.");
                                minus = 0;
                            }
                        }
                        while (minus < 0 && minus > 4 && match - minus > -1);
                        match -= minus;
                        if (match == 0) {
                            System.out.println("Победил первый игрок.");
                            winnerFound = 1;
                        }
                        if (winnerFound == 0) {
                            System.out.println("Оставшихся спичек: " + match);
                            do {
                                System.out.println("Ходит второй игрок! Сколько берем спичек? (от 1 до 3)");
                                minus = Integer.valueOf(input.nextLine());
                                if ((minus <= 0 || minus >= 4) || match - minus < 0) {
                                    System.out.println("Недопустимое количество спичек."
                                            + System.lineSeparator() + "Ход переходит первому игроку.");
                                    minus = 0;
                                }
                            }
                            while (minus < 0 && minus > 4 && match - minus > -1);
                            match -= minus;
                            if (match == 0) {
                                System.out.println("Победил второй игрок.");
                                winnerFound = 1;
                            }
                        }
                    }
                    System.out.println("Введите 0, чтобы вернуться в меню и любую другую цифры, чтобы завернить игру.");
                    ans = Integer.valueOf(input.nextLine());
                    if (ans != 0) {
                        run = false;
                        System.out.println("Выход...");
                    }
                    break;
                case 2:
                    System.out.println("Игра с компьютером!");
                    match = 11;
                    winnerFound = 0;
                    while (match > 0 && winnerFound == 0) {
                        int minus;
                        System.out.println("Оставшихся спичек: " + match);
                        do {
                            System.out.println("Вы ходите! Сколько берем спичек? (от 1 до 3)");
                            minus = Integer.valueOf(input.nextLine());
                            if ((minus <= 0 || minus >= 4) ||match -minus < 0) {
                                System.out.println("Недопустимое количество спичек. "
                                        + System.lineSeparator() + "Ход переходит компьютеру.");
                                minus = 0;
                            }
                        }
                        while (minus < 0 && minus > 4 && match - minus > -1);
                        match -= minus;
                        if (match == 0) {
                            System.out.println("Вы победили!");
                            winnerFound = 1;
                        }
                        if (winnerFound == 0) {
                            System.out.println("Оставшихся спичек: " + match);

                            System.out.println("Ходит компьютер!");
                            if (match > 0 && match < 4) {
                                minus = match;
                                System.out.println("Компьютер взял спичек в количестве: " + minus);
                            } else {
                                Random random = new Random();
                                minus = random.nextInt(2);
                                minus += 1;
                                System.out.println("Компьютер взял спичек в количестве: " + minus);
                            }
                            match -= minus;
                            if (match == 0) {
                                System.out.println("Победил компьютер.");
                                winnerFound = 1;
                            }
                        }
                    }
                    System.out.println("Введите 0, чтобы вернуться в меню и любую другую цифры, чтобы завернить игру.");
                    ans = Integer.valueOf(input.nextLine());
                    if (ans != 0) {
                        run = false;
                        System.out.println("Выход...");
                    }
                    break;
            }
        }
    }
}
