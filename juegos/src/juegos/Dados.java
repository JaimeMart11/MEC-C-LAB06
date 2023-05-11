import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Dados extends JFrame implements ActionListener {

    private JButton btnLanzar;
    private JLabel lblDado1, lblDado2;

    public Dados() {
        // Configuración de la ventana
        setTitle("Lanzamiento de Dados");
        setSize(300, 150);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Configuración de los componentes
        btnLanzar = new JButton("Lanzar");
        lblDado1 = new JLabel("");
        lblDado2 = new JLabel("");

        // Configuración del layout
        setLayout(new GridLayout(3, 2));

        // Agregar los componentes a la ventana
        add(new JLabel("Dado 1:"));
        add(lblDado1);
        add(new JLabel("Dado 2:"));
        add(lblDado2);
        add(new JLabel(""));
        add(btnLanzar);

        // Agregar el listener al botón
        btnLanzar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Generar los valores aleatorios de los dados
        int dado1 = (int) (Math.random() * 6) + 1;
        int dado2 = (int) (Math.random() * 6) + 1;

        // Actualizar las etiquetas con los valores de los dados
        lblDado1.setText(String.valueOf(dado1));
        lblDado2.setText(String.valueOf(dado2));
    }

    public static void main(String[] args) {
        // Crear la ventana y hacerla visible
        Dados ventana = new Dados();
        ventana.setVisible(true);
    }
}
