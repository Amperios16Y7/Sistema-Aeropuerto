package aerodb;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Ventana de diálogo para ingresar un ID de registro a eliminar.
 * Retorna el ID como entero mediante el método getIdIngresado().
 * 
 * @author jarqu
 */
public class eliminaRegistro extends JDialog {
    private JTextField campoId;
    private int idIngresado = -1;

    public eliminaRegistro(JFrame parent) {
        super(parent, "Eliminar Registro", true);
        setLayout(new GridLayout(2, 2, 10, 10));
        JLabel etiqueta = new JLabel("ID:");
        campoId = new JTextField();

        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    idIngresado = Integer.parseInt(campoId.getText().trim());
                    dispose();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(eliminaRegistro.this, "ID inválido. Debe ser un número entero.");
                }
            }
        });

        add(etiqueta);
        add(campoId);
        add(new JLabel());
        add(btnGuardar);
        
        getContentPane().setBackground(new Color(0, 153, 255));
        Font fuente = new Font("Tw Cen Mt", Font.BOLD, 14);
        Color colorTexto = new Color(255, 255, 255);
        etiqueta.setFont(fuente);
        etiqueta.setForeground(colorTexto);
        
        setSize(300, 120);
        setLocationRelativeTo(parent);
    }

    /**
     * Devuelve el ID ingresado por el usuario.
     * 
     * @return El ID como entero, o -1 si no se ingresó correctamente.
     */
    public int getIdIngresado() {
        return idIngresado;
    }
}

