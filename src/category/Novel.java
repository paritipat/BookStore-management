package category;

public class Novel extends book {
    
    protected int rated ;
    
    public Novel(String productCode,String name,int price,int rated,int numOfBooks){
        this.name = name;
        this.productCode = productCode;
        this.price = price;
        this.rated = rated;
        this.numOfBooks = numOfBooks;
    }

    //Add book to the dictionary
    public static void addNovel(String productCode,String name,int price,int rated,int numOfBooks)
    { 
        Data.NvBook[bookType.getNV()] = new Novel( productCode,name, price, rated,numOfBooks);                //Creat object book
        dic.putDictionaryData(Data.NvBook[bookType.getNV()].getProductCode(), Data.NvBook[bookType.getNV()]); //set key = product code 
                                                                                                              //  value = book
        bookType.plusNV(); // increase 1 Novel Book in data
    }

    public int getRated(){
        return this.rated;
    }
}
