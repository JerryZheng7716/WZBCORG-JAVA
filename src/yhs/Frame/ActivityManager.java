package yhs.Frame;

import java.util.List;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import other.wzbcOrg.AdminLogin;

import com.yhs.dao.*;
import com.yhs.helper.DateHelper;
import com.yhs.helper.StringHelper;
import com.yhs.model.*;
import com.yhs.Observer.ActivityController;
import com.yhs.Observer.ActivityObserver;
import com.yhs.Observer.Controller;
import com.yhs.Observer.Observer;

/*
 * ActivityManager.java
 *
 * Created on __DATE__, __TIME__
 */

/**
 * 
 * @author __USER__
 */
public class ActivityManager extends javax.swing.JInternalFrame {
	private ActivityDao activityDao = new ActivityDao();
	private OrganizationDao organizationDao = new OrganizationDao();
	private Controller activityController;
	private Observer activityObserver;
	private Activity activity;

	private String AdminOrgName = AdminLogin.getOrgName();

	/** Creates new form ActivityManager */
	public ActivityManager() {
		initComponents();
		jComboBoxSearchOrgName.removeAllItems();
		jComboBoxOrgName.removeAllItems();
		if (AdminOrgName.equals("温州商学院")) {
			fillOrgName("Search");
		} else {
			Organization organization = new Organization();
			organization.setOrgName(AdminOrgName);
			this.jComboBoxSearchOrgName.addItem(organization);
			jComboBoxSearchOrgName.setEnabled(false);
		}
		fillOrgName("Details");

		activity = new Activity("", "", "", "");
		activityController = new ActivityController(activity);
		activityObserver = new ActivityObserver(
				((ActivityController) activityController).getActivity(),
				jTable1, activityDao);
		activityController.addObserver(activityObserver);
		activityController.notifyUpdate();
	}

	// 下拉框
	private void fillOrgName(String s) {
		List<Organization> listOrganizations = organizationDao
				.list(new Organization());
		Organization organization = null;
		if ("Search".equals(s)) {
			organization = new Organization();
			organization.setOrgName("请选择");
			this.jComboBoxSearchOrgName.addItem(organization);
		}
		if (listOrganizations.size() != 0) {
			for (int i = 0; i < listOrganizations.size(); i++) {
				organization = listOrganizations.get(i);
				if ("Search".equals(s)) {
					jComboBoxSearchOrgName.addItem(organization);
				} else if ("Details".equals(s)) {
					jComboBoxOrgName.addItem(organization);
				}
			}
		}

	}

	// 填充表格
	private void fillTable(String[] psString) {
		DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
		dtm.setRowCount(0);

		List<Activity> listActivity = activityDao.list(psString);
		Activity activity = null;
		if (listActivity.size() != 0) {
			for (int i = 0; i < listActivity.size(); i++) {
				activity = listActivity.get(i);
				Vector v = new Vector();
				v.add(activity.getActivityID());
				v.add(activity.getActivityName());
				v.add(activity.getActivityPlace());
				v.add(activity.getActivityTime());
				v.add(activity.getOrgName());
				v.add(activity.getActivityPs());
				dtm.addRow(v);
			}
		}
	}

