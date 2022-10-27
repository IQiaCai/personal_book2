package com.itdou;

import com.itdou.domain.Person;
import com.itdou.service.PersonService;
import com.itdou.service.impl.PersonServiceImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@Component
public class Controller {
    @Autowired
    private PersonService personService;

    ObservableList<Person> celldate = FXCollections.observableArrayList();

    @FXML
    private Button addNew;

    @FXML
    private Button del;

    @FXML
    private TableColumn<Person, String> address;

    @FXML
    private TableColumn<Person, String> name;

    @FXML
    private TableColumn<Person, String> phone;

    @FXML
    private TableView<Person> tableView;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtPhone;

    @FXML
    void add(ActionEvent event) {
        if (txtName.getText() != null && txtPhone.getText() != null && txtAddress.getText() != null) {
            Person person=new Person(txtName.getText(), txtAddress.getText(),txtPhone.getText());
            celldate.add(person);
            txtName.clear();
            txtAddress.clear();
            txtPhone.clear();
//            personService.save(person);
        }
    }

    @FXML
    void delIt(ActionEvent event) {
        TableView<Person> sw = tableView;
        Person person = sw.getSelectionModel().getSelectedItem();
        int id=person.getId();
        int size = celldate.size();
        if (size <= 0) {
            return ;
        }
        for (int i = 0; i < size; i++) {
            Person s = celldate.get(i);
            if (s.getId()==id) {
                try {
                    celldate.remove(s);
//                    personService.delete(id);
                }catch (Exception e){
                    e.printStackTrace();
                }
                tableView.setItems(celldate);
            }
        }
    }

    public void initialize(){
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        phone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        address.setCellValueFactory(new PropertyValueFactory<>("address"));

        tableView.setEditable(true);
        name.setCellFactory(TextFieldTableCell.forTableColumn());
        phone.setCellFactory(TextFieldTableCell.forTableColumn());
        address.setCellFactory(TextFieldTableCell.forTableColumn());

        List<Person> persons = personService.getAll();
        for (Person person : persons) {
            celldate.add(person);
        }

        tableView.setItems(celldate);
    }
}
