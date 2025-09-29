public class triangulo
{
    private double A;
    private double B;
    private double C;
    private String CLinea;
    private String CRelleno;
    
    public triangulo(){};
    public triangulo(double a, double b, double c, String Linea, String Relleno)
    {
        this.A=a;
        this.B=b;
        this.C=c;
        this.CLinea=Linea;
        this.CRelleno=Relleno;
    }
    
    public double getLadoA()
    {
        return A;
    }   
    public double getLadoB()
    {
        return B;
    }
    public double getLadoC()
    {
        return C;
    }
    public String getColorLinea()
    {
        return CLinea;
    }
    public String getColorRelleno()
    {
        return CRelleno;
    }
    public void setLadoA(double LadoA)
    {
        A = LadoA;
    }
    public void setLadoB(double LadoB)
    {
        B = LadoB;
    }
    public void setLadoC(double LadoC)
    {
        C = LadoC;
    }
    public void setColorLinea(String Linea)
    {
        CLinea = Linea;
    }
    public void setColorRelleno(String Relleno)
    {
        CRelleno = Relleno;
    }    
    
    public boolean EsTriangulo()
    {
        boolean T = (C>=A) && (C>=B) && (C<B+A); 
        return T;
    }
    
    public double calcularArea()
    {
        double s = (A + B + C) / 2;
        return Math.sqrt(s * (s-A) * (s-B) * (s-C));
    }
    
    public double calcularPerimetro()
    {
        return A+B+C;
    }
}