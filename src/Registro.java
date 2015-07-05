
public class Registro {


		public int codigo;
		public String numero;
		public String entrada;
		public String saida;
		public String setor;
		public String visitante;
		public String empregado;
	

		
	    public Registro(int c, String n, String v, String em, String se, String e, String s) {
	        codigo = c;
	        numero = n;
	        visitante = v;
	        empregado = em;
	        setor = se;        
	        saida = s;
	        entrada = e;
	       
	       
	
	    }
	    
	    public void setCodigo(int c){ codigo = c; }  
	    public void setNumero(String n){numero = n;}
	    public void setVisitante (String v){visitante=v;}
	    public void setEmpregado (String em){empregado = em;}
	    public void setSetor (String s){setor = s;}
	    public void setEntrada(String e){entrada = e;}
	    public void setSaida(String s){saida = s;}	    
	    public void setRegistro(int c,String n, String v, String em, String se, String s,String e) {
	       setCodigo(c);
	       setNumero(n);
	       setVisitante (v);
	       setEmpregado (em);
	       setSetor (se);
	       setEntrada(e);
	       setSaida	(s);
	      
	    }
	   
	    public int getCodigo(){ return codigo; } 
	    public String getNumero(){return numero;}
	    public String getVisitante(){return visitante;}
	    public String getEmpregado(){return empregado;}
	    public String getSetor(){return setor;}
	    public String getEntrada(){ return entrada; }
	    public String getSaida(){return saida;}
	

}
