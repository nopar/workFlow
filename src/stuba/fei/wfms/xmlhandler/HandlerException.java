package stuba.fei.wfms.xmlhandler;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Class for building all exceptions from HandlerXML class into GUI prompts.
 * @author Matej Pivarci
 */
public class HandlerException { 

    /**
     * Default constructor
     */
    public HandlerException(){
    }
    
    /**
     * Method for building new dialog box inside given frame with
     * provided exception message.
     * @param frame Parent JFrame
     * @param msg Exception message
     */
    public static void showDialog(JFrame frame, String msg) {
        JOptionPane.showMessageDialog(
            frame, 
            msg, 
            "Error!", 
            JOptionPane.ERROR_MESSAGE);
    }
    
    public static void showInfoStatus(JFrame frame, String msg, String title) {
        JOptionPane.showMessageDialog(
            frame, 
            msg, 
            title, 
            JOptionPane.INFORMATION_MESSAGE);
    }
    
}