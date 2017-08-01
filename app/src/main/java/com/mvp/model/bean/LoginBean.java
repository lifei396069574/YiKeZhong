package com.mvp.model.bean;

/**
 * 作者：李飞 on 2017/7/24 17:29
 * 类的用途：
 */

public class LoginBean {


    /**
     * code : 200
     * user : {"userId":93,"userName":"LF","userPassword":"123","userPhone":"18435161715","userSex":"男"}
     */

    private String code;
    private UserBean user;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }

    public static class UserBean {
        /**
         * userId : 93
         * userName : LF
         * userPassword : 123
         * userPhone : 18435161715
         * userSex : 男
         */

        private int userId;
        private String userName;
        private String userPassword;
        private String userPhone;
        private String userSex;

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getUserPassword() {
            return userPassword;
        }

        public void setUserPassword(String userPassword) {
            this.userPassword = userPassword;
        }

        public String getUserPhone() {
            return userPhone;
        }

        public void setUserPhone(String userPhone) {
            this.userPhone = userPhone;
        }

        public String getUserSex() {
            return userSex;
        }

        public void setUserSex(String userSex) {
            this.userSex = userSex;
        }
    }
}
