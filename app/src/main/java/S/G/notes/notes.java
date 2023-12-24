//---------------------------------------------
package S.G.notes;
//---------------------------------------------

//---------------------------------------------
// Imported and used Libraries
//---------------------------------------------
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.plaf.basic.BasicButtonUI;
import javax.swing.plaf.basic.BasicMenuItemUI;
import javax.swing.plaf.basic.BasicPopupMenuUI;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.UndoManager;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.*;
import S.G.notes.UI.Scripts.*;
import S.G.notes.system.settings.settings;
import static java.awt.Frame.MAXIMIZED_BOTH;
import static java.awt.Frame.NORMAL;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicToggleButtonUI;
//---------------------------------------------

/**
 * notes
 * @author S.G.[i]
 * @version 0.5
 */

//---------------------------------------------
public class notes extends JFrame
{
    //---------------------------------------------
    //Custom Selection of PopupMenuItem background Color Class declaration
    //---------------------------------------------
    public class customColorForPopupUI extends BasicMenuItemUI 
    {
        public customColorForPopupUI(Color color)
        {
                super.selectionBackground = color;
                super.acceleratorForeground = new Color(201, 201, 197);
                super.acceleratorFont = UIManager.getFont(new Font("Monospaced", Font.BOLD, 10));
        }
    //---------------------------------------------
    } // End of Custom Selection of PopupMenuItem background Color Class declaration
    //---------------------------------------------

    //---------------------------------------------
        //Color for UI, change in setting to implement in future
    //---------------------------------------------
    
//    private Color UIColor = new Color(90,20,230); // - bright purple
//    private Color UIColor = new Color(90,230,20); // - brighter light green
//    private Color UIColor = new Color(20,90,230); // - bright blue
//    private Color UIColor = new Color(20,230,90); // - bright green
//    private Color UIColor = new Color(230,20,20); // - like bright red
//    private Color UIColor = new Color(230,90,20); // - bright orange
    private Color UIColor = new Color(230,20,90); // - bright pink/raspberry
//    private Color UIColor = new Color(230,230,20); //- bright yellow
//    private Color UIColor = new Color(253,220,179); //- like gold
    private Color DarkModeColor = new Color(25,25,25);
    //---------------------------------------------

    //---------------------------------------------
        //Variables for UI
    //---------------------------------------------
    String nameAndVersionOfAnAplication = "notes 0.5";
    int searchYsize = 0; //TextField Y size
    int settingsXsize = 0;
    int turnOn = 0; //SearchBar activation int (used for true/false like boolean)
    int turnOnSettings = 0; //SettingsPanel acivation int (used for true/false like boolean)
    int turnOnDarkMode = 1; //DarkMode acivation int (used for true/false like boolean)
    int fontStyle = 0; // fontStyle integer to force previous(when you was using this app last time) selected font style
    int fontSize = 8; // fontSize integer to force previous(when you was using this app last time) selected font size
    int fontSize_index = 0; // fontSize_index integer to force previous(when you was using this app last time) selected font size in combobox by index
    String fontName; // fontName of last time selected font
    int fontName_index; // fontName_index integer to force previous(when you was using this app last time) selected font name in combobox by index
    int flagSaved = 1; //Used for to declarate if file is saved or not
    File currentFile = null; // simple currentFile holder
    String pathOfCurrentSelectedFile = "File Path (open a file or save a file first to see a path to your file)";
    private JFileChooser chooser = new JFileChooser();
    private String fileName = "New File" + " " + nameAndVersionOfAnAplication;
    private String fileNameWithStar = fileName;
    UndoManager undoRedoMenager = new UndoManager();
    ImageIcon tabFontIcon = new ImageIcon(getClass().getResource("/icon/FontSettingsCategory.png"));
    ImageIcon tabAppearanceIcon = new ImageIcon(getClass().getResource("/icon/UICategory.png"));
    ImageIcon tabAboutIcon = new ImageIcon(getClass().getResource("/icon/AboutCategory.png"));
    //---------------------------------------------

    //---------------------------------------------
        //Variables for CustomTitlebar UI
    //---------------------------------------------
    int xx, xy; //Variables of window xx and xy sizes
    //---------------------------------------------
    // Variables declaration for whole UI
    private javax.swing.JLabel UI_color_description_1;
    private javax.swing.JPanel UI_color_description_panel;
    private javax.swing.JPanel UI_color_panel;
    private javax.swing.JLabel UI_color_title;
    private javax.swing.JLabel about_author;
    private javax.swing.JPanel about_description_panel;
    private javax.swing.JLabel about_logo_icon;
    private javax.swing.JPanel about_logo_panel;
    private javax.swing.JPanel about_panel;
    private javax.swing.JLabel about_title;
    private javax.swing.JLabel about_version;
    private javax.swing.JPanel aplicationTitle_panel;
    private javax.swing.JPanel background_panel_what_holds_all;
    private javax.swing.JButton closeWindowButton;
    private S.G.notes.UI.Scripts.RoundedButton color_button_bright_blue;
    private S.G.notes.UI.Scripts.RoundedButton color_button_bright_orange;
    private S.G.notes.UI.Scripts.RoundedButton color_button_bright_purple;
    private S.G.notes.UI.Scripts.RoundedButton color_button_bright_raspberry;
    private S.G.notes.UI.Scripts.RoundedButton color_button_bright_yellow;
    private S.G.notes.UI.Scripts.RoundedButton color_button_brighter_light_green;
    private S.G.notes.UI.Scripts.RoundedButton color_button_like_bright_red;
    private S.G.notes.UI.Scripts.RoundedButton color_button_like_royal_gold;
    private javax.swing.JPanel customTitlebar;
    private javax.swing.JToggleButton dark_mode_button_ON_OFF;
    private javax.swing.JPanel dark_mode_button_panel;
    private javax.swing.JLabel dark_mode_description_1;
    private javax.swing.JLabel dark_mode_description_2;
    private javax.swing.JPanel dark_mode_description_panel;
    private javax.swing.JPanel dark_mode_panel;
    private javax.swing.JLabel dark_mode_title;
    private javax.swing.JLabel fileName_label;
    private javax.swing.JPanel fileName_panel;
    private javax.swing.JLabel file_path;
    private javax.swing.JButton find_text_field_button;
    private S.G.notes.UI.Scripts.customCombobox<String> font_name_combo_box;
    private javax.swing.JPanel font_name_description_panel;
    private javax.swing.JPanel font_name_panel;
    private javax.swing.JLabel font_name_title;
    private S.G.notes.UI.Scripts.customCombobox<String> font_size_combo_box;
    private javax.swing.JPanel font_size_description_panel;
    private javax.swing.JPanel font_size_panel;
    private javax.swing.JLabel font_size_title;
    private S.G.notes.UI.Scripts.customCombobox<String> font_style_combo_box;
    private javax.swing.JPanel font_style_description_panel;
    private javax.swing.JPanel font_style_panel;
    private javax.swing.JLabel font_style_title;
    private javax.swing.JPanel lineUnderDrawerUIColor;
    private javax.swing.JPanel lineWhatColorYouCanCustom;
    private javax.swing.JLabel line_and_column_label;
    private javax.swing.JButton menu_button;
    private javax.swing.JButton minimalizeWindowButton;
    private javax.swing.JButton replace_all_text_field_button;
    private javax.swing.JTextField replace_text_field;
    private javax.swing.JButton replace_text_field_button;
    private javax.swing.JButton resizeWindowButton;
    private javax.swing.JScrollPane scroll_pane_for_text_area;
    private javax.swing.JPanel searchButton;
    private javax.swing.JPanel searchDrawerMenuBar;
    private javax.swing.JPanel searchDrawerMenuBar_panel;
    private javax.swing.JButton search_button;
    private javax.swing.JPanel search_button_panel;
    private javax.swing.JTextField search_text_field;
    private javax.swing.JButton settings_button;
    private javax.swing.JPanel settings_panel;
    private S.G.notes.UI.Scripts.customTabbedPane settings_tabbed_pane;
    private javax.swing.JPanel statusOfFile;
    private javax.swing.JPanel status_file_panel;
    private javax.swing.JPanel tab_1_panel;
    private javax.swing.JPanel tab_2_panel;
    private javax.swing.JPanel tab_3_panel;
    private javax.swing.JTextArea text_area;
    private javax.swing.JPanel text_area_panel;
    private javax.swing.JPanel windowsMinResExit_panel;
    // End of variables declaration

