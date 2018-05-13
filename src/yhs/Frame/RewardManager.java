package yhs.Frame;

import java.util.List;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.yhs.dao.RewardDao;
import com.yhs.helper.StringHelper;
import com.yhs.model.Reward;

/*
 * RewardManager.java
 *
 * Created on __DATE__, __TIME__
 */

/**
 * 
 * @author __USER__
 */
public class RewardManager extends javax.swing.JInternalFrame {
	private RewardDao rewardDao;

	/** Creates new form RewardManager */
	public RewardManager() {
		initComponents();
		String[] psString = {};
		fillTable(new Reward(), psString);
	}

	private void clearText() {
		// jTextFieldPersonNumberSearch.setText("");
		// jTextFieldRewardContentSearch.setText("");
		// jTextFieldPunishContentSearch.setText("");
		jTextFieldRewardID.setText("");
		jTextFieldPersonNumber.setText("");
		jTextFieldRewardContent.setText("");
		jTextFieldPunishContent.setText("");
		jTextAreaRewardPs.setText("");
	}

	// 填充表格
	private void fillTable(Reward reward, String[] psString) {
		DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
		dtm.setRowCount(0);

		rewardDao = new RewardDao();

		List<Reward> listReward = rewardDao.list(reward, psString);
		Reward rewardTemp;

		if (listReward.size() != 0) {
			for (int i = 0; i < listReward.size(); i++) {
				rewardTemp = listReward.get(i);
				Vector v = new Vector();
				v.add(rewardTemp.getRewardID());
				v.add(rewardTemp.getRewardContent());
				v.add(rewardTemp.getPunishContent());
				v.add(rewardTemp.getPersonNumber());
				v.add(rewardTemp.getRewardPs());
				dtm.addRow(v);
			}
		}
	}

