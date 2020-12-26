package ru.job4j.ru.job4j.io.ru.job4j.io;

import java.util.Scanner;

public class Matches {
    public static void possibleMove(int match, int minus, int nextPlayer) {
        if ((minus <= 0 || minus >= 4) || match - minus < 0) {
            System.out.println("Недопустимое количество спичек. "
                    + System.lineSeparator() + "Ход переходит игроку №"+ nextPlayer+".");
            minus = 0;
        }
    }
    public static boolean victoryCheck(int match, int minus) {
        return (minus < 0 && minus > 4 && match - minus > -1);
    }

    public static void main(String[] args) {
        int match = 11;
        int winnerFound = 0;
        int mode;
        boolean run = true;
        int ans;
        Scanner input = new Scanner(System.in);
        System.out.println("Игра \"11\"!");
        match = 11;
        winnerFound = 0;
        while (match > 0 && winnerFound == 0) {
            int minus;
            System.out.println("Оставшихся спичек: " + match);
            do {
                System.out.println("Ходит первый игрок! Сколько берем спичек? (от 1 до 3)");
                minus = Integer.valueOf(input.nextLine());
                possibleMove(match,minus,2);
            }
            while (victoryCheck(match,minus));
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
                    possibleMove(match,minus,1);
                }
                while (victoryCheck(match,minus));
                match -= minus;
                if (match == 0) {
                    System.out.println("Победил второй игрок.");
                    winnerFound = 1;
                }
            }
        }
    }
}
