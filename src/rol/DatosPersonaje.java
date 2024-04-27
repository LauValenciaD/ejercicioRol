package rol;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

public class DatosPersonaje extends JFrame {

    private static final long serialVersionUID = 1L;
    private Personaje personaje;

    public DatosPersonaje(Personaje personaje) {
        this.personaje = personaje;
        Raza raza = personaje.getRaza();
        Caracteristicas caract = personaje.getCaract();
        setTitle("Detalles del Personaje");
        setSize(600, 350);
        setLocationRelativeTo(null);

        // Crear una tabla para mostrar los detalles del personaje
        JTable table = new JTable();
        table.setFont(new Font("Tahoma", Font.PLAIN, 12));
        table.setFillsViewportHeight(true);
        DefaultTableModel model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Hacer que todas las celdas no sean editables
            }
        };
        model.addColumn("Atributo");
        model.addColumn("Valor");
        table.setModel(model);

        // Agregar filas para cada atributo del personaje
        model.addRow(new Object[]{"Nombre", personaje.getNombre()});

        if (personaje.getProfesion() instanceof Guerrero)
            model.addRow(new Object[]{"Profesion", "Guerrero"});
        else if (personaje.getProfesion() instanceof Mago)
            {model.addRow(new Object[]{"Profesion", "Mago"});}
        model.addRow(new Object[]{"Raza", raza.getNombre()});
        model.addRow(new Object[]{"Caracterisica Bono", raza.getCaractBonif()});
        model.addRow(new Object[]{"Bonificador", raza.getBonificador()});
        model.addRow(new Object[]{"Fuerza", caract.getFuerza()});
        model.addRow(new Object[]{"Destreza", caract.getDestreza()});
        model.addRow(new Object[]{"Constitución", caract.getConstitucion()});
        model.addRow(new Object[]{"Inteligencia", caract.getInteligencia()});
        model.addRow(new Object[]{"Sabiduria", caract.getSabiduria()});
        model.addRow(new Object[]{"Carisma", caract.getCarisma()});
        model.addRow(new Object[]{"Vida", caract.getVida()});
        model.addRow(new Object[]{"Defensa", caract.getDefensa()});

        // Renderizador de celdas para cambiar el color de fondo de la primera columna
        TableCellRenderer headerRenderer = new TableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                           boolean hasFocus, int row, int column) {
                JLabel label = new JLabel(value.toString());
                label.setOpaque(true);
                if (column == 0) {
                    label.setBackground(new Color(173, 216, 230)); // Color azul claro para la primera columna
                } else {
                    label.setBackground(Color.LIGHT_GRAY); // Otros colores de columna
                }
                label.setBorder(BorderFactory.createEtchedBorder());
                label.setHorizontalAlignment(SwingConstants.CENTER);
                return label;
            }
        };

        // Aplicar el renderizador a las columnas
        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
        }

        JScrollPane scrollPane = new JScrollPane(table);

        // Panel para el GIF
        JPanel gifPanel = new JPanel(new BorderLayout());
        JLabel gifLabel = new JLabel();
        		if (personaje.isJugador() == true)
        		{gifLabel.setIcon(new ImageIcon(DatosPersonaje.class.getResource("/images/link-pixel-art (2).gif")));
        gifLabel.setPreferredSize(new Dimension(250, 303));} // Establecer el tamaño 
        		else
        		{gifLabel.setIcon(new ImageIcon(DatosPersonaje.class.getResource("/images/bowser (2).gif")));
        gifLabel.setPreferredSize(new Dimension(290, 296));} 
        gifPanel.add(gifLabel, BorderLayout.CENTER);

        // Dividir el contenido entre el GIF y la tabla
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, gifPanel, scrollPane);
        splitPane.setResizeWeight(0.3); // Porcentaje de espacio asignado al GIF

        getContentPane().add(splitPane, BorderLayout.CENTER);
    }
}
