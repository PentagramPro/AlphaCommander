package commander.panel;

import javafx.beans.property.SimpleStringProperty;

/**
 * Created by maxon on 02-May-17.
 */
public class FileItem {
    private final SimpleStringProperty name;
    private final SimpleStringProperty date;

    public FileItem(String name, String date) {
        this.name = new SimpleStringProperty(name);
        this.date = new SimpleStringProperty(date);
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getDate() {
        return date.get();
    }

    public SimpleStringProperty dateProperty() {
        return date;
    }

    public void setDate(String date) {
        this.date.set(date);
    }
}
