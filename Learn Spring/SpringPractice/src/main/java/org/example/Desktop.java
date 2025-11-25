package org.example;

import org.springframework.stereotype.Component;

@Component
public class Desktop implements Computer {

    @Override
    public void compile(){
        System.out.println("Compiling on Desktop....");
    }
}
