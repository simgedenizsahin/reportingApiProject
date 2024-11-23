package com.denizsahin.demoApiProject.exception;

import lombok.Getter;

@Getter
public enum MessageType {

    TOKEN_EXCEPTION("1004" , "token girmeniz gerekmektedir"),
    VALUE_EXCEPTION("1003" , "belirtilen değeriniz geçersizdir, doğru değer giriniz "),
    GET_TRANSACTION_EXCEPTION("1008" , "get transaction servisi çağrılırken hata alındı"),
    LOGIN_EXCEPTION("1009" , "login servisi çağrılırken hata alındı"),
    CLIENT_IS_OCCURED("1010" , "servisten client bilgileri alınamadı"),
    TRANSACTION_QUERY_EXCEPTION("1011" , "transaction query çağrılırken hata alındı"),
    TRANSACTION_REPORT_EXCEPTION("1012" , "transaction report çağrılırken hata alındı"),
    GENERAL_EXCEPTION("9999" , "genel bir hata oluştu");

    private String code;
    private String message;

    MessageType(String code , String message) {
        this.code =code;
        this.message = message;
    }
}
