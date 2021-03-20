package quanLyThongTinDatPhongKhachSan_Nhom4;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Time;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DateFormatter;



public class UI extends JFrame implements ActionListener, MouseListener {
	private JTextField txtCMND, txtHoTen, txtSoLuongPhong, txtNgayDen, txtNgayDi, txtSdt, txtTenNguoiNhan, txtGioNhan,
			txtNgayNhan, txtSoPhongTra, txtTenNguoiTra, txtGioTra, txtNgayTra, txtSoPhong, txtLoaiPhong4, txtGiaCoBan,
			txtTenThietBi, txtSoLuong, txtMess1, txtMess2, txtMess3, txtMess4;
	private JButton btn1, btn2, btn3, btn4, btnDK, btnHuyDK, btnXoaTrang1, btnLuu1, btnSua1, btnCheckP1, btnThem2,
			btnXoaTrang2, btnLuu2, btnSua2, btnLoc2, btnThem3, btnXoaTrang3, btnLuu3, btnCheckP3, btnThem4, btnXoa4,
			btnXoaTrang4, btnLuu4, btnSua4;
	private JTable table1, table2, table3, table4;
	private JComboBox<String> cboLoai1, cboLoai2, cboLoai4, cboPhong;
	public static DefaultTableModel tableModel1, tableModel2, tableModel3, tableModel4;
	JFrame fr1;

	public UI() {
		setTitle("Quản lý thông tin đặt phòng khách sạn");
		setSize(900, 600);
		setLocation(250, 80);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		JPanel pN = new JPanel();
		JPanel pn = new JPanel();
		pn.add(btn1 = new JButton("Quản lý đăng ký thuê phòng"));
		pn.add(btn2 = new JButton("Quản lý thông tin nhận phòng"));
		pn.add(btn3 = new JButton("Quản lý việc trả phòng"));
		pn.add(btn4 = new JButton("Quản lý thông tin phòng và loại phòng"));
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		btn4.addActionListener(this);
		quanLyThongTinDatPhongKhachSan_Nhom4.Database.getInstance().connect();
		add(pn);

	}

