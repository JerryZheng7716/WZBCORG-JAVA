package ls.Frame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import other.wzbcOrg.AdminLogin;
import other.wzbcOrg.OpenSituation;
import yhs.Frame.*;
import zjl.Frame.DepartManage;
import zjl.Frame.MessageSearch;
import zjl.Frame.PersonManage;
import zjl.Frame.SpecialtyManage;

public class Main extends javax.swing.JFrame {
	private JPanel timePanel;
	private JLabel timeLabel;
	private String DEFAULT_TIME_FORMAT = "当前时间： yyyy年MM月dd日  HH:mm:ss";
	private String time;
	private int ONE_SECOND = 1000;

	/**
	 * This method creates a timer task to update the time per second
	 */
	private void configTimeArea() {
		Timer tmr = new Timer();
		tmr.scheduleAtFixedRate(new JLabelTimerTask(), new Date(), ONE_SECOND);
	}

	/**
	 * Timer task to update the time display area
	 *
	 */
	protected class JLabelTimerTask extends TimerTask {
		SimpleDateFormat dateFormatter = new SimpleDateFormat(
				DEFAULT_TIME_FORMAT);

		public void run() {
			time = dateFormatter.format(Calendar.getInstance().getTime());
			jLabel1.setText(time);
		}
	}

