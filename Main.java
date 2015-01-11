

import java.io.EOFException;





public class Main {

static void separar(String texto, listaSimple nueva,listaSimple nueva2){
	int cont=0;	
        String test = texto;

        String[] result = test.split("");

        for(String s : result){
        	if(cont!=0){
            nueva.InsertaFinalD(s);
            nueva2.InsertaInicio(s);
        	}
        	
        	cont++;
        }	
	
}
/////////////////////////////////////////////////////////////////////7////////77

static void splitme(String texto,listaSimple nueva2){
	int cont=0;	
        String test = texto;

        String[] result = test.split("");

        for(String s : result){
        	if(cont!=0){
            nueva2.InsertaFinalD(s);
        	}
        	
        	cont++;
        }	
	
}


///////////////////////////////////////////////////////separadores////////////77
 static boolean cotcarac(listaSimple nueva){
	int cont=0;
	nodo aux=nueva.PrimerNodo;
	while(aux!=null){
		cont++;
		aux=aux.siguiente;
	}
	if (cont<4){
		System.out.println("no hay suficientes caracteres"); 
		return false;}
	
	else{return true;}
}

///////////////////////////////////////////////////7777Indificador ///////////////////////////////////////////////////

static boolean esregla(listaSimple Nueva ){
	nodo aux = Nueva.PrimerNodo;
	while (aux!=null){
		try{
			
		if (aux.datos.equalsIgnoreCase(")")&aux.siguiente.datos.equalsIgnoreCase(":")&aux.siguiente.siguiente.datos.equalsIgnoreCase("-")){
			System.out.println("Es regla");
			return true;}}
		catch(Exception e){
			System.out.println("Es hecho");
			return false;
		}
	 aux = aux.siguiente;	
	}
	
return false;
}

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////777

static boolean numparen(listaSimple Nueva){
	nodo aux=Nueva.PrimerNodo;
	 while(aux!=null){
	 if (aux.datos.equals("(")){
		 if(aux.siguiente.datos.equals(")")==false){
		char v=aux.siguiente.siguiente.datos.charAt(0);
		 char y=aux.siguiente.datos.charAt(0);
		 char h=aux.siguiente.siguiente.siguiente.datos.charAt(0);
		 
		if(Character.isDigit(y)&aux.siguiente.siguiente.datos.equalsIgnoreCase(",")&Character.isDigit(h)){
			System.out.println("hola1");
			return true;}
	 
		if (Character.isDigit(y)&aux.siguiente.siguiente.datos.equalsIgnoreCase(")")||Character.isDigit(v)){
			System.out.println("hola2");
			return true;}
	 }
		}	
	 aux=aux.siguiente;
	 }
	 System.out.println("malo");
	 return false;
	 }


	

static boolean Inicio(listaSimple Nueva){
	
	char f1 =(Nueva.PrimerNodo.datos).charAt(0);
	if (Character.isDigit(f1)==false){
		if (Character.isUpperCase(f1)){
			System.out.println("Error ninguna regla o clausula puede empezar con Mayuscula");
			return false;
		}
		else{return true;}
	}
	
	System.out.println("Error ninguna regla o clausula puede empezar con numeros");
	return false;
	
}


static boolean parentesis(listaSimple Nueva){
	int cont=0;
	 nodo aux=Nueva.PrimerNodo;
	 while(aux!=null){
		 if (aux.datos.equalsIgnoreCase("(")){
			 nodo aux1=aux;
			 while(aux1!=null){ 
				if (cont!=0){
				 if (aux1.datos.equalsIgnoreCase("(")){
					System.out.println("Systaxis erronea recuerde cerrar parentesis");
					return false; 
				 }				 }
				/////////////////////////////////////////////
				 if(aux1.datos.equalsIgnoreCase(")")){
					 System.out.println("Systaxis correcta");
					 return true; 
				 } 
				 ///////////////////////////////////////////////
				 cont++;
				 aux1=aux1.siguiente; 
			 } 
			 System.out.println("Systaxis incorrecta recuerde cerrar los parentesis");
			 return false;
		 }
		aux=aux.siguiente; 
	 }
	 ///////////////////////////////////////
	 System.out.println("Systaxis erronea2");
	return false;
////////////////////////////////////////////
}


static boolean punto (listaSimple nueva){
	 nodo aux=nueva.PrimerNodo;
	 while(aux.siguiente!=null){
		 if(aux.datos.equalsIgnoreCase(")")){
			 if(aux.siguiente.datos.equalsIgnoreCase(".")){
				 if(aux.siguiente.siguiente!= null){
					 System.out.println("Error de sintaxis colocacion del punto");
					 return false;
				 }
				 else{
					 System.out.println("bien");
					 return true;	
				 }
			 }
			 else{System.out.println("Error de sintaxis colocacion del punto"); return false;} 
		 }
		aux=aux.siguiente;
	 }
	System.out.println("Error de sintaxis colocacion del punto");
	return false;
}

static boolean adentro (listaSimple nueva){
	 nodo aux=nueva.PrimerNodo;
	 while(aux.siguiente!=null){
		 if(aux.datos.equalsIgnoreCase("(")){
			 char d =(aux.siguiente.datos).charAt(0);
			 if(Character.isAlphabetic(d)==false  & aux.siguiente.datos.equalsIgnoreCase(")")==false&numparen(nueva)==false){
			 		System.out.println("caracter despues  del parentesis es invalido");
			 				return false;}
			 	else{
			 		if(Character.isUpperCase(d)){
			 					System.out.println("caracter despues del parentesis invalido recuerde solo minuscula000");	 
			 					return true;}}
			 nodo aux1=aux;
			 while(aux1!=null){ 
			 if(aux1.datos.equalsIgnoreCase(",")){
				 char c =(aux1.siguiente.datos).charAt(0);
				 char f=(aux1.anterior.datos).charAt(0);
				 	if(Character.isAlphabetic(c)==false&Character.isDigit(c)==false){
				 		System.out.println("caracter despues  de la coma invalido");
				 				return false;}
				 	else{
				 				if(Character.isUpperCase(c)){
				 					System.out.println("caracter despues de la coma recuerde solo minuscula");	 
				 					return false;}}
					
				 	if(Character.isAlphabetic(f)==false&numparen(nueva)==false){
				 		System.out.println("caracter antes de la coma invalido");
				 				return false;}
		 }
			 aux1=aux1.siguiente;
			 }
			 return true;
		 }
		 aux=aux.siguiente;
		 
	 }
	
	return false;
		
}


static boolean antesparen(listaSimple  Nueva){

	nodo aux = Nueva.PrimerNodo;
	if (aux.datos.equals("(")){
		System.out.println("No hay encabezado");
		return false;
		
	}
	while(aux.datos.equals("(")==false){

		char t= aux.datos.charAt(0);
		if (Character.isAlphabetic(t)==false & Character.isDigit(t)==false &aux.datos.equalsIgnoreCase("_")==false){
			System.out.println("Caracter antes parentesis invalido");
			return false;
			
		}
		
		
		aux=aux.siguiente;
		
	}
	return true;
	
	
	
}
/////////////////////////////////////////////////////////////7parcer Reglas///////////////////////////////////////////////////////////////////777

static boolean cierraparentesis(listaSimple Nueva){
	
nodo aux = Nueva.PrimerNodo;
	int cont1=0;
	int cont2=0;
	while (aux!=null){
		
		if (aux.datos.equals("(")){
			cont1++;
		}
		if(aux.datos.equals(")")){
			cont2++;
		}
		
		aux=aux.siguiente;
		
	}
	
	if (cont1==cont2){
		System.out.println("Cerro los parentesis");
		return true;
	}
	else{System.out.println("Cierre los parentesis");return false;}
}


