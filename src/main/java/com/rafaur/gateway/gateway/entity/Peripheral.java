package com.rafaur.gateway.gateway.entity;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.*;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.validation.annotation.Validated;

import java.util.Date;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Peripheral")
//@Validated
public class Peripheral {
	@Id
	@Column(nullable = false, updatable = true)
	@NotNull
	private Long uid;

	@NotBlank
	private String vendor;
	
	@Past(message = "Enter valid date.")
	private Date created;
	private Boolean status;// - online/offline.

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "Gateway_serialNumber",
			nullable = false, referencedColumnName = "serialNumber")
	@NotFound(action = NotFoundAction.IGNORE)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
//	@Valid
	private Gateway gateway;


	public Peripheral(Gateway gateway) {
		this.gateway = gateway;
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.created,
				this.status,
				this.vendor);
	}

	@Override
	public boolean equals(Object obj) {
		if (this.hashCode()== obj.hashCode())
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Peripheral other = (Peripheral) obj;
		if (this.uid == null) {
			if (other.uid != null)
				return false;
		} else if (!this.uid.equals(other.uid))
			return false;
		return true;
	}
}
