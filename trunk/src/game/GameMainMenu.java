package game;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.FlowLayout;
import java.awt.Insets;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ButtonGroup;

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
	private JLabel jLabel9 = null;  // the buttom label
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
	private JLabel jLabel6 = null;
	private JLabel jLabel7 = null;
	private JLabel jLabel8 = null;
	private JButton jButton = null;
	private ButtonGroup playergroup = null;
	private ButtonGroup propertygroup = null;
	private ButtonGroup percentgroup = null;
	private ButtonGroup pointgroup = null;
	private ButtonGroup modegroup = null; 
	private Font newfont = new Font("標楷體",Font.PLAIN,18);
	
	private GameInfo ginfo = null;
	private int player_num = 2; 
	private int property = 500000 ;
	private int percent = 5;
	private int point = 0 ;
	private int mode = 1;
	private boolean gameflag = false;
	
	/**
	 * This is the default constructor
	 */
	public GameMainMenu(GameInfo ginfo) {
		super();
		this.ginfo = ginfo;
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
		this.setTitle("NTU Monopoly");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void Display(){
		setVisible(true);
		while(!gameflag){};
		setVisible(false);
		
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
			jLabel9 = new JLabel();
			jLabel9.setFont(newfont);
			setButtomJLabel();
			jPanel = new JPanel();
			jPanel.setLayout(new GridBagLayout());
			jPanel.add(jLabel9, gridBagConstraints1);
		}
		return jPanel;
	}

	private JPanel getJPanel1(){
		if(jPanel1 == null){
			jLabel = new JLabel();
			jLabel.setFont(newfont);
			jLabel.setText("歡迎來到NTU Monopoly  , you can select the option of the game");
			jPanel1 = new JPanel();
			jPanel1.add(jLabel, null);
			jPanel1.setLayout(new GridBagLayout());
		}
		return jPanel1;
	}
	
	private JPanel getJPanel2() {
		if (jPanel2 == null) {
			GridBagConstraints gridBagConstraints5 = new GridBagConstraints();
			gridBagConstraints5.gridx = 4;
			gridBagConstraints5.insets = new Insets(5, 5, 5, 5);
			gridBagConstraints5.gridy = 7;
			GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
			gridBagConstraints4.gridx = 3;
			gridBagConstraints4.insets = new Insets(5, 5, 5, 5);
			gridBagConstraints4.gridy = 6;
			jLabel8 = new JLabel();
			jLabel8.setFont(newfont);
			jLabel8.setText("總財產超過200萬");
			GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
			gridBagConstraints3.gridx = 2;
			gridBagConstraints3.insets = new Insets(5, 5, 5, 5);
			gridBagConstraints3.gridy = 6;
			jLabel7 = new JLabel();
			jLabel7.setFont(newfont);
			jLabel7.setText("擁有超過50棟房屋");
			GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
			gridBagConstraints2.gridx = 1;
			gridBagConstraints2.insets = new Insets(5, 5, 5, 5);
			gridBagConstraints2.gridy = 6;
			jLabel6 = new JLabel();
			jLabel6.setFont(newfont);
			jLabel6.setText("玩至其他玩家破產為止");
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
			jLabel5.setFont(newfont);
			jLabel5.setText("遊戲模式:");
			GridBagConstraints gridBagConstraints40 = new GridBagConstraints();
			gridBagConstraints40.gridx = 0;
			gridBagConstraints40.insets = new Insets(0, 1, 0, 0);
			gridBagConstraints40.gridwidth = 1;
			gridBagConstraints40.anchor = GridBagConstraints.WEST;
			gridBagConstraints40.gridy = 4;
			jLabel4 = new JLabel();
			jLabel4.setFont(newfont);
			jLabel4.setText("初始點數:");
			GridBagConstraints gridBagConstraints39 = new GridBagConstraints();
			gridBagConstraints39.gridx = 0;
			gridBagConstraints39.insets = new Insets(0, 1, 0, 0);
			gridBagConstraints39.gridwidth = 1;
			gridBagConstraints39.anchor = GridBagConstraints.WEST;
			gridBagConstraints39.gridy = 3;
			jLabel3 = new JLabel();
			jLabel3.setFont(newfont);
			jLabel3.setText("初始現金/存款比率:");
			GridBagConstraints gridBagConstraints38 = new GridBagConstraints();
			gridBagConstraints38.gridx = 0;
			gridBagConstraints38.insets = new Insets(0, 1, 0, 0);
			gridBagConstraints38.gridwidth = 1;
			gridBagConstraints38.anchor = GridBagConstraints.WEST;
			gridBagConstraints38.gridy = 2;
			jLabel2 = new JLabel();
			jLabel2.setFont(newfont);
			jLabel2.setText("初始總財產:");
			GridBagConstraints gridBagConstraints37 = new GridBagConstraints();
			gridBagConstraints37.gridx = 0;
			gridBagConstraints37.insets = new Insets(0, 1, 0, 0);
			gridBagConstraints37.gridwidth = 1;
			gridBagConstraints37.anchor = GridBagConstraints.WEST;
			gridBagConstraints37.gridy = 1;
			jLabel1 = new JLabel();
			jLabel1.setFont(newfont);
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
			
			playergroup = new ButtonGroup();
			propertygroup = new ButtonGroup();
			percentgroup = new ButtonGroup();
			pointgroup = new ButtonGroup();
			modegroup = new ButtonGroup(); 
			
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
			jPanel2.add(jLabel6, gridBagConstraints2);
			jPanel2.add(jLabel7, gridBagConstraints3);
			jPanel2.add(jLabel8, gridBagConstraints4);
			jPanel2.add(getJButton(), gridBagConstraints5);
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
			jRadioButton.setFont(newfont);
			jRadioButton.setText("2人");
			jRadioButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					player_num = 2;
					setButtomJLabel();
				}
			});
			jRadioButton.doClick();
			playergroup.add(jRadioButton);
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
			jRadioButton1.setFont(newfont);
			jRadioButton1.setText("3人");
			jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					player_num = 3;
					setButtomJLabel();
				}
			});
			playergroup.add(jRadioButton1);
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
			jRadioButton2.setFont(newfont);
			jRadioButton2.setText("4人");
			jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					player_num = 4;
					setButtomJLabel();
				}
			});
			playergroup.add(jRadioButton2);
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
			jRadioButton3.setFont(newfont);
			jRadioButton3.setText("80萬");
			jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					property = 500000;
					setButtomJLabel();
				}
			});
			jRadioButton3.doClick();
			propertygroup.add(jRadioButton3);
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
			jRadioButton4.setFont(newfont);
			jRadioButton4.setText("120萬");
			jRadioButton4.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					property = 1200000;
					setButtomJLabel();
				}
			});
			propertygroup.add(jRadioButton4);
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
			jRadioButton5.setFont(newfont);
			jRadioButton5.setText("150萬");
			jRadioButton5.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					property = 1500000;
					setButtomJLabel();
				}
			});
			propertygroup.add(jRadioButton5);
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
			jRadioButton6.setFont(newfont);
			jRadioButton6.setText("50%/50%");
			jRadioButton6.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					percent = 5;
					setButtomJLabel();
				}
			});
			jRadioButton6.doClick();
			percentgroup.add(jRadioButton6);
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
			jRadioButton7.setFont(newfont);
			jRadioButton7.setText("30%/70%");
			jRadioButton7.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					percent = 3;
					setButtomJLabel();
				}
			});
			percentgroup.add(jRadioButton7);
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
			jRadioButton8.setFont(newfont);
			jRadioButton8.setText("70%/30%");
			jRadioButton8.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					percent = 7;
					setButtomJLabel();
				}
			});
			percentgroup.add(jRadioButton8);
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
			jRadioButton9.setFont(newfont);
			jRadioButton9.setText("0點");
			jRadioButton9.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					point = 0;
					setButtomJLabel();
				}
			});
			jRadioButton9.doClick();
			pointgroup.add(jRadioButton9);
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
			jRadioButton10.setFont(newfont);
			jRadioButton10.setText("100點");
			jRadioButton10.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					point = 100;
					setButtomJLabel();
				}
			});
			pointgroup.add(jRadioButton10);
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
			jRadioButton11.setFont(newfont);
			jRadioButton11.setText("200點");
			jRadioButton11.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					point = 200 ;
					setButtomJLabel();
				}
			});
			pointgroup.add(jRadioButton11);
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
			jRadioButton12.setFont(newfont);
			jRadioButton12.setText("真‧大富翁");
			jRadioButton12.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					mode = 1;
					setButtomJLabel();
				}
			});
			jRadioButton12.doClick();
			modegroup.add(jRadioButton12);
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
			jRadioButton13.setFont(newfont);
			jRadioButton13.setText("真‧房地產大亨");
			jRadioButton13.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					mode = 2;
					setButtomJLabel();
				}
			});
			modegroup.add(jRadioButton13);
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
			jRadioButton14.setFont(newfont);
			jRadioButton14.setText("真‧好野人");
			jRadioButton14.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					mode = 3 ;
					setButtomJLabel();
				}
			});
			modegroup.add(jRadioButton14);
		}
		return jRadioButton14;
	}

	/**
	 * This method initializes jButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton() {
		if (jButton == null) {
			jButton = new JButton();
			jButton.setFont(newfont);
			jButton.setText("開始遊戲!");
			jButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					ginfo.players_num = player_num;
					ginfo.init_cash = property * percent / 10 ;
					ginfo.init_deposit = property * (10 - percent) / 10;
					ginfo.init_point = point;
					ginfo.gamemode = mode;
					gameflag = true;
				}
			});
		}
		return jButton;
	}
	private void setButtomJLabel(){
		jLabel9.setText("遊戲人數:" +  player_num + "  初始現金:" + property * percent / 10 + "  初始存款:" + property * (10-percent) /10 + "  初始點數:" + point + "  遊戲模式:" + mode);
	}
}


