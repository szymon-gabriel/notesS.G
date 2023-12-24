//---------------------------------------------
package S.G.notes.UI.Scripts;
//---------------------------------------------

//---------------------------------------------
// Imported and used Libraries
//---------------------------------------------
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;
//---------------------------------------------

/**
 * notes
 * @author S.G.[i]
 * @since notes 0.5
 */

//---------------------------------------------
    // CustomJPanel class to make it rounded
//---------------------------------------------
public class RoundedButton extends JButton
{
    //---------------------------------------------
        //Variables for RoundedPanel custom UI
    //---------------------------------------------
    private int roundedHeight = 0;
    private int roundedWidth = 0;
    //---------------------------------------------

    //---------------------------------------------
        // getters
        // return value of Rounded Height and Width
        // variables
    //---------------------------------------------
    // Rounded Height
    public int getRoundedHeight()
    {
        return roundedHeight;
    }
    //---------------------------------------------
    // Rounded Width
    public int getRoundedWidth()
    {
        return roundedWidth;
    }
    //---------------------------------------------
    
    //---------------------------------------------
        // Setters set value of rounded variables
        // and after this repaint the part of panel
        // and to make rounded option a default value 
    //---------------------------------------------
    // Rounded Height
    public void setRoundedHeight(int roundedHeight)
    {
        this.roundedHeight = roundedHeight;
        repaint();
    }
    //---------------------------------------------
    // Rounded Width
    public void setRoundedWidth(int roundedWidth)
    {
        this.roundedWidth = roundedWidth;
        repaint();
    }
    //---------------------------------------------
    
    //---------------------------------------------
        // Setting a panel to have ability to be 
        // transparent on edges
    //---------------------------------------------
    public RoundedButton()
    {
        setContentAreaFilled(false);
        setOpaque(false);
        setBorder(new EmptyBorder(8,8,8,8));
    }
    //---------------------------------------------

    //---------------------------------------------
        // paintComponent method whats creates whole panel
    //---------------------------------------------
    @Override
    protected void paintComponent(Graphics g)
    {
        Graphics2D grap2D = (Graphics2D)g.create();
        //Anti Aliasing ON to avoid sharp edges
        grap2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        //Setting a background color to be a color which will be filled this panel
        grap2D.setColor(getBackground());
        //Creating rounded eadges
        grap2D.fillRoundRect(0, 0, getWidth(), getHeight(), roundedWidth, roundedHeight);

        grap2D.dispose();
        super.paintComponent(g);
    //---------------------------------------------
    }   // End of PaintComponent method whats creates whole panel
    //---------------------------------------------
    
//---------------------------------------------
} // End of CustomJPanel class declaration
//---------------------------------------------