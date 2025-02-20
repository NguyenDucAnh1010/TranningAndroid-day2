open class HinhChuNhat(mau: String, private var chieudai: Double, private var chieurong: Double) : Hinh(mau) {
    override fun TinhDienTich(): Double {
        return chieudai * chieurong
    }

    override fun TinhChuVi(): Double {
        return 2 * (chieudai + chieurong)
    }

    override fun LayThongTin(): String {
        return "Hình chữ nhật ($mau) - Dài: $chieudai, Rộng: $chieurong, Diện tích: ${TinhDienTich()}, Chu vi: ${TinhChuVi()}"
    }
}