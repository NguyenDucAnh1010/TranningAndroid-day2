data class Category (val id:Int,var nameCategory:String, var listProduct: MutableList<Product>)
data class Product (val id:Int,var nameProduct: String, var price:Double, var origin:String)

fun addProduct(mutableProduct:MutableList<Product>){
    print("Mã sản phẩm: ")
    val idProduct = readlnOrNull()?.toIntOrNull()
    print("Tên sản phẩm: ")
    val nameProduct = readlnOrNull()
    print("Giá cả: ")
    val priceProduct = readlnOrNull()?.toDoubleOrNull()
    print("Xuất xứ: ")
    val originProduct = readlnOrNull()
    if (idProduct!= null && nameProduct != null && priceProduct != null && originProduct != null)
        mutableProduct.add(Product(idProduct,nameProduct,priceProduct,originProduct))
}

fun enterValue(mutableCategory:MutableList<Category>,mutableProduct:MutableList<Product>){
    println("Nhập danh mục")
    print("Mã danh mục: ")
    val idCategory = readlnOrNull()?.toIntOrNull()
    print("Tên danh mục: ")
    val nameCategory = readlnOrNull()
    println("--------------------------")

    var countProduct: Int?
    do {
        print("Nhập số lượng sản phẩm: ")
        countProduct = readlnOrNull()?.toIntOrNull()
    }while (countProduct == null)

    for (i in 1..countProduct){
        println("Nhập sản phẩm thứ $i")
        addProduct(mutableProduct)
        println("--------------------------")
    }

    if (idCategory!= null && nameCategory != null)
        mutableCategory.add(Category(idCategory,nameCategory,mutableProduct))

    printListCategory(mutableCategory)
}

fun printListCategory(mutableCategory:MutableList<Category>){
    println("\nDanh sách danh mục")
    for (category in mutableCategory){
        println("Mã danh mục: ${category.id}, Tên danh mục: ${category.nameCategory}")
        println("\nDanh sách sản phẩm của")
        for (product in category.listProduct){
            println(product)
            println("--------------------------")
        }
    }
}

fun listOfProduct(mutableCategory:MutableList<Category>){
    var idSearchCategory: Int?
    do {
        print("Nhập mã danh mục mà bạn muốn tìm: ")
        idSearchCategory = readlnOrNull()?.toIntOrNull()
    }while (idSearchCategory == null)


    println("Danh sách sản phẩm theo danh mục:")
    val category = mutableCategory.find { it.id == idSearchCategory }
    if (category!=null){
        for (product in category.listProduct){
            println(product)
        }
    }else{
        println("Không tìm thấy danh mục")
    }
}

fun updateProduct(mutableCategory:MutableList<Category>){
    var idCategoryToUpdate: Int?
    do {
        print("Nhập mã sản phẩm mà bạn muốn sửa: ")
        idCategoryToUpdate = readlnOrNull()?.toIntOrNull()
    }while (idCategoryToUpdate == null)

    var idProductToUpdate: Int?
    do {
        print("Nhập mã sản phẩm mà bạn muốn sửa: ")
        idProductToUpdate = readlnOrNull()?.toIntOrNull()
    }while (idProductToUpdate == null)

    val category = mutableCategory.find { it.id == idCategoryToUpdate }
    if (category!=null){
        val product = category.listProduct.find { it.id == idProductToUpdate }

        if (product != null){
            println("Cập nhập sản phẩm")
            print("Tên sản phẩm: ")
            val newNameProduct = readlnOrNull()
            if (newNameProduct!=null) product.nameProduct = newNameProduct
            print("Giá cả: ")
            val newPriceProduct = readlnOrNull()?.toDoubleOrNull()
            if (newPriceProduct!=null) product.price = newPriceProduct
            print("Xuất xứ: ")
            val newOriginProduct = readlnOrNull()
            if (newOriginProduct!=null) product.origin = newOriginProduct

            if (newNameProduct != null && newPriceProduct != null && newOriginProduct != null) {
                product.nameProduct = newNameProduct
                product.price = newPriceProduct
                product.origin = newOriginProduct

                println("Cập nhật sản phẩm thành công!\n")
                printListCategory(mutableCategory)
            } else {
                println("Thông tin nhập vào không hợp lệ, cập nhật thất bại!")
            }
        }else {
            println("Không tìm thấy sản phẩm với ID $idProductToUpdate")
        }
    }else{
        println("Không tìm thấy sản phẩm với ID $idCategoryToUpdate")
    }
}

fun deleteProduct(mutableCategory: MutableList<Category>) {
    print("Nhập ID danh mục: ")
    val idCategoryToDelete = readlnOrNull()?.toIntOrNull()
    val isCategoryRemove = mutableCategory.find { it.id == idCategoryToDelete }

    if (isCategoryRemove!= null){
        print("Nhập ID sản phẩm cần xóa: ")
        val idProductToDelete = readlnOrNull()?.toIntOrNull()
        val isRemoved = isCategoryRemove.listProduct.removeIf{ it.id == idProductToDelete }

        if (isRemoved) {
            println("Xóa sản phẩm thành công!")
            printListCategory(mutableCategory)
        } else {
            println("Không tìm thấy sản phẩm với ID $idProductToDelete")
        }
    }else{
        println("Không tìm thấy danh mục với ID $idCategoryToDelete")
    }
}

fun totalPriceOf(mutableProduct: MutableList<Product>){
    val totalValue = mutableProduct.sumOf { it.price }
    println("Tổng giá trị của các mặt hàng: $totalValue")
}

fun listChinaProduct(mutableProduct: MutableList<Product>){
    val chinaProducts = mutableProduct.filter { it.origin.equals("Trung Quốc", ignoreCase = true) }
    for (product in chinaProducts){
        println(product)
    }
}

fun main(){
    val mutableCategory:MutableList<Category> = mutableListOf()
    val mutableProduct:MutableList<Product> = mutableListOf()

    do {
        println("\n--- QUẢN LÝ BÁN HÀNG ---")
        println("1. Thêm danh mục sản phẩm và sản phẩm")
        println("2. Xuất danh sách sản phẩm theo danh mục")
        println("3. Cập nhật sản phẩm")
        println("4. Xóa sản phẩm")
        println("5. Tính tổng giá trị hàng hóa")
        println("6. Liệt kê sản phẩm xuất xứ Trung Quốc")
        println("7. Thoát")

        print("Chọn chức năng: ")
        val choice = readln().toIntOrNull() ?: -1

        when (choice) {
            1 -> enterValue(mutableCategory,mutableProduct)
            2 -> listOfProduct(mutableCategory)
            3 -> updateProduct(mutableCategory)
            4 -> deleteProduct(mutableCategory)
            5 -> totalPriceOf(mutableProduct)
            6 -> listChinaProduct(mutableProduct)
            7 -> {
                println("Thoát chương trình.")
                return
            }
            else -> println("Lựa chọn không hợp lệ!")
        }
        println()
    }while (true)
}