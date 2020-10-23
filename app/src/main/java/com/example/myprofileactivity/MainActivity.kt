package com.example.myprofileactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnSave.setOnClickListener { validasiInput() }
    }

    private fun validasiInput() {

        val namaInput = edtName.text.toString()
        val emailInput = edtEmail.text.toString()
        val telpInput = edtTelp.text.toString()
        val alamatInput = edtAddress.text.toString()
        val genderInput = spinnerGender.selectedItem.toString()
        when{
            namaInput.isEmpty() -> edtName.error = "Nama tidak bolehkosong"
            genderInput == "pilih kelamin" -> Toast.makeText(this, "Kelamin harus dipilih", Toast.LENGTH_SHORT).show()
            emailInput.isEmpty() -> edtEmail.error = "Email tidak bolehkosong"
            telpInput.isEmpty() -> edtTelp.error = "Telp tidak bolehkosong"
            alamatInput.isEmpty() -> edtAddress.error = "Alamat tidak boleh kosong"
            else -> {

                navigasiKeProfilDiri()
                Toast.makeText(
                        this,
                        "navigasi ke halaman profil diri",Toast.LENGTH_SHORT
                ).show()


            }

        }

    }



    private fun setDataSpinnerGender() {
        val adapter = ArrayAdapter.createFromResource(this,
                R.array.gender_list, android.R.layout.simple_spinner_item)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerGender.adapter = adapter
    }
    private fun navigasiKeProfilDiri() {

        val intent = Intent(this, MainActivity::class.java)
        val bundle = Bundle()
        val namaInput = edtName.text.toString()
        bundle.putString("nama", namaInput)
        val genderInput = spinnerGender.selectedItem.toString()
        bundle.putString("gender", genderInput)
        val emailInput = edtEmail.text.toString()
        bundle.putString("email", emailInput)
        val telpInput = edtTelp.text.toString()
        bundle.putString("telp", telpInput)
        val alamatInput = edtAddress.text.toString()
        bundle.putString("alamat", alamatInput)
        intent.putExtras(bundle)
        startActivity(intent)
    }}