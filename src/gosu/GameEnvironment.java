        /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gosu;

import audio.AudioPlayer;
import static audio.AudioPlayer.LOOP_SINGLE;
import static audio.AudioPlayer.play;
import environment.Direction;
import environment.Environment;
import environment.Velocity;
import java.awt.Color;
import java.awt.Font;
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
    private int score;

    @Override
    public void initializeEnvironment() {
        this.paddleRight = new Paddle(new Point(750, 550), new Velocity(0, -13));
        this.paddleRight.getSize().height = 75;
        this.getActors().add(paddleRight);

        this.pong = new Pong(new Point(500, 200), new Velocity(-10, -10));
        this.getActors().add(pong);

    }

    public void act() {
        super.act();
//        System.out.println("Pong position = " + this.pong.getPosition().toString());
        if (this.pong.getPosition().y <= 0) {
            this.pong.getVelocity().y *= -1;
            AudioPlayer.play("/reasources/boing_01.wav");
        } else if (this.pong.getPosition().y >= this.getSize().height) {
            this.pong.getVelocity().y *= -1;
            AudioPlayer.play("/reasources/boing_01.wav");
        } else if (this.pong.getPosition().x <= 0) {
            this.pong.getVelocity().x *= -1;
            AudioPlayer.play("/reasources/boing_01.wav");
        } else if (this.pong.getPosition().x >= 875) {
            this.pong.getVelocity().x *= -1;
            AudioPlayer.play("/reasources/boing_01.wav");
        } else if (paddleRight.getPosition().y <= 0) {
            this.paddleRight.getVelocity().y *= -1;
        } else if (this.paddleRight.getPosition().y >= this.getSize().height) {
            this.paddleRight.getVelocity().y *= -1;
        }
    }

    @Override
    public void timerTaskHandler() {
        if ((paddleRight != null) && (pong != null)) {
            if (this.paddleRight.intersects(this.pong)) {
                System.out.println("HIT!!!!!!!!!!!!!!!!!!!!!!!!!");
                this.score += 1;
                System.out.println("score");
                this.pong.getPosition().x = paddleRight.getPosition().x - pong.getSize().width;
                this.pong.getVelocity().x *= -1;
                AudioPlayer.play("/reasources/thud.wav");

            }
            
        }

    }

    @Override
    public void keyPressedHandler(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            this.paddleRight.getVelocity().y *= -1;
        } else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            this.paddleRight.getVelocity().y *= 1;

        }
    }

    @Override
    public void keyReleasedHandler(KeyEvent e) {
    }

    @Override
    public void environmentMouseClicked(MouseEvent e) {
    }

    @Override
    public void paintEnvironment(Graphics graphics) {
        graphics.drawLine(825, 0, 825, this.getSize().height);
        graphics.setFont(new Font("Calibri ", Font.ITALIC, 50));
        graphics.drawString("Score: " + this.score, 50, 50);
    }

}
