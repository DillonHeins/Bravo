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
public class Report
    {
        String type;
        Report()
        {
            
        }
        public void setType(String t)
        {
            this.type=t;
        }
        Report(String type)
        {
            this.type=type;
        }
        
        public String returnReport()
        {
            String repo="No reports available!";
            switch (type)
            {
                case "bar": repo=getBar();
                    break;
                case "pie":repo=getPie();
                    break;
                case "line": repo=getLine();
                    break;
                case "sum":repo=getSum();
                    break;    
            }

            return repo;
        }
        
        private String getBar()
        {
            return "This is a bar graph report";
        }
        private String getLine()
        {
            return "This is a line graph report";
        }
        private String getPie()
        {
            return "This is a pie chart report";
        }
        private String getSum()
        {
            return "This is a summary report";
        }
    }
    
    