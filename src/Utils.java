import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.lang.*;
public class Utils {

    static ArrayList<Products> products = new ArrayList<>();// static
    Scanner scanner = new Scanner(System.in);
    static Integer index ; // declare variable
    // put static no need to make object
    static String Ascii = """
               ______    ______   ________   ______   _______            _____   ______   __     __   ______ \s
             /      \\  /      \\ |        \\ /      \\ |       \\          |     \\ /      \\ |  \\   |  \\ /      \\\s
            |  $$$$$$\\|  $$$$$$\\ \\$$$$$$$$|  $$$$$$\\| $$$$$$$\\          \\$$$$$|  $$$$$$\\| $$   | $$|  $$$$$$\\
            | $$   \\$$| $$___\\$$   | $$   | $$__| $$| $$  | $$            | $$| $$__| $$| $$   | $$| $$__| $$
            | $$       \\$$    \\    | $$   | $$    $$| $$  | $$       __   | $$| $$    $$ \\$$\\ /  $$| $$    $$
            | $$   __  _\\$$$$$$\\   | $$   | $$$$$$$$| $$  | $$      |  \\  | $$| $$$$$$$$  \\$$\\  $$ | $$$$$$$$
            | $$__/  \\|  \\__| $$   | $$   | $$  | $$| $$__/ $$      | $$__| $$| $$  | $$   \\$$ $$  | $$  | $$
             \\$$    $$ \\$$    $$   | $$   | $$  | $$| $$    $$       \\$$    $$| $$  | $$    \\$$$   | $$  | $$
              \\$$$$$$   \\$$$$$$     \\$$    \\$$   \\$$ \\$$$$$$$         \\$$$$$$  \\$$   \\$$     \\$     \\$$   \\$$
                
                
                   
                                                                                                \s""";

    static void printMenu() {
        System.out.println("*)Display | W)rite  | R)ead     | U)pdate  | F)irst  | P)revious  | N)ext  | L)ast" + "\n" +
                "S)earch   | G)oto   | Se)t row  | H)elp    | E)xit");


    }

    // String Option it's mean function have parameter
    void handleOption(String option) {

        switch (option) {
            case "*":
                displayProducts();
                break;
            case "w":
                writeProducts();
                break;
            case "r":
                readProducts();
                break;
            case "u":
                updateProducts();
                break;
            case "d":
                deleteProducts(products);
                break;
            case "f":
                System.out.println("f");
                break;
            case "p":
                System.out.println("p");
                break;
            case "n":
                System.out.println("n");
                break;
            case "l":
                System.out.println("l");
                break;
            case "s":
                searchProducts();
                break;
            case "h":
                helpMenu();
                break;
            case "e" :
                System.exit(0);
            default:
                System.out.println("Invalid Option");
        }
        printMenu();
        System.out.print("Command ———>");
        option = scanner.nextLine();

        // invoke either class ("Utils class : handle option ")
        Utils utils = new Utils();
        utils.handleOption(option);


    }

    void writeProducts() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Product ID : ");
        Integer id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Product's name : ");
        String name = scanner.nextLine();
        System.out.print("Product's Price : ");
        Integer qty = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Product's Qty : ");
        Double price = scanner.nextDouble();

        // Write Product to list
        products.add(new Products(id, name, qty, price, LocalDate.now()));
        System.out.println("Product size" + products.size());
    }

    void displayProducts() {
        for (Products ID : products) {
            System.out.println(ID.getId());
            System.out.println(ID.getName());
            System.out.println(ID.getQty());
            System.out.println(ID.getPrice());
            System.out.println(ID.getImportedDate());
        }
    }

    void deleteProducts(List<Products> productsList) {
        System.out.println("Please choose product you want to delete !");
        System.out.println("Are you sure want to delete this record ? [Y/y] or [N/n]");
        System.out.println("Product was Remove ");
        Integer deleteID = scanner.nextInt();
        for (Products products1 : productsList) {
            if (deleteID == products1.getId()) {
                productsList.remove(products1);
            }
        }
    }
      void updateProducts(){
          readProducts();
          System.out.println("Update Menu");
          System.out.println("1.Update All");
          System.out.println("2.Update Name ");
          System.out.println("3.Update Qty");
          System.out.println("4.Update Price");

          List<Products> menu = new ArrayList<>();
          System.out.println("What do you want to Update ?");
          Integer id = scanner.nextInt();
          scanner.nextLine();

          switch (id)
          {
              case 1:
                  System.out.println("2.Update Name");
                  String name = scanner.nextLine();
                  products.get(index).setName(name);
                  System.out.println("3.Update Qty");
                  Integer qty = scanner.nextInt();
                  products.get(index).setQty(qty);
                  System.out.println("4.Update Price");
                  Double price = scanner.nextDouble();
                  products.get(index).setPrice(price);
                  break;
              case 2:
                  System.out.println("2.Update Name");
                  String name1 = scanner.nextLine();
                  products.get(index).setName(name1);
                  break;
              case 3:
                  System.out.println("3.Update Qty");
                  Integer qty1 = scanner.nextInt();
                  products.get(index).setQty(qty1);
                  break;
              case 4:
                  System.out.println("4.Update Price");
                  Double price1 = scanner.nextDouble();
                  products.get(index).setPrice(price1);
                  break;
              case 5:
                  break;
              default:

          }

      }
      void readProducts(){
        System.out.println("Please Input ID of product's");
        Integer searchID = scanner.nextInt();
          boolean isFound = true;
          for (int i =0 ; i < products.size(); i++  ) {
              if (searchID.equals(products.get(i).getId())){
                  System.out.println(products.get(i));
                  index = i;
                  isFound= true;
          }
          }
          if (!isFound){
              System.out.println("Not Found");
          }
           
      }
      void searchProducts(){
          System.out.println("Search by Name Products");
          String nameProducts = scanner.nextLine();
          boolean isFound = true;
          for (Products productsSearch : products ) {
              if (nameProducts.equals(productsSearch.getName())){
                  System.out.println(productsSearch);
                  isFound = true;
              }
          }
          if (!isFound){
              System.out.println("Name of bound ");
          }
      }
      void helpMenu(){
          System.out.println("Help Menu ");
          System.out.println("1. Press * : Display all record of products ");
          System.out.println("2. Press w : Add new product " +
                                "Press w -> #proname-unit-price-qty : shortcut for add new product  "            );
          System.out.println("3. Press r : read Content any content " +"\n"+
                                "Press r#proId : shortcut for read product by Id ");
          System.out.println("4. Press u : Update Data ");
          System.out.println("5. Press d : Delete Data " +"\n"+
                                "Press d#proId : shortcut for delete product by Id");
          System.out.println("6. Press f : Display First Page ");
          System.out.println("7. Press p : Display Previous Page ");
          System.out.println("8. Press n : Display Next Page ");
          System.out.println("9. Press l : Display Next Page ");
          System.out.println("10.Press s : Search product by name ");
          System.out.println("11.Press h : Help ");
      }
}

