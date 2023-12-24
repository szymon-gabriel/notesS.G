//---------------------------------------------
package S.G.notes.UI.Scripts;
//---------------------------------------------

//---------------------------------------------
// Imported and used Libraries
//---------------------------------------------
import S.G.notes.system.settings.settings;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JScrollBar;
import javax.swing.plaf.basic.BasicScrollBarUI;
//---------------------------------------------

/**
 * notes
 * @author S.G.[i]
 * @since 0.2
 */

//---------------------------------------------
    // CustomScrollBarUI class to declarate how scrollbar will look
//---------------------------------------------
public class customScrollbarUI extends BasicScrollBarUI
{
    //---------------------------------------------
        //Variables for UI
    //---------------------------------------------
    private Color UIColor = new Color(230,20,90); // - bright pink/raspberry
    private final int sizeOfThumb = 911;
    private int x, y, width, height;
    int turnOnDarkMode = 1;
    settings DarkModeConfig = new settings();
    //---------------------------------------------
    
    //---------------------------------------------
        //Extra Settings for ScrollUpDownButton
        //setting an 0x0 size to arrowButtons
    //---------------------------------------------
    private JButton ArrowScrollbarButton()
    {
        JButton arrowButton = new JButton();
        arrowButton.setPreferredSize(new Dimension(0, 0));
        arrowButton.setMinimumSize(new Dimension(0, 0));
        arrowButton.setMaximumSize(new Dimension(0, 0));
        return arrowButton;
    }
    @Override
    protected JButton createIncreaseButton(int orientation) {
        return ArrowScrollbarButton();
    }
    @Override
    protected JButton createDecreaseButton(int orientation) 
    {
        return ArrowScrollbarButton();
    }
    //---------------------------------------------
    
    //---------------------------------------------
        //Settings for Scrollbar Track
    //---------------------------------------------
    @Override
    protected void paintTrack(Graphics g, JComponent c, Rectangle trackBounds) 
    {
        DarkModeConfig.loadSettingsFromFile();
        turnOnDarkMode = DarkModeConfig.getTurnOnDarkMode();
        
        x = trackBounds.x;
        y = trackBounds.y;
        width = trackBounds.width;
        height = trackBounds.height;
        
        Graphics2D grap2DTrack = (Graphics2D)g;
        grap2DTrack.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); //antialiasing ON
        if(turnOnDarkMode == 1)
        {
            grap2DTrack.setColor(new Color(25,25,25));//background color of scrollbar
        }
        else if(turnOnDarkMode == 0)
        {
            grap2DTrack.setColor(new Color(225,225,225));//background color of scrollbar
        }
        grap2DTrack.fillRect(x, y, width, height);
    }
    //---------------------------------------------
    
    //---------------------------------------------
        //Settings for Scrollbar Thumb
    //---------------------------------------------
    @Override
    protected Dimension getMaximumThumbSize()
    {
        if(scrollbar.getOrientation() == JScrollBar.VERTICAL)
        {
            return new Dimension(0,sizeOfThumb);
        }
        else
        {
            return new Dimension(sizeOfThumb,0);
        }
    }

    @Override
    protected Dimension getMinimumThumbSize()
    {
        if(scrollbar.getOrientation() == JScrollBar.VERTICAL)
        {
            return new Dimension(sizeOfThumb,40);
        }
        else
        {
            return new Dimension(40,sizeOfThumb);
        }
    }
    
    @Override
    protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds)
    {
        settings UIColorForSettings = new settings();
        UIColorForSettings.loadSettingsFromFile();
        UIColor = UIColorForSettings.getUIColor();
        
        x = thumbBounds.x;
        y = thumbBounds.y;
        width = thumbBounds.width;
        height = thumbBounds.height;
        
        Graphics2D grap2DTrack = (Graphics2D)g;
        grap2DTrack.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); //antialiasing ON
        if(scrollbar.getOrientation() == JScrollBar.VERTICAL)
        {
            y += 6;
            height -= 12;
        }
        else
        {
            x += 6;
            width -= 12;
        }
        grap2DTrack.setColor(UIColor); //color of thumb
        grap2DTrack.fillRect(x, y, width, height);
    }
    //---------------------------------------------
    
//---------------------------------------------
} // End of CustomScrollBarUI class declaration
//---------------------------------------------
