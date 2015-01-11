import java.io.*;  
import java.util.StringTokenizer;  
    
class solucion{  
  
    lista Unificadas; 
    lista Resultados = new lista(); 
    int POS=0; 
    boolean fail = false; 
       
        
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
        
//recibe el array donde esta la base de conocimiento y el predicado y devuleve si ese hecho existe en la base     
boolean existehecho(String hecho,String[] base)   
{boolean respuesta = false;  
 int largobase = base.length;  
for(int i = 0;i<largobase;i++){  
    if((base[i]).equals(hecho)){  
        //System.out.println("Se encontro hecho en la base.");  
        respuesta = true;  
    }  
        
}  
return respuesta;  
}  
   /* recibe el predicado de la consulta y quita los antecedentes del predicado.   
    ejemplo: persona(X,Y,Z):-humano(X).  
    devuelve humano(X).  
    */
   String quitarantecedentes(String predicado)  
   {StringTokenizer tokens = new StringTokenizer(predicado,":-");  
    int contador = 0;  
    String cadena = "";  
    while(contador<2 &tokens.hasMoreTokens())     
     {cadena = tokens.nextToken();  
      contador++;  
     }  
    return  cadena;  
   }  
       
   /* recibe el predicado de la consulta y quita los antecedentes del predicado.   
    ejemplo: persona(X,Y,Z):-humano(X).  
    devuelve persona(X,Y,Z)  
    */   
   String separarconsecuente(String predicado)  
   {StringTokenizer tokens = new StringTokenizer(predicado,":");  
    return tokens.nextToken();  
   }  
        
   /* recibe el predicado de la consulta devuelve true si el predicado es un hecho.   
    ejemplo: humano(fernando).  
    devuelve true  
    */      
//   boolean eshecho(String predicado)  
//   {boolean respuesta = false;  
//      StringTokenizer tokens = new StringTokenizer(predicado,":");  
//    String cadena = tokens.nextToken();  
//    if(cadena.equals(predicado))  
//      {respuesta = true;  
//      }  
//   return respuesta;  
//   }  
       
       
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
       
    
       
      //metodo que separa el functor del predicado   
   String separarfunctor(String predicado)  
   {StringTokenizer tokens = new StringTokenizer(predicado,"(");  
    return tokens.nextToken();  
   }  
       
      //metodo para determinar aridad de un predicado   
   int aridad(String predicado)  
   {int respuesta = 0;  
   try{ 
    String parametros = separarparametros(predicado);     
    StringTokenizer  tokens = new StringTokenizer(parametros,",");  
    while(tokens.hasMoreTokens())  
     {String parametro = tokens.nextToken();  
      if(parametro.equals(".")|parametro.equals(predicado))  
        break;  
      else
         {respuesta++;  
         }  
     } 
   } 
   catch(Exception e) 
                    {return respuesta;} 
   return respuesta;  
   }  
       
