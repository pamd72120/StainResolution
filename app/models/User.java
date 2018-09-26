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


        public void setUserName(String titleName)
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
    }



