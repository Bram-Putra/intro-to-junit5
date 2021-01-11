package customerintake.notifier;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import customerintake.CustomerAppointment;
import customerintake.GymCalendar;
import customerintake.PersonalTrainer;

class UpcomingAppointmentNotifierTest {

	@Test
	void sendNotificationWithCorrectFormat() {
		GymCalendar calendar = new GymCalendar(LocalDate.of(2021, 1, 11));
		calendar.addAppointment("Bram", "Putra", "tyson", "1/12/2021 6:30 am");
		UpcomingAppointmentNotifier notifier = new UpcomingAppointmentNotifier(calendar);
		notifier.run();
	}

	/* TODO[10]: comment or remove lines 14-22 
	 * 			 and uncomment below codes */
//	private EmailNotifierTestDouble emailDouble;
//
//	@BeforeEach
//	void init() {
//		emailDouble = new EmailNotifierTestDouble();
//	}
//
//	@Test
//	void sendNotificationWithCorrectFormat() {
//		GymCalendar calendar = new GymCalendar(LocalDate.of(2021, 1, 11));
//		calendar.addAppointment("Bram", "Putra", "tyson", "1/12/2021 6:30 am");
//		UpcomingAppointmentNotifier notifier = new UpcomingAppointmentNotifier(calendar, emailDouble);
//		notifier.run();
//
//		assertEquals(1, emailDouble.receivedMessages.size());
//		EmailNotifierTestDouble.Message expectedMessage = emailDouble.receivedMessages.get(0);
//		assertAll(
//				() -> assertEquals("putrabram@mail.com", expectedMessage.toAddress),
//				() -> assertEquals("Appointment Reminder", expectedMessage.subject),
//				() -> assertEquals("You have an appointment tomorrow at 6:30 AM with Mike Tyson.",
//						expectedMessage.body)
//				);
//	}

}
