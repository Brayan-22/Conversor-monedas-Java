package com.oracleonejava;

import com.oracleonejava.view.Principal;

/**
 * Hello world!
 *
 */
public class App 
{
    private Principal principal;
    public App(){
        this.principal = new Principal();
        principal.iniciar();
    }
    public static void main( String[] args )
    {
        new App();
    }
}