      /* recibe el consecuente y quita el functor y los parentesis.   
    ejemplo: persona(X,Y,Z)  
    devuelve X,Y,Z  
    */   
   String separarparametros(String consecuente)  
   {int contador = 0;  
    String cadena = "";  
    StringTokenizer tokens = new StringTokenizer(consecuente,"(");  
    while((contador <2) & tokens.hasMoreTokens())  
       {cadena = tokens.nextToken();  
        contador++;  
       }  
    StringTokenizer tokens2 = new StringTokenizer(cadena,")");  
    cadena = tokens2.nextToken();  
   return cadena;  
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
       else if((esconstante(e1))&(esconstante(e2)==false))  
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
       else if((esconstante(e1)==false)&(esconstante(e2)==false))  
          {if((esunificada(unificadas,e1)&esunificada(unificadas,e2)==false)||(esunificada(unificadas,e1)==false&esunificada(unificadas,e2)))  
             {respuesta = true;  
             }  
          else if(esunificada(unificadas,e1)&esunificada(unificadas,e2))  
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
       
       
   boolean unificaenpares(String parametros, String parametros2,lista unificadas)  
   {boolean respuesta = false;        
      if(posible(parametros,parametros2,unificadas))//Analiza si es POSIBLE unificar los parametros  
       {  
          unificarVariables(unificadas,parametros,parametros2);  
          respuesta = true;//Si resulta que es posible invoca al metodo unificarvariables  
       }  
      else
         {respuesta = false;  
         }  
   return respuesta;  
   }  
       
   String valor_de_variable(String variable,lista unificadas)//Metodo que devuelve valor de una variable  
   //Devuelve el valor en la lista de unificadas si es que existe, si no, se retorna la misma variable.  
   {String respuesta = "";  
   if(esconstante(variable))  
       respuesta = variable;  
   else{  
       NodosLista puntero = unificadas.PrimerNodo;  
       while(puntero !=null)  
       {if(puntero.nombre.equals(variable)){  
           respuesta = puntero.datos;  
           puntero = puntero.siguiente;  
       }  
       else
           puntero = puntero.siguiente;  
       }  
   }  
   if(respuesta.equals(""))  
       respuesta = variable;  
          
    return respuesta;  
   }  
       
       
   //Unificar los parametros  
   void unificarVariables(lista unificadas,String e1, String e2){  
       if(posible(e1, e2, unificadas))  
       {   if((esconstante(e1))&((!esconstante(e2))&(!esunificada(unificadas,e2)))) //revisar es unificada  
             {unificadas.InsertaFinal(e2,e1);  
             }  
           if(((!(esconstante(e1)))&(!(esunificada(unificadas,e1))))&(esconstante(e2)))  
            {  
               unificadas.InsertaFinal(e1, e2);  
            }  
           else
             if((esconstante(e2)&((!(esconstante(e1)))&(!(esunificada(unificadas,e1))))))  
             {  
               unificadas.InsertaFinal(e2, e1);  
             }  
             else 
                if (((!(esconstante(e1)))&(!(esconstante(e2))))&((!(esunificada(unificadas,e1)))&(!(esunificada(unificadas,e2)))))  
                    {  
                       unificadas.InsertaFinal(e1, e2);  
                    }  
                else
                     if (((!(esconstante(e1)))&(!(esconstante(e2))))&(((esunificada(unificadas,e1)))&(!(esunificada(unificadas,e2)))))  
                        {  
                          String valor_e1 = valor_de_variable(e1,unificadas);  
                          unificadas.InsertaFinal(e2,valor_e1);  
                        }  
                     else
                        { if (((!(esconstante(e1)))&(!(esconstante(e2))))&(((!esunificada(unificadas,e1)))&((esunificada(unificadas,e2)))))  
                            {  
                              String valor_e2 = valor_de_variable(e2,unificadas);  
                              unificadas.InsertaFinal(e1,valor_e2);  
                            }  
                
                        }  
                
       }  
   }        
   /* Este es el metodo que falta terminar devolveria true si la consulta se puede  
    satisfacer con la base de conocimiento, false y es lo contrario  
    */
   int obtener_linea_predicado(String predicado,String []base, lista unificadas){ 
       int respuesta=-1; 
       if(aridad(predicado)>=1) //si el consecuente tiene al menos un parametro  
       {String parametrosconse = separarparametros(predicado); //separa los parametros del consecuente para verificar si pueden unificar  
        //System.out.println(parametrosconse);  
        String parametrosbase;  
        int largobase = base.length; //cantidad de reglas y hechos en la base de conocimiento  
        String functor = separarfunctor(predicado); //separa el functor del consecuente de la consulta para saber si unifica con los de la base  
        for(int i = 0;i<largobase;i++) //para revisar toda la base en caso de que 2 parametros no se puedan unificar  
          {String predibase = base[i]; //extrae los predicados de la base  
           String consebase = separarconsecuente(predibase); //separa el consecuente del predicado extraido de la base  
           if(functor.equals(separarfunctor(consebase))) //si los functores son iguales unifica  
             {if(aridad(consebase)==aridad(predicado))//si la aridad es la misma unifica  
               {parametrosbase = separarparametros(consebase); //separa los parametros del consecuente extraido de la base  
                //System.out.println(parametrosbase);                 
                StringTokenizer tokens = new StringTokenizer(parametrosbase,",");  
                StringTokenizer tokens2 = new StringTokenizer(parametrosconse,",");   
                int aux = i;  
                //El siguiente ciclo lo que realiza es una sucesion de evaluaciones donde prueba cada argumento  
                //con su pareja para concluir si unifican o no mediante el metodo unifica pares  
                //si TODOS unifican cierra el ciclo totalmente, devolviendo la linea de la base de conocimiento  
                //como resultado. Si solo algun token no unifica, hace break en el while y analiza la siguiente linea de la base  
                while(tokens.hasMoreTokens())//ciclo para comprobar si los parametros unifican uno por uno                    
                {if(posible(tokens.nextToken(),tokens2.nextToken(),unificadas))//si unifican devuelve true  
                {respuesta = aux;  
                //POS = i;//Guarda la posicion donde tuvo exito la unificacion de los consecuentes  
                i=largobase; 
                  
                }  
                else{ 
                    i=aux; 
                    respuesta = -1; 
                    break; 
                } 
                }  
                }  
               }  
             }  
          } 
       return respuesta; 
   } 
   String unifica_predicado(String predicado,int pos, String [] base, lista unificadas){  
       String respuesta = "";  
       //String regla = obtener_regla(predicado,base);  
       //String consecuente = separarconsecuente(predicado);  //separa el consecuente del resto del predicado  
       //String antecedentebase = quitarantecedentes(predicado);  //separa los antecedentes del consecuente        
       if(aridad(predicado)>=1) //si el consecuente tiene al menos un parametro  
        {String parametrosconse = separarparametros(predicado); //separa los parametros del consecuente para verificar si pueden unificar  
         //System.out.println(parametrosconse);  
         String parametrosbase;  
         int largobase = base.length; //cantidad de reglas y hechos en la base de conocimiento  
         String functor = separarfunctor(predicado); //separa el functor del consecuente de la consulta para saber si unifica con los de la base  
         for(int i = pos;i<largobase;i++) //para revisar toda la base en caso de que 2 parametros no se puedan unificar  
           {String predibase = base[i]; //extrae los predicados de la base  
            String consebase = separarconsecuente(predibase); //separa el consecuente del predicado extraido de la base  
            if(functor.equals(separarfunctor(consebase))) //si los functores son iguales unifica  
              {if(aridad(consebase)==aridad(predicado))//si la aridad es la misma unifica  
                {parametrosbase = separarparametros(consebase); //separa los parametros del consecuente extraido de la base  
                 //System.out.println(parametrosbase);                 
                 StringTokenizer tokens = new StringTokenizer(parametrosbase,",");  
                 StringTokenizer tokens2 = new StringTokenizer(parametrosconse,",");  
                 int unificaciones = 0;  
                 int aux = i;  
                 //El siguiente ciclo lo que realiza es una sucesion de evaluaciones donde prueba cada argumento  
                 //con su pareja para concluir si unifican o no mediante el metodo unifica pares  
                 //si TODOS unifican cierra el ciclo totalmente, devolviendo la linea de la base de conocimiento  
                 //como resultado. Si solo algun token no unifica, hace break en el while y analiza la siguiente linea de la base  
                 while(tokens.hasMoreTokens())//ciclo para comprobar si los parametros unifican uno por uno                    
                 {if(unificaenpares(tokens.nextToken(),tokens2.nextToken(),unificadas))//si unifican devuelve true  
                 {respuesta = base[aux];  
                 unificaciones++;  
                 //POS = i;//Guarda la posicion donde tuvo exito la unificacion de los consecuentes  
                 i=largobase;  
                 }  
                 else{  
                     for(int z =1;z<unificaciones;z++)  
                         unificadas.EliminaFinal();  
                     respuesta="";  
                     i=aux;  
                     break;  
                 }  
                 }  
                 }  
                }  
              }  
           }                     
            
       return respuesta;  
   }  
   boolean solucion_consulta(String consulta, String [] base, lista unificadas){ 
       boolean respuesta = false; 
       StringTokenizer tokens = new StringTokenizer(consulta,"&;."); 
       int argumentos = tokens.countTokens(); 
       tokens = new StringTokenizer (consulta,"&;.",true); 
       String argumento = tokens.nextToken()+"."; 
       if(argumentos==1) 
           respuesta=solu(argumento,base,unificadas); 
       else{ 
           boolean temporal = solu(argumento,base,unificadas); 
           for(int i =0;i<argumentos-1;i++){ 
               String op = tokens.nextToken(); 
               argumento=tokens.nextToken()+"."; 
               temporal = solucion_consulta_aux(temporal,solu(argumento,base,unificadas),op); 
                 
           } 
           respuesta = temporal; 
       } 
       POS=0; 
       Resultados.deepCopy(unificadas); 
       unificadas.PrimerNodo=null; 
       fail = false; 
       return respuesta; 
         
   } 
     
   boolean solucion_consulta_aux(boolean temp,boolean temp2,String op){ 
       boolean respuesta=false; 
       if(op.equals("&")){ 
           if(temp&temp2) 
               respuesta = true; 
       } 
       else{ 
           if(temp|temp2) 
               respuesta = true; 
       } 
         
       return respuesta; 
   } 
       
   //evalua una variable boolean temporal con el resultado de evaluar el parametro 2 y devuelve true o false.  
   boolean solucion_pares(boolean temp, String par2, String op, String [] base, lista unificadas){  
       boolean respuesta = false;  
       if(op.equals("&")){  
           if(temp&solucion(par2,unificadas,base))  
               respuesta = true;  
           else
               respuesta = false;  
       }  
       else
           if(temp|solucion(par2,unificadas,base))  
               respuesta = true;  
           else
               respuesta = false;  
       return respuesta;  
   }  
   boolean solucion(String arg1, lista unificadas, String [] base){  
       boolean respuesta=false;  
       String predicado = "";  
       String functor = separarfunctor(arg1);// Obtiene el functor de la consulta   
       int aridad = aridad(arg1);//calcula la aridad  
       if(functor.equals("write")) 
       {respuesta=write(arg1,unificadas);        
       } 
       else if(functor.equals("nl")|functor.equals("nl.")) 
          respuesta = write("nl",unificadas); 
       else if(functor.equals("fail")|functor.equals("fail.")){ 
           fail = true; 
           respuesta = false; 
       } 
       else{ 
           if(aridad==1){  
               String var = valor_de_variable(separarparametros(arg1),unificadas);  
               predicado = functor+"("+var+").";  
               if(existehecho(predicado,base))//Si el hecho existe en la base retorna True  
                   respuesta = true;  
               else if(unifica_predicado(predicado,0,base,unificadas).equals("")==false)  
                   respuesta = true;//Si no existe en la base, pero si su valor de variable unifica con el valor de algun hecho, retorna True  
           }  
           else{  
               predicado = functor+"(";  
               String parametros=separarparametros(arg1);  
               StringTokenizer tokens = new StringTokenizer(parametros,",");  
               for(int i = 0;i<aridad-1;i++){  
                   String var = valor_de_variable(tokens.nextToken(),unificadas);  
                   predicado=predicado+var+",";  
               }  
               String var = valor_de_variable(tokens.nextToken(),unificadas);  
               predicado=predicado+var+").";  
               //Hasta este punto, lo que hace es armar un nuevo predicado pero con los valores que tiene asignadas las variables  
               //Y hace la misma evaluacion en los siguientes condicionales  
               if(existehecho(predicado,base))  
                   respuesta = true;  
               else if((unifica_predicado(predicado,0,base, unificadas)).equals("")==false)  
                   respuesta = true;  
           }  
       } 
       return respuesta;  
   }  
       
   boolean solucion_regla(int pos,String predicado, String[] base,lista unificadas){  
       boolean respuesta = false;  
       String linea = unifica_predicado(predicado,pos,base, unificadas);//el valor de la linea es tomado del metodo indicado  
       if(linea.equals("")==false){  
           String antecedente = quitarantecedentes(linea);  
           //System.out.println(antecedente);  
           StringTokenizer tokens = new StringTokenizer(antecedente,";&");  
           int argumentos = tokens.countTokens();  
           StringTokenizer tokens2 = new StringTokenizer(antecedente,";&",true);  
           if(argumentos==1){  
               String argumento = tokens2.nextToken(); 
               if(separarfunctor(argumento).equals("write")) 
                 {respuesta=write(argumento,unificadas);         
                 } 
               else if(separarfunctor(argumento).equals("nl.")) 
                      respuesta = write("nl",unificadas); 
               else if(separarfunctor(argumento).equals("fail")){ 
                   fail = true; 
                   respuesta = false; 
               } 
               else
                   respuesta = solucion(argumento,unificadas,base);  
           }  
           else{//este metodo evalua de 2 en 2, es decir si hay 3 argumentos, evalua los primeros 2, y despues el resultado con el siguiente  
               boolean temporal = false; 
               String argumento = tokens2.nextToken(); 
               if(separarfunctor(argumento).equals("write")) 
               {temporal=write(argumento,unificadas);        
               } 
               else if(separarfunctor(argumento).equals("nl")) 
                      temporal = write("nl",unificadas); 
               else if(separarfunctor(argumento).equals("fail")){ 
                   fail = true; 
                   respuesta = false; 
               } 
               else
                   temporal = solucion(argumento,unificadas,base);  
               for(int i =0;i<argumentos-1;i++){  
                   String op = tokens2.nextToken(); 
                   argumento=tokens2.nextToken(); 
                   temporal = solucion_pares(temporal,argumento,op,base,unificadas);  
               } 
                 
//             if(argumentos%2==0){ 
//                 for(int i =0;i<argumentos-1;i++){  
//                     String op = tokens2.nextToken(); 
//                     argumento=tokens2.nextToken(); 
//                     temporal = solucion_pares(temporal,argumento,op,base,unificadas);  
//                 } 
//             } 
//             else{ 
//                 for(int i =0;i<argumentos;i+=2){  
//                     String op = tokens2.nextToken(); 
//                     argumento=tokens2.nextToken(); 
//                     temporal = solucion_pares(temporal,argumento,op,base,unificadas);  
//                 }   
//             } 
               respuesta = temporal; 
           } 
           //HACE BACTRACKING  
           if(respuesta==false & POS<(base.length-2)){  
               unificadas.PrimerNodo=null;  
               respuesta=solucion_regla(POS+1,predicado,base,unificadas);  
           }    
       }  
       else{  
               
       }  
       return respuesta;  
   }  
       
   boolean solu(String predicado,String[] base,lista unificadas) //parametros el predicado ingresado por el usuario, la base de conocimientos y la lista de variables unificadas  
   {boolean respuesta = false; 
   if(predicado.equals("fail.")) 
     {respuesta=false; 
     fail = true;} 
   if(separarfunctor(predicado).equals("write")) 
     {respuesta=write(predicado,unificadas);         
     } 
   else if(separarfunctor(predicado).equals("nl.")) 
          respuesta = write("nl",unificadas); 
   else
   { 
   if(existehecho(predicado,base))//si el hecho existe dentro de la base de conocimientos devuelve true  
   {respuesta = true;  
   }  
          
    else //entra en el else si es una regla  
    {  
        POS = obtener_linea_predicado(predicado,base,unificadas); 
        if(POS!=1){ 
            if(solucion_regla(POS,predicado,base,unificadas)&(fail!=true))//invoca al metodo solucion regla  
                respuesta = true;  
            else
                respuesta = false; 
        }  
    } 
    if(!unificadas.VaciaLista()&respuesta){//si la lista de unificadas no es vacia y la respuesta es true, imprime las varibales  
          
        //unificadas.Imprimir();  
    }  
    //unificadas.Imprimir();  
   } 
    return respuesta;  
   } 
     
   boolean esnumero(String cadena) 
   {boolean respuesta = false; 
    try
      { 
      Long.parseLong(cadena); 
      } 
    catch(Exception e) 
        {return false; 
        
        } 
   return true; 
   } 
       
   boolean variable_valida(String variable) 
   {boolean respuesta = false; 
    if(Character.isDigit(variable.charAt(0))) 
      {respuesta = false;     
      } 
    else
       {respuesta = true;} 
    if(esnumero(variable)) 
       {respuesta = true; } 
      return respuesta;   
   } 
       
   boolean write(String predicado,lista unifi) 
   {boolean respuesta = false; 
      
     int aridad = aridad(predicado); 
    if(aridad==1) 
      {if(variable_valida(separarparametros(predicado))) 
        {writeaux(predicado,unifi);respuesta=true;} 
       else
       {System.out.println("el caracter que quiere imprimir no es valido");  
       } 
        } 
          
                    
    else    
        {if(aridad==0) 
                   {if((predicado.equals("nl.")||predicado.equals("nl"))) 
                      {System.out.print("\n");; 
                      respuesta = true;} 
                     
                    else
                       System.out.println("write debe tener un parametro"); 
                   } 
          
        else
            {System.out.println("write debe tener solo un parametro");}} 
       
  
   return respuesta; 
   } 
     
   void writeaux(String predi,lista unificadas) 
   {String parametro =  separarparametros(predi); 
    String valor_parametro= ""; 
    if(esconstante(parametro)==false) 
      {if(unificadas.BuscarElemento(parametro, unificadas)) 
         {valor_parametro = valor_de_variable(parametro,unificadas); 
        System.out.println(valor_parametro);  
         } 
       else
          {System.out.println(parametro);         
          }          
      } 
    else
       {if(variable_valida(parametro)) 
        System.out.println(parametro); 
        else
            System.out.println("el valor que quiere imprimir no es valido"); 
        
       } 
      
   } 
     
}