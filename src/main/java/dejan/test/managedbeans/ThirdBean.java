/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dejan.test.managedbeans;

import dejan.test.interceptor.TestICR;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.interceptor.Interceptors;

/**
 *
 * @author Dejan
 */
@Named
@ConversationScoped
@Interceptors(TestICR.class)
public class ThirdBean implements Serializable{
    private String name = "ThirdBean";
    private int i = 0;
    @Inject
    Conversation conversation;
    
     
    @PostConstruct
    void init() {
        conversation.begin();
        System.err.println(name +" "+ this+" Construct!");
    }
    @PreDestroy
    void signoff() {
        System.err.println(name +" "+ this+" Destroy!");
    }        
    public void doSomething() {
        
    
    }
    public String back() {
        conversation.end();
        return "index.xhtml";
    }
    
}
