import category.*;

public class SellGUI { //method in this class for using with GUI

    private static String arraySell[] = new String[100]; //get Name from product code text field
    private static String arrayProductCode[] = new String[100]; // get product code from product code text field
    private static Integer arrayNumBook[] = new Integer[100]; // get from amount text field
    private static int i = 0; // important attribute for looping and set index in array 

    public static void addToCart(String productCodeTextField,int amountTextField){ // add book to cart
        arraySell[i] = dic.books.get(productCodeTextField).getName();
        arrayProductCode[i] = dic.books.get(productCodeTextField).getProductCode();
        arrayNumBook[i] = amountTextField; //amount that customer want to buy
        i++;
    }

    public static int totalPrice(){ // return total price of book in cart.
        int totalPrice=0;
        for(int j=0;j<i;j++){
            totalPrice += dic.books.get(arrayProductCode[j]).getPrice()
            *arrayNumBook[j];
        }
        return totalPrice;
    }

    public static void sellInCart(){ // confirm the sale
        for(int j=0;j<i;j++){
            if(dic.books.get(arrayProductCode[j]).getNumOfBooks()>=arrayNumBook[j]){
                dic.books.get(arrayProductCode[j]).sellBook(arrayNumBook[j]);
            }else{
                System.out.println("Lack of stock.");
            }
        }
        i = 0;
    }

    public static String[] getArraySell() {
        return arraySell;
    }
    
    public static void setArraySell(String[] newArray) {
        arraySell = newArray;
    }

    public static Integer[] getArrayNumBook(){
        return arrayNumBook;
    }

    public static void setArrayNumBook(Integer[] newArray){
        arrayNumBook = newArray;
    }
    
    public static String[] getArrayProductCode(){
        return arrayProductCode;
    }

    public static void setArrayProductCode(String[] newArray){
        arrayProductCode = newArray;
    }

    public static int getI(){
        return i;
    }

    public static void setI(int set){
        i = set;
    }

}
