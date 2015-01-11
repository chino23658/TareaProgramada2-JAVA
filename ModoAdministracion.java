import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.StringTokenizer;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class ModoAdministracion extends JFrame {
	int largobase = 0;
	private JPanel contentPane;
	public ModoAdministracion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblModoAdministracion = new JLabel("Modo Administracion");
		lblModoAdministracion.setHorizontalAlignment(SwingConstants.CENTER);
		lblModoAdministracion.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblModoAdministracion.setBounds(64, 11, 298, 27);
		contentPane.add(lblModoAdministracion);
		
		final JTextPane textPane = new JTextPane();
		textPane.setBounds(42, 74, 349, 145);
		contentPane.add(textPane);
		
		
		JLabel lblNewLabel = new JLabel("Ingrese la base de conocimiento");
		lblNewLabel.setBounds(42, 49, 250, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnOk = new JButton("Consultar");
		btnOk.setBounds(302, 230, 89, 23);
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String base = textPane.getText();
				StringTokenizer tokens = new StringTokenizer(base,"\r");
				while(tokens.hasMoreTokens()){
					largobase++;
					String parada = tokens.nextToken();
					
				}
				hacerArreglo(base,largobase);
				
				
			}

			private void hacerArreglo(String base, int largobase) {
				String [] baseconocimiento;
				baseconocimiento = new String[largobase];
				StringTokenizer tokens = new StringTokenizer(base,"\n\r");
				for(int i=0;i<largobase;i++){
					baseconocimiento[i]=tokens.nextToken();
					System.out.println(baseconocimiento[i]);
				}
				scanner sc = new scanner();
				Main a = new Main();
				if(sc.scannear(baseconocimiento)&a.parsear(baseconocimiento, largobase)){
					lista nueva = new lista();
					ModoConsulta panel = new ModoConsulta(nueva,baseconocimiento,largobase);
					panel.setVisible(true);
				}
				
				
			}
		});
		contentPane.add(btnOk);
		
		}
}
