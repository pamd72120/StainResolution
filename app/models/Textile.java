package models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Textile
{
    @Id private int textileId;
    private String textileName;

    public int getTextileId()
    {
        return textileId;
    }

    public void setTextileId(int textileId)
    {
        this.textileId = textileId;
    }

    public String getTextileName()
    {
        return textileName;
    }

    public void setTextileName(String textileName)
    {
        this.textileName = textileName;
    }

}
