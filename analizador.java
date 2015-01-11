import java.lang.reflect.Array;
import java.util.*;
import java.lang.*;
public class analizador {
	String abc = "()ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvwxyz0123456789*/+;_:,.-";
	Character[] simbolos = new Character[abc.length()];
	List<Character> lista;
	int lenght;
	public void scannear(String[] base){
		for(int i = 0; i<simbolos.length;i++){
			simbolos[i]=new Character(abc.charAt(i));
		}
		lista = Arrays.asList(simbolos);
		boolean flag = false;
		lenght = base.length;
		for (int i=0;i<lenght;i++){
			char [] contenido = base[i].toCharArray();
			for(Character c: contenido){
				flag = lista.contains(c);
				if(flag == false){
					System.out.println("Error en el proceso de scanning");
					System.out.println("El caracter "+c+" no es una caracter valido");
					i=base.length;
					break;
				}
				else{
					
				}
			}

		}
		parser(base);

	}
	public void parser(String[] base){
		boolean flag = false;
		lenght = base.length;
		for (int i=0;i<lenght;i++){
			char [] contenido = base[i].toCharArray();
			int largo = contenido.length - 1;
			while(largo>=0){
				if(contenido[largo]!='.'){
					System.out.println("Se espera un punto al final de la expresion en linea "+(i+1));
					i=lenght;
				}
				if(contenido[largo]=='.' & (contenido[largo-1]!=')'|contenido[largo-1]!='l')){
					System.out.println("El caracter antes del punto es invalido. Revisar la expresion en linea "+(i+1));
					i=lenght;
				}
				if(contenido[largo]==')'){
					while(contenido[largo]!='('){
						
					}
				}
			}
		}
	}
	
	
}

