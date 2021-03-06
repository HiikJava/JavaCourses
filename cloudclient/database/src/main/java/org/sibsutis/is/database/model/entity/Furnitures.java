/**
 * This file was generated by the Jeddict
 */
package org.sibsutis.is.database.model.entity;

import java.util.List;
import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;

/**
 * @author Eugene
 */
@Embeddable
public class Furnitures
{

    @ElementCollection
    private List<String> Equipment;

    @ElementCollection
    private List<String> PiecesOfFurniture;

    @ElementCollection
    private List<String> OtherFurnitures;

    public List<String> getEquipment()
    {
        return this.Equipment;
    }

    public void setEquipment(List<String> Equipment)
    {
        this.Equipment = Equipment;
    }

    public List<String> getPiecesOfFurniture()
    {
        return this.PiecesOfFurniture;
    }

    public void setPiecesOfFurniture(List<String> PiecesOfFurniture)
    {
        this.PiecesOfFurniture = PiecesOfFurniture;
    }

    public List<String> getOtherFurnitures()
    {
        return this.OtherFurnitures;
    }

    public void setOtherFurnitures(List<String> OtherFurnitures)
    {
        this.OtherFurnitures = OtherFurnitures;
    }

}
