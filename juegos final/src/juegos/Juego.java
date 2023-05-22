import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Juego extends JFrame {
    private JPanel resultadoPanel;
    private JLabel resultadoLabel1;
    private JLabel resultadoLabel2;
    private JLabel resultadoLabel3;
    private JButton jugarDadosButton;
    private JButton jugarTragamonedasButton;
    private boolean dadosEnJuego;
    private boolean tragamonedasEnJuego;

    // Imágenes de los dados
    private ImageIcon[] dados;

    // Imágenes de los símbolos del tragamonedas
    private ImageIcon[] simbolos;

    public Juego() {
        super("Juego de Dados y Tragamonedas");
        dadosEnJuego = false;
        tragamonedasEnJuego = false;
        resultadoPanel = new JPanel();
        resultadoLabel1 = new JLabel();
        resultadoLabel2 = new JLabel();
        resultadoLabel3 = new JLabel();
        jugarDadosButton = new JButton("Jugar Dados");
        jugarTragamonedasButton = new JButton("Jugar Tragamonedas");

        // Cargar imágenes de los dados
        dados = new ImageIcon[6];
        for (int i = 0; i < 6; i++) {
            dados[i] = new ImageIcon("dado_" + (i + 1) + ".png");
        }

        // Cargar imágenes de los símbolos del tragamonedas
        simbolos = new ImageIcon[8];
        simbolos[0] = new ImageIcon("bar.png");
        simbolos[1] = new ImageIcon("7.png");
        simbolos[2] = new ImageIcon("cereza.png");
        simbolos[3] = new ImageIcon("campana.png");
        simbolos[4] = new ImageIcon("diamante.png");
        simbolos[5] = new ImageIcon("naranja.png");
        simbolos[6] = new ImageIcon("limon.png");
        simbolos[7] = new ImageIcon("herradura.png");

        resultadoPanel.setLayout(new GridLayout(1, 3, 10, 10)); // Ajuste de espacio entre componentes
        resultadoPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Ajuste de margen
        resultadoPanel.add(resultadoLabel1);
        resultadoPanel.add(resultadoLabel2);
        resultadoPanel.add(resultadoLabel3);

        jugarDadosButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!dadosEnJuego && !tragamonedasEnJuego) {
                    dadosEnJuego = true;
                    resultadoLabel1.setIcon(null);
                    resultadoLabel2.setIcon(null);
                    resultadoLabel3.setIcon(null);
                    resultadoLabel1.setText("Lanzando dado 1...");
                    resultadoLabel2.setText("Lanzando dado 2...");
                    int[] resultados = lanzarDados();
                    resultadoLabel1.setIcon(dados[resultados[0] - 1]);
                    resultadoLabel1.setText("");
                    resultadoLabel2.setIcon(dados[resultados[1] - 1]);
                    resultadoLabel2.setText("");
                    dadosEnJuego = false;
                }
            }
        });

        jugarTragamonedasButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!dadosEnJuego && !tragamonedasEnJuego) {
                    tragamonedasEnJuego = true;
                    resultadoLabel1.setIcon(null);
                    resultadoLabel2.setIcon(null);
                    resultadoLabel3.setIcon(null);
                    resultadoLabel1.setText("");
                    resultadoLabel2.setText("");
                    resultadoLabel3.setText("");
                    girarTragamonedas();
                    tragamonedasEnJuego = false;
                }
            }
        });

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.add(jugarDadosButton);
        panel.add(jugarTragamonedasButton);

        setLayout(new BorderLayout());
        add(resultadoPanel, BorderLayout.CENTER);
        add(panel, BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 200);
        setVisible(true);
    }

    private int[] lanzarDados() {
        int dado1 = (int) (Math.random() * 6) + 1;
        int dado2 = (int) (Math.random() * 6) + 1;
        int[] resultados = { dado1, dado2 };
        return resultados;
    }

    private void girarTragamonedas() {
        ImageIcon resultado1 = simbolos[(int) (Math.random() * simbolos.length)];
        ImageIcon resultado2 = simbolos[(int) (Math.random() * simbolos.length)];
        ImageIcon resultado3 = simbolos[(int) (Math.random() * simbolos.length)];
        resultadoLabel1.setIcon(resultado1);
        resultadoLabel2.setIcon(resultado2);
        resultadoLabel3.setIcon(resultado3);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Juego();
            }
        });
    }
}
