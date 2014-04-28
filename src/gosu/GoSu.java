/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gosu;

import environment.ApplicationStarter;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Daniel
 */
public class GoSu {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       start();
    }

    private static void start() {
        ApplicationStarter.run("GoSu", new GameEnvironment());
    }
    
}


