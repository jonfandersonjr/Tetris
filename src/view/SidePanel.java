/*
 * TCSS 305 Tetris.
 */
package view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Class that creates the panel that will be holding the non-active game information.
 * 
 * @author Jon Anderson
 * @version May 19
 *
 */

public class SidePanel extends JPanel {

//    implements Observer 
    
    /**
     * Auto generated serial ID.
     */
    private static final long serialVersionUID = 4811726021988067944L;

    /**
     * Amount of rows in this grid panel layout.
     */
    private static final int PANELS = 3;

    /**
     * Amount of rows of labels.
     */
    private static final int LABEL_ROWS = 7;

    /**
     * Modifies the size of the labels using the block size.
     */
    private static final double LABEL_SIZE_MODIFIER = 1.5;
    
    /**
     * Amount of plain fonts.
     */
    private static final int PLAIN_FONTS = 6;

    /**
     * Width of the borders in this panel.
     */
    private static final BasicStroke BORDER_WIDTH = new BasicStroke(3);

    /**
     * Uses the block size to determine sizes of labels etc.
     */
    private final int myBlockSize;

    /**
     * List containing all of my labels in this panel.
     */
    private final List<JLabel> myLabels = new ArrayList<JLabel>();

    /**
     * Label for the left control.
     */
    private final JLabel myControlLeft = addLabel("     \u2190 / A");

    /**
     * Label for the right control.
     */
    private final JLabel myControlRight = addLabel("     \u2192 / D");

    /**
     * Label for the down control.
     */
    private final JLabel myControlDown = addLabel("     \u2193 / S");

    /**
     * Label for the drop control.
     */
    private final JLabel myControlCW = addLabel("     \u2191 / W");

    /**
     * Label for the drop control.
     */
    private final JLabel myControlCCW = addLabel("     Shift");
    
    /**
     * Label for the drop control.
     */
    private final JLabel myControlDrop = addLabel("     Space");

    /**
     * Label for the pause control.
     */
    private final JLabel myControlPause = addLabel("     P");

    /**
     * Constructs a piece panel for the right side of the game frame.
     * @param theBlockSize for determining panel and label sizes.
     * @param theNextPiecePanel to be added to the side panel.
     * @param theScorePanel to be added to the side panel.
     */
    public SidePanel(final int theBlockSize, final JPanel theNextPiecePanel,
                     final ScorePanel theScorePanel) {
        super();
        myBlockSize = theBlockSize;
        setLayout(new GridLayout(PANELS, 1));
        add(theNextPiecePanel);
        add(createInstructionsPanel());
        add(theScorePanel);
        setLabelFont();
        setBackground(Color.darkGray);
    }

    /**
     * Constructs an instruction panel containing labels for controls.
     * @return an instructions panel.
     */
    private JPanel createInstructionsPanel() {
        final JPanel panel = new JPanel();
        final JPanel gridPanel = new JPanel();
        gridPanel.setLayout(new GridLayout(LABEL_ROWS, 2));
        gridPanel.add(addLabel("Move Left: "));
        gridPanel.add(myControlLeft);
        gridPanel.add(addLabel("Move Right: "));
        gridPanel.add(myControlRight);
        gridPanel.add(addLabel("Move Down: "));
        gridPanel.add(myControlDown);
        gridPanel.add(addLabel("Rotate CW: "));
        gridPanel.add(myControlCW);
        gridPanel.add(addLabel("Rotate CCW: "));
        gridPanel.add(myControlCCW);
        gridPanel.add(addLabel("Drop Piece: "));
        gridPanel.add(myControlDrop);
        gridPanel.add(addLabel("Pause Game: "));
        gridPanel.add(myControlPause);

        panel.add(gridPanel);
        panel.setBorder(BorderFactory.createStrokeBorder(BORDER_WIDTH));
        return panel;
    }

    /**
     * Creates a label and adds it to myLabel list.
     * @param theLabel name for the created label.
     * @return the created label.
     */
    private JLabel addLabel(final String theLabel) {
        final JLabel label = new JLabel(theLabel);
        myLabels.add(label);
        return label;
    }

    /**
     * Sets the fonts for all the labels.
     */
    private void setLabelFont() {
        final Font boldFont = new Font(Font.SERIF, Font.BOLD,
                                       (int) (myBlockSize / LABEL_SIZE_MODIFIER));
        final Font plainFont = new Font("Osaka", Font.ITALIC,
                                        (int) (myBlockSize / LABEL_SIZE_MODIFIER));
        int count = 0;
        for (final JLabel label: myLabels) {
            label.setFont(plainFont);
            if (count > PLAIN_FONTS) {
                label.setFont(boldFont);
            }
            count++;
        }
    }

}
