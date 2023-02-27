package com.rafaur.gateway.gateway.dto;

import com.rafaur.gateway.gateway.entity.Gateway;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
public class PeripheralDTO {
    private Long uid;
    private String vendor;
    private Date created;
    private Boolean status;
    private GatewayDTO gateway;

    @Override
    public int hashCode() {
        return Objects.hash(this.uid,
                this.status,
                this.vendor,
                this.created);
    }

    @Override
    public boolean equals(Object obj) {
        if (this.hashCode() == obj.hashCode())
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        PeripheralDTO other = (PeripheralDTO) obj;
        if (this.uid == null) {
            if (other.getUid() != null)
                return false;
        } else if (!this.uid.equals(other.getUid()))
            return false;
        return true;
    }
}
