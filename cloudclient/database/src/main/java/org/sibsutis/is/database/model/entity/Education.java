/**
 This file was generated by the Jeddict
 */
package org.sibsutis.is.database.model.entity;

import javax.persistence.Basic;
import javax.persistence.Entity;

/**
 @author Admin
 */
@Entity
public class Education extends Document
{

    @Basic
    private String Education;

    @Basic
    private String series;

    @Basic
    private String date_of_issue;

    public String getEducation()
    {
        return this.Education;
    }

    public void setEducation(String Education)
    {
        this.Education = Education;
    }

    public String getSeries()
    {
        return this.series;
    }

    public void setSeries(String series)
    {
        this.series = series;
    }

    public String getDate_of_issue()
    {
        return this.date_of_issue;
    }

    public void setDate_of_issue(String date_of_issue)
    {
        this.date_of_issue = date_of_issue;
    }

}
