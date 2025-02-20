package bai4

interface Complexity {
    var Complexity: Int
    fun foo() {
        print("A")
    }
}

class Question(
    override var Complexity: Int,
    val question: String
) : Complexity {

}