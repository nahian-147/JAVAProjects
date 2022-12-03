import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.XMLEvent;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.LinkedHashMap;
import java.util.Map;
public class SoapDemo {

    static Map<String, String> getPicklistFromSoapResponse(String soapResponse) throws Exception {
        Map<String, String> values = new LinkedHashMap<String, String>();
        XMLInputFactory inputFactory = XMLInputFactory.newInstance();
        String code = null;
        String display = null;
        String disabled = null;
        try {
            InputStream in = new ByteArrayInputStream(soapResponse.getBytes("UTF-8"));
            XMLEventReader eventReader = inputFactory.createXMLEventReader(in);
            while (eventReader.hasNext()) {
                XMLEvent event = eventReader.nextEvent();
                if (event.isStartElement()) {
                    if (event.asStartElement().getName().getLocalPart().equals("Code")) {
                        event = eventReader.nextEvent();
                        code = event.asCharacters().getData();
                        continue;
                    }
                    if (event.asStartElement().getName().getLocalPart().equals("DisplayValue")) {
                        event = eventReader.nextEvent();
                        display = event.asCharacters().getData();
                        continue;
                    }
                    if (event.asStartElement().getName().getLocalPart().equals("Disabled")) {
                        event = eventReader.nextEvent();
                        disabled = event.asCharacters().getData();
                        if ( "Y".equals(disabled)) values.put(code, display);
                        continue;
                    }
                }
            }
        } catch (UnsupportedEncodingException e) {
            throw new Exception(e);
        } catch (XMLStreamException e) {
            throw new Exception(e);
        }
        return values;
    }

    public static void main(String args[]){

    }
}