    notes()
    {
        initComponents();

    //---------------------------------------------
        //Settings for CustomTitlebar Buttons
    //---------------------------------------------
    JButton [] customTitleBarButtons = {minimalizeWindowButton, resizeWindowButton, closeWindowButton};
    for(JButton titleBarButtonsSettings : customTitleBarButtons)
    {
        titleBarButtonsSettings.setBackground(new Color(25,25,25));
        titleBarButtonsSettings.setUI(new BasicButtonUI());
        titleBarButtonsSettings.setFont(new java.awt.Font("Monospaced", 0, 12));
        titleBarButtonsSettings.setForeground(new Color(234,234,227));
        titleBarButtonsSettings.setBorder(null);
        titleBarButtonsSettings.addMouseListener(new MouseListener()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                if(e.getSource() == minimalizeWindowButton)
                {
                    setState(Frame.ICONIFIED);
                }
                else if(e.getSource() == resizeWindowButton)
                {
                    if(getExtendedState() == MAXIMIZED_BOTH)
                    {
                        setExtendedState(NORMAL);
                    }
                    else
                    {
                        setExtendedState(MAXIMIZED_BOTH);
                    }
                }
                else if(e.getSource() == closeWindowButton)
                {
                System.exit(0);
                } 
            }

            @Override
            public void mousePressed(MouseEvent e)
            {
                if(e.getSource() == minimalizeWindowButton)
                {
                    minimalizeWindowButton.setBackground(new Color(105,105,117));
                }
                else if(e.getSource() == resizeWindowButton)
                {
                    resizeWindowButton.setBackground(new Color(105,105,117));
                }
                else if(e.getSource() == closeWindowButton)
                {
                    closeWindowButton.setBackground(new Color(255,50,50));
                }
            }

            @Override
            public void mouseReleased(MouseEvent e)
            {
                if(e.getSource() == minimalizeWindowButton)
                {
                    minimalizeWindowButton.setBackground(new Color(25,25,25));
                }
                else if(e.getSource() == resizeWindowButton)
                {
                    resizeWindowButton.setBackground(new Color(25,25,25));
                }
                else if(e.getSource() == closeWindowButton)
                {
                    closeWindowButton.setBackground(new Color(25,25,25));
                }
            }

            @Override
            public void mouseEntered(MouseEvent e)
            {
                if(e.getSource() == minimalizeWindowButton)
                {
                    minimalizeWindowButton.setBackground(new Color(65,65,77));
                }
                else if(e.getSource() == resizeWindowButton)
                {
                    resizeWindowButton.setBackground(new Color(65,65,77));
                }
                else if(e.getSource() == closeWindowButton)
                {
                    closeWindowButton.setBackground(new Color(230,20,20));
                }
                
                if(e.getSource() == minimalizeWindowButton)
                {
                    if(turnOnDarkMode == 1)
                    {
                        minimalizeWindowButton.setBackground(new Color(65,65,77));
                    }
                    else if(turnOnDarkMode == 0)
                    {
                        minimalizeWindowButton.setBackground(new Color(245,245,245));
                    }
                }
                else if(e.getSource() == resizeWindowButton)
                {
                    if(turnOnDarkMode == 1)
                    {
                        resizeWindowButton.setBackground(new Color(65,65,77));
                    }
                    else if(turnOnDarkMode == 0)
                    {
                        resizeWindowButton.setBackground(new Color(245,245,245));
                    }
                }
                else if(e.getSource() == closeWindowButton)
                {
                    if(turnOnDarkMode == 1)
                    {
                        closeWindowButton.setBackground(new Color(230,20,20));
                    }
                    else if(turnOnDarkMode == 0)
                    {
                        closeWindowButton.setBackground(new Color(245,40,40));
                    }
                }
            }

            @Override
            public void mouseExited(MouseEvent e)
            {
                if(e.getSource() == minimalizeWindowButton)
                {
                    if(turnOnDarkMode == 1)
                    {
                        minimalizeWindowButton.setBackground(new Color(25,25,25));
                    }
                    else if(turnOnDarkMode == 0)
                    {
                        minimalizeWindowButton.setBackground(new Color(225,225,225));
                    }
                }
                else if(e.getSource() == resizeWindowButton)
                {
                    if(turnOnDarkMode == 1)
                    {
                        resizeWindowButton.setBackground(new Color(25,25,25));
                    }
                    else if(turnOnDarkMode == 0)
                    {
                        resizeWindowButton.setBackground(new Color(225,225,225));
                    }
                }
                else if(e.getSource() == closeWindowButton)
                {
                    if(turnOnDarkMode == 1)
                    {
                        closeWindowButton.setBackground(new Color(25,25,25));
                    }
                    else if(turnOnDarkMode == 0)
                    {
                        closeWindowButton.setBackground(new Color(225,225,225));
                    }
                }
            }
        });
    }
    //---------------------------------------------

    //---------------------------------------------
        // Settings for MenuButton Buttons

        // Extra Settings for menu button popupMenuItems
    //---------------------------------------------
        JPopupMenu menuFile = new JPopupMenu();
        menuFile.setBorder(new LineBorder(new Color(253,220,179)));
        //---------------------------------------------
        //New File Settings
        //---------------------------------------------
        JMenuItem menuNew = menuFile.add("New");
        menuNew.setIcon(new ImageIcon("/icon/newFileMenuBarIcon.png"));
        menuNew.setAccelerator(KeyStroke.getKeyStroke("ctrl N"));
        menuNew.setUI(new customColorForPopupUI(UIColor));
        menuNew.setFont(new java.awt.Font("Monospaced", 0, 12));
        menuNew.setForeground(new Color(234,234,227));
        menuNew.setBackground(new Color(65,65,77));
        //---------------------------------------------
        //New File ActionListener - settings
        //---------------------------------------------
        menuNew.addActionListener(new ActionListener()
        {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            newFile();
        }
        });
        //---------------------------------------------

        //---------------------------------------------
        //Open File Settings
        //---------------------------------------------
        JMenuItem menuOpen = menuFile.add("Open");
        menuOpen.setIcon(new ImageIcon("/icon/openFileMenuBarIcon.png"));
        menuOpen.setAccelerator(KeyStroke.getKeyStroke("ctrl O"));
        menuOpen.setUI(new customColorForPopupUI(UIColor));
        menuOpen.setFont(new java.awt.Font("Monospaced", 0, 12));
        menuOpen.setForeground(new Color(234,234,227));
        menuOpen.setBackground(new Color(65,65,77));
        //---------------------------------------------
        //Open File ActionListener - settings
        //---------------------------------------------
        menuOpen.addActionListener(new ActionListener()
        {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            openFile();
        }
        });
        //---------------------------------------------
        menuFile.addSeparator();
        //---------------------------------------------
        //Save File Settings
        //---------------------------------------------
        JMenuItem menuSave = menuFile.add("Save");
        menuSave.setIcon(new ImageIcon("/icon/saveFileMenuBarIcon.png"));
        menuSave.setAccelerator(KeyStroke.getKeyStroke("ctrl S"));
        menuSave.setUI(new customColorForPopupUI(UIColor));
        menuSave.setFont(new java.awt.Font("Monospaced", 0, 12));
        menuSave.setForeground(new Color(234,234,227));
        menuSave.setBackground(new Color(65,65,77));
        //---------------------------------------------
        //Save File ActionListener - settings
        //---------------------------------------------
        menuSave.addActionListener(new ActionListener()
        {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            saveFile(currentFile);
        }
        });
        //---------------------------------------------

        //---------------------------------------------
        //SaveAs File Settings
        //---------------------------------------------
        JMenuItem menuSaveAs = menuFile.add("Save As");
        menuSaveAs.setIcon(new ImageIcon("/icon/saveFileAsMenuBarIcon.png"));
        menuSaveAs.setAccelerator(KeyStroke.getKeyStroke("ctrl shift S"));
        menuSaveAs.setUI(new customColorForPopupUI(UIColor));
        menuSaveAs.setFont(new java.awt.Font("Monospaced", 0, 12));
        menuSaveAs.setForeground(new Color(234,234,227));
        menuSaveAs.setBackground(new Color(65,65,77));
        //---------------------------------------------
        //SaveAs File ActionListener - settings
        //---------------------------------------------
        menuSaveAs.addActionListener(new ActionListener()
        {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            saveFileAs();
        }
        });
        //---------------------------------------------
        menuFile.addSeparator();
        //---------------------------------------------
        //Exit File Settings
        //---------------------------------------------
        JMenuItem menuExit = menuFile.add("Close");
        menuExit.setIcon(new ImageIcon("/icon/exitFileMenuBarIcon.png"));
        menuExit.setAccelerator(KeyStroke.getKeyStroke("alt F4"));
        menuExit.setUI(new customColorForPopupUI(UIColor));
        menuExit.setFont(new java.awt.Font("Monospaced", 0, 12));
        menuExit.setForeground(new Color(234,234,227));
        menuExit.setBackground(new Color(65,65,77));
        //---------------------------------------------
        //Exit File ActionListener - settings
        //---------------------------------------------
        menuExit.addActionListener(new ActionListener()
        {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            exitFile();
        }
        });
        //---------------------------------------------

        //---------------------------------------------
        //Main Menu File Settings
        //---------------------------------------------
        if(turnOnDarkMode == 0)
        {
            menuFile.setBackground(new Color(165,165,177));
        }
        if(turnOnDarkMode == 1)
        {
            menuFile.setBackground(new Color(65,65,77));
        }
        menuFile.setUI(new BasicPopupMenuUI());
        menuFile.setSize(270, 150); // change second value if you add new MenuItems for MenuFile, +30 per one Item
        menuFile.setPreferredSize(menuFile.getSize());
        //---------------------------------------------
            
        //---------------------------------------------
        //Settings for MenuButton
        //---------------------------------------------
        JButton [] toolBarButtons = {menu_button};
        for(JButton buttonsSettings : toolBarButtons)
        {
            buttonsSettings.setBackground(new Color(25,25,25));
            buttonsSettings.setUI(new BasicButtonUI());
            buttonsSettings.setFont(new java.awt.Font("Monospaced", 0, 12));
            buttonsSettings.setForeground(new Color(234,234,227));
            buttonsSettings.setBorder(null);
            buttonsSettings.addMouseListener(new MouseListener() 
            {
                @Override
                public void mouseClicked(MouseEvent e)
                {
                    if(e.getSource() == menu_button)
                    {
                        menuFile.show(menu_button, 0,menu_button.getBounds().height);
                        
                    }
                }

                @Override
                public void mousePressed(MouseEvent e)
                {
                    
                }

                @Override
                public void mouseReleased(MouseEvent e)
                {
                    
                }

                @Override
                public void mouseEntered(MouseEvent e)
                {
                    buttonsSettings.setBackground(UIColor);
                }

                @Override
                public void mouseExited(MouseEvent e)
                {
                    if(turnOnDarkMode == 0)
                    {
                        buttonsSettings.setBackground(new Color(225,225,225));
                    }
                    else if(turnOnDarkMode == 1)
                    {
                        buttonsSettings.setBackground(new Color(25,25,25));
                    }
                }
            });
        }
        //---------------------------------------------
    //---------------------------------------------

    //---------------------------------------------
        //Settings for all buttons ToolsCenterBar
    //---------------------------------------------
        JButton [] customTitleCenterBarButtons = 
        {
        find_text_field_button,replace_text_field_button,replace_all_text_field_button};
        for(JButton titleCenterBarButtonsSettings : customTitleCenterBarButtons)
        {
            titleCenterBarButtonsSettings.setBackground(new Color(65,65,77));
            titleCenterBarButtonsSettings.setUI(new BasicButtonUI());
            titleCenterBarButtonsSettings.setFont(new java.awt.Font("Monospaced", 0, 12));
            titleCenterBarButtonsSettings.setForeground(new Color(234,234,227));
            titleCenterBarButtonsSettings.setBorder(null);
            titleCenterBarButtonsSettings.addMouseListener(new MouseListener() 
            {
                @Override
                public void mouseClicked(MouseEvent e)
                {
                    if(e.getSource() == find_text_field_button)
                    {
                        int offset = text_area.getCaretPosition();
                        String searchText = search_text_field.getText();
                        int startOfSelection = text_area.getText().indexOf(searchText,offset);
                        if(startOfSelection != -1)
                        {
                            try 
                            {
                                text_area.requestFocus();
                                text_area.select(startOfSelection, startOfSelection + searchText.length());
                                text_area.requestFocus();
                            } 
                            catch (Exception ex) 
                            {
                                ex.printStackTrace();
                            }
                        }
                        if(startOfSelection == -1)
                        {
                            text_area.requestFocus();
                            text_area.setCaretPosition(0);
                            startOfSelection = text_area.getText().indexOf(searchText);
                            text_area.select(startOfSelection, startOfSelection + searchText.length());
                        }
                        //here i can set an error message for like "This what are you looking for doesn't exist"
                        if(!text_area.getText().contains(searchText) && e.getSource() == find_text_field_button)
                        {
                            text_area.setCaretPosition(offset);
                            text_area.setSelectionStart(offset);
                            text_area.setSelectionEnd(offset);
                        }
                    }
                    if(e.getSource() == replace_text_field_button)
                    {
                        int offset = text_area.getCaretPosition();
                        String searchText = search_text_field.getText();
                        int startOfSelection = text_area.getText().indexOf(searchText,offset);
                        
                        if(search_text_field.getText().equals(replace_text_field.getText()))
                        {
                            System.out.println("System message: Woo woo woo slow down man, you want to replace two same words");
                        }
                        else if(text_area.getSelectedText() == null && !text_area.getText().contains(search_text_field.getText()))
                        {
                            text_area.requestFocus();
                            text_area.setSelectionStart(text_area.getCaretPosition());
                            text_area.setSelectionEnd(text_area.getCaretPosition());
                        }
                        else if(text_area.getSelectedText() == null && text_area.getText().contains(search_text_field.getText()))
                        {
                            text_area.requestFocus();
                            text_area.select(startOfSelection, startOfSelection + searchText.length());
                            text_area.requestFocus();
                            if(startOfSelection == -1)
                            {
                            text_area.requestFocus();
                            text_area.setCaretPosition(0);
                            startOfSelection = text_area.getText().indexOf(searchText);
                            text_area.select(startOfSelection, startOfSelection + searchText.length());
                            }
                            //here i can set an error message for like "This what are you looking for doesn't exist"
                            if(!text_area.getText().contains(searchText) && e.getSource() == find_text_field_button)
                            {
                                text_area.setCaretPosition(offset);
                                text_area.setSelectionStart(offset);
                                text_area.setSelectionEnd(offset);
                            }
                        }
                        else if(text_area.getSelectedText() != null)
                        {
                            if(search_text_field.getText().equals(replace_text_field.getText()))
                            {
                                System.out.println("System message: Woo woo woo slow down man, you want to replace two same words");
                            }
                            else if(!text_area.getText().contains(search_text_field.getText()) && e.getSource() == replace_text_field_button)
                            {
                                text_area.setCaretPosition(text_area.getCaretPosition());
                                text_area.setSelectionStart(text_area.getCaretPosition());
                                text_area.setSelectionEnd(text_area.getCaretPosition());
                            }
                            else if(text_area.getSelectedText().contains(search_text_field.getText()) && e.getSource() == replace_text_field_button)
                            {
                            text_area.getHighlighter().removeAllHighlights();

                            text_area.replaceSelection(replace_text_field.getText());
                            text_area.setSelectionStart(text_area.getCaretPosition());
                            text_area.setSelectionEnd(text_area.getCaretPosition()+1);
                            text_area.setCaretPosition(offset);
                            }
                        }
                    }
                    if(e.getSource() == replace_all_text_field_button)
                    {
                        if(text_area.getText().contains(search_text_field.getText()))
                        {
                            if(search_text_field.getText().equals(replace_text_field.getText()))
                            {
                                System.out.println("System message: Woo woo woo slow down man, you want to replace two same words");
                            }
                            else if(!search_text_field.getText().equals(replace_text_field.getText()))
                            {
                                
                                while(text_area.getText().contains(search_text_field.getText()))
                                {
                                int offset = text_area.getCaretPosition();
                                String searchText = search_text_field.getText();
                                int startOfSelection = text_area.getText().indexOf(searchText,offset);
                                
                                //here i can set an error message for like "This what are you looking for doesn't exist"
                                if(!text_area.getText().contains(searchText) && e.getSource() == replace_all_text_field_button)
                                {
                                    text_area.setCaretPosition(offset);
                                    text_area.setSelectionStart(offset);
                                    text_area.setSelectionEnd(offset);
                                    break;
                                }
                                else if(text_area.getText().contains(searchText) && e.getSource() == replace_all_text_field_button)
                                {
                                    if(startOfSelection == -1)
                                    {
                                    text_area.requestFocus();
                                    text_area.setCaretPosition(0);
                                    startOfSelection = text_area.getText().indexOf(searchText);
                                    text_area.select(offset, offset);
                                    }
                                    text_area.select(startOfSelection, startOfSelection + searchText.length());
                                    text_area.replaceSelection(replace_text_field.getText());
                                    text_area.setSelectionStart(text_area.getCaretPosition());
                                    text_area.setSelectionEnd(text_area.getCaretPosition()-1);
                                }
                                }
                            }
                        }
                        else if((text_area.getText().contains(search_text_field.getText())))
                        {
                            text_area.setCaretPosition(text_area.getCaretPosition());
                            text_area.setSelectionStart(text_area.getCaretPosition());
                            text_area.setSelectionEnd(text_area.getCaretPosition());
                        }
                    }
                }

                @Override
                public void mousePressed(MouseEvent e)
                {
                    
                }

                @Override
                public void mouseReleased(MouseEvent e)
                {
                    
                }

                @Override
                public void mouseEntered(MouseEvent e)
                {
                    if(e.getSource() == find_text_field_button)
                    {
                        find_text_field_button.setBackground(UIColor);
                    }
                    else if(e.getSource() == replace_text_field_button)
                    {
                        replace_text_field_button.setBackground(UIColor);
                    }
                    else if(e.getSource() == replace_all_text_field_button)
                    {
                        replace_all_text_field_button.setBackground(UIColor);
                    }
                }

                @Override
                public void mouseExited(MouseEvent e)
                {
                    if(e.getSource() == find_text_field_button)
                    {
                        if(turnOnDarkMode == 1)
                        {
                            find_text_field_button.setBackground(new Color(65,65,77));
                            find_text_field_button.setForeground(new Color(187,187,187));
                        }
                        else if(turnOnDarkMode == 0)
                        {
                            find_text_field_button.setBackground(new Color(234,234,234));
                            find_text_field_button.setForeground(new Color(29,29,29));
                        }
                    }
                    else if(e.getSource() == replace_text_field_button)
                    {
                        if(turnOnDarkMode == 1)
                        {
                            replace_text_field_button.setBackground(new Color(65,65,77));
                            replace_text_field_button.setForeground(new Color(187,187,187));
                        }
                        else if(turnOnDarkMode == 0)
                        {
                            replace_text_field_button.setBackground(new Color(234,234,234));
                            replace_text_field_button.setForeground(new Color(29,29,29));
                        }
                    }
                    else if(e.getSource() == replace_all_text_field_button)
                    {
                        if(turnOnDarkMode == 1)
                        {
                            replace_all_text_field_button.setBackground(new Color(65,65,77));
                            replace_all_text_field_button.setForeground(new Color(187,187,187));
                        }
                        else if(turnOnDarkMode == 0)
                        {
                            replace_all_text_field_button.setBackground(new Color(234,234,234));
                            replace_all_text_field_button.setForeground(new Color(29,29,29));
                        }
                    }
                }
            });
        }
    //---------------------------------------------

    //---------------------------------------------
        //Extra Settings for Search button and bar
    //---------------------------------------------
        JButton [] searchBarButtons = {search_button};
            
        for(JButton searchButtonSettings : searchBarButtons)
        {
            searchButtonSettings.setBackground(new Color(25,25,25));
            searchButtonSettings.setUI(new BasicButtonUI());
            searchButtonSettings.setFont(new java.awt.Font("Monospaced", 0, 12));
            searchButtonSettings.setForeground(new Color(234,234,227));
            searchButtonSettings.setBorder(null);
            searchButtonSettings.addMouseListener(new MouseListener(){
                @Override
                public void mouseClicked(MouseEvent e)
                {
                    if(e.getSource() == search_button)
                {
                    if(searchYsize == 30 && turnOn == 1)
                    {
                        searchDrawerMenuBar.setSize(searchDrawerMenuBar.getSize().width, searchYsize);
                        
                        Thread searchPSizing = new Thread()
                        {
                          @Override
                          public void run()
                          {
                              try
                              {
                                  for(int i = 30; i >= 0; i--)
                                  {
                                      Thread.sleep(1);
                                      searchDrawerMenuBar.setSize(searchDrawerMenuBar.getSize().width, i);
                                  }
                                  searchDrawerMenuBar.setVisible(false);
                              }
                              catch(Exception e)
                              {
                                  System.out.println("System message: You can't scale search panel");
                              }
                          }
                        };searchPSizing.start();
                        searchYsize = 0;
                        turnOn = 0;
                    }
                    else if(searchYsize == 0 && turnOn == 0)
                    {
                        searchDrawerMenuBar.setVisible(true);
                        searchDrawerMenuBar.setSize(searchDrawerMenuBar.getSize().width, searchYsize);
                        Thread searchPSizing = new Thread()
                        {
                          @Override
                          public void run()
                          {
                              try
                              {
                                  for(int i = 0; i <= searchYsize; i++)
                                  {
                                      Thread.sleep(1);
                                      searchDrawerMenuBar.setSize(searchDrawerMenuBar.getSize().width, i);
                                  }
                              }
                              catch(Exception e)
                              {
                                  System.out.println("System message: You can't scale search panel");
                              }
                          }
                        };searchPSizing.start();
                        searchYsize = 30;
                        turnOn = 1;
                    }
                }
                }

                @Override
                public void mousePressed(MouseEvent e)
                {
                    
                }

                @Override
                public void mouseReleased(MouseEvent e)
                {
                    
                }

                @Override
                public void mouseEntered(MouseEvent e)
                {
                    searchButtonSettings.setBackground(UIColor);
                }

                @Override
                public void mouseExited(MouseEvent e)
                {
                    if(turnOn == 0)
                    searchButtonSettings.setBackground(new Color(25,25,25));
                    else if(turnOn == 1)
                    searchButtonSettings.setBackground(UIColor);
                    
                    if(turnOn == 0 && turnOnDarkMode == 0)
                    searchButtonSettings.setBackground(new Color(225,225,225));
                    else if(turnOn == 1 && turnOnDarkMode == 0)
                    searchButtonSettings.setBackground(UIColor);
                }
            });
        }
    //---------------------------------------------

    //---------------------------------------------
        //Extra Settings for Settings button and bar
    //---------------------------------------------
        JButton [] settingsButton = {settings_button};
            
        for(JButton settingsButtonSettings : settingsButton)
        {
            settingsButtonSettings.setBackground(new Color(25,25,25));
            settingsButtonSettings.setUI(new BasicButtonUI());
            settingsButtonSettings.setFont(new java.awt.Font("Monospaced", 0, 12));
            settingsButtonSettings.setForeground(new Color(234,234,227));
            settingsButtonSettings.setBorder(null);
            settingsButtonSettings.addMouseListener(new MouseListener(){
                @Override
                public void mouseClicked(MouseEvent e)
                {
                    if(e.getSource() == settings_button)
                {
                    if(settingsXsize == 300 && turnOnSettings == 1)
                    {
                        settingsXsize = 0;
                        turnOnSettings = 0; 
                        settings_panel.setVisible(false);
                    }
                    else if(settingsXsize == 0 && turnOnSettings == 0)
                    {
                        settingsXsize = 300;
                        turnOnSettings = 1; 
                        settings_panel.setVisible(true);
                        
                    }
                }
                }

                @Override
                public void mousePressed(MouseEvent e)
                {
                    
                }

                @Override
                public void mouseReleased(MouseEvent e)
                {
                    
                }

                @Override
                public void mouseEntered(MouseEvent e)
                {
                    settingsButtonSettings.setBackground(UIColor);
                }

                @Override
                public void mouseExited(MouseEvent e)
                {
                    if(turnOnSettings == 0 && turnOnDarkMode == 1)
                    settingsButtonSettings.setBackground(new Color(25,25,25));
                    else if(turnOnSettings == 1 && turnOnDarkMode == 1)
                    settingsButtonSettings.setBackground(UIColor);
                    
                    if(turnOnSettings == 0 && turnOnDarkMode == 0)
                    settingsButtonSettings.setBackground(new Color(225,225,225));
                    else if(turnOnSettings == 1 && turnOnDarkMode == 0)
                    settingsButtonSettings.setBackground(UIColor);
                }
            });
        }
    //---------------------------------------------
    
    //---------------------------------------------
        // Settings for TextArea CustomScrollbar
    //---------------------------------------------
    scroll_pane_for_text_area.setVerticalScrollBar(new customScrollbar());
    scroll_pane_for_text_area.setHorizontalScrollBar(new customScrollbar());
    customScrollbar horizontalUI = new customScrollbar();
    horizontalUI.setOrientation(JScrollBar.HORIZONTAL);
    scroll_pane_for_text_area.setHorizontalScrollBar(horizontalUI);
    scroll_pane_for_text_area.setBackground(new Color(25,25,25));
    //---------------------------------------------
    
    //---------------------------------------------
        // Number of line and column status bar label
    //---------------------------------------------
        text_area.addCaretListener(new CaretListener(){
            @Override
            public void caretUpdate(CaretEvent e)
            {
                int positonOfCaret = 0;
                int lineNumber = 0;
                int columnNumber = 0;
                try 
                {
                    positonOfCaret = text_area.getCaretPosition();
                    lineNumber = text_area.getLineOfOffset(positonOfCaret);
                    columnNumber = positonOfCaret - text_area.getLineStartOffset(lineNumber);
                } 
                catch (Exception exCaret) 
                {
                    exCaret.getStackTrace();
                }
                if(text_area.getText().length() == 0)
                {
                    lineNumber = 0;
                    columnNumber = 0;
                }

                line_and_column_label.setText("Line: " + lineNumber + ", Column: " + columnNumber + "        ");
            }
        });
        
        //---------------------------------------------

        //---------------------------------------------
            // text_area key listener settings
        //---------------------------------------------
        text_area.addKeyListener(new KeyAdapter()
            {
                public void keyPressed(KeyEvent e)
                {
                    if(!text_area.equals("") && ifItsAscii(e.getKeyChar()))
                    {
                        fileName_label.setFont(fileName_label.getFont().deriveFont(Font.BOLD | Font.ITALIC));
                        fileName_label.setText(fileName + " *");
                    }
                    flagSaved = 0;
                    menuSave.setEnabled(true);
                }
        //---------------------------------------------
            // boolean ifItsAscii 
            // *to check if this what you type is a 
            // *character or not (for example 'Q', 'A', or
            // *any different typed character or word 
        //---------------------------------------------
        boolean ifItsAscii(char zn)
        {
            for (int i = 0; i < 255; i++) 
            {
                if(zn == i)
                    return true;
            }

            return false;
        }
    //---------------------------------------------
    }); //End of text_area key listener settings 
        //declaration
    //---------------------------------------------
    
    //---------------------------------------------
        // text_area mouse listener settings
    //---------------------------------------------
    text_area.addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e)
            {
                text_area.getHighlighter().removeAllHighlights();
            }

            @Override
            public void mousePressed(MouseEvent e)
            {
                
            }

            @Override
            public void mouseReleased(MouseEvent e)
            {
                
            }

            @Override
            public void mouseEntered(MouseEvent e)
            {
                
            }

            @Override
            public void mouseExited(MouseEvent e)
            {
                
            }
    //---------------------------------------------
    }); //End of text_area mouse listener settings 
        //declaration
    //---------------------------------------------
    
    
    //    private Color UIColor = new Color(90,20,230); // - bright purple 5903590
