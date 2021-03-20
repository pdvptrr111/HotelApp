package quanLyThongTinDatPhongKhachSan_Nhom4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class QuanLy {
	private static ArrayList<Phong> dsThuePhong;
	private static ArrayList<Phong> dsNhanPhong;
	private static ArrayList<Phong> dsTraPhong;
	private static ArrayList<Phong> dsPhong;
	private static ArrayList<Phong> dsPhongTrong;
	private static int pVipTrong, pNLTrong;

	public QuanLy() {
		dsThuePhong = new ArrayList<Phong>();
		dsNhanPhong = new ArrayList<Phong>();
		dsTraPhong = new ArrayList<Phong>();
		dsPhong = new ArrayList<Phong>();

	}

	/////////// Thue phong
	public ArrayList<Phong> docTuBangThuePhong() {
		try {
			Database.getInstance();
			Connection con = Database.getInstance().getConnection();
			String sql = "select * from THUE";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String cmnd = rs.getString(1);
				String hoTen = rs.getString(2);
				int soLuongPhong = rs.getInt(3);
				String loaiPhong = rs.getString(4);
				LocalDate ngayDen = rs.getDate(5).toLocalDate();
				LocalDate ngayDi = rs.getDate(6).toLocalDate();
				String sdt = rs.getString(7);
				Phong p = new Phong(new KhachHang(hoTen, cmnd, sdt), soLuongPhong, loaiPhong, ngayDen, ngayDi);
				dsThuePhong.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsThuePhong;
	}

	public static int themThuePhong(Phong p) {
		for (int i = 0; i < dsThuePhong.size(); i++) {
			if (dsThuePhong.get(i).getKhachHang().getCMND_Visa_PP().equals(p.getKhachHang().getCMND_Visa_PP())) {
				if (dsThuePhong.get(i).getNgayDen().getDayOfMonth() == p.getNgayDen().getDayOfMonth()) {
					if (dsThuePhong.get(i).getNgayDen().getMonth() == p.getNgayDen().getMonth()) {
						if (dsThuePhong.get(i).getNgayDen().getYear() == p.getNgayDen().getYear()) {
							if (dsThuePhong.get(i).getLoaiPhong().trim().equals(p.getLoaiPhong().trim())) {
								return -1;
							}

						}
					}
				}
			}
		}
		dsThuePhong.add(p);
		Connection con = Database.getInstance().getConnection();
		PreparedStatement stm = null;
		int n = 0;
		try {
			stm = con.prepareStatement("insert into THUE values(?,?,?,?,?,?,?)");
			stm.setString(1, p.getKhachHang().getCMND_Visa_PP());
			stm.setString(2, p.getKhachHang().getHoten());
			stm.setInt(3, p.getSoLuongDat());
			stm.setString(4, p.getLoaiPhong());
			stm.setDate(5, java.sql.Date.valueOf(p.getNgayDen()));
			stm.setDate(6, java.sql.Date.valueOf(p.getNgayDi()));
			stm.setString(7, p.getKhachHang().getSdt());
			n = stm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n;
	}

	public static int capNhatThuePhong(Phong p) {
		Connection con = Database.getInstance().getConnection();
		PreparedStatement stm = null;
		int n = 0;
		try {
			stm = con.prepareStatement(
					"update THUE set SoLuongPhong=?,SDT=? where Cmnd=? and NgayDen=? and LoaiPhong=?");
			stm.setInt(1, p.getSoLuongDat());
			stm.setString(2, p.getKhachHang().getSdt());
			stm.setString(3, p.getKhachHang().getCMND_Visa_PP());
			stm.setDate(4, java.sql.Date.valueOf(p.getNgayDen()));
			stm.setString(5, p.getLoaiPhong() + "  ");
			n = stm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n;
	}

	// Kiểm tra số lượng phòng còn lại với loại tương ứng có còn đủ để đặt
	public static boolean kiemTraSoLuongPhongDat(int num, String loai) {
		if (soPhongConTheoLoai(loai) >= num) {
			return true;
		}
		return false;
	}

	//// chua xong
	public static int soPhongConTheoLoai(String loai) {
		dsPhongTrong = new ArrayList<>();
		dsPhongTrong = dsPhongTrong(loai);
		if (loai.equals("VIP  ")) {
			pVipTrong = dsPhongTrong.size();
			return pVipTrong;
		} else {
			pNLTrong = dsPhongTrong.size();
			return pNLTrong;
		}

	}

	public static int xoaThuePhong(int row) {
		int n = 0;
		Connection con = Database.getInstance().getConnection();
		PreparedStatement stm = null;
		try {
			stm = con.prepareStatement("delete from THUE where Cmnd=? and NgayDen=? and LoaiPhong=?");
			stm.setString(1, dsThuePhong.get(row).getKhachHang().getCMND_Visa_PP());
			stm.setDate(2, java.sql.Date.valueOf(dsThuePhong.get(row).getNgayDen()));
			stm.setString(3, dsThuePhong.get(row).getLoaiPhong());
			if (row >= 0 && row <= dsThuePhong.size()) {
				dsThuePhong.remove(row);
				n = 1;
			}
			n = stm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return n;
	}

	public static ArrayList<Phong> dsPhongTrong(String loai) {
		try {
			Database.getInstance();
			Connection con = Database.getInstance().getConnection();
			String sql = "select * from PHONG where TinhTrang='off' and LoaiPhong='" + loai + "'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				int soPhong = rs.getInt(1);
				String loaiPhong = rs.getString(2);
				Double gia = rs.getDouble(3);
				String tenThietbi = rs.getString(4);
				int soLuongThietbi = rs.getInt(5);
				String tinhTrang = rs.getString(6);
				Phong p = new Phong(soPhong, tinhTrang, gia, loaiPhong, tenThietbi, soLuongThietbi);
				dsPhongTrong.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsPhongTrong;
	}

	//////////////////// Nhan phong
	public ArrayList<Phong> docTuBangNhanPhong() {
		try {
			Database.getInstance();
			Connection con = Database.getInstance().getConnection();
			String sql = "select * from NHAN";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				int soPhong = rs.getInt(1);
				String hoTen = rs.getString(2);
				LocalDate ngayNhan = rs.getDate(3).toLocalDate();
				Time gioNhan = rs.getTime(4);
				Phong p = new Phong(new KhachHang(hoTen), soPhong, ngayNhan, gioNhan);
				dsNhanPhong.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsNhanPhong;
	}

	/////////////////// Tra phong
	public ArrayList<Phong> docTuBangTraPhong() {
		try {
			Database.getInstance();
			Connection con = Database.getInstance().getConnection();
			String sql = "select * from TRA";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				int soPhong = rs.getInt(1);
				String hoTen = rs.getString(2);
				LocalDate ngayTra = rs.getDate(3).toLocalDate();
				Time gioTra = rs.getTime(4);
				double tongTien = rs.getDouble(5);
				Phong p = new Phong(new KhachHang(hoTen), soPhong, ngayTra, gioTra, tongTien);
				dsTraPhong.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsTraPhong;
	}

	/////////////////// Phong va loai phong
	public static ArrayList<Phong> docTuBangPhong() {
		try {
			Database.getInstance();
			Connection con = Database.getInstance().getConnection();
			String sql = "select * from PHONG";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				int soPhong = rs.getInt(1);
				String loaiPhong = rs.getString(2);
				Double gia = rs.getDouble(3);
				String tenThietbi = rs.getString(4);
				int soLuongThietbi = rs.getInt(5);
				String tinhTrang = rs.getString(6);
				Phong p = new Phong(soPhong, tinhTrang, gia, loaiPhong, tenThietbi, soLuongThietbi);
				dsPhong.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsPhong;
	}

	///////// UI4
	///////////////// Phong va loai phong
	public static ArrayList<Phong> docTuBangPhong1() {
		try {
			Connection con = Database.getInstance().getConnection();
			String sql = "Select * from Phong";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				int so = rs.getInt(1);
				String loai = rs.getString(2);
				double gia = rs.getDouble(3);
				String tenThietbi = rs.getString(4);
				int soluong = rs.getInt(5);
				String tinhtrang = rs.getString(6);
				Phong e = new Phong(so, tinhtrang, gia, loai, tenThietbi, soluong);
				dsPhong.add(e);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsPhong;
	}

	public boolean themttphong(int soph, String tinhtrang, double gia, String loai, String tenThietbi,
			int soLuongThietbi) {
		Connection con = Database.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("insert into Phong values(?,?,?,?,?,?)");
			stmt.setInt(1, soph);
			stmt.setString(2, loai);
			stmt.setDouble(3, gia);
			stmt.setString(4, tenThietbi);
			stmt.setInt(5, soLuongThietbi);
			stmt.setString(6, "off");
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0;

	}

	public boolean xoaphong(int soph) {
		Connection con = Database.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("delete from Phong where soPhong =?");
			stmt.setInt(1, soph);
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0;

	}

	public boolean capnhap(int soph, String tinhtrang, double gia, String loai, String tenThietbi, int soLuongThietbi) {
		Connection con = Database.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("update Phong" + " set tinhTrang= ?, " + " gia= ? ," + " loaiPhong= ? ,"
					+ " tenThietbi= ? ," + " soLuong= ? " + " where soPhong= ? ");

			stmt.setString(1, "off");
			stmt.setDouble(2, gia);
			stmt.setString(3, loai);
			stmt.setString(4, tenThietbi);
			stmt.setInt(5, soLuongThietbi);
			stmt.setInt(6, soph);

			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return n > 0;

	}
}
