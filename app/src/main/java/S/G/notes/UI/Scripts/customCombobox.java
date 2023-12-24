//---------------------------------------------
package S.G.notes.UI.Scripts;
//---------------------------------------------

//---------------------------------------------
// Imported and used Libraries
//---------------------------------------------
import S.G.notes.system.settings.settings;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.JScrollPane;
import static javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.basic.BasicComboPopup;
import javax.swing.plaf.basic.ComboPopup;
//---------------------------------------------

/**
 * notes
 * @author S.G.[i]
 * @since 0.5
 */

//---------------------------------------------
    // CustomCombobox class to declarate how combobox will look like
//---------------------------------------------
public class customCombobox<Exception> extends JComboBox<Exception>
{
    //---------------------------------------------
        //Variables for UI Color
    //---------------------------------------------
    Color UIColor;
    //---------------------------------------------
        //Variable for mouseListener
    //---------------------------------------------
    private boolean mouseOnCombo;
    //---------------------------------------------

//    @Override
//    public void setBackground(Color backgroundOfCombobox)
//    {
//        Uncomment this section if you want this effect:
//
//        //NO BACKGROUND - THE PANEL IS AN BACKGROUND ITSELF FOR THIS COMBOBOX
//        /*
//            That mean if you create this customCombobox you need to have already 
//            created background behind it, like simple container with backround 
//            color RED for example.
//        */
//    }
    
    //---------------------------------------------
        //Setting new customCombobox Renderer
    //---------------------------------------------
    public customCombobox(String[] fontName)
    {
        setCustomUI();
    }
    //---------------------------------------------
    
    //---------------------------------------------
        //customCombobox Renderer
    //---------------------------------------------
    private void setCustomUI()
    {
        //---------------------------------------------
            //Setting new customCombobox UI
        //---------------------------------------------
        setUI(new ComboUI(this));
        //---------------------------------------------
        
        //---------------------------------------------
            //Setting new customCombobox UI
        //---------------------------------------------
        setRenderer(new DefaultListCellRenderer()
        {
            @Override
            public Component getListCellRendererComponent(JList<?> cCBList, Object object, int i, boolean itemSelected, boolean cellHasFocus)
            {
                //Creating component (combobox)
                Component customCombobox = super.getListCellRendererComponent(cCBList, object, i, itemSelected, cellHasFocus);
                
                //Adding an border for popup item to make a space for a button, if you change these values take a look on the button, if it is still visible
                //correctly
                setBorder(new EmptyBorder(5, 5, 5, 5));
                
                //Forcing the combobox item to use a different font for every front from model list[] for example item Arial will have font Arial and
                //item Monospaced will have font Monospaced, good if you want to create fontName_combobox what will be a list of available fonts
                //Font itemFont = new Font(object.toString(), Font.PLAIN, customCombobox.getFont().getSize());
                //setFont(itemFont);
                
                //Setting popup selected item background
                if (itemSelected)
                {
                    customCombobox.setBackground(UIColor);
                }
                //---------------------------------------------
                
                return customCombobox;
            }
        });
        //---------------------------------------------
    //---------------------------------------------
    }   // End of customCombobox Renderer method
    //---------------------------------------------
    
    //---------------------------------------------
        // Setting a customCombobox to use CustomUI class
    //---------------------------------------------
    public customCombobox() 
    {
        setCustomUI();
    }   
    //---------------------------------------------
    
    //---------------------------------------------
        // CustomUI class and setting a behavior of a combobox
    //---------------------------------------------
    private class ComboUI extends BasicComboBoxUI
    {
        //---------------------------------------------
            //Variables for ComboUI
        //---------------------------------------------
        private customCombobox customCombo;
        
        //---------------------------------------------
            //Setting customCombobox mouse behavior
        //---------------------------------------------
        public ComboUI(customCombobox combo)
        {
            this.customCombo = combo;
        //---------------------------------------------
            //MouseListener to change color of combobox button when mouseEnter in combo area
        //---------------------------------------------
            addMouseListener(new MouseAdapter()
            {
                @Override
                public void mouseEntered(MouseEvent me)
                {
                    mouseOnCombo = true;
                    repaint();
                }
                
                @Override
                public void mouseExited(MouseEvent me)
                {
                    mouseOnCombo = false;
                    repaint();
                }
            });
        //---------------------------------------------
        
        //---------------------------------------------
            //PopupMenuListener to change color of combobox button when you click on combobox to open popup list of items, when you click to select and item
            //and when you cancel your selection
        //---------------------------------------------
            addPopupMenuListener(new PopupMenuListener()
            {
                @Override
                public void popupMenuWillBecomeVisible(PopupMenuEvent popupMenuEvent)
                {
                    arrowButton.setForeground(UIColor);
                }

                @Override
                public void popupMenuWillBecomeInvisible(PopupMenuEvent popupMenuEvent)
                {
                    arrowButton.setForeground(new Color(187, 187, 187));
                    getRootPane().requestFocus(false);
                }

                @Override
                public void popupMenuCanceled(PopupMenuEvent popupMenuEvent)
                {
                    arrowButton.setForeground(new Color(187, 187, 187));
                    getRootPane().requestFocus(false);
                }
            });
        //---------------------------------------------
        }   // End of setting customCombobox mouse behavior
        //---------------------------------------------
        
