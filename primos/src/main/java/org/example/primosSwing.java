package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class primosSwing {
    private JButton iniciarButton;
    private JPanel panel1;
    private JTextField textField1;
    private JTextField textField2;
    private JTextArea resultadoTextArea;

    public primosSwing() {
        iniciarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buscarNumerosPrimos();
            }
        });
    }

    public void buscarNumerosPrimos() {
        String inicioStr = textField1.getText();
        String finStr = textField2.getText();

        try {
            int inicio = Integer.parseInt(inicioStr);
            int fin = Integer.parseInt(finStr);

            if (inicio <= 0 || fin <= 0 || fin < inicio) {
                resultadoTextArea.setText("Por favor, ingresa un intervalo válido.");
            } else {
                int totalPrimos = 0;
                StringBuilder resultados = new StringBuilder("Números primos en el intervalo [" + inicio + ", " + fin + "]:\n");

                for (int num = inicio; num <= fin; num++) {
                    if (esPrimo(num)) {
                        resultados.append(num).append(" ");
                        totalPrimos++;
                    }
                }

                if (totalPrimos == 0) {
                    resultadoTextArea.setText("No se encontraron números primos en el intervalo.");
                } else {
                    resultadoTextArea.setText(resultados.toString());
                }
            }
        } catch (NumberFormatException ex) {
            resultadoTextArea.setText("Por favor, ingresa números válidos.");
        }
    }

    public static boolean esPrimo(int numero) {
        if (numero <= 1) {
            return false;
        }
        if (numero <= 3) {
            return true;
        }
        if (numero % 2 == 0 || numero % 3 == 0) {
            return false;
        }

        int divisor = 5;
        while (divisor * divisor <= numero) {
            if (numero % divisor == 0 || numero % (divisor + 2) == 0) {
                return false;
            }
            divisor += 6;
        }

        return true;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Primos Swing");
        frame.setContentPane(new primosSwing().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
