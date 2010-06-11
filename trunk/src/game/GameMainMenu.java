package game;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.FlowLayout;
import java.awt.Insets;
import javax.swing.JRadioButton;

public class GameMainMenu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JPanel jPanel = null;
	private JPanel jPanel1 = null;
	private JPanel jPanel2 = null;
	private JLabel jLabel = null;  //  @jve:decl-index=0:visual-constraint="76,625"
	private JLabel jLabel1 = null;
	private JLabel jLabel2 = null;
	private JLabel jLabel3 = null;
	private JLabel jLabel4 = null;
	private JLabel jLabel5 = null;
	private JRadioButton jRadioButton = null;
	private JRadioButton jRadioButton1 = null;
	private JRadioButton jRadioButton2 = null;
	private JRadioButton jRadioButton3 = null;
	private JRadioButton jRadioButton4 = null;
	private JRadioButton jRadioButton5 = null;
	private JRadioButton jRadioButton6 = null;
	private JRadioButton jRadioButton7 = null;
	private JRadioButton jRadioButton8 = null;
	private JRadioButton jRadioButton9 = null;
	private JRadioButton jRadioButton10 = null;
	private JRadioButton jRadioButton11 = null;
	private JRadioButton jRadioButton12 = null;
	private JRadioButton jRadioButton13 = null;
	private JRadioButton jRadioButton14 = null;
	
	/**
	 * This is the default constructor
	 */
	public GameMainMenu() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(800, 600);
		this.setContentPane(getJContentPane());
		this.setTitle("JFrame");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(new BorderLayout());
			jContentPane.add(getJPanel(), BorderLayout.SOUTH);
			jContentPane.add(getJPanel1(),BorderLayout.NORTH);
			jContentPane.add(getJPanel2(), BorderLayout.CENTER);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel() {
		if (jPanel == null) {
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
			gridBagConstraints1.insets = new Insets(5, 218, 5, 219);
			gridBagConstraints1.gridy = 0;
			gridBagConstraints1.gridx = 0;
			jLabel = new JLabel();
			jLabel.setText("歡迎來到NTU Monopoly  , you can select the option of the game");
			jPanel = new JPanel();
			jPanel.setLayout(new GridBagLayout());
			jPanel.add(jLabel, gridBagConstraints1);
		}
		return jPanel;
	}

	private JPanel getJPanel1(){
		if(jPanel1 == null){
			jLabel = new JLabel();
			jLabel.setText("歡迎來到NTU Monopoly  , you can select the option of the game");
			jPanel1 = new JPanel();
			jPanel1.add(jLabel, null);
			jPanel.setLayout(new GridBagLayout());
		}
		return jPanel1;
	}
	
	private JPanel getJPanel2() {
		if (jPanel2 == null) {
			GridBagConstraints gridBagConstraints56 = new GridBagConstraints();
			gridBagConstraints56.gridx = 3;
			gridBagConstraints56.insets = new Insets(5, 5, 5, 5);
			gridBagConstraints56.gridy = 5;
			GridBagConstraints gridBagConstraints55 = new GridBagConstraints();
			gridBagConstraints55.gridx = 2;
			gridBagConstraints55.insets = new Insets(5, 5, 5, 5);
			gridBagConstraints55.gridy = 5;
			GridBagConstraints gridBagConstraints54 = new GridBagConstraints();
			gridBagConstraints54.gridx = 1;
			gridBagConstraints54.insets = new Insets(5, 5, 5, 5);
			gridBagConstraints54.gridy = 5;
			GridBagConstraints gridBagConstraints53 = new GridBagConstraints();
			gridBagConstraints53.gridx = 3;
			gridBagConstraints53.insets = new Insets(5, 5, 5, 5);
			gridBagConstraints53.gridy = 4;
			GridBagConstraints gridBagConstraints52 = new GridBagConstraints();
			gridBagConstraints52.gridx = 2;
			gridBagConstraints52.insets = new Insets(5, 5, 5, 5);
			gridBagConstraints52.gridy = 4;
			GridBagConstraints gridBagConstraints51 = new GridBagConstraints();
			gridBagConstraints51.gridx = 1;
			gridBagConstraints51.insets = new Insets(5, 5, 5, 5);
			gridBagConstraints51.gridy = 4;
			GridBagConstraints gridBagConstraints50 = new GridBagConstraints();
			gridBagConstraints50.gridx = 3;
			gridBagConstraints50.insets = new Insets(5, 5, 5, 5);
			gridBagConstraints50.gridy = 3;
			GridBagConstraints gridBagConstraints49 = new GridBagConstraints();
			gridBagConstraints49.gridx = 2;
			gridBagConstraints49.insets = new Insets(5, 5, 5, 5);
			gridBagConstraints49.gridy = 3;
			GridBagConstraints gridBagConstraints48 = new GridBagConstraints();
			gridBagConstraints48.gridx = 1;
			gridBagConstraints48.insets = new Insets(5, 5, 5, 5);
			gridBagConstraints48.gridy = 3;
			GridBagConstraints gridBagConstraints47 = new GridBagConstraints();
			gridBagConstraints47.gridx = 3;
			gridBagConstraints47.insets = new Insets(5, 5, 5, 5);
			gridBagConstraints47.gridy = 2;
			GridBagConstraints gridBagConstraints46 = new GridBagConstraints();
			gridBagConstraints46.gridx = 2;
			gridBagConstraints46.insets = new Insets(5, 5, 5, 5);
			gridBagConstraints46.gridy = 2;
			GridBagConstraints gridBagConstraints45 = new GridBagConstraints();
			gridBagConstraints45.gridx = 1;
			gridBagConstraints45.insets = new Insets(5, 5, 5, 5);
			gridBagConstraints45.gridy = 2;
			GridBagConstraints gridBagConstraints44 = new GridBagConstraints();
			gridBagConstraints44.gridx = 3;
			gridBagConstraints44.insets = new Insets(5, 5, 5, 5);
			gridBagConstraints44.gridy = 1;
			GridBagConstraints gridBagConstraints43 = new GridBagConstraints();
			gridBagConstraints43.gridx = 2;
			gridBagConstraints43.insets = new Insets(5, 5, 5, 5);
			gridBagConstraints43.gridy = 1;
			GridBagConstraints gridBagConstraints42 = new GridBagConstraints();
			gridBagConstraints42.gridx = 1;
			gridBagConstraints42.insets = new Insets(5, 5, 5, 5);
			gridBagConstraints42.gridy = 1;
			GridBagConstraints gridBagConstraints41 = new GridBagConstraints();
			gridBagConstraints41.gridx = 0;
			gridBagConstraints41.insets = new Insets(0, 1, 0, 0);
			gridBagConstraints41.gridwidth = 1;
			gridBagConstraints41.anchor = GridBagConstraints.WEST;
			gridBagConstraints41.gridy = 5;
			jLabel5 = new JLabel();
			jLabel5.setText("遊戲模式:");
			GridBagConstraints gridBagConstraints40 = new GridBagConstraints();
			gridBagConstraints40.gridx = 0;
			gridBagConstraints40.insets = new Insets(0, 1, 0, 0);
			gridBagConstraints40.gridwidth = 1;
			gridBagConstraints40.anchor = GridBagConstraints.WEST;
			gridBagConstraints40.gridy = 4;
			jLabel4 = new JLabel();
			jLabel4.setText("初始點數:");
			GridBagConstraints gridBagConstraints39 = new GridBagConstraints();
			gridBagConstraints39.gridx = 0;
			gridBagConstraints39.insets = new Insets(0, 1, 0, 0);
			gridBagConstraints39.gridwidth = 1;
			gridBagConstraints39.anchor = GridBagConstraints.WEST;
			gridBagConstraints39.gridy = 3;
			jLabel3 = new JLabel();
			jLabel3.setText("初始現金/存款比率:");
			GridBagConstraints gridBagConstraints38 = new GridBagConstraints();
			gridBagConstraints38.gridx = 0;
			gridBagConstraints38.insets = new Insets(0, 1, 0, 0);
			gridBagConstraints38.gridwidth = 1;
			gridBagConstraints38.anchor = GridBagConstraints.WEST;
			gridBagConstraints38.gridy = 2;
			jLabel2 = new JLabel();
			jLabel2.setText("初始總財產:");
			GridBagConstraints gridBagConstraints37 = new GridBagConstraints();
			gridBagConstraints37.gridx = 0;
			gridBagConstraints37.insets = new Insets(0, 1, 0, 0);
			gridBagConstraints37.gridwidth = 1;
			gridBagConstraints37.anchor = GridBagConstraints.WEST;
			gridBagConstraints37.gridy = 1;
			jLabel1 = new JLabel();
			jLabel1.setText("遊戲人數:");
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.gridx = 0;
			gridBagConstraints.gridy = 0;
			jLabel = new JLabel();
			
			jLabel.setText("");
			jPanel2 = new JPanel();
			jPanel2.setLayout(new GridBagLayout());
			jPanel2.add(jLabel, gridBagConstraints);
			jPanel2.add(jLabel1, gridBagConstraints37);
			jPanel2.add(jLabel2, gridBagConstraints38);
			jPanel2.add(jLabel3, gridBagConstraints39);
			jPanel2.add(jLabel4, gridBagConstraints40);
			jPanel2.add(jLabel5, gridBagConstraints41);
			jPanel2.add(getJRadioButton(), gridBagConstraints42);
			jPanel2.add(getJRadioButton1(), gridBagConstraints43);
			jPanel2.add(getJRadioButton2(), gridBagConstraints44);
			jPanel2.add(getJRadioButton3(), gridBagConstraints45);
			jPanel2.add(getJRadioButton4(), gridBagConstraints46);
			jPanel2.add(getJRadioButton5(), gridBagConstraints47);
			jPanel2.add(getJRadioButton6(), gridBagConstraints48);
			jPanel2.add(getJRadioButton7(), gridBagConstraints49);
			jPanel2.add(getJRadioButton8(), gridBagConstraints50);
			jPanel2.add(getJRadioButton9(), gridBagConstraints51);
			jPanel2.add(getJRadioButton10(), gridBagConstraints52);
			jPanel2.add(getJRadioButton11(), gridBagConstraints53);
			jPanel2.add(getJRadioButton12(), gridBagConstraints54);
			jPanel2.add(getJRadioButton13(), gridBagConstraints55);
			jPanel2.add(getJRadioButton14(), gridBagConstraints56);
		}
		return jPanel2;
	}

	/**
	 * This method initializes jRadioButton	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getJRadioButton() {
		if (jRadioButton == null) {
			jRadioButton = new JRadioButton();
			jRadioButton.setText("2人");
		}
		return jRadioButton;
	}

	/**
	 * This method initializes jRadioButton1	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getJRadioButton1() {
		if (jRadioButton1 == null) {
			jRadioButton1 = new JRadioButton();
			jRadioButton1.setText("3人");
		}
		return jRadioButton1;
	}

	/**
	 * This method initializes jRadioButton2	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getJRadioButton2() {
		if (jRadioButton2 == null) {
			jRadioButton2 = new JRadioButton();
			jRadioButton2.setText("4人");
		}
		return jRadioButton2;
	}

	/**
	 * This method initializes jRadioButton3	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getJRadioButton3() {
		if (jRadioButton3 == null) {
			jRadioButton3 = new JRadioButton();
			jRadioButton3.setText("50萬");
		}
		return jRadioButton3;
	}

	/**
	 * This method initializes jRadioButton4	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getJRadioButton4() {
		if (jRadioButton4 == null) {
			jRadioButton4 = new JRadioButton();
			jRadioButton4.setText("100萬");
		}
		return jRadioButton4;
	}

	/**
	 * This method initializes jRadioButton5	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getJRadioButton5() {
		if (jRadioButton5 == null) {
			jRadioButton5 = new JRadioButton();
			jRadioButton5.setText("150萬");
		}
		return jRadioButton5;
	}

	/**
	 * This method initializes jRadioButton6	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getJRadioButton6() {
		if (jRadioButton6 == null) {
			jRadioButton6 = new JRadioButton();
			jRadioButton6.setText("50%/50%");
		}
		return jRadioButton6;
	}

	/**
	 * This method initializes jRadioButton7	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getJRadioButton7() {
		if (jRadioButton7 == null) {
			jRadioButton7 = new JRadioButton();
			jRadioButton7.setText("30%/70%");
		}
		return jRadioButton7;
	}

	/**
	 * This method initializes jRadioButton8	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getJRadioButton8() {
		if (jRadioButton8 == null) {
			jRadioButton8 = new JRadioButton();
			jRadioButton8.setText("70%/30%");
		}
		return jRadioButton8;
	}

	/**
	 * This method initializes jRadioButton9	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getJRadioButton9() {
		if (jRadioButton9 == null) {
			jRadioButton9 = new JRadioButton();
			jRadioButton9.setText("0點");
		}
		return jRadioButton9;
	}

	/**
	 * This method initializes jRadioButton10	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getJRadioButton10() {
		if (jRadioButton10 == null) {
			jRadioButton10 = new JRadioButton();
			jRadioButton10.setText("100點");
		}
		return jRadioButton10;
	}

	/**
	 * This method initializes jRadioButton11	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getJRadioButton11() {
		if (jRadioButton11 == null) {
			jRadioButton11 = new JRadioButton();
			jRadioButton11.setText("200點");
		}
		return jRadioButton11;
	}

	/**
	 * This method initializes jRadioButton12	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getJRadioButton12() {
		if (jRadioButton12 == null) {
			jRadioButton12 = new JRadioButton();
			jRadioButton12.setText("真‧大富翁");
		}
		return jRadioButton12;
	}

	/**
	 * This method initializes jRadioButton13	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getJRadioButton13() {
		if (jRadioButton13 == null) {
			jRadioButton13 = new JRadioButton();
			jRadioButton13.setText("真‧房地產大亨");
		}
		return jRadioButton13;
	}

	/**
	 * This method initializes jRadioButton14	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getJRadioButton14() {
		if (jRadioButton14 == null) {
			jRadioButton14 = new JRadioButton();
			jRadioButton14.setText("真‧好野人");
		}
		return jRadioButton14;
	}
}
