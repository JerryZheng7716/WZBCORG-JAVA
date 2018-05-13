package yhs.Frame;

import java.util.List;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.yhs.dao.ActivityDao;
import com.yhs.dao.AttendanceDao;
import com.yhs.helper.StringHelper;
import com.yhs.model.Activity;
import com.yhs.model.Attendance;

/*
 * AttManager.java
 *
 * Created on __DATE__, __TIME__
 */

/**
 * 
 * @author __USER__
 */
public class AttManager extends javax.swing.JInternalFrame {
	private AttendanceDao attendanceDao = new AttendanceDao();

	/** Creates new form AttManager */
	public AttManager() {
		initComponents();
		String[] psString = {};
		fillTable(new Attendance(), psString);
		jRadioButtonAttLateYes.setSelected(true);
		jRadioButtonAttLateNo.setSelected(false);
	}

	// 填充表格
	private void fillTable(Attendance attendance1, String[] psString) {
		DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
		dtm.setRowCount(0);

		List<Attendance> listAttendance = attendanceDao.list(psString);
		Attendance attendance = null;
		if (listAttendance.size() != 0) {
			for (int i = 0; i < listAttendance.size(); i++) {
				attendance = listAttendance.get(i);
				Vector v = new Vector();
				v.add(attendance.getAttID());
				v.add(attendance.getPersonNumber());
				v.add(attendance.getActivityID());
				v.add(attendance.getAttTime());
				if (attendance.getAttLate() == true) {
					v.add("迟到");
				} else {
					v.add("未迟到");
				}

				v.add(attendance.getAttPs());
				dtm.addRow(v);
			}
		}
	}
	
	
	// 点击表格填充数据
	private void jTable1MousePressed(java.awt.event.MouseEvent evt) {
		// TODO add your handling code here:
		int row = this.jTable1.getSelectedRow();
		jTextFieldAttID.setText(jTable1.getValueAt(row, 0).toString());
		jTextFieldPersonNumber.setText(jTable1.getValueAt(row, 1).toString());
		jTextFieldActivityID.setText(jTable1.getValueAt(row, 2).toString());
		jTextFieldAttTime.setText(jTable1.getValueAt(row, 3).toString());
		if (jTable1.getValueAt(row, 4).toString().equals("迟到")) {
			jRadioButtonAttLateYes.setSelected(true);
			jRadioButtonAttLateNo.setSelected(false);
		} else if (jTable1.getValueAt(row, 4).toString().equals("未迟到")) {
			jRadioButtonAttLateYes.setSelected(false);
			jRadioButtonAttLateNo.setSelected(true);
		}
		try {
			if (StringHelper.isEmpty(jTable1.getValueAt(row, 5) + "")
					|| jTable1.getValueAt(row, 5) == null) {
				jTextAreaAttPs.setText("");
				System.out.println("1");
			} else {
				jTextAreaAttPs.setText(jTable1.getValueAt(row, 5) + "");
				System.out.println("2");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		String name = attendanceDao.selectPersonName(jTable1.getValueAt(row, 1)
				.toString());
		jTextFieldPersonName.setText(name);
	}

	// 删除按钮
	private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {
		String AttID = this.jTextFieldAttID.getText();

		if (StringHelper.isEmpty(AttID)) {
			JOptionPane.showMessageDialog(null, "请选择要修改的记录");
			return;
		}

		Attendance attendance = new Attendance();
		attendance.setAttID(Integer.parseInt(AttID));
		try {
			int n = attendanceDao.DeleteAttendance(attendance);
			if (n == 1) {
				JOptionPane.showMessageDialog(null, "考勤删除成功");
			} else {
				JOptionPane.showMessageDialog(null, "考勤删除失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			String[] psString = {};
			fillTable(new Attendance(), psString);
		}
	}

	private void jButtonModifyActionPerformed(java.awt.event.ActionEvent evt) {
		String AttID = this.jTextFieldAttID.getText();

		if (StringHelper.isEmpty(AttID)) {
			JOptionPane.showMessageDialog(null, "请选择要修改的记录");
			return;
		}
		String PersonNumber = this.jTextFieldPersonNumber.getText();
		String ActivityID = this.jTextFieldActivityID.getText();
		String AttTime = this.jTextFieldAttTime.getText();

		if (StringHelper.isEmpty(PersonNumber)) {
			JOptionPane.showMessageDialog(null, "人员编号不能为空");
			return;
		}
		if (StringHelper.isEmpty(ActivityID)) {
			JOptionPane.showMessageDialog(null, "活动编号不能为空");
			return;
		}
		if (StringHelper.isEmpty(AttTime)) {
			JOptionPane.showMessageDialog(null, "出勤时间不能为空");
			return;
		}
		boolean AttLate;
		if (jRadioButtonAttLateYes.isSelected() == true) {
			AttLate = true;
		} else {
			AttLate = false;
		}
		String AttPs = this.jTextAreaAttPs.getText();

		Attendance attendance = new Attendance();
		attendance.setAttID(Integer.parseInt(AttID));
		attendance.setPersonNumber(PersonNumber);
		attendance.setActivityID(ActivityID);
		attendance.setAttTime(AttTime);
		attendance.setAttLate(AttLate);
		attendance.setAttPs(AttPs);

		try {
			int n = attendanceDao.UpdateAttendance(attendance);
			if (n == 1) {
				JOptionPane.showMessageDialog(null, "考勤修改成功");
			} else {
				JOptionPane.showMessageDialog(null, "考勤修改失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			String[] psString = {};
			fillTable(new Attendance(), psString);
		}
	}

	private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {
		String PersonNumber = this.jTextFieldPersonNumber.getText();
		String ActivityID = this.jTextFieldActivityID.getText();
		String AttTime = this.jTextFieldAttTime.getText();
		if (StringHelper.isEmpty(PersonNumber)) {
			JOptionPane.showMessageDialog(null, "人员编号不能为空");
			return;
		}
		if (StringHelper.isEmpty(ActivityID)) {
			JOptionPane.showMessageDialog(null, "活动编号不能为空");
			return;
		}
		if (StringHelper.isEmpty(AttTime)) {
			JOptionPane.showMessageDialog(null, "出勤时间不能为空");
			return;
		}
		boolean AttLate;
		if (jRadioButtonAttLateYes.isSelected() == true) {
			AttLate = true;
		} else {
			AttLate = false;
		}

		String AttPs = this.jTextAreaAttPs.getText();
		// System.out.println(ActivityPs);
		// System.out.println(organization.getOrgName());

		Attendance attendance = new Attendance();
		attendance.setPersonNumber(PersonNumber);
		attendance.setActivityID(ActivityID);
		attendance.setAttTime(AttTime);
		attendance.setAttLate(AttLate);
		attendance.setAttPs(AttPs);

		try {
			int n = attendanceDao.AddAttendance(attendance);
			if (n == 1) {
				JOptionPane.showMessageDialog(null, "考勤添加成功");
			} else {
				JOptionPane.showMessageDialog(null, "考勤添加失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			String[] psString = {};
			fillTable(new Attendance(), psString);
		}
	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.ButtonGroup buttonGroup1;
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButtonAdd;
	private javax.swing.JButton jButtonDelete;
	private javax.swing.JButton jButtonModify;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel10;
	private javax.swing.JLabel jLabel12;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel8;
	private javax.swing.JLabel jLabel9;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JPanel jPanel3;
	private javax.swing.JRadioButton jRadioButtonAttLateNo;
	private javax.swing.JRadioButton jRadioButtonAttLateYes;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JTable jTable1;
	private javax.swing.JTextArea jTextAreaAttPs;
	private javax.swing.JTextField jTextFieldActivityID;
	private javax.swing.JTextField jTextFieldAttID;
	private javax.swing.JTextField jTextFieldAttTime;
	private javax.swing.JTextField jTextFieldPersonName;
	private javax.swing.JTextField jTextFieldPersonNumber;
	private javax.swing.JTextField jTextFieldSearchActivityID;
	private javax.swing.JTextField jTextFieldSearchAttID;
	private javax.swing.JTextField jTextFieldSearchPersonNumber;
	private javax.swing.JLabel 人员姓名;

	// End of variables declaration//GEN-END:variables
	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		buttonGroup1 = new javax.swing.ButtonGroup();
		jPanel1 = new javax.swing.JPanel();
		jPanel2 = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		jTextFieldSearchAttID = new javax.swing.JTextField();
		jLabel2 = new javax.swing.JLabel();
		jTextFieldSearchPersonNumber = new javax.swing.JTextField();
		jLabel3 = new javax.swing.JLabel();
		jTextFieldSearchActivityID = new javax.swing.JTextField();
		jButton1 = new javax.swing.JButton();
		jScrollPane1 = new javax.swing.JScrollPane();
		jTable1 = new javax.swing.JTable();
		jPanel3 = new javax.swing.JPanel();
		jLabel5 = new javax.swing.JLabel();
		jTextFieldAttID = new javax.swing.JTextField();
		jLabel6 = new javax.swing.JLabel();
		jTextFieldPersonNumber = new javax.swing.JTextField();
		人员姓名 = new javax.swing.JLabel();
		jTextFieldPersonName = new javax.swing.JTextField();
		jLabel8 = new javax.swing.JLabel();
		jTextFieldActivityID = new javax.swing.JTextField();
		jLabel9 = new javax.swing.JLabel();
		jTextFieldAttTime = new javax.swing.JTextField();
		jLabel10 = new javax.swing.JLabel();
		jRadioButtonAttLateYes = new javax.swing.JRadioButton();
		jRadioButtonAttLateNo = new javax.swing.JRadioButton();
		jLabel12 = new javax.swing.JLabel();
		jScrollPane2 = new javax.swing.JScrollPane();
		jTextAreaAttPs = new javax.swing.JTextArea();
		jButtonAdd = new javax.swing.JButton();
		jButtonModify = new javax.swing.JButton();
		jButtonDelete = new javax.swing.JButton();

		setTitle("\u8003\u52e4\u7ba1\u7406");

		jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(
				javax.swing.BorderFactory.createLineBorder(new java.awt.Color(
						0, 0, 0)), "\u641c\u7d22\u6761\u4ef6"));

		jLabel1.setText("\u8003\u52e4\u7f16\u53f7");

		jLabel2.setText("\u4eba\u5458\u7f16\u53f7");

		jLabel3.setText("\u6d3b\u52a8\u7f16\u53f7");

		jButton1.setText("\u641c\u7d22");

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
																javax.swing.GroupLayout.Alignment.LEADING,
																false)
														.addGroup(
																jPanel2Layout
																		.createSequentialGroup()
																		.addComponent(
																				jLabel1)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				jTextFieldSearchAttID,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				100,
																				javax.swing.GroupLayout.PREFERRED_SIZE))
														.addGroup(
																jPanel2Layout
																		.createSequentialGroup()
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				jLabel3)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				jTextFieldSearchActivityID)))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(jLabel2)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(
												jTextFieldSearchPersonNumber,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												100,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(jButton1)
										.addContainerGap(18, Short.MAX_VALUE)));
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
																		.addContainerGap()
																		.addComponent(
																				jButton1))
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
																												jLabel1)
																										.addComponent(
																												jTextFieldSearchAttID,
																												javax.swing.GroupLayout.PREFERRED_SIZE,
																												javax.swing.GroupLayout.DEFAULT_SIZE,
																												javax.swing.GroupLayout.PREFERRED_SIZE))
																						.addGroup(
																								jPanel2Layout
																										.createParallelGroup(
																												javax.swing.GroupLayout.Alignment.BASELINE)
																										.addComponent(
																												jLabel2)
																										.addComponent(
																												jTextFieldSearchPersonNumber,
																												javax.swing.GroupLayout.PREFERRED_SIZE,
																												javax.swing.GroupLayout.DEFAULT_SIZE,
																												javax.swing.GroupLayout.PREFERRED_SIZE)))
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addGroup(
																				jPanel2Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.BASELINE)
																						.addComponent(
																								jTextFieldSearchActivityID,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								jLabel3))))
										.addContainerGap(10, Short.MAX_VALUE)));

		jTable1.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] {

				}, new String[] { "考勤编号", "学生学号", "活动编号", "出勤时间", "是否迟到",
						"备注信息" }) {
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

		jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(
				javax.swing.BorderFactory.createLineBorder(new java.awt.Color(
						0, 0, 0)), "\u8be6\u7ec6\u4fe1\u606f"));

		jLabel5.setText("\u8003\u52e4\u7f16\u53f7");

		jTextFieldAttID.setEnabled(false);

		jLabel6.setText("\u4eba\u5458\u7f16\u53f7");

		人员姓名.setText("\u5b66\u751f\u59d3\u540d");

		jTextFieldPersonName.setEnabled(false);

		jLabel8.setText("\u6d3b\u52a8\u7f16\u53f7");

		jLabel9.setText("\u51fa\u52e4\u65f6\u95f4");

		jLabel10.setText("\u662f\u5426\u8fdf\u5230");

		buttonGroup1.add(jRadioButtonAttLateYes);
		jRadioButtonAttLateYes.setText("\u662f");

		buttonGroup1.add(jRadioButtonAttLateNo);
		jRadioButtonAttLateNo.setText("\u5426");

		jLabel12.setText("\u5907\u6ce8\u4fe1\u606f");

		jTextAreaAttPs.setColumns(20);
		jTextAreaAttPs.setRows(5);
		jScrollPane2.setViewportView(jTextAreaAttPs);

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

		javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(
				jPanel3);
		jPanel3.setLayout(jPanel3Layout);
		jPanel3Layout
				.setHorizontalGroup(jPanel3Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel3Layout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												jPanel3Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																jPanel3Layout
																		.createSequentialGroup()
																		.addComponent(
																				jLabel5)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				jTextFieldAttID,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				70,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				jLabel6)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				jTextFieldPersonNumber,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				70,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				人员姓名)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				jTextFieldPersonName,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				70,
																				javax.swing.GroupLayout.PREFERRED_SIZE))
														.addGroup(
																jPanel3Layout
																		.createSequentialGroup()
																		.addComponent(
																				jLabel8)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				jTextFieldActivityID,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				70,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				jLabel9)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				jTextFieldAttTime,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				70,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				jLabel10)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				jRadioButtonAttLateYes)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				jRadioButtonAttLateNo))
														.addGroup(
																jPanel3Layout
																		.createSequentialGroup()
																		.addComponent(
																				jLabel12)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				jScrollPane2,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				328,
																				Short.MAX_VALUE))
														.addGroup(
																jPanel3Layout
																		.createSequentialGroup()
																		.addComponent(
																				jButtonAdd,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				95,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addGap(
																				42,
																				42,
																				42)
																		.addComponent(
																				jButtonModify,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				99,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																				47,
																				Short.MAX_VALUE)
																		.addComponent(
																				jButtonDelete,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				98,
																				javax.swing.GroupLayout.PREFERRED_SIZE)))
										.addContainerGap()));
		jPanel3Layout
				.setVerticalGroup(jPanel3Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel3Layout
										.createSequentialGroup()
										.addGroup(
												jPanel3Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel5)
														.addComponent(
																jTextFieldAttID,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(jLabel6)
														.addComponent(
																jTextFieldPersonNumber,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(人员姓名)
														.addComponent(
																jTextFieldPersonName,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addGroup(
												jPanel3Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel8)
														.addComponent(
																jTextFieldActivityID,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(jLabel9)
														.addComponent(
																jTextFieldAttTime,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(jLabel10)
														.addComponent(
																jRadioButtonAttLateYes)
														.addComponent(
																jRadioButtonAttLateNo))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addGroup(
												jPanel3Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(jLabel12)
														.addComponent(
																jScrollPane2,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																93,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(18, 18, 18)
										.addGroup(
												jPanel3Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																jButtonAdd)
														.addComponent(
																jButtonModify)
														.addComponent(
																jButtonDelete))
										.addContainerGap()));

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(
				jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout
				.setHorizontalGroup(jPanel1Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								javax.swing.GroupLayout.Alignment.TRAILING,
								jPanel1Layout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.TRAILING)
														.addComponent(
																jScrollPane1,
																javax.swing.GroupLayout.Alignment.LEADING,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																415,
																Short.MAX_VALUE)
														.addComponent(
																jPanel2,
																javax.swing.GroupLayout.Alignment.LEADING,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addComponent(
																jPanel3,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE))
										.addGap(15, 15, 15)));
		jPanel1Layout
				.setVerticalGroup(jPanel1Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel1Layout
										.createSequentialGroup()
										.addComponent(
												jPanel2,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												91,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(
												jScrollPane1,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												258, Short.MAX_VALUE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(
												jPanel3,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
				javax.swing.GroupLayout.DEFAULT_SIZE,
				javax.swing.GroupLayout.PREFERRED_SIZE));
		layout.setVerticalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				layout.createSequentialGroup().addComponent(jPanel1,
						javax.swing.GroupLayout.DEFAULT_SIZE,
						javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addContainerGap()));

		pack();
	}// </editor-fold>
	//GEN-END:initComponents

}