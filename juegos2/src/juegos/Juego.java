import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Juego extends JFrame {
    private JLabel resultadoLabel;
    private JButton jugarDadosButton;
    private JButton jugarTragamonedasButton;
    private boolean dadosEnJuego;
    private boolean tragamonedasEnJuego;

    public Juego() {
        super("Juego de Dados y Tragamonedas");
        dadosEnJuego = false;
        tragamonedasEnJuego = false;
        resultadoLabel = new JLabel("Presiona un botón para comenzar");
        jugarDadosButton = new JButton("Jugar Dados");
        jugarTragamonedasButton = new JButton("Jugar Tragamonedas");

        jugarDadosButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!dadosEnJuego && !tragamonedasEnJuego) {
                    dadosEnJuego = true;
                    resultadoLabel.setText("Lanzando dados...");
                    int[] resultados = lanzarDados();
                    resultadoLabel.setText("El resultado de los dados es: Dado 1 = " + resultados[0] + ", Dado 2 = " + resultados[1]);
                    dadosEnJuego = false;
                }
            }
        });

        jugarTragamonedasButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!dadosEnJuego && !tragamonedasEnJuego) {
                    tragamonedasEnJuego = true;
                    resultadoLabel.setText("Girando los rodillos...");
                    String resultado = girarTragamonedas();
                    resultadoLabel.setText("El resultado del tragamonedas es: " + resultado);
                    tragamonedasEnJuego = false;
                }
            }
        });

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.add(jugarDadosButton);
        panel.add(jugarTragamonedasButton);

        setLayout(new BorderLayout());
        add(resultadoLabel, BorderLayout.CENTER);
        add(panel, BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setVisible(true);
    }

    private int[] lanzarDados() {
        int dado1 = (int) (Math.random() * 6) + 1;
        int dado2 = (int) (Math.random() * 6) + 1;
        int[] resultados = { dado1, dado2 };
        return resultados;
    }

    private String girarTragamonedas() {
        String[] simbolos = { "BAR", "7", "🍒", "🔔", "💎" };
        int r1 = (int) (Math.random() * simbolos.length);
        int r2 = (int) (Math.random() * simbolos.length);
        int r3 = (int) (Math.random() * simbolos.length);
        return simbolos[r1] + " - " + simbolos[r2] + " - " + simbolos[r3];
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Juego();
            }
        });
    }
}
