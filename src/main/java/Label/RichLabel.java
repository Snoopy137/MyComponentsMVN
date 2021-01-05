package Label;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author admin
 */
public class RichLabel extends JLabel{
    
    public RichLabel (){
        this.addMouseListener(mouseover);
    }
    
    private Color fontbackground;
    private Color mouseovercolor;
    private Icon BackGroundPicture;
    
    //sets color change if selected
    private MouseAdapter mouseover = new MouseAdapter() {
        @Override
        public void mouseEntered(MouseEvent e) {
            super.mouseClicked(e);
            if (mouseovercolor!=null){
                fontbackground = getBackground();
                setOpaque(true);
                setBackground(mouseovercolor);
                repaint();
            }
        }
        @Override
        public void mouseExited(MouseEvent e) {
            setOpaque(true);
            setBackground(fontbackground);
            repaint();
        }
    };
    
    //paints a background picture if selected
    @Override
    public void paint(Graphics g) {
        if (BackGroundPicture != null) {
            Image img = ((ImageIcon)BackGroundPicture).getImage();
            g.drawImage(img, 0, 0, getWidth(), getHeight(),this);
            setOpaque(false);
            super.paint(g);
        }
        else{
            super.paint(g);
        }
    }
    
    public void setMouseovercolor(Color mouseovercolor){
        this.mouseovercolor=mouseovercolor;
    }

    public MouseAdapter getMouseover() {
        return mouseover;
    }

    public Icon getBackGroundPicture() {
        return BackGroundPicture;
    }

    public void setBackGroundPicture(Icon BackGroundPicture) {
        this.BackGroundPicture = BackGroundPicture;
    }
    
}
