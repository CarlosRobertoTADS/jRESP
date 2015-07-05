public class Setor {
	
        public int codigo;
		public String sigla;
		public String telefone;
		public String descricao;
		public String unidade;
		

		
	    public Setor(int c, String d, String s, String t, String u) {
	       codigo = c;
	       sigla = s;
	       telefone = t;
	       descricao = d;
	       unidade = u;
	
	
	    }
	   
	    public void setCodigo (int c){codigo = c;}
	    public void setSigla(String s){ sigla = s; }
	    public void setTelefone(String t){ telefone = t; }
	    public void setDescricao(String d){descricao = d;}
	    public void setUnidade (String u){unidade = u;}
	
	    public void setSetor(int c, String s, String t, String d, String u) {
	       setCodigo(c);
	       setSigla(s);
	       setTelefone(t);
	       setDescricao(d);
	       setUnidade (u);
	  
	       	
	    }
	   
	    public int getCodigo(){return codigo;}
	    public String getSigla(){ return sigla; }
	    public String getTelefone(){ return telefone; }	
	    public String getDescricao(){return descricao;}
	    public String getUnidade () {return unidade;}

	
}




