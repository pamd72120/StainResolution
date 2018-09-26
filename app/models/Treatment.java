package models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Treatment
{
    @Id private int treatmentId;
    private int stainTypeId;
    private String instruction;
    private int textileId;

    public int getTreatmentId()
    {
        return treatmentId;
    }

    public void setTreatmentId(int treatmentId)
    {
        this.treatmentId = treatmentId;
    }

    public int getStainTypeId()
    {
        return stainTypeId;
    }

    public void setStainTypeId(int stainTypeId)
    {
        this.stainTypeId = stainTypeId;
    }

    public String getInstruction()
    {
        return instruction;
    }

    public void setInstruction(String instruction)
    {
        this.instruction = instruction;
    }

    public int getTextileId()
    {
        return textileId;
    }

    public void setTextileId(int textileId)
    {
        this.textileId = textileId;
    }
}
