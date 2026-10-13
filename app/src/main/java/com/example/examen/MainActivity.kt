package com.example.examen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Scaffold(
                modifier = Modifier.fillMaxSize(),
                containerColor = Color(0xFFFAF7F2)
            ) { innerPadding ->
                Pantalla(modifier = Modifier.padding(innerPadding))
            }
        }
    }
}

@Composable
fun Pantalla(modifier: Modifier = Modifier) {
    val lenguajes = listOf(
        "Kotlin",
        "Java",
        "Python",
        "SQL",
        "C++",
        "HTML",
        "CSS",
        "PHP")

    val materias = listOf(
        "Programacion movil",
        "Bases de datos",
        "Redes",
        "Sistemas operativos",
        "Estructura de datos",
        "Ingenieria de software",
        "Desarrollo web",
        "Seguridad informatica",
        "Matematicas discretas",
        "Calculo"
    )

    Column(modifier = modifier.padding(16.dp)) {
        Tarjeta()

        Spacer(modifier = Modifier.height(24.dp))

        Text(text = "Lenguajes", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color(0xFF2D2A28))
        Spacer(modifier = Modifier.height(10.dp))
        LazyRow {
            items(lenguajes) { lenguaje ->
                LenguajesAprendidos(lenguaje)
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text(text = "Mis materias", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color(0xFF2D2A28))
        Spacer(modifier = Modifier.height(10.dp))
        LazyColumn {
            items(materias) { materia ->
                Materia(materia)
            }
        }
    }
}

@Composable
fun Tarjeta() {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF2D2A28), contentColor = Color(0xFFFAF7F2))
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(R.drawable.cr7),
                    contentDescription = "FotoPerfil",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(90.dp)
                        .clip(CircleShape)
                        .background(Color(0xFFB8AEA4))
                )
                Spacer(modifier = Modifier.width(16.dp))
                Column {
                    Text(text = "Francisco Garcia", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                    Text(text = "Lic. Tecnologias de la Informacion", color = Color(0xFFB8AEA4))
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                OutlinedButton(
                    onClick = { },
                    border = BorderStroke(1.dp, Color(0xFFB8AEA4))
                ) {
                    Text(text = "Mensaje", color = Color(0xFFFAF7F2))
                }
                Spacer(modifier = Modifier.width(8.dp))
                Button(
                    onClick = { },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFB8AEA4),
                        contentColor = Color(0xFF2D2A28)
                    )
                ) {
                    Text(text = "Seguir")
                }
            }
        }
    }
}

@Composable
fun LenguajesAprendidos(texto: String) {
    Box(
        modifier = Modifier
            .padding(end = 8.dp)
            .size(75.dp)
            .background(Color(0xFF2D2A28), RoundedCornerShape(12.dp)),
        contentAlignment = Alignment.Center
    ) {
        Text(text = texto, color = Color(0xFFFAF7F2))
    }
}

@Composable
fun Materia(nombre: String) {
    Text(
        text = nombre,
        fontSize = 16.sp,
        color = Color(0xFF2D2A28),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp)
            .background(Color(0xFFB8AEA4), RoundedCornerShape(12.dp))
            .padding(16.dp)
    )
}

@Preview(showBackground = true, backgroundColor = 0xFFFAF7F2, heightDp = 800)
@Composable
fun PantallaPreview() {
    Pantalla()
}
