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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "COMPETENCEPROFILE")
public class CompetenceProfile implements Serializable
{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "COMPETENCE_PROFILE_ID")
    private Integer id;

    @NotNull
    @Column(name = "YEARS_OF_EXPERIENCE")
    private int yearsOfExperience;

    @NotNull
    @OneToOne
    @JoinColumn(name = "COMPETENCE_ID")
    private Competence competence;

    @ManyToOne
    @JoinColumn(name = "APPLICANT_ID")
    private Applicant applicant;

    public CompetenceProfile()
    {
    }

    public Applicant getApplicant()
    {
        return applicant;
    }

    public void setApplicant(Applicant applicant)
    {
        this.applicant = applicant;
        if (!applicant.getCompetenceProfiles().contains(this))
            applicant.getCompetenceProfiles().add(this);
    }

    public Integer getId()
    {
        return id;
    }

    public int getYearsOfExperience()
    {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience)
    {
        this.yearsOfExperience = yearsOfExperience;
    }

    public Competence getCompetence()
    {
        return competence;
    }

    public void setCompetence(Competence competence)
    {
        this.competence = competence;
    }

    public void setId(Integer id)
    {
        this.id = id;
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
        if (!(object instanceof CompetenceProfile))
        {
            return false;
        }
        CompetenceProfile other = (CompetenceProfile) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
        {
            return false;
        }
        return true;
    }

    public CompetenceProfile(int yearsOfExperience, Competence competence)
    {
        this.yearsOfExperience = yearsOfExperience;
        this.competence = competence;
    }

    @Override
    public String toString()
    {
        return competence.getName() + " : " + yearsOfExperience;
    }

}
