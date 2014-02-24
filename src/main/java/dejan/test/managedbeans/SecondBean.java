/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dejan.test.managedbeans;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Dejan
 */
@Named
@ConversationScoped
public class SecondBean implements Serializable{
    private String name = "SecondBean";
    private int i = 0;
    @Inject
    Conversation conversation;
    
     
    @PostConstruct
    void init() {
        System.err.println(name +" "+ this+" Construct!");
    }
    @PreDestroy
    void signoff() {
        System.err.println(name +" "+ this+" Destroy!");
    }        
    public void doSomething() {
        conversation.end();
    
    }
    public String back() {
        return "index.xhtml";
    }
    
}
