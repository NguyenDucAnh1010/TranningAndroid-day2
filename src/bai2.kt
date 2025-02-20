import kotlin.math.PI

open class Point(private var x: Int, private var y: Int) {
    override fun toString(): String {
        return "Tọa độ: [$x, $y]"
    }
}

class Cicrle(x: Int, y:Int, private var radius:Double):Point (x,y) {
    override fun toString(): String {
        return "Circle(${super.toString()}, Bán kính: $radius)"
    }

    fun getDiameter():Double{
        return 2 * radius
    }

    fun getCircumference(): Double {
        return 2 * PI * radius
    }

    fun getArea(): Double {
        return PI * radius * radius
    }
}

fun main(){
    var countCicrle: Int?
    do {
        print("Nhập số lượng hình tròn: ")
        countCicrle = readlnOrNull()?.toIntOrNull()
    }while (countCicrle == null)

    val circles = mutableListOf<Cicrle>()

    for (i in 1..countCicrle) {
        println("Nhập thông tin hình tròn thứ $i:")
        print("  Nhập x: ")
        val x = readlnOrNull()?.toIntOrNull() ?: 0
        print("  Nhập y: ")
        val y = readlnOrNull()?.toIntOrNull() ?: 0
        print("  Nhập bán kính: ")
        val r = readlnOrNull()?.toDoubleOrNull() ?: 0.0

        if (r <= 0) {
            println("Bán kính phải > 0. Dùng giá trị mặc định (1.0)")
            circles.add(Cicrle(x, y, 1.0))
        } else {
            circles.add(Cicrle(x, y, r))
        }
    }

    println("\nThông tin các hình tròn:")
    for (circle in circles) {
        println(circle)
        println("  - Đường kính: %.2f".format(circle.getDiameter()))
        println("  - Chu vi: %.2f".format(circle.getCircumference()))
        println("  - Diện tích: %.2f".format(circle.getArea()))
        println("--------------------------")
    }
}