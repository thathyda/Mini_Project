import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;

public class Products {

    private Integer id;

    private String name;

    private Integer qty;

    private Double price;

    private LocalDate importedDate;

    /* Create constructor */
    public Products(int id, String name, Integer qty, Double price, LocalDate importedDate) {
        this.id = id;
        this.name = name;
        this.qty = qty;
        this.price = price;
        this.importedDate = importedDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        return "Products{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", qty=" + qty +
                ", price=" + price +
                ", importedDate=" + importedDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Products products = (Products) o;
        return Objects.equals(id, products.id) && Objects.equals(name, products.name) && Objects.equals(qty, products.qty) && Objects.equals(price, products.price) && Objects.equals(importedDate, products.importedDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, qty, price, importedDate);
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public LocalDate getImportedDate() {
        return importedDate;
    }

    public void setImportedDate(LocalDate importedDate) {
        this.importedDate = importedDate;

    }
}
