package zhangyuyao;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName msg of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }

    public void test1(){
        System.out.println("matrix");
    }

    public void test2() throws IOException {

//        File file = new File("databaseConnection.properties");
//
//        FileInputStream fileInputStream = new FileInputStream(file);
//
//        Properties properties = new Properties();
//
//        properties.load(fileInputStream);
//
//        for (String name: properties.stringPropertyNames()) {
//            System.out.println(properties.getProperty(name));
//        }

    }
}
