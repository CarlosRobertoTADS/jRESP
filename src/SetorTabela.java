public class SetorTabela {	

		public int numero, tamanho;
		public Setor[] setor;
		
		
		
	    public SetorTabela(int t) {
	    	tamanho = t;
	    	numero = 0;
	    	criarTabela();
	    }
	    public void setNumero(int n){ numero = n; }
	    public void setTamaho(int t){ tamanho = t; }
	    public int getNumero(){ return numero; }
	    public int getTamanho(){ return tamanho; }
	    public String getSetor(int i){ //i: indice
	    	return ("Código do Setor:"+ setor[i].getCodigo()+"   "+"Sigla do Setor:" + setor[i].getSigla() +"    " +"Telefone do Setor:"+ setor[i].getTelefone()+"     "+"Descricao:"+setor[i].getDescricao()+ "      "+"Unidade:"+setor[i].getUnidade()+"\n" ); 
	   
	   	}
	  
	    public void criarTabela(){
	    	setor = new Setor[getTamanho()];    	
	    	for(int i=0; i<getTamanho(); i++){    	
	    		setor[i] = new Setor(i, null, null,null,null);
	    		
	    	}    	
	    }
	    
	    public char add(int codigo, String sigla, String telefone, String descricao, String unidade){
	    	char resp = '0'; //0: insucesso; 1: sucesso
	    	if(getNumero() < getTamanho()){    	  
		    	int indice = getNumero();
		    	setor[indice].setCodigo(codigo);
		    	setor[indice].setSigla(sigla);
		    	setor[indice].setDescricao(descricao);	
		    	setor[indice].setTelefone(telefone);
		    	setor[indice].setUnidade(unidade);
		   
		    	setNumero(indice + 1);
		    	resp = '1';	    	
		    }
		    return resp;
	    }
	   
	    
	   
	    public int pesquisar ( int codigo){
	    	int temp = -1;
	    	
	    	if(getNumero()>0){
	    		for (int i=0; i<getNumero(); i++){
	    			if(setor[i].getCodigo()== codigo){
	    				temp = i;
	    			}
	    		}
	    	}
	    	return temp;
	    }
	    
	    public int Remover(String sigla){
			int num=0;
			if(getNumero()>0){
		    	for(int i=0; i<getNumero(); i++){ 
		    	   if(setor[i].getSigla().equals(sigla)){
		    		   setor[i].setSetor(0," ", " ","","");
		    		   num=1;
		    	   }
		    	 }
			}
			return num;
		}
	  
	    
	    
}
	    
	

