

	import java.awt.Container;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.lang.model.type.IntersectionType;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;
import javax.swing.JButton;
import javax.swing.SwingConstants;



		public class RegistroTela extends JDialog implements ActionListener {
			public SNEO sneo;
			public JLabel 	lCodigo,  lcodsetor, lNumero;
			public JTextField tfNome, tfCodigo, tfNumero;
			public JComboBox cbSetor, cbEmpregado, cbVisitante;
			public int distBotoes = 20;
			public ToolBar toolBar;
			public char operacao; //[0]Nenhuma operação; [1]Incluir; [2]Atualizar; [3]Excluir;
			public Registro registro;
			public RegistroTabela rTabela;
			public ServidorTabela ssTabela;
			public SetorTabela sTabela;		
			public UnidadeTabela uTabela;
			public VisitanteTabela vTabela;
			private JButton btnDataEHora;
			private JLabel lentrada;
			private JButton btnDataEHora_1;
			private JLabel lsaida;
			private JLabel lblMatrculaDoEmpregado;
			private JButton btnAddVisitante;
			private JButton btnAddSetor;
			private JButton btnAddEmpregado;
			public Consultar consultar;
			public JTable table;
			private JButton btnHabilitar;
			
			
			
			
			
			

		    public RegistroTela(Frame owner, String title, boolean modal, SNEO sneo,RegistroTabela rTabela, VisitanteTabela vTabela, ServidorTabela ssTabela, SetorTabela sTabela,  UnidadeTabela uTabela ) {
		      	super(owner, title, modal);
		      	this.sneo = sneo;
		      	setResizable(false);
		      	setBounds(280, 300,700, 600);
		      	
		      	//Vinculando a referência com a Tabela de Clientes
		     	this.rTabela = rTabela;
		      	this.vTabela = vTabela;
		     	this.ssTabela = ssTabela;
		      	this.sTabela = sTabela;
		      	this.uTabela = uTabela;
		     
		     
		    	
		    	//Cria o container (box, caixa) para a  
		    	//agrupamento dos objetos
		    	Container areaTrabalho = getContentPane();
		    	areaTrabalho.setLayout(null);
		    	
		    	
		    	lCodigo = new JLabel("Visitante:");
		    	lCodigo.setBounds(11, 82, 217, 40);
		    	lCodigo.setFont(new Font("TimesRoman", Font.ITALIC, 25)); 
		    	areaTrabalho.add(lCodigo);
		    	
		    	lcodsetor = new JLabel ("Setor:");
		    	lcodsetor.setBounds ( 11, 129, 200, 40);
		    	lcodsetor.setFont(new Font("TimesRoman", Font.ITALIC,25));
		    	areaTrabalho.add(lcodsetor);
		    	
		    	cbSetor = new JComboBox();
		    	cbSetor.setBounds(90, 133, 498, 40);
		    	cbSetor.setFont(new Font("TimesRoman", Font.ITALIC, 25));
		    	areaTrabalho.add(cbSetor);
		    	
		    	lCodigo = new JLabel("Código:");
		    	lCodigo.setBounds(10, 180, 90, 40);
		    	lCodigo.setFont(new Font("TimesRoman", Font.ITALIC, 25)); 
		    	areaTrabalho.add(lCodigo);
		    	
		    	tfCodigo = new JTextField("");
		    	tfCodigo.setBounds(110, 180, 200, 40);
		    	tfCodigo.setHorizontalAlignment(JTextField.LEFT);
		    	tfCodigo.addActionListener(this); 
		    	tfCodigo.setFont(new Font("TimesRoman",Font.ITALIC, 25));
		    	tfCodigo.setEditable(true);
		    	areaTrabalho.add(tfCodigo);
		    
		    
		    	
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
		    	
		    	btnDataEHora = new JButton("Data e hora da Entrada:");
		    	btnDataEHora.addActionListener(new ActionListener() {
		    		public void actionPerformed(ActionEvent arg0) {
		    			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");  
		    		    System.out.println(sdf.format(new Date()));  
		    		int temp = 0;
		    		sdf.getCalendar();
		    		
		    		lentrada.setText(sdf.format(new Date()));
		    		}
		    	});
		    	btnDataEHora.setBounds(20, 342, 150, 30);
		    	areaTrabalho.add(btnDataEHora);
		    	
		    	lentrada = new JLabel("");
		    	lentrada.setBounds(198, 342, 163, 30);
		    	areaTrabalho.add(lentrada);
		    	
		    	btnDataEHora_1 = new JButton("Data e hora da Sa\u00EDda:");
		    	btnDataEHora_1.addActionListener(new ActionListener() {
		    		public void actionPerformed(ActionEvent arg0) {
		    			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");  
		    		    System.out.println(sdf.format(new Date()));  
		    		int temp = 0;
		    		sdf.getCalendar();
		    		
		    		lsaida.setText(sdf.format(new Date()));
		    		}
		    	});
		    	btnDataEHora_1.setBounds(20, 408, 150, 30);
		    	areaTrabalho.add(btnDataEHora_1);
		    	
		    	lsaida = new JLabel("");
		    	lsaida.setBounds(198, 408, 163, 30);
		    	areaTrabalho.add(lsaida);
		    	
		    	lblMatrculaDoEmpregado = new JLabel("Empregado:");
		    	lblMatrculaDoEmpregado.setFont(new Font("Serif", Font.ITALIC, 25));
		    	lblMatrculaDoEmpregado.setBounds(20, 472, 276, 30);
		    	areaTrabalho.add(lblMatrculaDoEmpregado);
		    	
		    	cbEmpregado = new JComboBox();
		    	cbEmpregado.setBounds(156, 472, 432, 30);
		    	areaTrabalho.add(cbEmpregado);
		    	
		    	cbVisitante = new JComboBox();
		    	cbVisitante.setBounds(117, 90, 456, 36);
		    	areaTrabalho.add(cbVisitante);
		    	
		    	btnAddVisitante = new JButton("ADD ");
		    	btnAddVisitante.addActionListener(new ActionListener() {
		    		public void actionPerformed(ActionEvent arg0) {
		    			preencherDadosVisitante();
		    			
		    		}
		    	});
		    	btnAddVisitante.setBounds(583, 88, 86, 40);
		    	areaTrabalho.add(btnAddVisitante);
		    	
		    	btnAddSetor = new JButton("ADD");
		    	btnAddSetor.addActionListener(new ActionListener() {
		    		public void actionPerformed(ActionEvent e) {
		    			preencherDadosSetor();
		    		}
		    	});
		    	btnAddSetor.setBounds(598, 135, 89, 40);
		    	areaTrabalho.add(btnAddSetor);
		    	
		    	btnAddEmpregado = new JButton("ADD");
		    	btnAddEmpregado.addActionListener(new ActionListener() {
		    		public void actionPerformed(ActionEvent e) {
		    			
		    			preencherDadosServidor();
		    		}
		    	});
		    	btnAddEmpregado.setBounds(598, 472, 89, 33);
		    	areaTrabalho.add(btnAddEmpregado);
		    	
		    	lNumero = new JLabel("N\u00FAmero:");
		    	lNumero.setFont(new Font("Serif", Font.ITALIC, 25));
		    	lNumero.setBounds(11, 242, 90, 40);
		    	areaTrabalho.add(lNumero);
		    	
		    	tfNumero = new JTextField("");
		    	tfNumero.setHorizontalAlignment(SwingConstants.LEFT);
		    	tfNumero.setFont(new Font("Serif", Font.ITALIC, 25));
		    	tfNumero.setEnabled(false);
		    	tfNumero.setEditable(true);
		    	tfNumero.setBounds(110, 242, 101, 40);
		    	areaTrabalho.add(tfNumero);
		    	
		    	btnHabilitar = new JButton("Habilitar");
		    	JButton btnHabilitar = new JButton("Habilitar");
		    	btnHabilitar.addActionListener(new ActionListener(){
		    		public void actionPerformed(ActionEvent e){
		    			tfCodigo.setEditable(true);
		    		
		    		}
		    	});
		    	btnHabilitar.setBounds(323, 184, 89, 23);
		    	getContentPane().add(btnHabilitar);
		    
		    	
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
			    	  cbSetor.requestFocus();
			      else if(e.getSource()==cbVisitante)
			      cbEmpregado.requestFocus();
			   
			    	
			    		  
			 
			      	temp = 0;
			    
		  	}
		  	
		  	
		  	public void incluir(){
		  		
		  		
		  		tfCodigo.requestFocus();
				toolBar.bloquearBotoes();
				desbloquearCampos();
				
		  		SimpleDateFormat dataent = new SimpleDateFormat("yyyy"); 		
		  		int temp = 0;
		  		dataent.getCalendar();
		  		Random gerar = new Random();
		  	    int numero = gerar.nextInt(10001)+ 9999;
		  	    tfCodigo.setEnabled(true);
		  	    tfCodigo.setEditable(false);
		  	    tfCodigo.setText(dataent.format(new Date())+numero);
				operacao = '1';		 		 
			}
		  	
		  	public void atualizar(){
		  		tfCodigo.requestFocus();
				toolBar.bloquearBotoes();
				
				desbloquearCampos();
			
				
				operacao = '2';		 		 
			}
			
		       public void excluir(){
				
				/*int temp = rTabela.Remover(tfCodigo.getText());
				if (temp==1){
					JOptionPane.showMessageDialog(null, "Registro removido com sucesso!","Aviso",
							JOptionPane.INFORMATION_MESSAGE);
					
				}else{
					JOptionPane.showMessageDialog(null, "Erro ao Excluir","Aviso",
							JOptionPane.INFORMATION_MESSAGE);
				}*/
				tfCodigo.requestFocus();
				toolBar.bloquearBotoes();
				desbloquearCampos();
				operacao = '3';		 		 
			}
			public void confirmar(){
				  if("".equals(tfCodigo.getText()) || ("".equals(cbVisitante.getSelectedItem())||  ("".equals(cbEmpregado.getSelectedItem()))|| ("".equals(cbSetor.getSelectedItem()))))
			       { JOptionPane.showMessageDialog(null, "Erro campos vazios, Insira novamente os dados!");
			       tfCodigo.setText("");
			       cbEmpregado.setSelectedItem("");
			       cbSetor.setSelectedItem("");
			       cbVisitante.setSelectedItem("");
			       
			       
					
				    cbEmpregado.setEnabled(true);
					cbSetor.setEnabled(true);	
					tfCodigo.setEnabled(true);
					cbVisitante.setEnabled(true);
					toolBar.metodoconfirmar();
					 
					
			       } 
			       
			       else{
			     toolBar.desbloquearBotoes();
					
					bloquearCampos();
					
					if(operacao == '1'){
						
						
						if(rTabela.add(Integer.parseInt(tfCodigo.getText()),tfNumero.getText(),lsaida.getText(), lentrada.getText(),cbEmpregado.getSelectedItem().toString(),cbSetor.getSelectedItem().toString(),cbVisitante.getSelectedItem().toString())=='1')
							JOptionPane.showMessageDialog(null, "Registro cadastrado com sucesso!","Aviso", JOptionPane.INFORMATION_MESSAGE);			
						else
							JOptionPane.showMessageDialog(null, "Não foi possível cadastrar o Registro!","Aviso", JOptionPane.INFORMATION_MESSAGE);							
					}		
			
					
					   limpar();
				
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
					
			 
			
			  public void preencherDadosServidor(){
					cbEmpregado.addItem("");
				  if(ssTabela.getNumero()==0)
			  			JOptionPane.showMessageDialog(null, "Nenhum Empregado cadastrado!","Aviso", JOptionPane.INFORMATION_MESSAGE);		 
			  		else{
			  		  for(int i=0; i<ssTabela.getNumero(); i++)
				    	cbEmpregado.addItem(ssTabela.getServidor(i));     
			  		}
			 }
			  public void preencherDadosSetor(){
				  cbSetor.addItem("");
					if(sTabela.getNumero()==0)
			  			JOptionPane.showMessageDialog(null, "Nenhum SETOR cadastrado!","Aviso", JOptionPane.INFORMATION_MESSAGE);		 
			  		else{
			  		  for(int i=0; i<sTabela.getNumero(); i++)
				    	cbSetor.addItem(sTabela.getSetor(i));	      
			  		}
				}
					
				 public void preencherDadosVisitante(){
					 cbVisitante.addItem("");
						if(vTabela.getNumero()==0)
				  			JOptionPane.showMessageDialog(null, "Nenhum Visitante cadastrado!","Aviso", JOptionPane.INFORMATION_MESSAGE);		 
				  		else{
				  		  for(int i=0; i<vTabela.getNumero(); i++)
					    	cbVisitante.addItem(vTabela.getVisitante(i));     
				  		}
				 }
		
				 public void  exclusao(){
				        int temp = rTabela.Remover(tfCodigo.getText());
							
						}
						
						public void confirmação(){
					
							rTabela.add(Integer.parseInt(tfCodigo.getText()),tfNumero.getText(),lsaida.getText(), lentrada.getText(),cbEmpregado.getSelectedItem().toString(),cbSetor.getSelectedItem().toString(),cbVisitante.getSelectedItem().toString());
											
						}
				
		  	public void limpar(){
				 tfCodigo.setText("");
				 tfNumero.setText("");
				
				 
				 		 		 
			}
		  	
		  	public void bloquearCampos(){
				tfCodigo.setEnabled(false);
				tfNumero.setEnabled(false);
			
		  	}
		  	
		  	public void desbloquearCampos(){
		  	 	tfCodigo.setEnabled(true);
				
				
				tfCodigo.setEnabled(true);
				
			
					
		  	}
		  	
		  	public void visualizar(){
		  		int temp= rTabela.pesquisar(Integer.parseInt(tfCodigo.getText()));
		  		
		  		if(temp ==-1){
		  			JOptionPane.showMessageDialog(null, "Nenhum registro cadastrado!","Aviso", JOptionPane.INFORMATION_MESSAGE);		 
		  		}
		  			
		  		else{
		  			lentrada.setText(rTabela.registro[temp].getEntrada());
		  		    lsaida.setText(rTabela.registro[temp].getSaida());
		  			cbVisitante.setSelectedItem(rTabela.registro[temp].getVisitante());
		  			cbSetor.setSelectedItem(rTabela.registro[temp].getSetor());
		  			cbEmpregado.setSelectedItem(rTabela.registro[temp].getEmpregado());
		  			tfNumero.setText(rTabela.registro[temp].getNumero());
		  			
		  			
		  			
		  			
		  		
		
		    
		}
		}


		}



