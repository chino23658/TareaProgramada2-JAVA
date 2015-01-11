//Definici�n de la Clase de Excepciones 
class EmptyListException  extends RuntimeException 
{ public EmptyListException(String nombre) 
  { 
      super ( " La" + nombre+" esta vacia"); 
  } 
 } 
  
// Clase NodosListaD 
class NodosListaD { 
 // datos amigables para que la Clase Lista Tenga un acceso directo 
     String datos; 
     String nombre; 
     NodosListaD siguiente; 
     NodosListaD anterior; 
     boolean estado; 
  
//Construtor  Crea un nodo del tipo Object 
 NodosListaD (String variable, String  valor,boolean flag) 
  {  datos =valor; 
     nombre = variable;  
     siguiente = null;  //siguiente con valor de nulo 
     anterior = null; 
     estado  = flag; 
  } 
  
// Constructor Crea un nodo del Tipo Object y al siguiente nodo de la lista 
NodosListaD (String valor, NodosListaD signodo) 
{   datos = valor; 
    siguiente = signodo; //siguiente se refiere al siguiente nodo 
} 
  
//Retorna el dato que se encuentra en este nodo 
Object getObject() {return datos; } 
  
//Retorna el siguiente nodo 
NodosListaD getnext() {return siguiente; } 
  
}//Final de la Clase NodosLista 
  
  
//Definici�n de la Clase Lista 
 public class listaDoble 
{ 
  public NodosListaD PrimerNodo; 
  public NodosListaD ultimo; 
  String Nombre;   
  
//Constructor construye una lista vacia con un nombre s 
  
//Retorna True si Lista Vac�a 
 public boolean VaciaLista () {return PrimerNodo == null;} 
  
// Imprime el contenido de la lista 
 public void Imprimir() 
 { if (VaciaLista()) 
   { 
     System.out.println( "vacia" +Nombre); 
   } 
   //fin del primer if 
  else
  { 
      System.out.print( "La  " +  Nombre  +"  es:  "); 
      NodosListaD Actual = PrimerNodo; 
  
     while (Actual != null) 
     { 
      System.out.print (Actual.datos.toString() + " "); 
      Actual=Actual.siguiente; 
     } 
  
     System.out.println(); 
     System.out.println(); 
   } 
 } 
  
 public listaDoble (String s) 
{ Nombre = s; 
  PrimerNodo = ultimo =null; 
} 
  
//Constructor construye una lista vacia con un nombre de List 
public listaDoble(){ this ("Lista");} 
  
  
  
  
//Inserta al Final de la Lista 
//Si la lista se encuentra vac�a, el PrimerNodo y el UltimoNodo se refieren al nuevo nodo. Si no, la variable de siguiente de UltimoNodo se refiere al nuevo nodo. 
public void InsertaFinal(String var ,String ElemInser,boolean flag) 
{ if ( VaciaLista()) 
     PrimerNodo=ultimo = new NodosListaD (var,ElemInser,flag); 
  else
     { 
      NodosListaD aux= PrimerNodo; 
      while (aux.siguiente != null) 
         aux = aux.siguiente; 
      /* Primera Forma 
         aux.siguiente = new NodosListaD (ElemInser); 
         aux.siguiente.anterior =aux; 
     */
  
      NodosListaD Nuevo = new NodosListaD (var,ElemInser,flag); 
      aux.siguiente= Nuevo; 
      Nuevo.anterior= aux; 
      ultimo = Nuevo; 
  
    } 
} 
  
  
  
  
//Eliminar al Final 
//Debe tomar en cuenta si la lista se encuentra vac�a y producir una excepci�n, en caso contrario si PrimerNodo y UltimoNodo referencian al mismo nodo, ambos deben ser null y sino  ultimonodo en el campo siguiente ser� nulo 
  
public void EliminaFinal () 
{  
  if  ( VaciaLista()) 
    System.out.println ("No hay elementos"); 
  else
   { 
    // Restablecer  las referencias de PrimerNodo y UltimoNodo 
     if (PrimerNodo.siguiente== null) 
        PrimerNodo =  null; 
      else
      {         
        NodosListaD Actual =PrimerNodo; 
          
         while (Actual.siguiente.siguiente != null) 
            Actual = Actual.siguiente; 
  
          Actual.siguiente = null; 
          ultimo = Actual; 
      } 
   } 
 } 
  
  
public boolean  BuscarElemento(String Elem,listaDoble list) 
{   boolean respuesta = false; 
    try
    { 
      NodosListaD aux= list.PrimerNodo; 
      while((aux!=null)&(aux.nombre.equals(Elem))==false) 
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
  
String devolvervalor(String variable,listaDoble uni) 
{String respuesta = ""; 
 NodosListaD aux = uni.PrimerNodo; 
 while((aux!=null)&&(aux.nombre!=variable)) 
  {aux = aux.siguiente; 
  } 
 respuesta = aux.datos; 
return  respuesta; 
} 
  
// << 3.Largo 
public void Largo() 
{ 
  NodosListaD aux=PrimerNodo; 
  int i=0; 
  
  while (aux !=null) 
  { 
    i++; 
    aux=aux.siguiente; 
  } 
  System.out.println("El largo de la lista es :  "+ i); 
  
} 
  
  
  
  
} 