	// 表格点击 填充信息
	private void jTable1MousePressed(java.awt.event.MouseEvent evt) {
		int row = this.jTable1.getSelectedRow();
		jTextFieldActivityID.setText(jTable1.getValueAt(row, 0).toString());
		jTextFieldActivityName.setText(jTable1.getValueAt(row, 1).toString());
		jTextFieldActivityPlace.setText(jTable1.getValueAt(row, 2).toString());
		jTextFieldActivityTime.setText(jTable1.getValueAt(row, 3).toString());
		String OrgName = jTable1.getValueAt(row, 4).toString();
		for (int i = 0; i < jComboBoxOrgName.getItemCount(); i++) {
			Organization item = (Organization) jComboBoxOrgName.getItemAt(i);
			if (item.getOrgName().equals(OrgName)) {
				this.jComboBoxOrgName.setSelectedIndex(i);
			}
		}
		try {
			// System.out.println(123 + "" +jTable1.getValueAt(row,
			// 5).toString()+"");
			// System.out.println((jTable1.getValueAt(row, 5)+"").length());
			if (StringHelper.isEmpty(jTable1.getValueAt(row, 5) + "")
					|| jTable1.getValueAt(row, 5) == null) {
				jTextAreaActivityPs.setText("");
				// System.out.println("1");
			} else {
				jTextAreaActivityPs.setText(jTable1.getValueAt(row, 5) + "");
				// System.out.println("2");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// 搜索按钮
	private void jButtonSearchActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		String searchActivityName = jTextFieldSearchActivityName.getText() + "";
		String searchActivityPlace = jTextFieldSearchActivityPlace.getText()
				+ "";
		Organization organization = (Organization) this.jComboBoxSearchOrgName
				.getSelectedItem();
		// if (AdminOrgName == "温州商学院") {
		// organization = (Organization) this.jComboBoxSearchOrgName
		// .getSelectedItem();
		// } else {
		// organization = new Organization();
		// organization.setOrgName(AdminOrgName);
		// }

		if ("请选择".equals(organization.getOrgName())) {
			organization.setOrgName("");
		}

		String searchActivityTime = jTextFieldSearchActivityTime.getText() + "";

		// 按时间搜索
		// 先判断时间字符串是否大于0
		// 大于0，用valiDateTimeWithLongFormat方法匹配是否为字符串类型
		// 不大于0，按照其他三个条件进行模糊查找
		if (searchActivityTime.length() > 0) {

			if (!DateHelper.valiDateTimeWithLongFormat(searchActivityTime)) {
				JOptionPane.showMessageDialog(null, "时间格式不正确，请按照YYYY-MM-dd填写");
				return;
			}
			// else {
			// String[] psString = { searchActivityName, searchActivityPlace,
			// searchActivityTime, organization.getOrgName() };
			// fillTable(psString);
			// activity = new Activity(searchActivityName, searchActivityPlace,
			// searchActivityTime, organization.getOrgName());
			// ((ActivityObserver) activityObserver).setActivity(activity);
			// activityController.notifyUpdate();
			// fillOrgName("Search");
			// System.out.println("11111111111111111111111111111111");
			// }
		}
		// else {
		// String[] psString = { searchActivityName, searchActivityPlace,
		// organization.getOrgName() };
		// fillTable(psString);
		// fillOrgName("Search");
		// }

		activity = new Activity(searchActivityName, searchActivityPlace,
				searchActivityTime, organization.getOrgName());
		((ActivityObserver) activityObserver).setActivity(activity);
		activityController.notifyUpdate();
		fillOrgName("Search");
	}

	// 删除按钮事件
	private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {
		String ActivityID = this.jTextFieldActivityID.getText();

		if (StringHelper.isEmpty(ActivityID)) {
			JOptionPane.showMessageDialog(null, "请选择要修改的记录");
			return;
		}

		Object[] options = { "删除此活动", "取消删除" };

		if (JOptionPane.showOptionDialog(null, "请确定删除此活动和关于此活动的所有数据吗", "",
				JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null,
				options, options[0]) == 0) {
			Activity activity = new Activity(Integer.parseInt(ActivityID));
			try {
				int n = activityDao.DeleteActivity(activity);
				if (n == 1) {
					JOptionPane.showMessageDialog(null, "活动删除成功");
				} else {
					JOptionPane.showMessageDialog(null, "活动删除失败");
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				String[] psString = {};
				fillTable(psString);
			}
		} else {
			return;
		}

	}

	// 修改按钮事件
	private void jButtonModifyActionPerformed(java.awt.event.ActionEvent evt) {
		String ActivityID = this.jTextFieldActivityID.getText();
		String ActivityName = this.jTextFieldActivityName.getText();
		String ActivityPlace = this.jTextFieldActivityPlace.getText();
		String ActivityTime = this.jTextFieldActivityTime.getText();
		if (StringHelper.isEmpty(ActivityID)) {
			JOptionPane.showMessageDialog(null, "请选择要修改的记录");
			return;
		}
		if (StringHelper.isEmpty(ActivityName)) {
			JOptionPane.showMessageDialog(null, "活动名称不能为空");
			return;
		}
		if (StringHelper.isEmpty(ActivityPlace)) {
			JOptionPane.showMessageDialog(null, "活动地点不能为空");
			return;
		}

		if (StringHelper.isEmpty(ActivityTime)) {
			JOptionPane.showMessageDialog(null, "活动时间不能为空");
			return;
		} else if (!StringHelper.isEmpty(ActivityTime)) {
			if (!DateHelper.valiDateTimeWithLongFormat(ActivityTime)) {
				JOptionPane.showMessageDialog(null, "时间格式不正确，请按照YYYY-MM-dd填写");
				return;
			}
		}
		Organization organization = (Organization) this.jComboBoxOrgName
				.getSelectedItem();
		String ActivityPs = this.jTextAreaActivityPs.getText();

		Activity activity = new Activity(Integer.parseInt(ActivityID),
				ActivityName, ActivityPlace, ActivityTime, organization
						.getOrgName(), ActivityPs);
		try {
			int n = activityDao.UpdateActivity(activity);
			if (n == 1) {
				JOptionPane.showMessageDialog(null, "活动修改成功");
			} else {
				JOptionPane.showMessageDialog(null, "活动修改失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			String[] psString = {};
			fillTable(psString);
		}
	}

	// 增加按钮事件
	private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {
		String ActivityName = this.jTextFieldActivityName.getText();
		String ActivityPlace = this.jTextFieldActivityPlace.getText();
		String ActivityTime = this.jTextFieldActivityTime.getText();
		if (StringHelper.isEmpty(ActivityName)) {
			JOptionPane.showMessageDialog(null, "活动名称不能为空");
			return;
		}
		if (StringHelper.isEmpty(ActivityPlace)) {
			JOptionPane.showMessageDialog(null, "活动地点不能为空");
			return;
		}
		if (StringHelper.isEmpty(ActivityTime)) {
			JOptionPane.showMessageDialog(null, "活动时间不能为空");
			return;
		} else if (!StringHelper.isEmpty(ActivityTime)) {
			if (!DateHelper.valiDateTimeWithLongFormat(ActivityTime)) {
				JOptionPane.showMessageDialog(null, "时间格式不正确，请按照YYYY-MM-dd填写");
				return;
			}
		}

		Organization organization = (Organization) this.jComboBoxOrgName
				.getSelectedItem();
		String ActivityPs = this.jTextAreaActivityPs.getText();
		// System.out.println(ActivityPs);
		// System.out.println(organization.getOrgName());
		Activity activity = new Activity(ActivityName, ActivityPlace,
				ActivityTime, organization.getOrgName(), ActivityPs);

		try {
			int n = activityDao.AddActivity(activity);
			if (n == 1) {
				JOptionPane.showMessageDialog(null, "活动添加成功");
			} else {
				JOptionPane.showMessageDialog(null, "活动添加失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			String[] psString = {};
			fillTable(psString);
		}
	}

	// GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JButton jButtonAdd;
	private javax.swing.JButton jButtonDelete;
	private javax.swing.JButton jButtonModify;
	private javax.swing.JButton jButtonSearch;
	private javax.swing.JComboBox jComboBoxOrgName;
	private javax.swing.JComboBox jComboBoxSearchOrgName;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel10;
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
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JTable jTable1;
	private javax.swing.JTextArea jTextAreaActivityPs;
	private javax.swing.JTextField jTextFieldActivityID;
	private javax.swing.JTextField jTextFieldActivityName;
	private javax.swing.JTextField jTextFieldActivityPlace;
	private javax.swing.JTextField jTextFieldActivityTime;
	private javax.swing.JTextField jTextFieldSearchActivityName;
	private javax.swing.JTextField jTextFieldSearchActivityPlace;
	private javax.swing.JTextField jTextFieldSearchActivityTime;

	// End of variables declaration//GEN-END:variables

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	// GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jPanel1 = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		jTextFieldSearchActivityName = new javax.swing.JTextField();
		jLabel2 = new javax.swing.JLabel();
		jTextFieldSearchActivityPlace = new javax.swing.JTextField();
		jLabel3 = new javax.swing.JLabel();
		jTextFieldSearchActivityTime = new javax.swing.JTextField();
		jLabel4 = new javax.swing.JLabel();
		jButtonSearch = new javax.swing.JButton();
		jComboBoxSearchOrgName = new javax.swing.JComboBox();
		jScrollPane1 = new javax.swing.JScrollPane();
		jTable1 = new javax.swing.JTable();
		jPanel2 = new javax.swing.JPanel();
		jLabel5 = new javax.swing.JLabel();
		jTextFieldActivityID = new javax.swing.JTextField();
		jLabel6 = new javax.swing.JLabel();
		jTextFieldActivityName = new javax.swing.JTextField();
		jLabel7 = new javax.swing.JLabel();
		jTextFieldActivityPlace = new javax.swing.JTextField();
		jLabel8 = new javax.swing.JLabel();
		jTextFieldActivityTime = new javax.swing.JTextField();
		jLabel9 = new javax.swing.JLabel();
		jComboBoxOrgName = new javax.swing.JComboBox();
		jLabel10 = new javax.swing.JLabel();
		jScrollPane2 = new javax.swing.JScrollPane();
		jTextAreaActivityPs = new javax.swing.JTextArea();
		jButtonAdd = new javax.swing.JButton();
		jButtonModify = new javax.swing.JButton();
		jButtonDelete = new javax.swing.JButton();

		setTitle("\u6d3b\u52a8\u7ba1\u7406");

		jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(
				javax.swing.BorderFactory.createLineBorder(new java.awt.Color(
						0, 0, 0)), "\u641c\u7d22\u6761\u4ef6"));

		jLabel1.setText("\u6d3b\u52a8\u540d\u79f0");

		jTextFieldSearchActivityName.setToolTipText("\u6d3b\u52a8\u540d\u79f0");

		jLabel2.setText("\u6d3b\u52a8\u5730\u70b9");

		jTextFieldSearchActivityPlace
				.setToolTipText("\u6d3b\u52a8\u5730\u70b9");

		jLabel3.setText("\u6d3b\u52a8\u65f6\u95f4");

		jTextFieldSearchActivityTime
				.setToolTipText("\u6d3b\u52a8\u65f6\u95f4 YYYY-MM-dd");

		jLabel4.setText("\u7ec4\u7ec7\u540d\u79f0");

		jButtonSearch.setText("\u641c\u7d22");
		jButtonSearch.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonSearchActionPerformed(evt);
			}
		});

		jComboBoxSearchOrgName.setModel(new javax.swing.DefaultComboBoxModel(
				new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

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
																javax.swing.GroupLayout.Alignment.LEADING,
																false)
														.addGroup(
																jPanel1Layout
																		.createSequentialGroup()
																		.addComponent(
																				jLabel1)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																		.addComponent(
																				jTextFieldSearchActivityName,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				202,
																				javax.swing.GroupLayout.PREFERRED_SIZE))
														.addGroup(
																jPanel1Layout
																		.createSequentialGroup()
																		.addComponent(
																				jLabel3)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																		.addComponent(
																				jTextFieldSearchActivityTime)))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												59, Short.MAX_VALUE)
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING,
																false)
														.addGroup(
																jPanel1Layout
																		.createSequentialGroup()
																		.addComponent(
																				jLabel2)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				jTextFieldSearchActivityPlace,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				257,
																				javax.swing.GroupLayout.PREFERRED_SIZE))
														.addGroup(
																jPanel1Layout
																		.createSequentialGroup()
																		.addComponent(
																				jLabel4)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				jComboBoxSearchOrgName,
																				0,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE)))
										.addGap(31, 31, 31).addComponent(
												jButtonSearch).addGap(29, 29,
												29)));
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
																								jTextFieldSearchActivityName,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.PREFERRED_SIZE))
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addGroup(
																				jPanel1Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.BASELINE)
																						.addComponent(
																								jLabel3)
																						.addComponent(
																								jTextFieldSearchActivityTime,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.PREFERRED_SIZE)))
														.addGroup(
																jPanel1Layout
																		.createSequentialGroup()
																		.addGroup(
																				jPanel1Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.BASELINE)
																						.addComponent(
																								jLabel2)
																						.addComponent(
																								jTextFieldSearchActivityPlace,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.PREFERRED_SIZE))
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addGroup(
																				jPanel1Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addComponent(
																								jComboBoxSearchOrgName,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								jLabel4)))
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

				}, new String[] { "活动编号", "活动名称", "活动地点", "活动时间", "组织名称",
						"活动备注" }) {
			boolean[] canEdit = new boolean[] { false, false, false, false,
					false, false };

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
						0, 0, 0)), "\u4fe1\u606f\u8be6\u60c5"));

		jLabel5.setText("\u6d3b\u52a8\u7f16\u53f7");

		jTextFieldActivityID.setEnabled(false);

		jLabel6.setText("\u6d3b\u52a8\u540d\u79f0");

		jLabel7.setText("\u6d3b\u52a8\u5730\u70b9");

		jLabel8.setText("\u6d3b\u52a8\u65f6\u95f4");

		jLabel9.setText("\u7ec4\u7ec7\u540d\u79f0");

		jComboBoxOrgName.setModel(new javax.swing.DefaultComboBoxModel(
				new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

		jLabel10.setText("\u6d3b\u52a8\u5907\u6ce8");

		jTextAreaActivityPs.setColumns(20);
		jTextAreaActivityPs.setRows(5);
		jScrollPane2.setViewportView(jTextAreaActivityPs);

		jButtonAdd.setText("\u6dfb\u52a0");
		jButtonAdd.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonAddActionPerformed(evt);
			}
		});

		jButtonModify.setText("\u4fee\u6539");
		jButtonModify.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonModifyActionPerformed(evt);
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
																		.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.TRAILING,
																				false)
																		.addGroup(
																				javax.swing.GroupLayout.Alignment.LEADING,
																				jPanel2Layout
																						.createSequentialGroup()
																						.addComponent(
																								jLabel8)
																						.addGap(
																								18,
																								18,
																								18)
																						.addComponent(
																								jTextFieldActivityTime))
																		.addGroup(
																				javax.swing.GroupLayout.Alignment.LEADING,
																				jPanel2Layout
																						.createSequentialGroup()
																						.addComponent(
																								jLabel5)
																						.addGap(
																								18,
																								18,
																								18)
																						.addComponent(
																								jTextFieldActivityID,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								94,
																								javax.swing.GroupLayout.PREFERRED_SIZE)))
														.addGroup(
																jPanel2Layout
																		.createSequentialGroup()
																		.addComponent(
																				jLabel9)
																		.addGap(
																				18,
																				18,
																				18)
																		.addGroup(
																				jPanel2Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addComponent(
																								jButtonAdd,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								95,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								jComboBoxOrgName,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								225,
																								javax.swing.GroupLayout.PREFERRED_SIZE))))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												jPanel2Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																jPanel2Layout
																		.createSequentialGroup()
																		.addGroup(
																				jPanel2Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addGroup(
																								jPanel2Layout
																										.createSequentialGroup()
																										.addComponent(
																												jLabel10)
																										.addPreferredGap(
																												javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																										.addComponent(
																												jScrollPane2,
																												javax.swing.GroupLayout.DEFAULT_SIZE,
																												319,
																												Short.MAX_VALUE))
																						.addGroup(
																								jPanel2Layout
																										.createSequentialGroup()
																										.addPreferredGap(
																												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																										.addComponent(
																												jLabel6)
																										.addPreferredGap(
																												javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																										.addComponent(
																												jTextFieldActivityName,
																												javax.swing.GroupLayout.PREFERRED_SIZE,
																												94,
																												javax.swing.GroupLayout.PREFERRED_SIZE)
																										.addPreferredGap(
																												javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																												65,
																												Short.MAX_VALUE)
																										.addComponent(
																												jLabel7)
																										.addGap(
																												18,
																												18,
																												18)
																										.addComponent(
																												jTextFieldActivityPlace,
																												javax.swing.GroupLayout.PREFERRED_SIZE,
																												94,
																												javax.swing.GroupLayout.PREFERRED_SIZE)))
																		.addGap(
																				71,
																				71,
																				71))
														.addGroup(
																jPanel2Layout
																		.createSequentialGroup()
																		.addComponent(
																				jButtonModify,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				99,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																				130,
																				Short.MAX_VALUE)
																		.addComponent(
																				jButtonDelete,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				98,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addGap(
																				123,
																				123,
																				123)))));
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
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																jPanel2Layout
																		.createSequentialGroup()
																		.addGroup(
																				jPanel2Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.BASELINE)
																						.addComponent(
																								jLabel5)
																						.addComponent(
																								jTextFieldActivityID,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.PREFERRED_SIZE))
																		.addGap(
																				28,
																				28,
																				28)
																		.addGroup(
																				jPanel2Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.BASELINE)
																						.addComponent(
																								jLabel8)
																						.addComponent(
																								jTextFieldActivityTime,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.PREFERRED_SIZE))
																		.addGap(
																				24,
																				24,
																				24)
																		.addGroup(
																				jPanel2Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.BASELINE)
																						.addComponent(
																								jLabel9)
																						.addComponent(
																								jComboBoxOrgName,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.PREFERRED_SIZE)))
														.addGroup(
																jPanel2Layout
																		.createSequentialGroup()
																		.addGroup(
																				jPanel2Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addGroup(
																								jPanel2Layout
																										.createParallelGroup(
																												javax.swing.GroupLayout.Alignment.BASELINE)
																										.addComponent(
																												jTextFieldActivityName,
																												javax.swing.GroupLayout.PREFERRED_SIZE,
																												javax.swing.GroupLayout.DEFAULT_SIZE,
																												javax.swing.GroupLayout.PREFERRED_SIZE)
																										.addComponent(
																												jLabel6))
																						.addGroup(
																								jPanel2Layout
																										.createParallelGroup(
																												javax.swing.GroupLayout.Alignment.BASELINE)
																										.addComponent(
																												jTextFieldActivityPlace,
																												javax.swing.GroupLayout.PREFERRED_SIZE,
																												javax.swing.GroupLayout.DEFAULT_SIZE,
																												javax.swing.GroupLayout.PREFERRED_SIZE)
																										.addComponent(
																												jLabel7)))
																		.addGap(
																				28,
																				28,
																				28)
																		.addGroup(
																				jPanel2Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addComponent(
																								jLabel10)
																						.addComponent(
																								jScrollPane2,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								80,
																								javax.swing.GroupLayout.PREFERRED_SIZE))))
										.addGap(31, 31, 31)
										.addGroup(
												jPanel2Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																jButtonAdd)
														.addComponent(
																jButtonModify)
														.addComponent(
																jButtonDelete))
										.addContainerGap()));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout
				.setHorizontalGroup(layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								layout
										.createSequentialGroup()
										.addGap(24, 24, 24)
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																jPanel2,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addGroup(
																layout
																		.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.TRAILING,
																				false)
																		.addComponent(
																				jScrollPane1,
																				javax.swing.GroupLayout.Alignment.LEADING)
																		.addComponent(
																				jPanel1,
																				javax.swing.GroupLayout.Alignment.LEADING,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE)))
										.addContainerGap(
												javax.swing.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)));
		layout
				.setVerticalGroup(layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								layout
										.createSequentialGroup()
										.addContainerGap()
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
												143,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(
												jPanel2,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addContainerGap(26, Short.MAX_VALUE)));

		pack();
	}// </editor-fold>
	// GEN-END:initComponents
}