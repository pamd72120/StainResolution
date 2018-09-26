package models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class StainType
{
   @Id private int stainTypeId;
   private String typeName;
   private byte[] picture;


    public int getStainTypeId()
    {
        return stainTypeId;
    }

    public void setStainTypeId(int stainTypeId)
    {
        this.stainTypeId = stainTypeId;
    }

    public String getTypeName()
    {
        return typeName;
    }

    public void setTypeName(String typeName)
    {
        this.typeName = typeName;
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
