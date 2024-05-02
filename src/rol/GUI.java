package rol;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.util.ArrayList;
import java.util.List;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.LineBorder;

public class GUI extends JFrame {
	private static final long serialVersionUID = 1L; // Agregar serialVersionUID
    private JDesktopPane desktopPane;
    private JRadioButton radioOpcion1;
    private JRadioButton radioOpcion2;
    private JRadioButton radioOpcion3;
    private JRadioButton radioOpcion4;
    private JRadioButton radioOpcion5;
    private JButton btnConfirmar;
    private JLabel lblNewLabel;
    private JLabel lblTiutlo;
    public static List<Raza> razasCreadas = new ArrayList<>();
    public static List<Personaje> personajesCreados = new ArrayList<>();
    public static DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>();


    public static void main(String[] args) {
        Raza elfo = new Raza("Elfo", "Des", 2);
    	GUI.razasCreadas.add(elfo);
    	GUI.comboBoxModel.addElement("Elfo");
        Raza dragon = new Raza("Dragon", "Fue", 3);
    	GUI.razasCreadas.add(dragon);
    	GUI.comboBoxModel.addElement("Dragon");
        Personaje link = new Personaje("Link", "Elfo", "Guerrero", true);
        GUI.personajesCreados.add(link);
        Personaje bowser = new Personaje("Bowser", "Dragon", "Guerrero");
        GUI.personajesCreados.add(bowser);
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    GUI frame = new GUI();
                    frame.setVisible(true);
                    frame.setLocationRelativeTo(null);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public GUI() {
    	setBackground(new Color(100, 149, 237));
    	setTitle("Creador de Personajes");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 600); 
        desktopPane = new JDesktopPane();
        desktopPane.setBackground(new Color(128, 0, 128));
        setContentPane(desktopPane);
        desktopPane.setLayout(null);
        
        // Crear botón de confirmar
        btnConfirmar = new JButton("Confirmar");
        btnConfirmar.setBounds(135, 350, 100, 30);
        desktopPane.add(btnConfirmar);
        
        
        
                // Agregar ActionListener al botón de confirmar
                btnConfirmar.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        // Mostrar el formulario o el mensaje según la opción seleccionada
                        if (radioOpcion1.isSelected()) {
                        	FormRaza formRaza = new FormRaza(); // Crear una nueva instancia de FormRaza
                        	desktopPane.add(formRaza);
                            formRaza.setVisible(true); // Hacer visible la instancia de FormRaza
                        } else if (radioOpcion2.isSelected()) {
                            // Mostrar formulario 2
                        	FormPersonaje formPersonaje = new FormPersonaje();
                        	desktopPane.add(formPersonaje);
                            formPersonaje.setVisible(true); 
                        } else if (radioOpcion3.isSelected()) {
                            // Mostrar formulario 3
                        	FormNPC formNPC = new FormNPC();
                        	desktopPane.add(formNPC);
                            formNPC.setVisible(true); 
                        } else if (radioOpcion4.isSelected()) {
                        	FormVisualizar formVisualizar = new FormVisualizar();
                        	desktopPane.add(formVisualizar);
                            formVisualizar.setVisible(true); 
                            // Mostrar texto
                        } else if (radioOpcion5.isSelected()) {
                            SelectorCom selector = new SelectorCom(); // Crear una nueva instancia de SelectorCombate
                            selector.setVisible(true); 

                        }
                    }
                });
        
        lblTiutlo = new JLabel("Creador de Personajes");
        lblTiutlo.setForeground(new Color(255, 255, 255));
        lblTiutlo.setFont(new Font("Impact", Font.PLAIN, 30));
        lblTiutlo.setBounds(39, 34, 289, 46);
        desktopPane.add(lblTiutlo);

        // Crear botones de opción
        radioOpcion1 = new JRadioButton("Crear Raza");
        radioOpcion1.setFont(new Font("Arial Black", Font.PLAIN, 12));
        radioOpcion1.setBounds(50, 106, 195, 30);
        desktopPane.add(radioOpcion1);

        radioOpcion2 = new JRadioButton("Crear Personaje jugable");
        radioOpcion2.setFont(new Font("Arial Black", Font.PLAIN, 12));
        radioOpcion2.setBounds(50, 156, 246, 30);
        desktopPane.add(radioOpcion2);

        radioOpcion3 = new JRadioButton("Crear Personaje no jugable");
        radioOpcion3.setFont(new Font("Arial Black", Font.PLAIN, 12));
        radioOpcion3.setBounds(50, 206, 260, 30);
        desktopPane.add(radioOpcion3);
        
        radioOpcion4 = new JRadioButton("Ver personajes creados");
        radioOpcion4.setFont(new Font("Arial Black", Font.PLAIN, 12));
        radioOpcion4.setBounds(50, 256, 195, 30);
        desktopPane.add(radioOpcion4);
        
        radioOpcion5 = new JRadioButton("Combatir");
        radioOpcion5.setFont(new Font("Arial Black", Font.PLAIN, 12));
        radioOpcion5.setBounds(50, 306, 195, 30);
        desktopPane.add(radioOpcion5);

        // Agrupar los botones de opción
        ButtonGroup grupoOpciones = new ButtonGroup();
        grupoOpciones.add(radioOpcion1);
        grupoOpciones.add(radioOpcion2);
        grupoOpciones.add(radioOpcion3);
        grupoOpciones.add(radioOpcion4);
        grupoOpciones.add(radioOpcion5);
        
        JPanel panel = new JPanel();
        panel.setBounds(27, 90, 313, 305);
        desktopPane.add(panel);
        
        JLabel lblimagen = new JLabel("");
        lblimagen.setIcon(new ImageIcon(GUI.class.getResource("/images/bg3 (2).jpg")));
        
        Border border = BorderFactory.createLineBorder(Color.BLACK, 5);
        lblimagen.setBorder(new LineBorder(new Color(0, 0, 0), 2));
       
        lblimagen.setBounds(350, 34, 400, 450);
        desktopPane.add(lblimagen);
        
        lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon(GUI.class.getResource("/images/beautiful-purple-color-gradient-background-free-vector.jpg")));
        lblNewLabel.setBounds(0, 10, 800, 600);
        desktopPane.add(lblNewLabel);
        radioOpcion1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		lblimagen.setIcon(new ImageIcon(GUI.class.getResource("/images/raza.png")));
        	}
        });
        radioOpcion2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		lblimagen.setIcon(new ImageIcon(GUI.class.getResource("/images/personaje.jpg")));
        	}
        });
        radioOpcion3.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		lblimagen.setIcon(new ImageIcon(GUI.class.getResource("/images/orco.jpg")));
        	}
        });
        radioOpcion4.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		lblimagen.setIcon(new ImageIcon(GUI.class.getResource("/images/creados.jpg")));
        	}
        });
        radioOpcion5.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		lblimagen.setIcon(new ImageIcon(GUI.class.getResource("/images/DNDFIGHT.png")));
        	}
        });
}
}