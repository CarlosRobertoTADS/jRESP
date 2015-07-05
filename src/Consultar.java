import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.table.DefaultTableModel;
import javax.swing.JTextPane;


public class Consultar extends JFrame {
    public SNEO sneo;
	private JPanel contentPane;
	private JTextField tfMostrar;
	JTextPane tpmos;
	private JTable table;
	public RegistroTabela rTabela;
	private JTextField tfPesquisar;
	private JLabel lCodigoReg;
	
	
	
	public Consultar(SNEO sneo, RegistroTabela rTabela) {
		
		this.sneo = sneo;
		this.rTabela = rTabela;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 959, 559);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		
		 tfMostrar = new JTextField("");
    	 tfMostrar.setBounds(38, 66, 895, 147);
    	 tfMostrar.setHorizontalAlignment(JTextField.LEFT);
    	 tfMostrar.setFont(new Font("Arial", Font.PLAIN, 12));
    	 tfMostrar.setEditable(false);
    	 
    	 contentPane.add(tfMostrar);
		
    	 
    	 JButton btnNewButton = new JButton("Pesquisar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				preencherDados();
			}
		});
		btnNewButton.setBounds(440, 22, 99, 23);
		contentPane.add(btnNewButton);
		
		tfPesquisar = new JTextField();
		tfPesquisar.setBounds(205, 23, 225, 20);
		contentPane.add(tfPesquisar);
		tfPesquisar.setColumns(10);
		
		lCodigoReg = new JLabel("DIGITE C\u00D3DIGO DO RESGISTRO:");
		lCodigoReg.setBounds(10, 26, 185, 14);
		contentPane.add(lCodigoReg);
		
		
		
	}
	public void preencherDados(){
		int temp= rTabela.pesquisar(Integer.parseInt(tfPesquisar.getText()));
  		
  		if(temp ==-1){
  			JOptionPane.showMessageDialog(null, "Nenhum Registro cadastrado!","Aviso", JOptionPane.INFORMATION_MESSAGE);		 
  		}
  			
  		else{
  			
  		 tfMostrar.setText(rTabela.registro[temp].getVisitante());
  		 tfMostrar.setText(rTabela.registro[temp].getSetor());
  		 tfMostrar.setText(rTabela.registro[temp].getEntrada());
  		 tfMostrar.setText(rTabela.registro[temp].getSaida());
  		 tfMostrar.setText(rTabela.registro[temp].getEmpregado());
	
		
		
	  		}
	}
  		}
		
	
	 

