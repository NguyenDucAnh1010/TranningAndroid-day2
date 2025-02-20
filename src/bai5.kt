class Address(var streetAddress:String, var city: String,var state: String, var zipCode:Long){
    override fun toString(): String {
        return "$streetAddress, $city, $state - $zipCode"
    }
}

class Student(var firstName:String, var lastName:String, var homeAddress:Address, var schoolAddress:Address){
    override fun toString(): String {
        return """Họ tên: $firstName $lastName
                |Địa chỉ nhà: $homeAddress
                |Địa chỉ trường: $schoolAddress""".trimMargin()
    }
}

fun main() {
    val homeAddress = Address("123 Lý Tự Trọng", "Hà Nội", "VN", 100000)
    val schoolAddress = Address("456 Trần Hưng Đạo", "Hà Nội", "VN", 100001)

    val student1 = Student("Nguyễn", "Văn A", homeAddress, schoolAddress)

    println(student1)
}