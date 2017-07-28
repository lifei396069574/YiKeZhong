package com.mvp.model.bean;

/**
 * 作者：李飞 on 2017/7/24 17:29
 * 类的用途：
 */

public class LoginBean {

    /**
     * error_code : 200
     * user : {"userHead":"emmm","userId":6,"userName":"唐清如","userPassword":"111","userPhone":"13011196165","userSex":"女"}
     */

    private String error_code;
    private UserBean user;

    public String getError_code() {
        return error_code;
    }

    public void setError_code(String error_code) {
        this.error_code = error_code;
    }

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }

    public static class UserBean {
        /**
         * userHead : emmm
         * userId : 6
         * userName : 唐清如
         * userPassword : 111
         * userPhone : 13011196165
         * userSex : 女
         */

        private String userHead;
        private int userId;
        private String userName;
        private String userPassword;
        private String userPhone;
        private String userSex;

        public String getUserHead() {
            return userHead;
        }

        public void setUserHead(String userHead) {
            this.userHead = userHead;
        }

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
