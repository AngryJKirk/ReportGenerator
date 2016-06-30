import javafx.scene.chart.PieChart;

import java.security.KeyStore;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Deadliest Baddest Fattest Motherfucker in Universe on 30.06.2016.
 */
public class TableBuilder {


    //private List<DataObject> dataObjects;
    private  TableParams tableParams;
    private List<String[]> lines;
    public TableBuilder(TableParams tableParams, List<String[]> lines ) {
        this.tableParams = tableParams;
        this.lines = lines;
       // this.dataObjects = dataObjects;
    }

    public void build(){
        System.out.println(hatBuild(tableParams.getColumns()));
        System.out.println(separateBuild(tableParams.getWidth()));
        for(int i=0;i<lines.size();i++){
            System.out.println(lineBuild(lines.get(i),tableParams.getColumns()));
            System.out.println(separateBuild(tableParams.getWidth()));


        }
    }

    private String hatBuild(List<Column> columns){
        StringBuilder builder = new StringBuilder();
            for(Column column : columns){
                builder.append(String.format("| %s ", column.getColumnName()));
                builder = addSpaces(builder, column.getNumberOfSymbols());
            }
        builder.append("|");
        return builder.toString();
    }
    private String separateBuild(int width){
        StringBuilder builder = new StringBuilder();
        for(int i=0;i<width;i++){
            builder.append("-");
        }
        return builder.toString();
    }

    private String lineBuild(String[] lines, List<Column> columns){
        StringBuilder builder = new StringBuilder();

        for(int i=0;i<lines.length;i++){
            builder.append(String.format("| %s ", lines[i]));
            builder = addSpaces(builder, columns.get(i).getNumberOfSymbols());
        }
        builder.append("|");
        return builder.toString();

    }
    private StringBuilder addSpaces(StringBuilder stringBuilder, int numberOfSpaces){
        for(int i=0;i<numberOfSpaces;i++)
            stringBuilder.append(" ");
        return stringBuilder;
    }
}
