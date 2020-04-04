/*
 * Copyright 2020 Hochschule Luzern - Informatik.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ch.hslu.ad.sw07.balls;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class Canvas {

    private static Canvas canvasSingleton;

    public static Canvas getCanvas() {
        if (canvasSingleton == null) {
            canvasSingleton = new Canvas("Ball Demo", 600, 400,
                    Color.white);
        }
        canvasSingleton.setVisible(true);
        return canvasSingleton;
    }

    private final JFrame frame;
    private final CanvasPane canvas;
    private Graphics2D graphic;
    private final Color backgroundColor;
    private Image canvasImage;
    private final List<Object> objects;
    private final HashMap<Object, ShapeDescription> shapes;

    private Canvas(String title, int width, int height, Color bgColor) {
        frame = new JFrame();
        canvas = new CanvasPane();
        frame.setContentPane(canvas);
        frame.setTitle(title);
        frame.setLocation(30, 30);
        canvas.setPreferredSize(new Dimension(width, height));
        backgroundColor = bgColor;
        frame.pack();
        objects = new ArrayList<>();
        shapes = new HashMap<>();
    }

    public int getWidth() {
        return canvas.getWidth();
    }

    public int getHeight() {
        return canvas.getHeight();
    }

    public void setVisible(boolean visible) {
        if (graphic == null) {
            // first time: instantiate the offscreen image and fill it with
            // the background color
            Dimension size = canvas.getSize();
            canvasImage = canvas.createImage(size.width, size.height);
            graphic = (Graphics2D) canvasImage.getGraphics();
            graphic.setColor(backgroundColor);
            graphic.fillRect(0, 0, size.width, size.height);
            graphic.setColor(Color.black);
        }
        frame.setVisible(visible);
        if (!visible){
            frame.dispose();
        }
    }

    public synchronized void draw(Object referenceObject, String color, Shape shape) {
        objects.remove(referenceObject);   // just in case it was already there
        objects.add(referenceObject);      // add at the end
        shapes.put(referenceObject, new ShapeDescription(shape, color));
        redraw();
    }

    public synchronized void erase(Object referenceObject) {
        objects.remove(referenceObject);   // just in case it was already there
        shapes.remove(referenceObject);
        redraw();
    }

    public void setForegroundColor(String colorString) {
        switch (colorString) {
            case "red":
                graphic.setColor(new Color(235, 25, 25));
                break;
            case "black":
                graphic.setColor(Color.black);
                break;
            case "blue":
                graphic.setColor(new Color(30, 75, 220));
                break;
            case "yellow":
                graphic.setColor(new Color(255, 230, 0));
                break;
            case "green":
                graphic.setColor(new Color(80, 160, 60));
                break;
            case "magenta":
                graphic.setColor(Color.magenta);
                break;
            case "white":
                graphic.setColor(Color.white);
                break;
            default:
                graphic.setColor(Color.black);
                break;
        }
    }

    public void wait(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            // ignoring exception at the moment
        }
    }

    private void redraw() {
        erase();
        for (Object shape : objects) {
            shapes.get(shape).draw(graphic);
        }
        canvas.repaint();
    }

    private void erase() {
        Color original = graphic.getColor();
        graphic.setColor(backgroundColor);
        Dimension size = canvas.getSize();
        graphic.fill(new Rectangle(0, 0, size.width, size.height));
        graphic.setColor(original);
    }

    private class CanvasPane extends JPanel {

        private static final long serialVersionUID = 1L;

        @Override
        public void paint(Graphics g) {
            g.drawImage(canvasImage, 0, 0, null);
        }
    }

    private class ShapeDescription {

        private final Shape shape;
        private final String colorString;

        public ShapeDescription(Shape shape, String color) {
            this.shape = shape;
            colorString = color;
        }

        public void draw(Graphics2D graphic) {
            setForegroundColor(colorString);
            graphic.fill(shape);
        }
    }
}
