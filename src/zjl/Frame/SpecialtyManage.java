/*
 * SpecialtyManage.java
 *
 * Created on __DATE__, __TIME__
 */

package zjl.Frame;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import other.wzbcOrg.AdminLogin;
import other.wzbcOrg.OpenSituation;
import other.wzbcOrg.OtherFunction;
import other.wzbcOrg.SqlFunction;

/**
 *
 * @author  __USER__
 */
public class SpecialtyManage extends javax.swing.JInternalFrame {
	OtherFunction otherFunction = new OtherFunction();
	SqlFunction sqlFunction = new SqlFunction();
	String[] psString = { "" };
	String oldName = "";

	/** Creates new form SpecialtyManage */
	public SpecialtyManage() {
		initComponents();
	}

	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jScrollPane1 = new javax.swing.JScrollPane();
		jTable1 = new javax.swing.JTable();
		jComboBox1 = new javax.swing.JComboBox();
		jLabel1 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		jTextField1 = new javax.swing.JTextField();
		jTextField2 = new javax.swing.JTextField();
		jButton1 = new javax.swing.JButton();
		jButton2 = new javax.swing.JButton();
		jButton3 = new javax.swing.JButton();

		setMaximizable(true);
		setTitle("\u4e13\u4e1a\u7ba1\u7406");
		addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
			public void internalFrameActivated(
					javax.swing.event.InternalFrameEvent evt) {
			}

