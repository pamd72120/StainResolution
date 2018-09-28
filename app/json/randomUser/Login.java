package json.randomUser;

import com.fasterxml.jackson.annotation.*;

import java.util.Map;


@JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonPropertyOrder({

            "username", "password"


    })

    public class Login
    {
        @JsonProperty("username")
        private String username;
        @JsonProperty("password")
        private String password;

        @JsonProperty("username")
        public String getUsername() {
            return username;
        }

        @JsonProperty("username")
        public void setUsername(String username) {
            this.username = username;
        }

        @JsonProperty("password")
        public String getPassword() {
            return password;
        }

        @JsonProperty("password")
        public void setPassword(String password) {
            this.password = password;
        }


    }