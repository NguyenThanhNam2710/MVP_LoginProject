package com.example.mvpproject.inteface;

public interface LoginView {

    void loginFail();
    void loginSuccessful();
    void navigateHome();

    void setErrorUsername();
    void setErrorPassword();

}
