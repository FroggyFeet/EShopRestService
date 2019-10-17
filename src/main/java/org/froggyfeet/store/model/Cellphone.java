package org.froggyfeet.store.model;

import org.froggyfeet.store.model.interfaces.Good;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "cellphones")
public class Cellphone extends AbstractPersistable<Integer> implements Good {

    @Basic
    @Column(name = "vendor")
    private String vendor;
    @Basic
    @Column(name = "model")
    private String model;
    @Basic
    @Column(name = "screen_diagonal")
    private double screenDiagonal;
    @Basic
    @Column(name = "charge_port")
    private String chargePort;

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getScreenDiagonal() {
        return screenDiagonal;
    }

    public void setScreenDiagonal(double screenDiagonal) {
        this.screenDiagonal = screenDiagonal;
    }

    public String getChargePort() {
        return chargePort;
    }

    public void setChargePort(String chargePort) {
        this.chargePort = chargePort;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Cellphone cellphone = (Cellphone) o;
        return screenDiagonal == cellphone.screenDiagonal &&
                vendor.equals(cellphone.vendor) &&
                model.equals(cellphone.model) &&
                chargePort.equals(cellphone.chargePort);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), vendor, model, screenDiagonal, chargePort);
    }

    @Override
    public String toString() {
        return "Cellphone{" +
                "vendor='" + vendor + '\'' +
                ", model='" + model + '\'' +
                ", screenDiagonal=" + screenDiagonal +
                ", chargePort='" + chargePort + '\'' +
                '}';
    }
}
