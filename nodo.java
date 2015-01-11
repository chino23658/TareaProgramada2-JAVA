//Clase Nodo para la Lista Simple
public class nodo {

	String datos;
	nodo anterior;
	nodo siguiente;
	
	
	//Constructor de nodo nulo
	nodo(){
		datos = null;
		siguiente = null;
	}
	
	nodo (String  valor)
	  {  datos = valor;
	     siguiente = null;  //siguiente con valor de nulo
	     anterior = null;
	 
	  }

	// Constructor Crea un nodo del Tipo Object y al siguiente nodo de la lista
	nodo (String valor, nodo signodo)
	{   datos = valor;
	    siguiente = signodo; //siguiente se refiere al siguiente nodo
	}

	
	
}
