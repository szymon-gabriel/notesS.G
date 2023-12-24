//---------------------------------------------
package S.G.notes.system.settings;
//---------------------------------------------

//---------------------------------------------
// Imported and used Libraries
//---------------------------------------------
import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

//---------------------------------------------

/**
 * notes
 * @author S.G.[i]
 * @version 0.5
 */

//---------------------------------------------
public class settings 
{
    //---------------------------------------------
        //Variables for custom UI colors
    //---------------------------------------------
    private Color UIColor;
    private int fontStyle;
    private int fontSize;
    private int fontSize_index;
    private String fontName;
    private int fontName_index;
    private int turnOnDarkMode;
    private Color DarkModeColor;
    //---------------------------------------------
    
    //---------------------------------------------
        // getters
        // return value of UIColor and TurnOnDarkMode
        // variables
    //---------------------------------------------
    // UIColor
    public Color getUIColor() {
        return UIColor;
    }
    // DarkModeColor
    public Color getDarkModeColor() {
        return DarkModeColor;
    }
    // TurnOnDarkMode
    public int getTurnOnDarkMode() {
        return turnOnDarkMode;
    }
    // fontStyle
    public int getfontStyle()
    {
        return fontStyle;
    }
    // fontSize
    public int getfontSize()
    {
        return fontSize;
    }
    // fontSize_index
    public int getfontSize_index()
    {
        return fontSize_index;
    }
    // fontName
    public String getfontName()
    {
        return fontName;
    }
    // fontName_index
    public int getfontName_index()
    {
        return fontName_index;
    }
    //---------------------------------------------
        // Setters
    //---------------------------------------------
    // UIColor
    public void setUIColor(Color UIColor) {
        this.UIColor = UIColor;
    }
    // UIColor
    public void setDarkModeColor(Color DarkModeColor) {
        this.DarkModeColor = DarkModeColor;
    }
    // TurnOnDarkMode
    public void setTurnOnDarkMode(int turnOnDarkMode) {
        this.turnOnDarkMode = turnOnDarkMode;
    }
    // fontStyle
    public void setfontStyle(int fontStyle)
    {
        this.fontSize = fontSize;
    }
    // fontSize
    public void setfontSize(int fontSize)
    {
        this.fontSize = fontSize;
    }
    // fontSize_index
    public void setfontSize_index(int fontSize_index)
    {
        this.fontSize_index = fontSize_index;
    }
    // fontName
    public void setfontName(String fontName)
    {
        this.fontName = fontName;
    }
    // fontName_index
    public void setfontName_index(int fontName_index)
    {
        this.fontName_index = fontName_index;
    }
    //---------------------------------------------
    
    public settings(Color UIColor, int turnOnDarkMode) {
        this.UIColor = UIColor;
        this.turnOnDarkMode = turnOnDarkMode;
    }

    public settings() {
    }
    
    public void loadSettingsFromFile()
    {
        try
        {
            Properties config = new Properties();
            FileInputStream inputStream = new FileInputStream(new File("system_settings.properties"));
            config.load(inputStream);
            String UIColors = config.getProperty("UIColor");
            String DarkModeColors = config.getProperty("DarkModeColor");
            UIColor = new Color(Integer.parseInt(UIColors));
            DarkModeColor = new Color(Integer.parseInt(DarkModeColors));
            turnOnDarkMode = Integer.parseInt(config.getProperty("turnOnDarkMode"));
            fontStyle = Integer.parseInt(config.getProperty("fontStyle"));
            fontSize = Integer.parseInt(config.getProperty("fontSize"));
            fontSize_index = Integer.parseInt(config.getProperty("fontSize_index"));
            fontName_index = Integer.parseInt(config.getProperty("fontName_index"));
            fontName = config.getProperty("fontName");
            inputStream.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public void saveSettingsToFile(String name, String value)
    {
        try
        {
            Properties config = new Properties();
            File configFile = new File("system_settings.properties");
            FileInputStream inputStream = new FileInputStream(configFile);
            config.load(inputStream);
            config.setProperty(name, value);
            config.store(new FileOutputStream(configFile), null);
            inputStream.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
}
