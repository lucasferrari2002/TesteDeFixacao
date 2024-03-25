import Entities.ImportedProduct;
import Entities.Product;
import Entities.UsedProduct;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);
        List<Product> list = new ArrayList<>();



        System.out.print("Enter the number of products: ");
        int n = sc.nextInt();

        for(int i = 0; i < n; i++){
            System.out.println("Product #" +(i+1)+ " data:");
            System.out.print("Common, used or imported (c/u/i)? ");
            char ch = sc.next().charAt(0);
            sc.nextLine();
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Price: ");
            Double price = sc.nextDouble();
            if (ch == 'c'){
                list.add(new Product(name, price));
            } else if (ch == 'u') {
                System.out.print("Manufacture date (DD/MM/YYYY): ");
                LocalDate data = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                list.add(new UsedProduct(name, price, data));

            }else {
                System.out.print("Taxa de importacao: ");
                double customsFee = sc.nextDouble();
                list.add(new ImportedProduct(name, price, customsFee));
            }

        }
        System.out.println();
        System.out.println("ETIQUETAS DE PRECO:");
        for (Product prod : list) {
            System.out.println(prod.priceTag());
        }

        //Teste esteira
























        sc.close();

    }
}