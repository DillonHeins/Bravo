/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bravo.reporting.ejb;

/**
 *
 * @author Warmaster
 */
public class Report {
 
    String type;
    Report()
    {
        
    }
    Report(String reportType)
    {
        this.type=reportType;
    }
    private String getBar()
    {
        return "This is a bar graph report.";
    }
    private String getPie()
    {
        return "This is a pie chart report.";
    }
    private String getLine()
    {
     return "This is a line graph report.";   
    }
    private String getSumm()
    {
     return "This is a summary report of the database.";   
    }
    public String generateReport()
    {
        String report="Sorry! No Reports available";
        switch (type.toLowerCase())
        {
            case "bar": report=getBar();
                break;
            case "line": report=getLine();
                break;
            case "pie": report=getPie();
                break;
            case "sum": report=getSumm();
                break;
        }
        
        return report;
    }
}
