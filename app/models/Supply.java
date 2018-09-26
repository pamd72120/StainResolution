package models;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Supply
{
    @Id private int SupplyId;
    private int TreatmentId;
    private String SupplyName;
    private byte [] picture;

    public int getSupplyId()
    {
        return SupplyId;
    }

    public void setSupplyId(int supplyId)
    {
        SupplyId = supplyId;
    }

    public int getTreatmentId()
    {
        return TreatmentId;
    }

    public void setTreatmentId(int treatmentId)
    {
        TreatmentId = treatmentId;
    }

    public String getSupplyName()
    {
        return SupplyName;
    }

    public void setSupplyName(String supplyName)
    {
        SupplyName = supplyName;
    }

    public byte[] getPicture()
    {
        return picture;
    }

    public void setPicture(byte[] picture)
    {
        this.picture = picture;
    }
}