 static boolean despuesEnca(listaSimple Nueva){
	 
	 nodo aux =Nueva.PrimerNodo;
	 while (aux != null){
		 if (aux.datos.equals(")")&aux.siguiente.datos.equals(":")){
			 char g =(aux.anterior.datos).charAt(0);
			 if (Character.isAlphabetic(g)||Character.isDigit(g)){
				 
				 System.out.println("Inicio del Predicado valido");
				 return true;
			 }
			 else{
				 System.out.println("Inicio del Predicado invalido ");
				 return false;
				 
			 }
		 
		
		 }
		 
		 aux=aux.siguiente;
		 
		 
	 }
	 return false;
	 	 
 } 
 
 static ///////////////////////////////////////////////vreifica punto2.3
 
 
 boolean puntovacum(listaSimple nueva){
	 nodo aux1 = nueva.PrimerNodo;
	 int cont=0;
	 while(aux1!=null){
		 if(aux1.datos.equals(".")){
			 
			 cont++;
			 
			 
		 }
		 
		 aux1=aux1.siguiente;
		 
		 
		 
	 }
	 
	 if (cont>1){return false;}
	 else{return true;}
	 
 }
 
 
 static boolean operadores (listaSimple nueva){
	 
	 nodo aux = nueva.PrimerNodo;
	 
	 while (aux != null){
		 
		 if (aux.datos.equals("&")||aux.datos.equals(";")){
			 if (aux.siguiente.datos.equals("&")||aux.siguiente.datos.equals(";")){
				 
				 System.out.println("doble colocación de los operadores de y e o");
				return false;
				 
			 }
		 }
		 
		 
		 
		 
		 aux=aux.siguiente;
	 }
	 return true;
	 
	
	 
	 
	 
 }
 
 
 
//////////////////////////////////////////punto2.1//////////////////////////////////7
 static boolean punto2 (listaSimple nueva){
	 nodo aux=nueva.PrimerNodo;
	 while(aux!=null){
		 if(aux.datos.equalsIgnoreCase(".")){
			 if(aux.anterior==null&aux.siguiente.datos.equals(")")||aux.siguiente.datos.equals("l")&aux.siguiente.siguiente.datos.equals("n")||aux.siguiente.siguiente.datos.equals("i")){ 
				 
			
				 
				 System.out.println("Colacación del punto valida");
				 return true;}
			 else{System.out.println("Colacación del punto invalida");
			 

			 return false;}
		 }
		 
		 aux=aux.siguiente;
			 }
	 System.out.println("No se coloco punto en la reglas");
	 	return false;
 
 }
 

 

		
 static boolean comprobar(listaSimple temporal, listaSimple especial){	
	
	 
	 
	 if (Inicio(temporal)){
		try{
		if( casosespeciNL(temporal)&parentesis(temporal)& adentro(temporal)&antesparen(temporal)){
			System.out.println("Clausula Valida");
			return true;
			
		}
		
		else{
			
			System.out.println("Clausula invalidad");
			return false;
		}}
		catch(Exception e){
			
			
			
			if (temporal.PrimerNodo.datos.equals("n")&temporal.PrimerNodo.siguiente.datos.equals("l")&temporal.PrimerNodo.siguiente.siguiente==null){
				System.out.println("validado el nl");
				return true ;
				
			}
			

		
			
			nodo aux =temporal.PrimerNodo;
			while (aux!=null){
				if (aux.datos.equals("(")){
					char t=aux.siguiente.datos.charAt(0);
					if(Character.isAlphabetic(t)||Character.isDigit(t)){
							return true;
					}
					else {
						System.out.println("No caracteres que no sean letras o numeros entre parentesis");
						return false;}
					}
				aux=aux.siguiente;
			}
			if (casosespecifail(especial)){return true;}
			System.out.println("Clausula Invalida");
			return false;
		}
		
		
	
	
	
	
	
	}
	else{
		
		System.out.println("Clausula invalidad");
		return false;	
	}

}
		

 
 static boolean reglas (listaSimple Token){
	nodo aux= Token.PrimerNodo;
	
	listaSimple separada = new listaSimple();
	while(aux!= null){
		
		splitme(aux.datos,separada);
	
		if (comprobar(separada,Token)){
			System.out.println("Regla comprobada");
			separada.PrimerNodo=null;
			
			}
			else{
				
				System.out.println("Regla NOOOOOOOcomprobada");
				return false;
			}
		
		aux=aux.siguiente;
		}	
	
	System.out.println("Reglas comprobada//////////");
	return true;
		
	}
 

