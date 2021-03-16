package ru.sapteh.controller;

import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.sapteh.dao.DAO;
import ru.sapteh.daoImpl.ClientImpl;
import ru.sapteh.model.Client;

import java.util.Date;

public class Controller {
    @FXML
    private TableView<Client> tableView;

    @FXML
    private TableColumn<Client, Integer> columnId;

    @FXML
    private TableColumn<Client, String> columnFIO;

    @FXML
    private TableColumn<Client, String> columnPhone;

    @FXML
    private TableColumn<Client, String> columnPhoto;

    @FXML
    private TableColumn<Client, Date> columnBirthday;

    @FXML
    private TableColumn<Client, String> photoEmail;

    @FXML
    private TableColumn<Client, Date> columnRegistration;

    @FXML
    private TableColumn<Client, Character> columnGender;

    @FXML
    void initialize(){
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        DAO<Client, Integer> clientIntegerDAO = new ClientImpl(factory);
        ObservableList<Client> observableList = FXCollections.observableArrayList();
        tableView.setItems(observableList);
        columnId.setCellValueFactory(a -> new SimpleObjectProperty<>(a.getValue().getId()));
        columnFIO.setCellValueFactory(a -> new SimpleObjectProperty<>(a.getValue().getFio()));
        columnPhone.setCellValueFactory(a -> new SimpleObjectProperty<>(a.getValue().getPhoto()));
        columnPhoto.setCellValueFactory(a -> new SimpleObjectProperty<>(a.getValue().getPhoto()));
        columnBirthday.setCellValueFactory(a -> new SimpleObjectProperty<>(a.getValue().getBirthday()));
        columnGender.setCellValueFactory(a -> new SimpleObjectProperty<>(a.getValue().getGender().getCode()));
        photoEmail.setCellValueFactory(a -> new SimpleObjectProperty<>(a.getValue().getEmail()));
        columnRegistration.setCellValueFactory(a -> new SimpleObjectProperty<>(a.getValue().getDateRegistration()));
        observableList.addAll(clientIntegerDAO.findByAll());
    }
}

