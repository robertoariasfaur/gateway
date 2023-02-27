package com.rafaur.gateway.gateway.dto;

import lombok.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class GatewayDTO {
    @NonNull
    private String serialNumber;
    @NonNull
    private String name;
    @NonNull
    private String ipv4Address;
    private Set<PeripheralDTO> peripherals = new HashSet<>(10);

    @Override
    public int hashCode() {
        return Objects.hash(this.ipv4Address,
                this.name,
                this.serialNumber);
    }

    @Override
    public boolean equals(Object obj) {
        if (this.hashCode() == obj.hashCode())
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        GatewayDTO other = (GatewayDTO) obj;
        if (this.serialNumber == null) {
            if (other.getSerialNumber() != null)
                return false;
        } else if (!this.serialNumber.equals(other.getSerialNumber()))
            return false;
        return true;
    }
}