//    private Color UIColor = new Color(90,230,20); // - brighter light green 5957140
//    private Color UIColor = new Color(20,90,230); // - bright blue
//    private Color UIColor = new Color(20,230,90); // - bright green
//    private Color UIColor = new Color(230,20,20); // - like bright red
//    private Color UIColor = new Color(230,90,20); // - bright orange
//    private Color UIColor = new Color(230,20,90); // - bright pink/raspberry
//    private Color UIColor = new Color(230,230,20); //- bright yellow
//    private Color UIColor = new Color(253,220,179); //- like gold
    
    //---------------------------------------------
        //Extra Settings for Color Buttons
    //---------------------------------------------
        JButton [] settingsColorButtons = {color_button_bright_purple,color_button_brighter_light_green,color_button_bright_blue
        ,color_button_like_bright_red,color_button_bright_orange,color_button_bright_raspberry,color_button_bright_yellow
        ,color_button_like_royal_gold};
            
        for(JButton ColorButtonsSettings : settingsColorButtons)
        {
            ColorButtonsSettings.setUI(new BasicButtonUI());
            ColorButtonsSettings.setBorder(null);
            ColorButtonsSettings.addMouseListener(new MouseListener(){
                @Override
                public void mouseClicked(MouseEvent e)
                {
                    if (e.getSource() == color_button_bright_purple)
                    {
                        settings ColorsConfig = new settings();
                        ColorsConfig.loadSettingsFromFile();
                        
                        UIColor = new Color(90,20,230);
                        
                        text_area.setSelectionColor(UIColor);
                        
                        ColorsConfig.saveSettingsToFile("UIColor", "5903590");
                        ColorsConfig.loadSettingsFromFile();
                        changeUIColor(menuNew, menuOpen, menuSave, menuSaveAs, menuExit, ColorsConfig);
                    }
                    else if (e.getSource() == color_button_brighter_light_green)
                    {
                        settings ColorsConfig = new settings();
                        ColorsConfig.loadSettingsFromFile();
                        
                        UIColor = new Color(90,230,20);
                        
                        text_area.setSelectionColor(UIColor);
                        
                        ColorsConfig.saveSettingsToFile("UIColor", "5957140");
                        ColorsConfig.loadSettingsFromFile();
                        changeUIColor(menuNew, menuOpen, menuSave, menuSaveAs, menuExit, ColorsConfig);
                    }
                    else if (e.getSource() == color_button_bright_blue)
                    {
                        settings ColorsConfig = new settings();
                        ColorsConfig.loadSettingsFromFile();
                        
                        UIColor = new Color(20,90,230);
                        
                        text_area.setSelectionColor(UIColor);
                        
                        ColorsConfig.saveSettingsToFile("UIColor", "1333990");
                        ColorsConfig.loadSettingsFromFile();
                        changeUIColor(menuNew, menuOpen, menuSave, menuSaveAs, menuExit, ColorsConfig);
                    }
                    else if (e.getSource() == color_button_like_bright_red)
                    {
                        settings ColorsConfig = new settings();
                        ColorsConfig.loadSettingsFromFile();
                        
                        UIColor = new Color(230,20,20);
                        
                        text_area.setSelectionColor(UIColor);
                        
                        ColorsConfig.saveSettingsToFile("UIColor", "15078420");
                        ColorsConfig.loadSettingsFromFile();
                        changeUIColor(menuNew, menuOpen, menuSave, menuSaveAs, menuExit, ColorsConfig);
                    }
                    else if (e.getSource() == color_button_bright_orange)
                    {
                        settings ColorsConfig = new settings();
                        ColorsConfig.loadSettingsFromFile();
                        
                        UIColor = new Color(230,90,20);
                        
                        text_area.setSelectionColor(UIColor);
                        
                        ColorsConfig.saveSettingsToFile("UIColor", "15096340");
                        ColorsConfig.loadSettingsFromFile();
                        changeUIColor(menuNew, menuOpen, menuSave, menuSaveAs, menuExit, ColorsConfig);
                    }
                    else if (e.getSource() == color_button_bright_raspberry)
                    {
                        settings ColorsConfig = new settings();
                        ColorsConfig.loadSettingsFromFile();
                        
                        UIColor = new Color(230,20,90);
                        
                        text_area.setSelectionColor(UIColor);
                        
                        ColorsConfig.saveSettingsToFile("UIColor", "15078490");
                        ColorsConfig.loadSettingsFromFile();
                        changeUIColor(menuNew, menuOpen, menuSave, menuSaveAs, menuExit, ColorsConfig);
                    }
                    else if (e.getSource() == color_button_bright_yellow)
                    {
                        settings ColorsConfig = new settings();
                        ColorsConfig.loadSettingsFromFile();
                        
                        UIColor = new Color(230,230,20);
                        
                        text_area.setSelectionColor(UIColor);
                        
                        ColorsConfig.saveSettingsToFile("UIColor", "15132180");
                        
                        ColorsConfig.loadSettingsFromFile();
                        changeUIColor(menuNew, menuOpen, menuSave, menuSaveAs, menuExit, ColorsConfig);
                    }
                    else if (e.getSource() == color_button_like_royal_gold)
                    {
                        settings ColorsConfig = new settings();
                        ColorsConfig.loadSettingsFromFile();
                        
                        UIColor = new Color(253,220,179);
                        
                        text_area.setSelectionColor(UIColor);
                        
                        DarkModeColor = ColorsConfig.getDarkModeColor();
                        dark_mode_button_ON_OFF.setBackground(DarkModeColor);
                        
                        ColorsConfig.saveSettingsToFile("UIColor", "16637107");
                        ColorsConfig.saveSettingsToFile("DarkModeColor", "14803425");
                        ColorsConfig.loadSettingsFromFile();
                        changeUIColor(menuNew, menuOpen, menuSave, menuSaveAs, menuExit, ColorsConfig);
                    }
                }

                @Override
                public void mousePressed(MouseEvent e)
                {
                    
                }

                @Override
                public void mouseReleased(MouseEvent e)
                {
                    
                }

                @Override
                public void mouseEntered(MouseEvent e)
                {
                    
                }

                @Override
                public void mouseExited(MouseEvent e)
                {
                    
                }
            });
        }
    //---------------------------------------------
    
    //---------------------------------------------
        //Extra Settings for Color Buttons
    //---------------------------------------------
        JToggleButton [] DarkModeSettingsButton = {dark_mode_button_ON_OFF};
            
        for(JToggleButton DarkModeSettings : DarkModeSettingsButton)
        {
            DarkModeSettings.setUI(new BasicToggleButtonUI());
            DarkModeSettings.setBorder(new LineBorder(new Color(102,102,102), 1));
            DarkModeSettings.addMouseListener(new MouseListener(){
                @Override
                public void mouseClicked(MouseEvent e)
                {
                    if (e.getSource() == dark_mode_button_ON_OFF)
                    {
                        if(turnOnDarkMode == 0)
                        {    
                            dark_mode_button_ON_OFF.setText("ON");
                            turnOnDarkMode = 1;
                            dark_mode_button_ON_OFF.setBackground(UIColor);
                            
                            settings DarkModeConfig = new settings();
                            DarkModeConfig.loadSettingsFromFile();

                            DarkModeConfig.saveSettingsToFile("turnOnDarkMode", "1");
                            DarkModeConfig.saveSettingsToFile("DarkModeColor", "1644825");
                            DarkModeConfig.loadSettingsFromFile();
                            DarkModeColor = DarkModeConfig.getDarkModeColor();
                            darkModeON_OFF_system_settings(menuFile, menuNew, menuOpen, menuSave, menuSaveAs, menuExit, DarkModeConfig);
                        }
                        else if(turnOnDarkMode == 1)
                        {
                            dark_mode_button_ON_OFF.setText("OFF");
                            turnOnDarkMode = 0;
                            dark_mode_button_ON_OFF.setBackground(new Color(78,80,82));
                            
                            settings DarkModeConfig = new settings();
                            DarkModeConfig.loadSettingsFromFile();
                            
                            DarkModeConfig.saveSettingsToFile("turnOnDarkMode", "0");
                            DarkModeConfig.saveSettingsToFile("DarkModeColor", "14803425");
                            DarkModeConfig.loadSettingsFromFile();
                            DarkModeColor = DarkModeConfig.getDarkModeColor();
                            darkModeON_OFF_system_settings(menuFile, menuNew, menuOpen, menuSave, menuSaveAs, menuExit, DarkModeConfig);
                        }
                    }
                }
                @Override
                public void mousePressed(MouseEvent e)
                {
                }
                @Override
                public void mouseReleased(MouseEvent e)
                {
                }
                @Override
                public void mouseEntered(MouseEvent e)
                {
                }
                @Override
                public void mouseExited(MouseEvent e)
                {
                }
            });
        }
    //---------------------------------------------
    
    //---------------------------------------------
        // font_name settings
    //---------------------------------------------
    font_name_combo_box.addItemListener(new ItemListener(){
            @Override
            public void itemStateChanged(ItemEvent e)
            {
                text_area.setFont(new Font(font_name_combo_box.getSelectedItem().toString(), text_area.getFont().getStyle(), text_area.getFont().getSize()));
                font_name_combo_box.setFont(new Font(font_name_combo_box.getSelectedItem().toString(), font_name_combo_box.getFont().getStyle(), font_name_combo_box.getFont().getSize()));
                settings FontSettings = new settings();
                FontSettings.saveSettingsToFile("fontName", "" + font_name_combo_box.getSelectedItem().toString());
                FontSettings.saveSettingsToFile("fontName_index", "" + font_name_combo_box.getSelectedIndex());
            }
        });
    //---------------------------------------------
    
    //---------------------------------------------
        // font_style settings
    //---------------------------------------------
    font_style_combo_box.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e)
            {
                settings FontSettings = new settings();
                FontSettings.loadSettingsFromFile();
        
                if(font_style_combo_box.getSelectedIndex() == 0)
                {
                    text_area.setFont(new java.awt.Font(text_area.getFont().getName(), Font.PLAIN, text_area.getFont().getSize()));
                    FontSettings.saveSettingsToFile("fontStyle", "0");
                    FontSettings.loadSettingsFromFile();
                }
                
                if(font_style_combo_box.getSelectedIndex() == 1)
                {
                    text_area.setFont(new java.awt.Font(text_area.getFont().getName(), Font.ITALIC, text_area.getFont().getSize()));
                    FontSettings.saveSettingsToFile("fontStyle", "1");
                    FontSettings.loadSettingsFromFile();
                }
                
                if(font_style_combo_box.getSelectedIndex() == 2)
                {
                    text_area.setFont(new java.awt.Font(text_area.getFont().getName(), Font.BOLD, text_area.getFont().getSize()));
                    FontSettings.saveSettingsToFile("fontStyle", "2");
                    FontSettings.loadSettingsFromFile();
                }
                
                if(font_style_combo_box.getSelectedIndex() == 3)
                {
                    text_area.setFont(new java.awt.Font(text_area.getFont().getName(), Font.BOLD | Font.ITALIC, text_area.getFont().getSize()));
                    FontSettings.saveSettingsToFile("fontStyle", "3");
                    FontSettings.loadSettingsFromFile();
                }
            }
        });
    
    //---------------------------------------------
    
    //---------------------------------------------
        // font_size settings
    //---------------------------------------------
    font_size_combo_box.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e)
            {
                settings FontSettings = new settings();
                FontSettings.loadSettingsFromFile();
        
                if(font_size_combo_box.getSelectedIndex() == 0)
                {
                    text_area.setFont(new java.awt.Font(text_area.getFont().getName(), text_area.getFont().getStyle(), 8));
                    FontSettings.saveSettingsToFile("fontSize", "8");
                    FontSettings.saveSettingsToFile("fontSize_index", "0");
                    FontSettings.loadSettingsFromFile();
                }
                
                if(font_size_combo_box.getSelectedIndex() == 1)
                {
                    text_area.setFont(new java.awt.Font(text_area.getFont().getName(), text_area.getFont().getStyle(), 9));
                    FontSettings.saveSettingsToFile("fontSize", "9");
                    FontSettings.saveSettingsToFile("fontSize_index", "1");
                    FontSettings.loadSettingsFromFile();
                }
                
                if(font_size_combo_box.getSelectedIndex() == 2)
                {
                    text_area.setFont(new java.awt.Font(text_area.getFont().getName(), text_area.getFont().getStyle(), 10));
                    FontSettings.saveSettingsToFile("fontSize", "10");
                    FontSettings.saveSettingsToFile("fontSize_index", "2");
                    FontSettings.loadSettingsFromFile();
                }
                
                if(font_size_combo_box.getSelectedIndex() == 3)
                {
                    text_area.setFont(new java.awt.Font(text_area.getFont().getName(), text_area.getFont().getStyle(), 11));
                    FontSettings.saveSettingsToFile("fontSize", "11");
                    FontSettings.saveSettingsToFile("fontSize_index", "3");
                    FontSettings.loadSettingsFromFile();
                }
                
                if(font_size_combo_box.getSelectedIndex() == 4)
                {
                    text_area.setFont(new java.awt.Font(text_area.getFont().getName(), text_area.getFont().getStyle(), 12));
                    FontSettings.saveSettingsToFile("fontSize", "12");
                    FontSettings.saveSettingsToFile("fontSize_index", "4");
                    FontSettings.loadSettingsFromFile();
                }
                
                if(font_size_combo_box.getSelectedIndex() == 5)
                {
                    text_area.setFont(new java.awt.Font(text_area.getFont().getName(), text_area.getFont().getStyle(), 14));
                    FontSettings.saveSettingsToFile("fontSize", "14");
                    FontSettings.saveSettingsToFile("fontSize_index", "5");
                    FontSettings.loadSettingsFromFile();
                }
                
                if(font_size_combo_box.getSelectedIndex() == 6)
                {
                    text_area.setFont(new java.awt.Font(text_area.getFont().getName(), text_area.getFont().getStyle(), 16));
                    FontSettings.saveSettingsToFile("fontSize", "16");
                    FontSettings.saveSettingsToFile("fontSize_index", "6");
                    FontSettings.loadSettingsFromFile();
                }
                
                if(font_size_combo_box.getSelectedIndex() == 7)
                {
                    text_area.setFont(new java.awt.Font(text_area.getFont().getName(), text_area.getFont().getStyle(), 18));
                    FontSettings.saveSettingsToFile("fontSize", "18");
                    FontSettings.saveSettingsToFile("fontSize_index", "7");
                    FontSettings.loadSettingsFromFile();
                }
                
                if(font_size_combo_box.getSelectedIndex() == 8)
                {
                    text_area.setFont(new java.awt.Font(text_area.getFont().getName(), text_area.getFont().getStyle(), 20));
                    FontSettings.saveSettingsToFile("fontSize", "20");
                    FontSettings.saveSettingsToFile("fontSize_index", "8");
                    FontSettings.loadSettingsFromFile();
                }
                
                if(font_size_combo_box.getSelectedIndex() == 9)
                {
                    text_area.setFont(new java.awt.Font(text_area.getFont().getName(), text_area.getFont().getStyle(), 22));
                    FontSettings.saveSettingsToFile("fontSize", "22");
                    FontSettings.saveSettingsToFile("fontSize_index", "9");
                    FontSettings.loadSettingsFromFile();
                }
                
                if(font_size_combo_box.getSelectedIndex() == 10)
                {
                    text_area.setFont(new java.awt.Font(text_area.getFont().getName(), text_area.getFont().getStyle(), 24));
                    FontSettings.saveSettingsToFile("fontSize", "24");
                    FontSettings.saveSettingsToFile("fontSize_index", "10");
                    FontSettings.loadSettingsFromFile();
                }
                
                if(font_size_combo_box.getSelectedIndex() == 11)
                {
                    text_area.setFont(new java.awt.Font(text_area.getFont().getName(), text_area.getFont().getStyle(), 26));
                    FontSettings.saveSettingsToFile("fontSize", "26");
                    FontSettings.saveSettingsToFile("fontSize_index", "11");
                    FontSettings.loadSettingsFromFile();
                }
                
                if(font_size_combo_box.getSelectedIndex() == 12)
                {
                    text_area.setFont(new java.awt.Font(text_area.getFont().getName(), text_area.getFont().getStyle(), 28));
                    FontSettings.saveSettingsToFile("fontSize", "28");
                    FontSettings.saveSettingsToFile("fontSize_index", "12");
                    FontSettings.loadSettingsFromFile();
                }
                
                if(font_size_combo_box.getSelectedIndex() == 13)
                {
                    text_area.setFont(new java.awt.Font(text_area.getFont().getName(), text_area.getFont().getStyle(), 36));
                    FontSettings.saveSettingsToFile("fontSize", "36");
                    FontSettings.saveSettingsToFile("fontSize_index", "13");
                    FontSettings.loadSettingsFromFile();
                }
                
                if(font_size_combo_box.getSelectedIndex() == 14)
                {
                    text_area.setFont(new java.awt.Font(text_area.getFont().getName(), text_area.getFont().getStyle(), 48));
                    FontSettings.saveSettingsToFile("fontSize", "48");
                    FontSettings.saveSettingsToFile("fontSize_index", "14");
                    FontSettings.loadSettingsFromFile();
                }
                
                if(font_size_combo_box.getSelectedIndex() == 15)
                {
                    text_area.setFont(new java.awt.Font(text_area.getFont().getName(), text_area.getFont().getStyle(), 72));
                    FontSettings.saveSettingsToFile("fontSize", "72");
                    FontSettings.saveSettingsToFile("fontSize_index", "15");
                    FontSettings.loadSettingsFromFile();
                }
            }
        });
    
    //---------------------------------------------
    
    //---------------------------------------------
        // Reading UI color settings from a system_settings.properties file
    //---------------------------------------------
    settings ColorsConfig = new settings();
    ColorsConfig.loadSettingsFromFile();
    UIColor = ColorsConfig.getUIColor();
    changeUIColor(menuNew,menuOpen,menuSave,menuSaveAs,menuExit,ColorsConfig);
    text_area.setSelectionColor(UIColor);
    
    settings DarkModeConfig = new settings();
    DarkModeConfig.loadSettingsFromFile();
    turnOnDarkMode = DarkModeConfig.getTurnOnDarkMode();
    darkModeON_OFF_system_settings(menuFile, menuNew, menuOpen, menuSave, menuSaveAs, menuExit, DarkModeConfig);
    
    settings FontSettings = new settings();
    FontSettings.loadSettingsFromFile();
    fontStyle = FontSettings.getfontStyle();
    fontSize = FontSettings.getfontSize();
    fontSize_index = FontSettings.getfontSize_index();
    fontName = FontSettings.getfontName();
    fontName_index = FontSettings.getfontName_index();
    text_area.setFont(new java.awt.Font(fontName, fontStyle, fontSize));
    font_style_combo_box.setSelectedIndex(fontStyle);
    font_size_combo_box.setSelectedIndex(fontSize_index);
    font_name_combo_box.setSelectedIndex(fontName_index);
    //---------------------------------------------
    }
    
    private void initComponents()
    {
        //---------------------------------------------
            // Main panel that contains the others settings
        //---------------------------------------------
        setUndecorated(true);
        setBackground(new java.awt.Color(25, 25, 25));
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icon/notes.png")));
        setPreferredSize(new java.awt.Dimension(945, 550));
        setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
        setMinimumSize(new java.awt.Dimension(945, 550));
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getRootPane().setBorder(new LineBorder(new Color(253,220,179)));
        //---------------------------------------------
            // End of Main panel settings
        //---------------------------------------------
        
        //---------------------------------------------
            // Setting an aviable fonts list to a combobox
        //---------------------------------------------
        GraphicsEnvironment gEFonts = GraphicsEnvironment.getLocalGraphicsEnvironment();
        String fontName[] = gEFonts.getAvailableFontFamilyNames();
        
        font_name_combo_box = new customCombobox<>(fontName);
        
        //---------------------------------------------
        
        //---------------------------------------------
            // Custom UI initComponents
        //---------------------------------------------
        customTitlebar = new javax.swing.JPanel();
        windowsMinResExit_panel = new javax.swing.JPanel();
        minimalizeWindowButton = new javax.swing.JButton();
        resizeWindowButton = new javax.swing.JButton();
        closeWindowButton = new javax.swing.JButton();
        aplicationTitle_panel = new javax.swing.JPanel();
        menu_button = new javax.swing.JButton();
        fileName_panel = new javax.swing.JPanel();
        fileName_label = new javax.swing.JLabel();
        searchButton = new javax.swing.JPanel();
        search_button_panel = new javax.swing.JPanel();
        search_button = new javax.swing.JButton();
        settings_button = new javax.swing.JButton();
        background_panel_what_holds_all = new javax.swing.JPanel();
        searchDrawerMenuBar = new javax.swing.JPanel();
        searchDrawerMenuBar_panel = new javax.swing.JPanel();
        replace_all_text_field_button = new javax.swing.JButton();
        replace_text_field_button = new javax.swing.JButton();
        replace_text_field = new javax.swing.JTextField();
        find_text_field_button = new javax.swing.JButton();
        search_text_field = new javax.swing.JTextField();
        lineWhatColorYouCanCustom = new javax.swing.JPanel();
        lineUnderDrawerUIColor = new javax.swing.JPanel();
        text_area_panel = new javax.swing.JPanel();
        scroll_pane_for_text_area = new javax.swing.JScrollPane();
        text_area = new javax.swing.JTextArea();
        settings_panel = new javax.swing.JPanel();
        settings_tabbed_pane = new S.G.notes.UI.Scripts.customTabbedPane();
        tab_1_panel = new javax.swing.JPanel();
        font_name_panel = new javax.swing.JPanel();
        font_name_description_panel = new javax.swing.JPanel();
        font_name_title = new javax.swing.JLabel();
        font_name_combo_box = new S.G.notes.UI.Scripts.customCombobox(fontName);
        font_name_combo_box.setRenderer(new ComboBoxFontGetter());
        font_style_panel = new javax.swing.JPanel();
        font_style_description_panel = new javax.swing.JPanel();
        font_style_title = new javax.swing.JLabel();
        font_style_combo_box = new S.G.notes.UI.Scripts.customCombobox<>();
        font_size_panel = new javax.swing.JPanel();
        font_size_description_panel = new javax.swing.JPanel();
        font_size_title = new javax.swing.JLabel();
        font_size_combo_box = new S.G.notes.UI.Scripts.customCombobox<>();
        tab_2_panel = new javax.swing.JPanel();
        dark_mode_panel = new javax.swing.JPanel();
        dark_mode_description_panel = new javax.swing.JPanel();
        dark_mode_title = new javax.swing.JLabel();
        dark_mode_description_1 = new javax.swing.JLabel();
        dark_mode_description_2 = new javax.swing.JLabel();
        dark_mode_button_panel = new javax.swing.JPanel();
        dark_mode_button_ON_OFF = new javax.swing.JToggleButton();
        UI_color_panel = new javax.swing.JPanel();
        UI_color_description_panel = new javax.swing.JPanel();
        UI_color_title = new javax.swing.JLabel();
        UI_color_description_1 = new javax.swing.JLabel();
        color_button_bright_purple = new S.G.notes.UI.Scripts.RoundedButton();
        color_button_brighter_light_green = new S.G.notes.UI.Scripts.RoundedButton();
        color_button_bright_blue = new S.G.notes.UI.Scripts.RoundedButton();
        color_button_like_bright_red = new S.G.notes.UI.Scripts.RoundedButton();
        color_button_bright_orange = new S.G.notes.UI.Scripts.RoundedButton();
        color_button_bright_raspberry = new S.G.notes.UI.Scripts.RoundedButton();
        color_button_bright_yellow = new S.G.notes.UI.Scripts.RoundedButton();
        color_button_like_royal_gold = new S.G.notes.UI.Scripts.RoundedButton();
        tab_3_panel = new javax.swing.JPanel();
        about_panel = new javax.swing.JPanel();
        about_logo_panel = new javax.swing.JPanel();
        about_logo_icon = new javax.swing.JLabel();
        about_description_panel = new javax.swing.JPanel();
        about_title = new javax.swing.JLabel();
        about_version = new javax.swing.JLabel();
        about_author = new javax.swing.JLabel();
        status_file_panel = new javax.swing.JPanel();
        statusOfFile = new javax.swing.JPanel();
        line_and_column_label = new javax.swing.JLabel();
        file_path = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(25, 25, 25));
        setMinimumSize(new java.awt.Dimension(923, 261));

        customTitlebar.setMaximumSize(new java.awt.Dimension(32767, 30));
        customTitlebar.setMinimumSize(new java.awt.Dimension(922, 30));
        customTitlebar.setPreferredSize(new java.awt.Dimension(922, 30));
        customTitlebar.addMouseMotionListener(new java.awt.event.MouseMotionAdapter()
        {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                customTitlebarMouseDragged(evt);
            }
        });
        customTitlebar.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                customTitlebarMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt)
            {
                customTitlebarMousePressed(evt);
            }
        });
        customTitlebar.setLayout(new java.awt.BorderLayout());

        windowsMinResExit_panel.setBackground(new java.awt.Color(25, 25, 25));
        windowsMinResExit_panel.setMaximumSize(new java.awt.Dimension(90, 30));
        windowsMinResExit_panel.setMinimumSize(new java.awt.Dimension(90, 30));

        minimalizeWindowButton.setBackground(new java.awt.Color(25, 25, 25));
        minimalizeWindowButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/minimalizeWindowBar14x14.png"))); // NOI18N
        minimalizeWindowButton.setMaximumSize(new java.awt.Dimension(30, 30));
        minimalizeWindowButton.setMinimumSize(new java.awt.Dimension(30, 30));
        minimalizeWindowButton.setPreferredSize(new java.awt.Dimension(30, 30));

        resizeWindowButton.setBackground(new java.awt.Color(25, 25, 25));
        resizeWindowButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/resizeWindowBar14x14.png"))); // NOI18N
        resizeWindowButton.setMaximumSize(new java.awt.Dimension(30, 30));
        resizeWindowButton.setMinimumSize(new java.awt.Dimension(30, 30));
        resizeWindowButton.setPreferredSize(new java.awt.Dimension(30, 30));

        closeWindowButton.setBackground(new java.awt.Color(25, 25, 25));
        closeWindowButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/closeWindowBar14x14.png"))); // NOI18N
        closeWindowButton.setMaximumSize(new java.awt.Dimension(30, 30));
        closeWindowButton.setMinimumSize(new java.awt.Dimension(30, 30));
        closeWindowButton.setPreferredSize(new java.awt.Dimension(30, 30));

        javax.swing.GroupLayout windowsMinResExit_panelLayout = new javax.swing.GroupLayout(windowsMinResExit_panel);
        windowsMinResExit_panel.setLayout(windowsMinResExit_panelLayout);
        windowsMinResExit_panelLayout.setHorizontalGroup(
            windowsMinResExit_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(windowsMinResExit_panelLayout.createSequentialGroup()
                .addComponent(minimalizeWindowButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(resizeWindowButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(closeWindowButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        windowsMinResExit_panelLayout.setVerticalGroup(
            windowsMinResExit_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(windowsMinResExit_panelLayout.createSequentialGroup()
                .addGroup(windowsMinResExit_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(minimalizeWindowButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(closeWindowButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(resizeWindowButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        customTitlebar.add(windowsMinResExit_panel, java.awt.BorderLayout.LINE_END);

        aplicationTitle_panel.setBackground(new java.awt.Color(25, 25, 25));
        aplicationTitle_panel.setMaximumSize(new java.awt.Dimension(32767, 30));
        aplicationTitle_panel.setMinimumSize(new java.awt.Dimension(200, 30));

        menu_button.setBackground(new java.awt.Color(25, 25, 25));
        menu_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/notesMini.png"))); // NOI18N
        menu_button.setMaximumSize(new java.awt.Dimension(30, 30));
        menu_button.setMinimumSize(new java.awt.Dimension(30, 30));
        menu_button.setPreferredSize(new java.awt.Dimension(30, 30));

        javax.swing.GroupLayout aplicationTitle_panelLayout = new javax.swing.GroupLayout(aplicationTitle_panel);
        aplicationTitle_panel.setLayout(aplicationTitle_panelLayout);
        aplicationTitle_panelLayout.setHorizontalGroup(
            aplicationTitle_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(aplicationTitle_panelLayout.createSequentialGroup()
                .addComponent(menu_button, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 170, Short.MAX_VALUE))
        );
        aplicationTitle_panelLayout.setVerticalGroup(
            aplicationTitle_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, aplicationTitle_panelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(menu_button, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        customTitlebar.add(aplicationTitle_panel, java.awt.BorderLayout.LINE_START);

        fileName_panel.setBackground(new java.awt.Color(25, 25, 25));

        fileName_label.setBackground(new java.awt.Color(25, 25, 25));
        fileName_label.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        fileName_label.setForeground(new java.awt.Color(198, 197, 193));
        fileName_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fileName_label.setText("New File");
        fileName_label.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        searchButton.setBackground(new java.awt.Color(65, 65, 77));
        searchButton.setMaximumSize(new java.awt.Dimension(115, 30));
        searchButton.setMinimumSize(new java.awt.Dimension(115, 30));
        searchButton.setPreferredSize(new java.awt.Dimension(115, 30));
        searchButton.setLayout(new java.awt.BorderLayout());

        search_button_panel.setBackground(new java.awt.Color(25, 25, 25));
        search_button_panel.setMaximumSize(new java.awt.Dimension(30, 30));
        search_button_panel.setMinimumSize(new java.awt.Dimension(30, 30));
        search_button_panel.setPreferredSize(new java.awt.Dimension(30, 30));

        search_button.setBackground(new java.awt.Color(25, 25, 25));
        search_button.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        search_button.setForeground(new java.awt.Color(234, 234, 227));
        search_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/search_icon.png"))); // NOI18N
        search_button.setMaximumSize(new java.awt.Dimension(30, 30));
        search_button.setMinimumSize(new java.awt.Dimension(30, 30));
        search_button.setPreferredSize(new java.awt.Dimension(30, 30));

        settings_button.setBackground(new java.awt.Color(25, 25, 25));
        settings_button.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        settings_button.setForeground(new java.awt.Color(234, 234, 227));
        settings_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/settingsIcon14x14.png"))); // NOI18N
        settings_button.setMaximumSize(new java.awt.Dimension(30, 30));
        settings_button.setMinimumSize(new java.awt.Dimension(30, 30));
        settings_button.setPreferredSize(new java.awt.Dimension(30, 30));

        javax.swing.GroupLayout search_button_panelLayout = new javax.swing.GroupLayout(search_button_panel);
        search_button_panel.setLayout(search_button_panelLayout);
        search_button_panelLayout.setHorizontalGroup(
            search_button_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, search_button_panelLayout.createSequentialGroup()
                .addContainerGap(59, Short.MAX_VALUE)
                .addComponent(search_button, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(settings_button, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        search_button_panelLayout.setVerticalGroup(
            search_button_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, search_button_panelLayout.createSequentialGroup()
                .addGroup(search_button_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(settings_button, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(search_button, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );

        searchButton.add(search_button_panel, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout fileName_panelLayout = new javax.swing.GroupLayout(fileName_panel);
        fileName_panel.setLayout(fileName_panelLayout);
        fileName_panelLayout.setHorizontalGroup(
            fileName_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fileName_panelLayout.createSequentialGroup()
                .addContainerGap(225, Short.MAX_VALUE)
                .addComponent(fileName_label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 231, Short.MAX_VALUE)
                .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        fileName_panelLayout.setVerticalGroup(
            fileName_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fileName_panelLayout.createSequentialGroup()
                .addComponent(fileName_label)
                .addGap(3, 3, 3))
            .addComponent(searchButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        customTitlebar.add(fileName_panel, java.awt.BorderLayout.CENTER);

        background_panel_what_holds_all.setBackground(new java.awt.Color(25, 25, 25));
        background_panel_what_holds_all.setMinimumSize(new java.awt.Dimension(922, 472));
        background_panel_what_holds_all.setPreferredSize(new java.awt.Dimension(922, 472));

        searchDrawerMenuBar.setBackground(new java.awt.Color(65, 65, 77));
        searchDrawerMenuBar.setMinimumSize(new java.awt.Dimension(911, 30));
        searchDrawerMenuBar.setPreferredSize(new java.awt.Dimension(911, 30));
        searchDrawerMenuBar.setLayout(new java.awt.BorderLayout());

        searchDrawerMenuBar_panel.setBackground(new java.awt.Color(35, 35, 35));
        searchDrawerMenuBar_panel.setPreferredSize(new java.awt.Dimension(911, 30));

        replace_all_text_field_button.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        replace_all_text_field_button.setText("Replace all");
        replace_all_text_field_button.setMaximumSize(new java.awt.Dimension(150, 30));
        replace_all_text_field_button.setMinimumSize(new java.awt.Dimension(150, 30));
        replace_all_text_field_button.setPreferredSize(new java.awt.Dimension(150, 30));

        replace_text_field_button.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        replace_text_field_button.setText("Find and replace");
        replace_text_field_button.setMaximumSize(new java.awt.Dimension(125, 30));
        replace_text_field_button.setMinimumSize(new java.awt.Dimension(125, 30));
        replace_text_field_button.setPreferredSize(new java.awt.Dimension(125, 30));

        replace_text_field.setBackground(new java.awt.Color(54, 54, 66));
        replace_text_field.setFont(new java.awt.Font("Monospaced", 2, 12)); // NOI18N
        replace_text_field.setForeground(new java.awt.Color(102, 102, 102));
        replace_text_field.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        replace_text_field.setText("Replace");
        replace_text_field.setToolTipText(null);
        replace_text_field.setAlignmentX(0.0F);
        replace_text_field.setAlignmentY(0.0F);
        replace_text_field.setBorder(null);
        replace_text_field.setCaretColor(new java.awt.Color(253, 220, 179));
        replace_text_field.setMargin(new java.awt.Insets(0, 6, 0, 6));
        replace_text_field.setMaximumSize(new java.awt.Dimension(2147483647, 30));
        replace_text_field.setMinimumSize(new java.awt.Dimension(172, 30));
        replace_text_field.setPreferredSize(new java.awt.Dimension(172, 30));
        replace_text_field.addFocusListener(new java.awt.event.FocusAdapter()
        {
            public void focusGained(java.awt.event.FocusEvent evt)
            {
                replace_text_fieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt)
            {
                replace_text_fieldFocusLost(evt);
            }
        });

        find_text_field_button.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        find_text_field_button.setText("Find");
        find_text_field_button.setMaximumSize(new java.awt.Dimension(75, 30));
        find_text_field_button.setMinimumSize(new java.awt.Dimension(75, 30));
        find_text_field_button.setPreferredSize(new java.awt.Dimension(75, 30));

        search_text_field.setBackground(new java.awt.Color(54, 54, 66));
        search_text_field.setFont(new java.awt.Font("Monospaced", 2, 12)); // NOI18N
        search_text_field.setForeground(new java.awt.Color(102, 102, 102));
        search_text_field.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        search_text_field.setText("Find");
        search_text_field.setToolTipText(null);
        search_text_field.setAlignmentX(0.0F);
        search_text_field.setAlignmentY(0.0F);
        search_text_field.setBorder(null);
        search_text_field.setCaretColor(new java.awt.Color(253, 220, 179));
        search_text_field.setMargin(new java.awt.Insets(0, 6, 0, 6));
        search_text_field.setMaximumSize(new java.awt.Dimension(2147483647, 30));
        search_text_field.setMinimumSize(new java.awt.Dimension(172, 30));
        search_text_field.setPreferredSize(new java.awt.Dimension(172, 30));
        search_text_field.addFocusListener(new java.awt.event.FocusAdapter()
        {
            public void focusGained(java.awt.event.FocusEvent evt)
            {
                search_text_fieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt)
            {
                search_text_fieldFocusLost(evt);
            }
        });

        javax.swing.GroupLayout searchDrawerMenuBar_panelLayout = new javax.swing.GroupLayout(searchDrawerMenuBar_panel);
        searchDrawerMenuBar_panel.setLayout(searchDrawerMenuBar_panelLayout);
        searchDrawerMenuBar_panelLayout.setHorizontalGroup(
            searchDrawerMenuBar_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchDrawerMenuBar_panelLayout.createSequentialGroup()
                .addContainerGap(86, Short.MAX_VALUE)
                .addComponent(search_text_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(find_text_field_button, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addComponent(replace_text_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(replace_text_field_button, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(replace_all_text_field_button, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(86, Short.MAX_VALUE))
        );
        searchDrawerMenuBar_panelLayout.setVerticalGroup(
            searchDrawerMenuBar_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchDrawerMenuBar_panelLayout.createSequentialGroup()
                .addGroup(searchDrawerMenuBar_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(searchDrawerMenuBar_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(find_text_field_button, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(replace_text_field_button, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(replace_all_text_field_button, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(searchDrawerMenuBar_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(search_text_field, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(replace_text_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, 0))
        );

        searchDrawerMenuBar.add(searchDrawerMenuBar_panel, java.awt.BorderLayout.CENTER);

        lineWhatColorYouCanCustom.setMaximumSize(new java.awt.Dimension(32767, 1));
        lineWhatColorYouCanCustom.setMinimumSize(new java.awt.Dimension(911, 1));
        lineWhatColorYouCanCustom.setPreferredSize(new java.awt.Dimension(911, 1));
        lineWhatColorYouCanCustom.setLayout(new java.awt.BorderLayout());

        lineUnderDrawerUIColor.setBackground(new java.awt.Color(230, 20, 90));
        lineUnderDrawerUIColor.setMaximumSize(new java.awt.Dimension(32767, 1));
        lineUnderDrawerUIColor.setMinimumSize(new java.awt.Dimension(911, 1));
        lineUnderDrawerUIColor.setPreferredSize(new java.awt.Dimension(911, 1));

        javax.swing.GroupLayout lineUnderDrawerUIColorLayout = new javax.swing.GroupLayout(lineUnderDrawerUIColor);
        lineUnderDrawerUIColor.setLayout(lineUnderDrawerUIColorLayout);
        lineUnderDrawerUIColorLayout.setHorizontalGroup(
            lineUnderDrawerUIColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 912, Short.MAX_VALUE)
        );
        lineUnderDrawerUIColorLayout.setVerticalGroup(
            lineUnderDrawerUIColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );

        lineWhatColorYouCanCustom.add(lineUnderDrawerUIColor, java.awt.BorderLayout.CENTER);

        text_area_panel.setBackground(new java.awt.Color(25, 25, 25));
        text_area_panel.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 5, 2, 5, new java.awt.Color(25, 25, 25)));

        scroll_pane_for_text_area.setBorder(null);

        text_area.setBackground(new java.awt.Color(54, 54, 66));
        text_area.setColumns(20);
        text_area.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        text_area.setForeground(new java.awt.Color(234, 234, 227));
        text_area.setRows(5);
        text_area.setCaretColor(new java.awt.Color(253, 220, 179));
        scroll_pane_for_text_area.setViewportView(text_area);

        settings_panel.setBackground(new java.awt.Color(35, 35, 35));
        settings_panel.setMinimumSize(new java.awt.Dimension(300, 424));
        settings_panel.setPreferredSize(new java.awt.Dimension(300, 424));

        settings_tabbed_pane.setBackground(new java.awt.Color(35, 35, 35));

        tab_1_panel.setBackground(new java.awt.Color(35, 35, 35));
        tab_1_panel.setAlignmentX(0.0F);
        tab_1_panel.setAlignmentY(0.0F);

        font_name_panel.setBackground(new java.awt.Color(35, 35, 35));

        font_name_description_panel.setBackground(new java.awt.Color(35, 35, 35));

        font_name_title.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        font_name_title.setForeground(new java.awt.Color(198, 197, 193));
        font_name_title.setText("Font Name");

        font_name_combo_box.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        font_name_combo_box.setModel(new javax.swing.DefaultComboBoxModel<>(fontName));

        javax.swing.GroupLayout font_name_description_panelLayout = new javax.swing.GroupLayout(font_name_description_panel);
        font_name_description_panel.setLayout(font_name_description_panelLayout);
        font_name_description_panelLayout.setHorizontalGroup(
            font_name_description_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(font_name_description_panelLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(font_name_description_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(font_name_description_panelLayout.createSequentialGroup()
                        .addComponent(font_name_title)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(font_name_combo_box, 0, 153, Short.MAX_VALUE))
                .addContainerGap())
        );
        font_name_description_panelLayout.setVerticalGroup(
            font_name_description_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(font_name_description_panelLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(font_name_title)
                .addGap(2, 2, 2)
                .addComponent(font_name_combo_box, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout font_name_panelLayout = new javax.swing.GroupLayout(font_name_panel);
        font_name_panel.setLayout(font_name_panelLayout);
        font_name_panelLayout.setHorizontalGroup(
            font_name_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(font_name_panelLayout.createSequentialGroup()
                .addComponent(font_name_description_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 130, Short.MAX_VALUE))
        );
        font_name_panelLayout.setVerticalGroup(
            font_name_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(font_name_description_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        font_style_panel.setBackground(new java.awt.Color(35, 35, 35));

        font_style_description_panel.setBackground(new java.awt.Color(35, 35, 35));

        font_style_title.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        font_style_title.setForeground(new java.awt.Color(198, 197, 193));
        font_style_title.setText("Font Style");

        font_style_combo_box.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        font_style_combo_box.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "normal", "italic", "bold", "bold italic" }));

        javax.swing.GroupLayout font_style_description_panelLayout = new javax.swing.GroupLayout(font_style_description_panel);
        font_style_description_panel.setLayout(font_style_description_panelLayout);
        font_style_description_panelLayout.setHorizontalGroup(
            font_style_description_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(font_style_description_panelLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(font_style_description_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(font_style_description_panelLayout.createSequentialGroup()
                        .addComponent(font_style_title)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(font_style_combo_box, 0, 153, Short.MAX_VALUE))
                .addContainerGap())
        );
        font_style_description_panelLayout.setVerticalGroup(
            font_style_description_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(font_style_description_panelLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(font_style_title)
                .addGap(2, 2, 2)
                .addComponent(font_style_combo_box, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout font_style_panelLayout = new javax.swing.GroupLayout(font_style_panel);
        font_style_panel.setLayout(font_style_panelLayout);
        font_style_panelLayout.setHorizontalGroup(
            font_style_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(font_style_panelLayout.createSequentialGroup()
                .addComponent(font_style_description_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 142, Short.MAX_VALUE))
        );
        font_style_panelLayout.setVerticalGroup(
            font_style_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(font_style_description_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        font_size_panel.setBackground(new java.awt.Color(35, 35, 35));

        font_size_description_panel.setBackground(new java.awt.Color(35, 35, 35));

        font_size_title.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        font_size_title.setForeground(new java.awt.Color(198, 197, 193));
        font_size_title.setText("Font Size");

        font_size_combo_box.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        font_size_combo_box.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "8", "9", "10", "11", "12", "14", "16", "18", "20", "22", "24", "26", "28", "36", "48", "72" }));

        javax.swing.GroupLayout font_size_description_panelLayout = new javax.swing.GroupLayout(font_size_description_panel);
        font_size_description_panel.setLayout(font_size_description_panelLayout);
        font_size_description_panelLayout.setHorizontalGroup(
            font_size_description_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(font_size_description_panelLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(font_size_description_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(font_size_description_panelLayout.createSequentialGroup()
                        .addComponent(font_size_title)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(font_size_combo_box, 0, 153, Short.MAX_VALUE))
                .addContainerGap())
        );
        font_size_description_panelLayout.setVerticalGroup(
            font_size_description_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(font_size_description_panelLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(font_size_title)
                .addGap(2, 2, 2)
                .addComponent(font_size_combo_box, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout font_size_panelLayout = new javax.swing.GroupLayout(font_size_panel);
        font_size_panel.setLayout(font_size_panelLayout);
        font_size_panelLayout.setHorizontalGroup(
            font_size_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(font_size_panelLayout.createSequentialGroup()
                .addComponent(font_size_description_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 130, Short.MAX_VALUE))
        );
        font_size_panelLayout.setVerticalGroup(
            font_size_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(font_size_description_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout tab_1_panelLayout = new javax.swing.GroupLayout(tab_1_panel);
        tab_1_panel.setLayout(tab_1_panelLayout);
        tab_1_panelLayout.setHorizontalGroup(
            tab_1_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab_1_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tab_1_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(font_name_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(font_style_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(font_size_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        tab_1_panelLayout.setVerticalGroup(
            tab_1_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab_1_panelLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(font_name_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(font_style_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(font_size_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(387, Short.MAX_VALUE))
        );

        settings_tabbed_pane.addTab("   ", tabFontIcon,tab_1_panel);

        tab_2_panel.setBackground(new java.awt.Color(35, 35, 35));

        dark_mode_panel.setBackground(new java.awt.Color(35, 35, 35));

        dark_mode_description_panel.setBackground(new java.awt.Color(35, 35, 35));

        dark_mode_title.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        dark_mode_title.setForeground(new java.awt.Color(198, 197, 193));
        dark_mode_title.setText("Dark mode");

        dark_mode_description_1.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        dark_mode_description_1.setForeground(new java.awt.Color(127, 127, 127));
        dark_mode_description_1.setText("Turn on to use darker colors for an");

        dark_mode_description_2.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        dark_mode_description_2.setForeground(new java.awt.Color(127, 127, 127));
        dark_mode_description_2.setText("application UI");

        javax.swing.GroupLayout dark_mode_description_panelLayout = new javax.swing.GroupLayout(dark_mode_description_panel);
        dark_mode_description_panel.setLayout(dark_mode_description_panelLayout);
        dark_mode_description_panelLayout.setHorizontalGroup(
            dark_mode_description_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dark_mode_description_panelLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(dark_mode_description_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dark_mode_description_2)
                    .addComponent(dark_mode_description_1)
                    .addComponent(dark_mode_title))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        dark_mode_description_panelLayout.setVerticalGroup(
            dark_mode_description_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dark_mode_description_panelLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(dark_mode_title)
                .addGap(2, 2, 2)
                .addComponent(dark_mode_description_1)
                .addGap(1, 1, 1)
                .addComponent(dark_mode_description_2))
        );

        dark_mode_button_panel.setBackground(new java.awt.Color(35, 35, 35));

        dark_mode_button_ON_OFF.setText("ON / OFF");
        dark_mode_button_ON_OFF.setMaximumSize(new java.awt.Dimension(90, 25));
        dark_mode_button_ON_OFF.setMinimumSize(new java.awt.Dimension(90, 25));
        dark_mode_button_ON_OFF.setPreferredSize(new java.awt.Dimension(90, 25));

        javax.swing.GroupLayout dark_mode_button_panelLayout = new javax.swing.GroupLayout(dark_mode_button_panel);
        dark_mode_button_panel.setLayout(dark_mode_button_panelLayout);
        dark_mode_button_panelLayout.setHorizontalGroup(
            dark_mode_button_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dark_mode_button_panelLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(dark_mode_button_ON_OFF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );
        dark_mode_button_panelLayout.setVerticalGroup(
            dark_mode_button_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dark_mode_button_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dark_mode_button_ON_OFF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout dark_mode_panelLayout = new javax.swing.GroupLayout(dark_mode_panel);
        dark_mode_panel.setLayout(dark_mode_panelLayout);
        dark_mode_panelLayout.setHorizontalGroup(
            dark_mode_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dark_mode_panelLayout.createSequentialGroup()
                .addComponent(dark_mode_description_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(dark_mode_button_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );
        dark_mode_panelLayout.setVerticalGroup(
            dark_mode_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dark_mode_description_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(dark_mode_panelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(dark_mode_button_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        UI_color_panel.setBackground(new java.awt.Color(35, 35, 35));

        UI_color_description_panel.setBackground(new java.awt.Color(35, 35, 35));

        UI_color_title.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        UI_color_title.setForeground(new java.awt.Color(198, 197, 193));
        UI_color_title.setText("UI color");

        UI_color_description_1.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        UI_color_description_1.setForeground(new java.awt.Color(127, 127, 127));
        UI_color_description_1.setText("Click a color to change UI color");

        color_button_bright_purple.setBackground(new java.awt.Color(90, 20, 230));
        color_button_bright_purple.setMaximumSize(new java.awt.Dimension(20, 20));
        color_button_bright_purple.setMinimumSize(new java.awt.Dimension(20, 20));
        color_button_bright_purple.setPreferredSize(new java.awt.Dimension(20, 20));
        color_button_bright_purple.setRoundedHeight(10);
        color_button_bright_purple.setRoundedWidth(10);

        color_button_brighter_light_green.setBackground(new java.awt.Color(90, 230, 20));
        color_button_brighter_light_green.setMaximumSize(new java.awt.Dimension(20, 20));
        color_button_brighter_light_green.setMinimumSize(new java.awt.Dimension(20, 20));
        color_button_brighter_light_green.setPreferredSize(new java.awt.Dimension(20, 20));
        color_button_brighter_light_green.setRoundedHeight(10);
        color_button_brighter_light_green.setRoundedWidth(10);

        color_button_bright_blue.setBackground(new java.awt.Color(20, 90, 230));
        color_button_bright_blue.setMaximumSize(new java.awt.Dimension(20, 20));
        color_button_bright_blue.setMinimumSize(new java.awt.Dimension(20, 20));
        color_button_bright_blue.setPreferredSize(new java.awt.Dimension(20, 20));
        color_button_bright_blue.setRoundedHeight(10);
        color_button_bright_blue.setRoundedWidth(10);

        color_button_like_bright_red.setBackground(new java.awt.Color(230, 20, 20));
        color_button_like_bright_red.setMaximumSize(new java.awt.Dimension(20, 20));
        color_button_like_bright_red.setMinimumSize(new java.awt.Dimension(20, 20));
        color_button_like_bright_red.setPreferredSize(new java.awt.Dimension(20, 20));
        color_button_like_bright_red.setRoundedHeight(10);
        color_button_like_bright_red.setRoundedWidth(10);

        color_button_bright_orange.setBackground(new java.awt.Color(230, 90, 20));
        color_button_bright_orange.setMaximumSize(new java.awt.Dimension(20, 20));
        color_button_bright_orange.setMinimumSize(new java.awt.Dimension(20, 20));
        color_button_bright_orange.setPreferredSize(new java.awt.Dimension(20, 20));
        color_button_bright_orange.setRoundedHeight(10);
        color_button_bright_orange.setRoundedWidth(10);

        color_button_bright_raspberry.setBackground(new java.awt.Color(230, 20, 90));
        color_button_bright_raspberry.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/selectedColor.png"))); // NOI18N
        color_button_bright_raspberry.setMaximumSize(new java.awt.Dimension(20, 20));
        color_button_bright_raspberry.setMinimumSize(new java.awt.Dimension(20, 20));
        color_button_bright_raspberry.setPreferredSize(new java.awt.Dimension(20, 20));
        color_button_bright_raspberry.setRoundedHeight(10);
        color_button_bright_raspberry.setRoundedWidth(10);

        color_button_bright_yellow.setBackground(new java.awt.Color(230, 230, 20));
        color_button_bright_yellow.setMaximumSize(new java.awt.Dimension(20, 20));
        color_button_bright_yellow.setMinimumSize(new java.awt.Dimension(20, 20));
        color_button_bright_yellow.setPreferredSize(new java.awt.Dimension(20, 20));
        color_button_bright_yellow.setRoundedHeight(10);
        color_button_bright_yellow.setRoundedWidth(10);

        color_button_like_royal_gold.setBackground(new java.awt.Color(253, 220, 179));
        color_button_like_royal_gold.setMaximumSize(new java.awt.Dimension(20, 20));
        color_button_like_royal_gold.setMinimumSize(new java.awt.Dimension(20, 20));
        color_button_like_royal_gold.setPreferredSize(new java.awt.Dimension(20, 20));
        color_button_like_royal_gold.setRoundedHeight(10);
        color_button_like_royal_gold.setRoundedWidth(10);

        javax.swing.GroupLayout UI_color_description_panelLayout = new javax.swing.GroupLayout(UI_color_description_panel);
        UI_color_description_panel.setLayout(UI_color_description_panelLayout);
        UI_color_description_panelLayout.setHorizontalGroup(
            UI_color_description_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UI_color_description_panelLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(UI_color_description_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(UI_color_description_panelLayout.createSequentialGroup()
                        .addComponent(color_button_bright_purple, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(color_button_brighter_light_green, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(color_button_bright_blue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(color_button_like_bright_red, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(color_button_bright_orange, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(color_button_bright_raspberry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(color_button_bright_yellow, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(color_button_like_royal_gold, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(UI_color_description_1)
                    .addComponent(UI_color_title))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        UI_color_description_panelLayout.setVerticalGroup(
            UI_color_description_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UI_color_description_panelLayout.createSequentialGroup()
                .addGroup(UI_color_description_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(color_button_like_bright_red, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(UI_color_description_panelLayout.createSequentialGroup()
                        .addComponent(UI_color_title)
                        .addGap(2, 2, 2)
                        .addComponent(UI_color_description_1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(UI_color_description_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(color_button_bright_purple, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(color_button_brighter_light_green, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(color_button_bright_blue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(color_button_bright_orange, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(color_button_bright_raspberry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(color_button_bright_yellow, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(color_button_like_royal_gold, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout UI_color_panelLayout = new javax.swing.GroupLayout(UI_color_panel);
        UI_color_panel.setLayout(UI_color_panelLayout);
        UI_color_panelLayout.setHorizontalGroup(
            UI_color_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UI_color_panelLayout.createSequentialGroup()
                .addComponent(UI_color_description_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80))
        );
        UI_color_panelLayout.setVerticalGroup(
            UI_color_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(UI_color_description_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout tab_2_panelLayout = new javax.swing.GroupLayout(tab_2_panel);
        tab_2_panel.setLayout(tab_2_panelLayout);
        tab_2_panelLayout.setHorizontalGroup(
            tab_2_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab_2_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tab_2_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dark_mode_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(UI_color_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3))
        );
        tab_2_panelLayout.setVerticalGroup(
            tab_2_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab_2_panelLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(dark_mode_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(UI_color_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(432, Short.MAX_VALUE))
        );

        settings_tabbed_pane.addTab("  ",tabAppearanceIcon, tab_2_panel);

        tab_3_panel.setBackground(new java.awt.Color(35, 35, 35));

        about_panel.setBackground(new java.awt.Color(35, 35, 35));

        about_logo_panel.setBackground(new java.awt.Color(35, 35, 35));

        about_logo_icon.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        about_logo_icon.setForeground(new java.awt.Color(198, 197, 193));
        about_logo_icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/notesMini.png"))); // NOI18N

        javax.swing.GroupLayout about_logo_panelLayout = new javax.swing.GroupLayout(about_logo_panel);
        about_logo_panel.setLayout(about_logo_panelLayout);
        about_logo_panelLayout.setHorizontalGroup(
            about_logo_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, about_logo_panelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(about_logo_icon)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        about_logo_panelLayout.setVerticalGroup(
            about_logo_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(about_logo_panelLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(about_logo_icon)
                .addGap(35, 35, 35))
        );

        javax.swing.GroupLayout about_panelLayout = new javax.swing.GroupLayout(about_panel);
        about_panel.setLayout(about_panelLayout);
        about_panelLayout.setHorizontalGroup(
            about_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(about_logo_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        about_panelLayout.setVerticalGroup(
            about_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(about_logo_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        about_description_panel.setBackground(new java.awt.Color(35, 35, 35));

        about_title.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        about_title.setForeground(new java.awt.Color(198, 197, 193));
        about_title.setText("About");

        about_version.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        about_version.setForeground(new java.awt.Color(127, 127, 127));
        about_version.setText("notes 0.5 version");

        about_author.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        about_author.setForeground(new java.awt.Color(127, 127, 127));
        about_author.setText("Author : S.G.");

        javax.swing.GroupLayout about_description_panelLayout = new javax.swing.GroupLayout(about_description_panel);
        about_description_panel.setLayout(about_description_panelLayout);
        about_description_panelLayout.setHorizontalGroup(
            about_description_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, about_description_panelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(about_title)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(about_description_panelLayout.createSequentialGroup()
                .addContainerGap(107, Short.MAX_VALUE)
                .addGroup(about_description_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(about_description_panelLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(about_author))
                    .addComponent(about_version))
                .addContainerGap(107, Short.MAX_VALUE))
        );
        about_description_panelLayout.setVerticalGroup(
            about_description_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(about_description_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(about_title)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(about_version)
                .addGap(1, 1, 1)
                .addComponent(about_author))
        );

        javax.swing.GroupLayout tab_3_panelLayout = new javax.swing.GroupLayout(tab_3_panel);
        tab_3_panel.setLayout(tab_3_panelLayout);
        tab_3_panelLayout.setHorizontalGroup(
            tab_3_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab_3_panelLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(tab_3_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(about_description_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(about_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        tab_3_panelLayout.setVerticalGroup(
            tab_3_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab_3_panelLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(about_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(about_description_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(409, 409, 409))
        );

        settings_tabbed_pane.addTab("        ",tabAboutIcon, tab_3_panel);

        javax.swing.GroupLayout settings_panelLayout = new javax.swing.GroupLayout(settings_panel);
        settings_panel.setLayout(settings_panelLayout);
        settings_panelLayout.setHorizontalGroup(
            settings_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 349, Short.MAX_VALUE)
            .addGroup(settings_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(settings_panelLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(settings_tabbed_pane, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        settings_panelLayout.setVerticalGroup(
            settings_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 639, Short.MAX_VALUE)
            .addGroup(settings_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(settings_panelLayout.createSequentialGroup()
                    .addGap(0, 0, 0)
                    .addComponent(settings_tabbed_pane, javax.swing.GroupLayout.PREFERRED_SIZE, 639, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout text_area_panelLayout = new javax.swing.GroupLayout(text_area_panel);
        text_area_panel.setLayout(text_area_panelLayout);
        text_area_panelLayout.setHorizontalGroup(
            text_area_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(text_area_panelLayout.createSequentialGroup()
                .addComponent(scroll_pane_for_text_area, javax.swing.GroupLayout.DEFAULT_SIZE, 623, Short.MAX_VALUE)
                .addGap(3, 3, 3)
                .addComponent(settings_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        text_area_panelLayout.setVerticalGroup(
            text_area_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scroll_pane_for_text_area)
            .addComponent(settings_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout background_panel_what_holds_allLayout = new javax.swing.GroupLayout(background_panel_what_holds_all);
        background_panel_what_holds_all.setLayout(background_panel_what_holds_allLayout);
        background_panel_what_holds_allLayout.setHorizontalGroup(
            background_panel_what_holds_allLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(background_panel_what_holds_allLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(background_panel_what_holds_allLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lineWhatColorYouCanCustom, javax.swing.GroupLayout.DEFAULT_SIZE, 938, Short.MAX_VALUE)
                    .addComponent(searchDrawerMenuBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(5, 5, 5))
            .addGroup(background_panel_what_holds_allLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(text_area_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        background_panel_what_holds_allLayout.setVerticalGroup(
            background_panel_what_holds_allLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(background_panel_what_holds_allLayout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(searchDrawerMenuBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(lineWhatColorYouCanCustom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(text_area_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(2, 2, 2))
        );

        status_file_panel.setMaximumSize(new java.awt.Dimension(32767, 17));
        status_file_panel.setMinimumSize(new java.awt.Dimension(934, 17));
        status_file_panel.setPreferredSize(new java.awt.Dimension(934, 17));
        status_file_panel.setLayout(new java.awt.BorderLayout());

        statusOfFile.setBackground(new java.awt.Color(25, 25, 25));
        statusOfFile.setMaximumSize(new java.awt.Dimension(32767, 17));
        statusOfFile.setMinimumSize(new java.awt.Dimension(934, 17));
        statusOfFile.setPreferredSize(new java.awt.Dimension(934, 17));

        line_and_column_label.setBackground(new java.awt.Color(25, 25, 25));
        line_and_column_label.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        line_and_column_label.setForeground(new java.awt.Color(253, 220, 179));
        line_and_column_label.setText("Line: 0, Column: 0        ");

        file_path.setBackground(new java.awt.Color(25, 25, 25));
        file_path.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        file_path.setForeground(new java.awt.Color(253, 220, 179));
        file_path.setText(pathOfCurrentSelectedFile);

        javax.swing.GroupLayout statusOfFileLayout = new javax.swing.GroupLayout(statusOfFile);
        statusOfFile.setLayout(statusOfFileLayout);
        statusOfFileLayout.setHorizontalGroup(
            statusOfFileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, statusOfFileLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(file_path, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(line_and_column_label))
        );
        statusOfFileLayout.setVerticalGroup(
            statusOfFileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, statusOfFileLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(statusOfFileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(line_and_column_label)
                    .addComponent(file_path)))
        );

        status_file_panel.add(statusOfFile, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(customTitlebar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(background_panel_what_holds_all, javax.swing.GroupLayout.DEFAULT_SIZE, 948, Short.MAX_VALUE)
            .addComponent(status_file_panel, javax.swing.GroupLayout.DEFAULT_SIZE, 948, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(customTitlebar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(background_panel_what_holds_all, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(status_file_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        //---------------------------------------------
            // Setting searchDrawerMenuBar to be not visable after start
        //---------------------------------------------
        searchDrawerMenuBar.setVisible(false);
        settings_panel.setVisible(false);
        //---------------------------------------------
            // End of Setting searchDrawerMenuBar
        //---------------------------------------------

        //---------------------------------------------
            // Settings of UndoRedoMenager
        //---------------------------------------------
        text_area.getDocument().addUndoableEditListener(new UndoableEditListener() 
        {
            public void undoableEditHappened(UndoableEditEvent evt) {
                undoRedoMenager.addEdit(evt.getEdit());
            }
        });

        // Setting an action for Undo
        text_area.getActionMap().put("UndoWithShourtcut", new AbstractAction("UndoWithShourtcut") 
        {
            public void actionPerformed(ActionEvent evt) {
                try 
                {
                    if (undoRedoMenager.canUndo()) 
                    {
                        undoRedoMenager.undo();
                    }
                } 
                catch (CannotUndoException e) 
                {
                    e.printStackTrace();
                }
            }
        });

        // Setting CTRL + Z to be a shortcut for UndoWithShourtcut action
        text_area.getInputMap().put(KeyStroke.getKeyStroke("ctrl Z"), "UndoWithShourtcut");

        //---------------------------------------------

        // Setting an action for Redo
        text_area.getActionMap().put("RedoWithShourtcut", new AbstractAction("RedoWithShourtcut") 
        {
            public void actionPerformed(ActionEvent evt) {
                try 
                {
                    if (undoRedoMenager.canRedo()) 
                    {
                        undoRedoMenager.redo();
                    }
                } 
                catch (CannotRedoException e) 
                {
                    e.printStackTrace();
                }
            }
        });

        // Setting CTRL + Y to be a shortcut for RedoWithShourtcut action
        text_area.getInputMap().put(KeyStroke.getKeyStroke("ctrl Y"), "RedoWithShourtcut");
        //---------------------------------------------
            // End of Settings of UndoRedoMenager
        //---------------------------------------------

        //---------------------------------------------
            // Settings of MenuButton Shortcuts
        //---------------------------------------------
        // Setting an action for Save
        text_area.getActionMap().put("SaveShourtcut", new AbstractAction("SaveShourtcut") 
        {
            public void actionPerformed(ActionEvent evt) {
                try 
                {
                    saveFile(currentFile);
                } 
                catch (Exception e) 
                {
                    e.printStackTrace();
                }
            }
        });

        // Setting CTRL + S to be a shortcut for SaveShourtcut action
        text_area.getInputMap().put(KeyStroke.getKeyStroke("ctrl S"), "SaveShourtcut");

        //---------------------------------------------

        // Setting an action for SaveAs
        text_area.getActionMap().put("SaveAsShourtcut", new AbstractAction("SaveAsShourtcut") 
        {
            public void actionPerformed(ActionEvent evt) {
                try 
                {
                    saveFileAs();
                } 
                catch (Exception e) 
                {
                    e.printStackTrace();
                }
            }
        });

        // Setting CTRL + SHIFT + S to be a shortcut for SaveAsShourtcut action
        text_area.getInputMap().put(KeyStroke.getKeyStroke("ctrl shift S"), "SaveAsShourtcut");

        //---------------------------------------------

        // Setting an action for NewFile
        text_area.getActionMap().put("NewFileShourtcut", new AbstractAction("NewFileShourtcut") 
        {
            public void actionPerformed(ActionEvent evt) {
                try 
                {
                    newFile();
                } 
                catch (Exception e) 
                {
                    e.printStackTrace();
                }
            }
        });

        // Setting CTRL + N to be a shortcut for NewFileShourtcut action
        text_area.getInputMap().put(KeyStroke.getKeyStroke("ctrl N"), "NewFileShourtcut");

        //---------------------------------------------

        // Setting an action for OpenFile
        text_area.getActionMap().put("OpenFileShourtcut", new AbstractAction("OpenFileShourtcut") 
        {
            public void actionPerformed(ActionEvent evt) {
                try 
                {
                    openFile();
                } 
                catch (Exception e) 
                {
                    e.printStackTrace();
                }
            }
        });

        // Setting CTRL + O to be a shortcut for OpenFileShourtcut action
        text_area.getInputMap().put(KeyStroke.getKeyStroke("ctrl O"), "OpenFileShourtcut");

        //---------------------------------------------

        // Setting an action for Search
        text_area.getActionMap().put("SearchShourtcut", new AbstractAction("SearchShourtcut") 
        {
            public void actionPerformed(ActionEvent evt) {
                
                try 
                {
                    if(searchYsize == 30 && turnOn == 1)
                    {
                        searchDrawerMenuBar.setVisible(true);
                        searchDrawerMenuBar.setSize(searchDrawerMenuBar.getSize().width, searchYsize);
                        Thread searchPSizing = new Thread()
                        {
                          @Override
                          public void run()
                          {
                              try
                              {
                                  for(int i = 30; i >= 0; i--)
                                  {
                                      Thread.sleep(1);
                                      searchDrawerMenuBar.setSize(searchDrawerMenuBar.getSize().width, i);
                                  }
                                  searchDrawerMenuBar.setVisible(false);
                              }
                              catch(Exception e)
                              {
                                  System.out.println("It's not posible to scale search panel");
                              }
                          }
                        };searchPSizing.start();
                        searchYsize = 0;
                        turnOn = 0;
                        if(turnOnDarkMode == 0)
                        {
                            search_button.setBackground(new Color(225,225,225));
                        }
                        else if(turnOnDarkMode == 1)
                        {
                            search_button.setBackground(new Color(25,25,25));
                        }
                    }
                    else if(searchYsize == 0 && turnOn == 0)
                    {
                        searchDrawerMenuBar.setSize(searchDrawerMenuBar.getSize().width, searchYsize);
                        Thread searchPSizing = new Thread()
                        {
                          @Override
                          public void run()
                          {
                              try
                              {
                                  for(int i = 0; i <= searchYsize; i++)
                                  {
                                      Thread.sleep(1);
                                      searchDrawerMenuBar.setSize(searchDrawerMenuBar.getSize().width, i);
                                      searchDrawerMenuBar.setVisible(true);
                                  }
                              }
                              catch(Exception e)
                              {
                                  System.out.println("It's not posible to scale search panel");
                              }
                          }
                        };searchPSizing.start();
                        searchYsize = 30;
                        turnOn = 1;
                        search_button.setBackground(UIColor);
                    }
                } 
                catch (Exception e) 
                {
                    e.printStackTrace();
                }
            }
        });

        // Setting CTRL + F to be a shortcut for SearchShourtcut action
        text_area.getInputMap().put(KeyStroke.getKeyStroke("ctrl F"), "SearchShourtcut");

        //---------------------------------------------

        //---------------------------------------------
            // End of Settings of MenuButton Shortcuts
        //---------------------------------------------
        
        //---------------------------------------------
            // End of Custom UI initComponents
        //---------------------------------------------
    }
    



//---------------------------------------------
//Custom Titlebar Methods
//---------------------------------------------
private void customTitlebarMouseClicked(java.awt.event.MouseEvent evt) 
{                                             
    if(evt.getClickCount() == 2 &&! evt.isConsumed())
    {
        if(this.getExtendedState() == MAXIMIZED_BOTH)
        {
            this.setExtendedState(NORMAL);
        }
        else
        {
            this.setExtendedState(MAXIMIZED_BOTH);
        }
    }
}                                            

private void customTitlebarMouseDragged(java.awt.event.MouseEvent evt) 
{                                             
    int x = evt.getXOnScreen();
    int y = evt.getYOnScreen();
    
    this.setLocation(x - xx, y -xy);
}                                            

private void customTitlebarMousePressed(java.awt.event.MouseEvent evt) 
{                                             
    xx = evt.getX();
    xy = evt.getY();
}  
//---------------------------------------------

//---------------------------------------------
    //Placeholder Settings for Search textfield
//---------------------------------------------
    private void addPlaceholderSearch(JTextField search_text_field)
    {
        Font searchFont = search_text_field.getFont();
        searchFont = searchFont.deriveFont(Font.ITALIC);
        search_text_field.setFont(searchFont);
        search_text_field.setForeground(Color.GRAY);
    }
    private void removePlaceholderSearch(JTextField search_text_field)
    {
        Font searchFont = search_text_field.getFont();
        searchFont = searchFont.deriveFont(Font.PLAIN);
        search_text_field.setFont(searchFont);
        if(turnOnDarkMode == 0)
        {
            search_text_field.setForeground(new Color(29,29,29));
            search_text_field.setCaretColor(new Color(29,29,29));
        }
        else if(turnOnDarkMode == 1)
        {
            search_text_field.setForeground(new Color(234,234,227));
            search_text_field.setCaretColor(new Color(253,220,179));
        }
    }
//---------------------------------------------

//---------------------------------------------
    //Search textFields placeholder Settings
//---------------------------------------------
    private void search_text_fieldFocusGained(java.awt.event.FocusEvent evt) {                                              
        if(search_text_field.getText().equals("Find"))
        {
            search_text_field.setText(null);
            search_text_field.requestFocus();
            removePlaceholderSearch(search_text_field);
        }
    }                                             

    private void search_text_fieldFocusLost(java.awt.event.FocusEvent evt) {                                            
        if(search_text_field.getText().length() == 0)
        {
            addPlaceholderSearch(search_text_field);
            search_text_field.setText("Find");
        }
    }                                           

    private void replace_text_fieldFocusGained(java.awt.event.FocusEvent evt) {                                               
        if(replace_text_field.getText().equals("Replace"))
        {
            replace_text_field.setText(null);
            replace_text_field.requestFocus();
            removePlaceholderSearch(replace_text_field);
        }
    }                                              

    private void replace_text_fieldFocusLost(java.awt.event.FocusEvent evt) {                                             
        if(replace_text_field.getText().length() == 0)
        {
            addPlaceholderSearch(replace_text_field);
            replace_text_field.setText("Replace");
        }
    }                                            
//---------------------------------------------

//---------------------------------------------
    // newFile method
    // *method is used when you click New File
//---------------------------------------------
    private void newFile()
    {
        if(flagSaved == 1)
        {
                fileName = "New File" + " " + nameAndVersionOfAnAplication;
                fileName_label.setFont(fileName_label.getFont().deriveFont(Font.PLAIN));
                currentFile = new File(fileName);
                chooser.setSelectedFile(currentFile);
                fileName_label.setText(fileName);
                text_area.setText("");
                flagSaved = 1;   
                file_path.setText("Save a file first to see a path to your file");
                pathOfCurrentSelectedFile = "Save a file first to see a path to your file";
        }
        
        if(flagSaved == 0)
        {
            
            //---------------------------------------------
            // saveConfirmYN JOptionPane settings
            //---------------------------------------------
            Object[] saveConfirmYNOptions = {"Yes", "No", "Cancel"};
            String confirmMessage = "File " + "'" + fileName + "'" + " got changed."
                +" Do you want to save the changes before you create a new file?";
            
            int saveConfirmYN = JOptionPane.showOptionDialog(rootPane, confirmMessage, nameAndVersionOfAnAplication,
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, saveConfirmYNOptions,
                    saveConfirmYNOptions[0]);
            //---------------------------------------------
            if(saveConfirmYN == JOptionPane.YES_OPTION)
            {
                if(fileName == null || fileName.equals("New File" + " " + nameAndVersionOfAnAplication))
                {
                    saveFileAs();
                }
                else
                {
                saveFile(currentFile);
                //fileName = "Nowy dokument" + " " + nameAndVersionOfAnAplication;
                currentFile = new File(fileName);
                chooser.setSelectedFile(currentFile);
                fileName_label.setText(fileName);
                text_area.setText("");
                flagSaved = 1;
                }
            }
            if(saveConfirmYN == JOptionPane.NO_OPTION)
            {
                fileName = "New File" + " " + nameAndVersionOfAnAplication;
                fileName_label.setFont(fileName_label.getFont().deriveFont(Font.PLAIN));
                currentFile = new File(fileName);
                chooser.setSelectedFile(currentFile);
                fileName_label.setText(fileName);
                text_area.setText("");
                flagSaved = 1;   
            }
        }
        else
        {
            fileName = fileNameWithStar;
        }
    }
    //---------------------------------------------
    

    //---------------------------------------------
    // saveFileAs method
    // *method is used when you click SaveAs
    //---------------------------------------------
    private void saveFileAs()
    {
        //---------------------------------------------
        // chooser and chooserFilter settings
        //---------------------------------------------
        chooser = new JFileChooser();
//            chooser.addChoosableFileFilter(new NotesFileFilter(".txt","Text fles (.txt)"));
        chooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
//            chooser.setSelectedFile(new File(System.clearProperty("user.dir")+File.separator+"Bez nazwy.txt"));
        
        chooser.setDialogTitle("Save as");
        chooser.setApproveButtonToolTipText("Click to save a file as");
        
        int tmp = chooser.showDialog(rootPane,"Save As");
        try
        {
            if(chooser.getSelectedFile() == null)
            {
                file_path.setText("Save a file first to see a path to your file");
            }
            else
            {
                pathOfCurrentSelectedFile = "" + chooser.getSelectedFile().getPath();
            }
        }
        catch (Exception ex) 
        {
            chooser.setSelectedFile(null);
            System.out.println("You cancel choosing a file");
        }
        if(fileName.equals("New File" + " " + nameAndVersionOfAnAplication))
        {
            
        }
        else
        {
            file_path.setText(pathOfCurrentSelectedFile);
        }
        
        //---------------------------------------------
        
        //---------------------------------------------
        // BufferedWriter and fileName after save settings
        //---------------------------------------------
        if(tmp == JFileChooser.APPROVE_OPTION)
        {
        try 
        {
            BufferedWriter fileWriter = new BufferedWriter(new FileWriter(chooser.getSelectedFile().getAbsoluteFile()));
            currentFile = chooser.getSelectedFile();
            fileWriter.write(text_area.getText());
            fileWriter.close();
            fileName = chooser.getSelectedFile().getAbsoluteFile().getName();
            flagSaved = 1;
        } 
        catch (IOException IOex) 
        {
            System.out.println("Failed to save file.");
        }
        finally
        {
            fileName_label.setFont(fileName_label.getFont().deriveFont(Font.PLAIN));
            fileName = fileName + " " + nameAndVersionOfAnAplication;
            fileName_label.setText(fileName);
        }
        }
        else
        {
            chooser.setSelectedFile(currentFile);
        }
        if(tmp == JFileChooser.CANCEL_OPTION)
        {
            if(file_path.getText().equals("Save a file first to see a path to your file"))
            {
                file_path.setText("Save a file first to see a path to your file");
            }
            else
            {
                if(fileName.equals("New File" + " " + nameAndVersionOfAnAplication))
                {
                    file_path.setText("Save a file first to see a path to your file");
                }
                else
                {
                    file_path.setText(pathOfCurrentSelectedFile);
                }
            }
        }
        //---------------------------------------------
    }
    //---------------------------------------------
    
    //---------------------------------------------
    // saveFile method
    // *method is used when you click Save
    //---------------------------------------------
    private void saveFile(File tmp)
    {
        if(tmp == null || file_path.getText().equals("Save a file first to see a path to your file"))
        {
            saveFileAs();
        }
        else
        {
            try 
            {
                BufferedWriter fileWriter = new BufferedWriter(new FileWriter(chooser.getSelectedFile().getAbsoluteFile()));
                currentFile = chooser.getSelectedFile().getAbsoluteFile();
                fileWriter.write(text_area.getText());
                fileWriter.close();
                fileName = chooser.getSelectedFile().getAbsoluteFile().getName();
                flagSaved = 1;
                //menuSave.setEnabled(false);
                tmp = currentFile;
            } 
            catch (IOException IOex) 
            {
                System.out.println("Failed to save file.");
            }
            finally
            {
                fileName_label.setFont(fileName_label.getFont().deriveFont(Font.PLAIN));
                fileName = fileName + " " + nameAndVersionOfAnAplication;
                fileName_label.setText(fileName);
            }
        }
    }
    //---------------------------------------------
    
    //---------------------------------------------
    // openFile method
    // *method is used when you click Open
    //---------------------------------------------
    private void openFile()
    {
        //---------------------------------------------
        // chooser and chooserFilter settings
        //---------------------------------------------
        chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
        if(fileName.equals("New File") || fileName.equals("Untitled"))
        {
            chooser.setSelectedFile(new File(""));
        }
        else
        {
            if(currentFile == null)
            {
                fileName = "";
                chooser.setSelectedFile(new File(""+fileName));
            }
            else
            {
                fileName = ""+currentFile;
                chooser.setSelectedFile(new File(""+fileName));
            }
        }
        
        chooser.setDialogTitle("Open");
        chooser.setApproveButtonToolTipText("Click to open a file");
        
        int tmp = chooser.showDialog(rootPane,"Open");
        
        //---------------------------------------------
        
        //---------------------------------------------
        // BufferedReader and fileName after open settings
        //---------------------------------------------
        if(tmp == JFileChooser.APPROVE_OPTION)
        {
        BufferedReader fileReader = null;
        try 
        {
            fileReader = new BufferedReader(new FileReader(chooser.getSelectedFile().getAbsoluteFile()));
            fileName = chooser.getSelectedFile().getAbsoluteFile().getName();
            fileName = fileName + " " + nameAndVersionOfAnAplication;
            fileName_label.setFont(fileName_label.getFont().deriveFont(Font.PLAIN));
            fileName_label.setText(fileName);
            currentFile = chooser.getSelectedFile().getAbsoluteFile();
            flagSaved = 1;
            text_area.selectAll();
            text_area.setText("");
            
            String line = fileReader.readLine();
            while(line != null)
            {
                text_area.replaceSelection(line + "\n");
                line = fileReader.readLine();
            }
            text_area.setCaretPosition(0);
            pathOfCurrentSelectedFile = "" + chooser.getSelectedFile().getPath();
            file_path.setText(pathOfCurrentSelectedFile);
        }
        catch (IOException InOutEx) 
        {
        System.out.println("Failed to open file.");
        }
        finally
        {
            try 
            {
                fileReader.close();
            } 
            catch (IOException InOutEx) 
            {
                InOutEx.getStackTrace();
            }
        }
        }
        else
        {
            
        }
        //---------------------------------------------
    //---------------------------------------------
    }   // End of openFile method
    //---------------------------------------------    
    
    //---------------------------------------------
    // exitFile method
    // *method is used when you click Exit
    //---------------------------------------------
    private void exitFile()
    {
        if(flagSaved == 0)
        {
            //---------------------------------------------
            // saveConfirmYN JOptionPane settings
            //---------------------------------------------
            Object[] saveConfirmYNOptions = {"Yes", "No", "Cancel"};
            String confirmMessage = "File " + "'" + fileName + "'" + " got changed."
                +" Do you want to save the changes before you close a program?";
            
            int saveConfirmYN = JOptionPane.showOptionDialog(rootPane, confirmMessage, nameAndVersionOfAnAplication.substring(2),
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, saveConfirmYNOptions,
                    saveConfirmYNOptions[0]);
            //---------------------------------------------
            if(saveConfirmYN == JOptionPane.YES_OPTION)
            {
                saveFile(currentFile);
                System.exit(0);
            }
            if(saveConfirmYN == JOptionPane.NO_OPTION)
            {
                System.exit(0);
            }
        }
        else
        {
            System.exit(0);
        }
    //---------------------------------------------
    }   // End of exitFile method
    //---------------------------------------------    
    
    //---------------------------------------------
    // changeUIColor method
    //---------------------------------------------
    public void changeUIColor(JMenuItem menuNew,JMenuItem menuOpen, JMenuItem menuSave, JMenuItem menuSaveAs, JMenuItem menuExit,settings ColorsConfig)
    {
        if(turnOn == 1)
        {
            search_button.setBackground(UIColor);
        }
        lineUnderDrawerUIColor.setBackground(UIColor);
        if(turnOnSettings == 1)
        {
            settings_button.setBackground(UIColor);
        }

        menuNew.setUI(new customColorForPopupUI(UIColor));
        menuOpen.setUI(new customColorForPopupUI(UIColor));
        menuSave.setUI(new customColorForPopupUI(UIColor));
        menuSaveAs.setUI(new customColorForPopupUI(UIColor));
        menuExit.setUI(new customColorForPopupUI(UIColor));

        if(ColorsConfig.getTurnOnDarkMode() == 1)
        {
            getRootPane().setBorder(new LineBorder(new Color(35,35,35)));
            dark_mode_button_ON_OFF.setBackground(DarkModeColor);
            dark_mode_button_ON_OFF.setBackground(UIColor);
            dark_mode_button_ON_OFF.setText("ON");
        }
        
        if(ColorsConfig.getTurnOnDarkMode() == 0)
        {
            getRootPane().setBorder(new LineBorder(new Color(200,200,200)));
            dark_mode_button_ON_OFF.setBackground(DarkModeColor);
            dark_mode_button_ON_OFF.setBackground(UIColor);
            dark_mode_button_ON_OFF.setBackground(new Color(225,225,225));
            dark_mode_button_ON_OFF.setText("OFF");
        }
        
        if(ColorsConfig.getUIColor().equals(new Color(90,20,230)))
        {
            color_button_bright_purple.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/selectedColor.png")));
            color_button_brighter_light_green.setIcon(new javax.swing.ImageIcon(getClass().getResource("")));
            color_button_bright_blue.setIcon(new javax.swing.ImageIcon(getClass().getResource("")));
            color_button_like_bright_red.setIcon(new javax.swing.ImageIcon(getClass().getResource("")));
            color_button_bright_orange.setIcon(new javax.swing.ImageIcon(getClass().getResource("")));
            color_button_bright_raspberry.setIcon(new javax.swing.ImageIcon(getClass().getResource("")));
            color_button_bright_yellow.setIcon(new javax.swing.ImageIcon(getClass().getResource("")));
            color_button_like_royal_gold.setIcon(new javax.swing.ImageIcon(getClass().getResource("")));
        }
        
        if(ColorsConfig.getUIColor().equals(new Color(90,230,20)))
        {
            color_button_bright_purple.setIcon(new javax.swing.ImageIcon(getClass().getResource("")));
            color_button_brighter_light_green.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/selectedColor.png")));
            color_button_bright_blue.setIcon(new javax.swing.ImageIcon(getClass().getResource("")));
            color_button_like_bright_red.setIcon(new javax.swing.ImageIcon(getClass().getResource("")));
            color_button_bright_orange.setIcon(new javax.swing.ImageIcon(getClass().getResource("")));
            color_button_bright_raspberry.setIcon(new javax.swing.ImageIcon(getClass().getResource("")));
            color_button_bright_yellow.setIcon(new javax.swing.ImageIcon(getClass().getResource("")));
            color_button_like_royal_gold.setIcon(new javax.swing.ImageIcon(getClass().getResource("")));
        }
        
        if(ColorsConfig.getUIColor().equals(new Color(20,90,230)))
        {
            color_button_bright_purple.setIcon(new javax.swing.ImageIcon(getClass().getResource("")));
            color_button_brighter_light_green.setIcon(new javax.swing.ImageIcon(getClass().getResource("")));
            color_button_bright_blue.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/selectedColor.png")));
            color_button_like_bright_red.setIcon(new javax.swing.ImageIcon(getClass().getResource("")));
            color_button_bright_orange.setIcon(new javax.swing.ImageIcon(getClass().getResource("")));
            color_button_bright_raspberry.setIcon(new javax.swing.ImageIcon(getClass().getResource("")));
            color_button_bright_yellow.setIcon(new javax.swing.ImageIcon(getClass().getResource("")));
            color_button_like_royal_gold.setIcon(new javax.swing.ImageIcon(getClass().getResource("")));
        }
        
        if(ColorsConfig.getUIColor().equals(new Color(230,20,20)))
        {
            color_button_bright_purple.setIcon(new javax.swing.ImageIcon(getClass().getResource("")));
            color_button_brighter_light_green.setIcon(new javax.swing.ImageIcon(getClass().getResource("")));
            color_button_bright_blue.setIcon(new javax.swing.ImageIcon(getClass().getResource("")));
            color_button_like_bright_red.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/selectedColor.png")));
            color_button_bright_orange.setIcon(new javax.swing.ImageIcon(getClass().getResource("")));
            color_button_bright_raspberry.setIcon(new javax.swing.ImageIcon(getClass().getResource("")));
            color_button_bright_yellow.setIcon(new javax.swing.ImageIcon(getClass().getResource("")));
            color_button_like_royal_gold.setIcon(new javax.swing.ImageIcon(getClass().getResource("")));
        }
        
        if(ColorsConfig.getUIColor().equals(new Color(230,90,20)))
        {
            color_button_bright_purple.setIcon(new javax.swing.ImageIcon(getClass().getResource("")));
            color_button_brighter_light_green.setIcon(new javax.swing.ImageIcon(getClass().getResource("")));
            color_button_bright_blue.setIcon(new javax.swing.ImageIcon(getClass().getResource("")));
            color_button_like_bright_red.setIcon(new javax.swing.ImageIcon(getClass().getResource("")));
            color_button_bright_orange.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/selectedColor.png")));
            color_button_bright_raspberry.setIcon(new javax.swing.ImageIcon(getClass().getResource("")));
            color_button_bright_yellow.setIcon(new javax.swing.ImageIcon(getClass().getResource("")));
            color_button_like_royal_gold.setIcon(new javax.swing.ImageIcon(getClass().getResource("")));
        }
        
        if(ColorsConfig.getUIColor().equals(new Color(230,20,90)))
        {
            color_button_bright_purple.setIcon(new javax.swing.ImageIcon(getClass().getResource("")));
            color_button_brighter_light_green.setIcon(new javax.swing.ImageIcon(getClass().getResource("")));
            color_button_bright_blue.setIcon(new javax.swing.ImageIcon(getClass().getResource("")));
            color_button_like_bright_red.setIcon(new javax.swing.ImageIcon(getClass().getResource("")));
            color_button_bright_orange.setIcon(new javax.swing.ImageIcon(getClass().getResource("")));
            color_button_bright_raspberry.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/selectedColor.png")));
            color_button_bright_yellow.setIcon(new javax.swing.ImageIcon(getClass().getResource("")));
            color_button_like_royal_gold.setIcon(new javax.swing.ImageIcon(getClass().getResource("")));
        }
        
        if(ColorsConfig.getUIColor().equals(new Color(230,230,20)))
        {
            color_button_bright_purple.setIcon(new javax.swing.ImageIcon(getClass().getResource("")));
            color_button_brighter_light_green.setIcon(new javax.swing.ImageIcon(getClass().getResource("")));
            color_button_bright_blue.setIcon(new javax.swing.ImageIcon(getClass().getResource("")));
            color_button_like_bright_red.setIcon(new javax.swing.ImageIcon(getClass().getResource("")));
            color_button_bright_orange.setIcon(new javax.swing.ImageIcon(getClass().getResource("")));
            color_button_bright_raspberry.setIcon(new javax.swing.ImageIcon(getClass().getResource("")));
            color_button_bright_yellow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/LightModeSelectedColor.png")));
            color_button_like_royal_gold.setIcon(new javax.swing.ImageIcon(getClass().getResource("")));
        }
        
        if(ColorsConfig.getUIColor().equals(new Color(253,220,179)))
        {
            color_button_bright_purple.setIcon(new javax.swing.ImageIcon(getClass().getResource("")));
            color_button_brighter_light_green.setIcon(new javax.swing.ImageIcon(getClass().getResource("")));
            color_button_bright_blue.setIcon(new javax.swing.ImageIcon(getClass().getResource("")));
            color_button_like_bright_red.setIcon(new javax.swing.ImageIcon(getClass().getResource("")));
            color_button_bright_orange.setIcon(new javax.swing.ImageIcon(getClass().getResource("")));
            color_button_bright_raspberry.setIcon(new javax.swing.ImageIcon(getClass().getResource("")));
            color_button_bright_yellow.setIcon(new javax.swing.ImageIcon(getClass().getResource("")));
            color_button_like_royal_gold.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/LightModeSelectedColor.png")));
        }
    //---------------------------------------------
    }   // End of changeUIColor method
    //--------------------------------------------- 
    
    //---------------------------------------------
    // darkModeON_OFF_system_settings method
    //---------------------------------------------
    public void darkModeON_OFF_system_settings(JPopupMenu menuFile,JMenuItem menuNew,JMenuItem menuOpen, JMenuItem menuSave, JMenuItem menuSaveAs, JMenuItem menuExit,settings ColorsConfig)
    {
        if(turnOnDarkMode == 1)
        {
            dark_mode_button_ON_OFF.setText("ON");
            //Setting UI to be dark mode
            //Menu Button, popup settings
            menuFile.setBackground(new Color(65,65,77));
            menuNew.setForeground(new Color(198,197,193));
            menuOpen.setForeground(new Color(198,197,193));
            menuSave.setForeground(new Color(198,197,193));
            menuSaveAs.setForeground(new Color(198,197,193));
            menuExit.setForeground(new Color(198,197,193));
            //---------------------------------------------
            windowsMinResExit_panel.setBackground(new Color(25,25,25));
            minimalizeWindowButton.setBackground(new Color(25,25,25));
            resizeWindowButton.setBackground(new Color(25,25,25));
            closeWindowButton.setBackground(new Color(25,25,25));
            //---------------------------------------------
            aplicationTitle_panel.setBackground(new Color(25,25,25));
            menu_button.setBackground(new Color(25,25,25));
            //---------------------------------------------
            fileName_panel.setBackground(new Color(25,25,25));
            fileName_label.setBackground(new Color(25,25,25));
            fileName_label.setForeground(new Color(198,197,193));

            searchButton.setBackground(new Color(25,25,25));
            search_button_panel.setBackground(new Color(25,25,25));
            if(turnOn == 0)
            {
                search_button.setBackground(new Color(25,25,25));
            }
            search_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/search_icon.png")));
            if(turnOnSettings == 0)
            {
                settings_button.setBackground(new Color(25,25,25));
            }
            settings_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/settingsIcon14x14.png")));
            //---------------------------------------------
            searchDrawerMenuBar.setBackground(new Color(35,35,35));
            searchDrawerMenuBar_panel.setBackground(new Color(35,35,35));
            replace_all_text_field_button.setBackground(new Color(65,65,77));
            replace_all_text_field_button.setForeground(new Color(187,187,187));
            replace_text_field_button.setBackground(new Color(65,65,77));
            replace_text_field_button.setForeground(new Color(187,187,187));
            find_text_field_button.setBackground(new Color(65,65,77));
            find_text_field_button.setForeground(new Color(187,187,187));

            replace_text_field.setBackground(new Color(54,54,66));
            search_text_field.setBackground(new Color(54,54,66));
            
            if(search_text_field.getText().equals("Find"))
            {
                search_text_field.setForeground(new Color(102,102,102));
                search_text_field.setCaretColor(new Color(253,220,179));
            }
            else
            {
                search_text_field.setForeground(new Color(234,234,227));
                search_text_field.setCaretColor(new Color(253,220,179));
            }
            
            if(replace_text_field.getText().equals("Replace"))
            {
                replace_text_field.setForeground(new Color(102,102,102));
                replace_text_field.setCaretColor(new Color(253,220,179));
            }
            else
            {
                replace_text_field.setForeground(new Color(234,234,227));
                replace_text_field.setCaretColor(new Color(253,220,179));
            }
            //---------------------------------------------
            background_panel_what_holds_all.setBackground(new Color(25,25,25));
            //---------------------------------------------
            scroll_pane_for_text_area.setBackground(new Color(25,25,25));
            text_area_panel.setBackground(new Color(25,25,25));
            text_area_panel.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 5, 2, 5, new java.awt.Color(25, 25, 25)));
            text_area.setBackground(new Color(54,54,66));
            text_area.setForeground(new Color(234,234,227));
            text_area.setCaretColor(new Color(253,220,179));
            //---------------------------------------------
            settings_panel.setBackground(new Color(35,35,35));
            settings_tabbed_pane.setBackground(new Color(35,35,35));
            
            tabFontIcon = new ImageIcon(getClass().getResource("/icon/FontSettingsCategory.png"));
            tabAppearanceIcon = new ImageIcon(getClass().getResource("/icon/UICategory.png"));
            tabAboutIcon = new ImageIcon(getClass().getResource("/icon/AboutCategory.png"));
            //---------------------------------------------
            tab_1_panel.setBackground(new Color(35,35,35));
            font_name_panel.setBackground(new Color(35,35,35));
            font_name_description_panel.setBackground(new Color(35,35,35));
            font_name_title.setForeground(new Color(198,197,193));
            font_name_combo_box.setBackground(new Color(25,25,25));
            font_name_combo_box.setForeground(new Color(198,197,193));
            //to force dark / light mode working on combo popup
            font_name_combo_box.setUI(font_name_combo_box.getUI());
            font_style_panel.setBackground(new Color(35,35,35));
            font_style_description_panel.setBackground(new Color(35,35,35));
            font_style_title.setForeground(new Color(198,197,193));
            font_style_combo_box.setBackground(new Color(25,25,25));
            font_style_combo_box.setForeground(new Color(198,197,193));
            //to force dark / light mode working on combo popup
            font_style_combo_box.setUI(font_style_combo_box.getUI());
            font_size_panel.setBackground(new Color(35,35,35));
            font_size_description_panel.setBackground(new Color(35,35,35));
            font_size_title.setForeground(new Color(198,197,193));
            font_size_combo_box.setBackground(new Color(25,25,25));
            font_size_combo_box.setForeground(new Color(198,197,193));
            //to force dark / light mode working on combo popup
            font_size_combo_box.setUI(font_size_combo_box.getUI());
            //---------------------------------------------
            tab_2_panel.setBackground(new Color(35,35,35));
            dark_mode_panel.setBackground(new Color(35,35,35));
            dark_mode_description_panel.setBackground(new Color(35,35,35));
            dark_mode_button_panel.setBackground(new Color(35,35,35));
            dark_mode_title.setForeground(new Color(198,197,193));
            UI_color_panel.setBackground(new Color(35,35,35));
            UI_color_description_panel.setBackground(new Color(35,35,35));
            UI_color_title.setForeground(new Color(198,197,193));
            dark_mode_button_ON_OFF.setBorder(BorderFactory.createLineBorder(new Color(75,75,75)));
            //---------------------------------------------
            tab_3_panel.setBackground(new Color(35,35,35));
            about_panel.setBackground(new Color(35,35,35));
            about_logo_panel.setBackground(new Color(35,35,35));
            about_logo_icon.setBackground(new Color(35,35,35));
            about_description_panel.setBackground(new Color(35,35,35));
            about_title.setForeground(new Color(198,197,193));
            //---------------------------------------------
            statusOfFile.setBackground(new Color(25,25,25));
            line_and_column_label.setBackground(new Color(25,25,25));
            line_and_column_label.setForeground(new Color(198,197,193));
            file_path.setBackground(new Color(25,25,25));
            file_path.setForeground(new Color(198,197,193));
            //---------------------------------------------
        }
        else if (turnOnDarkMode == 0)
        {
            dark_mode_button_ON_OFF.setText("OFF");
            dark_mode_button_ON_OFF.setBackground(new Color(78,80,82));
            //Setting UI to be light mode
            //Menu Button, popup settings
            menuFile.setBackground(new Color(225,225,237));
            menuNew.setForeground(new Color(28,27,23));
            menuOpen.setForeground(new Color(28,27,23));
            menuSave.setForeground(new Color(28,27,23));
            menuSaveAs.setForeground(new Color(28,27,23));
            menuExit.setForeground(new Color(28,27,23));
            //---------------------------------------------
            windowsMinResExit_panel.setBackground(new Color(225,225,225));
            minimalizeWindowButton.setBackground(new Color(225,225,225));
            resizeWindowButton.setBackground(new Color(225,225,225));
            closeWindowButton.setBackground(new Color(225,225,225));
            //---------------------------------------------
            aplicationTitle_panel.setBackground(new Color(225,225,225));
            menu_button.setBackground(new Color(225,225,225));
            //---------------------------------------------
            fileName_panel.setBackground(new Color(225,225,225));
            fileName_label.setBackground(new Color(225,225,255));
            fileName_label.setForeground(new Color(28,27,23));

            searchButton.setBackground(new Color(225,225,225));
            search_button_panel.setBackground(new Color(225,225,225));
            if(turnOn == 0)
            {
                search_button.setBackground(new Color(225,225,225));
            }
            search_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/LightModeSearch_icon.png")));
            if(turnOnSettings == 0)
            {
                settings_button.setBackground(new Color(225,225,225));
            }
            settings_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/LightModeSettingsIcon14x14.png")));
            //---------------------------------------------
            searchDrawerMenuBar.setBackground(new Color(230,230,230));
            searchDrawerMenuBar_panel.setBackground(new Color(230,230,230));
            replace_all_text_field_button.setBackground(new Color(234,234,234));
            replace_all_text_field_button.setForeground(new Color(29,29,29));
            replace_text_field_button.setBackground(new Color(234,234,234));
            replace_text_field_button.setForeground(new Color(29,29,29));
            find_text_field_button.setBackground(new Color(234,234,234));
            find_text_field_button.setForeground(new Color(29,29,29));

            replace_text_field.setBackground(new Color(229,229,229));
            search_text_field.setBackground(new Color(229,229,229));
            
            if(search_text_field.getText().equals("Find"))
            {
                search_text_field.setForeground(new Color(102,102,102));
                search_text_field.setCaretColor(new Color(29,29,29));
            }
            else
            {
                search_text_field.setForeground(new Color(29,29,29));
                search_text_field.setCaretColor(new Color(29,29,29));
            }
            
            if(replace_text_field.getText().equals("Replace"))
            {
                replace_text_field.setForeground(new Color(102,102,102));
                replace_text_field.setCaretColor(new Color(29,29,29));
            }
            else
            {
                replace_text_field.setForeground(new Color(29,29,29));
                replace_text_field.setCaretColor(new Color(29,29,29));
            }
            
            //---------------------------------------------
            background_panel_what_holds_all.setBackground(new Color(225,225,225));
            //---------------------------------------------
            scroll_pane_for_text_area.setBackground(new Color(225,225,225));
            text_area_panel.setBackground(new Color(225,225,225));
            text_area_panel.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 5, 2, 5, new java.awt.Color(225,225,225)));
            text_area.setBackground(new Color(243,243,255));
            text_area.setForeground(new Color(45,45,38));
            text_area.setCaretColor(new Color(64,31,21));
            //---------------------------------------------
            settings_panel.setBackground(new Color(245,245,245));
            settings_tabbed_pane.setBackground(new Color(245,245,245));
            
            tabFontIcon = new ImageIcon(getClass().getResource("/icon/FontSettingsCategoryLightMode.png"));
            tabAppearanceIcon = new ImageIcon(getClass().getResource("/icon/UICategoryLightMode.png"));
            tabAboutIcon = new ImageIcon(getClass().getResource("/icon/AboutCategoryLightMode.png"));
            //---------------------------------------------
            tab_1_panel.setBackground(new Color(245,245,245));
            font_name_panel.setBackground(new Color(245,245,245));
            font_name_description_panel.setBackground(new Color(245,245,245));
            font_name_title.setForeground(new Color(45,45,38));
            font_name_combo_box.setBackground(new Color(225,225,225));
            font_name_combo_box.setForeground(new Color(45,45,38));
            //to force dark / light mode working on combo popup
            font_name_combo_box.setUI(font_name_combo_box.getUI());
            font_style_panel.setBackground(new Color(245,245,245));
            font_style_description_panel.setBackground(new Color(245,245,245));
            font_style_title.setForeground(new Color(45,45,38));
            font_style_combo_box.setBackground(new Color(225,225,225));
            font_style_combo_box.setForeground(new Color(45,45,38));
            //to force dark / light mode working on combo popup
            font_style_combo_box.setUI(font_style_combo_box.getUI());
            font_size_panel.setBackground(new Color(245,245,245));
            font_size_description_panel.setBackground(new Color(245,245,245));
            font_size_title.setForeground(new Color(45,45,38));
            font_size_combo_box.setBackground(new Color(225,225,225));
            font_size_combo_box.setForeground(new Color(45,45,38));
            //to force dark / light mode working on combo popup
            font_size_combo_box.setUI(font_size_combo_box.getUI());
            //---------------------------------------------
            tab_2_panel.setBackground(new Color(245,245,245));
            dark_mode_panel.setBackground(new Color(245,245,245));
            dark_mode_description_panel.setBackground(new Color(245,245,245));
            dark_mode_button_panel.setBackground(new Color(245,245,245));
            dark_mode_title.setForeground(new Color(45,45,38));
            UI_color_panel.setBackground(new Color(245,245,245));
            UI_color_description_panel.setBackground(new Color(245,245,245));
            UI_color_title.setForeground(new Color(45,45,38));
            dark_mode_button_ON_OFF.setBackground(new Color(220,220,220));
            dark_mode_button_ON_OFF.setBorder(BorderFactory.createLineBorder(new Color(200,200,200)));
            //---------------------------------------------
            tab_3_panel.setBackground(new Color(245,245,245));
            about_panel.setBackground(new Color(245,245,245));
            about_logo_panel.setBackground(new Color(245,245,245));
            about_logo_icon.setBackground(new Color(245,245,245));
            about_description_panel.setBackground(new Color(245,245,245));
            about_title.setForeground(new Color(45,45,38));
            //---------------------------------------------
            statusOfFile.setBackground(new Color(243,243,255));
            line_and_column_label.setBackground(new Color(243,243,255));
            line_and_column_label.setForeground(new Color(53,20,79));
            file_path.setBackground(new Color(243,243,255));
            file_path.setForeground(new Color(53,20,79));
            //---------------------------------------------
        }
    //---------------------------------------------
    }   // End of darkModeON_OFF_system_settings method
    //--------------------------------------------- 
    
    //---------------------------------------------
    // ComboBox of selecting a Font by name class
    //---------------------------------------------
    private class ComboBoxFontGetter extends DefaultListCellRenderer
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
                Font itemFont = new Font(object.toString(), Font.PLAIN, customCombobox.getFont().getSize());
                setFont(itemFont);
                
                //Setting popup selected item background
                if (itemSelected)
                {
                    customCombobox.setBackground(UIColor);
                }
                //---------------------------------------------
                
                return customCombobox;
            }
    //---------------------------------------------
    }   // End of ComboBox of selecting a Font by name class
    //--------------------------------------------- 
    
//---------------------------------------------
        //****** Constructor ******\\
//---------------------------------------------
    public static void main(String[] args) 
    {
        //Forcing to use systemLookAndFeel
        try 
        {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } 
        catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                | UnsupportedLookAndFeelException e) 
        {
            e.printStackTrace();
        }
        //---------------------------------------------
        new notes().setVisible(true);
    }
//---------------------------------------------
        //*************************\\
//---------------------------------------------
}

