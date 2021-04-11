
package modelo;

public class Sistemas {
    private int n_control;
    private String nombre;
    private String carrera;
    private int annio_ingreso;
    
  public Sistemas(){
  }

  public Sistemas(int n_control, String nombre, String carrera, int annio_ingreso){
      this.n_control = n_control;
      this.nombre = nombre;
      this.carrera = carrera;
      this.annio_ingreso = annio_ingreso;
  }

    public int getN_control() {
        return n_control;
    }

    public void setN_control(int n_control) {
        this.n_control = n_control;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public int getAnnio_ingreso() {
        return annio_ingreso;
    }

    public void setAnnio_ingreso(int annio_ingreso) {
        this.annio_ingreso = annio_ingreso;
    }
  
  
    
}
