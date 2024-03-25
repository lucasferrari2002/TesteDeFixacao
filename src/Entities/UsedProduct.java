package Entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class UsedProduct extends Product{
    private LocalDate manufacture;

    public UsedProduct(String name, Double price, LocalDate manufacture) {
        super(name, price);
        this.manufacture = manufacture;
    }

    public LocalDate getManufacture() {
        return manufacture;
    }

    public void setManufacture(LocalDate manufacture) {
        this.manufacture = manufacture;
    }
    @Override
    public String priceTag(){
        return getName()
                + " (used) $ "
                + String.format("%.2f", getPrice())
                + " (Manufacture date: "
                + manufacture.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
                + ")";
    }
}
