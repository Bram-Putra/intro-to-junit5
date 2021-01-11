package customerintake;
import java.time.LocalDateTime;

public class CustomerAppointment {
	private String customerFirstName;
	private String customerLastName;
	private LocalDateTime appointmentDateTime;
	private PersonalTrainer personalTrainer;

	public CustomerAppointment(String customerFirstName, String customerLastName,
			LocalDateTime appointmentDateTime, PersonalTrainer personalTrainer) {
		this.customerFirstName = customerFirstName;
		this.customerLastName = customerLastName;
		this.appointmentDateTime = appointmentDateTime;
		this.personalTrainer = personalTrainer;
	}

	public String getCustomerFirstName() {
		return customerFirstName;
	}

	public String getCustomerLastName() {
		return customerLastName;
	}

	public LocalDateTime getAppointmentDateTime() {
		return appointmentDateTime;
	}

	public PersonalTrainer getPersonalTrainer() {
		return personalTrainer;
	}
}
