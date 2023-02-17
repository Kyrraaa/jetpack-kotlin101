import android.app.Activity
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExtendedFloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

@Composable
fun BackButton() {
    val activity = (LocalContext.current as? Activity)
    ExtendedFloatingActionButton(
        backgroundColor = Color.LightGray,
        modifier = Modifier
            .padding(all = 10.dp),
        onClick = {
            activity?.finish()
        },
        icon = {
            Icon(
                Icons.Filled.ArrowBack,
                contentDescription = "ArrowBack"
            )
        },
        text = { Text("Return") }
    )
}