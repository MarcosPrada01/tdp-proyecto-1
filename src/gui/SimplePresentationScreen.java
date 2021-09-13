package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entities.Student;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class SimplePresentationScreen extends JFrame {

	private JPanel contentPane;
	private JPanel tabInformation;
	private JTabbedPane tabbedPane;
	private Student studentData;
	private JLabel lblLU;
	private JTextField textFieldLU;
	private JTextField textFieldNombre;
	private JTextField textFieldEmail;
	private JTextField textFieldGithub;
	private JTextField textFieldApellido;
	private JLabel lblFechaHora;

	/**
	 * Crea una ventana.
	 * @param studentData: una clase que contiene todos los datos de un estudiante.
	 */
	public SimplePresentationScreen(Student studentData) {
		
		this.studentData = studentData;
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setTitle("TdP-DCIC-UNS 2021 :: Pantalla de presentacion");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(615, 230));
		setResizable(false);
		setContentPane(contentPane);
		
		init();
		setIconImage(new ImageIcon(getClass().getResource("/images/tdp.png")).getImage());
	}
	
	/**
	 * Crea todos los componentes internos de la ventana.
	 */
	private void init() {
		contentPane.setLayout(null);
		// Tabbed Pane to student personal data
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(5, 5, 430, 191);
		tabInformation = new JPanel();
		tabInformation.setPreferredSize(new Dimension(425, 275));
		tabbedPane.addTab("Informacion del alumno", null, tabInformation, "Muestra la informacion declarada por el alumno");
		contentPane.add(tabbedPane, BorderLayout.WEST);
		tabInformation.setLayout(null);
		
		//Label del numero de lejajo.
		lblLU = new JLabel("LU");
		lblLU.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblLU.setBounds(11, 8, 14, 14);
		tabInformation.add(lblLU);
		
		//Caja de texto del numero de lejajo.
		textFieldLU = new JTextField();
		textFieldLU.setText(Integer.toString(studentData.getId()));
		textFieldLU.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldLU.setBounds(78, 5, 337, 20);
		tabInformation.add(textFieldLU);
		textFieldLU.setColumns(10);
		
		//Label del apellido.
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblApellido.setBounds(11, 36, 45, 14);
		tabInformation.add(lblApellido);
		
		//Caja de texto del apellido.
		textFieldApellido = new JTextField();
		textFieldApellido.setText(studentData.getLastName());
		textFieldApellido.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldApellido.setColumns(10);
		textFieldApellido.setBounds(78, 58, 337, 20);
		tabInformation.add(textFieldApellido);
		
		//Label del nombre.
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNombre.setBounds(11, 61, 44, 14);
		tabInformation.add(lblNombre);
		
		//Label del E-mail.
		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEmail.setBounds(11, 86, 35, 14);
		tabInformation.add(lblEmail);
		
		//Label del URL de Github.
		JLabel lblGithubUrl = new JLabel("Github URL");
		lblGithubUrl.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblGithubUrl.setBounds(11, 111, 62, 14);
		tabInformation.add(lblGithubUrl);
		
		//Caja de texto del nombre.
		textFieldNombre = new JTextField();
		textFieldNombre.setText(studentData.getFirstName());
		textFieldNombre.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldNombre.setColumns(10);
		textFieldNombre.setBounds(78, 30, 337, 20);
		tabInformation.add(textFieldNombre);
		
		//Caja de texto del E-mail.
		textFieldEmail = new JTextField();
		textFieldEmail.setText(studentData.getMail());
		textFieldEmail.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(78, 83, 337, 20);
		tabInformation.add(textFieldEmail);
		
		//Caja de texto del URL de Github.
		textFieldGithub = new JTextField();
		textFieldGithub.setText(studentData.getGithubURL());
		textFieldGithub.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldGithub.setColumns(10);
		textFieldGithub.setBounds(78, 108, 337, 20);
		tabInformation.add(textFieldGithub);
		contentPane.add(tabbedPane, BorderLayout.WEST);
		
		//Label de la imagen.
		JLabel lblImagen = new JLabel("");
		lblImagen.setBounds(445, 27, 143, 134);
		ImageIcon imagen= new ImageIcon(SimplePresentationScreen.class.getResource(studentData.getPathPhoto()));
		Icon icono= new ImageIcon(imagen.getImage().getScaledInstance(lblImagen.getWidth(),lblImagen.getHeight(),Image.SCALE_DEFAULT));
		lblImagen.setIcon(icono);
		this.repaint();
		contentPane.add(lblImagen);
		
		//Creo una fecha.
		Calendar fecha= new GregorianCalendar();
		
		//Creo los componentes de la fecha.
		String anio= Integer.toString(fecha.get(Calendar.YEAR));
		String mes= Integer.toString(fecha.get(Calendar.MONTH)+1);
		String dia= Integer.toString(fecha.get(Calendar.DATE));
		
		String hora= Integer.toString(fecha.get(Calendar.HOUR_OF_DAY));
		String minuto= Integer.toString(fecha.get(Calendar.MINUTE));
		String segundo= Integer.toString(fecha.get(Calendar.SECOND));
		
		//Creo un String con los componentes de la fecha.
		String fechaCompleta= dia+"/"+mes+"/"+anio;
		String horaExacta= hora+":"+minuto+":"+segundo;
		
		//Label de la fecha.
		lblFechaHora = new JLabel("Esta ventana fue generada el "+ fechaCompleta +" a las: "+horaExacta);
		lblFechaHora.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblFechaHora.setBounds(11, 138, 404, 14);
		tabInformation.add(lblFechaHora);
		contentPane.add(tabbedPane, BorderLayout.WEST);
	}
}
