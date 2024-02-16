package uz.coder.jetpackcomposelesson

interface DatabaseService {
    fun add(str: String)
    fun allList(): List<String>
}