	/** Creates new form Main */
	public Main() {
		initComponents();
		final JLabel jLabel2 = new JLabel();
		//
		jDesktopPane1.addComponentListener(new ComponentAdapter() {
			public void componentResized(final ComponentEvent e) {
				Dimension size = e.getComponent().getSize();
				jLabel2.setBounds(0, 0, size.width, size.height);
				//				jLabel2.setSize(e.getComponent().getSize());
				jLabel2.setText("<html><img width=" + size.width + " height="
						+ size.height + " src='"
						+ this.getClass().getResource("/images/MainForm.jpg")
						+ "'></html>");
				//					jDesktopPane1.add(jLabel2, new Integer(Integer.MIN_VALUE));
			}
		});

		//		JLabel jLabel2 = new JLabel();
		jLabel2.setBounds(0, 0, 980, 680);
		jLabel2.setText("<html><img width=" + 980 + " height=" + 680 + " src='"
				+ this.getClass().getResource("/images/MainForm.jpg")
				+ "'></html>");
		jDesktopPane1.add(jLabel2, new Integer(Integer.MIN_VALUE));

		configTimeArea();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);

	}

	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jDesktopPane1 = new javax.swing.JDesktopPane();
		jButton1 = new javax.swing.JButton();
		jButton2 = new javax.swing.JButton();
		jButton3 = new javax.swing.JButton();
		jButton4 = new javax.swing.JButton();
		jButton5 = new javax.swing.JButton();
		jButton6 = new javax.swing.JButton();
		jLabel1 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		jMenuBar1 = new javax.swing.JMenuBar();
		AdminManage = new javax.swing.JMenu();
		jMenuItem2 = new javax.swing.JMenuItem();
		jMenuItem3 = new javax.swing.JMenuItem();
		OrgManage = new javax.swing.JMenu();
		DepManage = new javax.swing.JMenu();
		SpeManage = new javax.swing.JMenu();
		PersonManage = new javax.swing.JMenu();
		ActivityManage = new javax.swing.JMenu();
		AttManage = new javax.swing.JMenu();
		AttManager = new javax.swing.JMenuItem();
		CheckInAndOut = new javax.swing.JMenuItem();
		jMenuItem1 = new javax.swing.JMenuItem();
		RewardManage = new javax.swing.JMenu();
		StatisticsManage = new javax.swing.JMenu();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowActivated(java.awt.event.WindowEvent evt) {
				formWindowActivated(evt);
			}
		});

		jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/images/MainButton1.png"))); // NOI18N
		jButton1.setBorder(null);
		jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jButton1MouseClicked(evt);
			}
		});
		jButton1.setBounds(20, 160, 139, 90);
		jDesktopPane1.add(jButton1, javax.swing.JLayeredPane.DEFAULT_LAYER);

		jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/images/MainButton2.png"))); // NOI18N
		jButton2.setBorder(null);
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});
		jButton2.setBounds(180, 160, 139, 90);
		jDesktopPane1.add(jButton2, javax.swing.JLayeredPane.DEFAULT_LAYER);

		jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/images/MainButton3.png"))); // NOI18N
		jButton3.setBorder(null);
		jButton3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton3ActionPerformed(evt);
			}
		});
		jButton3.setBounds(340, 160, 139, 90);
		jDesktopPane1.add(jButton3, javax.swing.JLayeredPane.DEFAULT_LAYER);

		jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/images/MainButton4.png"))); // NOI18N
		jButton4.setBorder(null);
		jButton4.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton4ActionPerformed(evt);
			}
		});
		jButton4.setBounds(500, 160, 139, 90);
		jDesktopPane1.add(jButton4, javax.swing.JLayeredPane.DEFAULT_LAYER);

		jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/images/MainButton5.png"))); // NOI18N
		jButton5.setBorder(null);
		jButton5.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton5ActionPerformed(evt);
			}
		});
		jButton5.setBounds(820, 160, 139, 90);
		jDesktopPane1.add(jButton5, javax.swing.JLayeredPane.DEFAULT_LAYER);

		jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/images/MainButton6.png"))); // NOI18N
		jButton6.setBorder(null);
		jButton6.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton6ActionPerformed(evt);
			}
		});
		jButton6.setBounds(660, 160, 139, 90);
		jDesktopPane1.add(jButton6, javax.swing.JLayeredPane.DEFAULT_LAYER);

		jLabel1.setText("jLabel1");
		jLabel1.setBounds(360, 430, 290, 40);
		jDesktopPane1.add(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

		jLabel3.setText("jLabel3");
		jLabel3.setBounds(340, 280, 490, 30);
		jDesktopPane1.add(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);

		jLabel4.setText("jLabel4");
		jLabel4.setBounds(390, 330, 290, 30);
		jDesktopPane1.add(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);

		AdminManage.setText("\u7ba1\u7406\u5458\u8bbe\u7f6e");

		jMenuItem2
				.setText("\u4fee\u6539\u5f53\u524d\u7528\u6237\u540d\u5bc6\u7801");
		jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItem2ActionPerformed(evt);
			}
		});
		AdminManage.add(jMenuItem2);

		jMenuItem3.setText("\u7ba1\u7406\u7ba1\u7406\u5458");
		jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItem3ActionPerformed(evt);
			}
		});
		AdminManage.add(jMenuItem3);

		jMenuBar1.add(AdminManage);

		OrgManage.setText("\u7ec4\u7ec7\u7ba1\u7406");
		OrgManage.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				OrgManageMouseClicked(evt);
			}
		});
		jMenuBar1.add(OrgManage);

		DepManage.setText("\u90e8\u95e8\u7ba1\u7406");
		DepManage.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				DepManageMouseClicked(evt);
			}
		});
		jMenuBar1.add(DepManage);

		SpeManage.setText("\u4e13\u4e1a\u7ba1\u7406");
		SpeManage.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				SpeManageMouseClicked(evt);
			}
		});
		jMenuBar1.add(SpeManage);

		PersonManage.setText("\u4eba\u5458\u7ba1\u7406");
		PersonManage.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				PersonManageMouseClicked(evt);
			}
		});
		jMenuBar1.add(PersonManage);

		ActivityManage.setText("\u6d3b\u52a8\u7ba1\u7406");
		ActivityManage.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				ActivityManageMouseClicked(evt);
			}
		});
		jMenuBar1.add(ActivityManage);

		AttManage.setText("\u8003\u52e4\u7ba1\u7406");

		AttManager.setText("\u8003\u52e4\u7ba1\u7406");
		AttManager.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				AttManagerActionPerformed(evt);
			}
		});
		AttManage.add(AttManager);

		CheckInAndOut.setText("\u7b7e\u5230\u7b7e\u9000");
		CheckInAndOut.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				CheckInAndOutActionPerformed(evt);
			}
		});
		AttManage.add(CheckInAndOut);

		jMenuItem1.setText("\u8003\u52e4\u67e5\u8be2");
		jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItem1ActionPerformed(evt);
			}
		});
		AttManage.add(jMenuItem1);

		jMenuBar1.add(AttManage);

		RewardManage.setText("\u5956\u60e9\u7ba1\u7406");
		RewardManage.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				RewardManageMouseClicked(evt);
			}
		});
		jMenuBar1.add(RewardManage);

		StatisticsManage.setText("\u7edf\u8ba1\u4fe1\u606f");
		StatisticsManage.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				StatisticsManageMouseClicked(evt);
			}
		});
		jMenuBar1.add(StatisticsManage);

		setJMenuBar(jMenuBar1);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 980,
				javax.swing.GroupLayout.PREFERRED_SIZE));
		layout.setVerticalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 680,
				javax.swing.GroupLayout.PREFERRED_SIZE));

		pack();
		init();
	}// </editor-fold>
	//GEN-END:initComponents

	private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//考勤查询
		AttendanceActivityManager attendanceActivityManager = new AttendanceActivityManager();
		attendanceActivityManager.setClosable(true);
		attendanceActivityManager.setVisible(true);
		this.jDesktopPane1.add(attendanceActivityManager);
		attendanceActivityManager.toFront();
	}

	private void RewardManageMouseClicked(java.awt.event.MouseEvent evt) {//奖惩管理
		RewardManager rewardManager = new RewardManager();
		rewardManager.setClosable(true);
		rewardManager.setVisible(true);
		this.jDesktopPane1.add(rewardManager);
		rewardManager.toFront();
	}

	private void ActivityManageMouseClicked(java.awt.event.MouseEvent evt) {//活动管理
		ActivityManager activityManager = new ActivityManager();
		activityManager.setClosable(true);
		activityManager.setVisible(true);
		this.jDesktopPane1.add(activityManager);
		activityManager.toFront();
	}

	private void OrgManageMouseClicked(java.awt.event.MouseEvent evt) {//组织管理
		OrgManager orgManager = new OrgManager();
		orgManager.setClosable(true);
		orgManager.setVisible(true);
		this.jDesktopPane1.add(orgManager);
		orgManager.toFront();
	}

	private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//综合查询
		StatisticsManage();
	}

	private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//注销登录
		LoginFrame LoginFrame = new LoginFrame();
		LoginFrame.setVisible(true);
		this.dispose();
		OpenSituation.setOpenAdminChange(false);
		OpenSituation.setOpenAdminManage(false);
		OpenSituation.setOpenDepartManage(false);
		OpenSituation.setOpenMessgeSearch(false);
		OpenSituation.setOpenPersonManage(false);
		OpenSituation.setOpenSpecialty(false);
		AdminLogin.setAdminLevel("");
		AdminLogin.setAdminName("");
		AdminLogin.setAdminOrgCount("");
		AdminLogin.setAdminPassword("");
		AdminLogin.setOrgName("");
	}

	private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//人员管理
		PersonManage();
	}

	private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//考勤查询
		AttendanceActivityManager attendanceActivityManager = new AttendanceActivityManager();
		attendanceActivityManager.setClosable(true);
		attendanceActivityManager.setVisible(true);
		this.jDesktopPane1.add(attendanceActivityManager);
		attendanceActivityManager.toFront();
	}

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//考勤管理
		AttManager attManager = new AttManager();
		attManager.setClosable(true);
		attManager.setVisible(true);
		this.jDesktopPane1.add(attManager);
		attManager.toFront();
	}

	private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//活动管理
		ActivityManager activityManager = new ActivityManager();
		activityManager.setClosable(true);
		activityManager.setVisible(true);
		this.jDesktopPane1.add(activityManager);
		activityManager.toFront();
	}

	private void StatisticsManageMouseClicked(java.awt.event.MouseEvent evt) {//综合查询
		StatisticsManage();
	}

	private void StatisticsManage() {
		MessageSearch messageSearch = new MessageSearch();
		if (OpenSituation.isOpenMessgeSearch()) {
			return;
		} else {
			messageSearch.setVisible(true);
			messageSearch.setClosable(true);
			messageSearch.setIconifiable(true);
			messageSearch.setMaximizable(true);
			this.jDesktopPane1.add(messageSearch);
			messageSearch.toFront();
		}
	}

	private void PersonManageMouseClicked(java.awt.event.MouseEvent evt) {//人员管理
		PersonManage();
	}

	private void PersonManage() {
		PersonManage personManage = new PersonManage();
		if (OpenSituation.isOpenSpecialty()) {
			return;
		} else {
			personManage.setVisible(true);
			personManage.setClosable(true);
			personManage.setIconifiable(true);
			personManage.setMaximizable(true);
			this.jDesktopPane1.add(personManage);
			personManage.toFront();
		}
	}

	private void SpeManageMouseClicked(java.awt.event.MouseEvent evt) {//专业管萝
		SpecialtyManage specialtyManage = new SpecialtyManage();
		if (OpenSituation.isOpenSpecialty()) {
			return;
		} else {
			specialtyManage.setVisible(true);
			specialtyManage.setClosable(true);
			specialtyManage.setIconifiable(true);
			specialtyManage.setMaximizable(true);
			this.jDesktopPane1.add(specialtyManage);
			specialtyManage.toFront();
		}
	}

	private void DepManageMouseClicked(java.awt.event.MouseEvent evt) {//部门管理
		DepartManage departManage = new DepartManage();
		if (OpenSituation.isOpenDepartManage()) {
			return;
		} else {
			departManage.setVisible(true);
			departManage.setClosable(true);
			departManage.setIconifiable(true);
			departManage.setMaximizable(true);
			this.jDesktopPane1.add(departManage);
			departManage.toFront();
		}
	}

	private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {
		if (AdminLogin.getAdminLevel().equals("学生干事")) {
			JOptionPane.showMessageDialog(null, "越级操作，无权访问!!");
			return;
		}
		AdminManage adminManage = new AdminManage();
		if (OpenSituation.isOpenAdminManage()) {
			return;
		} else {
			adminManage.setVisible(true);
			adminManage.setClosable(true);
			adminManage.setIconifiable(true);
			adminManage.setMaximizable(true);
			this.jDesktopPane1.add(adminManage);
			adminManage.toFront();
		}
	}

	private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {
		AdminChange adminChange = new AdminChange();
		if (OpenSituation.isOpenAdminChange()) {
			return;
		} else {
			adminChange.setVisible(true);
			adminChange.setClosable(true);
			adminChange.setIconifiable(true);
			adminChange.setMaximizable(true);
			this.jDesktopPane1.add(adminChange);
			adminChange.toFront();
		}
	}

	private void init() {
		jLabel1.setFont(new java.awt.Font("微软雅黑", 0, 14));
		jLabel1.setText("jLabel1");
		jLabel1.setBounds(360, 330, 290, 30);
		jLabel3.setFont(new java.awt.Font("微软雅黑", 0, 14));
		jLabel3.setText("欢迎您  , " + AdminLogin.getAdminLevel() + "："
				+ AdminLogin.getAdminName());
		jLabel3.setBounds(360, 270, 290, 30);
		jLabel4.setFont(new java.awt.Font("微软雅黑", 0, 14));
		jLabel4.setText("您所在 , " + AdminLogin.getOrgName() + ", 共有:"
				+ AdminLogin.getAdminOrgCount() + "人");
		jLabel4.setBounds(360, 300, 290, 30);
	}

	private void CheckInAndOutActionPerformed(java.awt.event.ActionEvent evt) {
		CheckInAndOutManager checkInAndOutManager = new CheckInAndOutManager();
		checkInAndOutManager.setClosable(true);
		checkInAndOutManager.setClosable(true);
		checkInAndOutManager.setVisible(true);
		this.jDesktopPane1.add(checkInAndOutManager);
		checkInAndOutManager.toFront();
	}

	private void AttManagerActionPerformed(java.awt.event.ActionEvent evt) {
		AttManager attManager = new AttManager();
		attManager.setClosable(true);
		attManager.setVisible(true);
		this.jDesktopPane1.add(attManager);
		attManager.toFront();
	}

	private void formWindowActivated(java.awt.event.WindowEvent evt) {
		Color c = new Color(0, 0, 255);
		jButton1.setBackground(c);
		jButton1.setOpaque(false);
		jButton2.setBackground(c);
		jButton2.setOpaque(false);
		jButton3.setBackground(c);
		jButton3.setOpaque(false);
		jButton4.setBackground(c);
		jButton4.setOpaque(false);
		jButton5.setBackground(c);
		jButton5.setOpaque(false);
		jButton6.setBackground(c);
		jButton6.setOpaque(false);
		JLabel jLabel3 = new JLabel();
		JLabel jLabel4 = new JLabel();
		//jLabel3.setText("欢迎您,"++,++);

	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Main().setVisible(true);
			}
		});
	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JMenu ActivityManage;
	private javax.swing.JMenu AdminManage;
	private javax.swing.JMenu AttManage;
	private javax.swing.JMenuItem AttManager;
	private javax.swing.JMenuItem CheckInAndOut;
	private javax.swing.JMenu DepManage;
	private javax.swing.JMenu OrgManage;
	private javax.swing.JMenu PersonManage;
	private javax.swing.JMenu RewardManage;
	private javax.swing.JMenu SpeManage;
	private javax.swing.JMenu StatisticsManage;
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JButton jButton3;
	private javax.swing.JButton jButton4;
	private javax.swing.JButton jButton5;
	private javax.swing.JButton jButton6;
	private javax.swing.JDesktopPane jDesktopPane1;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JMenuBar jMenuBar1;
	private javax.swing.JMenuItem jMenuItem1;
	private javax.swing.JMenuItem jMenuItem2;
	private javax.swing.JMenuItem jMenuItem3;
	// End of variables declaration//GEN-END:variables

}
