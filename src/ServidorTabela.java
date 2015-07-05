
public class ServidorTabela {
	
		public int numero, tamanho;
		public Servidor[] servidor;
	
	   
		public ServidorTabela(int t) {
	    	tamanho = t;
	    	numero = 0;
	    	criarTabela();
	    }
	    public void setNumero(int n){ numero = n; }
	    public void setTamaho(int t){ tamanho = t; }
	    public int getNumero(){ return numero; }
	    public int getTamanho(){ return tamanho; }
	    public String getServidor(int i){ //i: indice
	    	return ("Matricula:" + servidor[i].getMatricula() + "\n" + "CPF:"+ servidor[i].getCpf()+ "\n" + "RG:" + servidor[i].getRg()+ "Nome: "+ servidor[i].getNome() + "\n" + "Data de Nasc" + servidor[i].getData()+ "  " + "Sexo:" + servidor[i].getSexo()+ "      " + "Setor:" +servidor[i].getSetor() + "      " + "Endereco" +servidor[i].getEndereco() ); 
	   	}
	    
	    public void criarTabela(){
	    	servidor = new Servidor[getTamanho()];    	
	    	for(int i=0; i<getTamanho(); i++){    	
	    		DataNasc dNasc = new DataNasc(0,0,0);	
	    		servidor[i] = new Servidor(0,"","","",dNasc,'0',"","");	
	    	}    	
	    }
	    
	    public char add(int matricula, String cpf, String rg, String nome, int dia, int mes, int ano, char sexo, String setor, String endereco){
	    	char resp = '0'; //0: insucesso; 1: sucesso
	    	if(getNumero() < getTamanho()){    	  
		    	int indice = getNumero();
		    	servidor[indice].setMatricula(matricula);
		    	servidor [indice].setCpf(cpf);
		    	servidor [indice].setRg(rg);
		    	servidor[indice].setNome(nome);
		    	DataNasc dNasc = new DataNasc(dia,mes,ano);
		    	servidor[indice].setDataNasc(dNasc);
		    	servidor[indice].setSexo(sexo);
		    	servidor[indice].setSetor(setor);
		    	servidor [indice].setEndereco(endereco);
		    	setNumero(indice + 1);
		    	resp = '1';	    	
		    }
		    return resp;
	    }
	    

	    
	    public int pesquisar ( int matricula){
	    	int temp = -1;
	    	
	    	if(getNumero()>0){
	    		for (int i=0; i<getNumero(); i++){
	    			if(servidor[i].getMatricula()== matricula){
	    				temp = i;
	    			}
	    		}
	    	}
	    	return temp;
	    }
	    
	    
	    
	    public int Remover(String nome){
			int num=0;
			if(getNumero()>0){
		    	for(int i=0; i<getNumero(); i++){ 
		    	   if(servidor[i].getNome()== nome){
		    		   DataNasc dNasc = new DataNasc(0,0,0);
		    		   servidor[i].setServidor("",0,"","",dNasc,'0',"","");
		    		   num=1;
		    	   }
		    	 }
			}
			return num;
		}

	     }
	    
	    
	

