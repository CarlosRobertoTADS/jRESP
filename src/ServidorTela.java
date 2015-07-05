	import java.awt.Container;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

	import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;
import javax.swing.JButton;

	public class ServidorTela extends JDialog implements ActionListener {
		public SNEO sneo;
		public JLabel 	lMatricula, lNome, lDataNasc, lSexo, lCPF, lRG;
		public JTextField tfmatricula, tfNome, tfCPF, tfRG, tfEndereco;
		public String sSexo[] = {"", "Masculino", "Feminino"};
		public JComboBox cbSexo, cbSetor; 
		public JFormattedTextField ftfDataNasc;
		public MaskFormatter mfDataNasc;
		public int distBotoes = 20;
		public ToolBar toolBar;
		public char operacao; //[0]Nenhuma operação; [1]Incluir; [2]Atualizar; [3]Excluir;
		public ServidorTabela ssTabela;
		private JLabel lblSetor;
		public SetorTabela sTabela;
		private JButton btnAddSetor;
		
		
		
		

	    public ServidorTela(Frame owner, String title, boolean modal, SNEO sneo, ServidorTabela ssTabela, SetorTabela sTabela) {
	      	super(owner, title, modal);
	      	this.sneo = sneo;
	      	setResizable(false);
	      	setBounds(280, 300, 650, 700);
	      	
	      	//Vinculando a referência com a Tabela de Clientes
	      	this.ssTabela = ssTabela;
	      	this.sTabela = sTabela;

	      	
	    	
	    	//Cria o container (box, caixa) para a  
	    	//agrupamento dos objetos
	    	Container areaTrabalho = getContentPane();
	    	areaTrabalho.setLayout(null);
	    	
	    	
	    	lMatricula = new JLabel("Matr\u00EDcula:");
	    	lMatricula.setBounds(20, 110, 130, 40);
	    	lMatricula.setFont(new Font("TimesRoman", Font.ITALIC, 25)); 
	    	areaTrabalho.add(lMatricula);
	    	
	    	tfmatricula = new JTextField("");
	    	tfmatricula.setBounds(160, 116, 200, 28);
	    	tfmatricula.addActionListener(this); 
	    	tfmatricula.setHorizontalAlignment(JTextField.LEFT);
	    	tfmatricula.setFont(new Font("TimesRoman", Font.ITALIC, 25));
	    	tfmatricula.setEditable(false);
	    	areaTrabalho.add(tfmatricula);
	    	
	    	lCPF = new JLabel("CPF:");
	    	lCPF.setBounds(21, 179, 74, 40);
	    	lCPF.setFont(new Font("TimesRoman", Font.ITALIC, 25)); 
	    	areaTrabalho.add(lCPF);
	    	
	    	tfCPF = new JTextField("");
	    	tfCPF.setBounds(154, 185, 200, 28);
	    	tfCPF.addActionListener(this); 
	    	tfCPF.setHorizontalAlignment(JTextField.LEFT);
	    	tfCPF.setFont(new Font("TimesRoman", Font.ITALIC, 25));
	    	tfCPF.setEditable(false);
	    	areaTrabalho.add(tfCPF);
	    	
	    	lNome = new JLabel("Nome:");
	    	lNome.setBounds(20, 250, 81, 40);
	    	lNome.setFont(new Font("TimesRoman", Font.ITALIC, 25)); 
	    	areaTrabalho.add(lNome);
	    	
	    	tfNome = new JTextField("");
	    	tfNome.setBounds(120, 262, 450, 28);
	    	tfNome.setHorizontalAlignment(JTextField.LEFT);
	    	tfmatricula.addActionListener(this); 
	    	tfNome.setFont(new Font("TimesRoman",Font.ITALIC, 25));
	    	tfNome.setEditable(false);
	    	areaTrabalho.add(tfNome);
	    	
	    	
	    	lDataNasc = new JLabel("Data de Nascimento:");
	    	lDataNasc.setBounds(20, 320, 227, 40);
	    	lDataNasc.setFont(new Font("TimesRoman", Font.ITALIC, 25)); 
	    	areaTrabalho.add(lDataNasc);
	    	        	
	    	try{
	    		mfDataNasc = new MaskFormatter("##/##/####");
	    		mfDataNasc.setPlaceholderCharacter('_');
	    	}
	    	catch(ParseException ex){
	    		//código para exceção
	    	}
	    	
	    	ftfDataNasc = new JFormattedTextField(mfDataNasc);
	        ftfDataNasc.setBounds(257, 326, 130, 28);
	        ftfDataNasc.addActionListener(this); 
	        ftfDataNasc.setFont(new Font("TimesRoman", Font.ITALIC, 25));
	        ftfDataNasc.setEditable(false);
	    	areaTrabalho.add(ftfDataNasc);
	        	    
	    	
	    	lSexo = new JLabel("Sexo:");
	    	lSexo.setBounds(20, 390, 100, 40);
	    	lSexo.setFont(new Font("TimesRoman", Font.ITALIC, 25)); 
	    	areaTrabalho.add(lSexo);
	    	
	    	cbSexo = new JComboBox(sSexo);
	    	cbSexo.setBounds(120, 402, 140, 28);
	    	cbSexo.setFont(new Font("TimesRoman", Font.ITALIC, 25)); 
	    	areaTrabalho.add(cbSexo);
	    	
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
	    	
	    	lRG = new JLabel("RG:");
	    	lRG.setFont(new Font("Serif", Font.ITALIC, 25));
	    	lRG.setBounds(20, 459, 75, 28);
	    	getContentPane().add(lRG);
	    	
	   
	    	
	    	
	    	
	    	tfRG = new JTextField();
	    	tfRG.setBounds(80, 459, 140, 28);
	    	getContentPane().add(tfRG);
	    	tfRG.setColumns(10);
	    	tfRG.setEditable(false);
	    	
	    	lblSetor = new JLabel("Setor:");
	    	lblSetor.setFont(new Font("Serif", Font.ITALIC, 25));
	    	lblSetor.setBounds(20, 516, 75, 28);
	    	getContentPane().add(lblSetor);
	    	
	    	cbSetor = new JComboBox();
	    	cbSetor.setBounds(88, 516, 450, 28);
	    	areaTrabalho.add(cbSetor);
	    	
	    	JLabel label = new JLabel("Endereço:");
	    	label.setFont(new Font("Serif", Font.ITALIC, 25));
	    	label.setBounds(20, 568, 116, 28);
	    	areaTrabalho.add(label);
	    	
	    	tfEndereco = new JTextField();
	    	tfEndereco.setText("");
	    	tfEndereco.setEditable(true);
	    	tfEndereco.setColumns(10);
	    	tfEndereco.setBounds(135, 568, 480, 34);
	    	areaTrabalho.add(tfEndereco);
	    	
	    	btnAddSetor = new JButton("ADD");
	    	btnAddSetor.addActionListener(new ActionListener() {
	    		public void actionPerformed(ActionEvent e) {
	    			preencherDados();
	    		}
	    	});
	    	btnAddSetor.setBounds(545, 516, 89, 28);
	    	areaTrabalho.add(btnAddSetor);
	    	
	    	JButton btnHabilitar = new JButton("Habilitar");
	    	btnHabilitar.addActionListener(new ActionListener(){
	    		public void actionPerformed(ActionEvent e){
	    			tfmatricula.setEditable(true);
	    		
	    		}
	    	});
	    	btnHabilitar.setBounds(370, 110, 89, 23);
	    	areaTrabalho.add(btnHabilitar);
	    	
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
		      else if(e.getSource()==tfmatricula)
		        tfNome.requestFocus();
		      else if(e.getSource()==tfNome)
		        ftfDataNasc.requestFocus();
		      else if(e.getSource()==ftfDataNasc)
		        cbSexo.requestFocus();
		      else 
		      	temp = 0;
		    
	  	}
	  	
	  	
	  	public void incluir(){
	  		
	  		tfmatricula.requestFocus();
	  		tfNome.setEditable(true);
			ftfDataNasc.setEditable(true);
			cbSexo.setEditable(true);	
			tfCPF.setEditable(true);
			tfRG.setEditable(true);
			cbSexo.setEditable(true);
			cbSetor.setEditable(true);
			toolBar.bloquearBotoes();
			desbloquearCampos();
           
			
			
			SimpleDateFormat dataent = new SimpleDateFormat("yyyy"); 		
	  		int temp = 0;
	  		dataent.getCalendar();
	  		Random gerar = new Random();
	  	    int numero = gerar.nextInt(10001)+ 9999;
	  	    
	  	    tfmatricula.setEnabled(true); 
	  	    tfmatricula.setEditable(false);
	  	    tfmatricula.setText(dataent.format(new Date())+numero);
	  	   
			operacao = '1';		 		 
		}
	  	
	  	public void atualizar(){
	  		confirmação();
	  		exclusao();
	  		tfmatricula.requestFocus();
			toolBar.metodoeditar();
			
			
			desbloquearCampos();
		    tfmatricula.setEnabled(true);
			tfmatricula.setEditable(true);
			operacao = '2';	
			 limpar();
			
		}
		
		public void excluir(){
			
			int temp = ssTabela.Remover(tfmatricula.getText());
			if (temp==1){
				JOptionPane.showMessageDialog(null, "Servidor removido com sucesso!","Aviso",
						JOptionPane.INFORMATION_MESSAGE);
				
			}else{
				JOptionPane.showMessageDialog(null, "Erro ao Excluir","Aviso",
						JOptionPane.INFORMATION_MESSAGE);
			}
			tfmatricula.requestFocus();
			toolBar.metodoExcluir();
			desbloquearCampos();
			operacao = '3';	
			
			
		}
		public void confirmar(){
			 
		       if("".equals(tfCPF.getText()) || ("".equals(tfmatricula.getText())|| ("".equals(cbSexo.getSelectedItem()))|| ("".equals(cbSetor.getSelectedItem())|| ("".equals(tfNome.getText())) || ("".equals(tfRG.getText())))))
		       { JOptionPane.showMessageDialog(null, "Preencha os campos  vazios !");
		       tfCPF.setText("");
		       tfNome.setText("");
		       tfRG.setText("");
		       
		        tfmatricula.setEnabled(true);
				tfNome.setEnabled(false);
				ftfDataNasc.setEnabled(false);
				cbSexo.setEnabled(false);	
				tfCPF.setEnabled(false);
				tfRG.setEnabled(false);
				cbSexo.setEnabled(false);
				cbSetor.setEnabled(true);
				toolBar.metodoconfirmar();
				 
				
		       } 
		       
		       else{
		     toolBar.metodoconfirmar();
			toolBar.desbloquearBotoes();
			
			
			String textoData = ftfDataNasc.getText();
			int dia = Integer.parseInt(textoData.substring(0,2));
			int mes = Integer.parseInt(textoData.substring(3,5));
			
			int ano = Integer.parseInt(textoData.substring(6,10));
				
			if(operacao == '1'){
			char sexo;
				String textoSexo = ""+cbSexo.getItemAt(cbSexo.getSelectedIndex());
				if(textoSexo.equals("Masculino") )
				   sexo = 'M';	
				else if(textoSexo.equals("Feminino"))
					sexo = 'F';
				else 
					sexo = ' ';
					
				if(ssTabela.add(Integer.parseInt(tfmatricula.getText()),tfCPF.getText(),tfRG.getText(),tfNome.getText(), dia, mes, ano, sexo,cbSetor.getSelectedItem().toString(),tfEndereco.getText() )=='1')
					JOptionPane.showMessageDialog(null, "Empregado cadastrado com sucesso!","Aviso", JOptionPane.INFORMATION_MESSAGE);			
				else
				
					JOptionPane.showMessageDialog(null, "Não foi possível cadastrar o Empregado!","Aviso", JOptionPane.INFORMATION_MESSAGE);							
			}		
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
		}
		
	   public void preencherDados(){
		   cbSetor.addItem("");
		if(sTabela.getNumero()==0)
  			JOptionPane.showMessageDialog(null, "Nenhum Setor cadastrado!","Aviso", JOptionPane.INFORMATION_MESSAGE);		 
  		else{
  		  for(int i=0; i<sTabela.getNumero(); i++)
	    	cbSetor.addItem(sTabela.getSetor(i));	      
  		}
	}
		public void  exclusao(){
			int temp = ssTabela.Remover(tfmatricula.getText());
				
			}
					
					public void confirmação(){

						String textoData = ftfDataNasc.getText();
						int dia = Integer.parseInt(textoData.substring(0,2));
						int mes = Integer.parseInt(textoData.substring(3,5));
						
						int ano = Integer.parseInt(textoData.substring(6,10));
							
						if(operacao == '1'){
						char sexo;
							String textoSexo = ""+cbSexo.getItemAt(cbSexo.getSelectedIndex());
							if(textoSexo.equals("Masculino") )
							   sexo = 'M';	
							else if(textoSexo.equals("Feminino"))
								sexo = 'F';
							else 
								sexo = ' ';
								
							if(ssTabela.add(Integer.parseInt(tfmatricula.getText()),tfCPF.getText(),tfRG.getText(),tfNome.getText(), dia, mes, ano, sexo,cbSetor.getSelectedItem().toString(),tfEndereco.getText() )=='1');
										
							
							
													
						}		
					       }
						

				
					
					
					
				


	  	public void limpar(){
			 tfmatricula.setText("");
			 tfNome.setText("");
			 tfCPF.setText("");
			 tfRG.setText("");
			 ftfDataNasc.setText("");
			 cbSexo.setSelectedItem("");
			 cbSetor.setSelectedItem("");
			 tfEndereco.setText("");
		}
	  	
	  	public void bloquearCampos(){
	  	 	tfmatricula.setEnabled(false);
			tfNome.setEnabled(false);
			ftfDataNasc.setEnabled(false);
			cbSexo.setEnabled(false);	
			
			 cbSetor.setEnabled(true);
			 tfEndereco.setEnabled(false);
	  	}
	  	
	  	public void desbloquearCampos(){
	  		
			tfNome.setEnabled(true);
			ftfDataNasc.setEnabled(true);
			cbSexo.setEnabled(true);	
			tfCPF.setEnabled(true);
			tfRG.setEnabled(true);
			cbSexo.setEnabled(true);
			cbSetor.setEnabled(true);
			tfEndereco.setEnabled(true);
	  	}
	  
	  	
	  	public void visualizar(){
	  		
	  	
	  		
	  		int temp= ssTabela.pesquisar(Integer.parseInt(tfmatricula.getText()));
	  		
	  		if(temp ==-1){
	  			JOptionPane.showMessageDialog(null, "Nenhum cliente cadastrado!","Aviso", JOptionPane.INFORMATION_MESSAGE);		 
	  		}
	  			
	  		else{
	  		 tfNome.setText(ssTabela.servidor[temp].getNome());
	  		 ftfDataNasc.setText(ssTabela.servidor[temp].getData());
	  		 cbSexo.selectWithKeyChar(ssTabela.servidor[temp].getSexo());
	  		 tfCPF.setText(ssTabela.servidor[temp].getCpf());
	  		 tfRG.setText(ssTabela.servidor[temp].getRg());
	  		 cbSetor.setSelectedItem(ssTabela.servidor[temp].getSetor());
	  		 tfEndereco.setText(ssTabela.servidor[temp].getEndereco());
	  		
	  	bloquearCampos();
	  	toolBar.metodopesquisar();
	  		
	  		 
	
	  	}
	    
	}
	}
