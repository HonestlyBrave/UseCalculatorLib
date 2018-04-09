package control;

import command.Command;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import org.springframework.stereotype.Service;

/**
 * Listener for all buttons to execute their respective commands.
 *
 * @author Muhammad Diallo Thomas - muhammaddiallo.thomas@gmail.com
 */
@Service("actionListeners")
public class ActionListeners implements ActionListener {

    /**
     * Utility class.
     */
    private final CommandsResource cmdR = new CommandsResource();

    /**
     * Array of Command objects.
     */
    private final Command[] commands = cmdR.getCommands();

    /**
     * Utilize the action command string to retrieve and execute the
     * corresponding command.
     *
     * @param e event arguments
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().getClass().equals(JButton.class)) {
            String x = e.getActionCommand();
            int index = Integer.parseInt(x);
            commands[index].execute();
        }
    }
}
