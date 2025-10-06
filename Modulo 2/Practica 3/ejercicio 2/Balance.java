
/**
 * Write a description of class Balance here.
 *
 * @author (Manuel Tomas Teves)
 * 
 */

public class Balance
{
    private double price = 0;
    private int items = 0;

    public void iniciarCompra()
    {
        price = 0;
        items = 0;    
    }
    
    public void registrarProducto(double pesoEnKg, double precioPorKg)
    {
        this.price += pesoEnKg*precioPorKg;
        this.items++;
    }
    
    public double devolverMontoAPagar() {
        return this.price;
    }
    
    public String devolverResumenDeCompra() {
        return "Total a pagar " + this.price + "$ por la compra de " + 
        this.items + " productos.";
    }
    
    public Balance()
    {
        this.iniciarCompra();
    }

}