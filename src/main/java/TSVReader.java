import com.univocity.parsers.tsv.TsvParser;
import com.univocity.parsers.tsv.TsvParserSettings;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Deadliest Baddest Fattest Motherfucker in Universe on 30.06.2016.
 */
//TODO refactor this shit
public class TSVReader {
    private List<DataObject> dataObjects = new ArrayList<DataObject>();

    public List<DataObject> getDataObjects() {
        return dataObjects;
    }

    public List<String[]> getStrings() {
        return strings;
    }

    private List<String[]> results = new LinkedList<String[]>();
    private List<String[]> strings = new LinkedList<String[]>();
    public TSVReader(String filePath) {
        this.TSVFile = new File(filePath);
    }


    File TSVFile;
    public void parser() throws UnsupportedEncodingException {
        TsvParserSettings settings = new TsvParserSettings();


        TsvParser parser = new TsvParser(settings);

        strings = parser.parseAll(TSVFile, "UTF-16");
        //registData();


    }

    public void registData() {

        for(int i=0;i<strings.size();i++){
//            dataObjects.add(new DataObject(strings.get(i)[1], Integer.parseInt(strings.get(i)[0]), strings.get(i)[2]));
//            System.out.println(dataObjects.get(i));
            //results.add()
        }

    }
}
