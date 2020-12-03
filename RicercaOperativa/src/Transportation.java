import java.util.Formatter;

public class Transportation {

    private int stock;
    private int required;
    private double value;

    public Transportation() {
        this.stock = 0;
        this.required = 0;
    }

    public Transportation(int stock, int required) {
        this.stock = stock;
        this.required = required;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getRequired() {
        return required;
    }

    public void setRequired(int required) {
        this.required = required;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        Formatter f = new Formatter();
        f.format("Quantità[U.P.%d->D%d]=%f", this.stock + 1, this.required + 1, this.value);
        return f.toString();
    }


}