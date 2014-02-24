/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dejan.test.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "APPLICANT", uniqueConstraints = @UniqueConstraint(columnNames = { "SSN" }))
public class Applicant implements Serializable
{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "APPLICANT_ID")
    private Integer id;

    @NotNull
    @Column(name = "SSN")
    private String ssn;

    @NotNull
    @Column(name = "FIRST_NAME")
    private String firstName;

    @NotNull
    @Column(name = "LAST_NAME")
    private String lastName;

    @NotNull
    @Column(name = "EMAIL")
    private String email;

    @NotNull
    @OneToMany(mappedBy = "applicant", cascade = CascadeType.ALL)
    private List<Availability> availabilityIntervals;

    @OneToMany(mappedBy = "applicant", cascade = CascadeType.ALL)
    private List<CompetenceProfile> competenceProfiles;

    public Applicant()
    {

    }

    public Applicant(String ssn, String firstName, String lastName, String email, List<Availability> availabilityIntervals, List<CompetenceProfile> competenceProfiles)
    {
        this.ssn = ssn;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        setAvailabilityIntervals(availabilityIntervals);
        setCompetenceProfiles(competenceProfiles);
        
        
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getSsn()
    {
        return ssn;
    }

    public void setSsn(String ssn)
    {
        this.ssn = ssn;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public List<Availability> getAvailabilityIntervals()
    {
        return availabilityIntervals;
    }

    public void setAvailabilityIntervals(List<Availability> availabilityIntervals)
    {
        this.availabilityIntervals = availabilityIntervals;
        
        //Adds id of "this" as foreign key to Availability
        for(Availability a : availabilityIntervals) 
        {
            if(a.getApplicant() != this) 
            {
                a.setApplicant(this);
            }
        }
    }

    public List<CompetenceProfile> getCompetenceProfiles()
    {
        return competenceProfiles;
    }

    public void setCompetenceProfiles(List<CompetenceProfile> competenceProfiles)
    {
        this.competenceProfiles = competenceProfiles;
        
        //Adds id of "this" as foreign key to CompetenceProfile
        for(CompetenceProfile c : competenceProfiles) 
        {
            if(c.getApplicant() != this) 
            {
                c.setApplicant(this);
            }
        }
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
        if (!(object instanceof Applicant))
        {
            return false;
        }
        Applicant other = (Applicant) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "se.kth.iv1201projekt.model.Applicant[ id=" + id + " ]";
    }

}
