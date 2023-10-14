import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TikTakToe {

    // x tracks the turn, eg.- X's turn or Y's turn
    public static boolean x = true;

    public static int x_current_score = 0;
    public static int y_current_score = 0;

    public static void main(String[] args) {

        // --- SETTING UP ---
        // main frame
        JFrame main_frame = new JFrame("Tik Tak Toe");
        main_frame.setResizable(false);
        main_frame.setLayout(new BorderLayout());
        main_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // main panel
        JPanel main_panel = new JPanel(new GridLayout(3, 3));
        main_panel.setPreferredSize(new Dimension(750, 750));
        main_panel.setMaximumSize(new Dimension(750, 750));

        // score panel
        JPanel score_panel = new JPanel(new FlowLayout());
        score_panel.setPreferredSize(new Dimension(750, 40));
        score_panel.setMaximumSize(new Dimension(750, 40));

        // score labels
        JLabel x_label = new JLabel("X Score: ");
        JLabel y_label = new JLabel("Y Score: ");
        JLabel x_score = new JLabel("0");
        JLabel y_score = new JLabel("0");
        JLabel label_gap = new JLabel("                 ");

        // label font
        Font label_font = new Font("Serif", Font.BOLD, 20);
        x_label.setFont(label_font);
        y_label.setFont(label_font);
        x_score.setFont(label_font);
        y_score.setFont(label_font);
        label_gap.setFont(label_font);
        

        // adding the labels to the panel
        score_panel.add(x_label);
        score_panel.add(x_score);
        score_panel.add(label_gap);
        score_panel.add(y_label);
        score_panel.add(y_score);


        // buttons
        JButton button00 = new JButton();
        JButton button01 = new JButton();
        JButton button02 = new JButton();

        JButton button10 = new JButton();
        JButton button11 = new JButton();
        JButton button12 = new JButton();

        JButton button20 = new JButton();
        JButton button21 = new JButton();
        JButton button22 = new JButton();
        
        // font for buttons
        Font button_font = new Font(null, Font.BOLD, 70);
        button00.setFont(button_font);
        button01.setFont(button_font);
        button02.setFont(button_font);
        button10.setFont(button_font);
        button11.setFont(button_font);
        button12.setFont(button_font);
        button20.setFont(button_font);
        button21.setFont(button_font);
        button22.setFont(button_font);

        // adding the buttons to the main panel
        main_panel.add(button00);
        main_panel.add(button01);
        main_panel.add(button02);

        main_panel.add(button10);
        main_panel.add(button11);
        main_panel.add(button12);

        main_panel.add(button20);
        main_panel.add(button21);
        main_panel.add(button22);
        
        main_frame.add(score_panel, BorderLayout.NORTH);
        main_frame.add(main_panel, BorderLayout.CENTER);
        main_frame.pack();
        main_frame.setLocationRelativeTo(null);
        main_frame.setVisible(true);

        

        // action listeners
        button00.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (x && button00.getText().equals("")) {
                    button00.setText("X");
                    button00.setForeground(Color.RED);
                    setX(false);
                }
                else if (button00.getText().equals("")) {
                    button00.setText("O");
                    button00.setForeground(Color.BLUE);
                    setX(true);
                }

                if (hasWon(button00, button01, button02) || hasWon(button00, button10, button20) || hasWon(button00, button11, button22)) {
                    JOptionPane.showMessageDialog(main_frame, button00.getText() + " has won!", "Result", JOptionPane.INFORMATION_MESSAGE);

                    button00.setText("");
                    button01.setText("");
                    button02.setText("");
                    button10.setText("");
                    button11.setText("");
                    button12.setText("");
                    button20.setText("");
                    button21.setText("");
                    button22.setText("");

                    x_score.setText(Integer.toString(x_current_score));
                    y_score.setText(Integer.toString(y_current_score));
                    setX(true);
                }
                else if (draw(main_panel)) {
                    JOptionPane.showMessageDialog(main_frame, "Draw!", "Result", JOptionPane.WARNING_MESSAGE);
                    
                    button00.setText("");
                    button01.setText("");
                    button02.setText("");
                    button10.setText("");
                    button11.setText("");
                    button12.setText("");
                    button20.setText("");
                    button21.setText("");
                    button22.setText("");
                    setX(true);
                }
            }
        });

        button01.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (x && button01.getText().equals("")) {
                    button01.setText("X");
                    button01.setForeground(Color.RED);
                    setX(false);
                }
                else if (button01.getText().equals("")) {
                    button01.setText("O");
                    button01.setForeground(Color.BLUE);
                    setX(true);
                }

                if (hasWon(button00, button01, button02) || hasWon(button01, button11, button21)) {
                    JOptionPane.showMessageDialog(main_frame, button01.getText() + " has won!", "Result", JOptionPane.INFORMATION_MESSAGE);

                    button00.setText("");
                    button01.setText("");
                    button02.setText("");
                    button10.setText("");
                    button11.setText("");
                    button12.setText("");
                    button20.setText("");
                    button21.setText("");
                    button22.setText("");

                    x_score.setText(Integer.toString(x_current_score));
                    y_score.setText(Integer.toString(y_current_score));
                    setX(true);
                }
                else if (draw(main_panel)) {
                    JOptionPane.showMessageDialog(main_frame, "Draw!", "Result", JOptionPane.WARNING_MESSAGE);

                    button00.setText("");
                    button01.setText("");
                    button02.setText("");
                    button10.setText("");
                    button11.setText("");
                    button12.setText("");
                    button20.setText("");
                    button21.setText("");
                    button22.setText("");
                    setX(true);
                }
            }
        });

        button02.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (x && button02.getText().equals("")) {
                    button02.setText("X");
                    button02.setForeground(Color.RED);
                    setX(false);
                }
                else if (button02.getText().equals("")) {
                    button02.setText("O");
                    button02.setForeground(Color.BLUE);
                    setX(true);
                }

                if (hasWon(button00, button01, button02) || hasWon(button02, button12, button22) || hasWon(button02, button11, button20)) {
                    JOptionPane.showMessageDialog(main_frame, button02.getText() + " has won!", "Result", JOptionPane.INFORMATION_MESSAGE);

                    button00.setText("");
                    button01.setText("");
                    button02.setText("");
                    button10.setText("");
                    button11.setText("");
                    button12.setText("");
                    button20.setText("");
                    button21.setText("");
                    button22.setText("");

                    x_score.setText(Integer.toString(x_current_score));
                    y_score.setText(Integer.toString(y_current_score));
                    setX(true);
                }
                else if (draw(main_panel)) {
                    JOptionPane.showMessageDialog(main_frame, "Draw!", "Result", JOptionPane.WARNING_MESSAGE);

                    button00.setText("");
                    button01.setText("");
                    button02.setText("");
                    button10.setText("");
                    button11.setText("");
                    button12.setText("");
                    button20.setText("");
                    button21.setText("");
                    button22.setText("");
                    setX(true);
                }
            }
        });

        button10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (x && button10.getText().equals("")) {
                    button10.setText("X");
                    button10.setForeground(Color.RED);
                    setX(false);
                }
                else if (button10.getText().equals("")) {
                    button10.setText("O");
                    button10.setForeground(Color.BLUE);
                    setX(true);
                }

                if (hasWon(button00, button10, button20) || hasWon(button10, button11, button12)) {
                    JOptionPane.showMessageDialog(main_frame, button10.getText() + " has won!", "Result", JOptionPane.INFORMATION_MESSAGE);

                    button00.setText("");
                    button01.setText("");
                    button02.setText("");
                    button10.setText("");
                    button11.setText("");
                    button12.setText("");
                    button20.setText("");
                    button21.setText("");
                    button22.setText("");

                    x_score.setText(Integer.toString(x_current_score));
                    y_score.setText(Integer.toString(y_current_score));
                    setX(true);
                }
                else if (draw(main_panel)) {
                    JOptionPane.showMessageDialog(main_frame, "Draw!", "Result", JOptionPane.WARNING_MESSAGE);

                    button00.setText("");
                    button01.setText("");
                    button02.setText("");
                    button10.setText("");
                    button11.setText("");
                    button12.setText("");
                    button20.setText("");
                    button21.setText("");
                    button22.setText("");
                    setX(true);
                }
            }
        });

        button11.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (x && button11.getText().equals("")) {
                    button11.setText("X");
                    button11.setForeground(Color.RED);
                    setX(false);
                }
                else if (button11.getText().equals("")) {
                    button11.setText("O");
                    button11.setForeground(Color.BLUE);
                    setX(true);
                }

                if (hasWon(button10, button11, button12) || hasWon(button01, button11, button21) || hasWon(button00, button11, button22) || hasWon(button02, button11, button20)) {
                    JOptionPane.showMessageDialog(main_frame, button11.getText() + " has won!", "Result", JOptionPane.INFORMATION_MESSAGE);

                    button00.setText("");
                    button01.setText("");
                    button02.setText("");
                    button10.setText("");
                    button11.setText("");
                    button12.setText("");
                    button20.setText("");
                    button21.setText("");
                    button22.setText("");

                    x_score.setText(Integer.toString(x_current_score));
                    y_score.setText(Integer.toString(y_current_score));
                    setX(true);
                }
                else if (draw(main_panel)) {
                    JOptionPane.showMessageDialog(main_frame, "Draw!", "Result", JOptionPane.WARNING_MESSAGE);

                    button00.setText("");
                    button01.setText("");
                    button02.setText("");
                    button10.setText("");
                    button11.setText("");
                    button12.setText("");
                    button20.setText("");
                    button21.setText("");
                    button22.setText("");
                    setX(true);
                }
            }
        });

        button12.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (x && button12.getText().equals("")) {
                    button12.setText("X");
                    button12.setForeground(Color.RED);
                    setX(false);
                }
                else if (button12.getText().equals("")) {
                    button12.setText("O");
                    button12.setForeground(Color.BLUE);
                    setX(true);
                }

                if (hasWon(button02, button12, button22) || hasWon(button10, button11, button12)) {
                    JOptionPane.showMessageDialog(main_frame, button12.getText() + " has won!", "Result", JOptionPane.INFORMATION_MESSAGE);

                    button00.setText("");
                    button01.setText("");
                    button02.setText("");
                    button10.setText("");
                    button11.setText("");
                    button12.setText("");
                    button20.setText("");
                    button21.setText("");
                    button22.setText("");

                    x_score.setText(Integer.toString(x_current_score));
                    y_score.setText(Integer.toString(y_current_score));
                    setX(true);
                }
                else if (draw(main_panel)) {
                    JOptionPane.showMessageDialog(main_frame, "Draw!", "Result", JOptionPane.WARNING_MESSAGE);

                    button00.setText("");
                    button01.setText("");
                    button02.setText("");
                    button10.setText("");
                    button11.setText("");
                    button12.setText("");
                    button20.setText("");
                    button21.setText("");
                    button22.setText("");
                    setX(true);
                }
            }
        });

        button20.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (x && button20.getText().equals("")) {
                    button20.setText("X");
                    button20.setForeground(Color.RED);
                    setX(false);
                }
                else if (button20.getText().equals("")) {
                    button20.setText("O");
                    button20.setForeground(Color.BLUE);
                    setX(true);
                }

                if (hasWon(button20, button21, button22) || hasWon(button00, button10, button20) || hasWon(button20, button11, button02)) {
                    JOptionPane.showMessageDialog(main_frame, button20.getText() + " has won!", "Result", JOptionPane.INFORMATION_MESSAGE);

                    button00.setText("");
                    button01.setText("");
                    button02.setText("");
                    button10.setText("");
                    button11.setText("");
                    button12.setText("");
                    button20.setText("");
                    button21.setText("");
                    button22.setText("");

                    x_score.setText(Integer.toString(x_current_score));
                    y_score.setText(Integer.toString(y_current_score));
                    setX(true);
                }
                else if (draw(main_panel)) {
                    JOptionPane.showMessageDialog(main_frame, "Draw!", "Result", JOptionPane.WARNING_MESSAGE);

                    button00.setText("");
                    button01.setText("");
                    button02.setText("");
                    button10.setText("");
                    button11.setText("");
                    button12.setText("");
                    button20.setText("");
                    button21.setText("");
                    button22.setText("");
                    setX(true);
                }
            }
        });

        button21.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (x && button21.getText().equals("")) {
                    button21.setText("X");
                    button21.setForeground(Color.RED);
                    setX(false);
                }
                else if (button21.getText().equals("")) {
                    button21.setText("O");
                    button21.setForeground(Color.BLUE);
                    setX(true);
                }

                if (hasWon(button20, button21, button22) || hasWon(button21, button11, button01)) {
                    JOptionPane.showMessageDialog(main_frame, button21.getText() + " has won!", "Result", JOptionPane.INFORMATION_MESSAGE);

                    button00.setText("");
                    button01.setText("");
                    button02.setText("");
                    button10.setText("");
                    button11.setText("");
                    button12.setText("");
                    button20.setText("");
                    button21.setText("");
                    button22.setText("");

                    x_score.setText(Integer.toString(x_current_score));
                    y_score.setText(Integer.toString(y_current_score));
                    setX(true);
                }
                else if (draw(main_panel)) {
                    JOptionPane.showMessageDialog(main_frame, "Draw!", "Result", JOptionPane.WARNING_MESSAGE);

                    button00.setText("");
                    button01.setText("");
                    button02.setText("");
                    button10.setText("");
                    button11.setText("");
                    button12.setText("");
                    button20.setText("");
                    button21.setText("");
                    button22.setText("");
                    setX(true);
                }
            }
        });

        button22.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (x && button22.getText().equals("")) {
                    button22.setText("X");
                    button22.setForeground(Color.RED);
                    setX(false);
                }
                else if (button22.getText().equals("")) {
                    button22.setText("O");
                    button22.setForeground(Color.BLUE);
                    setX(true);
                }

                if (hasWon(button20, button21, button22) || hasWon(button02, button12, button22) || hasWon(button00, button11, button22)) {
                    JOptionPane.showMessageDialog(main_frame, button22.getText() + " has won!", "Result", JOptionPane.INFORMATION_MESSAGE);

                    button00.setText("");
                    button01.setText("");
                    button02.setText("");
                    button10.setText("");
                    button11.setText("");
                    button12.setText("");
                    button20.setText("");
                    button21.setText("");
                    button22.setText("");

                    x_score.setText(Integer.toString(x_current_score));
                    y_score.setText(Integer.toString(y_current_score));
                    setX(true);
                }
                else if (draw(main_panel)) {
                    JOptionPane.showMessageDialog(main_frame, "Draw!", "Result", JOptionPane.WARNING_MESSAGE);

                    button00.setText("");
                    button01.setText("");
                    button02.setText("");
                    button10.setText("");
                    button11.setText("");
                    button12.setText("");
                    button20.setText("");
                    button21.setText("");
                    button22.setText("");
                    setX(true);
                }
            }
        });
    }

    public static void setX(boolean x_val)
    {
        x = x_val;
    }

    public static boolean hasWon(JButton button1, JButton button2, JButton button3) {
        if (button1.getText() == button2.getText() && button2.getText() == button3.getText()) {
            if (button1.getText().equals("X"))
                x_current_score++;
            else
                y_current_score++;

            return true;
        }
        else
            return false;
    }

    public static boolean draw(JPanel p) {
        for (Component comp : p.getComponents()) {
            if (comp instanceof JButton && ((JButton)comp).getText().equals("")) {
                return false;
            }
        }

        return true;
    }
}