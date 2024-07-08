import java.time.LocalDateTime;

public class Appointment {
    private Patient patient;
    private LocalDateTime appointmentTime;

    public Appointment(Patient patient, LocalDateTime appointmentTime) {
        this.patient = patient;
        this.appointmentTime = appointmentTime;
    }

    public Patient getPatient() {
        return patient;
    }

    public LocalDateTime getAppointmentTime() {
        return appointmentTime;
    }

    @Override
    public String toString() {
        return "Appointment for " + patient.getName() + " at " + appointmentTime;
    }
}
