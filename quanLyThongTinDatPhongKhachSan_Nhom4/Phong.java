package quanLyThongTinDatPhongKhachSan_Nhom4;

import java.sql.Time;
import java.time.LocalDate;
import java.util.Date;

public class Phong {
	private KhachHang khachHang;
	private DichVu dichVu;
	private int soLuongDat;
	private int soPhong;
	private String tinhTrang;
	private double gia;
	private String loaiPhong;
	private String tenThietbi;
	private int soLuongThietbi;
	private LocalDate ngayDen,ngayDi;
	private Time gioNhan,gioTra;
	private double tongTien;
	
	public KhachHang getKhachHang() {
		return khachHang;
	}
	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}
	public DichVu getDichVu() {
		return dichVu;
	}
	public void setDichVu(DichVu dichVu) {
		this.dichVu = dichVu;
	}
	public int getSoPhong() {
		return soPhong;
	}
	public void setSoPhong(int soPhong) {
		this.soPhong = soPhong;
	}
	public String getTinhTrang() {
		return tinhTrang;
	}
	public void setTinhTrang(String tinhTrang) {
		this.tinhTrang = tinhTrang;
	}
	public double getGia() {
		return gia;
	}
	public void setGia(double gia) {
		this.gia = gia;
	}
	public String getLoaiPhong() {
		return loaiPhong;
	}
	public void setLoaiPhong(String loaiPhong) {
		this.loaiPhong = loaiPhong;
	}
	public String getTenThietbi() {
		return tenThietbi;
	}
	public void setTenThietbi(String tenThietbi) {
		this.tenThietbi = tenThietbi;
	}
	public int getSoLuongThietbi() {
		return soLuongThietbi;
	}
	public void setSoLuongThietbi(int soLuongThietbi) {
		this.soLuongThietbi = soLuongThietbi;
	}
	public int getSoLuongDat() {
		return soLuongDat;
	}
	public void setSoLuongDat(int soLuongDat) {
		this.soLuongDat = soLuongDat;
	}
	public LocalDate getNgayDen() {
		return ngayDen;
	}
	public void setNgayDen(LocalDate ngayDen) {
		this.ngayDen = ngayDen;
	}
	public LocalDate getNgayDi() {
		return ngayDi;
	}
	public void setNgayDi(LocalDate ngayDi) {
		this.ngayDi = ngayDi;
	}
	
	public Time getGioNhan() {
		return gioNhan;
	}
	public void setGioNhan(Time gioNhan) {
		this.gioNhan = gioNhan;
	}
	public Time getGioTra() {
		return gioTra;
	}
	public void setGioTra(Time gioTra) {
		this.gioTra = gioTra;
	}
	public double getTongTien() {
		return tongTien;
	}
	public void setTongTien(double tongTien) {
		this.tongTien = tongTien;
	}
	/////Thue phong
	public Phong(KhachHang khachHang, int soLuongDat, String loaiPhong, LocalDate ngayDen, LocalDate ngayDi) {
		super();
		this.khachHang = khachHang;
		this.soLuongDat = soLuongDat;
		this.loaiPhong = loaiPhong;
		this.ngayDen = ngayDen;
		this.ngayDi = ngayDi;
	}
	/////Nhan phong
	public Phong(KhachHang khachHang, int soPhong, LocalDate ngayDen, Time gioNhan) {
		super();
		this.khachHang = khachHang;
		this.soPhong = soPhong;
		this.ngayDen = ngayDen;
		this.gioNhan = gioNhan;
	}
	/////Tra phong
	public Phong(KhachHang khachHang, int soPhong, LocalDate ngayDi, Time gioTra, double tongTien) {
		super();
		this.khachHang = khachHang;
		this.soPhong = soPhong;
		this.ngayDi = ngayDi;
		this.gioTra = gioTra;
		this.tongTien=tongTien;
	}
	public Phong(int soPhong) {
		this.soPhong=soPhong;
		this.khachHang = null;
		this.dichVu = null;
		this.tinhTrang = "";
		this.gia = 0;
		this.loaiPhong = "";
		this.tenThietbi = "";
		this.soLuongThietbi = 0;
	}
	
	public Phong(KhachHang khachHang, String loaiPhong, LocalDate ngayDen) {
		super();
		this.khachHang = khachHang;
		this.loaiPhong = loaiPhong;
		this.ngayDen = ngayDen;
	}
	
	public Phong(String loaiPhong) {
		this.loaiPhong = loaiPhong;
		this.soPhong=0;
		this.khachHang = null;
		this.dichVu = null;
		this.tinhTrang = "";
		this.gia = 0;
		this.tenThietbi = "";
		this.soLuongThietbi = 0;
	}
	/////Phong
	public Phong(int soPhong, String tinhTrang,
			double gia, String loaiPhong, String tenThietbi, int soLuongThietbi) {
		this.soPhong = soPhong;
		this.tinhTrang = tinhTrang;
		this.gia = gia;
		this.loaiPhong = loaiPhong;
		this.tenThietbi = tenThietbi;
		this.soLuongThietbi = soLuongThietbi;
	}
	/////not use
	public Phong(KhachHang khachHang, DichVu dichVu, int soPhong, String tinhTrang,
			double gia, String loaiPhong, String tenThietbi, int soLuongThietbi) {
		this.khachHang = khachHang;
		this.dichVu = dichVu;
		this.soPhong = soPhong;
		this.tinhTrang = tinhTrang;
		this.gia = gia;
		this.loaiPhong = loaiPhong;
		this.tenThietbi = tenThietbi;
		this.soLuongThietbi = soLuongThietbi;
	}
	@Override
	public String toString() {
		return "Phong [khachHang=" + khachHang + ", dichVu=" + dichVu + ", soPhong=" + soPhong + ", tinhTrang="
				+ tinhTrang + ", gia=" + gia + ", loaiPhong=" + loaiPhong + ", tenThietbi=" + tenThietbi
				+ ", soLuongThietbi=" + soLuongThietbi + "]";
	}
	
	

}
