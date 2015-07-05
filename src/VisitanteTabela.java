import javax.swing.Icon;

public class VisitanteTabela {


		public int numero, tamanho;
		public Visitante[] visitante;
		
	    public VisitanteTabela(int t) {
	    	tamanho = t;
	    	numero = 0;
	    	criarTabela();
	    }
	    public void setNumero(int n){ numero = n; }
	    public void setTamaho(int t){ tamanho = t; }
	    public int getNumero(){ return numero; }
	    public int getTamanho(){ return tamanho; }
	    public String getVisitante(int i){ //i: indice
	    	return ("Matricula:" + visitante[i].getCodigo() + "\n" + "CPF:"+ visitante[i].getCpf()+ "\n" + "RG:" + visitante[i].getRg()+ "Nome: "+ visitante[i].getNome() + "\n" + "Data de Nasc" + visitante[i].getData()+ "\n" + "Sexo:" + visitante[i].getSexo()+ "     " + "Empregado:"+visitante[i].getEmpregado() + "       "); 
	   	}
	    
	    public void criarTabela(){
	    	visitante = new Visitante[getTamanho()];    	
	    	for(int i=0; i<getTamanho(); i++){    	
	        DataNasc dNasc = new DataNasc(0,0,0);
	        visitante[i] = new Visitante(0,"","","",dNasc,'0',"",null);
	    	}    	
	    }
	    
	    public char add(int codigo, String rg, String cpf, String nome,  int dia, int mes, int ano, char sexo, String empregado, Icon foto){
	    	char resp = '0'; //0: insucesso; 1: sucesso
	    	if(getNumero() < getTamanho()){    	  
		    	int indice = getNumero();
		    	visitante[indice].setCodigo(codigo);
		    	visitante[indice].setRg(rg);
		    	visitante[indice].setCpf(cpf);
		    	visitante[indice].setNome(nome);	
		    	DataNasc dNasc = new DataNasc(dia,mes,ano);
		    	visitante[indice].setDataNasc(dNasc);
		    	visitante[indice].setSexo(sexo);
		    	visitante[indice].setEmpregado(empregado);
		    	visitante[indice].setFoto(foto);
		    	setNumero(indice + 1);
		    	resp = '1';	    	
		    }
		    return resp;
	    }
	    
	 
	    public int pesquisar ( int codigo){
	    	int temp = -1;
	    	
	    	if(getNumero()>0){
	    		for (int i=0; i<getNumero(); i++){
	    			if(visitante[i].getCodigo()== codigo){
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
		    	   if(visitante[i].getNome()== nome){
		    		   DataNasc dNasc = new DataNasc(0,0,0);
		    		   visitante[i].setVisitante(0,"","","",dNasc,'0',"",null);
		    		   num=1;
		    	   }
		    	 }
			}
			return num;
		}
	    
	    
	}


