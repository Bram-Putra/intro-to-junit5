package customerintake;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class GymCalendar {
	private List<CustomerAppointment> appointments;
	private LocalDate today;

	public GymCalendar(LocalDate today) {
		this.appointments = new ArrayList<>();
		this.today = today;
	}

	public void addAppointment(String customerFirstName, String customerLastName, String personalTrainer,
			String dateTime) {
		PersonalTrainer pt = PersonalTrainer.valueOf(personalTrainer.toLowerCase());
		// TODO[3]: extract to a local method convertToDateTimeFromString
		LocalDateTime localDateTime;
		/* TODO[4]: extract the local method convertToDateTimeFromString to DateTimeConverter.java
		 *          and make the newly extracted method static
		 *          remember to add a LocalDate today as 2nd parameter of the new method */
		try {
			if (dateTime.toLowerCase().startsWith("today")) {
				String[] parts = dateTime.split(" ", 2);
				LocalTime time = LocalTime.parse(parts[1].toUpperCase(),
						DateTimeFormatter.ofPattern("h:mm a", Locale.US));
				localDateTime = LocalDateTime.of(today, time);
			}
			else {
				localDateTime = LocalDateTime.parse(dateTime.toUpperCase(),
						DateTimeFormatter.ofPattern("M/d/yyyy h:mm a", Locale.US));
			}
		} catch (Throwable t) {
			throw new RuntimeException("Unable to create date time from: [" +
					dateTime.toUpperCase() + "], please enter with format [M/d/yyyy h:mm a]"
					+ t.getMessage());
		}
		CustomerAppointment appointment = new CustomerAppointment(customerFirstName, customerLastName,
				localDateTime, pt);
		appointments.add(appointment);
	}

	public List<CustomerAppointment> getAppointments() {
		return this.appointments;
	}

	public List<CustomerAppointment> getTodayAppointments() {
		return appointments.stream()
				.filter(appt -> appt.getAppointmentDateTime().toLocalDate().equals(today))
				.collect(Collectors.toList());
	}

	public boolean hasAppointment(LocalDate date) {
		return appointments.stream()
				.anyMatch(appt -> appt.getAppointmentDateTime().toLocalDate().equals(date));
	}

	public List<CustomerAppointment> getTomorrowAppointments() {
		LocalDate tomorrow = today.plusDays(1);
		return getAppointmentsForDate(tomorrow);
	}

	private List<CustomerAppointment> getAppointmentsForDate(LocalDate tomorrow) {
		return appointments.stream()
				.filter(appt -> appt.getAppointmentDateTime().toLocalDate().equals(tomorrow))
				.collect(Collectors.toList());
	}

}
