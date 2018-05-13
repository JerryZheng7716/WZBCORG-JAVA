package ls.Frame;

import java.sql.ResultSet;
import java.util.List;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import other.wzbcOrg.AdminLogin;

import com.yhs.dao.ActivityDao;
import com.yhs.dao.AttendanceDao;
import com.yhs.dao.StudentDao;
import com.yhs.helper.SqlFunction;
import com.yhs.model.Student;

/*
 * AttendanceActivityManager.java
 *
 * Created on __DATE__, __TIME__
 */

/**
 * 
 * @author __USER__
 */
public class AttendanceActivityManager extends javax.swing.JInternalFrame {

	ActivityDao activityDao;
	StudentDao studentDao;
	AttendanceDao attendanceDao;

	//	private String AdminOrgName = AdminLogin.getOrgName();

	/** Creates new form AttendanceActivityManager */
	public AttendanceActivityManager() {
		initComponents();
		String[] psString = {};
		fillTableStudent(new Student(), psString);
	}

	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

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
		jPanel1 = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		jTextFieldStudentName = new javax.swing.JTextField();
		jLabel2 = new javax.swing.JLabel();
		jScrollPane1 = new javax.swing.JScrollPane();
		jTextAreaStudentLateActivity = new javax.swing.JTextArea();
		jLabel3 = new javax.swing.JLabel();
		jScrollPane2 = new javax.swing.JScrollPane();
		jTextAreaStudentNotLateActivity = new javax.swing.JTextArea();

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

				}, new String[] { "学生学号", "学生姓名", "所属组织" }) {
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
																javax.swing.GroupLayout.Alignment.TRAILING)
														.addComponent(
																jScrollPane4,
																javax.swing.GroupLayout.Alignment.LEADING,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																480,
																Short.MAX_VALUE)
														.addGroup(
																javax.swing.GroupLayout.Alignment.LEADING,
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
																				jLabel5)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				jTextFieldPersonNameSearch,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				70,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addGap(
																				18,
																				18,
																				18)
																		.addComponent(
																				jLabel6)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				jTextFieldOrgNameSearch,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				70,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addGap(
																				18,
																				18,
																				18)
																		.addComponent(
																				jButtonStudentSearch)))
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
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(jLabel6)
														.addComponent(
																jTextFieldOrgNameSearch,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																jButtonStudentSearch))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(
												jScrollPane4,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												259,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addContainerGap(
												javax.swing.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)));

		jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(
				javax.swing.BorderFactory.createLineBorder(new java.awt.Color(
						0, 0, 0)), "\u6d3b\u52a8\u8be6\u7ec6\u4fe1\u606f"));

		jLabel1.setText("\u5b66\u751f\u59d3\u540d");

		jTextFieldStudentName.setEnabled(false);

		jLabel2.setText("\u672a\u8fdf\u5230\u7684\u6d3b\u52a8");

		jTextAreaStudentLateActivity.setColumns(20);
		jTextAreaStudentLateActivity.setRows(5);
		jTextAreaStudentLateActivity.setEnabled(false);
		jScrollPane1.setViewportView(jTextAreaStudentLateActivity);

		jLabel3.setText("\u8fdf\u5230\u7684\u6d3b\u52a8");

		jTextAreaStudentNotLateActivity.setColumns(20);
		jTextAreaStudentNotLateActivity.setRows(5);
		jTextAreaStudentNotLateActivity.setEnabled(false);
		jScrollPane2.setViewportView(jTextAreaStudentNotLateActivity);

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
														.addComponent(jLabel1)
														.addComponent(jLabel2))
										.addGap(18, 18, 18)
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																jTextFieldStudentName,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																200,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addGroup(
																jPanel1Layout
																		.createSequentialGroup()
																		.addComponent(
																				jScrollPane1,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				135,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addGap(
																				18,
																				18,
																				18)
																		.addComponent(
																				jLabel3)
																		.addGap(
																				12,
																				12,
																				12)
																		.addComponent(
																				jScrollPane2,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.PREFERRED_SIZE)))
										.addContainerGap(31, Short.MAX_VALUE)));
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
																jTextFieldStudentName,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(24, 24, 24)
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(jLabel2)
														.addComponent(
																jScrollPane1,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																166,
																Short.MAX_VALUE)
														.addComponent(jLabel3)
														.addComponent(
																jScrollPane2,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																166,
																Short.MAX_VALUE))
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
										.addContainerGap()
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.TRAILING)
														.addComponent(
																jPanel1,
																javax.swing.GroupLayout.Alignment.LEADING,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addComponent(
																jPanel3,
																javax.swing.GroupLayout.Alignment.LEADING,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addContainerGap()));
		layout
				.setVerticalGroup(layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								layout
										.createSequentialGroup()
										.addComponent(
												jPanel3,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(
												jPanel1,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addContainerGap()));

		pack();
	}// </editor-fold>
	//GEN-END:initComponents

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JButton jButtonStudentSearch;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel3;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JScrollPane jScrollPane4;
	private javax.swing.JTable jTable2;
	private javax.swing.JTextArea jTextAreaStudentLateActivity;
	private javax.swing.JTextArea jTextAreaStudentNotLateActivity;
	private javax.swing.JTextField jTextFieldOrgNameSearch;
	private javax.swing.JTextField jTextFieldPersonNameSearch;
	private javax.swing.JTextField jTextFieldPersonNumberSearch;
	private javax.swing.JTextField jTextFieldStudentName;

	// End of variables declaration//GEN-END:variables

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

	private void jTable2MousePressed(java.awt.event.MouseEvent evt) {
		int row = this.jTable2.getSelectedRow();
		String StudentNumber = jTable2.getValueAt(row, 0).toString();
		jTextFieldStudentName.setText(jTable2.getValueAt(row, 1).toString());
		StudentLateActivity(StudentNumber);
		StudentNotLateActivity(StudentNumber);
	}

	private void StudentNotLateActivity(String StudentNumber) {
		String sql = "EXEC proc_Student_Not_Late_Activity '" + StudentNumber
				+ "'";
		ResultSet rs = null;
		SqlFunction sqlFunction = new SqlFunction();
		String[] newPsString = {};
		rs = sqlFunction.doSqlSelect(sql, newPsString, false);
		String listActivities = "";
		try {
			while (rs.next()) {

				listActivities = listActivities + rs.getString("ActivityName")
						+ "\n";

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		sqlFunction.closeAllLink();
		// return listStudents;
		jTextAreaStudentNotLateActivity.setText(listActivities);
	}

	private void StudentLateActivity(String StudentNumber) {
		String sql = "EXEC proc_Student_Late_Activity '" + StudentNumber + "'";
		ResultSet rs = null;
		SqlFunction sqlFunction = new SqlFunction();
		String[] newPsString = {};
		rs = sqlFunction.doSqlSelect(sql, newPsString, false);
		String listActivities = "";
		try {
			while (rs.next()) {

				listActivities = listActivities + rs.getString("ActivityName")
						+ "\n";

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		sqlFunction.closeAllLink();
		// return listStudents;
		jTextAreaStudentLateActivity.setText(listActivities);
	}

	private void jButtonStudentSearchActionPerformed(
			java.awt.event.ActionEvent evt) {
		String PersonNumber = jTextFieldPersonNumberSearch.getText() + "";
		String PersonName = jTextFieldPersonNameSearch.getText() + "";
		String OrgName = jTextFieldOrgNameSearch.getText() + "";
		String[] psString = { PersonNumber, PersonName, OrgName };
		fillTableStudent(new Student(), psString);
	}
}