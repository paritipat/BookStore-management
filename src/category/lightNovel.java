package category;

public class lightNovel extends book {

    protected int rated ;

    public lightNovel(String productCode,String name,int price,int rated,int numOfBooks){
        this.name = name;
        this.productCode = productCode;
        this.price = price;
        this.rated = rated;
        this.numOfBooks = numOfBooks;
    }

     //Add book to the dictionary
    public static void addLightNovel(String productCode,String name,int price,int rated,int numOfBooks)
    {
        Data.LnvBook[bookType.getLNV()] = new lightNovel(productCode,name, price, rated,numOfBooks);  //Creat object book
        dic.putDictionaryData(Data.LnvBook[bookType.getLNV()].getProductCode(), Data.LnvBook[bookType.getLNV()]); //set key = product code 
                                                                                                                  //value = book
        bookType.plusLNV(); // increase 1 Light Novel Book in data
    }

    public int getRated(){
        return this.rated;
    }

}
