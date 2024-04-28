package rol;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class Combate extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
    private JLabel playerLabel, npcLabel, combatTextLabel, lblFondo;
    private JProgressBar playerHealthBar, npcHealthBar;
    private JButton attackButton;
    private JTextArea combatTextArea;

    private int playerHealth = 100;
    private int npcHealth = 100;
    private JLabel lblBowser;
    private Personaje player;
    private Personaje npc;
	public Combate(Personaje player, Personaje npc) {
		  this.player = player;
		  this.npc = npc;
		setForeground(new Color(30, 144, 255));
		setTitle("Combate RPG");
        setSize(834, 729);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        playerLabel = new JLabel("Jugador");
        playerLabel.setForeground(new Color(255, 255, 255));
        playerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        playerLabel.setBounds(20, 50, 64, 45);
        playerLabel.setFont(new Font("Impact", Font.PLAIN, 15));
        npcLabel = new JLabel("Enemigo");
        npcLabel.setForeground(new Color(255, 255, 255));
        npcLabel.setHorizontalAlignment(SwingConstants.CENTER);
        npcLabel.setFont(new Font("Impact", Font.PLAIN, 15));
        npcLabel.setBounds(734, 56, 79, 33);
        combatTextArea = new JTextArea();
        combatTextArea.setLineWrap(true); // Habilitar el ajuste de línea automático
        combatTextArea.setWrapStyleWord(true); // Ajustar las líneas al ancho del componente
        combatTextArea.setBounds(59, 59, 485, 125);
        combatTextArea.setFont(new Font("SimSun", Font.BOLD, 14));
        playerHealthBar = new JProgressBar(0, 100);
        playerHealthBar.setFont(new Font("Tahoma", Font.PLAIN, 16));
        playerHealthBar.setForeground(Color.GREEN);
        playerHealthBar.setBounds(10, 7, 314, 45);
        playerHealthBar.setValue(playerHealth);
        playerHealthBar.setStringPainted(true);

        npcHealthBar = new JProgressBar(0, 100);
        npcHealthBar.setFont(new Font("Tahoma", Font.PLAIN, 16));
        npcHealthBar.setForeground(new Color(255, 0, 0));
        npcHealthBar.setBounds(499, 7, 314, 45);
        npcHealthBar.setValue(npcHealth);
        npcHealthBar.setStringPainted(true);
        
        lblBowser = new JLabel("");
        lblBowser.setIcon(new ImageIcon(Combate.class.getResource("/images/bowser (2).gif")));
        lblBowser.setBounds(497, 99, 290, 296);
        getContentPane().add(lblBowser);
        
        JLabel lblLink = new JLabel("");
        lblLink.setIcon(new ImageIcon(FormPersonaje.class.getResource("/images/link-pixel-art (2).gif")));
        lblLink.setBounds(52, 99, 250, 303);
        getContentPane().add(lblLink);
        
        attackButton = new JButton("Atacar");
        attackButton.setFont(new Font("Arial Narrow", Font.BOLD, 14));
        attackButton.setBounds(632, 465, 144, 79);
        attackButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Simulate an attack, reducing NPC's health
                int damage = (int)(Math.random() * 20) + 10; // Random damage between 10 and 30
                npcHealth -= damage;
                if (npcHealth < 0) npcHealth = 0;
                npcHealthBar.setValue(npcHealth);
                
                // Update combat text
                //combatTextLabel.setText(player.getNombre() + " ataca a " + npc.getNombre()+" e inflinge " + damage + " puntos de daño.");
                
             // Simular un ataque del NPC
                int damagenpc = (int)(Math.random() * 20) + 10; // Daño aleatorio entre 10 y 30
                playerHealth -= damagenpc;
                if (playerHealth < 0) playerHealth = 0;
                playerHealthBar.setValue(playerHealth);

                // Actualizar el texto de combate
                combatTextLabel.setText("");
                combatTextArea.setText(player.getNombre() + " ataca a " + npc.getNombre() + " e inflinge " + damage + " puntos de daño.\n" +
                        npc.getNombre() + " ataca a " + player.getNombre() + " e inflige " + damagenpc + " puntos de daño.");

                // Check if NPC is defeated
                if (playerHealth == 0 && npcHealth == 0) {
                	   JOptionPane.showMessageDialog(null, "¡Empate!");
                resetCombat();}
                else if (npcHealth == 0) {
                    JOptionPane.showMessageDialog(null, "¡Has derrotado al enemigo!");
                    resetCombat();
                    
                }
                else if (playerHealth == 0) {
                    JOptionPane.showMessageDialog(null, "¡Has sido derrotado!");
                    resetCombat();}
            }
        });
        getContentPane().setLayout(null);

        getContentPane().add(playerLabel);
        getContentPane().add(playerHealthBar);
        getContentPane().add(npcLabel);
        getContentPane().add(npcHealthBar);
        getContentPane().add(attackButton);
        
        JButton btnHuir = new JButton("Cambiar Personajes");
        btnHuir.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		   SelectorCom selector = new SelectorCom(); // Crear una nueva instancia de SelectorCombate
                   selector.setVisible(true); 
        	}
        });
        btnHuir.setFont(new Font("Arial Narrow", Font.BOLD, 14));
        btnHuir.setBounds(632, 567, 144, 79);
        getContentPane().add(btnHuir);
        
        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 255, 255));
        panel.setBorder(new LineBorder(new Color(0, 0, 0)));
        panel.setBounds(52, 465, 554, 194);
        getContentPane().add(panel);
        panel.setLayout(null);
        combatTextLabel = new JLabel("¡Comenzar combate!");
        combatTextLabel.setHorizontalAlignment(SwingConstants.CENTER);
        combatTextLabel.setForeground(new Color(0, 0, 0));
        combatTextLabel.setBounds(130, 61, 315, 70);
        panel.add(combatTextLabel);
        panel.add(combatTextArea);
        combatTextLabel.setFont(new Font("SimSun", Font.BOLD, 14));
        
        JLabel lblVS = new JLabel("VS");
        lblVS.setHorizontalAlignment(SwingConstants.CENTER);
        lblVS.setFont(new Font("Forte", Font.PLAIN, 36));
        lblVS.setBounds(382, 10, 57, 45);
        getContentPane().add(lblVS);
        
        lblFondo = new JLabel("");
        lblFondo.setIcon(new ImageIcon(Combate.class.getResource("/images/fondo (2).png")));
        lblFondo.setBounds(0, 0, 820, 692);
        getContentPane().add(lblFondo);

        setVisible(true);
    }

    private void resetCombat() {
        // Reset player and NPC health
        playerHealth = 100;
        npcHealth = 100;
        playerHealthBar.setValue(playerHealth);
        npcHealthBar.setValue(npcHealth);

        // Clear combat text
        combatTextArea.setText("");
        combatTextLabel.setText("¡Comenzar combate!");
    }
}
