	import java.util.StringTokenizer;


public class tokenizer {
		
		public tokenizer(String texto, listaSimple nuevaLista){
			StringTokenizer st = new StringTokenizer(texto,";&:-.");
			while(st.hasMoreTokens()){
				
				nuevaLista.InsertaFinal(st.nextToken());
					
					
			}
		}
	}

	