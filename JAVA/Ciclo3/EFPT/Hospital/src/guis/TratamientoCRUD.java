package guis;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.util.Date;
import java.awt.event.ActionEvent;
import guis.*;
import clases.*;

public class TratamientoCRUD extends JDialog {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private JComboBox cmbTipoTratamiento;
	private JTextField txtIDTratamiento;
	private JTextField txtNombrePaciente;
	private JComboBox cmbNombreMedico;
	private JTextField txtDniPaciente;
	private JButton btnCrearCita;
	private JButton btnActualizarTabla;
	private JButton btnCrearFile;
	DefaultTableModel model= new DefaultTableModel();
	Tratamientos tratamiento= new Tratamientos();
	private JButton btnSeleccionarMedicamen;
	private JButton btnActualizarCita;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			TratamientoCRUD dialog = new TratamientoCRUD();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public TratamientoCRUD() {
		setBounds(100, 100, 967, 396);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(296, 10, 647, 339);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		///////////
		
		///////////
		
		JLabel lblNewLabel = new JLabel("TRATAMIENTOS");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel.setBounds(10, 12, 208, 30);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ID Tratamiento");
		lblNewLabel_1.setBounds(10, 51, 102, 13);
		getContentPane().add(lblNewLabel_1);
		
		cmbTipoTratamiento = new JComboBox();
		cmbTipoTratamiento.setModel(new DefaultComboBoxModel(new String[] {"Terapia física", "Quimioterapia", "Radioterapia", "Terapias ocupacionales", "Cuidado intensivo", "Tratamientos psicológicos", "Diálisis", "Transplantes", "Otros....."}));
		cmbTipoTratamiento.setToolTipText("");
		cmbTipoTratamiento.setBounds(108, 74, 175, 21);
		getContentPane().add(cmbTipoTratamiento);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tipo Tratamiento");
		lblNewLabel_1_1.setBounds(10, 74, 102, 13);
		getContentPane().add(lblNewLabel_1_1);
		
		txtIDTratamiento = new JTextField();
		txtIDTratamiento.setBounds(108, 48, 175, 19);
		getContentPane().add(txtIDTratamiento);
		txtIDTratamiento.setColumns(10);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Nombre Paciente");
		lblNewLabel_1_1_1.setBounds(10, 105, 102, 13);
		getContentPane().add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Medico");
		lblNewLabel_1_1_2.setBounds(10, 160, 102, 13);
		getContentPane().add(lblNewLabel_1_1_2);
		
		cmbNombreMedico = new JComboBox();
		cmbNombreMedico.setModel(new DefaultComboBoxModel(new String[] {"mendez", "hugarte"}));
		cmbNombreMedico.setToolTipText("");
		cmbNombreMedico.setBounds(108, 156, 175, 21);
		getContentPane().add(cmbNombreMedico);
		
		txtNombrePaciente = new JTextField();
		txtNombrePaciente.setColumns(10);
		txtNombrePaciente.setBounds(108, 102, 175, 19);
		getContentPane().add(txtNombrePaciente);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("DNI paciente");
		lblNewLabel_1_1_1_1.setBounds(10, 128, 102, 13);
		getContentPane().add(lblNewLabel_1_1_1_1);
		
		txtDniPaciente = new JTextField();
		txtDniPaciente.setColumns(10);
		txtDniPaciente.setBounds(108, 128, 175, 19);
		getContentPane().add(txtDniPaciente);
		
		btnCrearCita = new JButton("Crear Nueva Cita");
		btnCrearCita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnCrearCitaJButton(e);
			}
		});
		btnCrearCita.setBounds(10, 223, 133, 21);
		getContentPane().add(btnCrearCita);
		
		JButton btnELiminarCita = new JButton("Eliminar Cita");
		btnELiminarCita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnELiminarCitaJButton(e);
			}
		});
		btnELiminarCita.setBounds(10, 248, 276, 21);
		getContentPane().add(btnELiminarCita);
		
		btnActualizarTabla = new JButton("Actualizar Tabla");
		btnActualizarTabla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnActualizarTablaJButton(e);
			}
		});
		btnActualizarTabla.setBounds(153, 328, 133, 21);
		getContentPane().add(btnActualizarTabla);
		
		btnCrearFile = new JButton("Crear BD");
		btnCrearFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnCrearFileJButton(e);
			}
		});
		btnCrearFile.setBounds(10, 328, 133, 21);
		getContentPane().add(btnCrearFile);
		tratamiento.MostrarRegistroTabla(table);
		
		btnSeleccionarMedicamen = new JButton("Seleccionar");
		btnSeleccionarMedicamen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnSeleccionarMedicamenJButton(e);
			}
		});
		btnSeleccionarMedicamen.setBounds(10, 279, 276, 21);
		getContentPane().add(btnSeleccionarMedicamen);
		
		btnActualizarCita = new JButton("Actualizar Cita");
		btnActualizarCita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnActualizarCitaJButton(e);
			}
		});
		btnActualizarCita.setBounds(153, 223, 133, 21);
		getContentPane().add(btnActualizarCita);
	}
	protected void actionPerformedBtnCrearCitaJButton(ActionEvent e) {
		Tratamientos tratamiento=new Tratamientos(LeerIDTratamiento(),LeerNombrePaciente(),LeerDNIPaciente(),LeerNombreDoctor(),leerTipoTratamiento(),2);
	    CrearRegistroTratamimento(
	    		tratamiento.getIdTramamiento(),
	    		tratamiento.getTipoTratamiento(),
	    		tratamiento.getPaciente(), 
	    		tratamiento.getDNIpaciente(),
	            tratamiento.getMedico());
	}
	
	
	protected void actionPerformedBtnCrearFileJButton(ActionEvent e) {
	     Tratamientos t=new Tratamientos();
	     t.CreateArchivoTXT();
	     txtIDTratamiento.setText("");
			txtDniPaciente.setText("");
			txtNombrePaciente.setText("");
	     
	}
	protected void actionPerformedBtnActualizarTablaJButton(ActionEvent e) {
	    tratamiento.MostrarRegistroTabla(table);
	    txtIDTratamiento.setText("");
		txtDniPaciente.setText("");
		txtNombrePaciente.setText("");
	}
	protected void actionPerformedBtnELiminarCitaJButton(ActionEvent e) {
	    tratamiento.EliminarRegistrotabla(table, txtIDTratamiento);
	    txtIDTratamiento.setText("");
		txtDniPaciente.setText("");
		txtNombrePaciente.setText("");
	}
	protected void actionPerformedBtnSeleccionarMedicamenJButton(ActionEvent e) {
		txtIDTratamiento.setText(String.valueOf(tratamiento.getIdTramamiento()));
		txtNombrePaciente.setText(tratamiento.getPaciente());
		txtDniPaciente.setText(String.valueOf(tratamiento.getDNIpaciente()));
		cmbNombreMedico.setSelectedItem(tratamiento.getMedico());
		cmbTipoTratamiento.setSelectedItem(tratamiento.getTipoTratamiento());
		tratamiento.SeleccionarMedicamento(table);
		
		
	}  
	protected void actionPerformedBtnActualizarCitaJButton(ActionEvent e) {
		
		tratamiento.EditarCita(table);
	}
	/////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////

	
	public int LeerIDTratamiento() {
		return Integer.parseInt(txtIDTratamiento.getText());	}
	
	public String leerTipoTratamiento() {
		return cmbTipoTratamiento.getSelectedItem().toString();
	}
	public String LeerNombrePaciente() {
		return txtNombrePaciente.getText();	}
	
	public int LeerDNIPaciente() {
		return Integer.parseInt(txtDniPaciente.getText());	}
	
	public String LeerNombreDoctor() {
		return cmbNombreMedico.getSelectedItem().toString();
	}
	
	
	public void CrearRegistroTratamimento(int id, String tipoTratamiento, String nombrePaciente, int DNIPaciente, String doctor) {
	    try (FileWriter f = new FileWriter("Tratamiento.txt", true)) { // true para agregar
	        f.write(id + "," + tipoTratamiento + "," + nombrePaciente + "," + DNIPaciente +","+doctor+ ","+ estado() + "," + fechaInicio() + "," + fechaFinDate().toString() + "\n");
	        System.out.println("Se registró correctamente");
	    } catch (Exception e) {
	        JOptionPane.showMessageDialog(null, "Ocurrió un error: " + e.getMessage());
	    }
	}


	public String fechaInicio() {
	    Date fecha = new Date();
	    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); // Formato deseado
	    return formato.format(fecha); // Devuelve la fecha formateada como String
	}

	public String estado() {
	    // Obtener la fecha de fin como String
	    String fechaFin = fechaFinDate(); // Ahora es un String

	    // Convertirlo a Date para la comparación
	    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
	    Date fechaFinDate = null;
	    try {
	        fechaFinDate = formato.parse(fechaFin);
	    } catch (ParseException e) {
	        e.printStackTrace();
	    }

	    if (fechaFinDate != null && fechaFinDate.after(new Date())) {
	        return "Activo";
	    } else {
	        return "Vencido";
	    }
	}

	public String fechaFinDate() {
	    Calendar calendario = Calendar.getInstance();
	    calendario.setTime(new Date()); // Establece la fecha actual
	    calendario.add(Calendar.YEAR, 2); // Aumenta dos años
	    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); // Define el formato
	    return formato.format(calendario.getTime()); // Devuelve la fecha formateada como String
	}
	
}

	

