import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import java.time.LocalDateTime;

public class ReceptionManagerController {

    @FXML
    private TextField nameField;
    @FXML
    private TextField ageField;
    @FXML
    private TextField idField;
    @FXML
    private ListView<Patient> patientListView;
    @FXML
    private ListView<Appointment> appointmentListView;

    private ObservableList<Patient> patients;
    private ObservableList<Appointment> appointments;

    @FXML
    public void initialize() {
        patients = FXCollections.observableArrayList();
        appointments = FXCollections.observableArrayList();
        patientListView.setItems(patients);
        appointmentListView.setItems(appointments);
    }

    @FXML
    private void addPatient() {
        String name = nameField.getText();
        int age;
        try {
            age = Integer.parseInt(ageField.getText());
        } catch (NumberFormatException e) {
            showAlert("Invalid age", "Please enter a valid age.");
            return;
        }
        String id = idField.getText();

        Patient patient = new Patient(name, age, id);
        patients.add(patient);

        nameField.clear();
        ageField.clear();
        idField.clear();
    }

    @FXML
    private void scheduleAppointment() {
        Patient selectedPatient = patientListView.getSelectionModel().getSelectedItem();
        if (selectedPatient == null) {
            showAlert("No patient selected", "Please select a patient from the list.");
            return;
        }

        LocalDateTime appointmentTime = LocalDateTime.now().plusMinutes(30); // Example appointment time
        Appointment appointment = new Appointment(selectedPatient, appointmentTime);
        appointments.add(appointment);
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
