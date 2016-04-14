/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bravo.publications.interfaces;

import java.util.List;

/**
 *
 * @author matheu
 */
public interface PublicationsInterface
{
   public void addPublication (String title, String staffNumber);
   public List<String> getTitle(String staffNumber);
}
