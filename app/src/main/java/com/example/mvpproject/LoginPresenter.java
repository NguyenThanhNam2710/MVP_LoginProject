package com.example.mvpproject;

import com.example.mvpproject.inteface.LoginView;

public class LoginPresenter {
    private LoginView loginView;

    public LoginPresenter(LoginView loginView) {
        this.loginView = loginView;
    }

    public void login(String username, String password) {
        if (username.isEmpty()) {
            loginView.setErrorUsername();
        } else if (password.isEmpty()) {
            loginView.setErrorPassword();
        } else if (username.equals("admin") && password.equals("admin")) {
            loginView.loginSuccessful();
            Thread thread = new Thread() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        loginView.navigateHome();
                    }
                }
            };
            thread.start();
        } else {
            loginView.loginFail();
        }

    }
}
