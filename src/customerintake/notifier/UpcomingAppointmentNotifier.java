package customerintake.notifier;

import java.time.format.DateTimeFormatter;
import java.util.Locale;

import customerintake.CustomerAppointment;
import customerintake.GymCalendar;

public class UpcomingAppointmentNotifier {
	
	private GymCalendar calendar;
	
	public UpcomingAppointmentNotifier(GymCalendar calendar) {
		this.calendar = calendar;
	}
	
	public void run() {
		for(CustomerAppointment appt: calendar.getTomorrowAppointments()) {
			/* TODO[9]: dependency injection
			 * 			create a new property called (private EmailNotifier) notifier 
			 * 			and allow it to be passed in on the constructor 
			 * 			then remove the instantiation of SmtpMessageSender below */
			SmtpMessageSender notifier = new SmtpMessageSender();
			String email = appt.getCustomerLastName().toLowerCase()
					+ appt.getCustomerFirstName().toLowerCase()
					+ "@mail.com";
			System.out.println("Sending with body: " + buildMessageBody(appt));
			notifier.sendNotification("Appointment Reminder", buildMessageBody(appt), email);
		}
	}
	
	private String buildMessageBody(CustomerAppointment appt) {
		return "You have an appointment tomorrow at "
				+ appt.getAppointmentDateTime().format(DateTimeFormatter.ofPattern("h:mm a", Locale.US))
				+ " with "
				+ appt.getPersonalTrainer().getName()
				+ ".";
	}
}
