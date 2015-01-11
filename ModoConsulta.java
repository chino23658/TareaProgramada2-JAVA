import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class ModoConsulta extends JFrame {

	private JPanel contentPane;
	public ModoConsulta(final lista Unificadas,final String [] base,int largobase) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblModoConsulta = new JLabel("Modo Consulta");
		lblModoConsulta.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblModoConsulta.setHorizontalAlignment(SwingConstants.CENTER);
		lblModoConsulta.setBounds(69, 11, 298, 27);
		contentPane.add(lblModoConsulta);
		
		final JTextPane textfield_consulta = new JTextPane();
		textfield_consulta.setBounds(45, 73, 343, 47);
		contentPane.add(textfield_consulta);
		
		JLabel lblIngreseLaConsulta = new JLabel("Ingrese la consulta");
		lblIngreseLaConsulta.setBounds(45, 49, 131, 14);
		contentPane.add(lblIngreseLaConsulta);
		
		final JTextPane textfield_respuesta = new JTextPane();
		textfield_respuesta.setBounds(45, 156, 343, 61);
		contentPane.add(textfield_respuesta);
		
		JLabel lblRespuesta = new JLabel("Respuesta:");
		lblRespuesta.setBounds(45, 131, 131, 14);
		contentPane.add(lblRespuesta);
		
		JButton btnOk = new JButton("Consultar");
		btnOk.setBounds(299, 127, 89, 23);
		btnOk.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				lista nueva = new lista();
				String nuevo = "";
				String consulta = textfield_consulta.getText();
				String [] consul;
				consul = new String[1];
				consul[0]=consulta;
				scanner sc = new scanner();
				Main a = new Main();
				solucion c = new solucion();
				if(sc.scannear(consul)&a.parsear(consul, 1)){
					boolean inferencia = c.solu(consulta, base, nueva);
					nuevo = listaenString(c.Resultados);
					if (inferencia==true)
						textfield_respuesta.setText("true"+"\n"+nuevo);
					else
						textfield_respuesta.setText("false");
				}
			}

			private String listaenString(lista nueva) {
				String respuesta= "";
				NodosLista aux = nueva.PrimerNodo;
				while(aux!=null){
					respuesta += aux.datos+" ";
					respuesta += aux.nombre+" ";
					aux=aux.siguiente;
				}
				return respuesta;
			}
		});
		contentPane.add(btnOk);
		
		JButton btnRegresar = new JButton("Regresar");
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModoAdministracion panel = new ModoAdministracion();
				panel.setVisible(true);
			}
		});
		btnRegresar.setBounds(299, 228, 89, 23);
		contentPane.add(btnRegresar);
		
			}
}
