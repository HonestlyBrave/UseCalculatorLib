package control;

import model.Facade;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import view.View;

/**
 *
 * @author Muhammad Diallo Thomas - muhammaddiallo.thomas@gmail.com
 */
public class Controller {

    /**
     * Spring context.
     */
    private static final ApplicationContext CTX =
            new ClassPathXmlApplicationContext(
                    "classpath:/control/beans.xml");

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
