package za.ac.cs.teambravo.publications.base;

import java.util.ArrayList;


//package za.ac.cs.teambravo.publications.publications;

public class PublicationType 
{
    public class PublicationType
{
    String name;
    ArrayList<PublicationTypeState> typeStates;

    public PublicationType(String name, ArrayList<PublicationTypeState> typeStates) {
        this.name = name;
        this.typeStates = typeStates;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<PublicationTypeState> getTypeStates() {
        return typeStates;
    }

    public void setTypeStates(ArrayList<PublicationTypeState> typeStates) {
        this.typeStates = typeStates;
    }
    
    public String getPublicationType(){
        return name;
    }
    public void setPublicationType(String _name)
    {
        name = _name;
    }

    
}