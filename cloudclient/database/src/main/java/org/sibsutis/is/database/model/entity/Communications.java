/**
 * This file was generated by the Jeddict
 */
package org.sibsutis.is.database.model.entity;

import java.util.List;
import javax.persistence.Basic;
import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;

/**
 * @author Eugene
 */
@Embeddable
public
	class Communications {

    @Basic
    private
	    String WaterMain;

    @Basic
    private
	    String PhoneLine;

    @Basic
    private
	    String PowerLine380v;

    @Basic
    private
	    String EthernetLine;

    @ElementCollection
    private
	    List<String> OtherCommunications;

    public
	    String getWaterMain () {
	return this.WaterMain;
    }

    public
	    void setWaterMain (String WaterMain) {
	this.WaterMain = WaterMain;
    }

    public
	    String getPhoneLine () {
	return this.PhoneLine;
    }

    public
	    void setPhoneLine (String PhoneLine) {
	this.PhoneLine = PhoneLine;
    }

    public
	    String getPowerLine380v () {
	return this.PowerLine380v;
    }

    public
	    void setPowerLine380v (String PowerLine380v) {
	this.PowerLine380v = PowerLine380v;
    }

    public
	    String getEthernetLine () {
	return this.EthernetLine;
    }

    public
	    void setEthernetLine (String EthernetLine) {
	this.EthernetLine = EthernetLine;
    }

    public
	    List<String> getOtherCommunications () {
	return this.OtherCommunications;
    }

    public
	    void setOtherCommunications (List<String> OtherCommunications) {
	this.OtherCommunications = OtherCommunications;
    }

}
