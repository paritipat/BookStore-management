package category;

public class Manga extends book {

    protected int rated;

    public Manga(String productCode, String name, int price, int rated, int numOfBooks) {
        this.name = name;
        this.productCode = productCode;
        this.price = price;
        this.rated = rated;
        this.numOfBooks = numOfBooks;
    }

    // Add book to the dictionary
    public static void addManga(String productCode, String name, int price, int rated,int numOfBooks) 
    {
        Data.MgBook[bookType.getMG()] = new Manga(productCode, name, price, rated,numOfBooks);   //Creat object book
        dic.putDictionaryData(Data.MgBook[bookType.getMG()].getProductCode(), Data.MgBook[bookType.getMG()]); //set key = product code 
                                                                                                              //  value = book
        bookType.plusMG(); // increase 1 Manga Book in data
    }
    
    public int getRated() {
        return this.rated;
    }

}
