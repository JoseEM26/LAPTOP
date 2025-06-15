package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Categoria;
import model.Producto;
import model.Proveedor;
import utils.JPAUtil;

import javax.persistence.EntityManager;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;

public class FrmManteProd extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;

	private JTextArea txtSalida;
	private JTextField txtCodigo;
	private JComboBox<Categoria> cboCategorias;
	private JComboBox<Proveedor> cboProveedores;
	private JTextField txtDescripcion;
	private JTextField txtStock;
	private JTextField txtPrecio;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmManteProd frame = new FrmManteProd();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmManteProd() {
		setTitle("Mantenimiento de Productos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 390);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				registrar();
			}
		});
		btnRegistrar.setBounds(324, 29, 89, 23);
		contentPane.add(btnRegistrar);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 171, 414, 143);
		contentPane.add(scrollPane);

		txtSalida = new JTextArea();
		txtSalida.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 11));
		scrollPane.setViewportView(txtSalida);

		JButton btnListado = new JButton("Listado");
		btnListado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listado();
			}
		});
		btnListado.setBounds(177, 322, 89, 23);
		contentPane.add(btnListado);

		txtCodigo = new JTextField();
		txtCodigo.setBounds(122, 11, 86, 20);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);

		JLabel lblCodigo = new JLabel("Id. Producto :");
		lblCodigo.setBounds(10, 14, 102, 14);
		contentPane.add(lblCodigo);

		cboCategorias = new JComboBox();
		cboCategorias.setBounds(122, 70, 86, 22);
		contentPane.add(cboCategorias);

		JLabel lblCategora = new JLabel("Categor\u00EDa");
		lblCategora.setBounds(10, 74, 102, 14);
		contentPane.add(lblCategora);

		JLabel lblNomProducto = new JLabel("Nom. Producto :");
		lblNomProducto.setBounds(10, 45, 102, 14);
		contentPane.add(lblNomProducto);

		txtDescripcion = new JTextField();
		txtDescripcion.setColumns(10);
		txtDescripcion.setBounds(122, 42, 144, 20);
		contentPane.add(txtDescripcion);

		JLabel lblStock = new JLabel("Stock:");
		lblStock.setBounds(10, 106, 102, 14);
		contentPane.add(lblStock);

		txtStock = new JTextField();
		txtStock.setColumns(10);
		txtStock.setBounds(122, 103, 77, 20);
		contentPane.add(txtStock);

		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(10, 134, 102, 14);
		contentPane.add(lblPrecio);

		txtPrecio = new JTextField();
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(122, 131, 77, 20);
		contentPane.add(txtPrecio);

		JLabel lblProveedores = new JLabel("Proveedor:");
		lblProveedores.setBounds(230, 106, 102, 14);
		contentPane.add(lblProveedores);

		cboProveedores = new JComboBox();
		cboProveedores.setBounds(300, 104, 120, 22);
		contentPane.add(cboProveedores);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscar();
			}
		});
		btnBuscar.setBounds(324, 63, 89, 23);
		contentPane.add(btnBuscar);

		llenaComboCategoria();
		llenaComboProveedor();
	}

	void llenaComboCategoria() {
		EntityManager manager = JPAUtil.getEntityManager();

		try {
			String jpql = "select c from Categoria c";
			List<Categoria> lstCategoria = manager.createQuery(jpql, Categoria.class).getResultList();

			for (Categoria categoria : lstCategoria) {
				cboCategorias.addItem(categoria);
			}
		} finally {
			manager.close();
		}

	}

	void llenaComboProveedor() {
		EntityManager manager = JPAUtil.getEntityManager();

		try {
			String jpql = "select p from Proveedor p";
			List<Proveedor> lstProveedor = manager.createQuery(jpql, Proveedor.class).getResultList();

			for (Proveedor proveedor : lstProveedor) {
				cboProveedores.addItem(proveedor);
			}
		} finally {
			manager.close();
		}
	}

	void registrar() {
		String idProducto = txtCodigo.getText();
		String descripcion = txtDescripcion.getText();
		int stock = Integer.parseInt(txtStock.getText());
		double precio = Double.parseDouble(txtPrecio.getText());
		int estado = 1;
		Categoria categoria = (Categoria)cboCategorias.getSelectedItem();
		Proveedor proveedor = (Proveedor) cboProveedores.getSelectedItem();
		
		Producto producto = new Producto(idProducto, descripcion, stock, precio, estado, categoria, proveedor);
		
		EntityManager manager = JPAUtil.getEntityManager();
		
		try {
			manager.getTransaction().begin();
			manager.persist(producto);
			manager.getTransaction().commit();
			JOptionPane.showMessageDialog(null, "Se ha registrado un nuevo producto", "Exitoso", JOptionPane.INFORMATION_MESSAGE);
			limpiarCampos();
		} finally {
			manager.close();
		}
	}

	void listado() {
		EntityManager manager = JPAUtil.getEntityManager();
		
		String jpql = "select p, c.descripcion, pv.razonSocial from Producto p join p.categoria c join p.proveedor pv order by p.idProducto";
		
		try {
			
			List<Object[]> resultados = manager.createQuery(jpql, Object[].class).getResultList();
			
			for (Object[] objects : resultados) {
				Producto producto = (Producto) objects[0];
				String descCategoria = (String) objects[1];
				String descProveedor = (String) objects[2];
				
				txtSalida.append("Id Producto....: "+ producto.getIdProducto()+ "\n");
				txtSalida.append("Descripción....: "+ producto.getDescripcion() + "\n" );
				txtSalida.append("Stock..........: "+ producto.getStock() + "\n");
				txtSalida.append("Precio.........: "+ producto.getPrecio() + "\n");
				txtSalida.append("Categoría......: "+ producto.getCategoria().getIdCategoria() + " - " + descCategoria+ "\n");
				txtSalida.append("Proveedor......: "+ producto.getProveedor().getIdProveedor() + " - " + descProveedor+ "\n");
				txtSalida.append("Estado.........: "+ producto.getEstado()+ "\n");
				txtSalida.append("*********************************************\n\n");
			}
		} finally {
			manager.close();
		}
	}

	void buscar() {
		
		String idProducto = txtCodigo.getText();
		
		EntityManager manager = JPAUtil.getEntityManager();
		
		try {
			Producto producto = manager.find(Producto.class, idProducto);
			
			if (producto == null) {
				JOptionPane.showMessageDialog(null, "No existe producto", "ERROR", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			txtDescripcion.setText(producto.getDescripcion());
			txtStock.setText(producto.getStock()+"");
			txtPrecio.setText(producto.getPrecio()+"");
			cboCategorias.setSelectedItem(producto.getCategoria());
			cboProveedores.setSelectedItem(producto.getProveedor());
		
		} finally {
			manager.close();
		}
	}

	private void limpiarCampos() {
		// Limpiar campos de texto
		txtCodigo.setText("");
		txtDescripcion.setText("");
		txtStock.setText("");
		txtPrecio.setText("");

		// Resetear combos (sin selección)
		cboCategorias.setSelectedIndex(-1);
		cboProveedores.setSelectedIndex(-1);

		// Opcional: devolver el foco al primer campo
		txtCodigo.requestFocusInWindow();
	}
}
