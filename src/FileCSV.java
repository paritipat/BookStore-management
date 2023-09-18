import java.io.*;
import category.*;
import java.util.*;

public class FileCSV {
    
    public void readCSV(String pathName) { // read CSV file and create object by using data in file CSV 

        File f = new File(pathName);
        FileReader fr = null;
        BufferedReader br = null;

        String s = "";
        int price, age, numBooks;

        // <Load data from exel>
        try {
            fr = new FileReader(f);
            br = new BufferedReader(fr);
            while ((s = br.readLine()) != null) {

                String[] colum = s.split(",");

                switch (colum[0]) {
                    case "Manga" -> {
                        price = Integer.parseInt(colum[3]);
                        age = Integer.parseInt(colum[4]);
                        numBooks = Integer.parseInt(colum[5]);
                        Manga.addManga(colum[1], colum[2], price, age,numBooks);
                    }

                    case "Novel" -> {
                        price = Integer.parseInt(colum[3]);
                        age = Integer.parseInt(colum[4]);
                        numBooks = Integer.parseInt(colum[5]);
                        Novel.addNovel(colum[1], colum[2], price, age, numBooks);
                    }

                    case "LightNovel" -> {
                        price = Integer.parseInt(colum[3]);
                        age = Integer.parseInt(colum[4]);
                        numBooks = Integer.parseInt(colum[5]);
                        lightNovel.addLightNovel(colum[1], colum[2], price, age, numBooks);
                    }

                    case "Comic" -> {
                        price = Integer.parseInt(colum[3]);
                        numBooks = Integer.parseInt(colum[4]);
                        Comic.addComic(colum[1], colum[2], price, numBooks);
                    }

                    case "Tale" -> {
                        price = Integer.parseInt(colum[3]);
                        numBooks = Integer.parseInt(colum[5]);
                        Tale.addTale(colum[1], colum[2], price, colum[4],numBooks);
                    }
                    default -> {
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Something Wrong!!!!");
        } finally {
            try {
                br.close();
                fr.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public void saveCSV() { // save data to CSV file

        File f2 = new File("Bookdata.csv");
        if (f2.delete()) {} // Clear CSV file
        else {
            System.out.println("Error. Can't delete file.");
        }

        FileWriter fw = null;
        BufferedWriter bw = null;

        // <Save data to exel>
        try {
            fw = new FileWriter(f2, true);
            bw = new BufferedWriter(fw);

            Enumeration book = dic.books.keys();

            String stringPdCode; // ProductCode (Key)

            while (book.hasMoreElements()) {

                stringPdCode = (String) book.nextElement(); // get product code of book from object book to stringPdCode

                if (stringPdCode.contains("34294")) { // Manga

                    bw.write("Manga,");
                    bw.write(dic.books.get(stringPdCode).getProductCode() + ",");
                    bw.write(dic.books.get(stringPdCode).getName() + ",");
                    bw.write(dic.books.get(stringPdCode).getPrice() + ",");
                    bw.write(((Manga) dic.books.get(stringPdCode)).getRated() + ",");
                    bw.write(dic.books.get(stringPdCode).getNumOfBooks() + "\n");

                } else if (stringPdCode.contains("71207")) { // Light Novel

                    bw.write("LightNovel,");
                    bw.write(dic.books.get(stringPdCode).getProductCode() + ",");
                    bw.write(dic.books.get(stringPdCode).getName() + ",");
                    bw.write(dic.books.get(stringPdCode).getPrice() + ",");
                    bw.write(((lightNovel) dic.books.get(stringPdCode)).getRated() + ",");
                    bw.write(dic.books.get(stringPdCode).getNumOfBooks() + "\n");

                } else if (stringPdCode.contains("20731")) { // Novel

                    bw.write("Novel,");
                    bw.write(dic.books.get(stringPdCode).getProductCode() + ",");
                    bw.write(dic.books.get(stringPdCode).getName() + ",");
                    bw.write(dic.books.get(stringPdCode).getPrice() + ",");
                    bw.write(((Novel) dic.books.get(stringPdCode)).getRated() + ",");
                    bw.write(dic.books.get(stringPdCode).getNumOfBooks() + "\n");

                } else if (stringPdCode.contains("40314")) { // Comic

                    bw.write("Comic,");
                    bw.write(dic.books.get(stringPdCode).getProductCode() + ",");
                    bw.write(dic.books.get(stringPdCode).getName() + ",");
                    bw.write(dic.books.get(stringPdCode).getPrice() + ",");
                    bw.write(dic.books.get(stringPdCode).getNumOfBooks() + "\n");

                } else if (stringPdCode.contains("74135")) { // Tale

                    bw.write("Tale,");
                    bw.write(dic.books.get(stringPdCode).getProductCode() + ",");
                    bw.write(dic.books.get(stringPdCode).getName() + ",");
                    bw.write(dic.books.get(stringPdCode).getPrice() + ",");
                    bw.write(((Tale) dic.books.get(stringPdCode)).getLanguage() + ",");
                    bw.write(dic.books.get(stringPdCode).getNumOfBooks() + "\n");

                }
            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Something Wrong!!!!");
        } finally {
            try {
                bw.close();
                fw.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
    
}