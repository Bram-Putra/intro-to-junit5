package customerintake;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

import org.junit.jupiter.api.Test;

// TODO[6]: use @DisplayName() for tests report
class GymCalendarShould {

	@Test
	public void allowEntryOfAnAppointment() {
		// TODO[1]: setting up tests by using @BeforeEach by copying and pasting the first line
		// TODO[2]: convert calendar from a local variable into an instance field
		GymCalendar calendar = new GymCalendar(LocalDate.of(2021, 1, 9));
		calendar.addAppointment("Bram", "Putra", "grover", "01/09/2021 6:30 am");
		List<CustomerAppointment> appointments = calendar.getAppointments();
		assertNotNull(appointments);
		assertEquals(1, appointments.size());
		CustomerAppointment enteredAppt = appointments.get(0);
		assertEquals("Bram", enteredAppt.getCustomerFirstName());
		assertEquals("Putra", enteredAppt.getCustomerLastName());
		assertEquals(PersonalTrainer.grover, enteredAppt.getPersonalTrainer());
		// because enumeration is unique, we can also use assertSame for PersonalTrainer
		assertSame(PersonalTrainer.grover, enteredAppt.getPersonalTrainer());
		assertEquals("1/9/2021 06:30 AM", 
				enteredAppt.getAppointmentDateTime().format(DateTimeFormatter
						.ofPattern("M/d/yyyy hh:mm a", Locale.US)));
		// TODO[6]: to prevent short-circuit, use assertAll()
//		assertAll(
//				() -> assertEquals("Bram", enteredAppt.getCustomerFirstName()),
//				() -> assertEquals("Putra", enteredAppt.getCustomerLastName()),
//				() -> assertEquals(PersonalTrainer.grover, enteredAppt.getPersonalTrainer()),
//				() -> assertSame(PersonalTrainer.grover, enteredAppt.getPersonalTrainer()),
//				() -> assertEquals("1/9/2021 06:30 AM", 
//						enteredAppt.getAppointmentDateTime().format(DateTimeFormatter
//								.ofPattern("M/d/yyyy hh:mm a", Locale.US)))
//				);
	}
	
	@Test
	public void returnTrueForHasAppointmentsIfThereAreAppointments() {
		GymCalendar calendar = new GymCalendar(LocalDate.of(2021, 1, 9));
		calendar.addAppointment("Bram", "Putra", "grover", "01/09/2021 6:30 am");
		assertTrue(calendar.hasAppointment(LocalDate.of(2021, 1, 9)));
	}
	
	@Test
	public void returnFalseForHasAppointmentsIfThereAreNoAppointments() {
		GymCalendar calendar = new GymCalendar(LocalDate.of(2021, 1, 9));
		assertFalse(calendar.hasAppointment(LocalDate.of(2021, 1, 9)));
	}
	
	@Test
	public void returnCurrentDaysAppointments() {
		GymCalendar calendar = new GymCalendar(LocalDate.of(2021, 1, 9));
		calendar.addAppointment("Bram", "Putra", "grover", "01/09/2021 6:30 am");
		calendar.addAppointment("Bram", "Putra", "wei", "01/09/2021 7:30 am");
		calendar.addAppointment("Bram", "Putra", "tyson", "01/10/2021 7:30 am");
		assertEquals(2, calendar.getTodayAppointments().size());
	}

}
