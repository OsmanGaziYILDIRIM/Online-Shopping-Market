public class PriceListMatris {
    public String[][] priceListMatris(String[] priceList1) {
        String[][] matris = new String[priceList1.length][5];
        int i = 0;
        for (String line : priceList1) { // creating matris of priceList
            String[] list = line.split("\t");
            for (int k = 0; k < 5; k++) {
                matris[i][k] = list[k];
            }
            i++;
        }
        return matris;// return matris of priceList
    }
}