import java.util.*;
import category.*;

public class Sorting {
    
    private static String[] sortedProduct; //Array of books sorted by method sortProduct
    private static int ArrSize ;

    public static String[] sortProcuct() { // Sorting books in alphabetical order of product code
        
        Enumeration FindSize = dic.books.keys();
        Enumeration book = dic.books.keys();
        ArrSize = 0;
        while (FindSize.hasMoreElements()) { // Find amount of object for size of Array 
            FindSize.nextElement();
            ArrSize++; 
        }

        sortedProduct = new String[ArrSize];
        String stringPdCode; // ProductCode (Key)
        int i = 0;
        while (book.hasMoreElements()) {
            stringPdCode = (String) book.nextElement(); // get product code of book from object book
            sortedProduct[i] = dic.books.get(stringPdCode).getProductCode(); 
            i++;
        }
        Arrays.sort(sortedProduct); // Sort books in alphabetical order

        return sortedProduct;
    }

    public static String[] showName() {  //Sorting product code for show in list
        
        sortProcuct();
        String[] bookName = new String[ArrSize];

        for(int i = 0; i < bookName.length; i++) {
            bookName[i] = dic.books.get(sortProcuct()[i]).getName();
        }
        return bookName;
    }
    
    public static String[] showProductCode() {  //Sorting product code for show in list
        
        sortProcuct();
        String[] product = new String[ArrSize];

        for(int i = 0; i < product.length; i++) {
            product[i] = dic.books.get(sortProcuct()[i]).getProductCode();
        }
        return product;
    }

    public static Integer[] showPrice() {  //Sorting price for show in list
        
        sortProcuct();
        Integer[] price = new Integer[ArrSize];            
        for (int i = 0; i < price.length; i++) {
            price[i] = dic.books.get(sortProcuct()[i]).getPrice();
        }
        return price;
    }
    
    public static Integer[] showAmount() {  //Sroting amount for show in list
        
        sortProcuct();
        Integer[] amount = new Integer[ArrSize];

        for (int i = 0; i < amount.length; i++) {
            amount[i] = dic.books.get(sortProcuct()[i]).getNumOfBooks();
        }
        return amount;
    }

    public static int getAllAmount(){ // get amount of all books in data

        Enumeration book = dic.books.keys();
        String stringPdCode;
        int AllAmount = 0;

        while (book.hasMoreElements()) {
            stringPdCode = (String)book.nextElement(); // get product code of book from object book
            AllAmount+=dic.books.get(stringPdCode).getNumOfBooks();
        }
        return AllAmount; //Amount of all books in the store
    }
}
                     