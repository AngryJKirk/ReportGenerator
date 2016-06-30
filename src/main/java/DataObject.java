/**
 * Created by Deadliest Baddest Fattest Motherfucker in Universe on 30.06.2016.
 */
public class DataObject {


    private int number;
    private String date;
    private String name;

    public DataObject(String date, int number, String name) {
        this.date = date;
        this.number = number;
        this.name = name;
    }

    @Override
    public String toString() {
        return "DataObject{" +
                "number=" + number +
                ", date='" + date + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public int getNumber() {
        return number;
    }

    public String getDate() {
        return date;
    }

    public String getName() {
        return name;
    }
}
