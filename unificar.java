import java.io.*; 
import java.util.StringTokenizer; 
  
public class unificar { 
    File archivo = null; 
    FileReader fr = null;    //creacion de un objeto tipo file para lectura de archivos 
    BufferedReader br = null; 
     
   //metodo para determinar si un parametro es constante o variable 
   boolean esconstante(String cadena) 
   {boolean respuesta= false;    
   if(Character.isUpperCase(cadena.charAt(0))) 
    { 
     respuesta = false; 
    } 
    else{ 
         respuesta=true; 
         }  
   return respuesta;             
   } 
     
     
   //metodo para saber si una variable esta unificada 
   boolean esunificada(lista unificadas,String variable) 
   {boolean respuesta = false; 
    if(unificadas.VaciaLista()) 
      {respuesta = false; 
      } 
    else
       {if(unificadas.BuscarElemento(variable,unificadas)) 
         {respuesta = true; 
         } 
        else
           {respuesta = false; 
           } 
       } 
   return respuesta; 
   } 
         
     
   //metodo que separa el functor del predicado  
   String separarfunctor(String predicado) 
   {StringTokenizer tokens = new StringTokenizer(predicado,"("); 
    return tokens.nextToken(); 
   } 
     
   String quitarantecedentes(String predicado) 
   {StringTokenizer tokens = new StringTokenizer(predicado,":"); 
    return  tokens.nextToken(); 
   } 
     
   String separarconsecuente(String predicado) 
   {StringTokenizer tokens = new StringTokenizer(predicado,":"); 
    return tokens.nextToken(); 
   } 
     
   //busca el functor ya sea si este posee parametros o no  
   boolean buscarfunctor(String delimitador,String linea,String functorparametro)  
   {boolean respuesta = false; 
    StringTokenizer tokens = new StringTokenizer(linea,delimitador); 
  
    while(tokens.hasMoreTokens()) 
    { 
  
    String functor = tokens.nextToken(); 
    if(functorparametro.equals(functor)) 
       {respuesta= true; 
        break; 
       } 
    else
       {respuesta= false; 
        break; 
       } 
    } 
   if(respuesta==false) 
   {StringTokenizer tokens2 = new StringTokenizer(linea,":"); 
   while(tokens2.hasMoreTokens()) 
    { 
  
    String functor2 = tokens2.nextToken(); 
    if(functorparametro.equals(functor2)) 
       {respuesta= true; 
        break; 
       } 
    else
       {respuesta= false; 
        break; 
       } 
    } 
   }       
   return respuesta; 
   } 
   //metodo para determinar aridad de un predicado  
   int aridad(String predicado) 
   {int respuesta = 0; 
    StringTokenizer tokens = new StringTokenizer(predicado,","); 
    while(tokens.hasMoreTokens()) 
    {String func = tokens.nextToken(); 
     if(func.equals(predicado)==false) 
        respuesta++; 
    } 
    if(respuesta==0) 
    {StringTokenizer tokens2 = new StringTokenizer(predicado,")"); 
    while(tokens2.hasMoreTokens()) 
    {String func2 = tokens2.nextToken(); 
     if(func2.equals(predicado)==false) 
        respuesta++; 
    } 
    } 
   return respuesta; 
   }      
   //metodo de unificacion  
   void unificar(String predicado)      
   {       
    try { 
         // Apertura del fichero y creacion de BufferedReader para poder 
         // hacer una lectura comoda (disponer del metodo readLine()). 
         archivo = new File ("archivo.txt"); 
         fr = new FileReader (archivo); 
         br = new BufferedReader(fr); 
   
         // Lectura del fichero 
         String linea; 
         String functorparametro = quitarantecedentes(predicado); 
         functorparametro=separarfunctor(functorparametro); 
         while((linea=br.readLine())!=null) 
           {if(buscarfunctor("(",linea,functorparametro)==true) 
              {System.out.println("el functor coincide y es: "+functorparametro); 
               String consecuentepredi = separarconsecuente(predicado); 
               String consecuentebase = separarconsecuente(linea); 
               if(aridad(consecuentepredi)!=aridad(consecuentebase))                 
                 {System.out.println("pero la aridad es distinta");                 
                 } 
               else
                  {System.out.println("la aridad es la misma: "+Integer.toString(aridad(consecuentebase))); 
                  } 
              } 
           }             
      } 
      catch(Exception e){ 
         e.printStackTrace(); 
      }finally{ 
         // En el finally cerramos el fichero, para asegurarnos 
         // que se cierra tanto si todo va bien como si salta  
         // una excepcion. 
         try{                     
            if( null != fr ){    
               fr.close();      
            }                   
         }catch (Exception e2){  
            e2.printStackTrace(); 
         } 
      }              
   } 
   boolean  posible(String e1, String e2,lista unificadas) 
   {boolean respuesta = false; 
    if((esconstante(e1)&esconstante(e2)))    
      {if(e1.equals(e2)) 
        {respuesta = true; 
        } 
       else
          {respuesta = false; 
          } 
      } 
    else
       {if((esconstante(e1)==false)&(esconstante(e2))) 
          {if(esunificada(unificadas,e1)==false) 
            {respuesta = true; 
            } 
           else
              {String valor = unificadas.devolvervalor(e1,unificadas); 
               if(valor.equals(e2)) 
                 {respuesta=true; 
                 } 
               else
                  respuesta = false; 
              } 
          } 
        if((esconstante(e1))&(esconstante(e2)==false)) 
         {if(esunificada(unificadas,e2)==false) 
           {respuesta = true; 
           } 
          else
             {String valorre = unificadas.devolvervalor(e2,unificadas); 
              if(valorre.equals(e1)) 
               {respuesta = true; 
               } 
              else
                 respuesta = false; 
             } 
         } 
        if((esconstante(e1)==false)&(esconstante(e2)==false)) 
          {if((esunificada(unificadas,e1)&esunificada(unificadas,e2)==false)||(esunificada(unificadas,e1)==false&esunificada(unificadas,e2))) 
             {respuesta = true; 
             } 
           if(esunificada(unificadas,e1)&esunificada(unificadas,e2)) 
             {String valore1 = unificadas.devolvervalor(e1,unificadas); 
              String valore2 = unificadas.devolvervalor(e2,unificadas); 
              if(valore1.equals(valore2)) 
                {respuesta = true;                 
                } 
              else
                 {respuesta = false; 
                 } 
             } 
           else
              {respuesta = true; 
              } 
          } 
       } 
   return respuesta;             
   } 
   void unificarVariables(lista unificadas,String e1, String e2){ 
       if(posible(e1, e2, unificadas)){ 
           if(((!(esconstante(e1)))&(!(esunificada(unificadas,e1))))&(esconstante(e2))){ 
               unificadas.InsertaFinal(e1, e2); 
           } 
           if((esconstante(e2)&((!(esconstante(e1)))&(!(esunificada(unificadas,e1)))))){ 
               unificadas.InsertaFinal(e2, e1); 
           } 
           if (((!(esconstante(e1)))&(!(esconstante(e2))))&((!(esunificada(unificadas,e1)))&(!(esunificada(unificadas,e2))))){ 
               unificadas.InsertaFinal(e1, e2); 
           } 
       } 
   } 
} 