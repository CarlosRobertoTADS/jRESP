public class RegistroTabela {
	
	

		public int numero, tamanho;
		public Registro[] registro;
		
		
		
	    public RegistroTabela(int t) {
	    	tamanho = t;
	    	numero = 0;
	    	criarTabela();
	    }
	    public void setNumero(int n){ numero = n; }
	    public void setTamaho(int t){ tamanho = t; }
	    public int getNumero(){ return numero; }
	    public int getTamanho(){ return tamanho; }
	    public String getRegistro(int i){ //i: indice
	    	return ("Código do Registro:"+ registro[i].getCodigo()+"   " +"Numero:"+registro[i].getNumero()+ "     "+"Entrada:"+ registro[i].getEntrada()+"     "+"Saida:"+registro[i].getSaida()+"     "+"Visitante:"+registro[i].getVisitante()+"     "+ "Setor:"+registro[i].getSetor()+"    "+"Empregado:"+registro[i].getEmpregado()); 
	   
	   	}
	  
	    public void criarTabela(){
	    	registro = new Registro[getTamanho()];    	
	    	for(int i=0; i<getTamanho(); i++){    	
	    		registro[i] = new Registro(0,"", "", "","","","");
	    		
	    	}    	
	    }
	    
	    public char add(int codigo,String numero, String entrada, String saida, String visitante, String setor, String empregado){
	    	char resp = '0'; //0: insucesso; 1: sucesso
	    	if(getNumero() < getTamanho()){    	  
		    	int indice = getNumero();
		    	registro[indice].setCodigo(codigo);
		    	registro[indice].setNumero(numero);
		    	registro[indice].setEntrada(entrada);
		    	registro[indice].setSaida(saida);
		    	registro[indice].setVisitante(visitante);
		    	registro[indice].setSetor(setor);
		    	registro[indice].setEmpregado(empregado);
		    	setNumero(indice + 1);
		    	resp = '1';	    	
		    }
		    return resp;
	    }
	   
	    
	   
	    public int pesquisar ( int codigo){
	    	int temp = -1;
	    	
	    	if(getNumero()>0){
	    		for (int i=0; i<getNumero(); i++){
	    			if(registro[i].getCodigo()== codigo){
	    				temp = i;
	    			}
	    		}
	    	}
	    	return temp;
	    }

	    
	   public int Remover(String numero){
			int num=0;
			if(getNumero()>0){
		    	for(int i=0; i<getNumero(); i++){ 
		    	   if(registro[i].getNumero()== numero){
		    		   registro[i].setRegistro(0,"","","","", " ", "");
		    		   num=1;
		    	   }
		    	 }
			}
			return num;
		}
	  
	  
	    
	    
}
	    
	



