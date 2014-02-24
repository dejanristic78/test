/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dejan.test.interceptor;

import java.io.Serializable;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

/**
 *
 * @author Dejan
 */
public class TestICR implements Serializable{
    
    @AroundInvoke
    public Object intercept(InvocationContext context) throws Exception {
        
        System.err.println("TestICR is Logging !!");
        
        Object result = context.proceed();
        
        return result;
    }
}
