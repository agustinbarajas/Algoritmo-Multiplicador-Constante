import static javax.swing.JOptionPane.*;

public class AlgoritoMC{
    private String x;
    private int a;
    private int y;
    public int n;
    private int d;
    public float[] r;
    float media;
    public final double alpha = 0.05;
    public final double z = 1.96;
    
    AlgoritoMC(int cN, String sem, int c){
        n= cN;
        r= new float[n];
        x = sem;        
        d= (x+"").length();
        a = c;
    }
    
    public void proceso(){
        for(int i=0;i<n;i++){			
            y= (a*Integer.parseInt(x));
            String sy= y+"";
            int ini= (sy.length()-d)/2;
            int fin= sy.length()-ini;
            if (sy.length()%2==0 && d%2==0 || sy.length()%2!=0 && d%2!=0){
                x= sy.substring(ini, fin);				
                r[i]=Float.parseFloat("0."+x);              
            }else{
                sy= "0"+sy; 
                int ini2= (sy.length()-d)/2;
                int fin2= sy.length()-ini2;
                x= sy.substring(ini2, fin2);
                r[i]=Float.parseFloat("0."+x);
            }                
        }
    }
    public float media(){
        float suma=0;
        for (int i = 0; i < n; i++) {
            suma += r[i]; 
        }
        media = suma/n;
        return media;
    }
    
    public double limiteI(){
        double t= 0.5 - z*(1/(Math.sqrt(12*n)));
        return t;
    }
    public float[] bubbleSort(float[] arr){
        float aux, bandera, n = arr.length;
        int i, j;
        for (i = 0; i < n-1; i++) {
            bandera = 0;
            for (j = 0; j < n-i-1; j++) {
                if (arr[j] > arr[j+1]) {
                    aux = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = aux;
                    bandera = 1;
                }
            }
            if (bandera == 0) {
                break;
            }
        }
        return arr;
    }
    
    public double limiteS(){
        double t= 0.5 + z*(1/(Math.sqrt(12*n)));
        return t;
    }
    
    public String medias(){ 
        int abajo=0, arriba=0;
        for (int i = 0; i < n; i++) {
            if (r[i]<media()) {
                abajo++;
            }else{
                arriba++;
            }
        }
        String cad = "\nAbajo = "+abajo+"\nArriba = "+arriba;
        return cad;
    }
    public String hipotesis(){
       double li = limiteI(), ls = limiteS(), media = media();
    if(li<=media && media <= ls){
        return "No existe evidencia estadistica para rechazar "
                + "\nla hipotesis 0 por lo tanto la media de los "
                + "\nnumeros pseudoaleatorios si es igual a 0.5";
    }else{
        return "Existe evidencia estadistica para rechazar "
                + "\nla hipotesis 0 por lo tanto la media de los "
                + "\nnumeros pseudoaleatorios es distinto a 0.5"; 
        }
    }
}
