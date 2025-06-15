package guis;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Iterator;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import Model.Actividad;
import Model.Solicitud;
import antlr.collections.List;

import javax.swing.JTextArea;
import java.awt.Font;

public class DlgSolicitud extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblIdSolicitud;
	private JLabel lblArchivoAdjunto;
	private JLabel lblActividad;
	private JLabel lblEstado;
	private JLabel lblFechaRegistro;
	private JTextField txtIdSolicitud;
	private JTextField txtArchivoAdjunto;
	private JComboBox<Object> cboActividad;
	private JComboBox<String> cboEstado;
	private JTextField txtFechaRegistro;
	private JButton btnBuscar;
	private JButton btnOK;
	private JButton btnOpciones;
	private JButton btnAdicionar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnListar;
	private JScrollPane scrollPane;
	private JTextArea txtSalida;

	// Tipo de operaci�n a procesar: Adicionar, Consultar, Modificar o Eliminar
	private int tipoOperacion;

	// Constantes para los tipos de operaciones
	public final static int ADICIONAR = 0;
	public final static int CONSULTAR = 1;
	public final static int MODIFICAR = 2;
	public final static int ELIMINAR = 3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DlgSolicitud dialog = new DlgSolicitud();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public DlgSolicitud() {
		setResizable(false);
		setTitle("Mantenimiento | Solicitud");
		setBounds(100, 100, 810, 604);
		getContentPane().setLayout(null);

		lblIdSolicitud = new JLabel("Id Solicitud :");
		lblIdSolicitud.setBounds(10, 10, 149, 23);
		getContentPane().add(lblIdSolicitud);

		lblArchivoAdjunto = new JLabel("Archivo adjunto :");
		lblArchivoAdjunto.setBounds(10, 35, 149, 23);
		getContentPane().add(lblArchivoAdjunto);

		lblActividad = new JLabel("Actividad :");
		lblActividad.setBounds(10, 62, 149, 23);
		getContentPane().add(lblActividad);

		lblEstado = new JLabel("Estado :");
		lblEstado.setBounds(10, 88, 149, 23);
		getContentPane().add(lblEstado);

		txtIdSolicitud = new JTextField();
		txtIdSolicitud.setBounds(174, 10, 86, 23);
		getContentPane().add(txtIdSolicitud);
		txtIdSolicitud.setEditable(false);
		txtIdSolicitud.setColumns(10);

		txtArchivoAdjunto = new JTextField();
		txtArchivoAdjunto.setBounds(174, 35, 251, 23);
		getContentPane().add(txtArchivoAdjunto);
		txtArchivoAdjunto.setColumns(10);

		cboActividad = new JComboBox<Object>();
		cboActividad.setBounds(174, 60, 251, 26);
		getContentPane().add(cboActividad);

		String[] estados = { "PE", "AC", "AN" };
		cboEstado = new JComboBox<String>();
		cboEstado.setBounds(174, 88, 86, 23);
		getContentPane().add(cboEstado);
		for (String estado : estados) {
			cboEstado.addItem(estado);
		}

		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(this);
		btnBuscar.setEnabled(false);
		btnBuscar.setBounds(324, 10, 101, 23);
		getContentPane().add(btnBuscar);

		btnOK = new JButton("OK");
		btnOK.addActionListener(this);
		btnOK.setBounds(325, 88, 100, 23);
		getContentPane().add(btnOK);

		btnOpciones = new JButton("Opciones");
		btnOpciones.addActionListener(this);
		btnOpciones.setBounds(555, 10, 100, 75);
		getContentPane().add(btnOpciones);

		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(this);
		btnAdicionar.setBounds(664, 10, 120, 23);
		getContentPane().add(btnAdicionar);

		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.setBounds(664, 36, 120, 23);
		getContentPane().add(btnModificar);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(664, 62, 120, 23);
		getContentPane().add(btnEliminar);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 146, 775, 371);
		getContentPane().add(scrollPane);

		txtSalida = new JTextArea();
		txtSalida.setFont(new Font("Monospaced", Font.PLAIN, 13));
		scrollPane.setViewportView(txtSalida);

		btnListar = new JButton("Listar");
		btnListar.addActionListener(this);
		btnListar.setBounds(345, 525, 115, 29);
		getContentPane().add(btnListar);

		lblFechaRegistro = new JLabel("Fecha registro :");
		lblFechaRegistro.setBounds(10, 115, 149, 20);
		getContentPane().add(lblFechaRegistro);

		txtFechaRegistro = new JTextField();
		txtFechaRegistro.setEditable(false);
		txtFechaRegistro.setBounds(174, 112, 146, 26);
		getContentPane().add(txtFechaRegistro);
		txtFechaRegistro.setColumns(10);

		habilitarEntradas(false);
		habilitarBotones(true);
		cargarActividades();
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnListar) {
			actionPerformedBtnListar(arg0);
		}
		if (arg0.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(arg0);
		}
		if (arg0.getSource() == btnModificar) {
			actionPerformedBtnModificar(arg0);
		}
		if (arg0.getSource() == btnAdicionar) {
			actionPerformedBtnAdicionar(arg0);
		}
		if (arg0.getSource() == btnOpciones) {
			actionPerformedBtnOpciones(arg0);
		}
		if (arg0.getSource() == btnOK) {
			actionPerformedBtnOK(arg0);
		}
		if (arg0.getSource() == btnBuscar) {
			actionPerformedBtnBuscar(arg0);
		}
	}

	protected void actionPerformedBtnBuscar(ActionEvent arg0) {
		buscar();
	}

	protected void actionPerformedBtnOK(ActionEvent arg0) {
		switch (tipoOperacion) {
		case ADICIONAR:
			adicionar();
			break;
		case MODIFICAR:
			modificar();
			break;
		case ELIMINAR:
			eliminar();
		}
	}

	protected void actionPerformedBtnOpciones(ActionEvent arg0) {
		limpiar();
	}

	protected void actionPerformedBtnListar(ActionEvent arg0) {
		listar();
	}

	protected void actionPerformedBtnAdicionar(ActionEvent arg0) {
		tipoOperacion = ADICIONAR;
		habilitarEntradas(true);
		habilitarBotones(false);
		txtArchivoAdjunto.requestFocus();
	}

	protected void actionPerformedBtnModificar(ActionEvent arg0) {
		tipoOperacion = MODIFICAR;
		txtIdSolicitud.setEditable(true);
		habilitarBotones(false);
		txtIdSolicitud.requestFocus();
	}

	protected void actionPerformedBtnEliminar(ActionEvent arg0) {
		tipoOperacion = ELIMINAR;
		txtIdSolicitud.setEditable(true);
		habilitarBotones(false);
		txtIdSolicitud.requestFocus();
	}

	void cargarActividades() {
	    EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysqlconexion");
	    EntityManager manager = factory.createEntityManager();

	    try {
	        java.util.List<Actividad> listaActividad = manager.createQuery("SELECT a FROM Actividad a", Actividad.class).getResultList();

	        if (listaActividad.isEmpty()) {
	            System.out.println("Tabla vacía");
	        } else {
	            for (Actividad actividad : listaActividad) {
	                cboActividad.addItem(actividad); // asegúrate que cboActividad está inicializado
	            }
	        }
	    } catch (Exception e) {
	        e.printStackTrace(); // mejor que un solo "ERRRORR"
	    } finally {
	        manager.close();
	        factory.close();
	    }
	}


	void listar() {
	    EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysqlconexion");
	    EntityManager manager = factory.createEntityManager();

	    try {
	        String codigo = "SELECT s FROM Solicitud s";
	        java.util.List<Solicitud> listaSolicitud = manager.createQuery(codigo, Solicitud.class).getResultList();

	        StringBuilder sb = new StringBuilder();
	        for (Solicitud solicitud : listaSolicitud) {
	            // Suponiendo que quieres imprimir el ID de la actividad asociada
	            sb.append("Actividad ID: ")
	              .append(solicitud.getActividad().getIdActividad())
	              .append(" - Estado: ")
	              .append(solicitud.getEstado())
	              .append("\n");
	        }

	        txtSalida.setText(sb.toString());
	    } catch (Exception e) {
	        e.printStackTrace();
	        System.out.println("ERROR");// mejor para debug que solo "ERRRORR"
	    } finally {
	        factory.close();
	        manager.close();
	    }
	}


	void adicionar() {
		
		EntityManagerFactory factory= Persistence.createEntityManagerFactory("mysqlconexion");
		EntityManager manager= factory.createEntityManager();
		try {
			Solicitud solicitu= new Solicitud();
			solicitu.setArchivo(txtArchivoAdjunto.getText());
			solicitu.setEstado(cboEstado.getSelectedItem().toString());
			solicitu.setActividad((Actividad) cboActividad.getSelectedItem());
			
			manager.getTransaction().begin();
			manager.persist(solicitu);
			manager.getTransaction().commit();
		} catch (Exception e) {
		    System.out.println("ERRRORR"+e.getMessage());
		}finally {
			factory.close();
			manager.close();
		}

	}
	
	void buscar() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysqlconexion");
		EntityManager manager = factory.createEntityManager();
		try {
			manager.getTransaction().begin();

			int id = Integer.parseInt(txtIdSolicitud.getText());
			Solicitud solicitud = manager.find(Solicitud.class, id);

			manager.getTransaction().commit();

			if (solicitud != null) {
				txtArchivoAdjunto.setText(solicitud.getArchivo());
				cboEstado.setSelectedItem(solicitud.getEstado());
				cboActividad.setSelectedItem(solicitud.getActividad());
				txtFechaRegistro.setText(solicitud.getFecha().toString());

				habilitarOk(); // activa el botón OK y campos necesarios
			} else {
				mensajeInfo("Solicitud no encontrada.");
				limpiar();
			}
		} catch (Exception e) {
			System.out.println("ERROR: " + e.getMessage());
			mensajeError("Error al buscar solicitud.");
		} finally {
			manager.close();
			factory.close();
		}
	}


	void modificar() {
		EntityManagerFactory factory= Persistence.createEntityManagerFactory("mysqlconexion");
		EntityManager manager= factory.createEntityManager();
		try {
			manager.getTransaction().begin();
			Solicitud solici= new Solicitud();
			solici.setArchivo(txtArchivoAdjunto.getText());
			solici.setActividad((Actividad) cboActividad.getSelectedItem());
			solici.setEstado((String) cboEstado.getSelectedItem());
			solici.setFecha(LocalDate.parse(txtFechaRegistro.getText()));
			manager.merge(solici);
			manager.getTransaction().commit();
		} catch (Exception e) {
		    System.out.println("ERRRORR"+e.getMessage());
		}finally {
			factory.close();
			manager.close();
		}
	}

	void eliminar() {
	    EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysqlconexion");
	    EntityManager manager = factory.createEntityManager();
	    try {
	        manager.getTransaction().begin();

	        int id = Integer.parseInt(txtIdSolicitud.getText());
	        Solicitud solicitud = manager.find(Solicitud.class, id);

	        if (solicitud != null) {
	            manager.remove(solicitud);
	            System.out.println("Solicitud eliminada con éxito.");
	        } else {
	            System.out.println("Solicitud no encontrada.");
	        }

	        manager.getTransaction().commit();
	    } catch (Exception e) {
	        System.out.println("ERROR: " + e.getMessage());
	    } finally {
	        manager.close();
	        factory.close();
	    }
	}


	// M�todos tipo void (con par�metros)
	void habilitarEntradas(boolean sino) {
		txtArchivoAdjunto.setEditable(sino);
		cboActividad.setEnabled(sino);
		cboEstado.setEnabled(sino);
	}

	void habilitarBotones(boolean sino) {
		if (tipoOperacion == ADICIONAR)
			btnOK.setEnabled(!sino);
		else {
			btnBuscar.setEnabled(!sino);
			btnOK.setEnabled(false);
		}
		btnAdicionar.setEnabled(sino);
		btnModificar.setEnabled(sino);
		btnEliminar.setEnabled(sino);
		btnOpciones.setEnabled(!sino);
	}

	void habilitarOk() {
		if (tipoOperacion == MODIFICAR) {
			habilitarEntradas(true);
			txtIdSolicitud.setEditable(false);
			btnBuscar.setEnabled(false);
			btnOK.setEnabled(true);
			txtArchivoAdjunto.requestFocus();
		}
		if (tipoOperacion == ELIMINAR) {
			txtIdSolicitud.setEditable(false);
			btnBuscar.setEnabled(false);
			btnOK.setEnabled(true);
		}
	}

	void mensajeInfo(String msj) {
		mensaje(msj, "INFO", JOptionPane.INFORMATION_MESSAGE);
	}

	void mensajeError(String msj) {
		mensaje(msj, "ERROR", JOptionPane.ERROR_MESSAGE);
	}

	void mensaje(String msj, String titulo, int tipo) {
		JOptionPane.showMessageDialog(this, msj, titulo, tipo);
	}

	void imprimir(String texto) {
		txtSalida.append(texto + "\n");
	}

	void imprimir() {
		imprimir("");
	}

	void limpiar() {
		txtIdSolicitud.setText("");
		txtArchivoAdjunto.setText("");
		if (cboActividad.getItemCount() > 0)
			cboActividad.setSelectedIndex(0);
		cboEstado.setSelectedIndex(0);
		txtFechaRegistro.setText("");
		txtIdSolicitud.setEditable(false);
		habilitarEntradas(false);
		habilitarBotones(true);
	}
}