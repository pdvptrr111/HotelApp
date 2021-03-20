package quanLyThongTinDatPhongKhachSan_Nhom4;

public class KhachHang {
	private String hoTen;
	private String CMND_Visa_PP;
	private String sdt;
	public String getHoten() {
		return hoTen;
	}
	public void setHoten(String hoTen) {
		this.hoTen = hoTen;
	}
	public String getCMND_Visa_PP() {
		return CMND_Visa_PP;
	}
	public void setCMND_Visa_PP(String CMND_Visa_PP) {
		this.CMND_Visa_PP = CMND_Visa_PP;
	}
	public KhachHang(String hoTen, String CMND_Visa_PP,String sdt) {
		super();
		this.hoTen = hoTen;
		this.CMND_Visa_PP = CMND_Visa_PP;
		this.sdt=sdt;
	}
	
	public KhachHang(String hoTen, String cMND_Visa_PP) {
		super();
		this.hoTen = hoTen;
		CMND_Visa_PP = cMND_Visa_PP;
	}
	public KhachHang(String hoTen) {
		super();
		this.hoTen = hoTen;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	
}
