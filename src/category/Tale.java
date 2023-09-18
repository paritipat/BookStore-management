package category;

public class Tale extends book{

    protected String language;

    public Tale(String productCode,String name,int price,String language,int numOfBooks){
        this.name = name;
        this.productCode = productCode;
        this.price = price;
        this.numOfBooks = numOfBooks;
        this.language = language;
    }

    //Add book to the dictionary
    public static void addTale(String productCode,String name,int price,String language,int numOfBooks) 
    { 
        Data.TlBook[bookType.getTL()] = new Tale( productCode,name, price, language,numOfBooks);  //Creat object book
        dic.putDictionaryData(Data.TlBook[bookType.getTL()].getProductCode(), Data.TlBook[bookType.getTL()]); //set key = product code 
                                                                                                              //value = book
        bookType.plusTL(); // increase 1 Tale Book in data
    }
    

    public String getLanguage(){
        return this.language;
    }
}
