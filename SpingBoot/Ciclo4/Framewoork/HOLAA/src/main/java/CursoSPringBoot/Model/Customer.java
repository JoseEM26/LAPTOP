package CursoSPringBoot.Model;

public class Customer {
    private String nombre,apellido,password;
    private int id;

    public Customer() {
    }

    public Customer(String nombre, String apellido, String password, int id) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.password = password;
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
