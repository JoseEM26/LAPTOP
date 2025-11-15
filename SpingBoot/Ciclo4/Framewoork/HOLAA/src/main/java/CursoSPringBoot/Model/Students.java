package CursoSPringBoot.Model;

public class Students {
    private String nombre, email , course;
    private int id ,age;

    public Students(String nombre, String email, String course, int id, int age) {
        this.nombre = nombre;
        this.email = email;
        this.course = course;
        this.id = id;
        this.age = age;
    }public Students() {

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
