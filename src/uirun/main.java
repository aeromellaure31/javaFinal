/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uirun;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
/*from   w  ww  .  j a v  a2 s .  co m*/
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class main extends JFrame {

    public main() {
        setSize(200, 200);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent evt) {
                Object[] options = {"Quit, My Computing Fellow",
                    "No, I want to Work more"};

                int answer = JOptionPane.showOptionDialog(main.this,
                        "What would you like to do? ", "Quit:Continue",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                        options, options[1]);
                if (answer == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });
    }

    public static void main(String st[]) {
        main mf = new main();
        mf.setVisible(true);
    }
}