	private void UI1() {
		// JFrame
		fr1 = new JFrame("Quản lý đăng ký thuê phòng");
		JLabel lblCMND, lblHoTen, lblSoLuongPhong, lblLoaiPhong, lblNgayDen, lblNgayDi, lblSdt;
		JPanel pn1 = new JPanel();
		pn1.setLayout(null);
		//////// Nhập
		JPanel pN1 = new JPanel();
		pN1.setBorder(BorderFactory.createTitledBorder("Nhập thông tin thuê phòng"));
		pN1.setBackground(Color.orange);
		pN1.setLayout(null);
		pN1.add(lblCMND = new JLabel("Số CMND: "));
		pN1.add(lblHoTen = new JLabel("Họ tên: "));
		pN1.add(lblSoLuongPhong = new JLabel("Số lượng phòng: "));
		pN1.add(lblLoaiPhong = new JLabel("Loại phòng: "));
		pN1.add(lblNgayDen = new JLabel("Ngày đến: "));
		pN1.add(lblNgayDi = new JLabel("Ngày đi: "));
		pN1.add(lblSdt = new JLabel("Số điện thoại: "));

		pN1.add(txtCMND = new JTextField());
		pN1.add(txtHoTen = new JTextField());
		pN1.add(txtSoLuongPhong = new JTextField());
		pN1.add(btnCheckP1 = new JButton("Kiểm tra số lượng"));
		String[] loaiP = { "VIP", "NL" };
		pN1.add(cboLoai1 = new JComboBox<>(loaiP));
		pN1.add(txtNgayDen = new JTextField());
		pN1.add(txtNgayDi = new JTextField());
		pN1.add(txtSdt = new JTextField());
		pN1.add(txtMess1 = new JTextField());
		txtMess1.setEditable(false);
		txtMess1.setForeground(Color.red);
		txtMess1.setBorder(null);
		txtMess1.setBackground(Color.orange);

		int w = 200, h = 23;
		lblCMND.setBounds(5, 20, w, h);
		txtCMND.setBounds(210, 20, w, h);
		lblHoTen.setBounds(5, 45, w, h);
		txtHoTen.setBounds(210, 45, w, h);
		lblSoLuongPhong.setBounds(5, 70, w, h);
		txtSoLuongPhong.setBounds(210, 70, 60, h);
		btnCheckP1.setBounds(270, 70, 140, 50);
		lblLoaiPhong.setBounds(5, 95, w, h);
		txtMess1.setBounds(5, 120, 500, h);
		cboLoai1.setBounds(210, 95, 60, h);
		lblNgayDen.setBounds(450, 20, w, h);
		txtNgayDen.setBounds(650, 20, w, h);
		lblNgayDi.setBounds(450, 50, w, h);
		txtNgayDi.setBounds(650, 50, w, h);
		lblSdt.setBounds(450, 80, w, h);
		txtSdt.setBounds(650, 80, w, h);

		pn1.add(pN1);
		pN1.setBounds(0, 0, 900, 150);
		//// /////Chức năng
		JPanel pC1 = new JPanel();
		pC1.setBorder(BorderFactory.createTitledBorder("Chọn tác vụ"));

		pn1.add(pC1);
		pC1.setBounds(0, 150, 900, 60);
		pC1.setBackground(Color.green);
		pC1.add(btnDK = new JButton("Đăng ký"));
		pC1.add(btnHuyDK = new JButton("Hủy đăng ký"));
		pC1.add(btnXoaTrang1 = new JButton("Xóa trắng ô"));
		pC1.add(btnSua1 = new JButton("Sửa thông tin"));
		pC1.add(btnLuu1 = new JButton("Lưu thông tin"));

		JScrollPane scroll;
		String[] headers1 = "CMND;Họ tên;Số lượng phòng;Loại phòng;Ngày đến;Ngày đi;Số điện thoại".split(";");
		tableModel1 = new DefaultTableModel(headers1, 0);
		pn1.add(scroll = new JScrollPane(table1 = new JTable(tableModel1), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED));
		scroll.setBorder(BorderFactory.createTitledBorder("Danh sách thuê phòng"));
		table1.setRowHeight(20);
		scroll.setPreferredSize(new Dimension(0, 350));
		scroll.setBounds(0, 210, 900, 360);
		scroll.setBackground(Color.cyan);
		table1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				int row = table1.getSelectedRow();
				fillForm1(row);
			}
		});

		btnDK.addActionListener(this);
		btnHuyDK.addActionListener(this);
		btnXoaTrang1.addActionListener(this);
		btnSua1.addActionListener(this);
		btnLuu1.addActionListener(this);
		btnCheckP1.addActionListener(this);
		updateTableData1();

		fr1.add(pn1);
		fr1.setSize(900, 600);
		fr1.setResizable(false);
		fr1.setLocation(250, 80);
		fr1.setVisible(true);
	}

	public void UI2() {
		JFrame fr2 = new JFrame("Quản lý thông tin nhận phòng");
		JPanel pn2 = new JPanel();
		JLabel lblSoPhongNhan, lblTenNguoiNhan, lblNgayNhan, lbllGioNhan, lblLoai;
		pn2.setLayout(null);
		///////////// Nhập
		JPanel pN2 = new JPanel();
		pN2.setBorder(BorderFactory.createTitledBorder("Nhập thông tin nhận phòng"));
		pN2.setBackground(Color.orange);
		pN2.setLayout(null);
		pN2.add(lblSoPhongNhan = new JLabel("Số phòng nhận: "));
		pN2.add(lblTenNguoiNhan = new JLabel("Họ tên người nhận: "));
		pN2.add(lblNgayNhan = new JLabel("Ngày nhận: "));
		pN2.add(lbllGioNhan = new JLabel("Giờ nhận: "));

		pN2.add(cboPhong = new JComboBox<>());
		//// Lọc phòng trống và thêm vào ComBobox
		// .............................
		pN2.add(txtTenNguoiNhan = new JTextField());
		pN2.add(txtNgayNhan = new JTextField());
		pN2.add(txtGioNhan = new JTextField());
		pN2.add(txtMess2 = new JTextField());
		txtMess2.setEditable(false);
		txtMess2.setForeground(Color.red);
		txtMess2.setBorder(null);
		txtMess2.setBackground(Color.orange);

		int w = 200, h = 23;
		lblSoPhongNhan.setBounds(5, 20, w, h);

		cboPhong.setBounds(210, 20, w, h);
		lblTenNguoiNhan.setBounds(5, 45, w, h);
		txtMess2.setBounds(5, 70, w, h);
		txtTenNguoiNhan.setBounds(210, 45, w, h);
		lblNgayNhan.setBounds(450, 20, w, h);
		txtNgayNhan.setBounds(650, 20, w, h);
		lbllGioNhan.setBounds(450, 50, w, h);
		txtGioNhan.setBounds(650, 50, w, h);
		pn2.add(pN2);
		pN2.setBounds(0, 0, 900, 105);
		//// Chức năng
		JPanel pC2 = new JPanel();
		pC2.setBorder(BorderFactory.createTitledBorder("Chọn tác vụ"));
		pn2.add(pC2);
		pC2.setBounds(0, 105, 900, 70);
		pC2.setBackground(Color.green);
		JSplitPane spl = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);

		JPanel pC21 = new JPanel();
		pC21.add(lblLoai = new JLabel("Chọn loại phòng cần lọc"));
		String[] loaiP = { "VIP", "NL" };
		pC21.add(cboLoai2 = new JComboBox<>(loaiP));
		pC21.add(btnLoc2 = new JButton("Lọc danh sách phòng trống"));
		spl.setLeftComponent(pC21);
		JPanel pC22 = new JPanel();

		pC22.add(btnThem2 = new JButton("Thêm"));
		pC22.add(btnXoaTrang2 = new JButton("Xóa trắng ô"));
		pC22.add(btnSua2 = new JButton("Sửa"));
		pC22.add(btnLuu2 = new JButton("Lưu"));
		spl.setRightComponent(pC22);
		pC2.add(spl);

		JScrollPane scroll;
		String[] headers2 = "Số phòng nhận; Họ tên người nhận;Ngày nhận; Giờ nhận".split(";");
		tableModel2 = new DefaultTableModel(headers2, 0);
		pn2.add(scroll = new JScrollPane(table2 = new JTable(tableModel2), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED));
		scroll.setBorder(BorderFactory.createTitledBorder("Danh sách nhận phòng"));
		table2.setRowHeight(20);
		scroll.setPreferredSize(new Dimension(0, 350));
		scroll.setBounds(0, 175, 900, 390);
		scroll.setBackground(Color.cyan);

		btnThem2.addActionListener(this);
		btnXoaTrang2.addActionListener(this);
		btnSua2.addActionListener(this);
		btnLuu2.addActionListener(this);
		btnLoc2.addActionListener(this);

		updateTableData2();

		fr2.add(pn2);
		fr2.setSize(900, 600);
		fr2.setResizable(false);
		fr2.setLocation(250, 80);
		fr2.setVisible(true);
	}

	public void UI3() {
		JFrame fr3 = new JFrame("Quản lý việc trả phòng phòng");
		JPanel pn3 = new JPanel();
		JLabel lblSoPhongTra, lblTenNguoiTra, lblNgayTra, lbllGioTra;
		pn3.setLayout(null);
		///////////// Nhập
		JPanel pN3 = new JPanel();
		pN3.setBorder(BorderFactory.createTitledBorder("Nhập thông tin trả phòng"));
		pN3.setBackground(Color.orange);
		pN3.setLayout(null);
		pN3.add(lblSoPhongTra = new JLabel("Số phòng trả: "));
		pN3.add(lblTenNguoiTra = new JLabel("Họ tên người trả: "));
		pN3.add(lblNgayTra = new JLabel("Ngày trả: "));
		pN3.add(lbllGioTra = new JLabel("Giờ trả: "));

		pN3.add(txtSoPhongTra = new JTextField());
		pN3.add(btnCheckP3 = new JButton("Check phòng"));
		pN3.add(txtTenNguoiTra = new JTextField());
		txtTenNguoiTra.setEditable(false);
		pN3.add(txtNgayTra = new JTextField());
		pN3.add(txtGioTra = new JTextField());
		pN3.add(txtMess3 = new JTextField());
		txtMess3.setEditable(false);
		txtMess3.setForeground(Color.red);
		txtMess3.setBorder(null);
		txtMess3.setBackground(Color.orange);

		int w = 200, h = 23;
		lblSoPhongTra.setBounds(5, 20, w, h);
		txtSoPhongTra.setBounds(210, 20, 50, h);
		btnCheckP3.setBounds(260, 20, 150, h);
		lblTenNguoiTra.setBounds(5, 45, w, h);
		txtMess3.setBounds(5, 70, w, h);
		txtTenNguoiTra.setBounds(210, 45, w, h);
		lblNgayTra.setBounds(450, 20, w, h);
		txtNgayTra.setBounds(650, 20, w, h);
		lbllGioTra.setBounds(450, 50, w, h);
		txtGioTra.setBounds(650, 50, w, h);
		pn3.add(pN3);
		pN3.setBounds(0, 0, 900, 105);
		//// Chức năng
		JPanel pC3 = new JPanel();
		pC3.setBorder(BorderFactory.createTitledBorder("Chọn tác vụ"));
		pn3.add(pC3);
		pC3.setBounds(0, 105, 900, 60);
		pC3.setBackground(Color.green);
		pC3.add(btnThem3 = new JButton("Trả phòng"));
		pC3.add(btnXoaTrang3 = new JButton("Xóa trắng ô"));
		pC3.add(btnLuu3 = new JButton("Lưu"));

		JScrollPane scroll;
		String[] headers3 = "Số phòng trả; Họ tên người trả;Ngày trả; Giờ trả;Tổng tiền".split(";");
		tableModel3 = new DefaultTableModel(headers3, 0);
		pn3.add(scroll = new JScrollPane(table3 = new JTable(tableModel3), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED));
		scroll.setBorder(BorderFactory.createTitledBorder("Danh sách trả phòng"));
		table3.setRowHeight(20);
		scroll.setPreferredSize(new Dimension(0, 350));
		scroll.setBounds(0, 165, 900, 400);
		scroll.setBackground(Color.cyan);

		btnThem3.addActionListener(this);
		btnCheckP3.addActionListener(this);
		btnXoaTrang3.addActionListener(this);
		btnLuu3.addActionListener(this);

		updateTableData3();

		fr3.add(pn3);
		fr3.setSize(900, 600);
		fr3.setResizable(false);
		fr3.setLocation(250, 80);
		fr3.setVisible(true);
	}

	public void UI4() {
		JFrame fr4 = new JFrame("Quản lý thông tin phòng và loại phòng");
		JPanel pn4 = new JPanel();
		JLabel lblSoPhong, lblLoaiPhong4, lblGiaCoBan, lblTenThietBi, lblSoLuong;
		pn4.setLayout(null);
		///////////// Nhập
		JPanel pN4 = new JPanel();
		pN4.setBorder(BorderFactory.createTitledBorder("Nhập thông tin phòng và loại phòng"));
		pN4.setBackground(Color.orange);
		pN4.setLayout(null);
		pN4.add(lblSoPhong = new JLabel("Số phòng: "));
		pN4.add(lblLoaiPhong4 = new JLabel("Loại phòng: "));
		pN4.add(lblGiaCoBan = new JLabel("Giá cơ bản: "));

		pN4.add(lblTenThietBi = new JLabel("Tên thiết bị: "));
		pN4.add(lblSoLuong = new JLabel("Số lượng: "));

		pN4.add(txtSoPhong = new JTextField());
		String[] loaiP = { "VIP", "NL" };
		pN4.add(cboLoai4 = new JComboBox<>(loaiP));
		pN4.add(txtGiaCoBan = new JTextField());
		pN4.add(txtTenThietBi = new JTextField());
		pN4.add(txtSoLuong = new JTextField());
		pN4.add(txtMess4 = new JTextField());
		txtMess4.setEditable(false);
		txtMess4.setForeground(Color.red);
		txtMess4.setBorder(null);
		txtMess4.setBackground(Color.orange);

		int w = 200, h = 23;
		lblSoPhong.setBounds(5, 20, w, h);
		txtSoPhong.setBounds(210, 20, w, h);
		lblLoaiPhong4.setBounds(5, 45, w, h);
		cboLoai4.setBounds(210, 45, w, h);
		lblGiaCoBan.setBounds(5, 70, w, h);
		txtMess4.setBounds(5, 95, w, h);
		txtGiaCoBan.setBounds(210, 70, w, h);
		lblTenThietBi.setBounds(450, 20, w, h);
		txtTenThietBi.setBounds(650, 20, w, h);
		lblSoLuong.setBounds(450, 45, w, h);
		txtSoLuong.setBounds(650, 45, w, h);
		pn4.add(pN4);
		pN4.setBounds(0, 0, 900, 125);
		//// Chức năng
		JPanel pC4 = new JPanel();
		pC4.setBorder(BorderFactory.createTitledBorder("Chọn tác vụ"));
		pn4.add(pC4);
		pC4.setBounds(0, 125, 900, 60);
		pC4.setBackground(Color.green);
		pC4.add(btnThem4 = new JButton("Thêm"));
		pC4.add(btnXoa4 = new JButton("Xóa"));
		pC4.add(btnXoaTrang4 = new JButton("Xóa trắng ô"));
		pC4.add(btnSua4 = new JButton("Sửa"));
		pC4.add(btnLuu4 = new JButton("Lưu"));

		JScrollPane scroll;
		String[] headers4 = "Số phòng; Loại phòng; Giá cơ bản;Tên thiết bị; Số lượng; Tình trạng".split(";");
		tableModel4 = new DefaultTableModel(headers4, 0);
		pn4.add(scroll = new JScrollPane(table4 = new JTable(tableModel4), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED));
		scroll.setBorder(BorderFactory.createTitledBorder("Danh sách phòng và loại phòng"));
		table4.setRowHeight(20);
		scroll.setPreferredSize(new Dimension(0, 350));
		scroll.setBounds(0, 185, 900, 380);
		scroll.setBackground(Color.cyan);
		/// chép phần này
		table4.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				int row = table4.getSelectedRow();
				fillForm4(row);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});

		btnThem4.addActionListener(this);
		btnXoa4.addActionListener(this);
		btnXoaTrang4.addActionListener(this);
		btnSua4.addActionListener(this);
		btnLuu4.addActionListener(this);

		updateTableData4();

		fr4.add(pn4);
		fr4.setSize(900, 600);
		fr4.setResizable(false);
		fr4.setLocation(250, 80);
		fr4.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj.equals(btn1)) {
			UI1();
		} else if (obj.equals(btn2)) {
			UI2();
		} else if (obj.equals(btn3)) {
			UI3();
		} else if (obj.equals(btn4)) {
			UI4();
		} else if (obj.equals(btnDK)) {
			if (kiemTraNhap1()) {
				if (QuanLy.themThuePhong(getField1()) > 0) {
					String[] row = { txtCMND.getText(), txtHoTen.getText(), txtSoLuongPhong.getText(),
							(String) cboLoai1.getSelectedItem(), txtNgayDen.getText(), txtNgayDi.getText(),
							txtSdt.getText() };
					tableModel1.addRow(row);
					txtMess1.setText("Đăng ký thành công!");
				} else
					txtMess1.setText("Đăng ký thất bại!----Trùng CMND-Loại Phòng-Ngày đến, vui lòng kiểm tra lại");
			}
		} else if (obj.equals(btnHuyDK)) {
			int row = table1.getSelectedRow();
			if (row != -1) {
				int loiNhac = JOptionPane.showConfirmDialog(fr1, "Chắc chắn xóa không ?", "Chú ý",
						JOptionPane.YES_NO_OPTION);
				if (loiNhac == JOptionPane.YES_OPTION) {
					if (QuanLy.xoaThuePhong(row) > 0) {
						tableModel1.removeRow(row);
						txtMess1.setText("Đã hủy đăng ký.");
						clearTextFields1();
					}
				}
			} else
				txtMess1.setText("Bạn phải chọn thuê phòng cần xóa");
		} else if (obj.equals(btnXoaTrang1)) {
			clearTextFields1();
			txtCMND.setEditable(true);
			txtHoTen.setEditable(true);
			cboLoai1.setEditable(true);
			txtNgayDen.setEditable(true);
			txtNgayDi.setEditable(true);
			txtCMND.requestFocus();
		} else if (obj.equals(btnCheckP1)) {
			if (txtSoLuongPhong.getText().trim().equals("")) {
				txtMess1.setText("Số lượng phòng trống!");
			} else {
				String loai = (String) cboLoai1.getSelectedItem();
				int x = Integer.parseInt(txtSoLuongPhong.getText().trim());
				if (QuanLy.kiemTraSoLuongPhongDat(x, loai)) {
					txtMess1.setText("Còn đủ phòng.");
				} else
					txtMess1.setText("Không còn đủ phòng. Số phòng " + loai + " còn lại:"
							+ Integer.toString(QuanLy.soPhongConTheoLoai(loai)));
			}
		} else if (obj.equals(btnSua1)) {
			int row = table1.getSelectedRow();
			if (row != 1) {
				fillForm1(row);
				txtCMND.setEditable(false);
				txtHoTen.setEditable(false);
				txtNgayDen.setEditable(false);
				txtSoLuongPhong.selectAll();
				txtSoLuongPhong.requestFocus();
				cboLoai1.setEditable(false);
				txtNgayDi.setEditable(false);
			}
		} else if (obj.equals(btnLuu1)) {
			if (kiemTraNhap1()) {
				if (QuanLy.capNhatThuePhong(getField1()) > 0) {
					// int x=tableModel1.getRowCount();
					for (int i = 0; i < tableModel1.getRowCount(); i++) {
						tableModel1.removeRow(i);
					}
					table1.removeAll();
					updateTableData1();
					txtMess1.setText("Cập nhật thành công!");
				} else
					txtMess1.setText("Cập nhật thất bại!");
			}
		}
		// chép hết ac tion 4 cái này
		if (obj.equals(btnThem4)) {
			if (kiemtra4() == true) {
				try {
					QuanLy ql = new QuanLy();
					if (cboLoai4.getSelectedItem().toString().equalsIgnoreCase("VIP")) {
						ql.themttphong(Integer.parseInt(txtSoPhong.getText()), "con phong",
								Double.parseDouble(txtGiaCoBan.getText()), "VIP", txtTenThietBi.getText(),
								Integer.parseInt(txtSoLuong.getText()));
					} else {
						ql.themttphong(Integer.parseInt(txtSoPhong.getText()), "con phong",
								Double.parseDouble(txtGiaCoBan.getText()), "NL", txtTenThietBi.getText(),
								Integer.parseInt(txtSoLuong.getText()));
					}

					ql.docTuBangPhong1();
					updateTableData4();
					;
					txtMess4.setText("them thanh cong");
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(this, "nhap sai du lieu");
				}
			} else
				;
		}
		if (obj.equals(btnXoa4)) {
			int row = table4.getSelectedRow();
			if (row < 0)
				JOptionPane.showMessageDialog(this, "chua chon dòng cần xóa");

			else {
				int chon = JOptionPane.showConfirmDialog(null, "xac nhan xoa", "xac nhan", JOptionPane.YES_NO_OPTION);

				if (chon == JOptionPane.YES_OPTION) {
					QuanLy ql = new QuanLy();

					int r = (int) Integer.parseInt(table4.getValueAt(row, 0).toString());
					ql.xoaphong(r);
					ql.docTuBangPhong1();
					table4.clearSelection();
					updateTableData4();
					JOptionPane.showMessageDialog(this, " đã xóa");
				}
			}
		}
		if (obj.equals(btnSua4)) {
			try {
				QuanLy ql = new QuanLy();
				if (cboLoai4.getSelectedItem().toString().equalsIgnoreCase("VIP")) {
					ql.capnhap(Integer.parseInt(txtSoPhong.getText()), "off", Double.parseDouble(txtGiaCoBan.getText()),
							"VIP", txtTenThietBi.getText(), Integer.parseInt(txtSoLuong.getText()));
				} else {
					ql.capnhap(Integer.parseInt(txtSoPhong.getText()), "off", Double.parseDouble(txtGiaCoBan.getText()),
							"NL", txtTenThietBi.getText(), Integer.parseInt(txtSoLuong.getText()));
				}
				ql.docTuBangPhong1();
				updateTableData4();
				txtMess4.setText("sua thanh cong");

			} catch (Exception ex) {

				txtMess4.setText("nhap sai du lieu");
				ex.printStackTrace();
			}

		}
		if (obj.equals(btnXoaTrang4)) {
			txtSoPhong.setText("");
			txtSoPhong.setEditable(true);
			txtGiaCoBan.setText("");
			txtSoLuong.setText("");
			txtTenThietBi.setText("");
			txtMess4.setText("");
		}
	}

	//////////////// UI1
	private void clearTextFields1() {
		txtCMND.setText("");
		txtHoTen.setText("");
		txtSoLuongPhong.setText("");
		cboLoai1.setSelectedIndex(0);
		txtNgayDen.setText("");
		txtNgayDi.setText("");
		txtSdt.setText("");
	}

	private boolean kiemTraNhap1() {
		String cmnd = txtCMND.getText().trim();
		String hoTen = txtHoTen.getText().trim();
		String so = txtSoLuongPhong.getText().trim();
		String den = txtNgayDen.getText().trim();
		String di = txtNgayDi.getText().trim();
		String sdt = txtSdt.getText().trim();
		if (cmnd.length() <= 0) {
			txtMess1.setText("Chứng minh nhân dân không được để trống!");
			return false;
		} else if (!(cmnd.matches("\\d{9}"))) {
			txtMess1.setText("Chứng minh nhân dân chứa 9 số theo mẫu: \\d{9}");
			return false;
		}

		if (hoTen.length() <= 0) {
			txtMess1.setText("Họ tên không được để trống!");
			return false;
		} else if (!(hoTen.matches("[a-zA-Z ]+"))) {
			txtMess1.setText("Họ tên chỉ chứa chữ không dấu theo mẫu: [a-zA-Z ]");
			return false;
		}

		if (so.length() <= 0) {
			txtMess1.setText("Số lượng phòng không được để trống!");
			return false;
		} else {
			if (!so.matches("\\d{2}")) {
				txtMess1.setText("Số lượng phòng theo dạng: \\d{2}");
				return false;
			} else {
				int x = Integer.parseInt(so);
				if (x <= 0) {
					txtMess1.setText("Số lượng phòng phải >= 0");
					return false;
				}
			}
		}

		if (den.length() <= 0) {
			txtMess1.setText("Ngày đến không được để trống!");
			return false;
		} else {
			if (!(den.matches("\\d{4}(-)\\d{2}(-)\\d{2}"))) {
				txtMess1.setText("Ngày đến theo mẫu:\\d{4}(-)\\d{2}(-)\\d{2}  ví dụ: 2019-04-30");
				return false;
			} else {
				String[] dateDen = den.split("-");
				int year = Integer.parseInt(dateDen[0]);
				int month = Integer.parseInt(dateDen[1]);
				int day = Integer.parseInt(dateDen[2]);
				if (year < 0) {
					txtMess1.setText("Năm phải > 0");
					return false;
				}
				if (month < 0 || month > 12) {
					txtMess1.setText("Tháng phải > 0 và <= 12");
					return false;
				}
				if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
					if (day < 0 || day > 31) {
						txtMess1.setText("Ngày phải > 0 và <=31 trong tháng:" + month);
						return false;
					}
				}
				if (month == 4 || month == 6 || month == 9 || month == 11) {
					if (day < 0 || day > 30) {
						txtMess1.setText("Ngày phải > 0 và <=30 trong tháng:" + month);
						return false;
					}
				}
				if (month == 2 && year % 4 == 0) {
					if (day < 0 || day > 29) {
						txtMess1.setText("Ngày phải > 0 và <=29 trong tháng:" + month);
						return false;
					}
				} else if (month == 2 && year % 4 != 0) {
					if (day < 0 || day > 28) {
						txtMess1.setText("Ngày phải > 0 và <=28 trong tháng:" + month);
						return false;
					}
				}
				LocalDate date = LocalDate.now();
				if (year < date.getYear()) {
					txtMess1.setText("Năm phải lớn hoặc bằng năm hiện tại:" + date.getYear());
					return false;
				} else if (year == date.getYear()) {
					if (month < date.getMonthValue()) {
						txtMess1.setText("Tháng phải lớn hơn hoặc bằng tháng hiện tại:" + date.getMonthValue());
						return false;
					} else if (month == date.getMonthValue()) {
						if (day < date.getDayOfMonth()) {
							txtMess1.setText("Ngày phải lớn hơn hoặc bằng ngày hiện tại:" + date.getDayOfMonth());
							return false;
						}
					}
				}
			}
		}
		if (di.length() <= 0) {
			txtMess1.setText("Ngày đến không được để trống!");
			return false;
		} else {
			if (!(di.matches("\\d{4}(-)\\d{2}(-)\\d{2}"))) {
				txtMess1.setText("Ngày đến theo mẫu:\\d{4}(-)\\d{2}(-)\\d{2}  ví dụ: 2019-04-30");
				return false;
			} else {
				String[] dateDi = di.split("-");
				int year = Integer.parseInt(dateDi[0]);
				int month = Integer.parseInt(dateDi[1]);
				int day = Integer.parseInt(dateDi[2]);
				if (year < 0) {
					txtMess1.setText("Năm phải > 0");
					return false;
				}
				if (month < 0 || month > 12) {
					txtMess1.setText("Tháng phải > 0 và <= 12");
					return false;
				}
				if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
					if (day < 0 || day > 31) {
						txtMess1.setText("Ngày phải > 0 và <=31 trong tháng:" + month);
						return false;
					}
				}
				if (month == 4 || month == 6 || month == 9 || month == 11) {
					if (day < 0 || day > 30) {
						txtMess1.setText("Ngày phải > 0 và <=30 trong tháng:" + month);
						return false;
					}
				}
				if (month == 2 && year % 4 == 0) {
					if (day < 0 || day > 29) {
						txtMess1.setText("Ngày phải > 0 và <= 29 trong tháng" + month);
						return false;
					}
				} else if (month == 2 && year % 4 != 0) {
					if (day < 0 || day > 28) {
						txtMess1.setText("Ngày phải > 0 và <= 28 trong tháng:" + month);
						return false;
					}
				}
				String[] dateDen = den.split("-");
				int year1 = Integer.parseInt(dateDen[0]);
				int month1 = Integer.parseInt(dateDen[1]);
				int day1 = Integer.parseInt(dateDen[2]);
				LocalDate date = LocalDate.now();
				if (year < year1) {
					txtMess1.setText("Năm đi phải >= năm đến:" + year1);
					return false;
				} else if (year == year1) {
					if (month < month1) {
						txtMess1.setText("Tháng đi phải >= tháng đến:" + month1);
						return false;
					} else if (month == month1) {
						if (day < day1) {
							txtMess1.setText("Ngày đi phải >= ngày đến:" + day1);
							return false;
						}
					}

				}

			}
		}
		if (sdt.length() <= 0) {
			txtMess1.setText("Số điện thoại không được để trống!");
			return false;
		} else if (!(sdt.matches("\\d{10}"))) {
			txtMess1.setText("Số điện thoại chứa 10 số");
			return false;
		}
		return true;
	}

	private void fillForm1(int row) {
		if (row != -1) {
			txtCMND.setText((String) table1.getValueAt(row, 0).toString() + " ");
			txtHoTen.setText((String) table1.getValueAt(row, 1).toString() + " ");
			txtSoLuongPhong.setText((String) table1.getValueAt(row, 2).toString() + " ");
			// cboLoai1.setSelectedItem((String) table1.getValueAt(row, 3).toString()+" ");
			if (((String) table1.getValueAt(row, 3)).equalsIgnoreCase("VIP  "))
				cboLoai1.setSelectedItem("VIP");
			else
				cboLoai1.setSelectedItem("NL");
			;
			txtNgayDen.setText((String) table1.getValueAt(row, 4).toString() + " ");
			txtNgayDi.setText((String) table1.getValueAt(row, 5).toString() + " ");
			txtSdt.setText((String) table1.getValueAt(row, 6).toString() + " ");
		}
	}

	private void updateTableData1() {
		QuanLy ql = new QuanLy();
		ArrayList<Phong> list = ql.docTuBangThuePhong();
		for (Phong phong : list) {
			String[] rowData = { phong.getKhachHang().getCMND_Visa_PP(), phong.getKhachHang().getHoten(),
					Integer.toString(phong.getSoLuongDat()), phong.getLoaiPhong(), phong.getNgayDen().toString(),
					phong.getNgayDi().toString(), phong.getKhachHang().getSdt() };
			tableModel1.addRow(rowData);
		}
		table1.setModel(tableModel1);
	}

	private Phong getField1() {
		String cmnd = txtCMND.getText().trim();
		String hoTen = txtHoTen.getText().trim();

		String so = txtSoLuongPhong.getText().trim();
		int soLuongDat = so.length() == 0 ? 0 : Integer.parseInt(so);

		String loaiPhong = (String) cboLoai1.getSelectedItem();

		String den = txtNgayDen.getText().trim();
		LocalDate ngayDen = LocalDate.parse(den);

		String di = txtNgayDi.getText().trim();
		LocalDate ngayDi = LocalDate.parse(di);

		String sdt = txtSdt.getText().trim();

		return new Phong(new KhachHang(hoTen, cmnd, sdt), soLuongDat, loaiPhong, ngayDen, ngayDi);
	}

	///////////// UI2
	private void updateTableData2() {
		QuanLy ql = new QuanLy();
		ArrayList<Phong> list = ql.docTuBangNhanPhong();
		for (Phong phong : list) {
			String[] rowData = { Integer.toString(phong.getSoPhong()), phong.getKhachHang().getHoten(),
					phong.getNgayDen().toString(), phong.getGioNhan().toString() };
			tableModel2.addRow(rowData);
		}
		table2.setModel(tableModel2);
	}

	///////////// UI3
	private void updateTableData3() {
		QuanLy ql = new QuanLy();
		ArrayList<Phong> list = ql.docTuBangTraPhong();
		for (Phong phong : list) {
			String[] rowData = { Integer.toString(phong.getSoPhong()), phong.getKhachHang().getHoten(),
					phong.getNgayDi().toString(), phong.getGioTra().toString(), Double.toString(phong.getTongTien()) };
			tableModel3.addRow(rowData);
		}
		table3.setModel(tableModel3);
	}

	///////////// UI4
