package Main;


public class BibTexEntry {
    
    String bibTexEntry; 

    public BibTexEntry() 
    {
        //creating empty bibTexEntry
    }

     public BibTexEntry(String _bibTexEntry) {
        bibTexEntry = _bibTexEntry;
    }
    
    public String getBibTexEntry()
    {

        return bibTexEntry;
    }


    public void setBibTextEntry(String _bibTexEntry) 
    {
        bibTexEntry = _bibTexEntry;
    }

   
}
