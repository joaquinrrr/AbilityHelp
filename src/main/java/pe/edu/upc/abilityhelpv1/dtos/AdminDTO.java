package pe.edu.upc.abilityhelpv1.dtos;

public class AdminDTO {
    private int idadmin;
    private String nombre;
    private String correo;
    private String password;

    public void setIdadmin(int idadmin) {
        this.idadmin = idadmin;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public int getIdadmin() {
        return idadmin;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public String getPassword() {
        return password;
    }


}
