/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bravo.publications.test;

import bravo.publications.ejb.PublicationsBean;
import java.util.Arrays;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

/**
 *
 * @author matheu
 */
public class PublicationsTest
{
    private static PublicationsBean mockedPublication;
    
    @BeforeClass
    public static void setUp()
    {
        mockedPublication = Mockito.mock(PublicationsBean.class);
        
        Mockito.when(mockedPublication.getTitle("123")).thenReturn(Arrays.asList("apples","pears"));
    }
    
    @Test
    public void getTitlesTest() throws Exception
    {
        Assert.assertEquals(Arrays.asList("apples","pears"),mockedPublication.getTitle("123"));
    }
}
