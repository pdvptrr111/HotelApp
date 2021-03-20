package quanLyThongTinDatPhongKhachSan_Nhom4;

public class DichVu {
	private double doUong;
	private double doAn;
	private double khac;
	private int soLuongAn;
	private int soLuongUong;
	private int soLuongKhac;
	public DichVu(double doUong, double doAn, double khac, int soLuongAn, int soLuongUong, int soLuongKhac) {
		super();
		this.doUong = doUong;
		this.doAn = doAn;
		this.khac = khac;
		this.soLuongAn = soLuongAn;
		this.soLuongUong = soLuongUong;
		this.soLuongKhac = soLuongKhac;
	}
	public double tinhTienDV() {
		return doAn*soLuongAn+doUong*soLuongUong+khac*soLuongKhac;
	}
}
