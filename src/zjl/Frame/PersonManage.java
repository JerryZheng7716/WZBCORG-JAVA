/*
 * PersonManage.java
 *
 * Created on __DATE__, __TIME__
 */

package zjl.Frame;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import other.wzbcOrg.AdminLogin;
import other.wzbcOrg.OpenSituation;
import other.wzbcOrg.OtherFunction;
import other.wzbcOrg.SqlFunction;

/**
 *
 * @author  __USER__
 */
public class PersonManage extends javax.swing.JInternalFrame {
	SqlFunction sqlFunction = new SqlFunction();
	OtherFunction otherFunction = new OtherFunction();
	String oldID = "";
	String[] init = { "%", "%", "%", "%", "%", "%", "%" };

	/** Creates new form PersonManage */
	public PersonManage() {
		initComponents();
	}

	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		buttonGroup1 = new javax.swing.ButtonGroup();
		buttonGroup2 = new javax.swing.ButtonGroup();
		jScrollPane1 = new javax.swing.JScrollPane();
		jTable1 = new javax.swing.JTable();
		jPanel1 = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		jLabel5 = new javax.swing.JLabel();
		jCheckBox1 = new javax.swing.JCheckBox();
		jCheckBox2 = new javax.swing.JCheckBox();
		jTextField1 = new javax.swing.JTextField();
		jTextField2 = new javax.swing.JTextField();
		jComboBox1 = new javax.swing.JComboBox();
		jComboBox2 = new javax.swing.JComboBox();
		jComboBox3 = new javax.swing.JComboBox();
		jLabel6 = new javax.swing.JLabel();
		jLabel7 = new javax.swing.JLabel();
		jTextField3 = new javax.swing.JTextField();
		jTextField4 = new javax.swing.JTextField();
		jLabel8 = new javax.swing.JLabel();
		jComboBox4 = new javax.swing.JComboBox();
		jComboBox5 = new javax.swing.JComboBox();
		jLabel9 = new javax.swing.JLabel();
		jLabel10 = new javax.swing.JLabel();
		jTextField5 = new javax.swing.JTextField();
		jLabel11 = new javax.swing.JLabel();
		jLabel12 = new javax.swing.JLabel();
		jLabel13 = new javax.swing.JLabel();
		jRadioButton1 = new javax.swing.JRadioButton();
		jRadioButton2 = new javax.swing.JRadioButton();
		jLabel14 = new javax.swing.JLabel();
		jLabel15 = new javax.swing.JLabel();
		jComboBox6 = new javax.swing.JComboBox();
		jComboBox7 = new javax.swing.JComboBox();
		jComboBox8 = new javax.swing.JComboBox();
		jLabel16 = new javax.swing.JLabel();
		jComboBox9 = new javax.swing.JComboBox();
		jComboBox10 = new javax.swing.JComboBox();
		jComboBox11 = new javax.swing.JComboBox();
		jLabel17 = new javax.swing.JLabel();
		jTextField6 = new javax.swing.JTextField();
		jLabel19 = new javax.swing.JLabel();
		jRadioButton3 = new javax.swing.JRadioButton();
		jRadioButton4 = new javax.swing.JRadioButton();
		jComboBox12 = new javax.swing.JComboBox();
		jComboBox13 = new javax.swing.JComboBox();
		jButton3 = new javax.swing.JButton();
		jButton2 = new javax.swing.JButton();
		jButton1 = new javax.swing.JButton();
		jTextField8 = new javax.swing.JTextField();
		jLabel20 = new javax.swing.JLabel();
		jTextField9 = new javax.swing.JTextField();

		setIconifiable(true);
		setTitle("\u4eba\u5458\u7ba1\u7406");
		addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
			public void internalFrameActivated(
					javax.swing.event.InternalFrameEvent evt) {
			}

			public void internalFrameClosed(
					javax.swing.event.InternalFrameEvent evt) {
				formInternalFrameClosed(evt);
			}

			public void internalFrameClosing(
					javax.swing.event.InternalFrameEvent evt) {
			}

			public void internalFrameDeactivated(
					javax.swing.event.InternalFrameEvent evt) {
			}

			public void internalFrameDeiconified(
					javax.swing.event.InternalFrameEvent evt) {
			}

			public void internalFrameIconified(
					javax.swing.event.InternalFrameEvent evt) {
			}

