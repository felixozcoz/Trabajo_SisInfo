package model;

public class EquipoVO{
    private String Id;
    private String Name; 

    /**
     * Constructor
     * @param Id
     * @param teamName
     */
    public EquipoVO(String Id, String teamName){
        this.Id = Id;
        this.Name = teamName;
    }

    public String getId(){
        return Id;
    }
    public void setId(String Id){
        this.Id = Id;
    }

    public String getName(){
        return Name;
    }
    public void setName(String Name){
        this.Name = Name;
    }

}