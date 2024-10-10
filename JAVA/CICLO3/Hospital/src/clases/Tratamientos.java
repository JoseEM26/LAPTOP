package clases;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Tratamientos {
      private int idTramamiento;
      private String paciente;
      private int DNIpaciente;
      private String medico;
      private String tipoTratamiento;
      private int duracion;
      
      
      public Tratamientos() {
  		
  	}  
	
		
	
	public Tratamientos(int idTramamiento, String paciente, int dNIpaciente, String medico, String tipoTratamiento,
			int duracion) {
		super();
		this.idTramamiento = idTramamiento;
		this.paciente = paciente;
		this.DNIpaciente = dNIpaciente;
		this.medico = medico;
		this.tipoTratamiento = tipoTratamiento;
		this.duracion = duracion;
	}
	
	



	public int getIdTramamiento() {
		return idTramamiento;
	}



	public void setIdTramamiento(int idTramamiento) {
		this.idTramamiento = idTramamiento;
	}



	public String getPaciente() {
		return paciente;
	}



	public void setPaciente(String paciente) {
		this.paciente = paciente;
	}



	public int getDNIpaciente() {
		return DNIpaciente;
	}



	public void setDNIpaciente(int dNIpaciente) {
		DNIpaciente = dNIpaciente;
	}



	public String getMedico() {
		return medico;
	}



	public void setMedico(String medico) {
		this.medico = medico;
	}



	public String getTipoTratamiento() {
		return tipoTratamiento;
	}



	public void setTipoTratamiento(String tipoTratamiento) {
		this.tipoTratamiento = tipoTratamiento;
	}



	public int getDuracion() {
		return duracion;
	}



	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}



	//Esto me sirve para poder crear un archivo txt como base de dato
	public void CreateArchivoTXT() {
		try {
			File TratamientoBD=new File("Tratamiento.txt");
			if(TratamientoBD.createNewFile()) {
				System.out.println("se creo el archivo "+ TratamientoBD.getName());
			}else {
				System.out.println("Archivo ya existe"+ TratamientoBD.getName());
			}
		} catch (Exception e) {
			System.out.println("Ocurrio un erro");
			
		
		}
	}
	
	public void MostrarRegistroTabla(JTable tabla) {
		DefaultTableModel model=new DefaultTableModel();
		
		model.addColumn("ID Tratamiento");
		model.addColumn("Tipo Tratamiento");
		model.addColumn("Paciente nombre");
		model.addColumn("DNI");
		model.addColumn("Medico nombre");
        tabla.setModel(model);
        
        String nombreruta="Tratamiento.txt";
        File ruta=new File(nombreruta);
        
        try {
            BufferedReader br=new BufferedReader(new FileReader(ruta)); 	
//            String firstLine= br.readLine().trim();
            
            Object[] tableLines= br.lines().toArray();
            
            for(int i=0; i<tableLines.length ;i++) {
            	String line =tableLines[i].toString().trim();
            	String[] datarow=line.split(",");
            	model.addRow(datarow);
            	
            }

		} catch (Exception e) {
			JOptionPane.showConfirmDialog(null,e.getMessage());
		}        
        
		
	}
	
	





}
