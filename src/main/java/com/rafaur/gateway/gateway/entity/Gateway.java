package com.rafaur.gateway.gateway.entity;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.validation.annotation.Validated;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Gateway")
//@Validated
public class Gateway {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "serialNumber")
    @NotBlank
    private String serialNumber;
    @NotBlank
	private String name;
    @Pattern(regexp="^(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\." +
            "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\." +
            "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\." +
            "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$",
            message="IP Address no valid")
    private String ipv4Address;// (to be validated)
    @OneToMany(mappedBy = "gateway", cascade={CascadeType.ALL})
    @Column(insertable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
//    @ToString.Exclude
//    @EqualsAndHashCode.Exclude
    @Size(max = 10)
//    @Valid
    private Set<Peripheral> peripherals = new HashSet<>();


    @Override
    public int hashCode() {
        return Objects.hash(this.ipv4Address,
                this.name,
                this.serialNumber);
    }

    public void addP(Peripheral peripheral){
        this.peripherals.add(peripheral);
        return;
    }
}
