package models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TreatmentSupply
{
   @Id private int treatmentSupplyId;
   private int treatmentId;
   private int supplyId;

    public int getTreatmentSupplyId()
    {
        return treatmentSupplyId;
    }

    public void setTreatmentSupplyId(int treatmentSupplyId)
    {
        this.treatmentSupplyId = treatmentSupplyId;
    }

    public int getTreatmentId()
    {
        return treatmentId;
    }

    public void setTreatmentId(int treatmentId)
    {
        this.treatmentId = treatmentId;
    }

    public int getSupplyId()
    {
        return supplyId;
    }

    public void setSupplyId(int supplyId)
    {
        this.supplyId = supplyId;
    }
}
