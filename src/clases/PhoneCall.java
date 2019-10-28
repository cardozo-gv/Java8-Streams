package clases;

import java.time.Duration;
import java.time.LocalDate;

public class PhoneCall {
	
	private Contact contact;
	private LocalDate time;
	private Duration duration;
	
	
	public PhoneCall(Contact contact, LocalDate time, Duration duration) {
		super();
		this.contact = contact;
		this.time = time;
		this.duration = duration;
	}


	public Contact getContact() {
		return contact;
	}


	public void setContact(Contact contact) {
		this.contact = contact;
	}


	public LocalDate getTime() {
		return time;
	}


	public void setTime(LocalDate time) {
		this.time = time;
	}


	public Duration getDuration() {
		return duration;
	}


	public void setDuration(Duration duration) {
		this.duration = duration;
	}
	
	
	
	

}
