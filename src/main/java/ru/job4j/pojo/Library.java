package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book bk0 = new Book("Clean Code", 100);
        Book bk1 = new Book("War and Peace", 1225);
        Book bk2 = new Book("Crime and Punishment", 576);
        Book bk3 = new Book("Encyclopedia", 10000);
        Book[] books = new Book[4];
        books[0] = bk0;
        books[1] = bk1;
        books[2] = bk2;
        books[3] = bk3;
        for (int i = 0; i < books.length; i++) {
            System.out.println("Book №" + i + " : "+books[i].getName() + " has "
                    + books[i].getNumberOfPages() + " pages.");
        }

        System.out.println("..rearranging books..");
        Book tempBook = new Book();
        tempBook = books[0];
        books[0] = books[3];
        books[3] = tempBook;

        for (int i = 0; i < books.length; i++) {
            if (books[i].getName().equals("Clean Code")) {
                System.out.println("Book \"" + books[i].getName() + "\" has number: " + i + " and "
                        + books[i].getNumberOfPages() + " pages");
            }
        }

    }
}
