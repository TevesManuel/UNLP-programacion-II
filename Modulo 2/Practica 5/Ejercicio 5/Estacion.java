
/**
 *
 * @author (Manuel Tomas Teves)
 *
 */
public class Estacion
{
    private final static double INF = 9999.9;
    private int dimF;
    private final static int DIMC = 12;//Cantidad de meses
 
    private double [][]TEMP;
    private String nombre;
    private double latitud;
    private double longuitud;
    private int refYear;

    public Estacion(int A, int N, String nombre, double latitud, double longuitud)
    {
        this.nombre = nombre;
        this.latitud = latitud;
        this.longuitud = longuitud;
        this.refYear = A;
        this.dimF = N;
        this.TEMP = new double[N][this.DIMC];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < this.DIMC; j++) {
                this.TEMP[i][j] = this.INF;
            }
        }
    }
    
    public Estacion(int A, int N)
    {
        this(A, N, "La Plata", -34.921, -57.955);
    }

    public void registrar(int A, int M, double temp) {
        this.TEMP[A-this.refYear][M-1] = temp;  
    }
    
    public String reportar(int A, int M) {
        return M+"/"+A+": "+this.TEMP[A-this.refYear][M-1]+"°C";
    }
    
    public String max() {
        String salida = "null";
        double max = 0.0;
        for(int i = 0; i < this.dimF; i++) {
            for(int j = 0; j < this.DIMC; j++) {
                if(this.TEMP[i][j] > max) {
                    max = this.TEMP[i][j];
                    salida = this.reportar(i+this.refYear, j+1);
                }
            }
        }
        return salida;
    }
    
    private String getPos() {
        String salida = this.nombre + " (" + Math.abs(this.latitud);
        if(this.latitud > 0) {
            salida += " N";
        } else {
            salida += " S";
        }
        salida += " - " + Math.abs(this.longuitud);
        if(this.longuitud > 0) {
            salida += " E";
        } else {
            salida += " O";
        }
        salida += ")";
        return salida;
    }
    
    public String getReporteAnual() {
        String salida = this.getPos() + ":\n";
        double sum = 0.0;
        int j;
        for(int i = 0; i < this.dimF; i++) {
            sum = 0.0;
            for(j = 0; j < this.DIMC; j++) {
                sum += this.TEMP[i][j];
            }
            salida += "\tAño " + (i + this.refYear) + ": " + (sum/this.DIMC) + "°C\n";
        }
        return salida;
    }
    
    public String getReporteMensual() {
        String salida = this.getPos() + ":\n";
        double sum = 0.0;
        int j;
        
        for(int i = 0; i < this.DIMC; i++) {
            sum = 0.0;
            for(j = 0; j < this.dimF; j++) {
                sum += this.TEMP[j][i];
            }
            salida += "\tMes " + i + ": " + (sum/this.dimF) + "°C\n";
        }
        return salida;
    }
    
    public static void main(String args[]) {//Tranquilamente se podria crear un archivo app y mover este codigo alla.
        Estacion e = new Estacion(2021, 3);//La Plata
        for(int i = 2021; i < 2024; i++) {
            for(int j = 1; j <= 12; j++) {
                e.registrar(i, j, ((j+i-2021)/24.0)*20.0);
                //System.out.println(e.reportar(i, j));
            }   
        }
        System.out.print("Reporte anual:\n" + e.getReporteAnual());
        System.out.print("La temperatura maxima fue " + e.max() + "\n");
        
        Estacion mp = new Estacion(2020, 4, "Mar del Plata", -38.002, -57.556);
        
        for(int i = 2020; i < 2024; i++) {
            for(int j = 1; j <= 12; j++) {
                mp.registrar(i, j, ((j+i-2021)/24.0)*20.0);
                //System.out.println(mp.reportar(i, j));
            }   
        }
        System.out.print("Reporte mensual:\n" + mp.getReporteMensual());
        System.out.print("La temperatura maxima fue " + mp.max() + "\n");
        
    }
}
/**⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⢀⠀⣿⡂⢹⡇⠀⠀⣰⠄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⢸⡇⢸⣇⢸⣇⠀⢀⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠾⠀⠀⣏⠀⡆⠀⠀
⢸⣷⢸⣇⣸⣇⠀⣾⠏⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣀⣀⣀⣠⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢲⣂⠀⣿⡄⢸⡀⣤
⢠⣿⣿⣿⣿⣿⣿⠇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣾⣿⣿⣊⡝⠛⠙⠂⠄⠠⠀⠀⠀⠀⠀⠀⡀⠀⠄⠀⢀⠀⠀⠀⠀⠀⠀⠀⠀⠈⢿⣦⣼⣷⣼⣁⠼
⢸⣿⣿⣿⣿⣿⣿⣀⢀⣀⣀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣰⣿⣿⣿⣿⡻⣥⢋⡔⡀⠀⠀⠀⠀⠂⠁⠀⠄⠀⠠⠀⠂⢀⠀⠐⠈⠀⢀⠠⢀⣀⡀⠘⣿⡟⢿⣿⣿⣄
⠈⣿⣿⣿⣿⣿⣿⣿⠿⠋⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⣷⢯⣿⣾⡔⠀⠀⠀⠀⠀⠂⢁⠠⠈⢀⠐⠀⠂⡀⠂⠠⠈⠀⠀⠉⠁⠁⣀⣈⠧⠈⠻⣿⣿
⠀⣿⣿⣟⢿⠿⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢻⣿⡟⠛⠉⡉⢸⡉⠁⢀⠀⠀⠀⠀⠠⢁⠂⡐⢈⠀⠂⡁⠂⠄⢁⠂⠄⠡⠈⠄⠂⠄⡈⠀⠂⡁⠀⢻⠇
⠀⣿⣿⣿⡏⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠺⣿⡇⣤⡤⢔⡿⣇⠀⢦⠀⠀⠀⠀⠐⣀⠂⡐⠠⢈⡐⠠⠁⠌⡀⠂⠌⠠⠁⡌⢐⠂⠔⡈⠆⣔⣠⣯⠀
⠘⡟⣛⠋⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⡇⣿⣿⠗⡲⠏⠟⠿⠀⠈⠓⠀⠀⠀⠡⡀⠆⣁⠢⢁⠤⠑⡨⠐⠤⠑⡨⠐⡡⠐⡌⢌⠒⡄⠈⠉⠁⠁⠀
⠃⡜⡠⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⣼⣿⡟⢡⡿⠿⠷⠀⠀⠀⠀⠀⢀⠱⣀⠣⢄⠢⡁⢆⠱⢠⠉⢆⠱⣀⠣⡐⠡⢌⠢⡘⠤⡁⠐⠒⠂⠂
⠐⠐⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠂⠀⠀⢻⠸⣡⢶⣿⣟⡃⠀⠘⠀⠀⢆⠡⢂⡜⢠⠃⡜⢠⢃⠦⣉⠦⡑⢢⡑⠬⡑⡌⢢⢑⠢⠅⠀⠀⡀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡀⠀⠐⠀⢁⡰⢸⠣⠉⠉⠋⠉⠀⠀⠀⠀⠈⠀⠣⢡⠜⢢⠩⢔⢣⡘⢲⡐⠦⣙⠢⣌⠓⣌⠲⡡⢎⠥⠃⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣰⣶⡶⠆⠁⠠⠁⠊⠐⠁⠈⠠⠄⠂⠉⠈⠖⠀⠀⠒⣶⢦⡁⠂⠀⠀⠀⠀⠀⠀⠀⠀⠘⠃⠁⠀⠀⠀⠁⠈⠱⢌⠳⣌⠳⣌⢣⡕⢮⡘⡅⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⠿⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠂⠀⠀⠏⠈⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠁⠘⡳⢬⠳⡜⢦⡹⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠉⠁⠋⠧⠹⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⠀⠃⢈⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠠⠀⠀⠠⠐⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠓⠂⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢈⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⡀⠀⢀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⢶⠀⡶⣲⠀⣆⡒⣰⠒⢦⢰⠀⢰⡆⣴⠐⣶⠒⣐⣒⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣠⣴⣺⣿⣿⣿⠛
⠀⠀⠀⠀⠀⠀⠐⠀⠈⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠞⠚⠃⠻⠴⠃⠦⠝⠘⠤⠎⠸⠤⠘⠧⠞⠀⠛⠀⠰⠤⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣼⡟⣾⣿⣿⣿⠃⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣤⣤⣤⣄⠀⠀⢠⣤⠀⠀⣤⣄⠀⠀⠀⣤⣤⠀⢠⣤⣤⣤⣤⣤⡄⢠⣤⣄⠀⠀⠀⠀⣤⣤⡄⠀⠀⠀⢠⣤⡄⠀⠀⠀⢘⡮⡝⣿⣿⡿⢆⠁⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣰⣿⠏⠉⠉⢿⣷⠀⢸⣿⠀⠠⣿⣿⣧⡀⠀⣿⣿⠀⢸⣿⡏⠉⠉⠉⠁⢼⣿⣿⡄⠀⠀⢸⡿⣿⡇⠀⠀⢀⣿⢻⣷⠀⠀⠀⡞⡜⣹⣿⣿⡙⢆⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⠀⠀⠀⠀⠀⠀⢸⣿⠀⠐⣿⡯⢻⣷⡀⣿⣿⠀⢸⣿⣷⣶⣶⡆⠀⢺⣿⠹⣿⡀⢠⣿⠃⣿⡇⠀⠀⣾⡟⠀⢿⣧⠀⠀⢣⠣⢽⣿⣯⡙⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢿⣿⡀⠀⠀⣠⣤⠀⢸⣿⠀⢈⣿⡧⠀⠹⣿⣿⣿⠀⢸⣿⡇⠀⠀⠀⠀⢸⣿⡄⢻⣧⣾⡏⢠⣿⡇⠀⣼⣿⣷⣶⣾⣿⣇⠀⠀⠱⢸⣿⢣⠜⠁⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⢿⣿⣶⣾⣿⠏⠀⢸⣿⠀⠀⣿⡷⠀⠀⠹⣿⣿⠀⢸⣿⣿⣿⣿⣿⡆⢸⣿⡆⠀⢿⡿⠀⢰⣿⡇⢀⣿⡏⠀⠀⠀⢹⣿⡀⠀⢁⢸⡇⠈⡆⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠉⠉⠀⠀⠀⠈⠉⠀⠀⠉⠁⠀⠀⠀⠉⠉⠀⠈⠉⠉⠈⠉⠉⠁⠈⠉⠀⠀⠈⠁⠀⠀⠉⠁⠈⠉⠀⠀⠀⠀⠈⠉⠁⠐⡀⢸⡐⠁⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠁⠀⢘⠀⠀⠀⠀⠀⠀
*/