			public void internalFrameClosed(
					javax.swing.event.InternalFrameEvent evt) {
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

				}, new String[] { "专业名", "所在学院", "专业人数" }) {
			Class[] types = new Class[] { java.lang.String.class,
					java.lang.String.class, java.lang.String.class };
			boolean[] canEdit = new boolean[] { false, false, false };

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

		jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] {
				"Item 1", "Item 2", "Item 3", "Item 4" }));
		jComboBox1.addItemListener(new java.awt.event.ItemListener() {
			public void itemStateChanged(java.awt.event.ItemEvent evt) {
				jComboBox1ItemStateChanged(evt);
			}
		});

		jLabel1.setText("\u6240\u5728\u5b66\u9662\uff1a");

		jLabel3.setText("\u4e13\u4e1a\u540d\uff1a");

		jLabel4.setText("\u6240\u5728\u5b66\u9662\uff1a");

		jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/ico/add.png"))); // NOI18N
		jButton1.setText("\u6dfb\u52a0\u4e13\u4e1a");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/ico/refresh.png"))); // NOI18N
		jButton2.setText("\u4fee\u6539\u4e13\u4e1a");
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});

		jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/ico/close.png"))); // NOI18N
		jButton3.setText("\u5220\u9664\u4e13\u4e1a");
		jButton3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton3ActionPerformed(evt);
			}
		});

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
										.addContainerGap()
										.add(
												layout
														.createParallelGroup(
																org.jdesktop.layout.GroupLayout.LEADING)
														.add(
																layout
																		.createSequentialGroup()
																		.add(
																				jButton1)
																		.addPreferredGap(
																				org.jdesktop.layout.LayoutStyle.RELATED)
																		.add(
																				jButton2)
																		.addPreferredGap(
																				org.jdesktop.layout.LayoutStyle.RELATED)
																		.add(
																				jButton3))
														.add(
																layout
																		.createSequentialGroup()
																		.add(
																				62,
																				62,
																				62)
																		.add(
																				layout
																						.createParallelGroup(
																								org.jdesktop.layout.GroupLayout.TRAILING)
																						.add(
																								jLabel3)
																						.add(
																								jLabel4))
																		.addPreferredGap(
																				org.jdesktop.layout.LayoutStyle.RELATED)
																		.add(
																				layout
																						.createParallelGroup(
																								org.jdesktop.layout.GroupLayout.LEADING)
																						.add(
																								jTextField2,
																								org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																								200,
																								org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
																						.add(
																								jTextField1,
																								org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																								200,
																								org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
										.add(15, 15, 15)
										.add(
												layout
														.createParallelGroup(
																org.jdesktop.layout.GroupLayout.LEADING)
														.add(
																layout
																		.createSequentialGroup()
																		.add(
																				jLabel1)
																		.addPreferredGap(
																				org.jdesktop.layout.LayoutStyle.RELATED)
																		.add(
																				jComboBox1,
																				org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																				186,
																				org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
														.add(
																jScrollPane1,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																332,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
										.addContainerGap(30, Short.MAX_VALUE)));
		layout
				.setVerticalGroup(layout
						.createParallelGroup(
								org.jdesktop.layout.GroupLayout.LEADING)
						.add(
								layout
										.createSequentialGroup()
										.addContainerGap()
										.add(
												layout
														.createParallelGroup(
																org.jdesktop.layout.GroupLayout.BASELINE)
														.add(
																jComboBox1,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
														.add(jLabel1))
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
																								org.jdesktop.layout.GroupLayout.BASELINE)
																						.add(
																								jLabel3)
																						.add(
																								jTextField1,
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
																								jLabel4)
																						.add(
																								jTextField2,
																								org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																								org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																								org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
																		.add(
																				101,
																				101,
																				101)
																		.add(
																				layout
																						.createParallelGroup(
																								org.jdesktop.layout.GroupLayout.BASELINE)
																						.add(
																								jButton1)
																						.add(
																								jButton2)
																						.add(
																								jButton3))
																		.add(
																				101,
																				101,
																				101))
														.add(
																org.jdesktop.layout.GroupLayout.TRAILING,
																jScrollPane1,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																372,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
										.addContainerGap(30, Short.MAX_VALUE)));

		pack();
	}// </editor-fold>
	//GEN-END:initComponents

	private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {
		if (evt.getStateChange() == java.awt.event.ItemEvent.SELECTED) {//不加这个会触发两次，（取消选择/选择）
			doSelectTable();
		}
	}

	private void doSelectTable() {
		String[] psStrings = { (String) jComboBox1.getSelectedItem() };
		if (psStrings[0].equals("所有学院")) {
			psStrings[0] = "%";
		}
		initTable(psStrings);
	}

	private void jTable1MousePressed(java.awt.event.MouseEvent evt) {
		int index = jTable1.getSelectedRow();
		jTextField1.setText((String) jTable1.getValueAt(index, 0));
		jTextField2.setText((String) jTable1.getValueAt(index, 1));
		oldName = (String) jTable1.getValueAt(index, 0);
		jButton2.setEnabled(true);
		jButton3.setEnabled(true);
	}

	private void formInternalFrameOpened(
			javax.swing.event.InternalFrameEvent evt) {
		OpenSituation.setOpenDepartManage(true);
		initTable(psString);
		initCombobox();
	}

	private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
		//删除专业
		String sqlLanguage = "DELETE tb_specialty where speName = ?";
		String[] psString2 = { oldName };
		int res = JOptionPane.showConfirmDialog(null, "是否删除“" + oldName
				+ "”的专业信息", "是否删除？", JOptionPane.YES_NO_OPTION);
		if (res == JOptionPane.YES_OPTION) {
			String sqlLanguage1 = "SELECT * FROM tb_person where SpeName= ?";
			String[] psString1 = { oldName };
			try {
				if (sqlFunction.doSqlSelect(sqlLanguage1, psString1, false)
						.next()) {
					Object[] options = { "删除这个专业", "取消删除" };
					if (JOptionPane.showOptionDialog(null,
							"此操作将删除专业下的所有人员，您真的要删除“" + oldName + "”的专业信息吗？",
							"警告 ，这个专业下有人员存在", JOptionPane.DEFAULT_OPTION,
							JOptionPane.WARNING_MESSAGE, null, options,
							options[0]) == 0) {
						int x = sqlFunction.doSqlUpdate(sqlLanguage, psString2);
						if (x > 0) {
							System.out.println(x);
							JOptionPane.showMessageDialog(null, "删除成功");
							initTable(psString);
							jButton2.setEnabled(false);
							jButton3.setEnabled(false);
						}
					} else {
						return;
					}

				} else {
					int x = sqlFunction.doSqlUpdate(sqlLanguage, psString2);
					if (x > 0) {
						JOptionPane.showMessageDialog(null, "删除成功");
						initTable(psString);
						initCombobox();
						jButton2.setEnabled(false);
						jButton3.setEnabled(false);
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			return;
		}
	}

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
		//修改专业, , speGrade;
		String sqlLanguage = "UPDATE tb_specialty SET speName = ? , speCollegeName = ? where speName = ?";
		String[] psString1 = new String[3];
		System.arraycopy(getStrings(), 0, psString1, 0, 2);
		psString1[2] = oldName;
		if (psString1 == null) {
			return;
		}
		
		int res = JOptionPane.showConfirmDialog(null, "是否修改”" + oldName
				+ "“的专业的信息", "是否修改", JOptionPane.YES_NO_OPTION);
		if (res == JOptionPane.YES_OPTION) {
			System.out.println(psString1[0]+psString1[1]+psString1[2]+sqlLanguage);
			int x = sqlFunction.doSqlUpdate(sqlLanguage, psString1);
			if (x > 0) {
				JOptionPane.showMessageDialog(null, "修改成功");
				initTable(psString);
				initCombobox();
				jButton2.setEnabled(false);
				jButton3.setEnabled(false);
			}
		} else {
			return;
		}
	}

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		// 添加专业
		String sqlLanguage = "INSERT tb_specialty(speName, speCollegeName) VALUES(?,?) ";
		oldName = "防止重名WD23";
		String[] psString1 = getStrings();
		if (psString1 == null) {
			return;
		}
		int x = sqlFunction.doSqlUpdate(sqlLanguage, psString1);
		if (x > 0) {
			System.out.println(x);
			JOptionPane.showMessageDialog(null, "插入成功");
			initTable(psString);
			initCombobox();
			jButton2.setEnabled(false);
			jButton3.setEnabled(false);
		}
	}

	private String[] getStrings() {//获取增删改的内容
		String speName, speCollegeName, speGrade;
		speName = jTextField1.getText();
		speCollegeName = jTextField2.getText();
		if (speName.equals("") || speCollegeName.equals("")) {
			JOptionPane.showMessageDialog(null, "专业名,所在学院，届次均不能为空!!");
			return null;
		}

		String sqlLanguage1 = "SELECT * FROM tb_specialty WHERE SpeName = ?";
		String[] psString1 = { speName };
		try {
			if (sqlFunction.doSqlSelect(sqlLanguage1, psString1, false).next()
					&& !speName.equals(oldName)) {
				JOptionPane.showMessageDialog(null, "已经存在当前用户名!!");
				oldName = speName;
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String[] psString = { speName, speCollegeName, };		
		return psString;
		
	}

	private void initTable(String[] psStrings) {
		String sqlLanguage = "EXEC proc_SelectSpecialtyWithCountPerson ?";
		otherFunction.selectTable(sqlLanguage, psStrings, jTable1);
	}

	private void initCombobox() {
		String sqlLanguage1 = "SELECT DISTINCT SpeCollegeName FROM tb_specialty";
		jComboBox1.removeAllItems();
		jComboBox1.addItem("所有学院");
		otherFunction.setComboBoxItem(sqlLanguage1, jComboBox1);
		sqlLanguage1 = "SELECT DISTINCT SpeGrade FROM tb_specialty ORDER BY SpeGrade";
		jButton2.setEnabled(false);
		jButton3.setEnabled(false);
	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JButton jButton3;
	private javax.swing.JComboBox jComboBox1;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTable jTable1;
	private javax.swing.JTextField jTextField1;
	private javax.swing.JTextField jTextField2;
	// End of variables declaration//GEN-END:variables

}