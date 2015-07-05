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

	public class UnidadeTela extends JDialog implements ActionListener {
		public SNEO sneo;
		public JLabel 	lRua, lNome, lCNPJ, lBairro;
		public JTextField tfRua, tfNome, tfCNPJ, tfBairro;
		public int distBotoes = 20;
		public ToolBar toolBar;
		public char operacao; //[0]Nenhuma operação; [1]Incluir; [2]Atualizar; [3]Excluir;
		public UnidadeTabela uTabela;
	
		
		
		

	    public UnidadeTela(Frame owner, String title, boolean modal, SNEO sneo, UnidadeTabela uTabela) {
	      	super(owner, title, modal);
	      	this.sneo = sneo;
	      	setResizable(false);
	      	setBounds(280, 300, 630, 420);
	      	
	      	//Vinculando a referência com a Tabela de Clientes
	      	this.uTabela = uTabela;
	      	
	    	
	    	//Cria o container (box, caixa) para a  
	    	//agrupamento dos objetos
	    	Container areaTrabalho = getContentPane();
	    	areaTrabalho.setLayout(null);
	    	
	    	lCNPJ = new JLabel ("CNPJ");
	    	lCNPJ.setBounds (20,110,100,40);
	    	lCNPJ.setFont(new Font("TimesRoman", Font.ITALIC,25));
	    	areaTrabalho.add(lCNPJ);
	    	
	    	tfCNPJ= new JTextField("");
	    	tfCNPJ.setBounds(120, 110, 200, 40);
	    	tfCNPJ.addActionListener(this); 
	    	tfCNPJ.setHorizontalAlignment(JTextField.LEFT);
	    	tfCNPJ.setFont(new Font("TimesRoman", Font.ITALIC, 25));
	    	tfCNPJ.setEditable(true);
	    	areaTrabalho.add(tfCNPJ);
	    	
	    	lNome = new JLabel("Nome");
	    	lNome.setBounds(20, 180, 150, 40);
	    	lNome.setFont(new Font("TimesRoman", Font.ITALIC, 25)); 
	    	areaTrabalho.add(lNome);
	    	
	    	tfNome = new JTextField("");
	    	tfNome.setBounds(120, 180, 200, 40);
	    	tfNome.addActionListener(this); 
	    	tfNome.setHorizontalAlignment(JTextField.LEFT);
	    	tfNome.setFont(new Font("TimesRoman", Font.ITALIC, 25));
	    	tfNome.setEditable(true);
	    	areaTrabalho.add(tfNome);
	    	
	    	lRua = new JLabel("Rua");
	    	lRua.setBounds(20, 250, 200, 40);
	    	lRua.setFont(new Font("TimesRoman", Font.ITALIC, 25)); 
	    	areaTrabalho.add(lRua);
	    	
	    	tfRua = new JTextField("");
	    	tfRua.setBounds(120, 250, 450, 40);
	    	tfRua.setHorizontalAlignment(JTextField.LEFT);
	    	tfRua.addActionListener(this); 
	    	tfRua.setFont(new Font("TimesRoman",Font.ITALIC, 25));
	    	tfRua.setEditable(true);
	    	areaTrabalho.add(tfRua);
	    	
	    	lBairro = new JLabel("Bairro");
	    	lBairro.setBounds(20, 320, 250, 40);
	    	lBairro.setFont(new Font("TimesRoman", Font.ITALIC, 25)); 
	    	areaTrabalho.add(lBairro);
	    	
	    	tfBairro = new JTextField("");
	    	tfBairro.setBounds(120, 320, 450, 40);
	    	tfBairro.setHorizontalAlignment(JTextField.LEFT);
	    	tfBairro.addActionListener(this); 
	    	tfBairro.setFont(new Font("TimesRoman",Font.ITALIC, 25));
	    	tfBairro.setEditable(true);
	    	areaTrabalho.add(tfBairro);
	    
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
		      else if(e.getSource()==tfCNPJ)
		        tfNome.requestFocus();
		      else if (e.getSource()== tfNome)
		    	  tfRua.requestFocus();
		      else if (e.getSource()== tfRua)
		    	  tfBairro.requestFocus();
		      else
		    	
                
		    	 
		      	temp = 0;
		    
	  	}
	  	
	  	
	  	public void incluir(){
	  		tfCNPJ.requestFocus();
			toolBar.metodoincluir();
			
			desbloquearCampos();
			operacao = '1';	
	  	
		
	  		
	  			
	  	}	
	
	  	public void atualizar(){ 
	  		exclusao();
	  		confirmação();
	  		toolBar.metodoeditar();
	  		tfCNPJ.requestFocus();
			toolBar.bloquearBotoes();
			
			desbloquearCampos();
			
			   tfCNPJ.setText("");
		       tfBairro.setText("");
		       tfNome.setText("");
		       tfRua.setText("");
		       
		       
		
			
			operacao = '2';		 		 
		}
		
		public void excluir(){
			
			tfCNPJ.requestFocus();
			int temp = uTabela.Remover(tfNome.getText());
			
			
			if (temp==1){
				JOptionPane.showMessageDialog(null, "Unidade removida com sucesso!","Aviso",
						JOptionPane.INFORMATION_MESSAGE);
				
			}else{
				JOptionPane.showMessageDialog(null, "Erro ao Excluir","Aviso",
						JOptionPane.INFORMATION_MESSAGE);
			}
			
			toolBar.metodoExcluir();
			desbloquearCampos();
			operacao = '3';		 	
			limpar();
		}
		public void confirmar(){
			
			  if("".equals(tfCNPJ.getText()) || ("".equals(tfNome.getText())|| ("".equals(tfBairro.getText())|| ("".equals(tfRua.getText())))))
		       { JOptionPane.showMessageDialog(null, "Erro campos vazios, Insira novamente os dados!");
		       tfCNPJ.setText("");
		       tfBairro.setText("");
		       tfNome.setText("");
		       tfRua.setText("");
		       
		       
		       
				tfNome.setEnabled(false);
				tfBairro.setEnabled(false);
				tfCNPJ.setEnabled(false);
				tfBairro.setEnabled(false);
				toolBar.metodoconfirmar();
				 
				
		       } 
		       
		       else{
			toolBar.metodoconfirmar();
			
			bloquearCampos();
			
				
			if(operacao == '1'){
				
					
				if(uTabela.add(Integer.parseInt(tfCNPJ.getText()), tfNome.getText(),tfRua.getText(),tfBairro.getText())=='1')
					JOptionPane.showMessageDialog(null, "Unidade cadastrada com sucesso!","Aviso", JOptionPane.INFORMATION_MESSAGE);			
				else
					JOptionPane.showMessageDialog(null, "Não foi possível cadastrar a unidade!","Aviso", JOptionPane.INFORMATION_MESSAGE);							
			}		


		    limpar();
		    
		}
		}
		
		public void  exclusao(){
        int temp = uTabela.Remover(tfNome.getText());
			
		}
		
		public void confirmação(){
		
				uTabela.add(Integer.parseInt(tfCNPJ.getText()), tfNome.getText(),tfRua.getText(),tfBairro.getText());
		
							
		}
	  	public void limpar(){
			 tfRua.setText("");
			 tfNome.setText("");
			 tfBairro.setText("");
			 tfCNPJ.setText("");
			 	 		 
		}
	  	
	  	public void bloquearCampos(){
	  	 	tfRua.setEnabled(false);
			tfNome.setEnabled(false);
			tfBairro.setEnabled(false);
		    tfCNPJ.setEnabled(false);
		    
			
	  	}
	  	
	  	public void desbloquearCampos(){
	  	 	tfRua.setEnabled(true);
			tfNome.setEnabled(true);
			tfBairro.setEnabled(true);
			tfCNPJ.setEnabled(true);
			
	  	}
	  	
	  	public void visualizar(){
	  		
	  		int temp= uTabela.pesquisar(Integer.parseInt(tfCNPJ.getText()));
	  		
	  		if(temp ==-1){
	  			JOptionPane.showMessageDialog(null, "Nenhuma unidade cadastrada!","Aviso", JOptionPane.INFORMATION_MESSAGE);		 
	  		}
	  			
	  		else{
	  		 tfNome.setText(uTabela.unidade[temp].getNome());
	  		 tfRua.setText(uTabela.unidade[temp].getRua());
	  		 tfBairro.setText(uTabela.unidade[temp].getBairro());
	  		}
	  		toolBar.metodopesquisar();
	  	}
	    
	}