////////chép cái này
	private void updateTableData4() {
		QuanLy ql = new QuanLy();
		ArrayList<Phong> list = ql.docTuBangPhong1();
		tableModel4.getDataVector().removeAllElements();
		for (Phong phong : list) {
			Object[] rowData = { Integer.toString(phong.getSoPhong()), phong.getLoaiPhong(),
					Double.toString(phong.getGia()), phong.getTenThietbi(), Integer.toString(phong.getSoLuongThietbi()),
					phong.getTinhTrang() };
			tableModel4.addRow(rowData);
		}
		table4.setModel(tableModel4);
	}

	boolean kiemtra4() {
		try {
			if (txtSoPhong.getText().equalsIgnoreCase("")) {
				txtMess4.setText("chua nhap so phong");
				return false;
			}
			if (txtGiaCoBan.getText().equalsIgnoreCase("")) {
				txtMess4.setText("chua nhap gia co ban");
				return false;
			}
			if (txtTenThietBi.getText().equalsIgnoreCase("")) {
				txtMess4.setText("chua nhap Ten thiet bi");
				return false;
			}
			if (txtSoLuong.getText().equalsIgnoreCase("")) {
				txtMess4.setText("chua nhap so luong thiet bi");
				return false;
			}

			if (Integer.parseInt(txtSoPhong.getText()) < 0) {
				txtMess4.setText("so phong lon hon 0");
				return false;
			}
			if (Double.parseDouble(txtGiaCoBan.getText()) < 0) {
				txtMess4.setText("gia co ban phai lon hon 0");
				return false;
			}
			if (Integer.parseInt(txtSoLuong.getText()) < 0) {
				txtMess4.setText("nhap sai so luong thiet bi");
				return false;
			}
			QuanLy ql = new QuanLy();
			for (Phong s : ql.docTuBangPhong()) {
				if (s.getSoPhong() == Integer.parseInt(txtSoPhong.getText())) {
					txtMess4.setText("da co phong nay");
					return false;
				}
			}
		} catch (Exception e) {
			txtMess4.setText("phai nhap so");

		}
		return true;
	}

	private void fillForm4(int row) {
		if (row != -1) {
			txtSoPhong.setText(table4.getValueAt(row, 0).toString() + "");

			if ((table4.getValueAt(row, 1).toString()).equalsIgnoreCase("VIP")) {
				cboLoai4.setSelectedIndex(0);
			} else {
				cboLoai4.setSelectedIndex(1);
			}
			txtGiaCoBan.setText((String) table4.getValueAt(row, 2).toString() + "");
			txtTenThietBi.setText((String) table4.getValueAt(row, 3).toString() + "");
			txtSoLuong.setText((String) table4.getValueAt(row, 4).toString() + "");
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int row = table1.getSelectedRow();
		fillForm1(row);

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
