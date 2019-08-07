package br.com.fia.imc

fun Double.toFixed(digits: Int) = String.format("%.${digits}f", this)