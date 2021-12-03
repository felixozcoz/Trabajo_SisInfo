package model;

public class UsuarioVO{
	private String Email;
    private String Nombre;
    private String Password; 
    private String Id_plantilla;

    public UsuarioVO(String _Email, String _Nombre, String _Password, String _Id_plantilla){
        this.Email = _Email;
    	this.Nombre = _Nombre;
        this.Password = _Password;
        this.Id_plantilla = _Id_plantilla;
    }
    
    public String getEmail(){
        return Email;
    }
    public void setEmail(String _Email){
        this.Email = _Email;
    }

    public String getNombre(){
        return Nombre;
    }
    public void setNombre(String _Nombre){
        this.Nombre = _Nombre;
    }

    public String getPassword(){
        return Password;
    }
    public void setPasswd(String _Password){
        this.Password = _Password;
    }
    
    public String getId_plantilla(){
        return Id_plantilla;
    }
    public void setId_plantilla(String _Id_plantilla){
        this.Id_plantilla = _Id_plantilla;
    }
}