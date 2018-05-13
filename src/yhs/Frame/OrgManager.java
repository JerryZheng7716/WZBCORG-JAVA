/*
 * ORGManager.java

 *
 * Created on __DATE__, __TIME__
 */
package yhs.Frame;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import other.wzbcOrg.AdminLogin;

import java.util.List;
import java.util.Vector;

import com.yhs.dao.*;
import com.yhs.helper.*;
import com.yhs.model.*;

/**
 * 
 * @author __USER__
 */
public class OrgManager extends javax.swing.JInternalFrame {

	OrganizationDao organizationDao = new OrganizationDao();
	private String OldName;
	private String AdminOrgName = AdminLogin.getOrgName();

	/** Creates new form ORGManager */
	public OrgManager() {
		initComponents();
		this.fillTable(new Organization());
		this.Org_id_Label.setVisible(false);
		if (AdminLogin.getOrgName() != "温州商学院") {
			AddButton.setEnabled(false);
			DeleteButton.setEnabled(false);
		}
	}
	
	private void clearText(){
		jTextField2.setText("");
	}

	// 点击表格
	private void jTable1MousePressed(java.awt.event.MouseEvent evt) {
		// System.out.println("press");
		int row = this.jTable1.getSelectedRow();
		// System.out.println(row);
		// Org_id_Label.setText(jTable1.getValueAt(row, 0).toString());
		jTextField2.setText(jTable1.getValueAt(row, 1).toString());
		OldName = jTable1.getValueAt(row, 1).toString();
	}

