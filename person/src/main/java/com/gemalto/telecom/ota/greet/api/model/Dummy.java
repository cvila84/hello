package com.gemalto.telecom.ota.greet.api.model;

import java.util.Map;
import java.util.Objects;

import javax.ws.rs.Path;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.gemalto.telecom.ota.greet.api.constraints.Id;
import com.gemalto.telecom.ota.greet.api.constraints.State;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Dummy {

    @ApiModelProperty(name = "id", value = "The unique identifier of the resource", required = true)
    @JsonProperty("id")
    @Id
    private String id;

    @ApiModelProperty(name = "name", value = "The name of the resource", required = true)
    @JsonProperty("name")
    private String name;

    @ApiModelProperty(name = "state", value = "The state of the resource")
    @JsonProperty("state")
    @State
    private String state;

    @ApiModelProperty(name = "properties", value = "The properties of the resource")
    @JsonProperty("properties")
    private Map<String, String> properties;

    @ApiModelProperty(name = "creation_date", value = "The creation date of the resource")
    @JsonProperty("creation_date")
    private Long creationDate;

    @ApiModelProperty(name = "update_date", value = "The last update date of the resource")
    @JsonProperty("update_date")
    private Long updateDate;

    public Dummy() {
    }

    public Dummy(final String id, final String name, final String state, final Map<String, String> properties) {
        this.id = id;
        this.name = name;
        this.state = state;
        this.properties = properties;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Path("/state")
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Long getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Long creationDate) {
        this.creationDate = creationDate;
    }

    public Long getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Long updateDate) {
        this.updateDate = updateDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, String> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, String> properties) {
        this.properties = properties;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Dummy dummy = (Dummy) o;
        return id.equals(dummy.id) &&
                name.equals(dummy.name) &&
                Objects.equals(state, dummy.state) &&
                Objects.equals(properties, dummy.properties) &&
                Objects.equals(creationDate, dummy.creationDate) &&
                Objects.equals(updateDate, dummy.updateDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, state, properties, creationDate, updateDate);
    }

    @Override
    public String toString() {
        return "Dummy{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", state='" + state + '\'' +
                ", properties=" + properties +
                ", creationDate=" + creationDate +
                ", updateDate=" + updateDate +
                '}';
    }
}
