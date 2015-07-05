	import java.awt.Container;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

	import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;
import javax.swing.JTextPane;
import javax.swing.JEditorPane;
import javax.swing.JButton;

	public class SetorTela extends JDialog implements ActionListener {
		public SNEO sneo;
		public JLabel 	lSigla, lNome, lCodigo, lCnpjUnidade, lDescricao;
		public JTextField tfSigla, ttelefone, tfCodigo, tfDescricao;
		public int distBotoes = 20;
		public ToolBar toolBar;
		public char operacao; //[0]Nenhuma operação; [1]Incluir; [2]Atualizar; [3]Excluir;
		public SetorTabela sTabela;
		public UnidadeTabela uTabela;
	
		public JComboBox cbcnpjunidade;
		private JButton btnAddUnidade;
		
	
		
		
		

	    public SetorTela(Frame owner, String title, boolean modal, SNEO sneo, SetorTabela sTabela, UnidadeTabela uTabela) {
	      	super(owner, title, modal);
	      	this.sneo = sneo;
	      	setResizable(false);
	      	setBounds(280, 300, 630, 496);
	      	
	      	//Vinculando a referência com a Tabela de Clientes
	      	this.sTabela = sTabela;
	      	this.uTabela = uTabela;
	      	
	    	
	    	//Cria o container (box, caixa) para a  
	    	//agrupamento dos objetos
	    	Container areaTrabalho = getContentPane();
	    	areaTrabalho.setLayout(null);
	    	
	    	lCodigo = new JLabel ("Código");
	    	lCodigo.setBounds (20,110,100,40);
	    	lCodigo.setFont(new Font("TimesRoman", Font.ITALIC,25));
	    	areaTrabalho.add(lCodigo);
	    	
	    	tfCodigo= new JTextField("");
	    	tfCodigo.setBounds(120, 110, 200, 40);
	    	tfCodigo.addActionListener(this); 
	    	tfCodigo.setHorizontalAlignment(JTextField.LEFT);
	    	tfCodigo.setFont(new Font("TimesRoman", Font.ITALIC, 25));
	    	tfCodigo.setEditable(true);
	    	areaTrabalho.add(tfCodigo);
	    	
	    	lSigla = new JLabel("Sigla");
	    	lSigla.setBounds(20, 180, 150, 40);
	    	lSigla.setFont(new Font("TimesRoman", Font.ITALIC, 25)); 
	    	areaTrabalho.add(lSigla);
	    	
	    	tfSigla = new JTextField("");
	    	tfSigla.setBounds(120, 180, 200, 40);
	    	tfSigla.addActionListener(this); 
	    	tfSigla.setHorizontalAlignment(JTextField.LEFT);
	    	tfSigla.setFont(new Font("TimesRoman", Font.ITALIC, 25));
	    	tfSigla.setEditable(true);
	    	areaTrabalho.add(tfSigla);
	    	
	    	lNome = new JLabel("Telefone");
	    	lNome.setBounds(20, 250, 100, 40);
	    	lNome.setFont(new Font("TimesRoman", Font.ITALIC, 25)); 
	    	areaTrabalho.add(lNome);
	    	
	    	ttelefone = new JTextField("");
	    	ttelefone.setBounds(131, 388, 200, 40);
	    	ttelefone.setHorizontalAlignment(JTextField.LEFT);
	    	ttelefone.addActionListener(this); 
	    	ttelefone.setFont(new Font("TimesRoman",Font.ITALIC, 25));
	    	ttelefone.setEditable(true);
	    	areaTrabalho.add(ttelefone);
	    	
	    	lCnpjUnidade= new JLabel("CNPJ da Unidade:");
	    	lCnpjUnidade.setFont(new Font("Serif", Font.ITALIC, 25));
	    	lCnpjUnidade.setBounds(20, 324, 208, 33);
	    	areaTrabalho.add(lCnpjUnidade);
	    	
	    	cbcnpjunidade = new JComboBox();
	    	cbcnpjunidade.setBounds(228, 329, 386, 28);
	    	areaTrabalho.add(cbcnpjunidade);
	    	
	    	lDescricao= new JLabel("Descrição");
	    	lDescricao.setFont(new Font("Serif", Font.ITALIC, 25));
	    	lDescricao.setBounds(20, 391, 138, 33);
	    	areaTrabalho.add(lDescricao);
	    	

	    	 tfDescricao = new JTextField("");
	    	 tfDescricao.setBounds(120, 251, 200, 40);
	    	 tfDescricao.setHorizontalAlignment(JTextField.LEFT);
	    	 tfDescricao.addActionListener(this); 
	    	 tfDescricao.setFont(new Font("TimesRoman",Font.ITALIC, 25));
	    	 tfDescricao.setEditable(true);
	    	areaTrabalho.add(tfDescricao);
	    	
	    	
	    	
	    
	    	toolBar = new ToolBar();
	    	toolBar.setBounds(1, 1, 700, 70); 	
	    	toolBar.bIncluir.addActionListener(this);    	  	
	    	toolBar.bAtualizar.addActionListener(this);
	    	toolBar.bExcluir.addActionListener(this);
	    	toolBar.bConfirmar.addActionListener(this);    	
	    	toolBar.bLimpar.addActionListener(this);    	
	    	toolBar.bPesquisar.addActionListener(this);
	    	
	    	areaTrabalho.add(toolBar);
	    	toolBar.desbloquearBotoes();
	    	toolBar.bIncluir.requestFocus();
	    	
	    	btnAddUnidade = new JButton("ADD");
	    	btnAddUnidade.addActionListener(new ActionListener() {
	    		public void actionPerformed(ActionEvent e) {
	    			preencherDados();
	    		}
	    	});
	    	btnAddUnidade.setBounds(525, 368, 89, 23);
	    	getContentPane().add(btnAddUnidade);
	    	
	    	
	    	
	    
	    	operacao = '0';
	    	limpar();
	    	bloquearCampos();
	    }
	    
	    
	    public void actionPerformed(ActionEvent e){ 
	    	int temp = 0;
		      if (e.getSource()==toolBar.bIncluir)	
		    	incluir();
		      else if(e.getSource()==toolBar.bAtualizar)
		        atualizar();
		      else if(e.getSource()==toolBar.bExcluir)
		        excluir();
		      else if(e.getSource()==toolBar.bConfirmar)
		        confirmar();
		      else if(e.getSource()==toolBar.bLimpar)
		        limpar();
		      else if(e.getSource()==toolBar.bPesquisar)
		      	visualizar();
		      else if(e.getSource()==tfCodigo)
		        tfSigla.requestFocus();
		      else if (e.getSource()== tfSigla)
		    	  ttelefone.requestFocus();
		      else
		    	
                
		    	 
		      	temp = 0;
		    
	  	}
	  	

	  		
	    	
	    
		
	  	
	  	public void incluir(){
	  	
	  		tfSigla.requestFocus();
			toolBar.bloquearBotoes();
			desbloquearCampos();
			operacao = '1';		 		 
		}
	  	
	  	public void atualizar(){
	  		confirmação();
	  		exclusao();
	  		tfSigla.requestFocus();
			toolBar.bloquearBotoes();
			
			desbloquearCampos();
			  tfCodigo.setText("");
		       tfSigla.setText("");
		       ttelefone.setText("");
		       tfDescricao.setText("");
		       cbcnpjunidade.setSelectedItem("");
			
			operacao = '2';		
			 limpar();
		}
		
		public void excluir(){
			

			int temp = sTabela.Remover(tfSigla.getText());
			if (temp==1){
				JOptionPane.showMessageDialog(null, "Setor removido com sucesso!","Aviso",
						JOptionPane.INFORMATION_MESSAGE);
				
			}else{
				JOptionPane.showMessageDialog(null, "Erro ao Excluir","Aviso",
						JOptionPane.INFORMATION_MESSAGE);
			}
			tfSigla.requestFocus();
			toolBar.bloquearBotoes();
			desbloquearCampos();
			operacao = '3';		 		 
		}
		public void confirmar(){
			  if("".equals(tfCodigo.getText()) || ("".equals(tfSigla.getText())|| ("".equals(ttelefone.getText())|| ("".equals(tfDescricao.getText())||("".equals(cbcnpjunidade.getSelectedItem()))))))
		       { JOptionPane.showMessageDialog(null, "Erro campos vazios, Insira novamente os dados!");
		       tfCodigo.setText("");
		       tfSigla.setText("");
		       ttelefone.setText("");
		       tfDescricao.setText("");
		       cbcnpjunidade.setSelectedItem("");
		   
		       
		       
				tfCodigo.setEnabled(false);	
				cbcnpjunidade.setEnabled(false);	
				tfSigla.setEnabled(false);
				ttelefone.setEnabled(false);
				tfDescricao.setEnabled(false);
				
				toolBar.metodoconfirmar();
				 
				
		       } 
		       
		       else{
			toolBar.desbloquearBotoes();
			
			bloquearCampos();
			
				
			if(operacao == '1'){
				
					
				if(sTabela.add(Integer.parseInt(tfCodigo.getText()),tfSigla.getText(), ttelefone.getText(),tfDescricao.getText(), cbcnpjunidade.getSelectedItem().toString())=='1')
					JOptionPane.showMessageDialog(null, "Setor cadastrado com sucesso!","Aviso", JOptionPane.INFORMATION_MESSAGE);			
				else
					JOptionPane.showMessageDialog(null, "Não foi possível cadastrar o cliente!","Aviso", JOptionPane.INFORMATION_MESSAGE);							
			}		
			/*else{
				if(operacao == '2'){
				
				}			
		 		else{
		 			if(operacao == '3'){
		 				
		 			}
		 			else
		 		
			}	
			*/		 
				
		    limpar();
		    toolBar.metodoconfirmar();
		
		}
		}
		 public void preencherDados(){
			 cbcnpjunidade.addItem("");
		  		
				if(uTabela.getNumero()==0)
		  			JOptionPane.showMessageDialog(null, "Nenhuma unidade cadastrada!","Aviso", JOptionPane.INFORMATION_MESSAGE);		 
		  		else{
		  		  for(int i=0; i<uTabela.getNumero(); i++)
			    	cbcnpjunidade.addItem(uTabela.getUnidade(i));     
		  		}
		 }
		 
			public void  exclusao(){
				int temp = sTabela.Remover(tfSigla.getText());
					
				}
				
				public void confirmação(){
				
					
					sTabela.add(Integer.parseInt(tfCodigo.getText()),tfSigla.getText(), ttelefone.getText(),tfDescricao.getText(), cbcnpjunidade.getSelectedItem().toString());
					
						
						
						}
					

				
	  	public void limpar(){
			 tfSigla.setText("");
			 ttelefone.setText("");
			 tfCodigo.setText("");
             tfDescricao.setText("");
             cbcnpjunidade.setSelectedItem("");
		}
	  	
	  	public void bloquearCampos(){
	  	 	tfSigla.setEnabled(false);
			ttelefone.setEnabled(false);
			tfCodigo.setEnabled(false);
			tfDescricao.setEnabled(false);
			
	  	}
	  	
	  	public void desbloquearCampos(){
	  	 	tfSigla.setEnabled(true);
			ttelefone.setEnabled(true);
			tfCodigo.setEnabled(true);
			tfDescricao.setEnabled(true);
			
	  	}
	  	
	  	public void visualizar(){
	  		
	  		int temp= sTabela.pesquisar(Integer.parseInt(tfCodigo.getText()));
	  		
	  		if(temp ==-1){
	  			JOptionPane.showMessageDialog(null, "Nenhum cliente cadastrado!","Aviso", JOptionPane.INFORMATION_MESSAGE);		 
	  		}
	  			
	  		else{
	  		 ttelefone.setText(sTabela.setor[temp].getTelefone());
	  		 tfSigla.setText(sTabela.setor[temp].getSigla());
	  		 tfDescricao.setText(sTabela.setor[temp].getDescricao());
	  		 cbcnpjunidade.setSelectedItem(sTabela.setor[temp].getUnidade());
	  		 
	  		}
	  	}
	}