	// 增加按钮
	private void AddButtonActionPerformed(java.awt.event.ActionEvent evt) {
		String orgName = this.jTextField2.getText();
		if (StringHelper.isEmpty(orgName)) {
			JOptionPane.showMessageDialog(null, "组织名称不能为空");
			return;
		}
		Organization organization = new Organization(orgName);
		OrganizationDao organizationDao = new OrganizationDao();
		try {
			int i = organizationDao.AddOrg(organization);
			if (i == 1) {
				JOptionPane.showMessageDialog(null, "增加成功");
				clearText();
				fillTable(new Organization());
			} else {
				JOptionPane.showMessageDialog(null, "增加失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 修改按钮
	private void ModifyButtonActionPerformed(java.awt.event.ActionEvent evt) {
		String val = Org_id_Label.getText();
		System.out.println(val);
		if (StringHelper.isEmpty(OldName)) {
			JOptionPane.showMessageDialog(null, "请选择要修改的记录");
			return;
		}
		String orgName = jTextField2.getText();
		Organization organization = new Organization();
		organization.setOrgName(orgName);

		OrganizationDao organizationDao = new OrganizationDao();
		try {
			int i = organizationDao.UpdateOrg(organization, OldName);
			if (i == 1) {
				JOptionPane.showMessageDialog(null, "修改成功");
				clearText();
				fillTable(new Organization());
			} else {
				JOptionPane.showMessageDialog(null, "修改失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 删除按钮
	private void DeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {
		String val = Org_id_Label.getText();
		System.out.println(val);
		if (StringHelper.isEmpty(OldName)) {
			JOptionPane.showMessageDialog(null, "请选择要删除的记录");
			return;
		}
		Object[] options = { "删除此组织", "取消删除" };

		if (JOptionPane.showOptionDialog(null, "请确定删除此部门和关于此部门的所有数据吗", "",
				JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null,
				options, options[0]) == 0) {
			String orgName = jTextField2.getText();
			Organization organization = new Organization();
			organization.setOrgName(orgName);

			OrganizationDao organizationDao = new OrganizationDao();
			try {
				int i = organizationDao.DeleteOrg(organization);
				if (i == 1) {
					JOptionPane.showMessageDialog(null, "删除成功");
					clearText();
					fillTable(new Organization());
				} else {
					JOptionPane.showMessageDialog(null, "删除失败");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else{
			return;
		}

	}

	// 搜索按钮
	private void SearchButtonActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		String orgName = this.jTextField1.getText();
		// if(StringHelper.isEmpty(orgName)){
		// return;
		// }
		Organization organization = new Organization();
		organization.setOrgName(orgName);
		fillTable(organization);
	}

	private void fillOrganization(String s) {
		List<Organization> listOrganization = organizationDao
				.list(new Organization());
		Organization organization = null;

	}

	
	// 填充表格
	private void fillTable(Organization organization1) {
		DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
		dtm.setRowCount(0);
		List<Organization> listOrg = organizationDao.list(organization1);
		Organization org = null;
		if (listOrg.size() != 0) {
			for (int i = 0; i < listOrg.size(); i++) {
				org = listOrg.get(i);
				Vector v = new Vector();
				v.add(i);
				v.add(org.getOrgName());
				dtm.addRow(v);
			}
		}
	}

	// GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JButton AddButton;
	private javax.swing.JButton DeleteButton;
	private javax.swing.JButton ModifyButton;
	private javax.swing.JLabel Org_id_Label;
	private javax.swing.JButton SearchButton;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTable jTable1;
	private javax.swing.JTextField jTextField1;
	private javax.swing.JTextField jTextField2;

	// End of variables declaration//GEN-END:variables

	// GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jTextField1 = new javax.swing.JTextField();
		SearchButton = new javax.swing.JButton();
		jScrollPane1 = new javax.swing.JScrollPane();
		jTable1 = new javax.swing.JTable();
		jPanel1 = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		jTextField2 = new javax.swing.JTextField();
		AddButton = new javax.swing.JButton();
		ModifyButton = new javax.swing.JButton();
		DeleteButton = new javax.swing.JButton();
		Org_id_Label = new javax.swing.JLabel();

		setTitle("\u7ec4\u7ec7\u7ba1\u7406");

		SearchButton.setText("\u641c\u7d22");
		SearchButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				SearchButtonActionPerformed(evt);
			}
		});

		jTable1.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] {

				}, new String[] { "序号", "组织名称" }) {
			boolean[] canEdit = new boolean[] { false, false };

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

		jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(
				javax.swing.BorderFactory.createLineBorder(new java.awt.Color(
						0, 0, 0)), "\u4fe1\u606f\u8be6\u60c5"));
		jPanel1.setToolTipText("");

		jLabel1.setText("\u7ec4\u7ec7\u540d\u79f0");

		AddButton.setText("\u6dfb\u52a0");
		AddButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				AddButtonActionPerformed(evt);
			}
		});

		ModifyButton.setText("\u4fee\u6539");
		ModifyButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				ModifyButtonActionPerformed(evt);
			}
		});

		DeleteButton.setText("\u5220\u9664");
		DeleteButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				DeleteButtonActionPerformed(evt);
			}
		});

		Org_id_Label.setEnabled(false);

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
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																jPanel1Layout
																		.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.TRAILING)
																		.addGroup(
																				jPanel1Layout
																						.createSequentialGroup()
																						.addContainerGap()
																						.addComponent(
																								Org_id_Label,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								37,
																								Short.MAX_VALUE)
																						.addGap(
																								84,
																								84,
																								84))
																		.addGroup(
																				jPanel1Layout
																						.createSequentialGroup()
																						.addGap(
																								35,
																								35,
																								35)
																						.addComponent(
																								AddButton,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								71,
																								Short.MAX_VALUE)
																						.addGap(
																								27,
																								27,
																								27)))
														.addGroup(
																javax.swing.GroupLayout.Alignment.TRAILING,
																jPanel1Layout
																		.createSequentialGroup()
																		.addContainerGap()
																		.addComponent(
																				jLabel1)
																		.addGap(
																				37,
																				37,
																				37)))
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																javax.swing.GroupLayout.Alignment.TRAILING,
																jPanel1Layout
																		.createSequentialGroup()
																		.addGap(
																				9,
																				9,
																				9)
																		.addComponent(
																				ModifyButton,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE)
																		.addGap(
																				27,
																				27,
																				27)
																		.addComponent(
																				DeleteButton,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE))
														.addComponent(
																jTextField2,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																150,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(22, 22, 22)));
		jPanel1Layout
				.setVerticalGroup(jPanel1Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel1Layout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																jTextField2,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																Org_id_Label)
														.addComponent(jLabel1))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												41, Short.MAX_VALUE)
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(AddButton)
														.addComponent(
																DeleteButton)
														.addComponent(
																ModifyButton))
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
										.addGap(59, 59, 59)
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.TRAILING,
																false)
														.addComponent(
																jPanel1,
																javax.swing.GroupLayout.Alignment.LEADING,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addGroup(
																javax.swing.GroupLayout.Alignment.LEADING,
																layout
																		.createSequentialGroup()
																		.addComponent(
																				jTextField1,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				151,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE)
																		.addComponent(
																				SearchButton))
														.addComponent(
																jScrollPane1,
																javax.swing.GroupLayout.Alignment.LEADING,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																291,
																Short.MAX_VALUE))
										.addGap(63, 63, 63)));
		layout
				.setVerticalGroup(layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								layout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																jTextField1,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																SearchButton))
										.addGap(18, 18, 18)
										.addComponent(
												jScrollPane1,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												133,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(
												jPanel1,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addContainerGap(18, Short.MAX_VALUE)));

		pack();
	}// </editor-fold>
	// GEN-END:initComponents

}