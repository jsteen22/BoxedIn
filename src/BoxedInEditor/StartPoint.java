/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BoxedInEditor;

import java.awt.Point;

/**
 *
 * @author tmb5577
 */
public class StartPoint extends GameObject{

        public StartPoint(Point p){
            location = p;
        }
        public StartPoint(SaveableGameObject sgo){
            this.location = sgo.p;
            this.setHeight(sgo.h);
            this.setWidth(sgo.w);
        }
        public void draw(){
            int x = this.location.x*Level.boxPixelWidth;
            int y = this.location.y*Level.boxPixelHeight;
            levelGraphics.drawImage(ImageUtility.getStartPointImage(), x, y, null);
        } 
    
}
