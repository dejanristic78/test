/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dejan.test.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "AVAILABILITY")
public class Availability implements Serializable
{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "AVAILABILITY_ID")
    private Integer id;

    @NotNull
    @Column(name = "FROM_DATE")
    String fromDate;

    @NotNull
    @Column(name = "TO_DATE")
    String toDate;

    @ManyToOne
    @JoinColumn(name = "APPLICANT", referencedColumnName = "APPLICANT_ID")
    private Applicant applicant;

    public Availability()
    {
    }

    public Availability(String fromDate, String toDate)
    {
        this.fromDate = fromDate;
        this.toDate = toDate;
    }

    public Applicant getApplicant()
    {
        return applicant;
    }

    public void setApplicant(Applicant applicant)
    {
        this.applicant = applicant;
        if (!applicant.getAvailabilityIntervals().contains(this))
            applicant.getAvailabilityIntervals().add(this);
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getFromDate()
    {
        return fromDate;
    }

    public void setFromDate(String fromDate)
    {
        this.fromDate = fromDate;
    }

    public String getToDate()
    {
        return toDate;
    }

    public void setToDate(String toDate)
    {
        this.toDate = toDate;
    }

    @Override
    public String toString()
    {
        return fromDate + " - " + toDate;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Availability))
        {
            return false;
        }
        Availability other = (Availability) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
        {
            return false;
        }
        return true;
    }

    public String test()
    {
        return id + ", " + fromDate + ", " + toDate;
    }

}