	// 点击表格填充数据
	private void jTable1MousePressed(java.awt.event.MouseEvent evt) {
		// TODO add your handling code here:
		int row = this.jTable1.getSelectedRow();

		jTextFieldRewardID.setText(jTable1.getValueAt(row, 0).toString());
		try {
			if (StringHelper.isEmpty(jTable1.getValueAt(row, 1) + "")
					|| jTable1.getValueAt(row, 1) == null) {
				jTextFieldRewardContent.setText("");
			} else {
				jTextFieldRewardContent.setText(jTable1.getValueAt(row, 1)
						.toString());
			}

			if (StringHelper.isEmpty(jTable1.getValueAt(row, 2) + "")
					|| jTable1.getValueAt(row, 2) == null) {
				jTextFieldPunishContent.setText("");
			} else {
				jTextFieldPunishContent.setText(jTable1.getValueAt(row, 2)
						.toString());
			}

			if (StringHelper.isEmpty(jTable1.getValueAt(row, 4) + "")
					|| jTable1.getValueAt(row, 4) == null) {
				jTextAreaRewardPs.setText("");
			} else {
				jTextAreaRewardPs
						.setText(jTable1.getValueAt(row, 4).toString());
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		jTextFieldPersonNumber.setText(jTable1.getValueAt(row, 3).toString());

	}

	// 删除按钮
	private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {
		String RewardID = jTextFieldRewardID.getText();
		if (StringHelper.isEmpty(RewardID)) {
			JOptionPane.showMessageDialog(null, "请选择要删除的记录");
			return;
		}

		Reward reward = new Reward();
		reward.setRewardID(Integer.parseInt(RewardID));
		try {
			rewardDao = new RewardDao();
			int n = rewardDao.DeleteReward(reward);
			if (n > 0) {
				JOptionPane.showMessageDialog(null, "记录删除成功");
				// clearText();
			} else {

				JOptionPane.showMessageDialog(null, "记录删除失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			String[] psString = {};
			fillTable(new Reward(), psString);
		}

	}

	// 修改按钮
	private void jButtonModifyActionPerformed(java.awt.event.ActionEvent evt) {
		String RewardID = jTextFieldRewardID.getText();
		if (StringHelper.isEmpty(RewardID)) {
			JOptionPane.showMessageDialog(null, "请选择要删除的记录");
			return;
		}

		String PersonNumber = jTextFieldPersonNumber.getText();
		String RewardContent = jTextFieldRewardContent.getText();
		String PunishContent = jTextFieldPunishContent.getText();
		String RewardPs = jTextAreaRewardPs.getText();

		if (StringHelper.isEmpty(PersonNumber)) {
			JOptionPane.showMessageDialog(null, "请填写学生编号");
			return;
		}

		if (!StringHelper.isEmpty(RewardContent)
				&& !StringHelper.isEmpty(PunishContent)) {
			JOptionPane.showMessageDialog(null, "请勿填选两种信息");
			return;
		}

		if (StringHelper.isEmpty(RewardContent)
				&& StringHelper.isEmpty(PunishContent)) {
			JOptionPane.showMessageDialog(null, "请选填奖励或惩罚信息");
			return;
		}

		Reward reward = new Reward();
		reward.setPersonNumber(PersonNumber);
		reward.setRewardID(Integer.parseInt(RewardID));
		if (StringHelper.isEmpty(RewardContent)) {
			reward.setRewardContent("");
		} else {
			reward.setRewardContent(RewardContent);
		}

		if (StringHelper.isEmpty(PunishContent)) {
			reward.setPunishContent("");
		} else {
			reward.setPunishContent(PunishContent);
		}

		if (StringHelper.isEmpty(RewardPs)) {
			reward.setRewardPs("");
		} else {
			reward.setRewardPs(RewardPs);
		}

		rewardDao = new RewardDao();
		try {
			int n = rewardDao.ModifyReward(reward);
			if (n > 0) {
				JOptionPane.showMessageDialog(null, "记录修改成功");
				// clearText();
			} else {
				JOptionPane.showMessageDialog(null, "记录修改失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			String[] psString = {};
			fillTable(new Reward(), psString);
		}
	}

	// 增加记录
	private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {
		String PersonNumber = jTextFieldPersonNumber.getText();
		String RewardContent = jTextFieldRewardContent.getText();
		String PunishContent = jTextFieldPunishContent.getText();
		String RewardPs = jTextAreaRewardPs.getText();

		if (StringHelper.isEmpty(PersonNumber)) {
			JOptionPane.showMessageDialog(null, "请填写学生编号");
			return;
		}

		if (!StringHelper.isEmpty(RewardContent)
				&& !StringHelper.isEmpty(PunishContent)) {
			JOptionPane.showMessageDialog(null, "请勿填选两种信息");
			return;
		}

		if (StringHelper.isEmpty(RewardContent)
				&& StringHelper.isEmpty(PunishContent)) {
			JOptionPane.showMessageDialog(null, "请选填奖励或惩罚信息");
			return;
		}

		Reward reward = new Reward();
		reward.setPersonNumber(PersonNumber);
		if (StringHelper.isEmpty(RewardContent)) {
			reward.setRewardContent("");
		} else {
			reward.setRewardContent(RewardContent);
		}

		if (StringHelper.isEmpty(PunishContent)) {
			reward.setPunishContent("");
		} else {
			reward.setPunishContent(PunishContent);
		}

		if (StringHelper.isEmpty(RewardPs)) {
			reward.setRewardPs("");
		} else {
			reward.setRewardPs(RewardPs);
		}

		rewardDao = new RewardDao();
		try {
			int n = rewardDao.AddReward(reward);
			if (n > 0) {
				JOptionPane.showMessageDialog(null, "记录添加成功");
				// clearText();
			} else if (n == -1) {
				JOptionPane.showMessageDialog(null, "您没有权限添加记录");
				// clearText();
			} else {
				JOptionPane.showMessageDialog(null, "记录添加失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			String[] psString = {};
			fillTable(new Reward(), psString);
		}

	}

	// 搜索
	private void jButtonSearchActionPerformed(java.awt.event.ActionEvent evt) {
		// String RewardID = jTextFieldRewardIDSearch.getText();
		String PersonNumber = jTextFieldPersonNumberSearch.getText() + "";
		String RewardContent = jTextFieldRewardContentSearch.getText() + "";
		String PunishContent = jTextFieldPunishContentSearch.getText() + "";

		Reward reward = new Reward();
		// reward.setRewardID(Integer.parseInt(RewardID));
		reward.setPersonNumber(PersonNumber);
		reward.setRewardContent(RewardContent);
		reward.setPunishContent(PunishContent);
		String[] psString = { reward.getRewardContent(),
				reward.getPunishContent(), reward.getPersonNumber() };
		fillTable(reward, psString);
	}

	// GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JButton jButtonAdd;
	private javax.swing.JButton jButtonDelete;
	private javax.swing.JButton jButtonModify;
	private javax.swing.JButton jButtonSearch;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JLabel jLabel8;
	private javax.swing.JLabel jLabel9;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane3;
	private javax.swing.JTable jTable1;
	private javax.swing.JTextArea jTextAreaRewardPs;
	private javax.swing.JTextField jTextFieldPersonNumber;
	private javax.swing.JTextField jTextFieldPersonNumberSearch;
	private javax.swing.JTextField jTextFieldPunishContent;
	private javax.swing.JTextField jTextFieldPunishContentSearch;
	private javax.swing.JTextField jTextFieldRewardContent;
	private javax.swing.JTextField jTextFieldRewardContentSearch;
	private javax.swing.JTextField jTextFieldRewardID;
	private javax.swing.JTextField jTextFieldRewardIDSearch;

	// End of variables declaration//GEN-END:variables

	// GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jPanel1 = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		jTextFieldRewardIDSearch = new javax.swing.JTextField();
		jLabel2 = new javax.swing.JLabel();
		jTextFieldPersonNumberSearch = new javax.swing.JTextField();
		jLabel3 = new javax.swing.JLabel();
		jTextFieldRewardContentSearch = new javax.swing.JTextField();
		jLabel4 = new javax.swing.JLabel();
		jTextFieldPunishContentSearch = new javax.swing.JTextField();
		jButtonSearch = new javax.swing.JButton();
		jScrollPane1 = new javax.swing.JScrollPane();
		jTable1 = new javax.swing.JTable();
		jPanel2 = new javax.swing.JPanel();
		jLabel5 = new javax.swing.JLabel();
		jTextFieldRewardID = new javax.swing.JTextField();
		jLabel6 = new javax.swing.JLabel();
		jTextFieldPersonNumber = new javax.swing.JTextField();
		jLabel7 = new javax.swing.JLabel();
		jTextFieldRewardContent = new javax.swing.JTextField();
		jLabel8 = new javax.swing.JLabel();
		jTextFieldPunishContent = new javax.swing.JTextField();
		jLabel9 = new javax.swing.JLabel();
		jScrollPane3 = new javax.swing.JScrollPane();
		jTextAreaRewardPs = new javax.swing.JTextArea();
		jButtonModify = new javax.swing.JButton();
		jButtonAdd = new javax.swing.JButton();
		jButtonDelete = new javax.swing.JButton();

		setTitle("\u5956\u60e9\u7ba1\u7406");

		jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(
				javax.swing.BorderFactory.createLineBorder(new java.awt.Color(
						0, 0, 0)), "\u641c\u7d22\u6761\u4ef6"));

		jLabel1.setText("\u5956\u60e9\u7f16\u53f7");

		jTextFieldRewardIDSearch.setEnabled(false);

		jLabel2.setText("\u5b66\u751f\u5b66\u53f7");

		jLabel3.setText("\u5956\u52b1\u4fe1\u606f");

		jLabel4.setText("\u60e9\u7f5a\u4fe1\u606f");

		jButtonSearch.setText("\u641c\u7d22");
		jButtonSearch.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonSearchActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(
				jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout
				.setHorizontalGroup(jPanel1Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel1Layout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																jPanel1Layout
																		.createSequentialGroup()
																		.addComponent(
																				jLabel1)
																		.addGap(
																				12,
																				12,
																				12)
																		.addComponent(
																				jTextFieldRewardIDSearch,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				70,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addGap(
																				18,
																				18,
																				18)
																		.addComponent(
																				jLabel2)
																		.addGap(
																				18,
																				18,
																				18)
																		.addComponent(
																				jTextFieldPersonNumberSearch,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				70,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addGap(
																				18,
																				18,
																				18)
																		.addComponent(
																				jButtonSearch))
														.addGroup(
																jPanel1Layout
																		.createSequentialGroup()
																		.addComponent(
																				jLabel3)
																		.addGap(
																				12,
																				12,
																				12)
																		.addComponent(
																				jTextFieldRewardContentSearch,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				70,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addGap(
																				18,
																				18,
																				18)
																		.addComponent(
																				jLabel4)
																		.addGap(
																				18,
																				18,
																				18)
																		.addComponent(
																				jTextFieldPunishContentSearch,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				70,
																				javax.swing.GroupLayout.PREFERRED_SIZE)))
										.addContainerGap(13, Short.MAX_VALUE)));
		jPanel1Layout
				.setVerticalGroup(jPanel1Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel1Layout
										.createSequentialGroup()
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																jPanel1Layout
																		.createSequentialGroup()
																		.addGroup(
																				jPanel1Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.BASELINE)
																						.addComponent(
																								jLabel1)
																						.addComponent(
																								jLabel2)
																						.addComponent(
																								jTextFieldPersonNumberSearch,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								jTextFieldRewardIDSearch,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.PREFERRED_SIZE))
																		.addGap(
																				18,
																				18,
																				18)
																		.addGroup(
																				jPanel1Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.BASELINE)
																						.addComponent(
																								jLabel3)
																						.addComponent(
																								jLabel4)
																						.addComponent(
																								jTextFieldRewardContentSearch,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								jTextFieldPunishContentSearch,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.PREFERRED_SIZE)))
														.addGroup(
																jPanel1Layout
																		.createSequentialGroup()
																		.addContainerGap()
																		.addComponent(
																				jButtonSearch)))
										.addContainerGap(
												javax.swing.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)));

		jTable1.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] {

				}, new String[] { "奖惩编号", "奖励信息", "惩罚信息", "学生学号", "奖惩备注" }) {
			boolean[] canEdit = new boolean[] { false, false, false, false,
					false };

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

		jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(
				javax.swing.BorderFactory.createLineBorder(new java.awt.Color(
						0, 0, 0)), "\u8be6\u7ec6\u4fe1\u606f"));

		jLabel5.setText("\u5956\u60e9\u7f16\u53f7");

		jTextFieldRewardID.setEnabled(false);

		jLabel6.setText("\u5b66\u751f\u5b66\u53f7");

		jLabel7.setText("\u5956\u52b1\u4fe1\u606f");

		jLabel8.setText("\u60e9\u7f5a\u4fe1\u606f");

		jLabel9.setText("\u5956\u60e9\u5907\u6ce8");

		jTextAreaRewardPs.setColumns(20);
		jTextAreaRewardPs.setRows(5);
		jScrollPane3.setViewportView(jTextAreaRewardPs);

		jButtonModify.setText("\u4fee\u6539");
		jButtonModify.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonModifyActionPerformed(evt);
			}
		});

		jButtonAdd.setText("\u6dfb\u52a0");
		jButtonAdd.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonAddActionPerformed(evt);
			}
		});

		jButtonDelete.setText("\u5220\u9664");
		jButtonDelete.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonDeleteActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(
				jPanel2);
		jPanel2.setLayout(jPanel2Layout);
		jPanel2Layout
				.setHorizontalGroup(jPanel2Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel2Layout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												jPanel2Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																jPanel2Layout
																		.createSequentialGroup()
																		.addComponent(
																				jLabel5)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																		.addComponent(
																				jTextFieldRewardID,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				90,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																				54,
																				Short.MAX_VALUE)
																		.addComponent(
																				jLabel6)
																		.addGap(
																				18,
																				18,
																				18)
																		.addComponent(
																				jTextFieldPersonNumber,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				90,
																				javax.swing.GroupLayout.PREFERRED_SIZE))
														.addGroup(
																jPanel2Layout
																		.createSequentialGroup()
																		.addComponent(
																				jLabel7)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																		.addComponent(
																				jTextFieldRewardContent,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				300,
																				Short.MAX_VALUE))
														.addGroup(
																jPanel2Layout
																		.createSequentialGroup()
																		.addComponent(
																				jLabel8)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																		.addComponent(
																				jTextFieldPunishContent,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				300,
																				javax.swing.GroupLayout.PREFERRED_SIZE))
														.addGroup(
																jPanel2Layout
																		.createSequentialGroup()
																		.addComponent(
																				jLabel9)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																		.addComponent(
																				jScrollPane3,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				300,
																				Short.MAX_VALUE))
														.addGroup(
																jPanel2Layout
																		.createSequentialGroup()
																		.addComponent(
																				jButtonAdd,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				95,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addGap(
																				35,
																				35,
																				35)
																		.addComponent(
																				jButtonModify,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				99,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																				33,
																				Short.MAX_VALUE)
																		.addComponent(
																				jButtonDelete,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				98,
																				javax.swing.GroupLayout.PREFERRED_SIZE)))
										.addContainerGap()));
		jPanel2Layout
				.setVerticalGroup(jPanel2Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel2Layout
										.createSequentialGroup()
										.addGroup(
												jPanel2Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel5)
														.addComponent(
																jTextFieldRewardID,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																jTextFieldPersonNumber,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(jLabel6))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addGroup(
												jPanel2Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel7)
														.addComponent(
																jTextFieldRewardContent,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addGroup(
												jPanel2Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel8)
														.addComponent(
																jTextFieldPunishContent,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addGroup(
												jPanel2Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(jLabel9)
														.addComponent(
																jScrollPane3,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addGroup(
												jPanel2Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																jButtonModify)
														.addComponent(
																jButtonDelete)
														.addComponent(
																jButtonAdd))
										.addContainerGap(22, Short.MAX_VALUE)));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				layout.createSequentialGroup().addContainerGap().addGroup(
						layout.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jPanel2,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jScrollPane1, 0, 0,
										Short.MAX_VALUE).addComponent(jPanel1,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)).addContainerGap()));
		layout
				.setVerticalGroup(layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								layout
										.createSequentialGroup()
										.addComponent(
												jPanel1,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(
												jScrollPane1,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												169,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(
												jPanel2,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addContainerGap()));

		pack();
	}// </editor-fold>
	// GEN-END:initComponents

}