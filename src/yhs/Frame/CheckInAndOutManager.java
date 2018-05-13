package yhs.Frame;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.yhs.JTable.JTableStudent;

import com.yhs.dao.*;
import com.yhs.helper.DateHelper;
import com.yhs.helper.StringHelper;
import com.yhs.model.*;

/*
 * CheckInAndOutManager.java
 *
 * Created on __DATE__, __TIME__
 */

/**
 * 
 * @author __USER__
 */
public class CheckInAndOutManager extends javax.swing.JInternalFrame {
	JTableStudent jTableStudent;
	JTable myTable;
	ActivityDao activityDao;
	StudentDao studentDao;
	AttendanceDao attendanceDao;

	/** Creates new form CheckInAndOutManager */
	public CheckInAndOutManager() {
		initComponents();
		String[] psString = {};
		fillTableActivity(new Activity(), psString);
		fillTableStudent(new Student(), psString);
		jRadioButtonAttLateYes.setSelected(false);
		jRadioButtonAttLateNo.setSelected(true);
		jTextAreaPersonName.setEnabled(false);
	}

	// public String isCheck(){
	// String a = myTable.getValueAt(1, 3).toString();
	// return a;
	// }

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		buttonGroup1 = new javax.swing.ButtonGroup();
		jPanel1 = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		jTextFieldSearchActivityID = new javax.swing.JTextField();
		jLabel2 = new javax.swing.JLabel();
		jTextFieldSearchActivityName = new javax.swing.JTextField();
		jButtonSearchActivity = new javax.swing.JButton();
		jScrollPane1 = new javax.swing.JScrollPane();
		jTable1 = new javax.swing.JTable();
		jPanel2 = new javax.swing.JPanel();
		jLabel3 = new javax.swing.JLabel();
		jScrollPane2 = new javax.swing.JScrollPane();
		jTextAreaPersonName = new javax.swing.JTextArea();
		jLabel8 = new javax.swing.JLabel();
		jTextFieldActivityID = new javax.swing.JTextField();
		jLabel9 = new javax.swing.JLabel();
		jTextFieldAttTime = new javax.swing.JTextField();
		jLabel10 = new javax.swing.JLabel();
		jRadioButtonAttLateYes = new javax.swing.JRadioButton();
		jRadioButtonAttLateNo = new javax.swing.JRadioButton();
		jLabel12 = new javax.swing.JLabel();
		jScrollPane3 = new javax.swing.JScrollPane();
		jTextAreaAttPs = new javax.swing.JTextArea();
		jButtonCheckIn = new javax.swing.JButton();
		jButtonClearStudentNumber = new javax.swing.JButton();
		jPanel3 = new javax.swing.JPanel();
		jLabel4 = new javax.swing.JLabel();
		jTextFieldPersonNumberSearch = new javax.swing.JTextField();
		jLabel5 = new javax.swing.JLabel();
		jTextFieldPersonNameSearch = new javax.swing.JTextField();
		jLabel6 = new javax.swing.JLabel();
		jTextFieldOrgNameSearch = new javax.swing.JTextField();
		jButtonStudentSearch = new javax.swing.JButton();
		jScrollPane4 = new javax.swing.JScrollPane();
		jTable2 = new javax.swing.JTable();

		jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(
				javax.swing.BorderFactory.createLineBorder(new java.awt.Color(
						0, 0, 0)), "\u641c\u7d22\u6d3b\u52a8"));

		jLabel1.setText("\u6d3b\u52a8\u7f16\u53f7");

		jLabel2.setText("\u6d3b\u52a8\u540d\u79f0");

		jButtonSearchActivity.setText("\u641c\u7d22");
		jButtonSearchActivity
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						jButtonSearchActivityActionPerformed(evt);
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
										.addComponent(jLabel1)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(
												jTextFieldSearchActivityID,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												90,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(jLabel2)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(
												jTextFieldSearchActivityName,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												90,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(11, 11, 11).addComponent(
												jButtonSearchActivity)
										.addContainerGap(18, Short.MAX_VALUE)));
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
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel1)
														.addComponent(
																jTextFieldSearchActivityID,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																jButtonSearchActivity)
														.addComponent(jLabel2)
														.addComponent(
																jTextFieldSearchActivityName,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addContainerGap(
												javax.swing.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)));

		jTable1.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] {

				}, new String[] { "����", "�����" }) {
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

		jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(
				javax.swing.BorderFactory.createLineBorder(new java.awt.Color(
						0, 0, 0)), "\u7b7e\u5230\u4fe1\u606f"));

		jLabel3.setText("\u5b66\u751f\u59d3\u540d");

		jTextAreaPersonName.setColumns(20);
		jTextAreaPersonName.setRows(5);
		jTextAreaPersonName
				.setToolTipText("\u8bf7\u70b9\u51fb\u53f3\u4fa7\u540d\u5355\u9009\u62e9");
		jScrollPane2.setViewportView(jTextAreaPersonName);

		jLabel8.setText("\u6d3b\u52a8\u7f16\u53f7");

		jTextFieldActivityID
				.setToolTipText("\u8bf7\u70b9\u51fb\u4e0a\u65b9\u8868\u683c\u9009\u62e9");

		jLabel9.setText("\u51fa\u52e4\u65f6\u95f4");

		jLabel10.setText("\u662f\u5426\u8fdf\u5230");

		buttonGroup1.add(jRadioButtonAttLateYes);
		jRadioButtonAttLateYes.setText("\u662f");

		buttonGroup1.add(jRadioButtonAttLateNo);
		jRadioButtonAttLateNo.setText("\u5426");

		jLabel12.setText("\u5907\u6ce8\u4fe1\u606f");

		jTextAreaAttPs.setColumns(20);
		jTextAreaAttPs.setRows(5);
		jScrollPane3.setViewportView(jTextAreaAttPs);

		jButtonCheckIn.setText("\u7b7e\u5230");
		jButtonCheckIn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonCheckInActionPerformed(evt);
			}
		});

		jButtonClearStudentNumber.setText("\u6e05\u9664\u5b66\u53f7");
		jButtonClearStudentNumber
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						jButtonClearStudentNumberActionPerformed(evt);
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
																				jLabel3)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				jScrollPane2,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				326,
																				Short.MAX_VALUE)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED))
														.addGroup(
																jPanel2Layout
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
																jPanel2Layout
																		.createSequentialGroup()
																		.addComponent(
																				jLabel12)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				jScrollPane3,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				326,
																				Short.MAX_VALUE)))
										.addGap(12, 12, 12)).addGroup(
								jPanel2Layout.createSequentialGroup().addGap(
										87, 87, 87).addComponent(
										jButtonCheckIn,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										97,
										javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(54, 54, 54).addComponent(
												jButtonClearStudentNumber)
										.addContainerGap(84, Short.MAX_VALUE)));
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
														.addComponent(jLabel3)
														.addComponent(
																jScrollPane2,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												jPanel2Layout
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
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												jPanel2Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(jLabel12)
														.addComponent(
																jScrollPane3,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																93,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(18, 18, 18)
										.addGroup(
												jPanel2Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																jButtonCheckIn)
														.addComponent(
																jButtonClearStudentNumber))
										.addContainerGap(39, Short.MAX_VALUE)));

		jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(
				javax.swing.BorderFactory.createLineBorder(new java.awt.Color(
						0, 0, 0)), "\u641c\u7d22\u5b66\u751f"));

		jLabel4.setText("\u5b66\u751f\u5b66\u53f7");

		jLabel5.setText("\u5b66\u751f\u59d3\u540d");

		jLabel6.setText("\u6240\u5c5e\u7ec4\u7ec7");

		jButtonStudentSearch.setText("\u641c\u7d22");
		jButtonStudentSearch
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						jButtonStudentSearchActionPerformed(evt);
					}
				});

		jTable2.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] {

				}, new String[] { "ѧ��ѧ��", "ѧ������", "������֯" }) {
			boolean[] canEdit = new boolean[] { false, false, false };

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
		jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				jTable2MousePressed(evt);
			}
		});
		jScrollPane4.setViewportView(jTable2);

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
														.addComponent(
																jScrollPane4,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																295,
																Short.MAX_VALUE)
														.addGroup(
																jPanel3Layout
																		.createSequentialGroup()
																		.addGroup(
																				jPanel3Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addGroup(
																								jPanel3Layout
																										.createSequentialGroup()
																										.addComponent(
																												jLabel4)
																										.addPreferredGap(
																												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
																												jLabel5))
																						.addGroup(
																								jPanel3Layout
																										.createSequentialGroup()
																										.addComponent(
																												jLabel6)
																										.addPreferredGap(
																												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																										.addComponent(
																												jTextFieldOrgNameSearch,
																												javax.swing.GroupLayout.PREFERRED_SIZE,
																												70,
																												javax.swing.GroupLayout.PREFERRED_SIZE)))
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addGroup(
																				jPanel3Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING,
																								false)
																						.addComponent(
																								jButtonStudentSearch,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								Short.MAX_VALUE)
																						.addComponent(
																								jTextFieldPersonNameSearch,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								70,
																								Short.MAX_VALUE))))
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
														.addComponent(jLabel4)
														.addComponent(
																jTextFieldPersonNumberSearch,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(jLabel5)
														.addComponent(
																jTextFieldPersonNameSearch,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												jPanel3Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel6)
														.addComponent(
																jTextFieldOrgNameSearch,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																jButtonStudentSearch))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(
												jScrollPane4,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addContainerGap(33, Short.MAX_VALUE)));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				layout.createSequentialGroup().addContainerGap().addGroup(
						layout.createParallelGroup(
								javax.swing.GroupLayout.Alignment.TRAILING,
								false).addComponent(jPanel2,
								javax.swing.GroupLayout.Alignment.LEADING, 0,
								javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE).addComponent(jPanel1,
								javax.swing.GroupLayout.Alignment.LEADING,
								javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE).addComponent(jScrollPane1, 0,
								0, Short.MAX_VALUE)).addGap(18, 18, 18)
						.addComponent(jPanel3,
								javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE).addContainerGap()));
		layout
				.setVerticalGroup(layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								layout
										.createSequentialGroup()
										.addGroup(
												layout
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
																				125,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				jPanel2,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE))
														.addComponent(
																jPanel3,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE))
										.addContainerGap()));

		pack();
	}// </editor-fold>
	//GEN-END:initComponents

	private void jButtonClearStudentNumberActionPerformed(
			java.awt.event.ActionEvent evt) {
		jTextAreaPersonName.setText("");
	}

	private void jButtonStudentSearchActionPerformed(
			java.awt.event.ActionEvent evt) {
		String PersonNumber = jTextFieldPersonNumberSearch.getText() + "";
		String PersonName = jTextFieldPersonNameSearch.getText() + "";
		String OrgName = jTextFieldOrgNameSearch.getText() + "";
		String[] psString = { PersonNumber, PersonName, OrgName };
		fillTableStudent(new Student(), psString);
	}

	private void jButtonSearchActivityActionPerformed(
			java.awt.event.ActionEvent evt) {
		String ActivityID = jTextFieldSearchActivityID.getText() + "";
		String ActivityName = jTextFieldSearchActivityName.getText() + "";
		String[] psString = { ActivityID, ActivityName };
		fillTableActivity(new Activity(), psString);

	}

	private void jButtonCheckInActionPerformed(java.awt.event.ActionEvent evt) {
		String PersonNumbers = jTextAreaPersonName.getText() + "";
		String ActivityID = this.jTextFieldActivityID.getText() + "";
		String AttTime = this.jTextFieldAttTime.getText() + "";
		if (StringHelper.isEmpty(PersonNumbers) || PersonNumbers.length() == 0) {
			JOptionPane.showMessageDialog(null, "������ѧ��ѧ��");
			return;
		}

		if (StringHelper.isEmpty(ActivityID)) {
			JOptionPane.showMessageDialog(null, "���Ų���Ϊ��");
			return;
		}
		if (StringHelper.isEmpty(AttTime)) {
			JOptionPane.showMessageDialog(null, "����ʱ�䲻��Ϊ��");
			return;
		}
		boolean AttLate;
		if (jRadioButtonAttLateYes.isSelected() == true) {
			AttLate = true;
		} else {
			AttLate = false;
		}

		String AttPs = this.jTextAreaAttPs.getText() + "";

		// ����ȥ��
		String[] array = PersonNumbers.split(" ");

		Set<String> set = new HashSet<String>();
		for (int i = 1; i < array.length; i++) {
			set.add(array[i]);
		}
		String[] ListPersonNumbers = (String[]) set.toArray(new String[set
				.size()]);

		// ���Ӳ���
		int successCount = 0;
		attendanceDao = new AttendanceDao();
		Attendance attendance;
		List<String> failedStudents = new ArrayList<String>();
		String s = "";
		for (int i = 0; i < ListPersonNumbers.length; i++) {
			attendance = new Attendance();
			attendance.setPersonNumber(ListPersonNumbers[i]);
			attendance.setActivityID(ActivityID);
			attendance.setAttTime(AttTime);
			attendance.setAttLate(AttLate);
			attendance.setAttPs(AttPs);

			try {
				int n = attendanceDao.AddAttendance(attendance);
				if (n == 1) {
					successCount++;
				} else {
					failedStudents.add(ListPersonNumbers[i]);
					JOptionPane.showMessageDialog(null, "��������ʧ��");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		JOptionPane.showMessageDialog(null, successCount + "�˿������ӳɹ�");
		// ��ʾ����ʧ����Ա
		if (failedStudents.size() > 0) {
			for (int i = 0; i < failedStudents.size(); i++) {
				studentDao = new StudentDao();
				String a = studentDao.StudentName(failedStudents.get(i));
				if (!StringHelper.isEmpty(a)) {
					s = s + a + " ";
				}
			}

		}
		if (s.length() > 0) {
			JOptionPane.showMessageDialog(null, s + "��������ʧ��");
		}
		
		jTextAreaPersonName.setText("");
	}

	private void jTable1MousePressed(java.awt.event.MouseEvent evt) {
		int row = this.jTable1.getSelectedRow();
		jTextFieldActivityID.setText(jTable1.getValueAt(row, 0).toString());
	}

	private void jTable2MousePressed(java.awt.event.MouseEvent evt) {
		int row = this.jTable2.getSelectedRow();
		if (StringHelper.isEmpty(jTextAreaPersonName.getText())) {
			jTextAreaPersonName.setText("");
		}
		jTextAreaPersonName.setText(jTextAreaPersonName.getText() + " "
				+ jTable2.getValueAt(row, 0).toString());
	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.ButtonGroup buttonGroup1;
	private javax.swing.JButton jButtonCheckIn;
	private javax.swing.JButton jButtonClearStudentNumber;
	private javax.swing.JButton jButtonSearchActivity;
	private javax.swing.JButton jButtonStudentSearch;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel10;
	private javax.swing.JLabel jLabel12;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
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
	private javax.swing.JScrollPane jScrollPane3;
	private javax.swing.JScrollPane jScrollPane4;
	private javax.swing.JTable jTable1;
	private javax.swing.JTable jTable2;
	private javax.swing.JTextArea jTextAreaAttPs;
	private javax.swing.JTextArea jTextAreaPersonName;
	private javax.swing.JTextField jTextFieldActivityID;
	private javax.swing.JTextField jTextFieldAttTime;
	private javax.swing.JTextField jTextFieldOrgNameSearch;
	private javax.swing.JTextField jTextFieldPersonNameSearch;
	private javax.swing.JTextField jTextFieldPersonNumberSearch;
	private javax.swing.JTextField jTextFieldSearchActivityID;
	private javax.swing.JTextField jTextFieldSearchActivityName;

	// End of variables declaration//GEN-END:variables

	private void fillTableActivity(Activity activity, String[] psString) {
		DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
		dtm.setRowCount(0);

		activityDao = new ActivityDao();
		List<Activity> listActivity = activityDao.list(psString);
		Activity activityTemp = null;
		if (listActivity.size() != 0) {
			for (int i = 0; i < listActivity.size(); i++) {
				activityTemp = listActivity.get(i);
				Vector v = new Vector();
				v.add(activityTemp.getActivityID());
				v.add(activityTemp.getActivityName());
				dtm.addRow(v);
			}
		}
	}

	private void fillTableStudent(Student student, String[] psString) {
		DefaultTableModel dtm = (DefaultTableModel) jTable2.getModel();
		dtm.setRowCount(0);
		studentDao = new StudentDao();
		List<Student> listStudents = studentDao.list(student, psString);

		Student studentTemp;
		if (listStudents.size() != 0) {
			for (int i = 0; i < listStudents.size(); i++) {
				studentTemp = listStudents.get(i);
				Vector v = new Vector();
				v.add(studentTemp.getPersonNumber());
				v.add(studentTemp.getPersonName());
				v.add(studentTemp.getOrgName());
				dtm.addRow(v);
			}
		}
	}
}