package bai3.model

class HinhVuong(mau: String, private val canh: Double) : HinhChuNhat(mau, canh, canh) {

    override fun LayThongTin(): String {
        return "Hình vuông ($mau) - Cạnh: $canh, Diện tích: ${TinhDienTich()}, Chu vi: ${TinhChuVi()}"
    }
}