/**
 * Entity representing the table competence in the database model.
 *
 */
package dejan.test.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "COMPETENCE")
public class Competence implements Serializable
{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "COMPETENCE_ID")
    private Integer id;
    
    @NotNull
    @Column(name = "NAME")
    private String name;

    /**
     * Constructor
     */
    public Competence()
    {
    }

    /**
     * Alternate constructor
     *
     * @param competenceId Identifier for the specfic competence
     * @param name Name of competence (depends on language)
     * @param lang Selects language
     */
    public Competence(String name)
    {
        this.name = name;
    }

    public Integer getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
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
        if (!(object instanceof Competence))
        {
            return false;
        }
        Competence other = (Competence) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
        {
            return false;
        }
        return true;
    }

    /**
     *
     * @return name of competence
     */
    @Override
    public String toString()
    {
        return getName();
    }
}
