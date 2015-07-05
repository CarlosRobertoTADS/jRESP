import javax.swing.JOptionPane;


public class UnidadeTabela {	

		public int numero, tamanho;
		public Unidade[] unidade;
		
		
		
	    public UnidadeTabela(int t) {
	    	tamanho = t;
	    	numero = 0;
	    	criarTabela();
	    }
	    public void setNumero(int n){ numero = n; }
	    public void setTamaho(int t){ tamanho = t; }
	    public int getNumero(){ return numero; }
	    public int getTamanho(){ return tamanho; }
	    public String getUnidade(int i){ //i: indice
	    	return ("Código da Unidade:"+ unidade[i].getCnpj()+"   "+"Nome:" + unidade[i].getNome() +"    " +"Rua:"+ unidade[i].getRua()+"     "+"Bairro:"+ unidade[i].getBairro()+"\n" ); 
	   
	   	}
	  
	    public void criarTabela(){
	    	unidade = new Unidade[getTamanho()];    	
	    	for(int i=0; i<getTamanho(); i++){    	
	    		unidade[i] = new Unidade(i, "", "", "");
	    		
	    	}    	
	    }
	    
	    public char add(int cnpj, String nome, String rua, String bairro){
	    	char resp = '0'; //0: insucesso; 1: sucesso
	    	if(getNumero() < getTamanho()){    	  
		    	int indice = getNumero();
		        unidade[indice].setCnpj(cnpj);
		    	unidade[indice].setNome(nome);
		    	unidade[indice].setRua(rua);	
		    	unidade[indice].setBairro(bairro);
		    	setNumero(indice + 1);
		    	resp = '1';	    	
		    }
		    return resp;
	    }

	   
	   
	    public int pesquisar ( int cnpj){
	    	int temp = -1;
	    	
	    	if(getNumero()>0){
	    		for (int i=0; i<getNumero(); i++){
	    			if(unidade[i].getCnpj()== cnpj){
	    				temp = i;
	    			}
	    		}
	    	}
	    	return temp;
	    }
	    
	    public int Remover(String nome){
			int temp=0;
			if(getNumero()>0){
		    	for(int i=0; i<getNumero(); i++){ 
		    	   if(unidade[i].getNome().equals(nome)){
		    		   unidade[i].setUnidade(0," ", " ","");
		    		   temp=1;
		    	   }
		    	 }
			}
			return temp;
		}
}




	    

	    
	

