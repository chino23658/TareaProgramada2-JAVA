import java.lang.reflect.Array; 
import java.util.*; 
public class scanner { 
      
    String abc = "()ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvwxyz0123456789*/+&;_:,.-\n\r"; 
    Character[] simbolos = new Character[abc.length()]; 
    List<Character> lista; 
    int lenght; 
    public boolean scannear(String[] base){ 
        for(int i = 0; i<simbolos.length;i++){ 
            simbolos[i]=new Character(abc.charAt(i)); 
        } 
        lista = Arrays.asList(simbolos); 
        boolean flag = false; 
        boolean resultado = true; 
        lenght = base.length; 
        for (int i=0;i<lenght;i++){ 
            char [] contenido = base[i].toCharArray(); 
            for(Character c: contenido){ 
                flag = lista.contains(c); 
                if(flag == false){ 
                    System.out.println("El caracter "+c+" no es una caracter valido"); 
                    resultado=false; 
                } 
            } 
        }
        return resultado;
              
    }
    
    
} 