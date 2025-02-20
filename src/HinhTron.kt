import kotlin.math.PI

class HinhTron(mau: String, private val bankinh: Double): Hinh(mau) {

    override fun TinhDienTich(): Double {
        return PI * bankinh * bankinh
    }

    override fun TinhChuVi(): Double {
        return 2 * PI * bankinh
    }

    override fun LayThongTin(): String {
        return "Hình tròn ($mau) - Bán kính: $bankinh, Diện tích: ${TinhDienTich()}, Chu vi: ${TinhChuVi()}"
    }
}