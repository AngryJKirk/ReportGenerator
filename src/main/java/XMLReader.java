import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Deadliest Baddest Fattest Motherfucker in Universe on 30.06.2016.
 */
public class XMLReader extends DefaultHandler {

    private File XMLFile;
    private TableParams tableParams = new TableParams();
    private String currentElement = "";
    private String pastElement = "";

    private List<String> titles = new LinkedList<String>();
    private List<Integer>  width = new LinkedList<Integer>();

    public XMLReader(String filePath){
        this.XMLFile = new File(filePath);
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        pastElement = currentElement;
        currentElement = qName;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        currentElement = "";
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (currentElement.equals("width") && pastElement.equals("page")){
            tableParams.setWidth(Integer.parseInt( new String(ch, start, length)));
            }

        if (currentElement.equals("height") ) {
           // System.out.println(pastElement);
            tableParams.setHeight(Integer.parseInt(new String (ch, start, length)));
        }

        if (currentElement.equals("title")) {
            titles.add(new String(ch, start, length));
        }
        if (currentElement.equals("width") && (!pastElement.equals("page"))) {
            System.out.println(pastElement);
            width.add(Integer.parseInt(new String(ch, start, length)));
            //System.out.println("width added");
        }

    }

//    @Override
//    public void endDocument() throws SAXException {
//        paramsMerge();
//        tableParams.printParams();
//    }

    public void startParse() throws IOException, SAXException, ParserConfigurationException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        //XMLReader xmlReader = new XMLReader("settings.xml");
        parser.parse(XMLFile, this );
        paramsMerge();
        tableParams.printParams();
    }

    private void paramsMerge(){
        for(int i=0; i<titles.size();i++){
            tableParams.addColumn(titles.get(i), width.get(i));

        }
    }
}
