import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

/**
 * Created by Deadliest Baddest Fattest Motherfucker in Universe on 30.06.2016.
 */
public class GeneratorRunner {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

        XMLReader xmlReader = new XMLReader("settings.xml");
        xmlReader.startParse();
        TSVReader tsvReader = new TSVReader("source-data.tsv");
        tsvReader.parser();
        TableBuilder tableBuilder = new TableBuilder(xmlReader.getTableParams(),tsvReader.getStrings());
        tableBuilder.build();
    }
}
