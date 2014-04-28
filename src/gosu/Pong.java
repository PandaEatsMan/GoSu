/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gosu;

import environment.Actor;
import environment.Direction;
import environment.Velocity;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

/**
 *
 * @author ZackB
 */
public class Pong extends Actor {
    private Dimension size = new Dimension(10, 10);
    private Color color = Color.PINK;

    public Pong(Point position, Velocity velocity) {
        super(position, velocity);
    }

    public void paint(Graphics graphics){
        graphics.setColor(getColor());
        graphics.fill3DRect(this.getPosition().x, this.getPosition().y, this.getSize().width, this.getSize().height, true);
        
        
    }

    /**
     * @return the size
     */
    public Dimension getSize() {
        return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(Dimension size) {
        this.size = size;
    }

    /**
     * @return the color
     */
    public Color getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(Color color) {
        this.color = color;
    }
}
