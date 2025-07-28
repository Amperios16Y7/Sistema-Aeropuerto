package aerodb;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import com.toedter.calendar.JDateChooser;

public class agregarRegistro extends JDialog {

    private List<JComponent> campos;
    private String[] resultado;
    private boolean seGuardo = false;

    
    public agregarRegistro(String[] headers, String[] tipos) {
        setTitle("Agregar Registro");
        setModal(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        campos = new ArrayList<>();
        resultado = new String[headers.length];

        JPanel panelSuperior = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelSuperior.setBackground(Color.WHITE);

        JLabel lblRegresar = new JLabel();
        lblRegresar.setIcon(new ImageIcon(getClass().getResource("/aerodb/returnBlack.png")));
        lblRegresar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lblRegresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dispose();
            }
        });
        panelSuperior.add(lblRegresar);

        JPanel panelCampos = new JPanel(new GridLayout(headers.length, 2, 10, 10));
        panelCampos.setBackground(new Color(0, 153, 255));
        panelCampos.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        Font fuente = new Font("Tw Cen Mt", Font.BOLD, 14);
        Color colorTexto = new Color(255, 255, 255);

        for (int i = 0; i < headers.length; i++) {
            JLabel etiqueta = new JLabel(headers[i] + ":");
            etiqueta.setFont(fuente);
            etiqueta.setForeground(colorTexto);

            JComponent campo;
            if (tipos[i].equalsIgnoreCase("DATE")) {
                JDateChooser dateChooser = new JDateChooser();
                dateChooser.setDateFormatString("yyyy-MM-dd");
                campo = dateChooser;
            } 
            else if(tipos[i].equalsIgnoreCase("ENUM")){
                String[] roles = {"Administrador", "Empleado", "Invitado", "Supervisor"};
                JComboBox<String> comboBox = new JComboBox<>(roles);
                campo = comboBox;
            }
            else {
                JTextField campoTexto = new JTextField();
                campoTexto.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                campoTexto.setBackground(Color.WHITE);
                campo = campoTexto;
            }

            campos.add(campo);
            panelCampos.add(etiqueta);
            panelCampos.add(campo);
        }

        
        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.setBackground(new Color(0, 153, 255));
        btnGuardar.setForeground(Color.WHITE);
        btnGuardar.setFocusPainted(false);
        btnGuardar.setFont(new Font("Segoe UI", Font.BOLD, 14));

        btnGuardar.addActionListener(e -> {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            for (int i = 0; i < campos.size(); i++) {
                if (campos.get(i) instanceof JTextField) {
                    resultado[i] = ((JTextField) campos.get(i)).getText().trim();
                } else if (campos.get(i) instanceof JDateChooser) {
                    java.util.Date date = ((JDateChooser) campos.get(i)).getDate();
                    resultado[i] = (date != null) ? sdf.format(date) : "";
                }
                else if(campos.get(i) instanceof JComboBox){
                    resultado[i] = ((JComboBox) campos.get(i)).getSelectedItem().toString();
                }
            }
            seGuardo = true;
            dispose();
        });


        JPanel panelBoton = new JPanel();
        panelBoton.setBackground(Color.WHITE);
        panelBoton.add(btnGuardar);

        
        setLayout(new BorderLayout());
        add(panelSuperior, BorderLayout.NORTH);
        add(panelCampos, BorderLayout.CENTER);
        add(panelBoton, BorderLayout.SOUTH);

        
        int altura = headers.length * 50 + 120;
        setSize(450, altura);
        setLocationRelativeTo(null);
    }

    public static String[] mostrarYObtener(String[] headers, String[] tipos) {
        agregarRegistro dialogo = new agregarRegistro(headers, tipos);
        dialogo.setVisible(true);

        if (dialogo.seGuardo) {
            String[] valores = dialogo.resultado;

            boolean todoLleno = true;
            for (String val : valores) {
                if (val == null || val.trim().isEmpty()) {
                    todoLleno = false;
                    break;
                }
            }

            if (todoLleno) {
                return valores;
            } else {
                JOptionPane.showMessageDialog(dialogo, "Por favor llena todos los campos", "Advertencia", JOptionPane.WARNING_MESSAGE);
                return null;
            }
        } else {
            return null;
        }
    }

}
