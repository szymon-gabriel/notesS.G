//---------------------------------------------
package S.G.notes.UI.Scripts;
//---------------------------------------------

//---------------------------------------------
// Imported and used Libraries
//---------------------------------------------
import S.G.notes.system.settings.settings;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import static javax.swing.SwingConstants.BOTTOM;
import static javax.swing.SwingConstants.LEFT;
import static javax.swing.SwingConstants.RIGHT;
import static javax.swing.SwingConstants.TOP;
import javax.swing.plaf.basic.BasicGraphicsUtils;
import javax.swing.plaf.basic.BasicTabbedPaneUI;
//---------------------------------------------

/**
 * notes
 * @author S.G.[i]
 * @since 0.5
 */

//---------------------------------------------

//---------------------------------------------
    //CustomTabbedPaneUI class what to declarate how TabbedPane will look
//---------------------------------------------
public class customTabbedPaneUI extends BasicTabbedPaneUI
{
    private Rectangle currentRectangle;
    
    @Override
    protected void paintTabBorder(Graphics g, int tabPlacement, int tabIndex, int x, int y, int w, int h, boolean isSelected)
    {
        Graphics2D grap2D = (Graphics2D)g.create();
        //Anti Aliasing ON to avoid sharp edges
        grap2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        if(currentRectangle != null)
            if(isSelected)
            {
                currentRectangle = new Rectangle(x, y, w, h);
            }
        if (currentRectangle !=null)
        {
            grap2D.fillRect(currentRectangle.x, currentRectangle.y + currentRectangle.height, currentRectangle.width, currentRectangle.height);
        }
        
        grap2D.dispose();
    }

    @Override
        protected void paintFocusIndicator(Graphics g, int tabPlacement,
                                            Rectangle[] rects, int tabIndex,
                                            Rectangle iconRect, Rectangle textRect,
                                            boolean isSelected) 
        {
        Rectangle tabRect = rects[tabIndex];
        if (tabPane.hasFocus() && isSelected) {
            int x, y, w, h;
            g.setColor(focus);
            switch(tabPlacement) {
              case LEFT:
                  x = 0;
                  y = 0;
                  w = 0;
                  h = 0;
                  break;
              case RIGHT:
                  x = 0;
                  y = 0;
                  w = 0;
                  h = 0;
                  break;
              case BOTTOM:
                  x = 0;
                  y = 0;
                  w = 0;
                  h = 0;
                  break;
              case TOP:
              default:
                  x = 0;
                  y = 0;
                  w = 0;
                  h = 0;
            }
            BasicGraphicsUtils.drawDashedRect(g, x, y, w, h);
        }
    }
    
    //size of single tab
    @Override
    protected Insets getTabInsets(int tabPlacement, int tabIndex)
    {
        return new Insets(5,30,5,30);
    }

    @Override
    protected void paintTabArea(Graphics g, int tabPlacement, int selectedIndex)
    {
        Color UIColor = new Color(230,20,90);
        
        settings UIColorForSettings = new settings();
        UIColorForSettings.loadSettingsFromFile();
        UIColor = UIColorForSettings.getUIColor();
        
        int turnOnDarkMode = 1;
        settings DarkModeConfig = new settings();
        DarkModeConfig.loadSettingsFromFile();
        turnOnDarkMode = DarkModeConfig.getTurnOnDarkMode();
        
        
        Graphics2D grap2D = (Graphics2D)g.create();
        //Anti Aliasing ON to avoid sharp edges
        grap2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        if(turnOnDarkMode == 1)
        {
            tabPane.setForeground(new java.awt.Color(198, 197, 193));
        }
        else if(turnOnDarkMode == 0)
        {
            tabPane.setForeground(new Color(28,27,23));
        }
        
        tabPane.setFont(new java.awt.Font("Monospaced", 1, 12));
        if(selectedIndex == 0)
        {
            tabPane.setBackgroundAt(0, UIColor);
            if(turnOnDarkMode == 1)
            {
                tabPane.setBackgroundAt(1, new Color(35,35,35));
                tabPane.setBackgroundAt(2, new Color(35,35,35));
            }
            else if(turnOnDarkMode == 0)
            {
                tabPane.setBackgroundAt(1, new Color(235,235,235));
                tabPane.setBackgroundAt(2, new Color(235,235,235));
            }
        }
        
        if(selectedIndex == 1)
        {
            tabPane.setBackgroundAt(1, UIColor);
            if(turnOnDarkMode == 1)
            {
                tabPane.setBackgroundAt(0, new Color(35,35,35));
                tabPane.setBackgroundAt(2, new Color(35,35,35));
            }
            else if(turnOnDarkMode == 0)
            {
                tabPane.setBackgroundAt(0, new Color(235,235,235));
                tabPane.setBackgroundAt(2, new Color(235,235,235));
            }
        }
        
        if(selectedIndex == 2)
        {
            tabPane.setBackgroundAt(2, UIColor);
            if(turnOnDarkMode == 1)
            {
                tabPane.setBackgroundAt(0, new Color(35,35,35));
                tabPane.setBackgroundAt(1, new Color(35,35,35));
            }
            else if(turnOnDarkMode == 0)
            {
                tabPane.setBackgroundAt(0, new Color(235,235,235));
                tabPane.setBackgroundAt(1, new Color(235,235,235));
            }
        }
        super.paintTabArea(grap2D, tabPlacement, selectedIndex);
    }
    
    
    @Override
    protected void paintContentBorder(Graphics g, int tabPlacement, int selectedIndex)
    {
    }
}
