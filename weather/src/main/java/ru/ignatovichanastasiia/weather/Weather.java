
package ru.ignatovichanastasiia.weather;

import java.io.IOException;
import javax.swing.text.Document;

/**
 *
 * @author ignatovicganastasiia
 */
public class Weather {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
    
    private static Document getPage() throws IOException {
        String url = "http://www.pogoda.spb.ru/";
//        Document page = Jsoup.parse(new URL(url), 3000);
        return null;
    }
}
