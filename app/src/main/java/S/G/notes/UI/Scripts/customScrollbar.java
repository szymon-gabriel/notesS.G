//---------------------------------------------
package S.G.notes.UI.Scripts;
//---------------------------------------------

//---------------------------------------------
// Imported and used Libraries
//---------------------------------------------
import S.G.notes.system.settings.settings;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JScrollBar;
//---------------------------------------------

/**
 * notes
 * @author S.G.[i]
 * @since 0.2
 */

//---------------------------------------------

//---------------------------------------------
    //CustomScrollBar class what I can use to change UI of scrollbar in value
//---------------------------------------------
public class customScrollbar extends JScrollBar 
{
    public customScrollbar()
    {
        Color DarkModeColor;
        settings DarkModeConfig = new settings();
        DarkModeConfig.loadSettingsFromFile();
        DarkModeColor = DarkModeConfig.getDarkModeColor();
        
        setUI(new customScrollbarUI());
        setPreferredSize(new Dimension(9,9));
        
        if(DarkModeConfig.getTurnOnDarkMode() == 0)
        {
            setBackground(DarkModeColor);//background color of scrollbar
//            setVisible(false);
        }
            
        if(DarkModeConfig.getTurnOnDarkMode() == 1)
        {
            setBackground(DarkModeColor);//background color of scrollbar
//            setVisible(false);
        }
    }
//---------------------------------------------
} // End of CustomScrollBar class declaration
//---------------------------------------------
