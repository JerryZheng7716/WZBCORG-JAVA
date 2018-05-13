package com.yhs.JTable;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import com.sun.org.apache.xpath.internal.operations.Bool;
import com.yhs.dao.StudentDao;
import com.yhs.model.Student;

public class JTableStudent extends JTable{
	MyTable mt = new MyTable();
	private JTable table = new JTable();
	StudentDao studentDao;

	public JTableStudent(Student student, String[] psString) {
		super();
		this.table.setModel(new DefaultTableModel(new Object[][] {
				
		}, new String[] { "学生学号", "学生姓名", "所属组织", "是否加入" }));
		JCheckBox jc1 = new JCheckBox("是否添加", false);
//		jc1.setSelected(false);
		this.table.getColumnModel().getColumn(3).setCellEditor(
				new DefaultCellEditor(jc1));

		DefaultTableModel dtm = (DefaultTableModel) this.table.getModel();
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
//				Boolean  a = false;
//				v.add(a);

				dtm.addRow(v);
			}
		}

	}

	public JTable getTable() {
		return table;
	}
	


}

class MyTable extends AbstractTableModel {

	Object[][] p = {};

	String[] n = { "学生学号", "学生姓名", "所属组织", "是否添加" };

	public int getRowCount() {
		return p.length;
	}

	public int getColumnCount() {
		return n.length;
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		return p[rowIndex][columnIndex];
	}

	public String getColumnName(int column) {
		return n[column];
	}

	public Class<?> getColumnClass(int columnIndex) {
		return getValueAt(0, columnIndex).getClass();
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return true;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		p[rowIndex][columnIndex] = aValue;
		fireTableCellUpdated(rowIndex, columnIndex);
	}
}
