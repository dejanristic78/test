/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dejan.test.managedbeans;

import dejan.test.model.Availability;
import dejan.test.model.Competence;
import dejan.test.model.CompetenceProfile;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Stateful;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Dejan
 */
@Named("AppBean")
@Stateful
public class AppBean {
    @PersistenceContext(unitName = "dejan_test_war_1.0PU")
    EntityManager em;
    
    @PostConstruct
    void init() {
        System.err.println("AppBean PostConstruct!");
    }
    public void persistData1() {
        System.err.println("Persisting");
        em.persist(new Competence("Lampa"));
        em.persist(new Competence("Karusell"));
        em.persist(new Competence("Biljetter"));
    }
    public void persistData() {
        System.err.println("Persisting");
        Availability av1 = new Availability("11-11-1111", "12-11-1111");
        Availability av2 = new Availability("22-11-1111", "23-11-1111");
        
        
        List<Availability> avL = new ArrayList<>();
        avL.add(av1);
        avL.add(av2);
        List<CompetenceProfile> cpL = new ArrayList<>();
        //cpL.add(cp1);
        //cpL.add(cp2);
        //Applicant ap = new Applicant("7811300057", "Dehab", "Aferwersd", "asdf@asdf.com", avL, cpL);
        
        //em.persist(ap);
    }
    public void fetchData() {
        
    }
    
}
