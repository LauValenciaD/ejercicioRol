package rol;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;

public class FormRaza extends JInternalFrame {
	private static final long serialVersionUID = 1L; // Agregar serialVersionUID

    private JTextField txtNombreRaza;
    private JComboBox<String> comboBoxCaracteristica;
    private JComboBox<Integer> comboBoxBonificador;
    private JButton btnGuardar;
    private JButton btnVolver;

    public FormRaza() {
        super("Crear Raza", false, true, false, false);
        setBounds(50, 50, 391, 328);
        getContentPane().setLayout(null);

        // Crear los campos del formulario 1
        JLabel lblNombreRaza = new JLabel("Nombre de la Raza:");
        lblNombreRaza.setBounds(10, 10, 150, 30);
        getContentPane().add(lblNombreRaza);

        txtNombreRaza = new JTextField();
        txtNombreRaza.setBounds(170, 10, 120, 30);
        getContentPane().add(txtNombreRaza);

        JLabel lblCaracteristica = new JLabel("Característica:");
        lblCaracteristica.setBounds(10, 50, 100, 30);
        getContentPane().add(lblCaracteristica);

        comboBoxCaracteristica = new JComboBox<>(new String[]{"Fue", "Des", "Con", "Sab", "Int", "Car"});
        comboBoxCaracteristica.setBounds(170, 50, 120, 30);
        getContentPane().add(comboBoxCaracteristica);

        JLabel lblBonificador = new JLabel("Bonificador (1-3):");
        lblBonificador.setBounds(10, 90, 150, 30);
        getContentPane().add(lblBonificador);

        comboBoxBonificador = new JComboBox<>(new Integer[]{1, 2, 3});
        comboBoxBonificador.setBounds(170, 90, 50, 30);
        getContentPane().add(comboBoxBonificador);

        // Crear botones "Guardar" y "Volver"
        btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(89, 130, 100, 30);
        getContentPane().add(btnGuardar);

        btnVolver = new JButton("Volver");
        btnVolver.setBounds(200, 130, 100, 30);
        getContentPane().add(btnVolver);
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon(FormRaza.class.getResource("/images/wizard (1).gif")));
        lblNewLabel.setBounds(127, 170, 120, 120);
        getContentPane().add(lblNewLabel);
        
        btnGuardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	String nombre = txtNombreRaza.getText();
            	String caracteristica = (String) comboBoxCaracteristica.getSelectedItem();
            	int bono =  (int) comboBoxBonificador.getSelectedItem();
            	
                Raza nuevaRaza = new Raza(nombre, caracteristica, bono);
            	GUI.razasCreadas.add(nuevaRaza);
            	GUI.comboBoxModel.addElement(nuevaRaza.getNombre());
            	    
            	
                JOptionPane.showMessageDialog(btnGuardar, "Raza " + nombre + " con bonificador "+ caracteristica + bono + " creada correctamente.");
            }
        });

        // Agregar ActionListener al botón "Volver"
        btnVolver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
    }
}