 static boolean casosespeciNL(listaSimple  nueva){
	 try{
	if (nueva.PrimerNodo.datos.equals("n")&nueva.PrimerNodo.siguiente.datos.equals("l")&nueva.PrimerNodo.siguiente.siguiente.datos.equals("(")){
		System.out.println("INVALIDO NL");
		return false ;
		
	}
			else{ return true;}
	 } 
	 catch(Exception e){
		 
		 return true;
		 
	 }
	 
	 
 }
 
 static boolean casosespecifail(listaSimple  nueva){ 
	 nodo aux = nueva.PrimerNodo;
	 while(aux!=null){
		 
		 if (aux.datos.equals("fail")){
			 
			 return true;
		 }
		 
		 aux=aux.siguiente;
	 }
	 
	 
	 
	 return false;}
 
 static boolean casoespecialWRITE(listaSimple nueva ){
	 listaSimple temporal1 = new listaSimple();
	 nodo aux= nueva.PrimerNodo;
	while(aux!= null){
		
		splitme(aux.datos,temporal1);
		if (comprobarwirte(temporal1)){
			
			return true;
		}
		
		
		
		aux=aux.siguiente;
	} 
	 
	 
	 
	 
	 return false;
 }
 
 
 static boolean  comprobarwirte(listaSimple nueva){ 
	 
	 nodo aux=nueva.PrimerNodo;
	 while (aux!=null){
		 
		 try{
		 if(aux.datos.equals("w")&aux.siguiente.datos.equals("r")&aux.siguiente.siguiente.datos.equals("i")&aux.siguiente.siguiente.siguiente.datos.equals("t")&aux.siguiente.siguiente.siguiente.siguiente.datos.equals("e")&aux.siguiente.siguiente.siguiente.siguiente.siguiente.datos.equals("(")){
		
			 return true;
			
		 }  }
		 
		 catch(Exception e){
			 
			 return false;
		 }
		 
		 
		 aux=aux.siguiente;
	 }
	 
	 
	 return false;}

///////////////////////////////////////////////////////7khl////////////////////////////////77









static boolean parcer(listaSimple NuevaLista2, listaSimple NuevaLista3,listaSimple NuevaLista4){

	if (esregla(NuevaLista2)==false){
		if (punto ( NuevaLista2)&Inicio(NuevaLista2)){
			if(parentesis(NuevaLista2)& adentro(NuevaLista2)&antesparen(NuevaLista2)){
				System.out.println("Clausula Valida");
				return true;
				
			}
			
			else{
				if (casoespecialWRITE(NuevaLista4)||casosespecifail(NuevaLista4)){return true;}
				System.out.println("Clausula invalidad");
				return false;
			}
		}
		else{
			if (casoespecialWRITE(NuevaLista4)||casosespecifail(NuevaLista4)){return true;}
			System.out.println("Clausula invalidad");
			return false;
		}
	}
	
	
	else{
		if(Inicio(NuevaLista2)&punto2(NuevaLista3)&puntovacum(NuevaLista2)&operadores (NuevaLista2)&antesparen(NuevaLista2)&cierraparentesis(NuevaLista2)){
			if(despuesEnca(NuevaLista2)&reglas(NuevaLista4)){System.out.println("REGLA COMPROBADASSSS");
			
			
			return true;}
			else{	System.out.println("REGLASS No comprobadas");
			return false;}
		}
		
		else{
			System.out.println("REGLASS No comprobadas");
			return false;
			
		}
	}

	

}

static boolean parcercompletado(String texto ,listaSimple NuevaLista2, listaSimple NuevaLista3,listaSimple NuevaLista4){
	tokenizer token = new tokenizer(texto, NuevaLista4);
	separar(texto,NuevaLista2,NuevaLista3);
	if (cotcarac(NuevaLista2)){
		if (parcer( NuevaLista2,NuevaLista3,NuevaLista4)){
			
			System.out.println("CLAUSULA VALIDA TOTALMENTE VALIDA");
			return true;
			
			
		}
		else{System.out.println("CLAUSULA INVALIDA");
		return false;}
	
	
	
	}
	
	else{System.out.println("CLAUSULA INVALIDA");
	return false;}

	
	
	
	
	
}

static boolean parsear(String [] baseconocimiento, int largobase){
	boolean flag = false;
	for(int i = 0; i<largobase; i++ ){
		listaSimple NuevaLista2 = new listaSimple();
		listaSimple NuevaLista3 = new listaSimple();
		listaSimple NuevaLista4 = new listaSimple();
		if(parcercompletado(baseconocimiento[i],NuevaLista2,NuevaLista3,NuevaLista4))
			flag = true;
	}
	return flag;
}
public static void main(String args[]) {
	/*listaSimple NuevaLista2 = new listaSimple();
	listaSimple NuevaLista3 = new listaSimple();
	listaSimple NuevaLista4 = new listaSimple();
	String texto="uio"; 
	
	parcercompletado(texto,NuevaLista2,NuevaLista3,NuevaLista4);*/
	String [] pruebas;
	pruebas = new String[6];
	pruebas[0]="hola(r):-kjsks(9000,8)&jjkhjhjkj()&hash(r)&fail&jjkhjhjkj().";
	parsear(pruebas,1);
	
	
	
}

	
}
