public class listaSimple  {
	public nodo PrimerNodo;
	public nodo UltimoNodo;
	String Nombre;
	String expresion = "";
	int valor = 0;
	public boolean VaciaLista () {return PrimerNodo == null;}

	
	/////////////////////////////////////////////////////////////////////////////777
	 void Imprimir(){
		 
		 nodo aux= PrimerNodo;
		 while(aux!=null){
			 
			 System.out.print(aux.datos);
			 
			 
			aux=aux.siguiente; 
		 }		 
		 
	 }
//////////////////////////////////////////////////////////////////////////////////////////7	 	 
	 public listaSimple (String s)
	{ Nombre = s;
	  PrimerNodo = UltimoNodo =null;
	}
/////////////////////////////////////////////////////////////////////////////////77	
	public listaSimple(){ this ("Lista");}
	public void InsertaFinalD(String data )
	{ if ( VaciaLista())
	     PrimerNodo = new nodo (data );
	  else
	     {
	      nodo aux= PrimerNodo;
	      while (aux.siguiente != null)
	         aux = aux.siguiente;
	         aux.siguiente = new nodo (data);
	         aux.siguiente.anterior =aux;
	    
	     
	     
	    }
	}
///////////////////////////////////////////////////////////////7
	public void InsertaInicio (String ElemInser)
	{ if (VaciaLista()){
		PrimerNodo=UltimoNodo=new nodo(ElemInser);
	}
	else{
		PrimerNodo=new nodo(ElemInser, PrimerNodo);
		PrimerNodo.siguiente.anterior=PrimerNodo;
	}
	}

	
	
	
	
	
	

////////////////////////////////////////////////////////////77	
	public void InsertaFinal(String   hola)
	{ if ( VaciaLista())
	     PrimerNodo = UltimoNodo = new nodo (hola);
	  else
	     UltimoNodo=UltimoNodo.siguiente =new nodo (hola);
	}
	
	
	
	  int largolista(){
		int cont=0;
		nodo aux5= 	PrimerNodo;
		while (aux5 != null){
			cont++;			
			aux5=aux5.siguiente;
		}
		System.out.println(cont);
		return cont;
		
	}
	
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	

////////////////////////////////Emsamblador de Ubicacion///////////////////////////////////////////////////////////////////7777	
	
