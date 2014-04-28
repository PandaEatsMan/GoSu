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
    private Object Pong;
    private Paddle paddleRight;
    private Pong pongRight;

    @Override
    public void initializeEnvironment() {
        this.paddleRight = new Paddle(new Point(250, 550), new Velocity(0, -5));
        this.getActors().add(paddleRight);

        this.pongRight = new Pong(new Point(250, 550), new Velocity(0, 0));
        this.getActors().add(pongRight);

//        this.gosu = new Pong(new Point(100, 150), 10, Direction.UP);
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
