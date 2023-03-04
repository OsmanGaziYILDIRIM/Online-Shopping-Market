import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class WriteBill {
    public void writeBill(String[] shoppingList,String[][] matris) {

        for (String line : shoppingList) {
            String[] list = line.split("\t");
            Customer customer = new Customer();// creating new customer
            Products product = new Products(); // creating new product
            double count = 0;
            for (int i = 0; i < list.length; ) {
                if (i < 3) {
                    customer.setName(list[i++]);
                    System.out.println("---" + customer.getName() + "---");//printing customer name
                    customer.setMembershipType(list[i++]);
                    customer.setShoppingDate(list[i++]);
                }
                product.setProductName(list[i++]);
                String number = list[i++];
                int quantity = Integer.parseInt(number.trim());
                product.setQuantity(quantity);
                System.out.print(product.getProductName() + "\t"); //printing product name

                for (int j = 0; j < matris.length; j++) {
                    if ((matris[j][0].equals(product.getProductName())) && (matris[j][1].equals(customer.getMembershipType()))) { // controlling product name and type of membership
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
                        Date dateStart = null;
                        try {
                            dateStart = simpleDateFormat.parse(matris[j][2]);
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        Date dateFinish = null;
                        try {
                            dateFinish = simpleDateFormat.parse(matris[j][3]);
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        Date dateShopping = null;
                        try {
                            dateShopping = simpleDateFormat.parse(customer.getShoppingDate());
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        Boolean first = dateShopping.before(dateFinish);
                        Boolean second = dateShopping.after(dateStart); //28-48  controlling to dates
                        if (first && second) {
                            String amount = matris[j][4];
                            double sum = Double.parseDouble(amount.trim());
                            System.out.print(matris[j][4] + "\t" + product.getQuantity() + "\t" + product.getQuantity() * sum + "\n");//printing product quantity and price
                            count += product.getQuantity() * sum;
                        }
                    }
                }
            }
            System.out.print("Total" + "\t" + count + "\n");//printing total price
        }
    }
}