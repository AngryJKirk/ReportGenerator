/**
 * Created by Deadliest Baddest Fattest Motherfucker in Universe on 30.06.2016.
 */
public class Column {

    private int numberOfSymbols;
    private String columnName;

    public Column(int numberOfSymbols, String columnName) {
        this.numberOfSymbols = numberOfSymbols;
        this.columnName = columnName;
    }

    public int getNumberOfSymbols() {
        return numberOfSymbols;
    }

    public String getColumnName() {
        return columnName;
    }


}
