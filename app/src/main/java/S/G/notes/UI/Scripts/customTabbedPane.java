//---------------------------------------------
package S.G.notes.UI.Scripts;
//---------------------------------------------

//---------------------------------------------
// Imported and used Libraries
//---------------------------------------------
import javax.swing.JTabbedPane;
//---------------------------------------------

/**
 * notes
 * @author S.G.[i]
 * @since 0.5
 */

//---------------------------------------------

//---------------------------------------------
    //CustomTabbedPane class what I can use to change UI of JTabbedPane
//---------------------------------------------
public class customTabbedPane extends JTabbedPane
{
    public customTabbedPane() 
    {
        setUI(new customTabbedPaneUI());
    }
//---------------------------------------------
} // End of CustomTabbedPane class declaration
//---------------------------------------------
