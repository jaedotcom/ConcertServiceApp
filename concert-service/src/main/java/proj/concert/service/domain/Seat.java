package proj.concert.service.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Version;
import javax.persistence.CascadeType;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Domain model class to represent seats at the concert venue.
 * <p>
 * A Seat describes a seat in terms of:
 * label the seat label
 * price the price
 * date the concert date
 * isBooked - whether it is booked or not
 */
@Entity
public class Seat implements Serializable {
	@Id
	private String label;
	@Id
	private LocalDateTime date;
	private BigDecimal price;
	private boolean isBooked = false;
	@Version
	private int version;

	@ManyToMany(mappedBy = "seats", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Booking> bookings;

	public Seat() {
	}

	public Seat(String label, LocalDateTime date, BigDecimal price) {
		this.label = label;
		this.price = price;
		this.date = date;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public LocalDateTime getDate(){
		return date;
	}

	public void setDate(LocalDateTime date){
		this.date = date;
	}

	public boolean getIsBooked() {
		return this.isBooked;
	}

	public void setIsBooked(boolean isBooked) {
		this.isBooked = isBooked;
	}

	public int getVersion(){
		return this.version;
	}

	public void setVersion(int newVersion){
		this.version = newVersion;
	}

	@Override
	public String toString() {
		return label;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;

		if (o == null || getClass() != o.getClass())
			return false;

		Seat seat = (Seat) o;

		return new EqualsBuilder()
				.append(label, seat.label)
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37)
				.append(label)
				.toHashCode();
	}
}
