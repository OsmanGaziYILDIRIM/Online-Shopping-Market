public class Main {
    public static void main(String[] args) {
        ReadFromFile shoppingFile = new ReadFromFile();
        String[] shoppingList = shoppingFile.readFile(args[0]);  //reading shoppingList.txt

        ReadFromFile priceFile = new ReadFromFile();
        String[] priceList1 = priceFile.readFile(args[1]);   //reading priceList.txt

        PriceListMatris priceListMatris = new PriceListMatris();
        String[][] matris = priceListMatris.priceListMatris(priceList1);   // creating a matris for prriceList

        WriteBill writeOutput = new WriteBill();
        writeOutput.writeBill(shoppingList, matris);   //printing bill
    }
}