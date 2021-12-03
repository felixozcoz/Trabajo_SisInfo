package model;

public class PlantillaVO {
    private int Id_plantilla;	// la plantilla a la que pertenece
    private String Nombre;	// info  del jugador
    private String Camiseta;	// url de la imagen de la camiseta que corresponde a su camiset
  
    // Constructor
    public PlantillaVO(int _Id_plantilla, String _Nombre, String _camiseta){
        this.Id_plantilla = _Id_plantilla;
        this.Nombre = _Nombre;
        this.Camiseta = _camiseta;
    }

    public int getId_plantilla(){
        return Id_plantilla;
    }
    public void setId_plantilla(int Id_plantilla){
        this.Id_plantilla = Id_plantilla;
    }

    public String getNombre(){
        return Nombre;
    }
    
    public String getCamiseta() {
    	return Camiseta;
    }

}