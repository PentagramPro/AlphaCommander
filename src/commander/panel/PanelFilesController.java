package commander.panel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by maxon on 02-May-17.
 */
public class PanelFilesController {

    ManagedPath currentPath;
    @FXML
    private TableView fileBrowser;

    ObservableList<FileItem> fileBrowserData = FXCollections.observableArrayList();

    @FXML
    protected void initialize(){
        currentPath = new ManagedPath(System.getProperty("user.home"));

        TableColumn fileNameCol = new TableColumn("Name");
        fileNameCol.setCellValueFactory(
                new PropertyValueFactory<FileItem,String>("name")
        );

        TableColumn modifiedCol = new TableColumn("Modified");
        modifiedCol.setCellValueFactory(
                new PropertyValueFactory<FileItem,String>("date")
        );

        fileBrowser.getColumns().addAll(fileNameCol, modifiedCol);

        File folder = new File(currentPath.getPath());

        File[] list = folder.listFiles();

        Arrays.sort(list, (o1, o2) -> {
            if((o1.isDirectory() && o2.isDirectory()) || (o1.isFile() && o2.isFile())) {
                return o1.getName().compareTo(o2.getName());
            }

            return o1.isDirectory() ? 1:-1;
        });

        fileBrowserData.clear();
        for(int i=0;i<list.length;i++) {
            File f = list[i];
            fileBrowserData.add(new FileItem(f.getName(),""));
        }

        fileBrowser.setItems(fileBrowserData);
    }
}
