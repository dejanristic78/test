/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dejan.test.managedbeans;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

import javax.inject.Named;

/**
 *
 * @author Dejan
 */
@Named
@ViewScoped
public class IndexBean implements Serializable{
    
    @Inject
    AppBean appBean;
    
    public IndexBean() {
    }
    @PostConstruct
    void init() {
        System.err.println(this+"Construct!");
    }
    @PreDestroy
    void signoff() {
        System.err.println(this+"Destroy!");
    }
    
    public void save() {
        System.err.println("persist");
        appBean.persistData();
        
    }
    public void load() {
        System.err.println("fetch");
        appBean.fetchData();
    }
    public String go() {
        return "secondPage.xhtml";
    }
    
}
