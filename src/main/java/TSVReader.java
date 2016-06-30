import com.univocity.parsers.tsv.TsvParser;
import com.univocity.parsers.tsv.TsvParserSettings;
import javafx.scene.chart.PieChart;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Deadliest Baddest Fattest Motherfucker in Universe on 30.06.2016.
 */
public class TSVReader {
    List<DataObject> dataObjects = new ArrayList<DataObject>();
//TODO refactor this shit
    List<String[]> strings = new LinkedList<String[]>();
    public TSVReader(String filePath) {
        this.TSVFile = new File(filePath);
    }


    File TSVFile;
    public void parser() throws UnsupportedEncodingException {
        TsvParserSettings settings = new TsvParserSettings();


        TsvParser parser = new TsvParser(settings);

        strings = parser.parseAll(TSVFile, "UTF-16");
        printparser();
    }

    public void printparser() throws UnsupportedEncodingException {

        for(int i=0;i<strings.size();i++){
            for(String i11 : strings.get(i))
                System.out.println(i11);

        }
    }
}
