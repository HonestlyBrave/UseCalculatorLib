package control;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import view.View;

/**
 *
 * @author Muhammad Diallo Thomas - muhammaddiallo.thomas@gmail.com
 */
public class Viewer extends JFrame implements View {

    /**
     * Calculator panels.
     */
    private JPanel jpMain, jpFirst, jpSecond;

    /**
     * Calculator buttons.
     */
    private JButton jb0, jb1, jb2, jb3, jb4, jb5, jb6, jb7, jb8, jb9, jbDecimal;

    /**
     * Calculator buttons.
     */
    private JButton jbSolve, jbAdd, jbSubtract, jbMultiply, jbDivide;

    /**
     * Calculator buttons.
     */
    private JButton jbClear, jbMemAdd, jbMemMinus, jbMemRecall, jbMemClear;

    /**
     * Calculator buttons.
     */
    private JButton jbOpenPara, jbClosePara, jbUndo;

    /**
     * Calculator display.
     */
    private JTextField jtDisplayBox;

    /**
     * Constructor.
     */
    public Viewer() {
        setWidgets();
        setListeneres();
    }

    /**
     * Components.
     */
    private void setWidgets() {
        jpMain = new JPanel(new GridLayout(2, 1, 10, 10));

        add(jpMain);

        jpFirst = new JPanel(new BorderLayout());
        jpSecond = new JPanel(new GridLayout(6, 4, 5, 5));

        jpMain.add(jpFirst);
        jpMain.add(jpSecond);

        jtDisplayBox = new JTextField("");
        jtDisplayBox.setEditable(false);
        jtDisplayBox.setHorizontalAlignment(JTextField.RIGHT);
        jtDisplayBox.setFont(new Font("Arial", Font.TRUETYPE_FONT, 32));

        jpFirst.add(jtDisplayBox, BorderLayout.CENTER);

        jb0 = aButton("0");
        jb1 = aButton("1");
        jb2 = aButton("2");
        jb3 = aButton("3");
        jb4 = aButton("4");
        jb5 = aButton("5");
        jb6 = aButton("6");
        jb7 = aButton("7");
        jb8 = aButton("8");
        jb9 = aButton("9");
        jbAdd = aButton("+");
        jbAdd.setActionCommand("10"); // Override default ActionCommand string.
        jbClear = aButton("Clear");
        jbClear.setActionCommand("11");
        jbDecimal = aButton(".");
        jbDecimal.setActionCommand("12");
        jbDivide = aButton("÷");
        jbDivide.setActionCommand("13");
        jbMemAdd = aButton("M+");
        jbMemAdd.setActionCommand("14");
        jbMemMinus = aButton("M-");
        jbMemMinus.setActionCommand("15");
        jbMemRecall = aButton("MR");
        jbMemRecall.setActionCommand("16");
        jbSubtract = aButton("-");
        jbSubtract.setActionCommand("17");
        jbMultiply = aButton("ˣ");
        jbMultiply.setActionCommand("18");
        jbSolve = aButton("=");
        jbSolve.setActionCommand("19");
        jbMemClear = aButton("MC");
        jbMemClear.setActionCommand("20");
        jbUndo = aButton("Undo");
        jbUndo.setActionCommand("21");
        jbOpenPara = aButton("(");
        jbOpenPara.setActionCommand("22");
        jbClosePara = aButton(")");
        jbClosePara.setActionCommand("23");

        jpSecond.add(jb1);
        jpSecond.add(jb2);
        jpSecond.add(jb3);
        jpSecond.add(jbAdd);
        jpSecond.add(jb4);
        jpSecond.add(jb5);
        jpSecond.add(jb6);
        jpSecond.add(jbSubtract);
        jpSecond.add(jb7);
        jpSecond.add(jb8);
        jpSecond.add(jb9);
        jpSecond.add(jbMultiply);
        jpSecond.add(jb0);
        jpSecond.add(jbDecimal);
        jpSecond.add(jbSolve);
        jpSecond.add(jbDivide);
        jpSecond.add(jbClear);
        jpSecond.add(jbUndo);
        jpSecond.add(jbOpenPara);
        jpSecond.add(jbClosePara);
        jpSecond.add(jbMemAdd);
        jpSecond.add(jbMemMinus);
        jpSecond.add(jbMemRecall);
        jpSecond.add(jbMemClear);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(600, 400));
        setTitle("Supreme Calculator");
        setLocationRelativeTo(null);
    }

    /**
     * Listeners.
     */
    private void setListeneres() {
        // Add listeners to components in a specific panel.
        for (Component comp : jpSecond.getComponents()) {
            if (comp.getClass().equals(JButton.class)) {
                ((JButton) comp).addActionListener(new ActionListeners());
                ((JButton) comp).addKeyListener(new KeyListeners());
            }
        }

    }

    @Override
    public void setVisible() {
        setVisible(true);
    }

    @Override
    public void setFocus() {
        jbClear.requestFocus();
    }

    @Override
    public String getDisplay() {
        return jtDisplayBox.getText();
    }

    @Override
    public void setDisplay(String text) {
        jtDisplayBox.setText(text);
    }

    @Override
    public void updateDisplay(String text) {
        jtDisplayBox.setText(getDisplay() + text);
    }

    /**
     * Standard button with an accompanying ActionCommand string for listeners.
     *
     * @param string text to display on button
     * @return a JButton
     */
    private JButton aButton(String string) {
        // Apply string to button.
        JButton tmp = new JButton(string);

        // Set string to action command.
        tmp.setActionCommand(string);

        // Return new button.
        return tmp;
    }

}
