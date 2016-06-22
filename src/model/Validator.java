/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

public class Validator {

    public String EMAIL_REGEX = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    public boolean validateEmail(String email) {
        return email.matches(EMAIL_REGEX);
    }

    public String PHONE_REGEX = "\\d{4}\\d{7}";

    public boolean validatePhoneNumber(String PhoneNumber) {
        return PhoneNumber.matches(PHONE_REGEX);
    }

    public boolean checkDate(String str) {
        if (str.matches("\\d{4}-\\d{2}-\\d{2}")) {
            return true;
        } else {
            return false;
        }
    }
    
//    public boolean checkDuration(String dura){
//        if(dura.equals("1")||dura.equals("2")||dura.equals("3")){
//            return true;
//        }else return false;
//    }
}
