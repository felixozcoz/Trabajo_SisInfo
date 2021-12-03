package model;

public class JugadorVO{
    //private int id_jugador;
    private String Equipo;
    private String Nombre; 
    private String Posicion; 
    private int Puntos; 
    private long Precio; 
    private int PJ; 
    private float Media; 
    private String Camiseta;
    private String Escudo;

    public JugadorVO(String Nombre, String Posicion, String Equipo, int Puntos, long Precio, int PJ, float Media){
        this.Equipo = Equipo;
        this.Nombre = Nombre;
        this.Posicion = Posicion;
        this.Puntos = Puntos;
        this.Precio = Precio;
        this.PJ = PJ;
        this.Media = Media;
    }
    
    public JugadorVO(String Nombre, String Posicion, String Equipo, int Puntos, long Precio, int PJ, float Media, String _Camiseta,String _Escudo){
        this.Equipo = Equipo;
        this.Nombre = Nombre;
        this.Posicion = Posicion;
        this.Puntos = Puntos;
        this.Precio = Precio;
        this.PJ = PJ;
        this.Media = Media;
        this.Camiseta = _Camiseta;
        this.Escudo = _Escudo;
    }
    

    public String getEquipo(){
        return Equipo;
    }
    public void setEquipo(String Equipo){
        this.Equipo = Equipo;
    }

    public String getNombre(){
        return Nombre;
    }
    public void setNombre(String Nombre){
        this.Nombre = Nombre;
    }

    public String getPosicion(){
        return Posicion;
    }
    public void setPosicion(String Posicion){
        this.Posicion = Posicion;
    }
    
    public String getCamiseta(){
        return Camiseta;
    }
    
    public void setCamiseta(String _Camiseta){
        this.Camiseta = _Camiseta;
    }
    
    public String getEscudo(){
        return Escudo;
    }
    
    public void setEscudo(String _Escudo){
        this.Escudo = _Escudo;
    }

    public int getPuntos(){
        return Puntos;
    }
    public void setPuntos(int Puntos){
        this.Puntos = Puntos;
    }

    public long getPrecio(){
        return Precio;
    }
    public void setPrecio(long Precio){
        this.Precio = Precio;
    }

    public int getPJ(){
        return PJ;
    }
    public void setPJ(int PJ){
        this.PJ = PJ;
    }

    public float getMedia(){
        return Media;
    }
    public void setMedia(float Media){
        this.Media = Media;
    }
}