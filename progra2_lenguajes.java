import java.util.*;
public class progra2_lenguajes {
    
    public static void main(String[] args) {
    
        lista nueva = new lista();   
        String base[]; 
        base = new String[6];  
        base[0]="perro(ruffo)."; 
        //base[1]="perro(alonso)."; 
        //base[2]="perro(fofis)."; 
        //base[3]="agrada(alonso,esteban)."; 
        base[1]="agradajavier,fofis)."; 
        //base[1]="agrada(X,Y):-agrada(Y,Z)&perro(Z);bonito(T).";
        //solucion c = new solucion(); 
        //c.Unificadas = nueva; 
        //boolean inferencia = c.solu("agrada(alonso,javier).", base, nueva);
        //c.Resultados.Imprimir(); 
        //System.out.println(inferencia); 
        //c.write("write(juanito mora).",nueva);
        //boolean bandera = false;
        //Main a = new Main();
        //boolean flag;
        //flag= a.parsear(base,2);
		//System.out.println(a.parsear(base,2));
        ModoAdministracion panel = new ModoAdministracion();
        panel.setVisible(true);
        
    }
}

