package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


    @Entity
    public class User
    {
        @Id
        @GeneratedValue(strategy= GenerationType.IDENTITY)private int userId;
        private String userName;
        private String passWord;


        public void setUserName(String userName)
        {
            this.userName = userName;
        }

        public int getUserId()
        {
            return userId;
        }

        public String getUserName()
        {
            return userName;
        }

        public String getpassWord()
        {
            return passWord;
        }

        public void setPassWord(String passWord)
        {
            this.passWord=passWord;
        }
    }



