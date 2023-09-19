package com.funandearn.mytemplate.utils

import java.util.regex.Pattern

object ValidationUtils {
    
    //Validate  Email ..
    fun isValidEmail(email: CharSequence): Boolean {
        var isValid = true
        val expression = "^[\\w.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$"
        val pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE)
        val matcher = pattern.matcher(email)
        if (!matcher.matches()) {
            isValid = false
        }
        return isValid
    }

    fun isNotEmpty(str: String): Boolean {
        var isValid = false
        if (str.length > 1) {
            isValid = true
        }
        return isValid
    }

    fun isValidName(str: String): Boolean {

        var isValid = false
        if (str.length > 1) {
            isValid = true
        }
        return isValid
    }


    fun isValidOTP(str: String): Boolean {

        var isValid = false
        if (str.length == 6) {
            isValid = true
        }
        return isValid
    }

//Validate Mobile number..

    fun isValidMobileNumber(str: String): Boolean {
        var isValid = false
        if (str.length == 10) {
            isValid = true
        }
        return isValid
    }

    fun isValidPassword(str: String): Boolean {
        var isValid = false
        if (str.length > 6) {
            isValid = true
        }
        return isValid
    }

//Validate upi id

    fun isValidUPi(str: String): Boolean {
        var isValid = true
        val expression = "^\\w.+@\\w+\$"
        val pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE)
        val matcher = pattern.matcher(str)
        if (!matcher.matches()) {
            isValid = false
        }
        return isValid
    }


}


//Validate Bank account number

//validate IFSC CODE

//Validate is EMPty ..



