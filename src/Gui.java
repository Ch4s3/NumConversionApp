import java.awt.EventQueue;

import javax.swing.JFrame;

import javax.swing.JMenuBar;
import javax.swing.JButton;
import javax.swing.JTextField;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JMenu;
import java.awt.Cursor;
import java.awt.Toolkit;
import javax.swing.JMenuItem;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JLayeredPane;
import java.awt.Panel;


public class Gui {

	private JFrame frmBaseConvertor;
	private JButton btnConvert;
	static JTextField numToConvert;
	static JComboBox startBase;
	static JTextField resField;
	private JLabel lblBase;
	private JLabel lblBase_1;
	static JComboBox endBase;
	private JMenu mnNewMenu;
	private JMenuItem mntmReset;
	private JMenuItem mntmCopyToClipboard;
	private JLabel lblConvert;
	private JLabel lblTo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui window = new Gui();
					window.frmBaseConvertor.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Gui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBaseConvertor = new JFrame();
		frmBaseConvertor.setFont(new Font("Gill Sans MT", Font.PLAIN, 14));
		frmBaseConvertor.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Chase\\workspace\\NumConversionApp\\src\\rocketICO.gif"));
		frmBaseConvertor.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		frmBaseConvertor.setTitle("Radix Rocket - Base Converter");
		frmBaseConvertor.setBounds(100, 100, 450, 255);
		frmBaseConvertor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setToolTipText("Convert");
		frmBaseConvertor.setJMenuBar(menuBar);
		
		mnNewMenu = new JMenu("Options");
		mnNewMenu.setFont(new Font("Gill Sans MT", Font.PLAIN, 12));
		menuBar.add(mnNewMenu);
		
		mntmReset = new JMenuItem("Reset");
		mntmReset.setFont(new Font("Gill Sans MT", Font.PLAIN, 12));
		mntmReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				numToConvert.setText("");
				resField.setText("");
				startBase.setSelectedIndex(0);
				endBase.setSelectedIndex(0);
			}
		});
		mnNewMenu.add(mntmReset);
		
		mntmCopyToClipboard = new JMenuItem("Copy to Clipboard");
		mntmCopyToClipboard.setFont(new Font("Gill Sans MT", Font.PLAIN, 12));
		mntmCopyToClipboard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CopyTo.Copy();
			}
		});
		mnNewMenu.add(mntmCopyToClipboard);
		frmBaseConvertor.getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),}));
		
		lblConvert = new JLabel("Convert");
		lblConvert.setFont(new Font("Gill Sans MT", Font.PLAIN, 14));
		frmBaseConvertor.getContentPane().add(lblConvert, "4, 4");
		
		numToConvert = new JTextField();
		numToConvert.setFont(new Font("Consolas", Font.PLAIN, 14));
		frmBaseConvertor.getContentPane().add(numToConvert, "6, 4, 17, 1, fill, default");
		numToConvert.setColumns(24);
		
		lblBase = new JLabel("Base");
		lblBase.setFont(new Font("Gill Sans MT", Font.PLAIN, 14));
		frmBaseConvertor.getContentPane().add(lblBase, "24, 4");
		
		startBase = new JComboBox();
		startBase.setFont(new Font("Consolas", Font.PLAIN, 14));
		startBase.setEditable(false);
		startBase.setToolTipText("select the starting base");
		startBase.setModel(new DefaultComboBoxModel(new String[] {"2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36"}));
		frmBaseConvertor.getContentPane().add(startBase, "26, 4, fill, default");
		
		lblTo = new JLabel("to");
		lblTo.setFont(new Font("Gill Sans MT", Font.PLAIN, 14));
		frmBaseConvertor.getContentPane().add(lblTo, "4, 8, center, default");
		
		resField = new JTextField();
		resField.setFont(new Font("Consolas", Font.PLAIN, 14));
		resField.setEditable(false);
		frmBaseConvertor.getContentPane().add(resField, "6, 8, 17, 1, fill, default");
		resField.setColumns(10);
		
		btnConvert = new JButton("Go");
		btnConvert.setFont(new Font("Gill Sans MT", Font.PLAIN, 11));
		btnConvert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Conv.run();
			}
		});
		
		lblBase_1 = new JLabel("Base");
		lblBase_1.setFont(new Font("Gill Sans MT", Font.PLAIN, 14));
		frmBaseConvertor.getContentPane().add(lblBase_1, "24, 8");
		
		endBase = new JComboBox();
		endBase.setFont(new Font("Consolas", Font.PLAIN, 14));
		endBase.setModel(new DefaultComboBoxModel(new String[] {"2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36"}));
		frmBaseConvertor.getContentPane().add(endBase, "26, 8, fill, default");
		frmBaseConvertor.getContentPane().add(btnConvert, "22, 12");
	}

}
