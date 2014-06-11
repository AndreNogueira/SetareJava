package beans;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class DistanceCalculator {

    public static double calculateDistance(String origem, String destino) {
        URL url;
        try {
            url = new URL("http://maps.google.com/maps/api/directions/xml?origin="
                    + origem + "&destination=" + destino + "&sensor=false");
            Document document = getDocument(url);
            return parseXML(document);
        } catch (MalformedURLException | DocumentException e) {
        }
        return 0.0;
    }

    private static double parseXML(Document document) {
        List list = document.selectNodes("//DirectionsResponse/route/leg/distance/text");
        if (list.isEmpty()) {
            return 0.0;
        } else {
            Element element = (Element) list.get(list.size() - 1);
            return transformStringToDouble(element.getText());
        }
    }

    private static double transformStringToDouble(String distance) {
        return new Double(distance.substring(0, distance.length() - 3));
    }

    private static Document getDocument(URL url) throws DocumentException {
        SAXReader reader = new SAXReader();
        Document document = reader.read(url);
        return document;
    }
}
