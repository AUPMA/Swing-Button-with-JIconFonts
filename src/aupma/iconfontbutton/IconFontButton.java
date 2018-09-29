/**
 * Copyright (c) 2018 AUPMA
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
 * documentation files (the "Software"), to deal in the Software without restriction, including without limitation the
 * rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the
 * Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
 * WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR
 * OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package aupma.iconfontbutton;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import jiconfont.icons.Elusive;
import jiconfont.icons.Entypo;
import jiconfont.icons.FontAwesome;
import jiconfont.icons.GoogleMaterialDesignIcons;
import jiconfont.icons.Iconic;
import jiconfont.icons.Typicons;
import jiconfont.swing.IconFontSwing;

/**
 *
 * @author AUPMA
 */
public class IconFontButton extends JButton {

    private Icon fontIcon = null;
    private int iconSize = 14;
    private Color iconColor = Color.BLACK;
    private boolean enableIcon = true;
    private IconFonts selectedIconFont = IconFonts.FontAwesome;
    private FontAwesome fontAwesomeIcon = FontAwesome.FONT_AWESOME;
    private GoogleMaterialDesignIcons googleIcon = GoogleMaterialDesignIcons.ANDROID;
    private Entypo entypoIcon = Entypo.KEYBOARD;
    private Iconic iconicIcon = Iconic.CLOUD;
    private Elusive elusiveIcon = Elusive.ADDRESS_BOOK;
    private Typicons typIcon = Typicons.ANCHOR;
    private boolean darkMouseEnter = true;
    private int cursor = Cursor.HAND_CURSOR;

    /*-----------------------------------------------------------------------*/
    public Icon getFontIcon() {
        return fontIcon;
    }

    public void setFontIcon(Icon fontIcon) {
        this.fontIcon = fontIcon;
        super.setIcon(buildIcon());
    }

    public int getIconSize() {
        return iconSize;
    }

    public void setIconSize(int iconSize) {
        this.iconSize = iconSize;
        super.setIcon(buildIcon());
    }

    public Color getIconColor() {
        return iconColor;
    }

    public void setIconColor(Color iconColor) {
        this.iconColor = iconColor;
        super.setIcon(buildIcon());
    }

    public boolean isEnableIcon() {
        return enableIcon;
    }

    public void setEnableIcon(boolean enableIcon) {
        this.enableIcon = enableIcon;
        super.setIcon(buildIcon());
    }

    public IconFonts getSelectedIconFont() {
        return selectedIconFont;
    }

    public void setSelectedIconFont(IconFonts selectedIconFont) {
        this.selectedIconFont = selectedIconFont;
        super.setIcon(buildIcon());
    }

    public FontAwesome getFontAwesomeIcon() {
        return fontAwesomeIcon;
    }

    public void setFontAwesomeIcon(FontAwesome fontAwesomeIcon) {
        this.fontAwesomeIcon = fontAwesomeIcon;
        super.setIcon(buildIcon());
    }

    public GoogleMaterialDesignIcons getGoogleIcon() {
        return googleIcon;
    }

    public void setGoogleIcon(GoogleMaterialDesignIcons googleIcon) {
        this.googleIcon = googleIcon;
        super.setIcon(buildIcon());
    }

    public Entypo getEntypoIcon() {
        return entypoIcon;
    }

    public void setEntypoIcon(Entypo entypoIcon) {
        this.entypoIcon = entypoIcon;
        super.setIcon(buildIcon());
    }

    public Iconic getIconicIcon() {
        return iconicIcon;
    }

    public void setIconicIcon(Iconic iconicIcon) {
        this.iconicIcon = iconicIcon;
        super.setIcon(buildIcon());
    }

    public Elusive getElusiveIcon() {
        return elusiveIcon;
    }

    public void setElusiveIcon(Elusive elusiveIcon) {
        this.elusiveIcon = elusiveIcon;
        super.setIcon(buildIcon());
    }

    public Typicons getTypIcon() {
        return typIcon;
    }

    public void setTypIcon(Typicons typIcon) {
        this.typIcon = typIcon;
        super.setIcon(buildIcon());
    }

    public boolean isDarkMouseEnter() {
        return darkMouseEnter;
    }

    public void setDarkMouseEnter(boolean darkMouseEnter) {
        this.darkMouseEnter = darkMouseEnter;
        super.setIcon(buildIcon());
    }

    

    public void setCursor(int cursor) {
        this.cursor = cursor;
    }
    
    

    /*-----------------------------------------------------------------------*/
    public IconFontButton() {
        registerIconFonts();
        addCustomProps();
        addMouseEffect();
        super.setIcon(buildIcon());

    }

    private void registerIconFonts() {
        IconFontSwing.register(FontAwesome.getIconFont());
        IconFontSwing.register(GoogleMaterialDesignIcons.getIconFont());
        IconFontSwing.register(Entypo.getIconFont());
        IconFontSwing.register(Iconic.getIconFont());
        IconFontSwing.register(Elusive.getIconFont());
        IconFontSwing.register(Typicons.getIconFont());

    }

    private void addCustomProps() {
        setBorderPainted(false);
        setText("BUTTON");
        setFocusPainted(false);
        setContentAreaFilled(false);
        setHorizontalAlignment(SwingConstants.LEFT);
        setMargin(new Insets(2, 5, 2, 2));
        setIconTextGap(10);
        setCursor(Cursor.getPredefinedCursor(cursor));
        setFont(new Font("Roboto",Font.BOLD,14));
    }

    private void addMouseEffect() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (isDarkMouseEnter()) {

                    setBackground(getBackground().darker());
                } else {
                    setBackground(getBackground().brighter());

                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (isDarkMouseEnter()) {

                    setBackground(getBackground().brighter());
                } else {
                    setBackground(getBackground().darker());

                }
            }

        });
    }

    private Icon buildIcon() {
        if (isEnableIcon()) {
            switch (getSelectedIconFont()) {
                case FontAwesome: {
                    Icon icon = IconFontSwing.buildIcon(FontAwesome.valueOf(getFontAwesomeIcon().toString()), getIconSize(), getIconColor());
                    return icon;
                }
                case GoogleMaterialDesignIcons: {

                    Icon icon = IconFontSwing.buildIcon(GoogleMaterialDesignIcons.valueOf(getGoogleIcon().toString()), getIconSize(), getIconColor());
                    return icon;

                }
                case Entypo: {

                    Icon icon = IconFontSwing.buildIcon(Entypo.valueOf(getEntypoIcon().toString()), getIconSize(), getIconColor());
                    return icon;

                }
                case Iconic: {

                    Icon icon = IconFontSwing.buildIcon(Iconic.valueOf(getIconicIcon().toString()), getIconSize(), getIconColor());
                    return icon;

                }
                case Elusive: {

                    Icon icon = IconFontSwing.buildIcon(Elusive.valueOf(getElusiveIcon().toString()), getIconSize(), getIconColor());
                    return icon;

                }
                case Typicons: {

                    Icon icon = IconFontSwing.buildIcon(Typicons.valueOf(getTypIcon().toString()), getIconSize(), getIconColor());
                    return icon;

                }
                default:
                    break;
            }

        } else {
            return null;
        }
        return null;
    }

}
