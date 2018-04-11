import javafx.scene.layout.Border;
import javafx.scene.layout.VBox;
import org.jfree.chart.ChartPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App  {

    public static String fileName;
    public static void main(String args[]) {

        //Creating the Frame
        JFrame frame = new JFrame("Chat Frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(650, 420);

        //Creating the panel at bottom and adding components
        JPanel panel = new JPanel(); // the panel is not visible in output
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));


        JLabel label = new JLabel("File:");
        JLabel labe2 = new JLabel("Parameter:");
        JButton button = new JButton("Execute");

        JComboBox comboBox1 = new JComboBox();
        JComboBox comboBox2 = new JComboBox();

        comboBox1.addItem("SOB.LAS");
        comboBox1.addItem("K.las");
        comboBox1.addItem("W.LAS");


        panel.add(label); // Components Added using Flow Layout
        panel.add(comboBox1); // Components Added using Flow Layout
        panel.add(labe2); // Components Added using Flow Layout
        panel.add(comboBox2); // Components Added using Flow Layout
        panel.add(button);

        JPanel panel2 = new JPanel();
        XYLineChart_AWT chart = new XYLineChart_AWT();
        ChartPanel chartPanel = XYLineChart_AWT.chartPanel;

        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                fileName = (String) comboBox1.getSelectedItem();
                System.out.println(fileName);

                setReader();

                for(String s : Reader.parameters )
                {
                    if(!s.equals("DEPT"))
                    comboBox2.addItem(s);
                }

            }
        });

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel2.add(XYLineChart_AWT.chartPanel);
                frame.getContentPane().add(BorderLayout.CENTER, panel2);
                SwingUtilities.updateComponentTreeUI(frame);
            }
        });


        //dodajemy pane dla charta



//        JScrollPane jScrollPane = new JScrollPane(chartPanel);
//        jScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
//        panel2.add(jScrollPane);





        // Text Area at the Center
        JTextArea ta = new JTextArea();

        //Adding Components to the frame.
        frame.getContentPane().add(BorderLayout.EAST, panel);

        //frame.getContentPane().add(BorderLayout.CENTER, ta);
        frame.setVisible(true);
    }

    public static void setReader()
    {
        Reader reader = new Reader();

        reader.ReadFromFile(fileName);


//        for(String s : reader.parameters)
//            System.out.println(s);
    }
}
