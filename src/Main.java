import category.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        FileCSV read = new FileCSV();
        read.readCSV("Bookdata.csv");

        //For test in terminal
        Scanner sc = new Scanner(System.in);
        
        while (true) {

            System.out.println();
            System.out.println("Press");
            System.out.println("1.add new book");
            System.out.println("2.show all books");
            System.out.println("3.remove book");
            System.out.println("4.sell book");
            System.out.println("5.fill book in stock");
            System.out.println("6.Save book data");
            System.out.println();

            int num = sc.nextInt();
            sc.nextLine();
            
            switch (num) {
                case 1 -> { //add new book to stock
                    System.out.println("1.Manga");
                    System.out.println("2.Light Novel");
                    System.out.println("3.Novel");
                    System.out.println("4.Comic");
                    System.out.println("5.Tale");

                    System.out.print("Enter type of Book : ");
                    String code = "";

                    int type = sc.nextInt();
                    sc.nextLine();

                    if (type == 1)
                        code = "34294"; // Manga
                    else if (type == 2)
                        code = "71207"; // Light Novel
                    else if (type == 3)
                        code = "20731"; // addNovel
                    else if (type == 4)
                        code = "40314"; // Comic
                    else if (type == 5)
                        code = "74135"; // Tale

                    System.out.print("Enter volume : ");
                    String vol = sc.nextLine();

                    System.out.print("Enter keyword (2 Charecter) : ");
                    String keyword = sc.nextLine();

                    String pCode = code + keyword + vol;

                    System.out.print("Enter name of book : ");
                    String name = sc.nextLine();

                    System.out.print("Enter price of book : ");
                    int Price = sc.nextInt();

                    System.out.print("Enter amount of book : ");
                    int numOfBooks = sc.nextInt();

                    int rated;


                    switch (code) {
                        case "34294" -> { // Manga
                            System.out.print("Enter rated : ");
                            rated = sc.nextInt();
                            sc.nextLine();
                            Manga.addManga(pCode, name, Price, rated, numOfBooks);
                        }
                        case "71207" -> { //Light Novel
                            System.out.print("Enter rated : ");
                            rated = sc.nextInt();
                            sc.nextLine();
                            lightNovel.addLightNovel(pCode, name, Price, rated, numOfBooks);
                        }
                        case "20731" -> { //Novel
                            System.out.print("Enter rated : ");
                            rated = sc.nextInt();
                            sc.nextLine();
                            Novel.addNovel(pCode, name, Price, rated, numOfBooks);
                        }
                        case "40314" -> { //Comic
                            Comic.addComic(pCode, name, Price, numOfBooks);
                        }
                        case "74135" -> { //Tale
                            System.out.print("Enter Language : ");
                            String language = sc.nextLine();
                            Tale.addTale(pCode, name, Price, language, numOfBooks);
                        }
                    }
                    System.out.println("Book has been add.");
                }
                case 2 -> { //Show all book
                    for(int i = 0; i < Sorting.showName().length; i++) {
                        System.out.println(Sorting.showName()[i]);
                    }
                }
                case 3 -> { //Remove book from data
                    System.out.print("Enter Product Code : ");
                    String tmp = sc.nextLine();
                    dic.books.remove(tmp);
                    System.out.print(tmp + " has been removed");
                }
                case 4 -> { //sell book 
                    System.out.print("Enter Product Code : ");
                    String tmp = sc.nextLine();
                    System.out.print("Amount : ");
                    int sell = sc.nextInt();
                    dic.books.get(tmp).sellBook(sell);
                    System.out.println("Amount = " + dic.books.get(tmp).getNumOfBooks());
                    System.out.println();
                }
                case 5 -> { //add book in stock
                    System.out.print("Enter Product Code : ");
                    String tmp = sc.nextLine();
                    System.out.print("Amount : ");
                    int add = sc.nextInt();
                    dic.books.get(tmp).addBook(add);
                    System.out.println("Book in stock has been increaced.");
                    System.out.println("Amount = " + dic.books.get(tmp).getNumOfBooks());
                    System.out.println();
                }
                case 6 -> { //save data of book
                    FileCSV save = new FileCSV();
                    save.saveCSV();

                }
                default -> {
                }
            }
            sc.nextLine(); //Enter any key to continue.
        }
    }
}
