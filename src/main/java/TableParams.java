import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Deadliest Baddest Fattest Motherfucker in Universe on 30.06.2016.
 */
public class TableParams {

    private int width;
    private int height;

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    List<Column> columns = new ArrayList<Column>();

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }



    public void addColumn(String columnName, int numberOfSymbols){
        columns.add(new Column(numberOfSymbols, columnName));
    }

    public ArrayList<Column> getColumns(){
        return (ArrayList<Column>) columns;
    }


    public void printParams() {
        System.out.println("Width is " + width + "; Height is " + height + ";");
        for(int i=0;i<columns.size();i++){
            System.out.println(columns.get(i).getColumnName() + " " + columns.get(i).getNumberOfSymbols());
        }
    }
}
