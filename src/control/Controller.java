package control;

import model.Facade;
import view.View;

/**
 *
 * @author Muhammad Diallo Thomas - muhammaddiallo.thomas@gmail.com
 */
public class Controller {

    /**
     * View Class object.
     */
    private static final View UI = new Viewer();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Facade.setView(UI);

        UI.setVisible();

        // After window loads, set focus to clear button.
        java.awt.EventQueue.invokeLater(() -> {
            UI.setFocus();
        });
    }

}
