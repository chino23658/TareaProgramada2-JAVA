// Clase NodosLista 
class NodosLista { 
 // datos amigables para que la Clase Lista Tenga un acceso directo 
     String datos; 
     String nombre;      
     NodosLista siguiente; 
  
//Construtor  Crea un nodo del tipo Object 
 NodosLista (String variable,String valor) 
  {  datos =valor; 
     nombre = variable; 
     siguiente = null;  //siguiente con valor de nulo 
  } 
  
// Constructor Crea un nodo del Tipo Object y al siguiente nodo de la lista 
NodosLista (String valor, NodosLista signodo) 
{   datos = valor; 
    siguiente = signodo; //siguiente se refiere al siguiente nodo 
} 
  
//Retorna el dato que se encuentra en este nodo 
Object getObject(){return datos; } 
  
//Retorna el siguiente nodo 
NodosLista getnext() {return siguiente; } 
  
}//Final de la Clase NodosLista 
  
  
//Definici�n de la Clase Lista 
 public class lista 
{ 
  public NodosLista PrimerNodo; 
  String Nombre; 
  
//Constructor construye una lista vacia con un nombre s 
  
//Retorna True si Lista Vac�a 
 public boolean VaciaLista () {return PrimerNodo == null;} 
  
  
  
 public lista (String s) 
{ Nombre = s; 
  PrimerNodo = null; 
} 
  
//Constructor construye una lista vacia con un nombre de List 
public lista(){ this ("Lista");} 
  
  
  
//Inserta al Final de la Lista 
//Si la lista se encuentra vac�a, el PrimerNodo y el UltimoNodo se refieren al nuevo nodo. Si no, la variable de siguiente de UltimoNodo se refiere al nuevo nodo. 
public void InsertaFinal(String nom,String ElemInser) 
{ if ( VaciaLista()) 
     PrimerNodo = new NodosLista (nom,ElemInser); 
  else
     {NodosLista aux = this.PrimerNodo; 
      while(aux.siguiente!=null) 
       {aux = aux.siguiente; 
       } 
      NodosLista nuevo =new NodosLista (nom,ElemInser); 
      aux.siguiente = nuevo; 
     } 
      
} 
  
public void EliminaFinal(){ 
    if(VaciaLista()){} 
    else if(PrimerNodo.siguiente==null) 
        PrimerNodo = null; 
    else{ 
        NodosLista aux = this.PrimerNodo; 
        while(aux.siguiente.siguiente!=null){ 
            aux=aux.siguiente; 
        } 
        aux.siguiente = null; 
    } 
} 
  
public void Imprimir() 
{ 
    if (VaciaLista()) 
        System.out.println("vacia"+Nombre); 
    else{ 
        NodosLista Actual = PrimerNodo; 
        while(Actual != null){ 
            System.out.print(Actual.nombre+" -> "); 
            System.out.print(Actual.datos+" "); 
            Actual = Actual.siguiente; 
        } 
    } 
} 
  
  
  
// << 2.BuscarElemento en una lista 
public boolean  BuscarElemento(String Elem,lista list) 
{   boolean respuesta = false; 
    try
    { 
      NodosLista aux= list.PrimerNodo; 
      while((aux!=null)&(aux.nombre !=Elem)) 
        aux=aux.siguiente; 
      if(aux !=null) 
        respuesta=true; 
     } 
     catch(Exception e) 
     { 
          respuesta=false; 
     } 
return respuesta; 
} 
  
void deepCopy(lista lista1){ 
    NodosLista aux = lista1.PrimerNodo; 
    while (aux != null) { 
        this.InsertaFinal(aux.nombre, aux.datos); 
        aux = aux.siguiente; 
    } 
} 
      
  
String devolvervalor(String variable,lista uni) 
{String respuesta = ""; 
 NodosLista aux = uni.PrimerNodo; 
 while((aux!=null)&&(aux.nombre!=variable)) 
  {aux = aux.siguiente; 
  } 
 respuesta = aux.datos; 
return  respuesta; 
}

public String listaenString(lista nueva){
	String respuesta= "";
	NodosLista aux = nueva.PrimerNodo;
	while(aux!=null){
		respuesta += aux.datos+" ";
		respuesta += aux.nombre+" ";
		aux=aux.siguiente;
	}
	return respuesta;
}
  
  
}; 