			public void internalFrameOpened(
					javax.swing.event.InternalFrameEvent evt) {
				formInternalFrameOpened(evt);
			}
		});

		jTable1.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] {

				}, new String[] { "学号", "姓名", "组织", "部门", "职务", "届次", "专业",
						"班级", "性别", "生日", "入职日期", "联系方式", "在职情况" }) {
			Class[] types = new Class[] { java.lang.String.class,
					java.lang.String.class, java.lang.String.class,
					java.lang.String.class, java.lang.String.class,
					java.lang.String.class, java.lang.String.class,
					java.lang.String.class, java.lang.String.class,
					java.lang.String.class, java.lang.String.class,
					java.lang.String.class, java.lang.String.class };
			boolean[] canEdit = new boolean[] { false, false, false, false,
					false, false, false, false, false, false, false, false,
					false };

			public Class getColumnClass(int columnIndex) {
				return types[columnIndex];
			}

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
		jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				jTable1MousePressed(evt);
			}
		});
		jScrollPane1.setViewportView(jTable1);

		jPanel1.setBorder(javax.swing.BorderFactory
				.createTitledBorder("\u7b5b\u9009\u5b57\u6bb5"));
		jPanel1.setToolTipText("");

		jLabel1.setText("\u5b66\u53f7\uff1a");

		jLabel2.setText("\u59d3\u540d\uff1a");

		jLabel3.setText("\u5c4a\u6b21\uff1a");

		jLabel4.setText("\u90e8\u95e8\uff1a");

		jLabel5.setText("\u4e13\u4e1a\uff1a");

		jCheckBox1.setText("\u5728\u804c");
		jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jCheckBox1ActionPerformed(evt);
			}
		});

		jCheckBox2.setText("\u79bb\u804c");
		jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jCheckBox2ActionPerformed(evt);
			}
		});

		jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] {
				"Item 1", "Item 2", "Item 3", "Item 4" }));
		jComboBox1.addItemListener(new java.awt.event.ItemListener() {
			public void itemStateChanged(java.awt.event.ItemEvent evt) {
				jComboBox1ItemStateChanged(evt);
			}
		});

		jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] {
				"Item 1", "Item 2", "Item 3", "Item 4" }));
		jComboBox2.addItemListener(new java.awt.event.ItemListener() {
			public void itemStateChanged(java.awt.event.ItemEvent evt) {
				jComboBox2ItemStateChanged(evt);
			}
		});

		jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] {
				"Item 1", "Item 2", "Item 3", "Item 4" }));
		jComboBox3.addItemListener(new java.awt.event.ItemListener() {
			public void itemStateChanged(java.awt.event.ItemEvent evt) {
				jComboBox3ItemStateChanged(evt);
			}
		});

		org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(
				jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout
				.setHorizontalGroup(jPanel1Layout
						.createParallelGroup(
								org.jdesktop.layout.GroupLayout.LEADING)
						.add(
								jPanel1Layout
										.createSequentialGroup()
										.addContainerGap()
										.add(
												jPanel1Layout
														.createParallelGroup(
																org.jdesktop.layout.GroupLayout.LEADING,
																false)
														.add(
																jPanel1Layout
																		.createSequentialGroup()
																		.add(
																				jLabel1)
																		.addPreferredGap(
																				org.jdesktop.layout.LayoutStyle.RELATED)
																		.add(
																				jTextField1,
																				org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																				213,
																				org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
														.add(
																jPanel1Layout
																		.createSequentialGroup()
																		.add(
																				jLabel4)
																		.addPreferredGap(
																				org.jdesktop.layout.LayoutStyle.RELATED)
																		.add(
																				jComboBox2,
																				0,
																				org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE)))
										.addPreferredGap(
												org.jdesktop.layout.LayoutStyle.RELATED,
												54, Short.MAX_VALUE)
										.add(
												jPanel1Layout
														.createParallelGroup(
																org.jdesktop.layout.GroupLayout.LEADING,
																false)
														.add(
																jPanel1Layout
																		.createSequentialGroup()
																		.add(
																				jLabel2,
																				org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																				45,
																				org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				org.jdesktop.layout.LayoutStyle.RELATED)
																		.add(
																				jTextField2,
																				org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																				204,
																				org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
														.add(
																jPanel1Layout
																		.createSequentialGroup()
																		.add(
																				jLabel5)
																		.addPreferredGap(
																				org.jdesktop.layout.LayoutStyle.RELATED)
																		.add(
																				jComboBox3,
																				0,
																				org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE)))
										.add(50, 50, 50)
										.add(
												jPanel1Layout
														.createParallelGroup(
																org.jdesktop.layout.GroupLayout.LEADING)
														.add(
																jPanel1Layout
																		.createSequentialGroup()
																		.add(
																				jLabel3)
																		.addPreferredGap(
																				org.jdesktop.layout.LayoutStyle.RELATED)
																		.add(
																				jComboBox1,
																				org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																				220,
																				org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
														.add(
																jPanel1Layout
																		.createSequentialGroup()
																		.add(
																				jCheckBox1)
																		.addPreferredGap(
																				org.jdesktop.layout.LayoutStyle.RELATED)
																		.add(
																				jCheckBox2)))
										.add(15, 15, 15)));
		jPanel1Layout
				.setVerticalGroup(jPanel1Layout
						.createParallelGroup(
								org.jdesktop.layout.GroupLayout.LEADING)
						.add(
								jPanel1Layout
										.createSequentialGroup()
										.add(8, 8, 8)
										.add(
												jPanel1Layout
														.createParallelGroup(
																org.jdesktop.layout.GroupLayout.CENTER)
														.add(jLabel3)
														.add(
																jTextField2,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
														.add(jLabel2)
														.add(
																jTextField1,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
														.add(jLabel1)
														.add(
																jComboBox1,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												org.jdesktop.layout.LayoutStyle.RELATED)
										.add(
												jPanel1Layout
														.createParallelGroup(
																org.jdesktop.layout.GroupLayout.LEADING)
														.add(
																jPanel1Layout
																		.createParallelGroup(
																				org.jdesktop.layout.GroupLayout.CENTER)
																		.add(
																				jLabel4)
																		.add(
																				jComboBox2,
																				org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																				org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																				org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
														.add(
																jPanel1Layout
																		.createParallelGroup(
																				org.jdesktop.layout.GroupLayout.CENTER)
																		.add(
																				jComboBox3,
																				org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																				org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																				org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
																		.add(
																				jLabel5))
														.add(
																jPanel1Layout
																		.createParallelGroup(
																				org.jdesktop.layout.GroupLayout.CENTER)
																		.add(
																				jCheckBox2)
																		.add(
																				jCheckBox1)))
										.addContainerGap(20, Short.MAX_VALUE)));

		jLabel6.setText("\u5b66\u53f7\uff1a");

		jLabel7.setText("\u59d3\u540d\uff1a");

		jLabel8.setText("\u7ec4\u7ec7\uff1a");

		jComboBox4.setModel(new javax.swing.DefaultComboBoxModel(new String[] {
				"Item 1", "Item 2", "Item 3", "Item 4" }));
		jComboBox4.addItemListener(new java.awt.event.ItemListener() {
			public void itemStateChanged(java.awt.event.ItemEvent evt) {
				jComboBox4ItemStateChanged(evt);
			}
		});

		jComboBox5.setModel(new javax.swing.DefaultComboBoxModel(new String[] {
				"Item 1", "Item 2", "Item 3", "Item 4" }));

		jLabel9.setText("\u90e8\u95e8\uff1a");

		jLabel10.setText("\u804c\u52a1\uff1a");

		jLabel11.setText("\u5b66\u9662\uff1a");

		jLabel12.setText("\u4e13\u4e1a\uff1a");

		jLabel13.setText("\u73ed\u7ea7\uff1a");

		buttonGroup1.add(jRadioButton1);
		jRadioButton1.setText("\u7537");

		buttonGroup1.add(jRadioButton2);
		jRadioButton2.setText("\u5973");

		jLabel14.setText("\u6027\u522b\uff1a");

		jLabel15.setText("\u751f\u65e5\uff1a");

		jComboBox6.setModel(new javax.swing.DefaultComboBoxModel(
				new String[] { "1996" }));
		jComboBox6.addItemListener(new java.awt.event.ItemListener() {
			public void itemStateChanged(java.awt.event.ItemEvent evt) {
				jComboBox6ItemStateChanged(evt);
			}
		});

		jComboBox7.setModel(new javax.swing.DefaultComboBoxModel(
				new String[] { "10" }));
		jComboBox7.addItemListener(new java.awt.event.ItemListener() {
			public void itemStateChanged(java.awt.event.ItemEvent evt) {
				jComboBox7ItemStateChanged(evt);
			}
		});

		jComboBox8.setModel(new javax.swing.DefaultComboBoxModel(
				new String[] { "28" }));

		jLabel16.setText("\u5165\u804c\u65e5\u671f\uff1a");

		jComboBox9.setModel(new javax.swing.DefaultComboBoxModel(
				new String[] { "1996" }));
		jComboBox9.addItemListener(new java.awt.event.ItemListener() {
			public void itemStateChanged(java.awt.event.ItemEvent evt) {
				jComboBox9ItemStateChanged(evt);
			}
		});

		jComboBox10.setModel(new javax.swing.DefaultComboBoxModel(
				new String[] { "10" }));
		jComboBox10.addItemListener(new java.awt.event.ItemListener() {
			public void itemStateChanged(java.awt.event.ItemEvent evt) {
				jComboBox10ItemStateChanged(evt);
			}
		});

		jComboBox11.setModel(new javax.swing.DefaultComboBoxModel(
				new String[] { "28" }));

		jLabel17.setText("\u8054\u7cfb\u65b9\u5f0f\uff1a");

		jLabel19.setText("\u5728\u804c\u60c5\u51b5\uff1a");

		buttonGroup2.add(jRadioButton3);
		jRadioButton3.setText("\u5728\u804c");

		buttonGroup2.add(jRadioButton4);
		jRadioButton4.setText("\u79bb\u804c");

		jComboBox12.setModel(new javax.swing.DefaultComboBoxModel(new String[] {
				"Item 1", "Item 2", "Item 3", "Item 4" }));
		jComboBox12.addItemListener(new java.awt.event.ItemListener() {
			public void itemStateChanged(java.awt.event.ItemEvent evt) {
				jComboBox12ItemStateChanged(evt);
			}
		});

		jComboBox13.setModel(new javax.swing.DefaultComboBoxModel(new String[] {
				"Item 1", "Item 2", "Item 3", "Item 4" }));

		jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/ico/close.png"))); // NOI18N
		jButton3.setText("\u5220\u9664\u4eba\u5458");
		jButton3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton3ActionPerformed(evt);
			}
		});

		jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/ico/refresh.png"))); // NOI18N
		jButton2.setText("\u4fee\u6539\u4eba\u5458");
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});

		jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/ico/add.png"))); // NOI18N
		jButton1.setText("\u6dfb\u52a0\u4eba\u5458");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		jLabel20.setText("\u5c4a\u6b21\uff1a");

		org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout
				.setHorizontalGroup(layout
						.createParallelGroup(
								org.jdesktop.layout.GroupLayout.LEADING)
						.add(
								layout
										.createSequentialGroup()
										.add(
												layout
														.createParallelGroup(
																org.jdesktop.layout.GroupLayout.LEADING)
														.add(
																layout
																		.createSequentialGroup()
																		.add(
																				45,
																				45,
																				45)
																		.add(
																				layout
																						.createParallelGroup(
																								org.jdesktop.layout.GroupLayout.LEADING)
																						.add(
																								org.jdesktop.layout.GroupLayout.TRAILING,
																								jLabel11)
																						.add(
																								org.jdesktop.layout.GroupLayout.TRAILING,
																								jLabel6)
																						.add(
																								org.jdesktop.layout.GroupLayout.TRAILING,
																								jLabel8)
																						.add(
																								org.jdesktop.layout.GroupLayout.TRAILING,
																								jLabel14)))
														.add(
																layout
																		.createSequentialGroup()
																		.addContainerGap()
																		.add(
																				jLabel17)))
										.addPreferredGap(
												org.jdesktop.layout.LayoutStyle.RELATED)
										.add(
												layout
														.createParallelGroup(
																org.jdesktop.layout.GroupLayout.LEADING)
														.add(
																layout
																		.createSequentialGroup()
																		.add(
																				layout
																						.createParallelGroup(
																								org.jdesktop.layout.GroupLayout.LEADING,
																								false)
																						.add(
																								jComboBox12,
																								0,
																								org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																								Short.MAX_VALUE)
																						.add(
																								jTextField3,
																								org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																								221,
																								Short.MAX_VALUE)
																						.add(
																								layout
																										.createSequentialGroup()
																										.add(
																												jRadioButton1)
																										.addPreferredGap(
																												org.jdesktop.layout.LayoutStyle.RELATED)
																										.add(
																												jRadioButton2))
																						.add(
																								jComboBox4,
																								0,
																								org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																								Short.MAX_VALUE))
																		.add(
																				52,
																				52,
																				52)
																		.add(
																				layout
																						.createParallelGroup(
																								org.jdesktop.layout.GroupLayout.LEADING)
																						.add(
																								org.jdesktop.layout.GroupLayout.TRAILING,
																								jLabel12)
																						.add(
																								org.jdesktop.layout.GroupLayout.TRAILING,
																								jLabel7)
																						.add(
																								org.jdesktop.layout.GroupLayout.TRAILING,
																								jLabel9)
																						.add(
																								org.jdesktop.layout.GroupLayout.TRAILING,
																								jLabel15))
																		.addPreferredGap(
																				org.jdesktop.layout.LayoutStyle.RELATED)
																		.add(
																				layout
																						.createParallelGroup(
																								org.jdesktop.layout.GroupLayout.LEADING)
																						.add(
																								org.jdesktop.layout.GroupLayout.TRAILING,
																								layout
																										.createSequentialGroup()
																										.add(
																												jComboBox6,
																												0,
																												71,
																												Short.MAX_VALUE)
																										.addPreferredGap(
																												org.jdesktop.layout.LayoutStyle.RELATED)
																										.add(
																												jComboBox7,
																												org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																												52,
																												org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
																										.add(
																												18,
																												18,
																												18)
																										.add(
																												jComboBox8,
																												org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																												55,
																												org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
																						.add(
																								jComboBox13,
																								0,
																								205,
																								Short.MAX_VALUE)
																						.add(
																								jComboBox5,
																								0,
																								205,
																								Short.MAX_VALUE)
																						.add(
																								jTextField4,
																								org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																								205,
																								org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
																		.add(
																				18,
																				18,
																				18))
														.add(
																layout
																		.createSequentialGroup()
																		.add(
																				jTextField6,
																				org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																				225,
																				org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				org.jdesktop.layout.LayoutStyle.RELATED)))
										.add(
												layout
														.createParallelGroup(
																org.jdesktop.layout.GroupLayout.TRAILING)
														.add(jLabel16).add(
																jLabel13).add(
																jLabel10).add(
																jLabel19).add(
																jLabel20))
										.addPreferredGap(
												org.jdesktop.layout.LayoutStyle.RELATED)
										.add(
												layout
														.createParallelGroup(
																org.jdesktop.layout.GroupLayout.LEADING)
														.add(
																org.jdesktop.layout.GroupLayout.TRAILING,
																layout
																		.createSequentialGroup()
																		.add(
																				layout
																						.createParallelGroup(
																								org.jdesktop.layout.GroupLayout.LEADING)
																						.add(
																								org.jdesktop.layout.GroupLayout.TRAILING,
																								layout
																										.createSequentialGroup()
																										.add(
																												jComboBox9,
																												org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																												76,
																												org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
																										.addPreferredGap(
																												org.jdesktop.layout.LayoutStyle.UNRELATED)
																										.add(
																												jComboBox10,
																												0,
																												55,
																												Short.MAX_VALUE)
																										.addPreferredGap(
																												org.jdesktop.layout.LayoutStyle.RELATED)
																										.add(
																												jComboBox11,
																												org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																												58,
																												org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
																						.add(
																								jTextField5,
																								org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																								213,
																								Short.MAX_VALUE)
																						.add(
																								jTextField8,
																								org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																								213,
																								Short.MAX_VALUE)
																						.add(
																								jTextField9,
																								org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																								213,
																								Short.MAX_VALUE))
																		.add(
																				29,
																				29,
																				29))
														.add(
																layout
																		.createSequentialGroup()
																		.add(
																				jRadioButton3)
																		.addPreferredGap(
																				org.jdesktop.layout.LayoutStyle.RELATED)
																		.add(
																				jRadioButton4)
																		.addContainerGap())))
						.add(
								org.jdesktop.layout.GroupLayout.TRAILING,
								layout
										.createSequentialGroup()
										.addContainerGap(15, Short.MAX_VALUE)
										.add(
												layout
														.createParallelGroup(
																org.jdesktop.layout.GroupLayout.TRAILING)
														.add(
																org.jdesktop.layout.GroupLayout.LEADING,
																jPanel1,
																org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.add(
																jScrollPane1,
																org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																936,
																Short.MAX_VALUE))
										.addContainerGap()).add(
								layout.createSequentialGroup().add(207, 207,
										207).add(jButton1).add(64, 64, 64).add(
										jButton2).add(79, 79, 79).add(jButton3)
										.addContainerGap(241, Short.MAX_VALUE)));
		layout
				.setVerticalGroup(layout
						.createParallelGroup(
								org.jdesktop.layout.GroupLayout.LEADING)
						.add(
								layout
										.createSequentialGroup()
										.addContainerGap()
										.add(
												jPanel1,
												org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
												org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
												org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												org.jdesktop.layout.LayoutStyle.RELATED)
										.add(
												jScrollPane1,
												org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
												232,
												org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												org.jdesktop.layout.LayoutStyle.RELATED)
										.add(
												layout
														.createParallelGroup(
																org.jdesktop.layout.GroupLayout.LEADING)
														.add(
																layout
																		.createSequentialGroup()
																		.add(
																				layout
																						.createParallelGroup(
																								org.jdesktop.layout.GroupLayout.LEADING)
																						.add(
																								layout
																										.createSequentialGroup()
																										.add(
																												35,
																												35,
																												35)
																										.add(
																												layout
																														.createParallelGroup(
																																org.jdesktop.layout.GroupLayout.CENTER)
																														.add(
																																jLabel10)
																														.add(
																																jTextField5,
																																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																																org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
																										.addPreferredGap(
																												org.jdesktop.layout.LayoutStyle.RELATED)
																										.add(
																												layout
																														.createParallelGroup(
																																org.jdesktop.layout.GroupLayout.BASELINE)
																														.add(
																																jLabel13)
																														.add(
																																jTextField8,
																																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																																org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
																						.add(
																								layout
																										.createSequentialGroup()
																										.add(
																												layout
																														.createParallelGroup(
																																org.jdesktop.layout.GroupLayout.CENTER)
																														.add(
																																jLabel6)
																														.add(
																																jTextField3,
																																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																																org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
																										.addPreferredGap(
																												org.jdesktop.layout.LayoutStyle.RELATED)
																										.add(
																												layout
																														.createParallelGroup(
																																org.jdesktop.layout.GroupLayout.CENTER)
																														.add(
																																jLabel8)
																														.add(
																																jComboBox4,
																																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																																org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
																										.addPreferredGap(
																												org.jdesktop.layout.LayoutStyle.RELATED)
																										.add(
																												layout
																														.createParallelGroup(
																																org.jdesktop.layout.GroupLayout.BASELINE)
																														.add(
																																jLabel11)
																														.add(
																																jComboBox12,
																																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																																org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
																		.add(
																				9,
																				9,
																				9)
																		.add(
																				layout
																						.createParallelGroup(
																								org.jdesktop.layout.GroupLayout.CENTER)
																						.add(
																								jRadioButton1)
																						.add(
																								jLabel14)
																						.add(
																								jRadioButton2)
																						.add(
																								jLabel16)
																						.add(
																								jComboBox11,
																								org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																								org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																								org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
																						.add(
																								jComboBox9,
																								org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																								org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																								org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
																						.add(
																								jComboBox10,
																								org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																								org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																								org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
																		.addPreferredGap(
																				org.jdesktop.layout.LayoutStyle.RELATED)
																		.add(
																				layout
																						.createParallelGroup(
																								org.jdesktop.layout.GroupLayout.CENTER)
																						.add(
																								jLabel19)
																						.add(
																								jRadioButton3)
																						.add(
																								jRadioButton4)))
														.add(
																layout
																		.createSequentialGroup()
																		.add(
																				layout
																						.createParallelGroup(
																								org.jdesktop.layout.GroupLayout.CENTER)
																						.add(
																								jLabel7)
																						.add(
																								jTextField4,
																								org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																								org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																								org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
																						.add(
																								jTextField9,
																								org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																								org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																								org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
																						.add(
																								jLabel20))
																		.addPreferredGap(
																				org.jdesktop.layout.LayoutStyle.RELATED)
																		.add(
																				layout
																						.createParallelGroup(
																								org.jdesktop.layout.GroupLayout.CENTER)
																						.add(
																								jLabel9)
																						.add(
																								jComboBox5,
																								org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																								org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																								org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
																		.addPreferredGap(
																				org.jdesktop.layout.LayoutStyle.RELATED)
																		.add(
																				layout
																						.createParallelGroup(
																								org.jdesktop.layout.GroupLayout.BASELINE)
																						.add(
																								jLabel12)
																						.add(
																								jComboBox13,
																								org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																								org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																								org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
																		.add(
																				9,
																				9,
																				9)
																		.add(
																				layout
																						.createParallelGroup(
																								org.jdesktop.layout.GroupLayout.CENTER)
																						.add(
																								jLabel15)
																						.add(
																								jComboBox6,
																								org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																								org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																								org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
																						.add(
																								jComboBox7,
																								org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																								org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																								org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
																						.add(
																								jComboBox8,
																								org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																								org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																								org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
																		.addPreferredGap(
																				org.jdesktop.layout.LayoutStyle.RELATED)
																		.add(
																				layout
																						.createParallelGroup(
																								org.jdesktop.layout.GroupLayout.BASELINE)
																						.add(
																								jLabel17)
																						.add(
																								jTextField6,
																								org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																								org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																								org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
										.addPreferredGap(
												org.jdesktop.layout.LayoutStyle.RELATED,
												48, Short.MAX_VALUE)
										.add(
												layout
														.createParallelGroup(
																org.jdesktop.layout.GroupLayout.BASELINE)
														.add(jButton1).add(
																jButton3).add(
																jButton2))
										.addContainerGap()));

		pack();
	}// </editor-fold>
	//GEN-END:initComponents

	private void jTable1MousePressed(java.awt.event.MouseEvent evt) {//点击table
		int index = jTable1.getSelectedRow();
		jTextField3.setText((String) jTable1.getValueAt(index, 0));
		oldID = jTextField3.getText();
		jTextField4.setText((String) jTable1.getValueAt(index, 1));
		otherFunction.setComboboxSelect(jComboBox4, (String) jTable1
				.getValueAt(index, 2));
		otherFunction.setComboboxSelect(jComboBox5, (String) jTable1
				.getValueAt(index, 3));
		jTextField5.setText((String) jTable1.getValueAt(index, 4));
		jTextField9.setText((String) jTable1.getValueAt(index, 5));
		String orgString = "";
		String sqlString = "SELECT SpeCollegeName FROM tb_specialty WHERE SpeName=?";
		String[] psStrings = { (String) jTable1.getValueAt(index, 6) };
		try {
			ResultSet resultSet = sqlFunction.doSqlSelect(sqlString, psStrings,
					false);
			if (resultSet.next()) {
				orgString = resultSet.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		otherFunction.setComboboxSelect(jComboBox12, orgString);
		otherFunction.setComboboxSelect(jComboBox13, (String) jTable1
				.getValueAt(index, 6));
		jTextField8.setText((String) jTable1.getValueAt(index, 7));
		if (((String) jTable1.getValueAt(index, 8)).equals("男")) {
			jRadioButton1.setSelected(true);
		} else {
			jRadioButton2.setSelected(true);
		}
		String[] timeStrings = ((String) jTable1.getValueAt(index, 9))
				.split("-");
		timeStrings[1] = (Integer.parseInt(timeStrings[1])) + "";//转换成int 再转 String 把前面的0去掉
		timeStrings[2] = (Integer.parseInt(timeStrings[2])) + "";//转换成int 再转 String 把前面的0去掉
		otherFunction.setComboboxSelect(jComboBox6, timeStrings[0]);
		otherFunction.setComboboxSelect(jComboBox7, timeStrings[1]);
		otherFunction.setComboboxSelect(jComboBox8, timeStrings[2]);

		timeStrings = ((String) jTable1.getValueAt(index, 10)).split("-");
		timeStrings[1] = (Integer.parseInt(timeStrings[1])) + "";//转换成int 再转 String 把前面的0去掉
		timeStrings[2] = (Integer.parseInt(timeStrings[2])) + "";//转换成int 再转 String 把前面的0去掉
		otherFunction.setComboboxSelect(jComboBox9, timeStrings[0]);
		otherFunction.setComboboxSelect(jComboBox10, timeStrings[1]);
		otherFunction.setComboboxSelect(jComboBox11, timeStrings[2]);
		jTextField6.setText((String) jTable1.getValueAt(index, 11));
		if (((String) jTable1.getValueAt(index, 12)).equals("在职")) {
			jRadioButton3.setSelected(true);
		} else {
			jRadioButton4.setSelected(true);
		}
		jButton2.setEnabled(true);
		jButton3.setEnabled(true);
	}

	//以下都是信息栏和搜索栏的监听（复选框监听/下拉框监听）↓↓↓↓↓
	private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {
		initTable(getPsStrings());
	}

	private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {
		initTable(getPsStrings());
	}

	private void jComboBox3ItemStateChanged(java.awt.event.ItemEvent evt) {
		if (evt.getStateChange() == java.awt.event.ItemEvent.SELECTED) {//不加这个会触发两次，（取消选择/选择）
			initTable(getPsStrings());
		}
	}

	private void jComboBox2ItemStateChanged(java.awt.event.ItemEvent evt) {
		if (evt.getStateChange() == java.awt.event.ItemEvent.SELECTED) {//不加这个会触发两次，（取消选择/选择）
			initTable(getPsStrings());
		}
	}

	private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {
		if (evt.getStateChange() == java.awt.event.ItemEvent.SELECTED) {//不加这个会触发两次，（取消选择/选择）
			initTable(getPsStrings());
		}
	}

	private void jComboBox10ItemStateChanged(java.awt.event.ItemEvent evt) {//重置月份
		if (evt.getStateChange() == java.awt.event.ItemEvent.SELECTED) {//不加这个会触发两次，（取消选择/选择）
			initDayCombobox();
		}
	}

	private void jComboBox9ItemStateChanged(java.awt.event.ItemEvent evt) {//重置年份
		if (evt.getStateChange() == java.awt.event.ItemEvent.SELECTED) {//不加这个会触发两次，（取消选择/选择）
			initDayCombobox();
		}
	}

	private void jComboBox7ItemStateChanged(java.awt.event.ItemEvent evt) {//重置月份
		if (evt.getStateChange() == java.awt.event.ItemEvent.SELECTED) {//不加这个会触发两次，（取消选择/选择）
			initDayCombobox();
		}
	}

	private void jComboBox6ItemStateChanged(java.awt.event.ItemEvent evt) {//重置年份
		if (evt.getStateChange() == java.awt.event.ItemEvent.SELECTED) {//不加这个会触发两次，（取消选择/选择）
			initDayCombobox();
		}
	}

	private void jComboBox12ItemStateChanged(java.awt.event.ItemEvent evt) {//重置学院
		if (evt.getStateChange() == java.awt.event.ItemEvent.SELECTED) {//不加这个会触发两次，（取消选择/选择）
			initSpeCombobox();
		}
	}

	private void jComboBox4ItemStateChanged(java.awt.event.ItemEvent evt) {//重置组织
		if (evt.getStateChange() == java.awt.event.ItemEvent.SELECTED) {//不加这个会触发两次，（取消选择/选择）
			initDepCombobox();
		}
	}
	//上都是信息栏和搜索栏的监听（复选框监听/下拉框监听）↑↑↑↑↑↑↑↑
	
	private void formInternalFrameOpened(//窗体打开初始化所有控件
			javax.swing.event.InternalFrameEvent evt) {
		// add your handling code here:
		OpenSituation.setOpenPersonManage(true);
		initTable(init);
		initSelectCombobox();
		initMessageCombobox();
		jCheckBox1.setSelected(true);
		jCheckBox2.setSelected(true);
		jTextField1.getDocument().addDocumentListener(new DocumentListener() {//对文本框进行文本变换监听
					public void changedUpdate(DocumentEvent e) {
						initTable(getPsStrings());
					}

					public void insertUpdate(DocumentEvent e) {
						initTable(getPsStrings());
					}

					public void removeUpdate(DocumentEvent e) {
						initTable(getPsStrings());
					}
				});
		jTextField2.getDocument().addDocumentListener(new DocumentListener() {//对文本框进行文本变换监听
					public void changedUpdate(DocumentEvent e) {
						initTable(getPsStrings());
					}

					public void insertUpdate(DocumentEvent e) {
						initTable(getPsStrings());
					}

					public void removeUpdate(DocumentEvent e) {
						initTable(getPsStrings());
					}
				});
	}

	private void formInternalFrameClosed(//关闭窗体触发事件
			javax.swing.event.InternalFrameEvent evt) {
		OpenSituation.setOpenPersonManage(false);
	}

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		//  添加人员
		String sqlLanguage = "SELECT * FROM tb_person WHERE PersonNumber = ?";
		String[] psString = { jTextField3.getText() };
		try {
			if (sqlFunction.doSqlSelect(sqlLanguage, psString, false).next()) {
				JOptionPane.showMessageDialog(null, "已经存在当前学号!!");
				return;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (getPsStringsOfVoid() == null) {
			return;
		}
		sqlLanguage = "INSERT tb_person VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		if (sqlFunction.doSqlUpdate(sqlLanguage, getPsStringsOfVoid()) > 0) {
			JOptionPane.showMessageDialog(null, "添加成功!!");
			jButton2.setEnabled(false);
			jButton3.setEnabled(false);
			initSelectCombobox();
			initTable(init);
			return;
		} else {
			System.out.println(getPsStringsOfVoid()[2]);
			JOptionPane.showMessageDialog(null, "未知错误，添加失败!!");
			return;
		}
	}

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
		// 修改人员
		String sqlLanguage = "SELECT * FROM tb_person WHERE PersonNumber = ?";
		String[] psString = { jTextField3.getText() };
		try {
			if (sqlFunction.doSqlSelect(sqlLanguage, psString, false).next()&&!jTextField3.getText().equals(oldID)) {
				JOptionPane.showMessageDialog(null, "已经存在当前学号!!");
				return;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (getPsStringsOfVoid() == null) {
			return;
		}
		sqlLanguage = "UPDATE tb_person SET " +
				"PersonNumber = ?, PersonName = ?, DepId = ?, PersonGrade = ?, " +
						"PersonDuty = ?, SpeName = ?, PersonClass = ?, PersonSex = ?, " +
						"PersonBirthday = ?, PersonJoinDate = ?, PersonTelNumber = ?, PersonInJob = ?, PersonDelete = ? " +
						"WHERE PersonNumber = ?";
		String[] psString1 = new String[14];
		System.out.println(sqlLanguage);
		System.arraycopy(getPsStringsOfVoid(), 0, psString1, 0, 13);
		psString1[13] = oldID;
		if (sqlFunction.doSqlUpdate(sqlLanguage, psString1) > 0) {
			JOptionPane.showMessageDialog(null, "修改成功!!");
			jButton2.setEnabled(false);
			jButton3.setEnabled(false);
			initSelectCombobox();
			initTable(init);
			return;
		} else {
			JOptionPane.showMessageDialog(null, "未知错误，修改失败!!");
			return;
		}
	}

	private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
		// 删除人员
		String sqlLanguage = "UPDATE tb_person SET PersonDelete=0 where PersonNumber = ?";
		String[] psString2 = { oldID };
		int res = JOptionPane.showConfirmDialog(null, "是否删除“" + oldID
				+ "”的专业信息", "是否删除？", JOptionPane.YES_NO_OPTION);
		if (res == JOptionPane.YES_OPTION) {
			String sqlLanguage1 = "SELECT * FROM tb_attendance where PersonNumber= ?";
			String sqlLanguage2 = "SELECT * FROM tb_reward where PersonNumber= ?";
			Object[] options = { "删除这个人员", "取消删除" };
			try {
				if (sqlFunction.doSqlSelect(sqlLanguage1, psString2, false)
						.next()) {
					if (JOptionPane.showOptionDialog(null,
							"此操作将删除此人的所有考勤信息，您真的要删除“" + oldID + "”吗？",
							"警告 ，这个此人存在考勤信息", JOptionPane.DEFAULT_OPTION,
							JOptionPane.WARNING_MESSAGE, null, options,
							options[0]) == 1) {
						return;
					}
					
				} 
				
				if (sqlFunction.doSqlSelect(sqlLanguage2, psString2, false)
						.next()) {					
						if (JOptionPane.showOptionDialog(null,
								"此操作将删除此人的所有奖惩信息，您真的要删除“" + oldID + "”吗？",
								"警告 ，这个此人存在奖惩信息", JOptionPane.DEFAULT_OPTION,
								JOptionPane.WARNING_MESSAGE, null, options,
								options[0]) == 1) {
							return;
						}					
				}
				int x = sqlFunction.doSqlUpdate(sqlLanguage, psString2);
				if (x > 0) {
					JOptionPane.showMessageDialog(null, "删除成功");
					initTable(init);
					initSelectCombobox();
					jButton2.setEnabled(false);
					jButton3.setEnabled(false);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			return;
		}

	}

	private String[] getPsStringsOfVoid() {
		String[] psStrings = new String[13];
		String PersonNumber, PersonName, DepId = "0", PersonGrade, PersonDuty, SpeName, PersonClass, PersonSex, PersonBirthday, PersonJoinDate, PersonTelNumber, PersonInJob, PersonDelete;
		PersonNumber = jTextField3.getText();
		if (PersonNumber.equals("")) {
			JOptionPane.showMessageDialog(null, "学号不能为空!!");
			return null;
		}

		PersonName = jTextField4.getText();
		if (PersonName.equals("")) {
			JOptionPane.showMessageDialog(null, "姓名不能为空!!");
			return null;
		}
		String sqlLanguage = "SELECT DepId FROM tb_department WHERE DepName=? and OrgName=?";
		String[] psString = { jComboBox5.getSelectedItem().toString(),
				jComboBox4.getSelectedItem().toString() };
		ResultSet resultSet = sqlFunction.doSqlSelect(sqlLanguage, psString,
				false);
		try {
			if (resultSet.next()) {
				DepId = resultSet.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		PersonGrade = jTextField9.getText();
		if (PersonGrade.equals("")) {
			JOptionPane.showMessageDialog(null, "届次不能为空!!");
			return null;
		}
		try {
			if (Integer.parseInt(PersonGrade) < 1990
					&& Integer.parseInt(PersonGrade) > 2100) {
				JOptionPane.showMessageDialog(null, "届次需要在1990-2100之间!!");
				return null;
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "届次必须是纯数字!!");
			return null;
		}

		PersonDuty = jTextField5.getText();
		if (PersonDuty.equals("")) {
			JOptionPane.showMessageDialog(null, "职位不能为空!!");
			return null;
		}
		SpeName = jComboBox13.getSelectedItem().toString();
		PersonClass = jTextField8.getText();
		if (PersonClass.equals("")) {
			JOptionPane.showMessageDialog(null, "班级不能为空!!");
			return null;
		}
		if (jRadioButton1.isSelected()) {
			PersonSex = "1";
		} else {
			PersonSex = "0";
		}
		PersonBirthday = jComboBox6.getSelectedItem().toString() + "-"
				+ jComboBox7.getSelectedItem().toString() + "-"
				+ jComboBox8.getSelectedItem().toString();
		PersonJoinDate = jComboBox9.getSelectedItem().toString() + "-"
				+ jComboBox10.getSelectedItem().toString() + "-"
				+ jComboBox11.getSelectedItem().toString();
		PersonTelNumber = jTextField6.getText();
		if (PersonTelNumber.equals("")) {
			JOptionPane.showMessageDialog(null, "联系方式不能为空!!");
			return null;
		}
		if (jRadioButton3.isSelected()) {
			PersonInJob = "1";
		} else {
			PersonInJob = "0";
		}
		PersonDelete = "1";
		psStrings = new String[] { PersonNumber, PersonName, DepId,
				PersonGrade, PersonDuty, SpeName, PersonClass, PersonSex,
				PersonBirthday, PersonJoinDate, PersonTelNumber, PersonInJob,
				PersonDelete };
		return psStrings;
	}

	private String[] getPsStrings() {
		String[] psStrings = { "%", "%", "%", "%", "%", "%", "%" };
		String personNumber = "%", personName = "%", personGrade = "%", depName = "%", speName = "%", personInJob = "%";
		if (!jTextField1.getText().equals("")) {
			personNumber = jTextField1.getText();
		}
		if (!jTextField2.getText().equals("")) {
			personName = jTextField2.getText();
		}
		if (!((String) jComboBox1.getSelectedItem()).equals("所有届次")) {
			personGrade = (String) jComboBox1.getSelectedItem();
		}
		if (!((String) jComboBox2.getSelectedItem()).equals("所有部门")) {
			depName = (String) jComboBox2.getSelectedItem();
		}
		if (!((String) jComboBox3.getSelectedItem()).equals("所有专业")) {
			speName = (String) jComboBox3.getSelectedItem();
		}
		if (jCheckBox1.isSelected() && jCheckBox2.isSelected()) {
			personInJob = "%";
		} else if (jCheckBox1.isSelected()) {
			personInJob = "1";
		} else if (jCheckBox2.isSelected()) {
			personInJob = "0";
		}
		psStrings = new String[] { "%", personNumber, personName, personGrade,
				depName, speName, personInJob };
		return psStrings;
	}

	private void initTable(String[] psStrings) {
		if (AdminLogin.getOrgName().equals("温州商学院")) {
			psStrings[0] = "%";
		} else {
			psStrings[0] = AdminLogin.getOrgName();
			jComboBox2.setEnabled(false);
		}
		//		initTable(psStrings);
		String sqlLanguage = "SELECT * FROM view_person_department "
				+ "where OrgName like ? and PersonNumber like ? and PersonName like ? and PersonGrade like ? "
				+ "and DepName like ? and SpeName like ? and PersonInJob like ? ";
		System.out.println(sqlLanguage);
		otherFunction.selectTable(sqlLanguage, psStrings, jTable1);
		for (int row = 0; row < jTable1.getRowCount(); row++) {
			if (jTable1.getValueAt(row, 8).equals("1")) {
				jTable1.setValueAt("男", row, 8);
			} else {
				jTable1.setValueAt("女", row, 8);
			}

			if (jTable1.getValueAt(row, 12).equals("1")) {
				jTable1.setValueAt("在职", row, 12);
			} else {
				jTable1.setValueAt("离职", row, 12);
			}
		}
	}

	private void initSelectCombobox() {
		String sqlLanguage1 = "SELECT DISTINCT PersonGrade FROM view_person_department ORDER BY PersonGrade";
		jComboBox1.removeAllItems();
		jComboBox1.addItem("所有届次");
		otherFunction.setComboBoxItem(sqlLanguage1, jComboBox1);
		sqlLanguage1 = "SELECT DISTINCT DepName FROM view_person_department ORDER BY DepName";
		jComboBox2.removeAllItems();
		jComboBox2.addItem("所有部门");
		otherFunction.setComboBoxItem(sqlLanguage1, jComboBox2);
		sqlLanguage1 = "SELECT DISTINCT SpeName FROM view_person_department ORDER BY SpeName";
		jComboBox3.removeAllItems();
		jComboBox3.addItem("所有专业");
		otherFunction.setComboBoxItem(sqlLanguage1, jComboBox3);
		jButton2.setEnabled(false);
		jButton3.setEnabled(false);
	}

	private void initMessageCombobox() {
		initDepCombobox();
		initSpeCombobox();

		String sqlLanguage1 = "SELECT OrgName FROM tb_organization";//组织
		jComboBox4.removeAllItems();
		otherFunction.setComboBoxItem(sqlLanguage1, jComboBox4);

		sqlLanguage1 = "SELECT DISTINCT SpeCollegeName FROM tb_specialty";//学院
		jComboBox12.removeAllItems();
		otherFunction.setComboBoxItem(sqlLanguage1, jComboBox12);

		jComboBox6.removeAllItems();//年份
		jComboBox9.removeAllItems();
		for (int i = 1990; i <= 2100; i++) {
			jComboBox6.addItem(i + "");
			jComboBox9.addItem(i + "");
		}
		jComboBox6.setSelectedIndex(30);
		jComboBox9.setSelectedIndex(30);

		initMonthCombobox();
	}

	private void initDepCombobox() {
		String sqlLanguage1 = "SELECT DepName FROM tb_department WHERE OrgName='"//部门
				+ jComboBox4.getSelectedItem() + "'";
		jComboBox5.removeAllItems();
		otherFunction.setComboBoxItem(sqlLanguage1, jComboBox5);
	}

	private void initSpeCombobox() {
		String sqlLanguage1 = "SELECT SpeName FROM tb_specialty WHERE SpeCollegeName='"//专业
				+ jComboBox12.getSelectedItem() + "'";
		jComboBox13.removeAllItems();
		otherFunction.setComboBoxItem(sqlLanguage1, jComboBox13);
	}

	private void initMonthCombobox() {
		jComboBox7.removeAllItems();//月份
		jComboBox10.removeAllItems();
		for (int i = 1; i <= 12; i++) {
			jComboBox7.addItem(i + "");
			jComboBox10.addItem(i + "");
		}
	}

	private void initDayCombobox() {
		jComboBox8.removeAllItems();//日
		jComboBox11.removeAllItems();
		String month = (String) jComboBox7.getSelectedItem();
		String year = (String) jComboBox6.getSelectedItem();
		if (month.equals("1") || month.equals("3") || month.equals("5")
				|| month.equals("7") || month.equals("8") || month.equals("10")
				|| month.equals("12")) {
			for (int i = 1; i <= 31; i++) {
				jComboBox8.addItem(i + "");
			}
		} else if (month.equals("4") || month.equals("6") || month.equals("9")
				|| month.equals("11")) {
			for (int i = 1; i <= 30; i++) {
				jComboBox8.addItem(i + "");
			}
		} else if (month.equals("2") && Integer.parseInt(year) % 4 == 0
				&& !year.equals("2100")) {
			for (int i = 1; i <= 29; i++) {
				jComboBox8.addItem(i + "");
			}
		} else {
			for (int i = 1; i <= 28; i++) {
				jComboBox8.addItem(i + "");
			}
		}

		month = (String) jComboBox10.getSelectedItem();
		year = (String) jComboBox9.getSelectedItem();
		if (month != null && year != null) {
			if (month.equals("1") || month.equals("3") || month.equals("5")
					|| month.equals("7") || month.equals("8")
					|| month.equals("10") || month.equals("12")) {
				for (int i = 1; i <= 31; i++) {
					jComboBox11.addItem(i + "");
				}
			} else if (month.equals("4") || month.equals("6")
					|| month.equals("9") || month.equals("11")) {
				for (int i = 1; i <= 30; i++) {
					jComboBox11.addItem(i + "");
				}
			} else if (month.equals("2") && Integer.parseInt(year) % 4 == 0
					&& !year.equals("2100")) {
				for (int i = 1; i <= 29; i++) {
					jComboBox11.addItem(i + "");
				}
			} else {
				for (int i = 1; i <= 28; i++) {
					jComboBox11.addItem(i + "");
				}
			}
		}
	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.ButtonGroup buttonGroup1;
	private javax.swing.ButtonGroup buttonGroup2;
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JButton jButton3;
	private javax.swing.JCheckBox jCheckBox1;
	private javax.swing.JCheckBox jCheckBox2;
	private javax.swing.JComboBox jComboBox1;
	private javax.swing.JComboBox jComboBox10;
	private javax.swing.JComboBox jComboBox11;
	private javax.swing.JComboBox jComboBox12;
	private javax.swing.JComboBox jComboBox13;
	private javax.swing.JComboBox jComboBox2;
	private javax.swing.JComboBox jComboBox3;
	private javax.swing.JComboBox jComboBox4;
	private javax.swing.JComboBox jComboBox5;
	private javax.swing.JComboBox jComboBox6;
	private javax.swing.JComboBox jComboBox7;
	private javax.swing.JComboBox jComboBox8;
	private javax.swing.JComboBox jComboBox9;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel10;
	private javax.swing.JLabel jLabel11;
	private javax.swing.JLabel jLabel12;
	private javax.swing.JLabel jLabel13;
	private javax.swing.JLabel jLabel14;
	private javax.swing.JLabel jLabel15;
	private javax.swing.JLabel jLabel16;
	private javax.swing.JLabel jLabel17;
	private javax.swing.JLabel jLabel19;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel20;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JLabel jLabel8;
	private javax.swing.JLabel jLabel9;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JRadioButton jRadioButton1;
	private javax.swing.JRadioButton jRadioButton2;
	private javax.swing.JRadioButton jRadioButton3;
	private javax.swing.JRadioButton jRadioButton4;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTable jTable1;
	private javax.swing.JTextField jTextField1;
	private javax.swing.JTextField jTextField2;
	private javax.swing.JTextField jTextField3;
	private javax.swing.JTextField jTextField4;
	private javax.swing.JTextField jTextField5;
	private javax.swing.JTextField jTextField6;
	private javax.swing.JTextField jTextField8;
	private javax.swing.JTextField jTextField9;
	// End of variables declaration//GEN-END:variables

}