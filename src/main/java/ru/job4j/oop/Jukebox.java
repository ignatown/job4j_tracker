package ru.job4j.oop;

public class Jukebox {

    public void music(int position) {
        if (position == 1) {
            System.out.println("May people run clumsily through puddles");
            System.out.println("May the water flow like a river down the street,");
            System.out.println("And may people passing by not understand why");
            System.out.println("I am so happy on this sad day. \n");
        } else {
            if (position == 2) {
                System.out.println("After The day we are very tired,");
                System.out.println("We all say: \"Good night.\"");
                System.out.println("Close your eyes, bye-bye.\n");

            } else {
                System.out.println("song not found\n");
            }
        }
    }

    public static void main(String[] args) {
        Jukebox first = new Jukebox();
        first.music(1);
        first.music(2);
        first.music(100);

    }
}