        //---------------------------------------------
            //Setting a customScrollbar to be a default scroll for this combobox
        //---------------------------------------------
        @Override
        protected ComboPopup createPopup()
        {
            BasicComboPopup comboboxPopup = new BasicComboPopup(comboBox)
            {
                @Override
                protected JScrollPane createScroller()
                {
                    //changing a size of single item cell
                    list.setFixedCellHeight(28);
                    
                    //scroll variable and setting scroll to never show his horizontal version
                    JScrollPane scrollThatWillBeUsed = new JScrollPane(list);
                    scrollThatWillBeUsed.setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_NEVER);
                    
                    //customScrollbar class variable and setting it to be a default scrollbar
                    customScrollbar newCustomScrollbar = new customScrollbar();
                    scrollThatWillBeUsed.setVerticalScrollBar(newCustomScrollbar);
                    //changing a speed of scroll
                    newCustomScrollbar.setUnitIncrement(35);
                    
                    return scrollThatWillBeUsed;
                }
            };
            
            //loading darkModeTurnON setting from settings file, and putting value as an int state 0/1
            settings DarkModeConfig = new settings();
            DarkModeConfig.loadSettingsFromFile();
            int turnOnDarkMode = DarkModeConfig.getTurnOnDarkMode();
            
            //setting a border around combo popup and making the color of the border depends if dark mode is on or off
            if(turnOnDarkMode == 0)
            {
            comboboxPopup.setBorder(new LineBorder(new Color(195,195,195), 1));
            }
            else if(turnOnDarkMode == 1)
            {
            comboboxPopup.setBorder(new LineBorder(new Color(25,25,25), 1));
            }
            
            return comboboxPopup;
        }
        //---------------------------------------------
        
        //---------------------------------------------
            //Setting a background for currentSelectedValue to be 'transparent' 
        //---------------------------------------------
        @Override
        public void paintCurrentValueBackground(Graphics g, Rectangle bounds, boolean hasFocus)
        {
            //This method is empty to allow customCombobox have a dark or light background color depends on dark / light mode
        }
        //---------------------------------------------
        
        //---------------------------------------------
            //Creating arrowButton '>'
        //---------------------------------------------
        @Override
        protected JButton createArrowButton()
        {
            return new SimpleArrowLikeButton();
        }
        //---------------------------------------------

        @Override
        public void paint(Graphics g, JComponent c)
        {
            //loading UIColor setting from settings file, and putting value as an color for UIColor
            settings UIColorForSettings = new settings();
            UIColorForSettings.loadSettingsFromFile();
            UIColor = UIColorForSettings.getUIColor();
            
            //painting current selected value component
            super.paint(g, c);
            //creating grap2D to set rendering hints and set UI color behavior and fill rectangles and 
            Graphics2D grap2D = (Graphics2D) g;
            //Anti Aliasing ON to avoid sharp edges
            grap2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            //Anti Aliasing ON for text to let the font itself to decide whether to use antialiasing or to use solid colors.
            grap2D.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_HRGB);
            
            //setting graph2D to have UI color when mouse is on combo and to have gray color if mouse is not on combo
            if (mouseOnCombo)
            {
                if(!customCombo.hasFocus())
                {
                    grap2D.setColor(UIColor);
                }
                else if(customCombo.hasFocus())
                {
                    grap2D.setColor(UIColor);
                }
            }
            else
            {
                if(!customCombo.hasFocus())
                {
                    grap2D.setColor(new Color (75,75,75));
                }
                else if(customCombo.hasFocus())
                {
                    grap2D.setColor(UIColor);
                }
            }
            
            //setting component height -1 to create a line what will be able to take UI color when mouse is on combo
            grap2D.fillRect(0, c.getHeight() - 1, c.getWidth(), 4);
            //grap2D dispose when this object is not needed anymore to free some memory space
            grap2D.dispose();
        }
        
        private class SimpleArrowLikeButton extends JButton
        {
            public SimpleArrowLikeButton()
            {
                //making button area not filled to make border invisible to create clear transition beetwen current selected value and button
                //and make more space for text (">")
                setContentAreaFilled(false);
                setBorder(new EmptyBorder(5, 5, 5, 5));
            }

            @Override
            public void paint(Graphics g)
            {
                super.paint(g);
                
                //creating grap2D to set rendering hints and set background
                Graphics2D grap2D = (Graphics2D) g;
                //Anti Aliasing ON to avoid sharp edges
                grap2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                //Anti Aliasing ON for text to let the font itself to decide whether to use antialiasing or to use solid colors.
                grap2D.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_HRGB);
                
                //setting button size, sign and text to be bold and bigger that current selected combo value
                setText(">");
                setFont(new Font("Monospaced", 1, 16));;
                setSize(0, 0);
                
                //setting arrowButtonText to have UI color when mouse is on combo and to have gray color if mouse is not on combo
                if (mouseOnCombo)
                {
                    if(!customCombo.hasFocus())
                    {
                        setForeground(UIColor);
                    }
                    else if(customCombo.hasFocus())
                    {
                        setForeground(UIColor);
                    }
                }
                else 
                {
                    if(!customCombo.hasFocus())
                    {
                        setForeground(new Color (198,197,193));
                    }
                }
                
                //grap2D dispose when this object is not needed anymore to free some memory space
                grap2D.dispose();
            }
        }
    }
//---------------------------------------------
} // End of CustomCombobox class declaration
//---------------------------------------------