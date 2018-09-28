package json.randomUser;

import akka.event.Logging;
import com.fasterxml.jackson.annotation.*;
import models.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "results",
        "info"
})
public class APIPayload {

    @JsonProperty("results")
    private List<User> results = null;
    @JsonProperty("info")
    private Logging.Info info;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("results")
    public List<User> getResults() {
        return results;
    }

    @JsonProperty("results")
    public void setResults(List<User> results) {
        this.results = results;
    }

    @JsonProperty("info")
    public Logging.Info getInfo() {
        return info;
    }

    @JsonProperty("info")
    public void setInfo(Logging.Info info) {
        this.info = info;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}

