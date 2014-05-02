/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gosu;

import environment.Direction;
import environment.Environment;
import environment.Velocity;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

/**
 *
 * @author Daniel
 */
class GameEnvironment extends Environment {

    private Pong gosu;
//    private Object Pong;
    private Paddle paddleRight;
    private Pong pong;
//    private final Point position;
//    private final int speed;
//    private final Direction direction;
//    
//    public GameEnvironment (Point position, int speed, Direction direction) {
//        this.position = position;
//        this.speed = speed;
//        this.direction = direction;
//    }
//
//    GameEnvironment() {
//    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

    @Override
    public void initializeEnvironment() {
        this.paddleRight = new Paddle(new Point(750, 550), new Velocity(0, -1));
        this.getActors().add(paddleRight);

        this.pong = new Pong(new Point(500, 200), new Velocity(-3, -4));
        this.getActors().add(pong);

    }

    public void act() {
        super.act();
        System.out.println("Pong position = " + this.pong.getPosition().toString());
        if (this.pong.getPosition().y <= 0) {
            this.pong.getVelocity().y *= -1;
            //play sound
        } else if (this.pong.getPosition().y >= this.getSize().height) {
            this.pong.getVelocity().y *= -1;
            //play sound
        } else if (this.pong.getPosition().x <= 0) {
            this.pong.getVelocity().x *= -1;
            //play sound
        }
        
    }

    @Override
    public void timerTaskHandler() {

    }

    @Override
    public void keyPressedHandler(KeyEvent e) {

    }

    @Override
    public void keyReleasedHandler(KeyEvent e) {
    }

    @Override
    public void environmentMouseClicked(MouseEvent e) {
    }

    @Override
    public void paintEnvironment(Graphics graphics) {
    }
}
