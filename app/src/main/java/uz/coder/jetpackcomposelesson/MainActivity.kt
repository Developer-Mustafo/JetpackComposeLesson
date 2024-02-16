package uz.coder.jetpackcomposelesson


import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import uz.coder.jetpackcomposelesson.ui.theme.JetpackComposeLessonTheme
class MainActivity : ComponentActivity() {
    private val viewModel by lazy {
        ViewModelProvider(this@MainActivity)[MyViewModel::class.java]
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(color = MaterialTheme.colorScheme.background) {
                GreeThing()
            }
        }
    }
    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview(){
        JetpackComposeLessonTheme {
            GreeThing()
        }
    }
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun GreeThing(){
        val color = Color.DarkGray
        Column(modifier = Modifier.fillMaxSize()) {
            var text by remember { mutableStateOf("") }
            TextField(value = text, onValueChange = {text = it}, modifier = Modifier.fillMaxWidth())
            Row(modifier = Modifier.align(alignment =  Alignment.CenterHorizontally)) {
                Button(colors = ButtonDefaults.buttonColors(color), onClick = {
                    viewModel.add(text)
                }
                    ){
                    Text("Saqlash")
                }
                Button(colors = ButtonDefaults.buttonColors(color),onClick = {
                    Log.d(TAG, "greeThing: ${viewModel.getList()}")
                }){
                    Text("Ko'rsatish")
                }
            }
        }
    }
}

private const val TAG = "MainActivity"