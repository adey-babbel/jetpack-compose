package com.example.practicecompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester.Companion.createRefs
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.SemanticsProperties.Text
import androidx.compose.ui.text.input.KeyboardType.Companion.Text
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import com.example.practicecompose.ui.theme.PracticeComposeTheme
import org.w3c.dom.Text
import androidx.compose.runtime.*
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation

class ConstraintLayoutPractice : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            //ConstraintBox()
            LoginUI()
        }

    }

    @Composable
    fun ConstraintBox() {
        val greenBoxRef = "green_ref"
        val redBoxRef = "red_ref"

        val constraints = ConstraintSet {
            val greenBox = createRefFor("green_ref")
            val redBox = createRefFor("red_ref")

            constrain(greenBox) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                width = Dimension.value(100.dp)
                height = Dimension.value(100.dp)
            }

            constrain(redBox) {
                top.linkTo(parent.top)
                start.linkTo(greenBox.end)
                width = Dimension.value(100.dp)
                height = Dimension.value(100.dp)
            }
        }

        /*ConstraintLayout(modifier = Modifier.size(200.dp)) {
            val (redBox, blueBox, yellowBox, text) = createRefs()

            Box(modifier = Modifier
                .size(50.dp)
                .background(Color.Red)
                .constrainAs(redBox) {})

            Box(modifier = Modifier
                .size(50.dp)
                .background(Color.Blue)
                .constrainAs(blueBox) {
                    top.linkTo(redBox.bottom)
                    start.linkTo(redBox.end)
                })

            Box(modifier = Modifier
                .size(50.dp)
                .background(Color.Yellow)
                .constrainAs(yellowBox) {
                    bottom.linkTo(blueBox.bottom)
                    start.linkTo(blueBox.end, 20.dp)
                })
        }*/

        ConstraintLayout(constraints, modifier = Modifier.fillMaxSize()) {
            Box(modifier = Modifier
                .background(Color.Green)
                .layoutId(greenBoxRef))
            Box(modifier = Modifier
                .background(Color.Red)
                .layoutId(redBoxRef))
        }

    }



}


@Composable
fun LoginUI() {



    ConstraintLayout(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {

        var emailText by remember {
            mutableStateOf("")
        }

        var passwordText by remember {
            mutableStateOf("")
        }



        val (logo, email, password, button) = createRefs()

        Card(modifier = Modifier
            .wrapContentSize()
            .constrainAs(logo) {
                top.linkTo(parent.top, margin = 20.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            },
        shape = RoundedCornerShape(10.dp),
        elevation = 5.dp) {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = "test",
                contentScale = ContentScale.Crop,
            modifier = Modifier
                .height(100.dp)
                .width(100.dp))
        }

        TextField(value = emailText, onValueChange = {
            emailText = it
        }, label = {
            Text(text = "Enter your email")
        }, modifier = Modifier
            //.height(30.dp)
            .fillMaxWidth()
            .constrainAs(email) {
                top.linkTo(logo.bottom, margin = 24.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            })

        TextField(value = passwordText, onValueChange = {
            passwordText = it
        },
            label = {
                Text(text = "Enter your password")
            },
            placeholder = { Text("Password") },
            visualTransformation = PasswordVisualTransformation(),
            //visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions.Default.copy(
                autoCorrect = true,
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done
            ),
            modifier = Modifier
                //.height(30.dp)
                .fillMaxWidth()
                .constrainAs(password) {
                    top.linkTo(email.bottom, margin = 24.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                })


        Button(modifier = Modifier.constrainAs(button){
            top.linkTo(password.bottom, margin = 32.dp)
            start.linkTo(password.start)
            end.linkTo(password.end)
        },

            onClick = {  }) {
            Text("Login")
        }


    }

}


@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    PracticeComposeTheme {
        LoginUI()
    }
}
